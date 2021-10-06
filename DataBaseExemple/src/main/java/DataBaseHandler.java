import java.sql.*;

public class DataBaseHandler {
    private static final String postgresqlUrlConnection = "jdbc:postgresql://localhost:5432/a19598978";
    private static Connection postgresqlConnection;

    private static boolean connectionStatus;

    public DataBaseHandler() {
        try {
            postgresqlConnection = DriverManager.getConnection(postgresqlUrlConnection);
            connectionStatus = true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void otherRequest(String request) {
        if (connectionStatus) {
            try {
                PreparedStatement sendRequest = postgresqlConnection.prepareStatement(request);
                sendRequest.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ResultSet selectRequest(String request) {
        ResultSet answer = null;
        if (connectionStatus) {
            try {
                Statement statement = postgresqlConnection.createStatement();
                answer = statement.executeQuery(request);
                return answer;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return answer;
    }
}
