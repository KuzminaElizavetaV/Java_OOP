import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
/**
 * Класс "Человек"
 */
public class Human {
    private final String name;
    private final String surname;
    private final LocalDate dateOfBirth;
    private final Map<Human, RelationType> communications;
    /**
     * Конструктор класса "Человек"
     * @param name имя человека
     * @param surname фамилия человека
     * @param dateOfBirth дата рождения человека
     */
    public Human(String name, String surname, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.communications = new HashMap<>();
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s года рождения", this.name, this.surname, this.dateOfBirth);
    }

    public Map<Human, RelationType> getCommunications() {
        return communications;
    }

    public void getInfo(){
        System.out.println("******ИНФОРМАЦИЯ ОБ ОБЪЕКТЕ******\n" +
                "ИМЯ, ФАМИЛИЯ: " + name + " "+ surname + "\nДАТА РОЖДЕНИЯ: " + dateOfBirth);
    }

    public void getInfoLine(){
        System.out.println(name + " "+ surname + " " + dateOfBirth + " года рождения");

    }
}
