
#include <array>
#include <string>
#include <vector>
using namespace std;

/*
The code will run faster with ios::sync_with_stdio(0).
However, this should not be used in production code and interactive problems.
In this particular problem, it is ok to apply ios::sync_with_stdio(0).

Many of the top-ranked C++ solutions for time on leetcode apply this trick,
so, for a fairer assessment of the time percentile of my code
you could outcomment the lambda expression below for a faster run.
*/

/*
const static auto speedup = [] {
    ios::sync_with_stdio(0);
    return nullptr;
}();
*/

class Solution {

    static constexpr array<array<int, 2>, 2> TARGET_PAIRS{ { {'A', 'B'}, {'C', 'D'} } };

public:
    int minLength(const string& input) const {
        // alternatively: deque<char>, stack<char>, list<char>
        vector<char> stackLetters;
        for (const auto& letter : input) {
            if (stackLetters.empty() || !isPair(letter, stackLetters.back())) {
                stackLetters.push_back(letter);
                continue;
            }
            stackLetters.pop_back();
        }
        return stackLetters.size();
    }

private:
    bool isPair(char first, char second) const {
        for (const auto& pair : TARGET_PAIRS) {
            if (pair[1] == first && pair[0] == second) {
                return true;
            }
        }
        return false;
    }
};
