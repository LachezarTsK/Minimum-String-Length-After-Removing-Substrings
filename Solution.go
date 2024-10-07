
package main

import "fmt"

var TARGET_PAIRS = [][]rune{{'A', 'B'}, {'C', 'D'}}

func minLength(input string) int {
    // alternatively: list from "container/list"
    stackLetters := make([]rune, 0, len(input))
    for _, letter := range input {
        if len(stackLetters) == 0 || !isPair(letter, stackLetters[len(stackLetters)-1]) {
            stackLetters = append(stackLetters, letter)
            continue
        }
        stackLetters = stackLetters[0 : len(stackLetters)-1]
    }
    return len(stackLetters)
}

func isPair(first rune, second rune) bool {
    for _, pair := range TARGET_PAIRS {
        if pair[1] == first && pair[0] == second {
            return true
        }
    }
    return false
}
