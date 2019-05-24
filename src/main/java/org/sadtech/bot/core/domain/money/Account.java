package org.sadtech.bot.core.domain.money;

import java.util.Objects;

public class Account {

    private Integer id;
    private Double totalSum;
    private Integer belongsPersonId;
    private Integer extinguishedPersonId;
    private String description;
    private AccountStatus accountStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Double totalSum) {
        this.totalSum = totalSum;
    }

    public Integer getBelongsPersonId() {
        return belongsPersonId;
    }

    public void setBelongsPersonId(Integer belongsPersonId) {
        this.belongsPersonId = belongsPersonId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Integer getExtinguishedPersonId() {
        return extinguishedPersonId;
    }

    public void setExtinguishedPersonId(Integer extinguishedPersonId) {
        this.extinguishedPersonId = extinguishedPersonId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) &&
                Objects.equals(totalSum, account.totalSum) &&
                Objects.equals(belongsPersonId, account.belongsPersonId) &&
                Objects.equals(description, account.description) &&
                accountStatus == account.accountStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalSum, belongsPersonId, description, accountStatus);
    }
}
