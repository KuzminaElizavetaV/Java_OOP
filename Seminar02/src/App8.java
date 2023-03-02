public class App8 {
  public static void main(String[] args) {

    String s = new StringBuilder()
        .append("cscds")
        .append(123)
        .append('c')
        .append(1.2)

        .toString();

    Worker w = WorkerCreator
        .getInstance()
        .setAddress("МСК Ленина 21")
        .setFirstName("Вася")
        .setSalary(110)
        .Create();

    new WorkerPrinter(w).print();

    Worker w2 = WorkerCreator
        .getInstance()
        .setAddress("МСК Ленина 111")
        .setFirstName("Маша")
        .Create();

    new NewWorkerPrinter(w2).print();

  }
}
