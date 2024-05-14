package com.eazybytes.entity.model;

import com.eazybytes.entity.BaseAuditEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "account_transactions")
@Setter
@Getter
public class AccountTransactions extends BaseAuditEntity {

    @Id
    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "account_number")
    private Long accountNumber;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "transaction_dt")
    private Date transactionDt;

    @Column(name = "transaction_summary")
    private String transactionSummary;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "transaction_amt")
    private Integer transactionAmt;

    @Column(name = "closing_balance")
    private Integer closingBalance;
}
