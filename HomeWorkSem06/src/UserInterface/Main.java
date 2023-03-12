package UserInterface;

/**
 * Точка входа в программу
 */
public class Main {
    public static void main(String[] args) {
        //Создаем новый экземпляр приложения, передавая в конструктор тип View. Запускаем приложение.
        new App(new ConsoleView()).start();
    }
}