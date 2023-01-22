import java.util.*;

public class HuffmanCode {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();

        TreeMap<Character, Integer> huffmanMap = findQuantityOfLettersInText(text);

        CodeTreeNode tree = huffman(turnTreeMapIntoCodeTreeNodes(huffmanMap));

        TreeMap<Character, String> codes = new TreeMap<>();
        if (huffmanMap.size() == 1) {
            codes.put(text.charAt(0), tree.getCodeForCharacter(text.charAt(0), "0"));
        } else {
            for (Character c : huffmanMap.keySet()) {
                codes.put(c, tree.getCodeForCharacter(c, ""));
            }
        }

        String huffmanText = translateTextIntoHuffmanCode(text, codes);
        System.out.println(codes.keySet().size() + " " + huffmanText.length());
        for (Character key :
                codes.keySet()) {
            System.out.println(key + ": " + codes.get(key));
        }
        System.out.println(huffmanText);

    }

    private static TreeMap<Character, Integer> findQuantityOfLettersInText(String text) {
        TreeMap<Character, Integer> huffmanMap = new TreeMap<>();
        for (int i = 0; i < text.length(); i++) {
            if (huffmanMap.containsKey(text.charAt(i))) {
                huffmanMap.put(text.charAt(i), huffmanMap.get(text.charAt(i)) + 1);
            } else {
                huffmanMap.put(text.charAt(i), 1);
            }
        }

        return huffmanMap;
    }

    private static ArrayList<CodeTreeNode> turnTreeMapIntoCodeTreeNodes(TreeMap<Character, Integer> huffmanMap) {
        ArrayList<CodeTreeNode> codeTreeNodes = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : huffmanMap.entrySet()) {
            codeTreeNodes.add(new CodeTreeNode(entry.getKey(), entry.getValue()));
        }

        return codeTreeNodes;
    }

    private static CodeTreeNode huffman(ArrayList<CodeTreeNode> codeTreeNodes) {
        while (codeTreeNodes.size() > 1) {
            Collections.sort(codeTreeNodes);
            CodeTreeNode left = codeTreeNodes.remove(codeTreeNodes.size() - 1);
            CodeTreeNode right = codeTreeNodes.remove(codeTreeNodes.size() - 1);

            CodeTreeNode parent = new CodeTreeNode(null, left.weight + right.weight, left, right);
            codeTreeNodes.add(parent);
        }

        return codeTreeNodes.get(0);
    }

    private static String translateTextIntoHuffmanCode(String text, TreeMap<Character, String> codes) {
        StringBuilder cryptoText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            cryptoText.append(codes.get(text.charAt(i)));
        }

        return cryptoText.toString();
    }
}

class CodeTreeNode implements Comparable<CodeTreeNode> {
    Character content;
    int weight;
    CodeTreeNode left;
    CodeTreeNode right;

    public CodeTreeNode(Character content, int weight) {
        this.content = content;
        this.weight = weight;
    }

    public CodeTreeNode(Character content, int weight, CodeTreeNode left, CodeTreeNode right) {
        this.content = content;
        this.weight = weight;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(CodeTreeNode o) {
        return o.weight - this.weight;
    }

    public String getCodeForCharacter(Character ch, String parentPath) {
        if (this.content == ch) {
            return parentPath;
        } else {
            if (left != null) {
                String path = left.getCodeForCharacter(ch, parentPath + 1);
                if (path != null) {
                    return path;
                }
            }

            if (right != null) {
                String path = right.getCodeForCharacter(ch, parentPath + 0);
                if (path != null) {
                    return path;
                }
            }
        }
        return null;
    }
}