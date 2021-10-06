import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String dropTableRequestMessage = "DROP TABLE City;";
    private static final String createTableRequestMessage = "CREATE TABLE IF NOT EXISTS City (" +
            "id SERIAL PRIMARY KEY, " +
            "name VARCHAR(100) UNIQUE NOT NULL, " +
            "region VARCHAR(100) NOT NULL, " +
            "district VARCHAR(100) NOT NULL, " +
            "population INTEGER NOT NULL, " +
            "foundation VARCHAR(100) NOT NULL" +
            ");";
    private static final String selectFirst20 = "SELECT * FROM City LIMIT 20";
    private static final String selectFirst100 = "SELECT * FROM City LIMIT 100";
    private static final String selectSortName = "SELECT * FROM City ORDER BY UPPER(name) COLLATE \"C\"";
    private static final String selectSortNameDistrict = "SELECT * FROM City ORDER BY district " +
            "COLLATE \"C\", name COLLATE \"C\"";
    private static final String selectMaxPopulation = "SELECT name, population FROM City";
    private static final String selectCityCount = "SELECT region, COUNT(*) FROM City GROUP BY region HAVING COUNT(*) > 0";

    private static boolean isExit = false;

    private static final DataBaseHandler dataBase = new DataBaseHandler();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] argv) {
        while (!isExit) {
            System.out.println("1) Создать и заполнить таблицу из файла");
            System.out.println("2) Вывести первые 20 строк");
            System.out.println("3) Вывести первые 100 строк");
            System.out.println("4) Вывести все строки, сортированные по названию городов");
            System.out.println("5) Вывести все строки, сортированные по округам и названиям городов");
            System.out.println("6) Вывест город с наибольшим населением");
            System.out.println("7) Вывести количество городов в регионах");
            System.out.println("8) Удалить таблицу");
            System.out.println("9) Выход");
            userChoiceHandler();
        }
    }

    public static void userChoiceHandler() {
        String choice = scanner.next();
        switch (choice) {
            case "1":
                createDataBase();
                break;
            case "2":
                showSelect(dataBase.selectRequest(selectFirst20));
                break;
            case "3":
                showSelect(dataBase.selectRequest(selectFirst100));
                break;
            case "4":
                showSelect(dataBase.selectRequest(selectSortName));
                break;
            case "5":
                showSelect(dataBase.selectRequest(selectSortNameDistrict));
                break;
            case "6":
                maxPopulation(getAllPopulations());
                break;
            case "7":
                cityCount();
                break;
            case "8":
                dataBase.otherRequest(dropTableRequestMessage);
                break;
            case "9":
                isExit = true;
                return;
            default:
                break;
        }
    }

    public static void createDataBase() {
        dataBase.otherRequest(createTableRequestMessage);
        System.out.print("Укажите имя файла и путь, если требуется: ");
        String file_name = scanner.next();
        parseFileInDataBase(file_name);
    }

    private static void parseFileInDataBase(String file_name) {
        try {
            Scanner scannerFile = new Scanner(new File(file_name));
            scannerFile.useDelimiter("[;\\n]");
            while(scannerFile.hasNext()) {
                String q = "INSERT INTO City VALUES (" + scannerFile.next() + ", '" + scannerFile.next() + "', '" +
                        scannerFile.next() + "', '" + scannerFile.next() + "', " + scannerFile.next() + ", " +
                        scannerFile.next() + ");";
                dataBase.otherRequest(q);
            }
            scannerFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void showSelect(ResultSet answer) {
        try {
            while (answer.next()) {
                System.out.println("City{name='" + answer.getString("name") + "', region='" +
                        answer.getString("region") + "', district='" +
                        answer.getString("district") + "', population=" +
                        answer.getString("population") + ", foundation='" +
                        answer.getString("foundation") + "'}");
            }
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    private static List<Populations> getAllPopulations() {
        List<Populations> data = new ArrayList<>();
        try {
            ResultSet info = dataBase.selectRequest(selectMaxPopulation);
            while (info.next()) {
                Populations temp = new Populations(info.getString("name"),
                        info.getInt("population"));
                data.add(temp);
            }
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
        return data;
    }

    private static void maxPopulation(List<Populations> data) {
        int maxPeople = Integer.MIN_VALUE, index = Integer.MIN_VALUE, population = 0;
        for (int i = 0; i < data.size(); i++) {
            population = data.get(i).getPopulation();
            if (population > maxPeople) {
                maxPeople = population;
                index = i;
            }
        }
        if (index > -1) System.out.println("[" + index + "] = " + maxPeople);
    }

    private static void cityCount() {
        try {
            ResultSet info = dataBase.selectRequest(selectCityCount);
            while (info.next()) {
                System.out.println(info.getString("region") + " - " + info.getInt("count"));
            }
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}
