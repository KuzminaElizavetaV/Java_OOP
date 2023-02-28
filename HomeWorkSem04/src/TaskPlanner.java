import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Класс ПланировщикЗадач
 */
public class TaskPlanner {
    static Scanner sc = new Scanner(System.in);

    private LocalDateTime InputDeadlineDate(){ //вспомог.метод для запроса дедлайна из строки от пользователя
        boolean checkInput = false;
        LocalDateTime deadline = null;
        while (!checkInput) {
            System.out.print("Введите дату дедлайна в формате ГГГГ-ММ-ДД: ");
            LocalDate deadlineDate = null;
            if (sc.hasNextLine()) {
                deadlineDate = LocalDate.parse(sc.nextLine());
                System.out.println(deadlineDate);
            }
            System.out.print("Введите время дедлайна в формате ЧЧ:ММ: ");
            LocalTime deadlineTime = null;
            if (sc.hasNextLine()) {
                deadlineTime = LocalTime.parse(sc.nextLine());
                System.out.println(deadlineTime);
            }
            assert deadlineDate != null;
            assert deadlineTime != null;
            deadline = LocalDateTime.of(deadlineDate, deadlineTime);
            System.out.println(deadline);
            checkInput = true;
        }
        return deadline;
    }
    public void createTask() {//добавление задачи через пользовательский ввод
        LocalDateTime deadline = this.InputDeadlineDate();
        System.out.print("Введите ФИО автора задачи: ");
        String author = null;
        if (sc.hasNextLine()) {
            author = sc.nextLine();

        }
        System.out.print("Введите описание задачи: ");
        String description = null;
        if (sc.hasNextLine()) {
            description = sc.nextLine();
        }
        TaskStorage.addTask(new Task(description, author, deadline));
    }

    public void showTasksByDeadline(){
        System.out.print("Введите дату дедлайна, по которую нужно показать задач в формате ГГГГ-ММ-ДД: ");
        if (sc.hasNextLine()) {
            LocalDate deadlineDate = LocalDate.parse(sc.nextLine());
            System.out.println(deadlineDate);
            TaskStorage.searchByDeadline(deadlineDate);
        }

    }
    public void showTasksByPriority(){
        Map<Integer, String> priorityMap = new HashMap<>();
        priorityMap.put(1, Priority.NOW.getTranslation());
        priorityMap.put(2, Priority.URGENT.getTranslation());
        priorityMap.put(3, Priority.MEDIUM.getTranslation());
        priorityMap.put(4, Priority.LOW.getTranslation());
        System.out.println("Какой приоритет задач вас интересует?");
        for (Map.Entry<Integer, String> el : priorityMap.entrySet()) {
            System.out.printf("%-3d=> %s\n", el.getKey(), el.getValue());
        }

        System.out.print("Введите цифру: ");
        int choice = sc.nextInt();
        if(priorityMap.containsKey(choice)){
            String priority = priorityMap.get(choice);
            TaskStorage.searchByPriority(priority);
        }else System.out.println("Ошибка ввода - попробуйте снова");
    }

    public void changeTask(){
        System.out.print("Введите ID задачи для изменений: ");
        String searchId = sc.nextLine();
        Task searchTask = TaskStorage.searchById(searchId);
        if (searchTask!=null){
            try {
                boolean checkInput = false;
                while (!checkInput){
                    System.out.println("Что будем менять?\n1 - дату/время дедлайна\n2 - описание задачи");
                    if (sc.hasNextLine()){
                        String choice = sc.nextLine();
                        switch (choice) {
                            case "1" -> {
                                checkInput = true;
                                System.out.println("Текущее значение: " + searchTask.getDeadline());
                                LocalDateTime deadline = this.InputDeadlineDate();
                                searchTask.setDeadline(deadline);//LocalDateTime.of(deadlineDate, deadlineTime)
                                searchTask.setPriority(searchTask.getDateTimeAdded(), searchTask.getDeadline());
                            }
                            case "2" -> {
                                checkInput = true;
                                System.out.println("Текущее значение: " + searchTask.getDescription());
                                System.out.println("Введите новое описание задачи:");
                                if (sc.hasNextLine()) {
                                    String description = sc.nextLine();
                                    searchTask.setDescription(description);

                                }
                            }
                            default -> System.out.println("Ошибка ввода - попробуйте снова");
                        }
                    }
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        } else System.out.println("Задача не найдена");
    }
    public void deleteTask(){
        System.out.println("Введите id задачи для удаления:");
        String searchId = sc.nextLine();
        Task searchTask = TaskStorage.searchById(searchId);
        if (searchTask!=null){
            TaskStorage.removeTaskByID(searchId);
            System.out.println("Задача отменена успешно");
        }
    }
    public void saveData() {
        //здесь можно выбирать формат и путь к файлу, после чего вести на разные методы/классы, но т.к. пока не успеваю
        //просто вызывается метод записи в csv
        DataExportImport.csvWriter();
    }
    public void loadData(){
        //здесь аналогично подумать над иерархией классов/методов - пока просто вызов загрузки csv
        //DataExchange.csvReader();
        System.out.println("На данный момент метод в разработке))");
    }
    public  static void printTitle(){
        System.out.println("""
                ---------------------------------------------------------------------------------------------------------------
                ID    ПРИОРИТЕТ       ОПИСАНИЕ ЗАДАЧИ                     АВТОР                ДАТА            СРОК ИСПОЛНЕНИЯ
                ---------------------------------------------------------------------------------------------------------------""");
    }
}

