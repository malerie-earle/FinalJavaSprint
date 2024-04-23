package FinalJavaSprint;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedReminderManager {
    private String med_list;
    private List<User> userList;

    public MedReminder addMedReminder(int user_id, String med_name, String dosage, String schedule, String start_date, String end_date) {
        MedReminder newReminder = new MedReminder();
        newReminder.setUserId(user_id);
        newReminder.setMedName(med_name);
        newReminder.setDosage(dosage);
        newReminder.setSchedule(schedule);
        newReminder.setStartDate(start_date);
        newReminder.setEndDate(end_date);
        User user = findUserById(user_id);
        if (user != null) {
            newReminder.setUserId(user_id);
        } else {
            System.out.println("User not found");
        }
        med_list.add(newReminder);
        return newReminder;
    }

    private User findUserById(int user_id) {
        for (User user : userList) {
            if (user.getUserId() == user_id) {
                return user;
            }
        }
        return null;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public String getMedList() {
        return med_list;
    }

    public void setMedList(String med_list) {
        this.med_list = med_list;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public static List<MedReminder> getRemindersByUserId(int user_id) {
        String sql = "SELECT * FROM med_reminder WHERE user_id = ?";
        List<MedReminder> reminders = new ArrayList<>();
        try {
            DatabaseConnection dbConnection = new DatabaseConnection();
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, user_id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                MedReminder reminder = new MedReminder(
                    rs.getInt("med_id"),
                    rs.getInt("user_id"),
                    rs.getString("med_name"),
                    rs.getString("dosage"),
                    rs.getString("schedule"),
                    rs.getString("start_date"),
                    rs.getString("end_date")
                );
                reminders.add(reminder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reminders;
    }
}
