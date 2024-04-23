package FinalJavaSprint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HealthDataDao implements Dao<HealthData> {
  public HealthDataDao() {
    DatabaseConnection dbConnection = new DatabaseConnection();
    Connection connection = dbConnection.getConnection();
  }

  public List<HealthData> getHealthDataByUserId(int user_id) {
    String sql = "SELECT * FROM health_data WHERE user_id = ?";
    List<HealthData> healthDataList = new ArrayList<>();
    try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, user_id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            healthDataList.add(mapResultSetToHealthData(resultSet));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return healthDataList;
}

    private Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver"); // For Postgres
            return DriverManager.getConnection("jdbc:postgresql://localhost:5050/HealthApp", "malerie", "password");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<HealthData> getId(int id) {
      String sql = "SELECT * FROM health_data WHERE health_id = ?";
      try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
          return Optional.of(mapResultSetToHealthData(resultSet));
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return Optional.empty();
    }

    @Override
    public List<HealthData> getAll() {
      List<HealthData> healthDataList = new ArrayList<>();
      String sql = "SELECT * FROM health_data";
      try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
          healthDataList.add(mapResultSetToHealthData(resultSet));
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return healthDataList;
    }

    @Override
    public void save(HealthData healthData) {
      String sql = "INSERT INTO health_data VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
      try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, healthData.getHealthId());
        statement.setInt(2, healthData.getUserId());
        statement.setString(3, healthData.getGender());
        statement.setInt(4, healthData.getAge());
        statement.setDouble(5, healthData.getWeight());
        statement.setDouble(6, healthData.getHeight());
        statement.setInt(7, healthData.getRestHeartRate());
        statement.setInt(8, healthData.getActiveHeartRate());
        statement.setString(9, healthData.getBloodPressure());
        statement.setDouble(10, healthData.getBloodSugar());
        statement.setInt(11, healthData.getSteps());
        statement.setInt(12, healthData.getCardioMinutes());
        statement.setInt(13, healthData.getHoursSlept());
        statement.setString(14, healthData.getLocalDate());
        statement.setString(15, healthData.getMedList());
        statement.setString(16, healthData.getAllergies());
        statement.setString(17, healthData.getMedHistory());
        statement.setInt(18, healthData.getDrId());
        statement.executeUpdate();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    @Override
    public void update(HealthData healthData, String[] params) {
      String sql = "UPDATE health_data SET user_id, gender, age, weight, height, rest_heart_rate, active_heart_rate, blood_pressure, blood_sugar, steps, cardio_minutes, hours_slept, date, med_list, allergies, med_history, dr_id WHERE health_id = ?"; 
      try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, healthData.getUserId());
        statement.setString(2, healthData.getGender());
        statement.setInt(3, healthData.getAge());
        statement.setDouble(4, healthData.getWeight());
        statement.setDouble(5, healthData.getHeight());
        statement.setInt(6, healthData.getRestHeartRate());
        statement.setInt(7, healthData.getActiveHeartRate());
        statement.setString(8, healthData.getBloodPressure());
        statement.setDouble(9, healthData.getBloodSugar());
        statement.setInt(10, healthData.getSteps());
        statement.setInt(11, healthData.getCardioMinutes());
        statement.setInt(12, healthData.getHoursSlept());
        statement.setString(13, healthData.getLocalDate());
        statement.setString(14, healthData.getMedList());
        statement.setString(15, healthData.getAllergies());
        statement.setString(16, healthData.getMedHistory());
        statement.setInt(17, healthData.getDrId());
        statement.executeUpdate();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    @Override
    public void delete(HealthData healthData) {
      String sql = "DELETE FROM health_data WHERE health_id = ?";
      try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, healthData.getHealthId());
        statement.executeUpdate();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    private HealthData mapResultSetToHealthData(ResultSet resultSet) throws SQLException {
        int health_id = resultSet.getInt("health_id");
        int user_id = resultSet.getInt("user_id");
        String gender = resultSet.getString("gender");
        int age = resultSet.getInt("age");
        double weight = resultSet.getInt("weight");
        double height = resultSet.getInt("height");
        int rest_heart_rate = resultSet.getInt("rest_heart_rate");
        int active_heart_rate = resultSet.getInt("active_heart_rate");
        String blood_pressure = resultSet.getString("blood_pressure");
        Double blood_sugar = resultSet.getDouble("blood_sugar");
        int steps = resultSet.getInt("steps");
        int cardio_minutes = resultSet.getInt("cardio_minutes");
        int hours_slept = resultSet.getInt("hours_slept");
        String date = resultSet.getString("date");
        String med_list = resultSet.getString("med_list");
        String allergies = resultSet.getString("allergies"); 
        String med_history = resultSet.getString("med_history");
        int dr_id = resultSet.getInt("dr_id");
        return new HealthData(health_id, user_id, gender, age, weight, height, rest_heart_rate, active_heart_rate, blood_pressure, blood_sugar, steps, cardio_minutes, hours_slept, date, med_list, allergies, med_history, dr_id);
        }
      }

        // public void addHealthData(HealthData healthData) {
        //     String sql = "INSERT INTO public.health_data (health_id, user_id, gender, age, weight, height, rest_heart_rate, active_heart_rate, blood_pressure, blood_sugar, steps, cardio_minutes, hours_slept, date, med_list, allergies, med_history, dr_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        //     try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
        //         statement.setInt(1, healthData.getHealthId());
        //         statement.setInt(2, healthData.getUserId());
        //         statement.setString(3, healthData.getGender());
        //         statement.setInt(4, healthData.getAge());
        //         statement.setDouble(5, healthData.getWeight());
        //         statement.setDouble(6, healthData.getHeight());
        //         statement.setInt(7, healthData.getRestHeartRate());
        //         statement.setInt(8, healthData.getActiveHeartRate());
        //         statement.setString(9, healthData.getBloodPressure());
        //         statement.setDouble(10, healthData.getBloodSugar());
        //         statement.setInt(11, healthData.getSteps());
        //         statement.setInt(12, healthData.getCardioMinutes());
        //         statement.setInt(13, healthData.getHoursSlept());
        //         statement.setString(14, healthData.getLocalDate());
        //         statement.setString(15, healthData.getMedList());
        //         statement.setString(16, healthData.getAllergies());
        //         statement.setString(17, healthData.getMedHistory());
        //         statement.setInt(18, healthData.getDrId());
        //         statement.executeUpdate();
        //     } catch (SQLException e) {
        //         e.printStackTrace();
        //     }
        //     save(healthData);
        // }

//         public static void main(String[] args) {
//           DatabaseConnection dbConnection = new DatabaseConnection();
//           Connection connection = dbConnection.getConnection();
//           HealthDataDao healthDataDao = new HealthDataDao();  
      
//           int userId = 5;  
//           List<HealthData> healthDataList = healthDataDao.getHealthDataByUserId(userId); 
//           if (healthDataList != null && !healthDataList.isEmpty()) {
//               for (HealthData healthData : healthDataList) {
//                   System.out.println(healthData);
//               }
//           } else {
//               System.out.println("No health data found for the provided user ID.");
//           }
//       }
// }
