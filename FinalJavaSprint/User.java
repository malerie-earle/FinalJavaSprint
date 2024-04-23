package FinalJavaSprint;

public class User {
  public int user_id;
  public String first_name;
  public String last_name;
  public String email;
  public String password;
  public boolean is_doctor;

  public User(int user_id, String first_name, String last_name, String email, String password, boolean is_doctor) {
      this.user_id = user_id;
      this.first_name = first_name;
      this.last_name = last_name;
      this.email = email;
      this.password = password;
      this.is_doctor = is_doctor;
  }

  public User(String first_name, String last_name, String email, String password, boolean is_doctor) {
      this.first_name = first_name;
      this.last_name = last_name;
      this.email = email;
      this.password = password;
      this.is_doctor = is_doctor;
  }

  public User(String email, String password) {
      this.email = email;
      this.password = password;
  }

  public User(User user) {
      this.user_id = user.user_id;
      this.first_name = user.first_name;
      this.last_name = user.last_name;
      this.email = user.email;
      this.password = user.password;
      this.is_doctor = user.is_doctor;
  }

  public User() {
  }

  public int getUserId() {
    return user_id;
  }

  public void setUserId(int user_id) {
    this.user_id = user_id;
  }

  public String getFirstName() {
    return first_name;
  }

  public void setFirstName(String first_name) {
    this.first_name = first_name;
  }

  public String getLastName() {
      return last_name;
  }

  public void setLastName(String last_name) {
      this.last_name = last_name;
  }

  public String getEmail() {
      return email;
  }

  public void setEmail(String email) {
      this.email = email;
  }

  public String getPassword() {
      return password;
  }

  public void setPassword(String password) {
      this.password = password;
  }

  public boolean is_doctor() {
      return is_doctor;
  }

  public boolean getIsDoctor() {
      return is_doctor;
  }

  public void setIsDoctor(boolean doctor) {
      this.is_doctor = doctor;
  }

  @Override
  public String toString() {
      return "User{" +
              "first_name='" + first_name + '\'' +
              ", last_name='" + last_name + '\'' +
              ", email='" + email + '\'' +
              ", password='" + password + '\'' +
              ", is_doctor=" + is_doctor +
              '}';
  }
}





