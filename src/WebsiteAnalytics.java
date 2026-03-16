import java.util.*;

public class WebsiteAnalytics {

    HashMap<String, Integer> pageViews = new HashMap<>();
    HashMap<String, Set<String>> uniqueUsers = new HashMap<>();
    HashMap<String, Integer> sources = new HashMap<>();

    public void processEvent(String url, String userId, String source) {

        pageViews.put(url, pageViews.getOrDefault(url, 0) + 1);

        uniqueUsers.putIfAbsent(url, new HashSet<>());
        uniqueUsers.get(url).add(userId);

        sources.put(source, sources.getOrDefault(source, 0) + 1);
    }

    public void showDashboard() {
        System.out.println("Page Views: " + pageViews);
        System.out.println("Traffic Sources: " + sources);
    }

    public static void main(String[] args) {
        WebsiteAnalytics w = new WebsiteAnalytics();

        w.processEvent("/news", "u1", "google");
        w.processEvent("/news", "u2", "facebook");

        w.showDashboard();
    }
}