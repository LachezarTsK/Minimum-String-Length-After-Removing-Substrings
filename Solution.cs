
using System;
using System.Collections.Generic;

public class Solution
{
    private static readonly char[][] TARGET_PAIRS = new char[2][] { new char[2] { 'A', 'B' }, new char[2] { 'C', 'D' } };

    public int MinLength(string input)
    {
        // alternatively: LinkedList<Character>
        Stack<char> stackLetters = new Stack<char>();

        foreach (char letter in input)
        {
            if (stackLetters.Count == 0 || !IsPair(letter, stackLetters.Peek()))
            {
                stackLetters.Push(letter);
                continue;
            }
            stackLetters.Pop();
        }
        return stackLetters.Count;
    }

    private bool IsPair(char first, char second)
    {
        foreach (char[] pair in TARGET_PAIRS)
        {
            if (pair[1] == first && pair[0] == second)
            {
                return true;
            }
        }
        return false;
    }
}
