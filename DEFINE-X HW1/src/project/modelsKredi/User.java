package project.modelsKredi;

import java.security.MessageDigest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;
    private String address;
    private LocalDate ageDate;
    private boolean isActive;
    private List<Application> applicationList = new ArrayList<>();
    private static UserRepository userRepository = UserRepository.getInstance();

    // constructor
    public User(String name, String surname, String email, String password, String phone, String address,
            LocalDate ageDate, boolean isActive) {
        if (checkSimilarEmail(email)) {
            System.out.println("This email is already in use. Please try another one.");
            return;
        }
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = getSHA512Password(password);
        this.phone = phone;
        this.address = address;
        this.ageDate = ageDate;
        this.isActive = isActive;
        userRepository.addUser(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getAge() {
        return ageDate;
    }

    public void setAge(LocalDate ageDate) {
        this.ageDate = ageDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public List<Application> getApplicationList() {
        return applicationList;
    }

    public void setApplicationList(List<Application> applicationList) {
        this.applicationList = applicationList;
    }

    public void addApplication(Application application) {

        this.applicationList.add(application);
    }

    // method to get SHA512 password
    private String getSHA512Password(String password) {
        // SecureRandom random = new SecureRandom();
        // byte[] salt = new byte[16];
        // random.nextBytes(salt);

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            // md.update(salt);
            byte[] hashedPassword = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte i : hashedPassword) {
                sb.append(Integer.toString((i & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public boolean checkSimilarEmail(String email) {
        if (userRepository.getUserByEmail(email) != null) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
