package Account;

import Money.Money;
import Money.Currency;

import java.math.BigDecimal;

public class BankAccount {
    private final Person person;
    private final Money balance;

    private final boolean allowNegativeBalance;

    public BankAccount(Person person, Money balance, boolean allowNegativeBalance) {
        this.person = person;
        this.balance = balance;
        this.allowNegativeBalance = allowNegativeBalance;
    }

    public void deposit(BigDecimal amount) throws IllegalArgumentException {
        if (amount.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Amount must be a positive number.");
        balance.setAmount(balance.getAmount().add(amount));
    }

    public void withdraw(BigDecimal amount) throws IllegalArgumentException {
        if (amount.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Amount must be a positive number.");
        if (!allowNegativeBalance) {
            if (balance.getAmount().add(amount.negate()).compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Cannot withdraw more than you have.");
        }
        balance.setAmount(balance.getAmount().add(amount.negate()));
    }

    public Person getPerson() {
        return person;
    }

    public Money getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account.BankAccount{" +
                "person=" + person +
                ", balance=" + balance +
                '}';
    }
}
