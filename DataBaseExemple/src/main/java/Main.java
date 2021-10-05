import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.io.File;

public class Main {
    private static final String postgresqlUrlConnection = "jdbc:postgresql://localhost:5432/a19598978";
    private static final String dropTableRequestMessage = "DROP TABLE City;";
    private static final String createTableRequestMessage = "CREATE TABLE City (" +
            "id SERIAL PRIMARY KEY, " +
            "name VARCHAR(100) UNIQUE NOT NULL, " +
            "region VARCHAR(100) NOT NULL, " +
            "district VARCHAR(100) NOT NULL, " +
            "population INTEGER NOT NULL, " +
            "foundation VARCHAR(100) NOT NULL" +
            ");";
    private static final String selectFirst20 = "SELECT * FROM City LIMIT 20";
    private static final String selectFirst100 = "SELECT * FROM City LIMIT 100";

    private static final String selectSortName = "SELECT * FROM City ORDER BY name COLLATE \"C\"";
    private static final String selectSortNameDistrict = "SELECT * FROM City ORDER BY district " +
            "COLLATE \"C\", name COLLATE \"C\"";
    private static final String selectMaxPopulation = "SELECT name, population FROM City";
    private static final String selectCityCount = "SELECT region, COUNT(*) FROM City GROUP BY region HAVING COUNT(*) > 0";

    private static boolean isCreate = false;
    private static boolean isParse = false;

    public static void main(String[] argv) throws SQLException, FileNotFoundException { // исключения лучше обрабатывать, а не указывать их в сгинатуре метода
        while (true) {
            String status = "Состояние таблицы:";
            if (isCreate) {
                status = status + " создана, ";
                if (isParse) status = status + " загружена из файла, ";
            } else status = status + " таблица не создана.";
            System.out.println(status);
            System.out.println("1) Создать и заполнить таблицу из файла");
            System.out.println("2) Вывести первые 20 строк");
            System.out.println("3) Вывести первые 100 строк");
            System.out.println("4) Вывести все строки, сортированные по названию городов");
            System.out.println("5) Вывести все строки, сортированные по округам и названиям городов");
            System.out.println("6) Ввести и выполнить запрос");
            System.out.println("7) Вывест город с наибольшим населением");
            System.out.println("8) Вывести количество городов в регионах");
            System.out.println("9) Выход");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            if (choice.length() > 0) {
                switch (choice.charAt(0)) {
                    case '1':
                        if (!isCreate) {
                            System.out.print("Укажите имя файла и путь, если требуется: ");
                            choice = scanner.nextLine();
                            otherRequest(createTableRequestMessage);
                            parseFileInDataBase(choice);
                            isCreate = true;
                            isParse = true;
                        }
                        else System.out.println("Таблица уже создана");
                        break;
                    case '2':
                        showSelect(selectRequest(selectFirst20));
                        break;
                    case '3':
                        showSelect(selectRequest(selectFirst100));
                        break;
                    case '4':
                        showSelect(selectRequest(selectSortName));
                        break;
                    case '5':
                        showSelect(selectRequest(selectSortNameDistrict));
                        break;
                    case '6':
                        choice = scanner.nextLine();
                        System.out.println("Command send: " + choice);
                        otherRequest(choice);
                        break;
                    case '7':
                        maxPopulation();
                        break;
                    case '8':
                        cityCount();
                        break;
                    case '9':
                        scanner.close();
                        if (isCreate) otherRequest(dropTableRequestMessage);
                        isCreate = false;
                        isParse = false;
                        return;
                    default:
                        break;
                }
            }
        }
    }



    // смысла везде конекшн создавать тоже нет, лучше приватное поле какое нибудь иметь
    private static void otherRequest(String request) throws SQLException {
        Connection postgresqlConnection = DriverManager.getConnection(postgresqlUrlConnection);
        PreparedStatement sendRequest = postgresqlConnection.prepareStatement(request);
        sendRequest.execute();
        postgresqlConnection.close();
    }

    private static ResultSet selectRequest(String request) throws SQLException {
        Connection postgresqlConnection = DriverManager.getConnection(postgresqlUrlConnection);
        Statement statement = postgresqlConnection.createStatement();
        ResultSet answer = statement.executeQuery(request);
        postgresqlConnection.close();
        return answer;
    }

    private static void showSelect(ResultSet answer) throws SQLException {
        while (answer.next()) {
            System.out.println("City{name='" + answer.getString("name") + "', region='" +
                    answer.getString("region") + "', district='" +
                    answer.getString("district") + "', population=" +
                    answer.getString("population") + ", foundation='" +
                    answer.getString("foundation") + "'}");
        }
    }

    private static void parseFileInDataBase(String file_name) throws FileNotFoundException, SQLException {
        Scanner scanner = new Scanner(new File(file_name));
        scanner.useDelimiter("[;\\n]");
        while(scanner.hasNext()) {
            String q = "INSERT INTO City VALUES (" + scanner.next() + ", '" + scanner.next() + "', '" +
                    scanner.next() + "', '" + scanner.next() + "', " + scanner.next() + ", " + scanner.next() + ");";
            otherRequest(q);
        }
        scanner.close();
    }

    private static void maxPopulation() throws SQLException {
        List<Populations> data = new ArrayList<>();
        int maxPeople = Integer.MIN_VALUE, index = Integer.MIN_VALUE; // что за рандомные числа
        ResultSet info = selectRequest(selectMaxPopulation);
        while (info.next()) {
            Populations temp = new Populations(info.getString("name"),
                    info.getInt("population"));
            data.add(temp);
        }
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getPopulation() > maxPeople) {
                maxPeople = data.get(i).getPopulation();
                index = i;
            }
        }
        if (index > -1) System.out.println("[" + index + "] = " + maxPeople);
    }

    private static void cityCount() throws SQLException {
        ResultSet info = selectRequest(selectCityCount);
        while (info.next()) {
            System.out.println(info.getString("region") + " - " + info.getInt("count"));
        }
    }
}

class Populations {
    private final String city;
    private final int population;

    public Populations(String name, int people) {
        city = name;
        population = people;
    }

    public String getCity() {
        return city;
    }

    public int getPopulation() {
        return population;
    }
}