package br.com.dotnext.financer.models;

import java.io.Serializable;
import java.util.Date;

import br.com.dotnext.financer.enums.OperationTypeEnum;

public class OperationModel implements Serializable {
    private String description;
    private Date creationDate;
    private Date settlementDate;
    private int instalments;
    private double amount;
    private OperationTypeEnum operationType;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    public int getInstalments() {
        return instalments;
    }

    public void setInstalments(int instalments) {
        this.instalments = instalments;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public OperationTypeEnum getOperationType() {
        return operationType;
    }

    public void setType(OperationTypeEnum operationType) {
        this.operationType = operationType;
    }
}
