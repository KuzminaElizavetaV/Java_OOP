package ObjectWriteRead;

import Animals.Animal;
import Furniture.Furniture;
import People.Human;
import java.io.*;

/**
 * Класс FileHandler создан для записи объектов в файл и чтения объектов из файла
 */
public class FileHandler implements Writable, Readable, Serializable{

    private File filename;

    /**
     * Запись объекта в файл
     * @param object объект
     */
    @Override
    public void save(Object object) {
        if (object instanceof Human) {
            this.filename = new File("HomeWorkSem01/src/ObjectWriteRead/People.txt");
        }
        else if (object instanceof Furniture) {
            this.filename = new File("HomeWorkSem01/src/ObjectWriteRead/Furniture.txt");
        } else if (object instanceof Animal) {
            this.filename = new File("HomeWorkSem01/src/ObjectWriteRead/Animal.txt.txt");
        }
        try {
            FileOutputStream fos = new FileOutputStream(this.filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
            oos.close();
            System.out.println("Объект записан в файл: " + this.filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Чтение объекта из файла
     * @param objectName имя файла или полностью путь
     */
    @Override
    public void read(Object objectName) {
        try {
            FileInputStream fis = new FileInputStream(objectName.toString());
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object object = ois.readObject();
            ois.close();
            System.out.println("Объект считан из файла!\n" + object);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
