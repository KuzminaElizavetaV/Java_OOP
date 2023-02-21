import java.time.LocalDate;

public class Man extends Human {

    public Man(String name, String surname, LocalDate dateOfBirth) {
        super(name, surname, dateOfBirth);
    }

    @Override
    public String toString() {
        String GENDER = "мужского пола";
        return super.toString() + ", " + GENDER + ", количество вещей в руках: " + getNumberThings();
    }
}

