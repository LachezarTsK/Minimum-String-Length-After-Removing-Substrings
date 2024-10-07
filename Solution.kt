
import java.util.ArrayDeque

class Solution {

    private companion object {
        val TARGET_PAIRS = arrayOf(charArrayOf('A', 'B'), charArrayOf('C', 'D'))
    }

    fun minLength(input: String): Int {
        // alternatively: Stack<Char>, LinkedList<Char>
        val stackLetters = ArrayDeque<Char>()
        for (letter in input) {
            if (stackLetters.isEmpty() || !isPair(letter, stackLetters.peekFirst())) {
                stackLetters.push(letter)
                continue
            }
            stackLetters.pollFirst()
        }
        return stackLetters.size
    }

    private fun isPair(first: Char, second: Char): Boolean {
        for (pair in TARGET_PAIRS) {
            if (pair[1] == first && pair[0] == second) {
                return true
            }
        }
        return false
    }
}
