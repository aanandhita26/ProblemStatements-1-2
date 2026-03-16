import java.util.*;

public class UsernameChecker {

    private HashMap<String, Integer> users = new HashMap<>();
    private HashMap<String, Integer> attempts = new HashMap<>();

    public boolean checkAvailability(String username) {
        attempts.put(username, attempts.getOrDefault(username, 0) + 1);
        return !users.containsKey(username);
    }

    public void registerUser(String username, int userId) {
        users.put(username, userId);
    }

    public List<String> suggestAlternatives(String username) {
        List<String> list = new ArrayList<>();
        list.add(username + "1");
        list.add(username + "2");
        list.add(username + "_123");
        return list;
    }

    public String getMostAttempted() {
        String maxUser = "";
        int max = 0;

        for (String key : attempts.keySet()) {
            if (attempts.get(key) > max) {
                max = attempts.get(key);
                maxUser = key;
            }
        }
        return maxUser;
    }

    public static void main(String[] args) {
        UsernameChecker u = new UsernameChecker();

        u.registerUser("john", 1);

        System.out.println(u.checkAvailability("john"));
        System.out.println(u.checkAvailability("jane"));
        System.out.println(u.suggestAlternatives("john"));
    }
}