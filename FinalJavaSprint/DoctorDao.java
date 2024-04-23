package FinalJavaSprint;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DoctorDao extends User implements Dao<Doctor> {
    private Connection connection;
    public DoctorDao(Connection connection) {
        this.connection = connection;
    }

    public Doctor getDrById(int dr_id) {
        String sql = "SELECT * FROM doctor WHERE dr_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, dr_id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Doctor(
                        resultSet.getInt("user_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("isDoctor"),
                        resultSet.getInt("dr_id"),
                        resultSet.getString("medLicenseNum"),
                        resultSet.getString("specialization")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public Doctor getDoctorByFirstName(String firstName) {
        String sql = "SELECT * FROM doctor WHERE first_name = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, firstName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Doctor(
                        resultSet.getInt("user_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("isDoctor"),
                        resultSet.getInt("dr_id"),
                        resultSet.getString("medLicenseNum"),
                        resultSet.getString("specialization")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public Doctor getDoctorByLastName(String lastName) {
        String sql = "SELECT * FROM doctor WHERE last_name = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, lastName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Doctor(
                        resultSet.getInt("user_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("isDoctor"),
                        resultSet.getInt("dr_id"),
                        resultSet.getString("medLicenseNum"),
                        resultSet.getString("specialization")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Doctor getDoctorByEmail(String email) {
        String sql = "SELECT * FROM doctor WHERE email = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Doctor(
                        resultSet.getInt("user_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("isDoctor"),
                        resultSet.getInt("dr_id"),
                        resultSet.getString("medLicenseNum"),
                        resultSet.getString("specialization")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage()); 
            e.printStackTrace();
        }
        return null;
    }

    public List<Doctor> getAll() {
        List<Doctor> drList  = new ArrayList<>();
        String sql = "SELECT * FROM doctor";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                drList.add(new Doctor(
                        resultSet.getInt("user_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("isDoctor"),
                        resultSet.getInt("dr_id"),
                        resultSet.getString("medLicenseNum"),
                        resultSet.getString("specialization")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        return drList;
    }

    public void createDoctor(Doctor doctor) {
        String sql = "INSERT INTO doctor (first_name, last_name, email, password, isDoctor, dr_id, medLicenseNum, specialization) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, doctor.getFirstName());
            statement.setString(2, doctor.getLastName());
            statement.setString(3, doctor.getEmail());
            statement.setString(4, doctor.getPassword());
            statement.setBoolean(5, doctor.getIsDoctor());
            statement.setInt(6, doctor.getDrId());
            statement.setString(7, doctor.getMedLicenseNum());
            statement.setString(8, doctor.getSpecialization());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDoctor(Doctor doctor) {
        String sql = "UPDATE doctor SET first_name = ?, last_name = ?, email = ?, password = ?, isDoctor = ?, dr_id = ?, medLicenseNum = ?, specialization = ?, WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, doctor.getFirstName());
            statement.setString(2, doctor.getLastName());
            statement.setString(3, doctor.getEmail());
            statement.setString(4, doctor.getPassword());
            statement.setBoolean(5, doctor.getIsDoctor());
            statement.setInt(6, doctor.getDrId());
            statement.setString(7, doctor.getMedLicenseNum());
            statement.setString(8, doctor.getSpecialization());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDoctorUser(int dr_id) {
        String sql = "DELETE FROM users WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, user_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql2 = "DELETE FROM doctor WHERE dr_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql2)) {
            statement.setInt(1, dr_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean verifyPassword(String email, String password) {
        String sql = "SELECT * FROM doctor WHERE email = ? AND password = ?";
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
        String sql = "SELECT isDoctor FROM doctor WHERE email = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getBoolean("isDoctor");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Optional<Doctor> getId(int dr_id) {
        String sql = "SELECT * FROM doctor WHERE dr_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, dr_id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(new Doctor(
                        resultSet.getInt("user_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("isDoctor"),
                        resultSet.getInt("dr_id"),
                        resultSet.getString("medLicenseNum"),
                        resultSet.getString("specialization")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void save(Doctor doctor) {
        String sql = "INSERT INTO doctor (first_name, last_name, email, password, isDoctor, dr_id, medLicenseNum, specialization) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, doctor.getFirstName());
            statement.setString(2, doctor.getLastName());
            statement.setString(3, doctor.getEmail());
            statement.setString(4, doctor.getPassword());
            statement.setBoolean(5, doctor.getIsDoctor());
            statement.setInt(6, doctor.getDrId());
            statement.setString(7, doctor.getMedLicenseNum());
            statement.setString(8, doctor.getSpecialization());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Doctor doctor, String[] params) {
        String sql = "UPDATE doctor SET first_name = ?, last_name = ?, email = ?, password = ?, isDoctor = ?, medLicenseNum = ?, specialization = ? WHERE dr_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, params[0]); // First Name
            statement.setString(2, params[1]); // Last Name
            statement.setString(3, params[2]); // Email
            statement.setString(4, params[3]); // Password
            statement.setBoolean(5, Boolean.parseBoolean(params[4])); // isDoctor
            statement.setInt(6, Integer.parseInt(params[5])); // Medical License Number
            statement.setString(7, params[6]); // Specialization
            statement.setInt(8, doctor.getDrId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Doctor doctor) {
        String sql = "DELETE FROM doctor WHERE dr_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, doctor.getDrId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Doctor getDoctorById(int dr_id) {
        String sql = "SELECT * FROM doctor WHERE dr_id = ?";
        DatabaseConnection dbConnection = new DatabaseConnection();
        try (Connection conn = dbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, dr_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Doctor(
                        rs.getInt("user_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getBoolean("is_doctor"),
                        rs.getInt("dr_id"),
                        rs.getString("medLicenseNum"),
                        rs.getString("specialization")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<User> getPatientsByDoctorId(int dr_id) {
        String sql = "SELECT user_id FROM health_data WHERE dr_id = ?";
        List<Integer> userIds = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, dr_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                userIds.add(resultSet.getInt("user_id"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    
        List<User> patients = new ArrayList<>();
        sql = "SELECT * FROM users WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (Integer userId : userIds) {
                statement.setInt(1, userId);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    User patient = new User(
                            resultSet.getInt("user_id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getString("email"),
                            resultSet.getString("password"),
                            resultSet.getBoolean("is_doctor")
                    );
                    patients.add(patient);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    
        return patients;
    }

    public void addHealthDataByUserId(int userId, HealthData healthData) {
        healthData.setUserId(userId);
        HealthDataDao healthDataDao = new HealthDataDao();
        healthDataDao.save(healthData);
    }

    // public static void main(String[] args) {
        // DatabaseConnection dbConnection = new DatabaseConnection();
        // Connection connection = dbConnection.getConnection();
        // DoctorDao userDao = new DoctorDao(connection);
    
        // List<User> patients = userDao.getPatientsByDoctorId(1);
        // for (User patient : patients) {
        //     System.out.println("Patient: " + patient);
        // }

        // public static void main(String[] args) {
        //     DatabaseConnection dbConnection = new DatabaseConnection();
        //     Connection connection = dbConnection.getConnection();
        //     DoctorDao doctorDao = new DoctorDao(connection);
        
            // Doctor doctor = doctorDao.getDoctorById(1);
            // if (doctor != null) {
            //     System.out.println(doctor);
            // } else {
            //     System.out.println("No doctor found with the provided ID.");
            // }

            public static void main(String[] args) {
                DatabaseConnection dbConnection = new DatabaseConnection();
                Connection connection = dbConnection.getConnection();
                DoctorDao doctorDao = new DoctorDao(connection);
            
                HealthData healthData = new HealthData(5, 5, "female", 25, 150, 175, 65, 110, "120/80", 5.5, 5000, 50, 7, "2021-10-10", "Tylenol, Propranolol", "Peanuts", "Hypertension", 3);
                doctorDao.addHealthDataByUserId(5, healthData);
            }
    }
