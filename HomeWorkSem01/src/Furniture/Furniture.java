package Furniture;

public abstract class Furniture {
    private int width, height, depth;
    private String color;

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
