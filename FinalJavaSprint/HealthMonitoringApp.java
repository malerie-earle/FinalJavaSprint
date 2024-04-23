package FinalJavaSprint;

public class HealthMonitoringApp {
    public static void main(String[] args) {
    
    // Test A
        // Register a New User
        // UserDao userDao = new UserDao(connection);
        // User newUser = new User("Malerie", "Earle", "malerie.earle@keyin.com", "password", false);
        // userDao.createUser(newUser);
        // System.out.println("User registered successfully");
    
    // Test B
        // Log In New User
        // UserDao userDao = new UserDao(connection);
        // boolean isAuthenticated = userDao.authenticateUser("malerie.earle@keyin.com", "password");
        // if (isAuthenticated) {
        //     System.out.println("User is authenticated");
        // } else {
        //     System.out.println("User is not authenticated");
        // }

    // Test C
        // Add Health Data
        // HealthDataDao healthDataDao = new HealthDataDao();  
        // HealthData healthData = new HealthData(22, 22, "Female", 33, 82.0, 150.0, 80, 100, "120/80", 5.0, 10000, 30, 8, "2021-10-01", "Ibuprofen, Birth Control", "Amoxicillin", "Fibromyalgia", 1);
        // healthDataDao.save(healthData);
        // System.out.println("Health data added successfully");

    // Test D
        // Generate Recommendations
        // RecommendationSystem recommendationSystem = new RecommendationSystem();
        // HealthData healthData = new HealthData(15, 14, "Male", 33, 80.0, 175.0, 70, 100, "120/80", 4.9, 9500, 30, 7, "2021-10-12", "Vitamin C", "None", "None", 3);
        // List<String> recommendations = recommendationSystem.generateRecommendations(healthData);
        // // recommendationSystem.addRecommendationsToDatabase(1, recommendations);
        // System.out.println("Recommendations:" + recommendations);
    
    // Test E
      // Add a Medicine Reminder  
    //   DatabaseConnection db = new DatabaseConnection();
    //   db.getConnection();
    //   MedReminder medicineReminder = new MedReminder(1, 1, "Ibuprofen", "400", "Daily", "2021-10-01", "2021-10-05");
    //   // MedReminderManager.save(medicineReminder);
    //   System.out.println("Medicine reminder added successfully:" + medicineReminder);
    //   List<MedReminder> reminders = MedReminder.getRemindersByUserId(1);
    //   System.out.println("Reminders for user 1: " + reminders);
    // }

    // Test F
        // Get Reminders for a Specific User
        // List<MedReminder> reminders = MedReminderManager.getRemindersByUserId(1);
        // System.out.println("Reminders for user 1: " + reminders);
        
    // Test G
        // Get Doctor By ID
        // DatabaseConnection dbConnection = new DatabaseConnection();
        // Connection connection = dbConnection.getConnection();
        // DoctorDao doctorDao = new DoctorDao(connection);
        // Doctor doctor = doctorDao.getDoctorById(1);
        // if (doctor != null) {
        //     System.out.println(doctor);
        // } else {
        //     System.out.println("No doctor found with the provided ID.");
        // }

    // Test H
        // Get Patients Associated with a Doctor
        // DatabaseConnection dbConnection = new DatabaseConnection();
        // Connection connection = dbConnection.getConnection();
        // DoctorDao userDao = new DoctorDao(connection);
    
        // List<User> patients = userDao.getPatientsByDoctorId(1);
        // for (User patient : patients) {
        //     System.out.println("Patient: " + patient);
        // }}}
    
    
    
    // Test I
        // Get Health Data for a Specific Patient
        // DatabaseConnection dbConnection = new DatabaseConnection();
        // Connection connection = dbConnection.getConnection();
        // HealthDataDao healthDataDao = new HealthDataDao();  
    
        // int userId = 5;  
        // List<HealthData> healthDataList = healthDataDao.getHealthDataByUserId(userId); 
        // if (healthDataList != null && !healthDataList.isEmpty()) {
        //     for (HealthData healthData : healthDataList) {
        //         System.out.println(healthData);
        //     }
        // } else {
        //     System.out.println("No health data found for the provided user ID.");
        // }
    }
}
  



       
    /**
     * To test the Doctor Portal in your Health Monitoring System, provide a simple test code method that you can add
     * to your main application class.
     * In this method, we'll test the following functionalities:
     * 1. Fetching a doctor by ID
     * 2. Fetching patients associated with a doctor
     * 3. Fetching health data for a specific patient
      */
    // public static void testDoctorPortal() {
    //     // Replace the doctorId with a valid ID from your database
    //     int doctorId = 1;

        // Add code to Fetch the doctor by ID

        // Add code to Fetch patients associated with the doctor

        // Add code to Fetch health data for the patient

// }    


    /**
     * To test the login user functionality in your Health Monitoring System, you can
     * add a test method to your main application class
     */
//     public static void testLoginUser() {
//         // Replace the email and password with valid credentials from your database
//         String userEmail = "john@example.com";
//         String userPassword = "password";

//         boolean loginSuccess = loginUser(userEmail, userPassword);

//         if (loginSuccess) {
//             // Print to console, "Login Successful"
//         } else {
//             // Print to console, "Incorrect email or password. Please try again.");
//             // Show an error message and prompt the user to re-enter their credentials
//         }
//     }

// }
