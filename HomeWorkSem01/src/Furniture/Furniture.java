package Furniture;

/**
 * Абстрактный класс Мебель
 */
public abstract class Furniture {
    private final int width;
    private final int height;
    private final int depth;
    private final String color;

    public Furniture(int width, int height, int depth, String color) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDepth() {
        return depth;
    }

    public String getColor() {
        return color;
    }
}
