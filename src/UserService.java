
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private final List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public List<User> listAll() {
        return new ArrayList<>(users);
    }

    public void viewUsers() {
        for (User u : users) {
            System.out.println(u.getName() + " - Role: " + u.getSubscription());
        }
    }

    public void updateRole(User user, Subscription subscription) {
        user.setSubscription(subscription);
    }

    public void setShippingAddress(User user, Address address) {
        user.setShippingAddress(address);
    }

    public void setBillingAddress(User user, Address address) {
        user.setBillingAddress(address);
    }
}
