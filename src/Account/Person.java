package Account;

public record Person(String fullName, int age) {

    @Override
    public String toString() {
        return "Account.Person{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                '}';
    }
}
