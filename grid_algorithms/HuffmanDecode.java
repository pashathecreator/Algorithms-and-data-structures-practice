import java.util.HashMap;
import java.util.Scanner;

public class HuffmanDecode {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfLetters = in.nextInt();
        int lengthOfHuffmanText = in.nextInt();
        in.nextLine();
        HashMap<Character, String> huffmanCodes = new HashMap<>();
        for (int i = 0; i < numberOfLetters; i++) {
            String[] letterAndCode = in.nextLine().split(": ");
            huffmanCodes.put(letterAndCode[0].charAt(0), letterAndCode[1]);
        }

        HuffmanTreeNode huffmanTreeNode = createHuffmanTree(huffmanCodes);

        String huffmanText = in.nextLine();

        String beforeHuffmanText = getTextFromHuffmanCode(huffmanTreeNode, huffmanText);

        System.out.println(beforeHuffmanText);
    }

    private static String getTextFromHuffmanCode(HuffmanTreeNode huffmanTreeNode, String huffmanText) {
        StringBuilder text = new StringBuilder();
        while (!huffmanText.isEmpty()) {
            LetterAndCode letterAndCode = huffmanTreeNode.getLetter(huffmanText, huffmanTreeNode);
            text.append(letterAndCode.letter);
            huffmanText = letterAndCode.code;

        }

        return text.toString();
    }

    private static HuffmanTreeNode createHuffmanTree(HashMap<Character, String> huffmanCodes) {
        HuffmanTreeNode huffmanTreeNode = new HuffmanTreeNode(null, null);
        for (Character key : huffmanCodes.keySet()) {
            huffmanTreeNode.setCode(key, huffmanCodes.get(key), huffmanTreeNode);
        }

        return huffmanTreeNode;
    }


}

class HuffmanTreeNode {
    Character letter;
    String code;
    HuffmanTreeNode left;
    HuffmanTreeNode right;

    public HuffmanTreeNode(Character content, String code) {
        this.letter = content;
        this.code = code;
    }

    public void setCode(Character letter, String code, HuffmanTreeNode huffmanTreeNode) {
        if (code.isEmpty()) {
            huffmanTreeNode.letter = letter;
            return;
        }
        if (code.charAt(0) == '0') {
            if (left == null) {
                left = new HuffmanTreeNode(null, "0");
            }
            code = code.substring(1);
            left.setCode(letter, code, left);
            return;
        }
        if (code.charAt(0) == '1') {
            if (right == null) {
                right = new HuffmanTreeNode(null, "1");
            }
            code = code.substring(1);
            right.setCode(letter, code, right);
        }
    }

    public LetterAndCode getLetter(String code, HuffmanTreeNode huffmanTreeNode) {
        if (huffmanTreeNode.letter != null) {
            return new LetterAndCode(huffmanTreeNode.letter, code);
        }

        if (code.charAt(0) == '0') {
            return getLetter(code.substring(1), huffmanTreeNode.left);
        }


        return getLetter(code.substring(1), huffmanTreeNode.right);
    }
}

class LetterAndCode {
    Character letter;
    String code;

    public LetterAndCode(Character letter, String code) {
        this.letter = letter;
        this.code = code;
    }
}
