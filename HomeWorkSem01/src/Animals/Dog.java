package Animals;

import java.time.LocalDate;

/**
 * Класс-наследник Собака
 */
public class Dog extends Animal {
    private final String name;
    private final String breed;
    private final LocalDate birthDate;
    private final String ownerName;

    /**
     * Конструктор класса Собака
     * @param name кличка собаки
     * @param breed порода собаки
     * @param birthDate дата рождения собаки
     * @param ownerName имя хозяина собаки
     */
    public Dog(String name, String breed, LocalDate birthDate, String ownerName) {
        this.name = name;
        this.breed = breed;
        this.birthDate = birthDate;
        this.ownerName = ownerName;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    @Override
    public void speak() {
        System.out.println("Гав-Гав!!!");
    }

    @Override
    public void run() {
        System.out.println(name + " бежит, виляя хвостом.");
    }

    @Override
    public void sleep() {
        System.out.println(name + " спит.");
    }

    @Override
    public void eat() {
        System.out.println(name + " кушает Pedigree.");
    }
}
