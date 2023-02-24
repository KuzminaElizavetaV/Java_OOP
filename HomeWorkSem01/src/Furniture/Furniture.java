package Furniture;

import ObjectWriteRead.FileHandler;
import ObjectWriteRead.Readable;
import ObjectWriteRead.Writable;

import java.io.File;
import java.io.Serializable;

/**
 * Абстрактный класс Мебель
 */
public abstract class Furniture implements Serializable {
    private Writable writable;
    private Readable readable;
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
            readable.read(new File("HomeWorkSem01/src/ObjectWriteRead/Furniture.bin"));
        }
    }

}
