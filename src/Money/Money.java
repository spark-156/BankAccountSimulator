package Money;

import java.math.BigDecimal;

public class Money {
    BigDecimal amount;
    Currency currency;

    public Money(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return currency.label + amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
