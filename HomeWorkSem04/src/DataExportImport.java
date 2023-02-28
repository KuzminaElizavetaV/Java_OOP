import java.io.*;

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
    public static void csvReader() throws IOException {
        String pathToCsv = "D:\\MyStudy\\Java_OOP\\HomeWorkSem04\\src\\task.csv";
        File csvFile = new File(pathToCsv);
        if (csvFile.isFile()) {
            BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));
//            while () {
//                не успела закончить
//            }
            csvReader.close();
        }


    }
}
