
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    private static final char[][] TARGET_PAIRS = {{'A', 'B'}, {'C', 'D'}};

    public int minLength(String input) {
        // alternatively: Stack<Character>, LinkedList<Character>
        Deque<Character> stackLetters = new ArrayDeque<>();
        for (char letter : input.toCharArray()) {
            if (stackLetters.isEmpty() || !isPair(letter, stackLetters.peekFirst())) {
                stackLetters.push(letter);
                continue;
            }
            stackLetters.pollFirst();
        }
        return stackLetters.size();
    }

    private boolean isPair(char first, char second) {
        for (char[] pair : TARGET_PAIRS) {
            if (pair[1] == first && pair[0] == second) {
                return true;
            }
        }
        return false;
    }
}
