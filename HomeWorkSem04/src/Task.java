import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * Класс Задача
 */
public class Task implements Comparable<LocalDate>{
    private final String ID;
    private final LocalDateTime dateTimeAdded;
    private LocalDateTime deadline;
    private final String author;
    private String description;
    private static Integer countId;
    private Priority priority;

    static {
        countId = TaskStorage.getTaskStorage().size();
    }

    public Task(String description, String author, LocalDateTime deadline) {
        this.ID = String.format("№%d",++countId);
        this.dateTimeAdded = LocalDateTime.now();
        this.deadline = deadline;
        this.author = author;
        this.description = description;
        this.setPriority(this.dateTimeAdded, this.deadline);
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(LocalDateTime dateAdded, LocalDateTime deadline) {
        long diff = DAYS.between(dateAdded, deadline);
        if (diff >= 0 && diff <= 3) {
            this.priority = Priority.NOW;
        } else if (diff > 3 && diff <= 7) {
            this.priority = Priority.URGENT;
        } else if (diff > 7 && diff <= 14) {
            this.priority = Priority.MEDIUM;
        } else if (diff >  14)
            this.priority = Priority.LOW;
    }

    public String getID() {
        return ID;
    }

    public LocalDateTime getDateTimeAdded() {
        return dateTimeAdded;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(ID, task.ID) && Objects.equals(dateTimeAdded, task.dateTimeAdded) &&
                Objects.equals(deadline, task.deadline) && Objects.equals(author, task.author) &&
                Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, dateTimeAdded, deadline, author, description);
    }

    @Override
    public String toString() {
        return "Task{" + "Приоритет=" + priority.getTranslation() +
                ", id='" + ID + '\'' + ", Добавлено: дата=" + dateTimeAdded.toLocalDate() +
                ", время=" + dateTimeAdded.toLocalTime() +
                ", Дедлайн: дата=" + deadline.toLocalDate() + ", время=" + deadline.toLocalTime() +
                ", Автор='" + author + '\'' + ", Описание задачи='" + description + '\'' + '}';
    }

    public String exportCsvFile(){
        return "Task id=" + ID + ", Приоритет=" + priority.getTranslation() +
                ", Описание задачи=" + description + ", Автор='" + author +
                ", Добавлено: дата=" + dateTimeAdded.toLocalDate() + ", время=" + dateTimeAdded.toLocalTime() +
                ", Дата выполнения=" + deadline.toLocalDate() + ", время выполнения=" + deadline.toLocalTime();
    }
    public String exportJsonFile(){
        return "  {taskID: \"" + ID + "\", priority: \"" + priority.getTranslation() +
                "\", description: \"" + description + "\", author: \"" + author +
                "\", dateAdded: \"" + dateTimeAdded.toLocalDate() + "\", timeAdded: \"" + dateTimeAdded.toLocalTime() +
                "\", dateDeadline: \"" + deadline.toLocalDate() + "\", timeDeadline: \"" + deadline.toLocalTime() + "\"}";
    }
    public String printFormat(){
        return String.format("%-5s %-15s %-35s %-20s %-15s %-10S %s", ID , priority.getTranslation(), description, author,
                dateTimeAdded.toLocalDate(), deadline.toLocalDate(), deadline.toLocalTime());
    }

    @Override
    public int compareTo(LocalDate date) {
        LocalDate dateThis = LocalDate.from(this.deadline);
        if (dateThis.isAfter(date)) {
            return 1;
        } else if (dateThis.isBefore(date))
            return -1;
        else
            return 0;
    }
}
