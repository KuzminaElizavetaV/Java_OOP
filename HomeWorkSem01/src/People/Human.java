package People;

import FamilyTree.FamilyRelationNew;
import FamilyTree.RelationType;
import ObjectWriteRead.FileHandler;
import ObjectWriteRead.Readable;
import ObjectWriteRead.Writable;
import Furniture.Condition;
import Furniture.Wardrobe;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

/**
 * Класс "Человек"
 */
public class Human implements Serializable, FamilyRelationNew {
    private Writable writable;
    private Readable readable;
    private final String name;
    private final String surname;
    private final LocalDate dateOfBirth;
    private final Map<Human, RelationType> communications;
    private int numberThings;
    public static Random randomNumberThings;
    static List<Human> humanList; // Добавила поле список всех объектов класса Human, в который автоматически добавляется
    static {                      // каждый новый объект этого класса
        randomNumberThings = new Random();
        humanList = new ArrayList<>();
    }
    /**
     * Конструктор класса "Человек"
     *
     * @param name        имя человека
     * @param surname     фамилия человека
     * @param dateOfBirth дата рождения человека
     */
    public Human(String name, String surname, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.communications = new HashMap<>();
        this.numberThings = Human.randomNumberThings.nextInt(0, 10);//задаю рандомное количество вещей
        humanList.add(this);
    }

    public static List<Human> getHumanList() {
        return humanList;
    }

    public void setWritable(Writable writable) {
        this.writable = writable;
    }
    public void save(){
        if (writable instanceof FileHandler){
          writable.save(this);
        }
    }

    public void setReadable(Readable readable) {
        this.readable = readable;
    }

    public void read(){
        if (readable instanceof FileHandler){
            readable.read(new File("HomeWorkSem01/src/ObjectWriteRead/People.bin"));
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s года рождения", this.name, this.surname, this.dateOfBirth);
    }

    public Map<Human, RelationType> getCommunications() {
        return communications;
    }

    public void addCommunication(Human human, RelationType type){
        this.communications.put(human, type);
    }

    public void getInfo() {
        System.out.println("******ИНФОРМАЦИЯ ОБ ОБЪЕКТЕ******\n" +
                "ИМЯ, ФАМИЛИЯ: " + name + " " + surname + "\nДАТА РОЖДЕНИЯ: " + dateOfBirth);
    }

    public void getInfoLine() {
        System.out.println(name + " " + surname + " " + dateOfBirth + " года рождения");

    }

    public int getNumberThings() {
        return numberThings;
    }

    public void setNumberThings(int numberThings) {
        this.numberThings = numberThings;
    }

    @Override
    public void addParent(Human human) {
        if (this instanceof Man){
            human.addCommunication(this, RelationType.SON);
        } else if (this instanceof Woman){
            human.addCommunication(this, RelationType.DAUGHTER);
        }
        if (human instanceof Man) {
            this.addCommunication(human, RelationType.FATHER);
        }
        else if (human instanceof Woman) {
            this.addCommunication(human, RelationType.MOTHER);
        }
    }

    //методы взять/положить/передвинуть/очистить - а в классе шкафа меняется Статус и наполненность
    //у человека изменяется кол-во вещей
     /**
     * Открыть шкаф человеку, у которого вызывается этот метод
     * @param wardrobe шкаф, который надор открыть
     */
    public void openWardrobe(Wardrobe wardrobe){
        if (wardrobe.getCondition() == Condition.CLOSED){
            System.out.println(name + " открыл(а) " + wardrobe.getId());
            wardrobe.setCondition(Condition.OPENED);
            System.out.println("Состояние "+ wardrobe.getId() + " изменилось на \"" +
                    wardrobe.getCondition().getTranslation() + "\"");
        }
    }
    /**
     * Открыть шкафа человеку, которому сказал другой человек
     * @param human человек, которому говорят открыть шкаф
     * @param wardrobe объект класса Шкаф (Wardrobe), который надо открыть
     */
    public void sayHumanOpenWardrobe(Human human, Wardrobe wardrobe){
        System.out.println(name + " говорит: \"" + human.getName() + ", открой " + wardrobe.getId()+ "\"");
        if (wardrobe.getCondition() == Condition.CLOSED){
            System.out.println(human.getName() + " открыл(а) " + wardrobe.getId());
            wardrobe.setCondition(Condition.OPENED);
            System.out.println("Состояние "+ wardrobe.getId() + " изменилось на \"" +
                    wardrobe.getCondition().getTranslation() + "\"");
        }
    }
    /**
     * Закрыть шкаф человеку, у которого вызывается этот метод
     * @param wardrobe шкаф, который надор закрыть
     */
    public void closeWardrobe(Wardrobe wardrobe){
        if (wardrobe.getCondition() == Condition.OPENED){
            System.out.println(name + " закрыл(а) " + wardrobe.getId());
            wardrobe.setCondition(Condition.CLOSED);
            System.out.println("Состояние "+ wardrobe.getId() + " изменилось на \"" +
                    wardrobe.getCondition().getTranslation() + "\"");
        }
    }
    /**
     * Закрыть шкаф человеку, кому сказал другой человек
     * @param human человек, которому говорят закрыть шкаф
     * @param wardrobe объект класса Шкаф (Wardrobe), который надо закрыть
     */
    public void sayHumanCloseWardrobe(Human human, Wardrobe wardrobe){
        System.out.println(name + " говорит: \"" + human.getName() + ", закрой " + wardrobe.getId()+ "\"");
        if (wardrobe.getCondition() == Condition.OPENED){
            System.out.println(human.getName() + " закрыл(а) " + wardrobe.getId());
            wardrobe.setCondition(Condition.CLOSED);
            System.out.println("Состояние "+ wardrobe.getId() + " изменилось на \"" +
                    wardrobe.getCondition().getTranslation() + "\"");
        }
    }
    /**
     * Перемещение объекта класса Шкаф (Wardrobe) в другое место человеком, у которого вызывается этот метод
     * @param wardrobe объект класса Шкаф (Wardrobe), который надо переставить
     * @param newLocation место, куда необходимо переставить
     */
    public void changeLocation(Wardrobe wardrobe, String newLocation){
        wardrobe.setLocation(newLocation);
        System.out.println(name + " передвинул(а) " + wardrobe.getId() + " в " + newLocation);
    }
    /**
     * Перемещение шкафа человеком, которому сказал другой человек
     * @param human человек, которому говорят передвинуть шкаф в новое место
     * @param wardrobe шкаф, который надо передвинуть
     * @param newLocation место, куда надо передвинуть
     */
    public void sayHumanChangeLocationWardrobe(Human human, Wardrobe wardrobe, String newLocation){
        System.out.println(name + " говорит: \"" + human.getName() + ", переставь " + wardrobe.getId()+
                " в " + newLocation + "\"");
        wardrobe.setLocation(newLocation);
        System.out.println(human.getName() + " передвинул(а) " + wardrobe.getId() + " в " + newLocation);
    }
    /**
     * Очистка объекта класса Шкаф (Wardrobe) от вещей человеком, у которого вызывается этот метод
     * @param wardrobe объект класса Шкаф (Wardrobe), который надо освободть от всех вещей
     */
    public void clearWardrobe(Wardrobe wardrobe){
        if (wardrobe.getOccupancy()>0){
            openWardrobe(wardrobe);
            int allThings = wardrobe.getOccupancy();
            wardrobe.setOccupancy(0);
            this.numberThings += allThings;
            System.out.println(this.name + " выложил(а) все вещи из " + wardrobe.getId() +
                    "\nВ руках у " + this.name + " стало " + this.numberThings + " вещи(ей)");
            closeWardrobe(wardrobe);
        }
    }
    public void sayHumanClearWardrobe(Human human, Wardrobe wardrobe){
        System.out.println(name + " говорит: \"" + human.getName() + ", надо очистить " + wardrobe.getId()+
                " от всех  вещей\"");
        if (wardrobe.getOccupancy()>0){
            if (wardrobe.getCondition() == Condition.CLOSED) {
                System.out.println(human.getName() + " открыл(а) " + wardrobe.getId());
                wardrobe.setCondition(Condition.OPENED);
            }
            int allThings = wardrobe.getOccupancy();
            wardrobe.setOccupancy(0);
            int temp = human.getNumberThings();
            human.setNumberThings(temp + allThings);
            System.out.println(human.getName() + " выложил(а) все вещи из " + wardrobe.getId() +
                    "\nВ руках у " + human.getName() + " стало " + human.getNumberThings() + " вещи(ей)");
                if (wardrobe.getCondition() == Condition.OPENED){
                    System.out.println(human.getName() + " закрыл(а) " + wardrobe.getId());
                    wardrobe.setCondition(Condition.CLOSED);
                }
        }
    }
    /**
     * Положить некоторое количество вещей в шкаф человеку, у которого вызывается метод
     * @param quantity количество вещей
     * @param wardrobe шкаф, в которой надо положить эти вещи
     */
    public void putThing(int quantity, Wardrobe wardrobe){
        if (this.numberThings >=quantity && quantity>0){
            openWardrobe(wardrobe);
            if ((wardrobe.getOccupancy()+quantity) <= wardrobe.getMaxOccupancy()){
                wardrobe.setOccupancy(wardrobe.getOccupancy()+quantity);
                this.numberThings -= quantity;
                System.out.println(name + " положил(а) в " + wardrobe.getId() + " " + quantity + " вещи(ей)" +
                        "\nВ руках у " + this.name + " осталось " + this.numberThings + " вещи(ей)");
            }
            else System.out.println(wardrobe.getId() + " переполнен. Можно положить " +
                    (wardrobe.getMaxOccupancy()- wardrobe.getOccupancy()) +" или выберите другой шкаф");
            closeWardrobe(wardrobe);
        }
        else System.out.println(this.name + " не может положить в " + wardrobe.getId() + " " + quantity +
                " вещи(ей), так как на руках всего лишь " + this.numberThings + " вещи(ей)");

    }
    /**
     * Положить некоторое количество вещей в шкаф человеку, кому это сказали
     * @param human человек, который должен положить вещи
     * @param quantity количество вещей
     * @param wardrobe шкаф, куда надо подожить вещи
     */
    public void sayHumanPutThingWardrobe(Human human, int quantity, Wardrobe wardrobe){
        System.out.println(name + " говорит: \"" + human.getName() + ", надо положить в " + wardrobe.getId()+
                " " + quantity +" вещи(ей)\"");
        if (human.getNumberThings() >=quantity && quantity>0){
            if (wardrobe.getCondition() == Condition.CLOSED){
                System.out.println(human.getName() + " открыл(а) " + wardrobe.getId());
                wardrobe.setCondition(Condition.OPENED);
            }
            if ((wardrobe.getOccupancy()+quantity) <= wardrobe.getMaxOccupancy()){
                wardrobe.setOccupancy(wardrobe.getOccupancy()+quantity);
                int temp = human.getNumberThings();
                human.setNumberThings(temp - quantity);
                System.out.println(human.getName() + " положил(а) в " + wardrobe.getId() + " " + quantity + " вещи(ей)" +
                        "\nВ руках у " + human.getName() + " осталось " + human.getNumberThings() + " вещи(ей)");
            }
            else System.out.println(wardrobe.getId() + " переполнен. Можно положить "+
                    (wardrobe.getMaxOccupancy()- wardrobe.getOccupancy()) +" или выберите другой шкаф");
            if (wardrobe.getCondition() == Condition.OPENED){
                System.out.println(human.getName() + " закрыл(а) " + wardrobe.getId());
                wardrobe.setCondition(Condition.CLOSED);
            }
        }
        else System.out.println(human.getName() + " не может положить в " + wardrobe.getId() + " " + quantity +
                " вещи(ей), так как на руках всего лишь " + human.getNumberThings() + " вещи(ей)");
    }
    /**
     * Взять вещь из шкафа человеку, у которого вызывается этот метод
     * @param quantity количество вещей
     * @param wardrobe шкаф, из которого надо взять
     */
    public void takeThing(int quantity, Wardrobe wardrobe){
        if ((wardrobe.getOccupancy() - quantity) > 0){
            openWardrobe(wardrobe);
            this.numberThings+=quantity;
            wardrobe.setOccupancy(wardrobe.getOccupancy() - quantity);
            System.out.println(name + " взял(а) из " + wardrobe.getId() + " " + quantity + " вещи(ей)" +
                    "\nВ руках у " + this.name + " стало " + this.numberThings + " вещи(ей)");
            closeWardrobe(wardrobe);
        } else {
            System.out.println("Нет такого количества вещей в " + wardrobe.getId() + ", доступно " +
                    wardrobe.getOccupancy() + " вещи(ей)");
        }
    }
    /**
     * Взять вещь из шкафа человеку, которому сказал другой человек
     * @param human человек, которому надо взять вещи из шкафа
     * @param quantity количество вещей
     * @param wardrobe шкаф, из которого надо взять
     */
    public void sayHumanTakeThing(Human human, int quantity, Wardrobe wardrobe){
        System.out.println(name + " говорит: \"" + human.getName() + ", надо взять из " + wardrobe.getId()+
                " " + quantity +" вещи(ей)\"");
        if ((wardrobe.getOccupancy() - quantity) > 0){
            if (wardrobe.getCondition() == Condition.CLOSED){
                System.out.println(human.getName() + " открыл(а) " + wardrobe.getId());
                wardrobe.setCondition(Condition.OPENED);
            }
            int temp = human.getNumberThings();
            human.setNumberThings(temp + quantity);
            wardrobe.setOccupancy(wardrobe.getOccupancy() - quantity);
            System.out.println(human.getName() + " взял(a) из " + wardrobe.getId() + " " + quantity + " вещи(ей)" +
                    "\nВ руках у " + human.getName() + " стало " + human.getNumberThings() + " вещи(ей)");
            if (wardrobe.getCondition() == Condition.OPENED){
                System.out.println(human.getName() + " закрыл(а) " + wardrobe.getId());
                wardrobe.setCondition(Condition.CLOSED);
            }
        } else {
            System.out.println("Нет такого количества вещей в " + wardrobe.getId() + ", доступно " +
                    wardrobe.getOccupancy() + " вещи(ей)");
        }
    }
}
