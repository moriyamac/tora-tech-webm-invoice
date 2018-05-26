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
            + "    c.client_no as client_no, "
            + "    o.item_count, "
            + "    i.invoice_no "
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

    public Optional<InvoiceByInvoiceNo> getInvoiceByInvoiceNo(String invoiceNo) {
        List<InvoiceByInvoiceNo> result = namedParameterJdbcTemplate.query(SELECT_DIRECT_SQL, new MapSqlParameterSource().addValue("invoice_no", invoiceNo),
                (rs, i) -> {
                    InvoiceByInvoiceNo dto = new InvoiceByInvoiceNo();
                    dto.setClientNo(rs.getInt("client_no"));
                    dto.setItemCount(rs.getInt("item_count"));
                    dto.setInvoiceNo(rs.getInt("invoice_no"));
                    return dto;
                });
        return result.isEmpty() ? Optional.empty() : Optional.of(result.get(0));
    }
}