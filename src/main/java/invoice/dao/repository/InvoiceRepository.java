package invoice.dao.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import invoice.dao.model.InvoiceEntity;

@Repository
public class InvoiceRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public InvoiceEntity save(InvoiceEntity invoice) {

        System.out.print(invoice);
        return new InvoiceEntity();
    }

}