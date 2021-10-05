import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;
import java.io.File;

public class Main {
    public static final String postgresqlUrlConnection = "jdbc:postgresql://localhost:5432/a19598978";
    public static final String dropTableRequestMessage = "DROP TABLE City;";
    public static final String createTableRequestMessage = "CREATE TABLE City (" +
            "id SERIAL PRIMARY KEY, " +
            "name VARCHAR(100) UNIQUE NOT NULL, " +
            "region VARCHAR(100) NOT NULL, " +
            "district VARCHAR(100) NOT NULL, " +
            "population INTEGER NOT NULL, " +
            "foundation VARCHAR(100) NOT NULL" +
            ");";
    public static final String selectFirst20 = "SELECT * FROM City LIMIT 20";
    public static final String selectFirst100 = "SELECT * FROM City LIMIT 100";

    public static boolean isCreate = false;
    public static boolean isParse = false;
    public static boolean isSort = false;

    public static void main(String[] argv) throws SQLException, FileNotFoundException {
        showMenu();
        otherRequest(dropTableRequestMessage);
        System.out.println("Done.");
    }

    public static void showMenu() throws SQLException, FileNotFoundException {
        while (true) {
            String status = "Состояние таблицы:";
            if (isCreate) {
                status = status + " создана, ";
                if (isParse) status = status + " загружена из файла, ";
                if (isSort) status = status + " сортирована ";
            } else status = status + " таблица не создана.";
            System.out.println(status);
            System.out.println("1) Создать и заполнить таблицу из файла");
            System.out.println("2) Вывести первые 20 строк");
            System.out.println("3) Вывести первые 100 строк");
            System.out.println("4) Выход");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();
            if (choice.length() > 0) {
                switch (choice.charAt(0)) {
                    case '1':
                        if (!isCreate) {
                            System.out.print("Укажите имя файла и путь, если требуется: ");
                            choice = scanner.next();
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
                        scanner.close();
                        return;
                    default:
                        break;
                }
            }
        }
    }

    public static void otherRequest(String request) throws SQLException {
        Connection postgresqlConnection = DriverManager.getConnection(postgresqlUrlConnection);
        PreparedStatement sendRequest = postgresqlConnection.prepareStatement(request);
        sendRequest.execute();
        postgresqlConnection.close();
    }

    public static ResultSet selectRequest(String request) throws SQLException {
        Connection postgresqlConnection = DriverManager.getConnection(postgresqlUrlConnection);
        Statement statement = postgresqlConnection.createStatement();
        ResultSet answer = statement.executeQuery(request);
        postgresqlConnection.close();
        return answer;
    }

    public static void showSelect(ResultSet answer) throws SQLException {
        while (answer.next()) {
            System.out.println("[" + answer.getString("id") + "]" + "City{name='" + answer.getString("name") + "', region='" +
                    answer.getString("region") + "', district='" +
                    answer.getString("district") + "', population=" +
                    answer.getString("population") + ", foundation='" +
                    answer.getString("foundation") + "'}");
        }
    }

    public static void parseFileInDataBase(String file_name) throws FileNotFoundException, SQLException {
        Scanner scanner = new Scanner(new File(file_name));
        scanner.useDelimiter(";|\\n");
        while(scanner.hasNext()) {
            String q = "INSERT INTO City VALUES (" + scanner.next() + ", '" + scanner.next() + "', '" +
                    scanner.next() + "', '" + scanner.next() + "', " + scanner.next() + ", " + scanner.next() + ");";
            otherRequest(q);
        }
        scanner.close();
    }
}
