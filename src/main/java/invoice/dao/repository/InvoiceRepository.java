package invoice.dao.repository;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import invoice.dao.model.InvoiceEntity;

@Repository
public class InvoiceRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

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

    public InvoiceEntity save(InvoiceEntity invoice) {
        jdbcTemplate.update(INSERT_INVOICE_SQL,
                invoice.getClientNo(), //client_no
                10, //invoice_status
                new Date(), //invoice_create_date
                100, //invoice_amt
                new Date(), //invoice_start_date
                new Date(), //invoice_end_date
                "createUser",
                "updateUser");
        return new InvoiceEntity();
    }

}