import java.util.*;

public class PlagiarismDetector {

    private HashMap<String, Set<String>> ngramMap = new HashMap<>();

    public void addDocument(String docId, String text) {
        String[] words = text.split(" ");

        for (int i = 0; i < words.length - 2; i++) {
            String gram = words[i] + " " + words[i + 1] + " " + words[i + 2];

            ngramMap.putIfAbsent(gram, new HashSet<>());
            ngramMap.get(gram).add(docId);
        }
    }

    public void checkDocument(String docId, String text) {
        int matches = 0;
        String[] words = text.split(" ");

        for (int i = 0; i < words.length - 2; i++) {
            String gram = words[i] + " " + words[i + 1] + " " + words[i + 2];

            if (ngramMap.containsKey(gram)) {
                matches++;
            }
        }

        System.out.println("Matching n-grams: " + matches);
    }

    public static void main(String[] args) {
        PlagiarismDetector p = new PlagiarismDetector();

        p.addDocument("doc1", "this is a sample document for test");
        p.checkDocument("doc2", "this is a sample text");
    }
}