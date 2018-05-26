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
 * The Class Order.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "ord")
public class OrdEntity implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The order no. */
    @Id
    @Column(name = "order_no")
    private int orderNo;

    /** The client no. */
    @Column(name = "client_no")
    private int clientNo;

    /** The create datetime. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_datetime")
    private Date createDatetime;

    /** The del flg. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "del_flg")
    private Date delFlg;

    /** The item count. */
    @Column(name = "item_count")
    private int itemCount;

    /** The item name. */
    @Column(name = "item_name")
    private String itemName;

    /** The item no. */
    @Column(name = "item_no")
    private int itemNo;

    /** The item price. */
    @Column(name = "item_price")
    private int itemPrice;

    /** The item type. */
    @Column(name = "item_type")
    private String itemType;

    /** The update datetime. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_datetime")
    private Date updateDatetime;
}