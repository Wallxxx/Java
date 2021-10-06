import java.sql.*;

public class DataBaseHandler {
    private static final String postgresqlUrlConnection = "jdbc:postgresql://localhost:5432/a19598978";
    private static Connection postgresqlConnection;

    private static boolean connectionStatus = false;

    public DataBaseHandler() {
        try {
            postgresqlConnection = DriverManager.getConnection(postgresqlUrlConnection);
            connectionStatus = true;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void otherRequest(String request) {
        if (connectionStatus) {
            PreparedStatement sendRequest = null;
            try {
                sendRequest = postgresqlConnection.prepareStatement(request);
                sendRequest.execute();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public ResultSet selectRequest(String request) {
        Statement statement = null;
        ResultSet answer = null;
        if (connectionStatus) {
            try {
                statement = postgresqlConnection.createStatement();
                answer = statement.executeQuery(request);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return answer;
    }
}
