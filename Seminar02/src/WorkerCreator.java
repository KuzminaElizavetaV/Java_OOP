import java.time.LocalDate;
import java.time.Month;

public class WorkerCreator {

  private static WorkerCreator instance;

  public static WorkerCreator getInstance() {
    if (instance == null)
      instance = new WorkerCreator();
    instance.init();
    return instance;
  }

  private WorkerCreator() {
  }

  private void init() {
    temp = new Worker();

    temp.dayOfBirth = LocalDate.of(1900, Month.JANUARY, 1);
    temp.salary = -2;
    temp.firstName = "";
    temp.lastName = "";
    temp.address = "";
  }

  Worker temp;

  public WorkerCreator setDay(LocalDate ofBirth) {
    temp.dayOfBirth = ofBirth;
    return this;
  }

  public WorkerCreator setSalary(int salary) {
    temp.salary = salary;
    return this;
  }

  public WorkerCreator setAddress(String address) {
    if (address != null)
      temp.address = address;
    else
      temp.address = "";
    return this;
  }

  public WorkerCreator setFirstName(String firstName) {
    temp.firstName = firstName;
    return this;
  }

  public WorkerCreator setLastName(String lastName) {
    temp.lastName = lastName;
    return this;
  }

  public Worker Create() {
    return temp;
  }
}
