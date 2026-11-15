
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

















































































































/*
 * THEORY:
 * 
 * Huffman Encoding is a lossless data compression technique used
 * to reduce the size of data. It assigns shorter binary codes to
 * characters that occur more frequently and longer codes to
 * characters that occur less frequently.
 * 
 * 1. Greedy Strategy:
 * Huffman Encoding uses a Greedy Strategy. It selects the two
 * characters or nodes having the smallest frequencies and combines
 * them into a new node. This process is repeated until only one
 * node remains.
 * 
 * 2. Huffman Tree:
 * A Huffman Tree is a binary tree used to generate Huffman codes.
 * Leaf nodes represent characters, and internal nodes represent
 * the combined frequencies of characters.
 * 
 * 3. Working:
 * - Calculate the frequency of each character.
 * - Insert all characters into a priority queue.
 * - Select the two nodes with the smallest frequencies.
 * - Combine their frequencies and create a new node.
 * - Repeat until only one node remains.
 * - Assign 0 to the left branch and 1 to the right branch.
 * - Generate the binary code for each character.
 * 
 * 4. Example:
 * 
 * Character Frequency
 * A 5
 * B 9
 * C 12
 * D 13
 * 
 * First, combine A(5) and B(9) = 14.
 * Next, combine C(12) and D(13) = 25.
 * Then, combine 14 and 25 = 39.
 * 
 * The final node becomes the root of the Huffman Tree.
 * 
 * 5. Lossless Compression:
 * Huffman Encoding is called lossless compression because the
 * original data can be recovered without losing any information.
 * 
 * 6. Time Complexity:
 * Building the Huffman Tree takes O(n log n) time, where n is
 * the number of unique characters.
 * 
 * 7. Space Complexity:
 * The space complexity is O(n) for storing the Huffman Tree
 * and character codes.
 * 
 * 8. Applications:
 * - ZIP file compression.
 * - JPEG image compression.
 * - Data transmission.
 * - File compression systems.
 * 
 * Conclusion:
 * Huffman Encoding uses a Greedy Strategy to generate variable-length
 * binary codes based on character frequencies. It reduces data size
 * and allows the original data to be recovered without information loss.
 */