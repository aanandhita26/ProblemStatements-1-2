import java.util.*;

public class MultiLevelCache {

    HashMap<String, String> L1 = new HashMap<>();
    HashMap<String, String> L2 = new HashMap<>();
    HashMap<String, String> L3 = new HashMap<>();

    public String getVideo(String id) {

        if (L1.containsKey(id)) {
            return "L1 Cache HIT";
        }

        if (L2.containsKey(id)) {
            L1.put(id, L2.get(id));
            return "L2 Cache HIT";
        }

        if (L3.containsKey(id)) {
            L2.put(id, L3.get(id));
            return "L3 Database HIT";
        }

        return "Video not found";
    }

    public static void main(String[] args) {

        MultiLevelCache c = new MultiLevelCache();

        c.L3.put("video1", "data");

        System.out.println(c.getVideo("video1"));
        System.out.println(c.getVideo("video1"));
    }
}