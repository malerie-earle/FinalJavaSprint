package FinalJavaSprint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection implements AutoCloseable {
    private static final String url = "jdbc:postgresql://localhost:5050/HealthApp";
    private static final String user = "malerie";
    private static final String password = "password";
    public Connection connection;

    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver"); 
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to connect to the database.");
        }
        return connection;
    }

    public Connection getCon() {
        return connection;
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public static void createUser(String firstName, String lastName, String email, String password) throws SQLException {
        String sql = "INSERT INTO users (first_name, last_name, email, password) VALUES (?, ?, ?, ?)";
        try (DatabaseConnection dbConnection = new DatabaseConnection();
             PreparedStatement statement = dbConnection.getCon().prepareStatement(sql)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, email);
            statement.setString(4, password);
            statement.executeUpdate();
        }
    }

    // Implement other CRUD operations similarly
}