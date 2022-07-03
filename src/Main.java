import Account.BankAccount;
import Account.Person;
import Money.Currency;
import Money.Money;
import UI.Option;
import UI.UserInterface;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface(new Scanner(System.in));

        String fullName = userInterface.getString("Please enter your fullname: ");
        int age = userInterface.getPositiveInt("Please enter your age: ");
        BigDecimal initialBalance = userInterface.getPositiveBigDecimal("Please enter your initial account balance: ");
        Currency currency = userInterface.chooseFromEnum(Currency.values());
        boolean allowNegativeBalance = userInterface.getBoolean("Should your account be able to go in to the negative?");

        BankAccount bankAccount = new BankAccount(new Person(fullName, age), new Money(initialBalance, currency ), allowNegativeBalance);

        while (true) {
            Option chosenOption = userInterface.chooseFromEnum(Option.values());

            switch (chosenOption) {
                case QUIT -> userInterface.quit();
                case DEPOSIT -> {
                    BigDecimal amountToDeposit = userInterface.getPositiveBigDecimal("Enter how much you would like to deposit: ");
                    bankAccount.deposit(amountToDeposit);
                }
                case WITHDRAW -> {
                    BigDecimal amountToWithdraw = userInterface.getPositiveBigDecimal("Enter how much you would like to withdraw: ");
                    try {
                        bankAccount.withdraw(amountToWithdraw);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case CHECK_ACCOUNT -> userInterface.printAccount(bankAccount.getPerson());
                case CHECK_BALANCE -> userInterface.printBankAccountBalance(bankAccount);
            }
        }
    }
}
