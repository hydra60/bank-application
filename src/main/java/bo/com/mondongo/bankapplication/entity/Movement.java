package bo.com.mondongo.bankapplication.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "movement")
@ApiModel(value = "movementDTO", description = "Movement model for the documentation")
public class Movement extends EntityBase implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "currency", nullable = false)
    private String currency;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @Column(name = "movement_type", nullable = false)
    private String movementType;

    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private Double amount;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void setMovementType(String movementType) {
        this.movementType = movementType;
    }

    public String getMovementType() {
        return movementType;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }
}
