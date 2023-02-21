package Animals;

import java.time.LocalDate;

public class Cat extends Animal {
    private final String name;
    private final String breed;
    private final LocalDate birthDate;
    private final String ownerName;

    public Cat(String name, String breed, LocalDate birthDate, String ownerName) {
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
        System.out.println("Мыррр, мяу!!!");
    }

    @Override
    public void run() {
        System.out.println(name + " бежит, подняв хвост.");
    }

    @Override
    public void sleep() {
        System.out.println(name + " спит, свернувшись в клубок.");
    }

    @Override
    public void eat() {
        System.out.println(name + " кушает сухой корм Purina.");
    }
}
