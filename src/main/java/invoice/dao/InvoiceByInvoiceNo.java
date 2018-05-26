package invoice.dao;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class InvoicePriceByClient.
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class InvoiceByInvoiceNo implements Serializable {

    private String invoiceNo;

    private String clientNo;

    private String clientChargeName;

    private String clientName;

    private String clientAddress;

    private String clientTel;

    private String clientFax;

    private String invoiceStatus;

    private String invoiceCreateDate;

    private String invoiceTitle;

    private String invoiceAmt;

    private String invoiceStartDate;

    private String invoiceEndDate;

    private String invoiceNote;

    private String createUser;

    private String createDatetime;

    private String updateUser;

    private String updateDatetime;
}