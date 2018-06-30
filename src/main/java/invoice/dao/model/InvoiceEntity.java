package invoice.dao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
  * The Class Invoice.
*/
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Table(name = "invoice")
public class InvoiceEntity implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The invoice no. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_no")
    private int invoiceNo;

    /** The client no. */
    @Column(name = "client_no")
    private int clientNo;

    /** The del flg. */
    @Column(name = "del_flg")
    private String delFlg;

    /** The invoice amt. */
    @Column(name = "invoice_amt")
    private int invoiceAmt;

    /** The invoice create date. */
    @Temporal(TemporalType.DATE)
    @Column(name = "invoice_create_date")
    private Date invoiceCreateDate;

    /** The invoice end date. */
    @Temporal(TemporalType.DATE)
    @Column(name = "invoice_end_date")
    private Date invoiceEndDate;

    /** The invoice note. */
    @Column(name = "invoice_note")
    private String invoiceNote;

    /** The invoice start date. */
    @Temporal(TemporalType.DATE)
    @Column(name = "invoice_start_date")
    private Date invoiceStartDate;

    /** The invoice status. */
    @Column(name = "invoice_status")
    private String invoiceStatus;

    /** The invoice title. */
    @Column(name = "invoice_title")
    private String invoiceTitle;

    /** The create datetime. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_datetime", insertable = false, updatable = false)
    private Date createDatetime;

    /** The create user. */
    @Column(name = "create_user")
    private String createUser;

    /** The update datetime. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_datetime", insertable = false, updatable = false)
    private Date updateDatetime;

    /** The update user. */
    @Column(name = "update_user")
    private String updateUser;

}