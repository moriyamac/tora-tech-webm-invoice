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

    private int clientNo;

    private int itemCount;

    private int invoiceNo;

}