import java.time.LocalDate;

public class Woman extends Human {
    public Woman(String name, String surname, LocalDate dateOfBirth) {
        super(name, surname, dateOfBirth);
    }

    @Override
    public String toString() {
        String GENDER = "женского пола";
        return super.toString() + ", " + GENDER + ", количество вещей в руках: " + getNumberThings();
    }
}
