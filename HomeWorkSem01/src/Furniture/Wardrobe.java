package Furniture;
import java.util.Random;

/**
 * Класс-наследник Шкаф
 */
public class Wardrobe extends Furniture{
    private final String id;
    private Condition condition;
    private String location;
    private int occupancy;
    private final int maxOccupancy;
    public static Random randomThing;
    private static int numberWardrobe;
    static {
        randomThing = new Random();
        numberWardrobe = 0;
    }

    /**
     * Конструктор объекта класса Шкаф
     * @param width ширина шкафа, см
     * @param height высота шкафа, см
     * @param depth глубина шкафа, см
     * @param color цвет шкафа
     * @param location местоположение шкафа
     */
    public Wardrobe(int width, int height, int depth, String color, String location) {
        super(width, height, depth, color);
        this.location = location;
        this.condition = Condition.CLOSED; //при создании нового объекта шкафа по умолчанию он всегда будет закрыт
        this.occupancy = Wardrobe.randomThing.nextInt(0, 25);//0-пустой, 25 - полный
        this.maxOccupancy = Wardrobe.randomThing.nextInt(25,35);
        numberWardrobe++;
        this.id = String.format("шкаф №%d", numberWardrobe);

    }

    public String getId() {
        return id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public int getMaxOccupancy() {
        return maxOccupancy;
    }

    @Override
    public String toString() {
        return  "ПАРАМЕТРЫ: " + getId() +
                "\n - ШхДхГ: " + getWidth() + "х"+getHeight() + "х"+ getDepth() + " см" +
                "\n - цвет: " + getColor() +
                "\n - местоположение \"" + location.toUpperCase() + "\"" +
                "\n - состояние: " + condition.getTranslation() +
                "\n - текущая заполненность: " + occupancy + " вещи(ей)" +
                "\n - максимальная вместимость: " + maxOccupancy + " вещи(ей)";
    }
}
