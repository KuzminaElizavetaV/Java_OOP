import java.io.*;
import java.util.Scanner;

//предназначен для описания логики обмена данными с файлами
//по хорошему здесь прописать поведение - выгрузка/загрузка, а нюансы в классах разных форматов
//но пока не успеваю, пробую только csv
public class DataExportImport {
    public static void csvWriter() {
        String path = "D:\\MyStudy\\Java_OOP\\HomeWorkSem04\\src\\task.csv";
        try {
            FileWriter csvWriter = new FileWriter(path, false);
            for (Task task : TaskStorage.getTaskStorage()) {
                csvWriter.append(task.exportCsvFile());
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();

        } catch (Exception e) {
            System.out.println("Не удалось записать данные в " + path);

        }
    }
    public static void jsonWriter() {
        String path = "D:\\MyStudy\\Java_OOP\\HomeWorkSem04\\src\\task.json";
        try {
            FileWriter csvWriter = new FileWriter(path, false);
            csvWriter.append("{\n");
            for (Task task : TaskStorage.getTaskStorage()) {
                csvWriter.append(task.exportJsonFile());
                csvWriter.append("\n");
            }
            csvWriter.append("}\n");
            csvWriter.flush();
            csvWriter.close();

        } catch (Exception e) {
            System.out.println("Не удалось записать данные в " + path);

        }
    }

    //загрузка из файла - в разработке - не окончен
    public static void csvReader() {
        String pathToCsv = "D:\\MyStudy\\Java_OOP\\HomeWorkSem04\\src\\task.csv";
        try {
            File file = new File(pathToCsv);
            if (file.isFile()) {
                FileReader reader = new FileReader(file);
                Scanner scan = new Scanner(reader);
                while (scan.hasNextLine()) {
                    System.out.println(scan.nextLine());
                }
                reader.close();
            }
        } catch (Exception e) {
                e.printStackTrace();
        }
    }
}
