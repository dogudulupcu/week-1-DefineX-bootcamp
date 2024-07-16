package project.modelsKredi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static UserRepository instance;
    private List<User> users = new ArrayList<>();

    private UserRepository() {
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public List<Application> getMaxApplicationUser(String email) {
        User user = getUserByEmail(email);
        if (user == null)
            return null;
        return user.getApplicationList();

    }

    public User getMaxApplicationUser() {
        User maxUser = users.get(0);
        for (User user : users) {
            if (user.getApplicationList().size() > maxUser.getApplicationList().size()) {
                maxUser = user;
            }
        }
        return maxUser;
    }

    public Application getMaxApplication() {
        Application maxApplication = users.get(0).getApplicationList().get(0);
        for (User user : users) {
            for (Application application : user.getApplicationList()) {
                if (application.getLoanAmount() == null)
                    continue;
                if (application.getLoanAmount().compareTo(maxApplication.getLoanAmount()) > 0) {
                    maxApplication = application;
                }
            }
        }
        return maxApplication;
    }

    public List<Application> getApplicationsInThisMonth() {
        List<Application> applications = new ArrayList<>();
        for (User user : users) {
            for (Application application : user.getApplicationList()) {
                if ((application.getLocalDateTime().isAfter(LocalDate.now().minusMonths(1))
                        || application.getLocalDateTime().isEqual(LocalDate.now().minusMonths(1)))
                        && (application.getLocalDateTime().isBefore(LocalDate.now())
                                || application.getLocalDateTime().isEqual(LocalDate.now()))) {
                    applications.add(application);
                }
            }
        }
        return applications;
    }

}
