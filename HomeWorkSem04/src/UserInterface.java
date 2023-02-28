import java.util.Scanner;

//класс будет отвечать за взаимодействие с пользователем - Меню
public class UserInterface {
    static public void startApplication() {
        Scanner scanner = new Scanner(System.in);
        TaskPlanner taskPlanner = new TaskPlanner();
        try {
            while (true) {
                System.out.println("""
                        *********************ПЛАНИРОВЩИК ЗАДАЧ*********************
                         ВЫБЕРИТЕ пунк меню из списка ниже
                                                                                 
                         ЗАДАЧА:  1 - создать новую
                                  2 - изменить по ID
                                  3 - удалить по ID
                        ***********************************************************
                         ПЛАННЕР: 4 - просмотреть весь список задач
                                  5 - удалить все
                        ***********************************************************
                         ДАННЫЕ:  6 - сохранить в файл
                                  7 - загрузить из файла
                        ***********************************************************
                         ВЫБОРКА: 8 - задач по дате исполнения (дедлайна)
                                  9 - задач по приоритету (низкий, высокий т.д.)
                                 10 - ВЫХОД ИЗ ПРОГРАММЫ
                        ***********************************************************""");
                switch (scanner.nextInt()) {
                    case 1 -> taskPlanner.createTask();
                    case 2 -> taskPlanner.changeTask();
                    case 3 -> taskPlanner.deleteTask();
                    case 4 -> TaskStorage.printAllTasks();
                    case 5 -> TaskStorage.clearTaskStorage();
                    case 6 -> taskPlanner.saveData();
                    case 7 -> taskPlanner.loadData();
                    case 8 -> taskPlanner.showTasksByDeadline();//compareTo сравнивает даты
                    case 9 -> taskPlanner.showTasksByPriority();
                    case 10 -> {
                        System.out.println("Работа завершена");
                        scanner.close();
                        System.exit(0);
                    }
                    default -> System.out.println("Некорректный ввод");
                }
            }
        }
        catch(Exception ex){
            System.out.println("Выберите пункт меню - введите число");
        }
    }
}

