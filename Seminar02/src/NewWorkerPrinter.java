public class NewWorkerPrinter extends WorkerPrinter {
  public NewWorkerPrinter(Worker worker) {
    super(worker);
  }

  @Override
  public void print() {

    System.out.println(String.format("[[%s %s %s]]",
        worker.firstName,
        worker.lastName,
        worker.address));
  }
}