package invoice.dao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class Client.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "client")
public class ClientEntity implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The client no. */
    @Id
    @Column(name = "client_no")
    private int clientNo;

    /** The client address. */
    @Column(name = "client_address")
    private String clientAddress;

    /** The client charge first name. */
    @Column(name = "client_charge_first_name")
    private String clientChargeFirstName;

    /** The client charge last name. */
    @Column(name = "client_charge_last_name")
    private String clientChargeLastName;

    /** The client fax. */
    @Column(name = "client_fax")
    private String clientFax;

    /** The client name. */
    @Column(name = "client_name")
    private String clientName;

    /** The client tel. */
    @Column(name = "client_tel")
    private String clientTel;

    /** The create datetime. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_datetime")
    private Date createDatetime;

    /** The del flg. */
    @Column(name = "del_flg")
    private String delFlg;

    /** The update datetime. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_datetime")
    private Date updateDatetime;
}