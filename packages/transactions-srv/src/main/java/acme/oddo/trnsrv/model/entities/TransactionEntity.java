package acme.oddo.trnsrv.model.entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Entity(name = "TransactionEntity")
@Table(name = "T_TRANSACTION")
public class TransactionEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTIONID")
    private Integer transactionID;

    @Column(name = "CUSTOMERID")
    private Integer customerID; 

    @NonNull
    @Column(name = "ACCOUNTID")
    private Integer accountID; 

    @Column(name = "CREATE_DATE")
    @CreationTimestamp
    private LocalDateTime createOn;
    
    @Column(name = "IMP_VALUE")
    private BigDecimal impValue;

    @PrePersist
    @PreUpdate
    public void precisionConvertion() {
        this.impValue.setScale(2, RoundingMode.HALF_UP);
    }
    
}
