package ObjectWriteRead;

import java.io.*;
import java.util.Scanner;

/**
 * Класс FileHandler создан для записи объектов в файл и чтения объектов из файла
 */
public class FileHandler implements Writable, Readable, Serializable{

    /**
     * Запись объекта в файл
     * @param object объект
     */
    @Override
    public void save(Object object) {
        Scanner input = new Scanner(System.in);
        System.out.println("ВВЕДИТЕ ИМЯ ФАЙЛА ДЛЯ СОХРАНЕНИЯ ОБЪЕКТА" +
                " (например, HomeWorkSem01/src/ObjectWriteRead/People.txt:\n");
        String pathname = input.nextLine();
        File filename = new File(pathname);
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
            oos.close();
            System.out.println("Объект записан в файл: " + filename);
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
