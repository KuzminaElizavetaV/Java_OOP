import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Task task = new Task("Сдать домашку 4 по ООП", "Кузьмина Е.В.",
                LocalDateTime.of(2023, 3, 3, 20, 0));
        Task task1 = new Task("Поклеить обои", "Кузьмина Т.Н.",
                LocalDateTime.of(2023, 4, 15, 20, 0));
        Task task2 = new Task("Сдать домашку 5 по ООП", "Кузьмина Е.В.",
                LocalDateTime.of(2023, 5, 15, 20, 0));
        Task task3 = new Task("Подготовить годовой отчет", "Хамидулов В.О.",
                LocalDateTime.of(2023, 3, 15, 20, 0));
        Task task5 = new Task("подготовиться к ОГЭ", "Кузьмин В.В.",
                LocalDateTime.of(2023, 3, 15, 15, 0));


        TaskStorage.addTask(task);
        TaskStorage.addTask(task1);
        TaskStorage.addTask(task2);
        TaskStorage.addTask(task3);
        TaskStorage.addTask(task5);
        //DataExportImport.jsonWriter(); //тестила что получается

        UserInterface.startApplication(); // запуск нтерфейса пользователя
        //выгрузка в csv пока только
    }
}