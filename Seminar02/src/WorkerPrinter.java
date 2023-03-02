public class WorkerPrinter {
  Worker worker;

  public WorkerPrinter(Worker w) {
    worker = w;
  }

  public void print() {

    System.out.println(String.format("%s %s %s",
        worker.firstName,
        worker.lastName,
        worker.address));
  }
}
