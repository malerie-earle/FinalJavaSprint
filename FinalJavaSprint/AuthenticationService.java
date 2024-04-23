package FinalJavaSprint;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthenticationService {
  Connection connection = new DatabaseConnection().getCon();

//   public boolean authenticateUser(String email, String password) {
//     UserDao userDao = new UserDao(connection);
//     User user = userDao.getUserByEmail(email);
//     if (email == null || password == null) {
//         return false;
//     } else if (user != null && user.getPassword().equals(password)) {
//         return true;
//     } else {
//         return false;
//     }
// }

  public boolean authenticateDoctor(String email, String password) {
      UserDao userDao = new UserDao(connection);
      User user = userDao.getUserByEmail(email);
      if (email == null || password == null) {
          return false;
      } else if (user != null && user.getPassword().equals(password) && user.is_doctor()) {
          return true;
      } else {
          return false;
      }
  }

  public void createUser(User user) {
    String sql = "INSERT INTO users (first_name, last_name, email, password, is_doctor) VALUES (?, ?, ?, ?, ?)";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3, user.getEmail());
        statement.setString(4, user.getPassword());
        statement.setBoolean(5, user.getIsDoctor());
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

  public void createDoctor(User user, Doctor doctor) {
      String sql = "INSERT INTO users (first_name, last_name, email, password, is_doctor) VALUES (?, ?, ?, ?, ?)";
      String sql2 = "INSERT INTO doctors (medLicenseNum, specialization) VALUES (?, ?)";
      try (PreparedStatement statement = connection.prepareStatement(sql)) {
          statement.setString(1, user.getFirstName());
          statement.setString(2, user.getLastName());
          statement.setString(3, user.getEmail());
          statement.setString(4, user.getPassword());
          statement.setBoolean(5, user.getIsDoctor());
          statement.executeUpdate();
      try (PreparedStatement statement2 = connection.prepareStatement(sql2)) {
          statement2.setString(1, doctor.getMedLicenseNum());
          statement2.setString(2, doctor.getSpecialization());
          statement2.executeUpdate();
      } catch (SQLException e) {
          e.printStackTrace();
  }
      } catch (SQLException e) {
          e.printStackTrace();
      }
  }

public void updateUser(User user, Doctor doctor) {
    String sql = "UPDATE users SET first_name = ?, last_name = ?, email = ?, password = ?, is_doctor = ? WHERE user_id = ?";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3, user.getEmail());
        statement.setString(4, user.getPassword());
        statement.setBoolean(5, user.getIsDoctor());
        statement.setInt(6, user.getUserId());
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    String sql2 = "UPDATE doctors SET medLicenseNum = ?, specialization = ? WHERE dr_id = ?";
    try (PreparedStatement statement = connection.prepareStatement(sql2)) {
        statement.setString(1, doctor.getMedLicenseNum());
        statement.setString(2, doctor.getSpecialization());
        statement.setInt(3, doctor.getDrId());
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
  }
}