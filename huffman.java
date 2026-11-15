
import java.util.*;

class Node {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

public class huffman {

    static void printCodes(Node root, String code,
            Map<Character, String> codes) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            codes.put(root.ch, code);
            System.out.println(root.ch + " : " + code);
            return;
        }

        printCodes(root.left, code + "0", codes);
        printCodes(root.right, code + "1", codes);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        // Count character frequency
        Map<Character, Integer> freq = new TreeMap<>();

        for (char c : text.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Create priority queue
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> {
                    int result = Integer.compare(a.freq, b.freq);
                    if (result == 0)
                        return Character.compare(a.ch, b.ch);
                    return result;
                });

        for (char c : freq.keySet()) {
            pq.add(new Node(c, freq.get(c)));
        }

        // Build Huffman tree using greedy method
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            Node parent = new Node('\0',
                    left.freq + right.freq);

            parent.left = left;
            parent.right = right;

            pq.add(parent);
        }

        Node root = pq.poll();

        // Generate Huffman codes
        Map<Character, String> codes = new HashMap<>();

        System.out.println("Huffman Codes:");
        printCodes(root, "", codes);

        // Encode the input string
        StringBuilder encoded = new StringBuilder();

        for (char c : text.toCharArray()) {
            encoded.append(codes.get(c));
        }

        System.out.println("Encoded String: " + encoded);

        sc.close();
    }
}
