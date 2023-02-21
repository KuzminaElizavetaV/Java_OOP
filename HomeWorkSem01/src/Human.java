import Furniture.Condition;
import Furniture.Wardrobe;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Класс "Человек"
 */
public class Human {
    private final String name;
    private final String surname;
    private final LocalDate dateOfBirth;
    private final Map<Human, RelationType> communications;
    private int numberThings;
    public static Random randomNumberThings;
    static {
        randomNumberThings = new Random();
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
            System.out.println(name + " очистил(а) " + wardrobe.getId() +
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
            System.out.println(human.getName() + " очистил(а) " + wardrobe.getId() +
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
                    (wardrobe.getMaxOccupancy()- wardrobe.getOccupancy()) +"\nИли выберите другой шкаф");
            closeWardrobe(wardrobe);
        }
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
                    (wardrobe.getMaxOccupancy()- wardrobe.getOccupancy()) +"\nИли выберите другой шкаф");
            if (wardrobe.getCondition() == Condition.OPENED){
                System.out.println(human.getName() + " закрыл(а) " + wardrobe.getId());
                wardrobe.setCondition(Condition.CLOSED);
            }
        }
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
            System.out.println(name + " взял из " + wardrobe.getId() + " " + quantity + " вещей" +
                    "\nВ руках у " + this.name + " стало " + this.numberThings + " вещи(ей)");
            closeWardrobe(wardrobe);
        } else {
            System.out.println("Нет столько вещей в " + wardrobe.getId() + ", доступно "+ wardrobe.getOccupancy());
        }
    }
    /**
     * Взять вещь из шкафа человеку, которому сказал другой человек
     * @param human человек, которому надо взять вещи из шкафа
     * @param quantity количество вещей
     * @param wardrobe шкаф, из которого надо взять
     */
    public void sayHumanTakeThing(Human human, int quantity, Wardrobe wardrobe){
        System.out.println(name + " говорит: \"" + human.getName() + ", надо взять в " + wardrobe.getId()+
                " " + quantity +" вещи(ей)\"");
        if ((wardrobe.getOccupancy() - quantity) > 0){
            if (wardrobe.getCondition() == Condition.CLOSED){
                System.out.println(human.getName() + " открыл(а) " + wardrobe.getId());
                wardrobe.setCondition(Condition.OPENED);
            }
            int temp = human.getNumberThings();
            human.setNumberThings(temp + quantity);
            wardrobe.setOccupancy(wardrobe.getOccupancy() - quantity);
            System.out.println(human.getName() + " взял(a) из " + wardrobe.getId() + " " + quantity + " вещей" +
                    "\nВ руках у " + human.getName() + " стало " + human.getNumberThings() + " вещи(ей)");
            if (wardrobe.getCondition() == Condition.OPENED){
                System.out.println(human.getName() + " закрыл(а) " + wardrobe.getId());
                wardrobe.setCondition(Condition.CLOSED);
            }
        } else {
            System.out.println("Нет столько вещей в " + wardrobe.getId() + ", доступно "+ wardrobe.getOccupancy());
        }
    }
}
