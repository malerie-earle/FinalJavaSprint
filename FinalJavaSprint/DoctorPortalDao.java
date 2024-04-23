package FinalJavaSprint;

import java.util.List;

public class DoctorPortalDao {
    private DoctorDao doctorDao;
    private UserDao userDao;
    private HealthDataDao healthDataDao;

    public DoctorPortalDao() {
        userDao = new UserDao();
        healthDataDao = new HealthDataDao();
    }

    public List<User> getPatientsByDoctorId(int doctorId) {
        return userDao.getPatientsByDoctorId(doctorId);
    }

    public void addHealthData(HealthData healthData) {
        healthDataDao.save(healthData);
    }

    public void addHealthDataByUserId(int userId, HealthData healthData) {
        healthData.setUserId(userId);
        healthDataDao.save(healthData);
    }
}
