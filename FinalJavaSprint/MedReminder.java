package FinalJavaSprint;

public class MedReminder {
  private int med_id;
  private int user_id;
  private String med_name;
  private String dosage;
  private String schedule;
  private String startDate;
  private String endDate;

    public MedReminder(int med_id, int user_id, String med_name, String dosage, String schedule, String startDate, String endDate) {
      this.med_id = med_id;
      this.user_id = user_id;
      this.med_name = med_name;
      this.dosage = dosage;
      this.schedule = schedule;
      this.startDate = startDate;
      this.endDate = endDate;
  }

    public MedReminder(int user_id, String med_name, String dosage, String schedule, String startDate, String endDate) {
      this.user_id = user_id;
      this.med_name = med_name;
      this.dosage = dosage;
      this.schedule = schedule;
      this.startDate = startDate;
      this.endDate = endDate;
  }

    public MedReminder(MedReminder medReminder) {
      this.med_id = medReminder.med_id;
      this.user_id = medReminder.user_id;
      this.med_name = medReminder.med_name;
      this.dosage = medReminder.dosage;
      this.schedule = medReminder.schedule;
      this.startDate = medReminder.startDate;
      this.endDate = medReminder.endDate;
  }

    public MedReminder() {
			//TODO Auto-generated constructor stub
		}

		public int getMedId() {
      return med_id;
    }

    public void setMedId(int med_id) {
      this.med_id = med_id;
    }

    public int getUserId() {
      return user_id;
    }

    public void setUserId(int user_id) {
      this.user_id = user_id;
    }

    public String getMedName() {
      return med_name;
    }

    public void setMedName(String med_name) {
      this.med_name = med_name;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "MedReminder{" +
                "med_id=" + med_id +
                ", user_id=" + user_id +
                ", med_name='" + med_name + '\'' +
                ", dosage='" + dosage + '\'' +
                ", schedule='" + schedule + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    
  }

  
