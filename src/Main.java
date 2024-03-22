import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные: Фамилия Имя Отчество дата_рождения номер_телефона пол");
        String inputData = scanner.nextLine();

        String[] dataParts = inputData.split(" ");
        if (dataParts.length != 6) {
            System.out.println("Ошибка ввода. Введите Фамилия Имя Отчество дата_рождения номер_телефона пол");
            return;
        }

        try {
            String surname = dataParts[0];
            String name = dataParts[1];
            String patronymic = dataParts[2];
            String birthDate = dataParts[3];
            long phoneNumber = Long.parseLong(dataParts[4]);
            char gender = dataParts[5].charAt(0);

            PersonInfo person = new PersonInfo(surname, name, patronymic, birthDate, phoneNumber, gender);

            String fileName = surname + ".txt";
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.write(String.format("%s %s %s %s %d %c\n", surname, name, patronymic, birthDate, phoneNumber, gender));
            fileWriter.close();
            System.out.println("Данные успешно записаны в файл.");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка формата номера телефона.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
