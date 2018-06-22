package invoice.dao.repository;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import invoice.dao.InvoiceStatus;
import invoice.response.InvoiceResult;

@Component
public class DirectSqlRepository {

    @Resource
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    // 行ごとにappendにしてinvoice_noの追加だけで差分にしたほうがよさげ
    private static final String SELECT_DIRECT_SQL_BY_ID = ""
            + "SELECT "
            + "    i.invoice_no, "
            + "    c.client_no, "
            + "    CONCAT(c.client_charge_first_name,c.client_charge_last_name) as client_charge_name, "
            + "    c.client_name, "
            + "    c.client_address, "
            + "    c.client_tel, "
            + "    c.client_fax, "
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
            + "    c.client_no = i.client_no AND "
            + "    o.client_no = c.client_no AND "
            + "    i.invoice_no = :invoice_no "
            + "GROUP BY "
            + "    i.invoice_no";

    private static final String SELECT_DIRECT_SQL_ALL = ""
            + "SELECT "
            + "    i.invoice_no, "
            + "    c.client_no, "
            + "    CONCAT(c.client_charge_first_name,c.client_charge_last_name) as client_charge_name, "
            + "    c.client_name, "
            + "    c.client_address, "
            + "    c.client_tel, "
            + "    c.client_fax, "
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
            + "    c.client_no = i.client_no AND "
            + "    o.client_no = c.client_no "
            + "GROUP BY "
            + "    i.invoice_no";

    /**
     * @param invoiceNo
     * @return InvoiceByInvoiceNo
     */
    public List<InvoiceResult> getInvoiceByInvoiceNo(final String invoiceNo) {
        List<InvoiceResult> result = namedParameterJdbcTemplate.query(SELECT_DIRECT_SQL_BY_ID,
                new MapSqlParameterSource().addValue("invoice_no", invoiceNo),
             // rowMapperは共通化して切り出す
            (rs, i) -> {
                InvoiceResult dto = new InvoiceResult();
                dto.setInvoiceNo(rs.getString("invoice_no"));
                dto.setClientNo(rs.getString("client_no"));
                dto.setClientChargeName(rs.getString("client_charge_name"));
                dto.setClientName(rs.getString("client_name"));
                dto.setClientAddress(rs.getString("client_address"));
                dto.setClientTel(rs.getString("client_tel"));
                dto.setClientFax(rs.getString("client_fax"));
                dto.setInvoiceStatusCode(rs.getString("invoice_status"));
                dto.setInvoiceStatus(InvoiceStatus.ofCode(rs.getString("invoice_status")));
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
        return result;
    }

    /**
     * @param invoiceNo
     * @return InvoiceByInvoiceNo
     */
    public List<InvoiceResult> getInvoiceAll() {
        List<InvoiceResult> result = namedParameterJdbcTemplate.query(SELECT_DIRECT_SQL_ALL,
                new MapSqlParameterSource(),
             // rowMapperは共通化して切り出す
            (rs, i) -> {
                InvoiceResult dto = new InvoiceResult();
                dto.setInvoiceNo(rs.getString("invoice_no"));
                dto.setClientNo(rs.getString("client_no"));
                dto.setClientChargeName(rs.getString("client_charge_name"));
                dto.setClientName(rs.getString("client_name"));
                dto.setClientAddress(rs.getString("client_address"));
                dto.setClientTel(rs.getString("client_tel"));
                dto.setClientFax(rs.getString("client_fax"));
                dto.setInvoiceStatusCode(rs.getString("invoice_status"));
                dto.setInvoiceStatus(InvoiceStatus.ofCode(rs.getString("invoice_status")));
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
        return result;
    }
}