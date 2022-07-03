package UI;

import Account.BankAccount;
import Account.Person;

import java.math.BigDecimal;
import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public <E extends Enum<E>> E chooseFromEnum(E[] options) {
        int answer;
        do {
            System.out.println("Please enter an option: ");
            for (int i = 1; i < options.length + 1; i++) {
                System.out.println(i + ". " + options[i - 1]);
            }
            answer = getPositiveInt("Choose: ");
        } while(options.length < answer);

        return options[answer - 1];
    }

    public boolean getBoolean(String message) {
        String answer;
        do  {
            System.out.print(message + " y/n ");
            answer = scanner.nextLine();
        } while (!(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n")));
        return answer.equalsIgnoreCase("y");
    }

    public String getString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public int getPositiveInt(String message) {
        int number;
        do {
            System.out.print(message);
            while (!scanner.hasNextInt()) {
                System.out.print("That's not a number!\n" + message);
                scanner.next();
            }
            number = scanner.nextInt();
        } while (number < 0);
        return number;
    }

    public BigDecimal getPositiveBigDecimal(String message) {
        BigDecimal number;
        do {
            System.out.print(message);
            while(!scanner.hasNextBigDecimal()) {
                System.out.print("That's not a valid decimal number!\n" + message);
                scanner.next();
            }
            number = scanner.nextBigDecimal();
        } while (number.compareTo(BigDecimal.ZERO) < 0);
        return number;
    }

    public void quit() {
        System.out.println("Thank you for using my program! Goodbye");
        System.exit(0);
    }

    public void printBankAccountBalance(BankAccount bankAccount) {
        System.out.println("Your current balance is: " + bankAccount.getBalance());
    }

    public void printAccount(Person person) {
        System.out.println("Your full name is: " + person.fullName());
        System.out.println("Your age is: " + person.age());
    }
}