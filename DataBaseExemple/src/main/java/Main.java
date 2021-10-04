import java.sql.*;

public class Main {
    public static final String postgresqlUrlConnection = "jdbc:postgresql://localhost:5432/a19598978";
    public static final String dropTableRequestMessage = "DROP TABLE City;";
    public static final String createTableRequestMessage = "CREATE TABLE City (" +
            "id SERIAL PRIMARY KEY, " +
            "name VARCHAR(100) UNIQUE NOT NULL, " +
            "region VARCHAR(100) NOT NULL, " +
            "district VARCHAR(100) NOT NULL, " +
            "population INTEGER NOT NULL, " +
            "foundation INTEGER NOT NULL" +
            ");";

    public static void main(String[] argv) throws SQLException {
        otherRequest(createTableRequestMessage);



        //Connection postgresqlConnection = DriverManager.getConnection(postgresqlUrlConnection);

        final String createTable = "create table Weather ( min int, max int );";
        final String insertFirst = "insert into Weather values (4, 19)";
        final String insertSecond = "insert into Weather values (2, 11)";
        final String select = "select * from Weather";

        //PreparedStatement temp = postgresqlConnection.prepareStatement(createTable);
        //temp.execute();
        //PreparedStatement temp = postgresqlConnection.prepareStatement(insertFirst);
        //temp.execute();
        //temp = postgresqlConnection.prepareStatement(insertSecond);
        //temp.execute();
        //Statement statement = postgresqlConnection.createStatement();
        //ResultSet rs = statement.executeQuery(select);
        //while (rs.next()) {
        //    System.out.println(rs.getString("min"));
        //    System.out.println(rs.getString("max"));
        //}
// Обязательно закрываем соединение
        //postgresqlConnection.close();

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

    public static void parseFileInDataBase() {
        // TODO: Парсить файл и заполнять таблицу
    }


}
