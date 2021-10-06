import java.sql.*;

public class DataBaseHandler {
    private final String postgresqlUrlConnection = "jdbc:postgresql://localhost:5432/a19598978";
    private Connection postgresqlConnection;

    public DataBaseHandler() {
        try {
            postgresqlConnection = DriverManager.getConnection(postgresqlUrlConnection);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void otherRequest(String request) {
        try {
            PreparedStatement sendRequest = postgresqlConnection.prepareStatement(request);
            sendRequest.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ResultSet selectRequest(String request) {
        ResultSet answer = null;
        try {
            Statement statement = postgresqlConnection.createStatement();
            answer = statement.executeQuery(request);
            return answer;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return answer;
    }
}
