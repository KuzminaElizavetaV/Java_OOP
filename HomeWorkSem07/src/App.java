public class App {
    public static void main(String[] args) {
        new InnerApp(new Print()).write();
    }
}
interface IInterface {
    void print();
}

class InnerApp {
    IInterface v;

    public InnerApp(IInterface v) {
        this.v = v;
    }

    void write() {
        v.print();
    }
}

class Print implements IInterface {
    IInterface v;

    public Print() {
    }

    @Override
    public void print() {
        if (v == null){
            System.out.println("Переменная v инициализирована с помощью класса Print, который имплементирует интерфейс IInterface," +
                    " сейчас она равна null, что значит ссылка в пустоту.\nКод все равно работает. Принципы SOLID не нарушены.");
        } else {
            System.out.println(v);
        }
    }
}
