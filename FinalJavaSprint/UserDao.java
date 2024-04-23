package FinalJavaSprint;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<User> {
    public Connection connection;
    public List<User> userList = new ArrayList<>();

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    public UserDao() {
    }


    public User getUserById(int user_id) {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, user_id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("user_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("is_doctor")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // No user found with the given ID, return null or throw an exception
        return null;
    }

    public User getUserByFirstName(String firstName) {
        String sql = "SELECT * FROM users WHERE first_name = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, firstName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("user_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("is_doctor")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getUserByLastName(String lastName) {
        String sql = "SELECT * FROM users WHERE last_name = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, lastName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("user_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("is_doctor")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getUserByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("user_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("is_doctor")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                userList.add(new User(
                        resultSet.getInt("user_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("is_doctor")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
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

    public void updateUser(User user) {
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
    }

    public void deleteUser(int user_id) {
        String sql = "DELETE FROM users WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, user_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean verifyPassword(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isDoctor(String email) {
        String sql = "SELECT is_doctor FROM users WHERE email = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getBoolean("is_doctor");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Optional<User> getId(int id) {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(new User(
                        resultSet.getInt("user_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("is_doctor")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void save(User user) {
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

    @Override
    public void update(User user, String[] params) {
        String sql = "UPDATE users SET first_name = ?, last_name = ?, email = ?, password = ?, is_doctor = ? WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, params[0]); // First Name
            statement.setString(2, params[1]); // Last Name
            statement.setString(3, params[2]); // Email
            statement.setString(4, params[3]); // Password
            statement.setBoolean(5, Boolean.parseBoolean(params[4])); 
            statement.setInt(6, user.getUserId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User user) {
        String sql = "DELETE FROM users WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, user.getUserId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getPatientsByDoctorId(int doctor_id) {
        String sql = "SELECT * FROM users WHERE dr_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, doctor_id);
            ResultSet resultSet = statement.executeQuery();
            List<User> patients = new ArrayList<>();
            while (resultSet.next()) {
                patients.add(new User(
                        resultSet.getInt("user_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("is_doctor")
                ));
            }
            return patients;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean authenticateUser(String email, String password) {
      UserDao userDao = new UserDao(connection);
      User user = userDao.getUserByEmail(email);
      if (email == null || password == null) {
          return false;
      } else if (user != null && user.getPassword().equals(password)) {
          return true;
      } else {
          return false;
      }
  }
}