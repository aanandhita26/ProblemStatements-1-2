import java.util.*;

class TokenBucket {
    int tokens;
    long lastTime;

    TokenBucket(int max) {
        tokens = max;
        lastTime = System.currentTimeMillis();
    }
}

public class RateLimiter {

    HashMap<String, TokenBucket> clients = new HashMap<>();
    int LIMIT = 5;

    public boolean allowRequest(String clientId) {

        clients.putIfAbsent(clientId, new TokenBucket(LIMIT));
        TokenBucket bucket = clients.get(clientId);

        if (bucket.tokens > 0) {
            bucket.tokens--;
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        RateLimiter r = new RateLimiter();

        for (int i = 0; i < 7; i++) {
            System.out.println(r.allowRequest("client1"));
        }
    }
}