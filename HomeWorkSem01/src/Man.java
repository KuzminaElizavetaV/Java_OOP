import java.time.LocalDate;


public class Man extends Human {

    public Man(String name, String surname, LocalDate dateOfBirth) {
        super(name, surname, dateOfBirth);
    }

    //можно добавить индивидуально вывод в консоль, типа Отец/мужчина ...переопределить вывод к примеру

    @Override
    public String toString() {
        //данные классы Man и Woman создаю только для проработки наследования, в целом можно обойтись классом person
        String GENDER = "мужского пола";
        return super.toString() + ", " + GENDER;
    }

}

