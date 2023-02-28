import java.time.LocalDate;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * Класс TaskStorage ("Хранилище" задач)
 */
public class TaskStorage {
    private static TreeSet<Task> taskStorage;

    static {//множество задач сортируется по срочности
        taskStorage = new TreeSet<>(Comparator.comparing(Task::getDeadline));
    }

    public static TreeSet<Task> getTaskStorage() {
        return taskStorage;
    }

    public static void addTask(Task task) {
        taskStorage.add(task);
    }

    public static void clearTaskStorage() {
        taskStorage.clear();
    }

    public static void removeTaskByID(String id) {
        taskStorage.removeIf(task -> task.getID().equals(id));
    }

    public static void printAllTasks() {
        if (taskStorage.size() > 0) {
            TaskPlanner.printTitle();
            for (Task task : taskStorage) {
                System.out.println(task.printFormat());
            }
            System.out.println("--------------------------------------------------------------------------------------" +
                    "-------------------------");
        } else System.out.println("Задачи не обнаружены");
    }

    public static Task searchById(String id) {
        for (Task task : taskStorage) {
            if (task.getID().equals(id)) return task;
        }
        return null;
    }

    public static void searchByDeadline(LocalDate date) {
        TaskPlanner.printTitle();
        for (Task task : taskStorage) {
            if (task.compareTo(date) <= 0)
                System.out.println(task.printFormat());
        }
        System.out.println("--------------------------------------------------------------------------------------" +
                "-------------------------");
    }

    public static void searchByPriority(String priority) {
        TaskPlanner.printTitle();
        for (Task task : taskStorage) {
            if (!task.getPriority().getTranslation().equals(priority))
                System.out.println("Нет таких задач");
            else System.out.println(task.printFormat());
        }
        System.out.println("--------------------------------------------------------------------------------------" +
                        "-------------------------");
    }
}

