package invoice.dao.repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import invoice.dao.model.InvoiceEntity;

@Repository
public class InvoiceRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<InvoiceEntity> findAll() {

        return jdbcTemplate.query(
                "SELECT * FROM invoice",
                new BeanPropertyRowMapper<InvoiceEntity>(InvoiceEntity.class));
    }

    public InvoiceEntity findOne(String invoiceNo) {

        SqlParameterSource param = new MapSqlParameterSource().addValue("invoiceNo", invoiceNo);

        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM invoice WHERE invoice_no = :invoiceNo",
                    param,
                    new BeanPropertyRowMapper<InvoiceEntity>(InvoiceEntity.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<InvoiceEntity> findByInvoiceNo(String invoiceNo) {

        SqlParameterSource param = new MapSqlParameterSource().addValue("invoiceNo", "%" + invoiceNo + "%");

        return jdbcTemplate.query(
                "SELECT * FROM invoice WHERE invoice_no LIKE :invoiceNo ORDER BY id",
                param,
                new BeanPropertyRowMapper<InvoiceEntity>(InvoiceEntity.class));
    }

    public InvoiceEntity save(InvoiceEntity invoice) {

        System.out.println(invoice);

        return new InvoiceEntity();
    }

    public void deleteAll() {

        jdbcTemplate.update("DELETE FROM customers", new HashMap<>());
    }
}