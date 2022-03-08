package br.com.devlhse.myaccount.adapter.persistence.transfer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "transactions")
public class TransactionModel {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column( name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn( name = "account_id")
    private AccountModel accountModel;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column( name = "type")
    @Enumerated( value = EnumType.STRING)
    private TransactionTypeModel transactionTypeModel;
}
