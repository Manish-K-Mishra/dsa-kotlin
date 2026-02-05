package com.dsa.array.twopointers

/*
Given: String of lowercase english letters
Expected: Return new string representing the next immediate sequence.
If this is last sequence in permutation than return 1st sequence

Approach to solve:
1. Locate the pivot
    - The pivot is the 1st character in the non-increasing sequence from the right of the string
    - If no  pivot is found , the string is already at its last lexicogrphical sequence, and the result is just reverse of the string
2. Find the rightmost successor to the pivot
3. Swap the rightmost successor with the pivot to increase the lexicographical order of the suffix
4. Reverse the suffix after the pivot to minimize its permutation.
 */

fun nextLexoGraphicalSequence(s: String): String{
    val n = s.length

    var pivot = n-2
    while (pivot >=0 && s[pivot] >= s[pivot+1]){
        pivot--
    }

    if (pivot == -1){
        return s.reversed()
    }

    var rightSuccessor =  n-1
    while (s[rightSuccessor] <= s[pivot]){
        rightSuccessor--
    }
    val chars = s.toCharArray()
    val temp = chars[pivot]
    chars[pivot] = chars[rightSuccessor]
    chars[rightSuccessor] = temp

    var l = pivot + 1
    var r = n - 1
    while (l < r) {
        val t = chars[l]
        chars[l] = chars[r]
        chars[r] = t
        l++
        r--
    }

    return chars.concatToString()
}

fun main() {
    println(nextLexoGraphicalSequence("abcd"))
}