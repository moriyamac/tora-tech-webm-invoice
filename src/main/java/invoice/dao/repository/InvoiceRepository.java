package invoice.dao.repository;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import invoice.dao.InvoiceStatus;
import invoice.dao.model.InvoiceEntity;
import invoice.response.InvoiceResult;

@Repository
public class InvoiceRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Resource
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String INSERT_INVOICE_SQL = ""
            + "INSERT INTO "
            + "invoice("
            + " client_no,"
            + " invoice_status,"
            + " invoice_create_date,"
            + " invoice_amt,"
            + " invoice_start_date,"
            + " invoice_end_date,"
            + " create_user,"
            + " update_user"
            + ")"
            + " values(?,?,?,?,?,?,?,?)";

    private static final String GET_NEW_INSERT_NO = "SELECT invoice_no FROM invoice ORDER BY invoice_no desc limit 1;";

    public List<InvoiceResult> save(final InvoiceEntity invoice) {
        jdbcTemplate.update(INSERT_INVOICE_SQL,
                invoice.getClientNo(), //client_no
                InvoiceStatus.PENDING.getStatus(), //invoice_status
                new Date(), //invoice_create_date
                1000, //invoice_amt
                invoice.getInvoiceStartDate(), //invoice_start_date
                invoice.getInvoiceEndDate(), //invoice_end_date
                "createUser",
                "updateUser");
        List<InvoiceResult> result = namedParameterJdbcTemplate.query(GET_NEW_INSERT_NO,
                new MapSqlParameterSource(),
            (rs, i) -> {
                InvoiceResult dto = new InvoiceResult();
                dto.setInvoiceNo(rs.getString("invoice_no"));
                return dto;
            });
        return result;
    }

}