package ge.bank.payment.model;

import java.math.BigDecimal;

public class OwnTransfer {
    String accountFrom;
    String accountTo;
    BigDecimal amount;

    public OwnTransfer() {
    }

    public OwnTransfer(String accountFrom, String accountTo) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
    }

    public String getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(String accountFrom) {
        this.accountFrom = accountFrom;
    }

    public String getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(String accountTo) {
        this.accountTo = accountTo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
