package FinalJavaSprint;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecommendationSystem {
    private static final int MIN_REST_HEART_RATE = 60;
    private static final int MAX_REST_HEART_RATE = 100;
    private static final int MIN_STEPS = 10000;
    private static final double MIN_BMI = 18.5;
    private static final double HEALTHY_BMI = 18- 24.9;
    private static final double OVERWEIGHT_BMI = 25 - 29.9;
    private static final double OBESE_BMI = 30 - 34.9;
    private Connection connection;

    HealthData healthData = new HealthData(1, 1, "Female", 33, 82, 150, 80, 120, "120/80", 5.0, 10000, 30, 8, "2021-10-01", "Ibuprofen, Birth Control", "Amoxicillin", "Fibromyalgia", 1);
 

    public List<String> generateRecommendations(HealthData healthData) {
        List<String> recommendations = new ArrayList<>();
        
        // Recommended heart rate
        recommendations.add("The recommended resting heart rate is between 60 and 100 beats per minute." + "Generally, a lower heart rate at rest implies more efficient heart function and better cardiovascular fitness.");

        // Analyze Resting Heart Rate
        int restHeartRate = healthData.getRestHeartRate();
        if (restHeartRate < MIN_REST_HEART_RATE) {
            recommendations.add("Your heart rate is lower than the recommended range. " +
                    "Consider increasing your physical activity to improve your cardiovascular health.");
        } else if (restHeartRate > MAX_REST_HEART_RATE) {
            recommendations.add("Your heart rate is higher than the recommended range. " +
                    "Consider reducing stress and incorporating relaxation techniques into your daily routine.");
        }

        // Analyze Active Heart Rate
        int activeHeartRate = healthData.getActiveHeartRate();
        int AGE = healthData.getAge();
        double MAX_HEART_RATE = 220 - AGE;
        double LOW_TARGET_HEART_RATE = MAX_HEART_RATE * 0.64;
        double HIGH_TARGET_HEART_RATE = MAX_HEART_RATE * 0.76;
        
        // MAX heart rate
        recommendations.add("Your maximum heart rate is " + MAX_HEART_RATE + " beats per minute.");
        
        // Target heart rate zone
        recommendations.add("Your target heart rate zone is between " + LOW_TARGET_HEART_RATE + " and " + HIGH_TARGET_HEART_RATE + " beats per minute.");
        
        // Check if active heart rate is within target range
        if (activeHeartRate < LOW_TARGET_HEART_RATE) {
            recommendations.add("Your target heart rate is below the recommended range." +
                    "Consider adjusting your exercise intensity to stay within the target heart rate zone.");
        } else if (activeHeartRate > HIGH_TARGET_HEART_RATE) {
            recommendations.add("Your target heart rate is above the recommended range." +
                    "Consider adjusting your exercise intensity to stay within the target heart rate zone.");
        }
        // Recommendations
        recommendations.add("The recommended blood pressure is below 120/80 mm Hg.");

        // Recommendations for blood pressure
        String bloodPressure = healthData.getBloodPressure();
        String[] parts = bloodPressure.split("/");
        int systolic = Integer.parseInt(parts[0]);
        int diastolic = Integer.parseInt(parts[1]);

        if (systolic > 120 || diastolic > 80) {
            recommendations.add("Your blood pressure is above the recommended range. " +
                    "Consider monitoring your blood pressure regularly and consulting with a healthcare provider.");
        } else if (120 < systolic && systolic < 129 || diastolic < 80) {
            recommendations.add("Your blood pressure is in the elevated hypertensive range. " +
                    "Consider consulting with a healthcare provider to address any potential health concerns.");
        } else if (130 < systolic && systolic < 139 || 80 < diastolic && diastolic < 89) {
            recommendations.add("Your blood pressure is in the hypertensive range - stage 1. " +
                    "Consider consulting with a healthcare provider to address any potential health concerns.");
        } else if (systolic >= 140 || diastolic >= 90) {
            recommendations.add("Your blood pressure is in the severely hypertensive - stage 2 range. " +
                    "Consider consulting with a healthcare provider to address any potential health concerns.");
        } else if (systolic >= 180 || diastolic >= 120) {
            recommendations.add("Your blood pressure is in the hypertensive crisis range. " +
                    "Seek immediate medical attention.");
        }

        // Analyze blood sugar levels
        double bloodSugar = healthData.getBloodSugar();
        AGE = healthData.getAge();

        // Before Meal Blood Sugar
        if (AGE < 18 && bloodSugar < 7 && bloodSugar > 3.5) {
            recommendations.add("Your blood sugar level is within the recommended range for children. " + "Keep up the good work!");
        } else if (AGE >= 18 && bloodSugar < 6.1) {
            recommendations.add("Your blood sugar level is within the recommended range for adults. " + "Keep up the good work!");
        } else if (bloodSugar >= 10) {
            recommendations.add("Your blood sugar level is HIGHER than the recommended range." + "Consider consulting with a healthcare provider to address any potential health concerns.");
        } else if (bloodSugar <= 13) {
        recommendations.add("Your blood sugar level is HIGHER than recommended, consider getting immediate medical attention.");
        } else if (bloodSugar <= 3.5) {
        recommendations.add("Your blood sugar level is LOWER than recommended, consider getting immediate medical attention.");
        }

        // Analyze steps
        int steps = healthData.getSteps();
        if (steps < MIN_STEPS) {
            recommendations.add("You're not reaching the recommended daily step count. " +
                    "Try to incorporate more walking or other physical activities into your daily routine.");
        }

        // Analyze cardio minutes
        int cardioMinutes = healthData.getCardioMinutes();
        if (cardioMinutes < 150) {
            recommendations.add("You're not reaching the recommended weekly cardio minutes. " +
                    "Try to incorporate more cardiovascular exercises into your weekly routine.");
        }

        // Analyze hours slept
        int hoursSlept = healthData.getHoursSlept();
        if (hoursSlept < 7) {
            recommendations.add("You're not getting enough sleep. " +
                    "Consider improving your sleep hygiene and creating a bedtime routine to ensure adequate rest.");
        } else if (hoursSlept > 7 && hoursSlept < 9) {
            recommendations.add("You're getting enough sleep according to experts. " +
                    "Keep up the good work!");
        } else if (hoursSlept > 9) {
                recommendations.add("You're getting more sleep than recommended. " +
                        "Consider adjusting your sleep schedule to ensure quality rest.");
        }
        
        // Analyze BMI
        double weight = healthData.getWeight(); // Must be in kg
        double height = healthData.getHeight(); // Must be in meters
        double BMI = weight / (height * height);
        if (BMI < MIN_BMI) {
            recommendations.add("Your BMI is below the healthy range. " +
                    "Consider consulting with a healthcare provider to address any potential health concerns.");
        } else if (BMI == HEALTHY_BMI) {
            recommendations.add("Your BMI is within the healthy range. " +
                    "Keep up the good work!");
        } else if (BMI >= OVERWEIGHT_BMI) {
            recommendations.add("Your BMI is above the healthy range. " +
                    "Consider consulting with a healthcare provider to address any potential health concerns.");
        } else if (BMI >= OBESE_BMI) {
            recommendations.add("Your BMI is in the obese range. " +
                    "Consider consulting with a healthcare provider to address any potential health concerns.");
        }

        return recommendations;
    }

    public void addRecommendationsToDatabase(int userId, List<String> recommendations) {
        String sql = "INSERT INTO recommendations (user_id, recommendation) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (String recommendation : recommendations) {
                statement.setInt(1, userId);
                statement.setString(2, recommendation);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }

    