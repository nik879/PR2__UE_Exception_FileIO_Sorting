package Exceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MessengerService {
    private HashMap<String, User> users =new HashMap<>();
    private ArrayList<Message> history =new ArrayList<>();

    public void registerUser(User user) throws UserAlreadyExistsException {
        if (users.containsKey(user.getName())) {
            throw new UserAlreadyExistsException("The user " + user.getName() + " allready " +
                    "exists!");
        }
        users.put(user.getName(), user);
    }

    public void unregisterUser(User user) throws UserNotFoundException {
        if (!users.containsKey(user.getName())) {
            throw new UserNotFoundException("The user " + user.getName() + "does not exist!");
        }
        users.remove(user.getName());
    }

    public void sendDirectMessage(DirectMessage message) throws UserNotFoundException, UserOfflineException {
        if (!users.containsValue(message.getFrom())) {
            throw new UserNotFoundException("The user " + message.getFrom().getName() + " cannot " +
                    "be " + "found");
        }
        if (!users.containsValue(message.getTo())) {
            throw new UserNotFoundException("The user " + message.getTo().getName() + " cannot " + "be " + "found");
        }
        if (!message.getTo().getStatus().equals(User.STATUS_ONLINE)) {
            throw new UserOfflineException("The user " + message.getTo().getName() + " is offline");
        }
        System.out.println(message);
        history.add(message);
    }

    public void sendBroadcastMessage(BroadcastMessage message) throws UserNotAdminException {
        if (!message.getFrom().isAdmin() == true) {
            throw new UserNotAdminException("The user " + message.getFrom().getName() + " is not "
                    + "a " + "Admin");
        }
        for (Map.Entry<String, User> stringUserEntry : users.entrySet()) {
            if (!stringUserEntry.getValue().equals(message.getFrom())) {
                System.out.println(stringUserEntry.getKey());
            }
        }
        System.out.println(message);
        history.add(message);
    }
}
