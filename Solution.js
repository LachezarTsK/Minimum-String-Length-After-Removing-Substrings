
/**
 * @param {string} input
 * @return {number}
 */
var minLength = function (input) {
    this.TARGET_PAIRS = [['A', 'B'], ['C', 'D']];
    const stackLetters = new Array();
    for (let letter of input) {
        if (stackLetters.length === 0 || !isPair(letter, stackLetters[stackLetters.length - 1])) {
            stackLetters.push(letter);
            continue;
        }
        stackLetters.pop();
    }
    return stackLetters.length;
};

/**
 * @param {string} first
 * @param {string} second 
 * @return {boolean}
 */
function isPair(first, second) {
    for (let pair of this.TARGET_PAIRS) {
        if (pair[1] === first && pair[0] === second) {
            return true;
        }
    }
    return false;
}
