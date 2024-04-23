package FinalJavaSprint;
/**
 * This class represents a user in the system.
 */
public class Doctor extends User{
    private int dr_id;
    private String medLicenseNum;
    private String specialization;
    private String patient_list;

    public Doctor(int user_id, String firstName, String lastName, String email, String password, boolean isDoctor, int dr_id, String medLicenseNum, String specialization, String patient_list) {
        super(user_id, firstName, lastName, email, password, isDoctor);
        this.dr_id = dr_id;
        this.medLicenseNum = medLicenseNum;
        this.specialization = specialization;
        this.patient_list = patient_list;
    }

    public Doctor(int user_id, String firstName, String lastName, String email, String password, boolean isDoctor, int dr_id, String medLicenseNum, String specialization) {
        super(user_id, firstName, lastName, email, password, isDoctor);
        this.dr_id = dr_id;
        this.medLicenseNum = medLicenseNum;
        this.specialization = specialization;
    }

    public Doctor(String email, String password) {
        super(email, password);
    }

    public Doctor(User user, int dr_id, String medLicenseNum, String specialization, String patient_list) {
        super(user);
        this.dr_id = dr_id;
        this.medLicenseNum = medLicenseNum;
        this.specialization = specialization;
        this.patient_list = patient_list;
    }

    public Doctor() {
        super();
    }

    public Doctor(int dr_id, String medLicenseNum, String specialization) {
        this.dr_id = dr_id;
        this.medLicenseNum = medLicenseNum;
        this.specialization = specialization;
    }

    public Doctor(int dr_id, String medLicenseNum, String specialization, String patient_list) {
        this.dr_id = dr_id;
        this.medLicenseNum = medLicenseNum;
        this.specialization = specialization;
        this.patient_list = patient_list;
    }

    // Getters and setters for the new properties
    public int getDrId() {
        return dr_id;
    }

    public void setDrId(int dr_id) {
        this.dr_id = dr_id;
    }

    public String getMedLicenseNum() {
        return medLicenseNum;
    }

    public void setMedLicenseNum(String medLicenseNum) {
        this.medLicenseNum = medLicenseNum;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getPatientList() {
        return patient_list;
    }

    public void setPatientList(String patient_list) {
        this.patient_list = patient_list;
    }

    // Overriding the toString method
    @Override
    public String toString() {
        return "Doctor{" +
                "medicalLicenseNumber='" + medLicenseNum + '\'' +
                ", specialization='" + specialization + '\'' +
                "} " + super.toString();
    }
    
}


