package invoice.dao.repository;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import invoice.dao.InvoiceByInvoiceNo;

@Component
public class DirectSqlRepository {

    @Resource
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String SELECT_DIRECT_SQL = ""
            + "SELECT "
            + "    i.invoice_no, "
            + "    c.client_no, "
            //+ "    c.client_charge_name, "
            + "    c.client_name, "
            + "    c.client_address, "
            + "    c.client_tel, "
            + "    c.client_fax, "
            //+ "    i.invoice_status_code, "
            + "    i.invoice_status, "
            + "    i.invoice_create_date, "
            + "    i.invoice_title, "
            + "    i.invoice_amt, "
            // + "    i.tax_amt, "
            + "    i.invoice_start_date, "
            + "    i.invoice_end_date, "
            + "    i.invoice_note, "
            + "    i.create_user, "
            + "    i.create_datetime, "
            + "    i.update_user, "
            + "    i.update_datetime "
            + "FROM "
            + "    ord as o, "
            + "    client as c, "
            + "    invoice as i "
            + "WHERE "
            + "    c.client_no = i.invoice_no AND "
            + "    o.client_no = c.client_no AND "
            + "    i.invoice_no = :invoice_no "
            + "GROUP BY "
            + "    i.invoice_no";

    /**
     * @param invoiceNo
     * @return InvoiceByInvoiceNo
     */
    public Optional<InvoiceByInvoiceNo> getInvoiceByInvoiceNo(final String invoiceNo) {
        List<InvoiceByInvoiceNo> result = namedParameterJdbcTemplate.query(SELECT_DIRECT_SQL,
                new MapSqlParameterSource().addValue("invoice_no", invoiceNo),
            (rs, i) -> {
                InvoiceByInvoiceNo dto = new InvoiceByInvoiceNo();
                dto.setInvoiceNo(rs.getString("invoice_no"));
                dto.setClientNo(rs.getString("client_no"));
                dto.setClientName(rs.getString("client_name"));
                dto.setClientAddress(rs.getString("client_address"));
                dto.setClientTel(rs.getString("client_tel"));
                dto.setClientFax(rs.getString("client_fax"));
                dto.setInvoiceStatus(rs.getString("invoice_status"));
                dto.setInvoiceCreateDate(rs.getString("invoice_create_date"));
                dto.setInvoiceTitle(rs.getString("invoice_title"));
                dto.setInvoiceAmt(rs.getString("invoice_amt"));
                dto.setInvoiceStartDate(rs.getString("invoice_start_date"));
                dto.setInvoiceEndDate(rs.getString("invoice_end_date"));
                dto.setInvoiceNote(rs.getString("invoice_note"));
                dto.setCreateUser(rs.getString("create_user"));
                dto.setCreateDatetime(rs.getString("create_datetime"));
                dto.setUpdateUser(rs.getString("update_user"));
                dto.setUpdateDatetime(rs.getString("update_datetime"));
                return dto;
            });
        return result.isEmpty() ? Optional.empty() : Optional.of(result.get(0));
    }
}