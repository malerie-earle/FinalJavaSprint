package FinalJavaSprint;

public class HealthData {
    private int health_id;
    private int user_id;
    private String gender;
    private int age;
    private double weight;
    private double height;
    private int restHeartRate;
    private int activeHeartRate;
    private String bloodPressure;
    private double bloodSugar;
    private int steps;
    private int cardioMinutes;
    private int hoursSlept;
    private String date;
    private String medList;
    private String allergies;
    private String medHistory;
    private int dr_id;

    // Constructor
    public HealthData(int health_id, int user_id, String gender, int age, double weight, double height, int restHeartRate, int activeHeartRate, String bloodPressure, double bloodSugar, int steps, int cardioMinutes, int hoursSlept, String date, String medList, String allergies, String medHistory, int dr_id) {
        this.health_id = health_id;
        this.user_id = user_id;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.restHeartRate = restHeartRate;
        this.activeHeartRate = activeHeartRate;
        this.bloodPressure = bloodPressure;
        this.bloodSugar = bloodSugar;
        this.steps = steps;
        this.cardioMinutes = cardioMinutes;
        this.hoursSlept = hoursSlept;
        this.date = date;
        this.medList = medList;
        this.allergies = allergies;
        this.medHistory = medHistory;
        this.dr_id = dr_id;
    }



    // Constructor - med info, vital signs, daily activities
    public HealthData(int health_id, int user_id, String gender, int age, double weight, double height, int restHeartRate, int activeHeartRate, String bloodPressure, double bloodSugar, int steps, int cardioMinutes, int hoursSlept, String date) {
        this.health_id = health_id;
        this.user_id = user_id;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.restHeartRate = restHeartRate;
        this.activeHeartRate = activeHeartRate;
        this.bloodPressure = bloodPressure;
        this.bloodSugar = bloodSugar;
        this.steps = steps;
        this.cardioMinutes = cardioMinutes;
        this.hoursSlept = hoursSlept;
        this.date = date;
    }

    // Constructor with daily activities
    public HealthData(int health_id, int user_id, int restHeartRate, int activeHeartRate, String bloodPressure, int bloodSugar, int steps, int cardioMinutes, int hoursSlept, String date) {
        this.health_id = health_id;
        this.user_id = user_id;
        this.restHeartRate = restHeartRate;
        this.activeHeartRate = activeHeartRate;
        this.bloodPressure = bloodPressure;
        this.bloodSugar = bloodSugar;
        this.steps = steps;
        this.cardioMinutes = cardioMinutes;
        this.hoursSlept = hoursSlept;
        this.date = date;
    }

    // Constructor with medical history, and medical information
    public HealthData(int health_id, int user_id, String gender, int age, double weight, double height, String date, String medList, String allergies, String medHistory, int dr_id) {
        this.health_id = health_id;
        this.user_id = user_id;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.date = date;
        this.medList = medList;
        this.allergies = allergies;
        this.medHistory = medHistory;
        this.dr_id = dr_id;
    }

    // Constructor with medical history
    public HealthData(int health_id, int user_id, String allergies, String medHistory, String date) {
        this.health_id = health_id;
        this.user_id = user_id;
        this.allergies = allergies;
        this.medHistory = medHistory;
        this.date = date;
    }

    // Constructor with vital signs
    public HealthData(int health_id, int user_id, int restHeartRate, int activeHeartRate, String bloodPressure, double bloodSugar, String date) {
        this.health_id = health_id;
        this.user_id = user_id;
        this.restHeartRate = restHeartRate;
        this.activeHeartRate = activeHeartRate;
        this.bloodPressure = bloodPressure;
        this.bloodSugar = bloodSugar;
        this.date = date;
    }

  public String getMedReminders() {
        return medList;
    }

    public int getHealthId() {
        return health_id;
    }

    public void setHealthId(int health_id) {
        this.health_id = health_id;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getRestHeartRate() {
        return restHeartRate;
    }

    public void setRestHeartRate(int restHeartRate) {
        this.restHeartRate = restHeartRate;
    }

    public int getActiveHeartRate() {
        return activeHeartRate;
    }

    public void setActiveHeartRate(int activeHeartRate) {
        this.activeHeartRate = activeHeartRate;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public double getBloodSugar() {
        return bloodSugar;
    }

    public void setBloodSugar(double bloodSugar) {
        this.bloodSugar = bloodSugar;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getCardioMinutes() {
        return cardioMinutes;
    }

    public void setCardioMinutes(int cardioMinutes) {
        this.cardioMinutes = cardioMinutes;
    }

    public int getHoursSlept() {
        return hoursSlept;
    }

    public void setHoursSlept(int hoursSlept) {
        this.hoursSlept = hoursSlept;
    }

    public String getLocalDate() {
        return date;
    }

    public void setLocalDate(String date) {
        this.date = date;
    }

    public String getMedList() {
        return medList;
    }
    
    public void setMedList(String medList) {
        this.medList = medList;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getMedHistory() {
        return medHistory;
    }

    public void setMedHistory(String medHistory) {
        this.medHistory = medHistory;
    }

    public int getDrId() {
        return dr_id;
    }

    public void setDrId(int dr_id) {
        this.dr_id = dr_id;
    }

    @Override
    public String toString() {
        return "HealthData{" +
                "health_id=" + health_id +
                ", user_id=" + user_id +
                ", gender=" + gender +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                ", restHeartRate=" + restHeartRate +
                ", activeHeartRate=" + activeHeartRate +
                ", bloodPressure=" + bloodPressure +
                ", bloodSugar=" + bloodSugar +
                ", steps=" + steps +
                ", cardioMinutes=" + cardioMinutes +
                ", hoursSlept=" + hoursSlept +
                ", date=" + date +
                ", medList=" + medList +
                ", allergies=" + allergies +
                ", medHistory=" + medHistory +
                ", dr_id=" + dr_id +
                '}';
}
    }
