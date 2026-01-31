package com.dsa

fun main() {
    println(characterReplacement("AABABBA", 1))
}

fun characterReplacement(s: String, k: Int): Int {
    var freq = IntArray(26)
    var left = 0
    var right = 0
    var maxFreq = 0
    var maxLength = 0
    while (right < s.length){
        freq[s[right] - 'A']++
        maxFreq = maxOf(maxFreq, freq[s[right] - 'A'])

        if(right-left+1 -maxFreq > k){
            freq[s[left] - 'A']--
            left++
        }

        maxLength = right -left+1
        right++
    }
    return maxLength
}
