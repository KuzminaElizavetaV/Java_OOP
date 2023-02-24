/**
 * Абстрактный класс животное с абстрактными методами говорить, спать, есть, бегать
 */
package Animals;

import ObjectWriteRead.FileHandler;
import ObjectWriteRead.Readable;
import ObjectWriteRead.Writable;
import java.io.File;
import java.io.Serializable;

public abstract class Animal implements Serializable {
    private Writable writable;
    private Readable readable;
    public abstract void speak();
    public abstract void sleep();
    public abstract void eat();
    public abstract void run();

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
            readable.read(new File("HomeWorkSem01/src/ObjectWriteRead/Animal.bin"));
        }
    }
}
