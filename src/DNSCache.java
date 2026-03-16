import java.util.*;

class DNSEntry {
    String ip;
    long expiry;

    DNSEntry(String ip, long ttl) {
        this.ip = ip;
        this.expiry = System.currentTimeMillis() + ttl;
    }
}

public class DNSCache {

    private HashMap<String, DNSEntry> cache = new HashMap<>();

    public String resolve(String domain) {
        if (cache.containsKey(domain)) {
            DNSEntry entry = cache.get(domain);

            if (System.currentTimeMillis() < entry.expiry) {
                return "Cache HIT: " + entry.ip;
            } else {
                cache.remove(domain);
            }
        }

        String newIP = "192.168.1." + new Random().nextInt(100);
        cache.put(domain, new DNSEntry(newIP, 5000));
        return "Cache MISS: " + newIP;
    }

    public static void main(String[] args) {
        DNSCache dns = new DNSCache();

        System.out.println(dns.resolve("google.com"));
        System.out.println(dns.resolve("google.com"));
    }
}