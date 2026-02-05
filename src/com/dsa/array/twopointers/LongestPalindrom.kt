package com.dsa.array.twopointers

/*
Given a string s, find the contiguous substring that is a palindrome and has maximum length.
Example: babad → bab (or aba), cbbd → bb.

Approach:
A palindrome mirrors around its center.
There are 2 kinds of centers:
Odd length: center at a character (e.g., racecar → center e)
Even length: center between characters (e.g., abba → center between b and b)
So for every index i, expand:
(i, i) for odd
(i, i+1) for even
Keep the longest substring.

 */
fun main() {
    println(longestPalindromicSubstring("babad"))
}
fun longestPalindromicSubstring(s: String): String{
    val n =  s.length
    if (n == 0) return ""
    var start = 0
    var maxLength = 1
    for (i in 0 until n){
        var len1 = expandAroundCenter(s, i, i)
        var len2 = expandAroundCenter(s,i, i+1)

        var currentLength = maxOf(len2, len1)
        if (currentLength > maxLength){
            maxLength = currentLength
            start = i - (currentLength -1 )/2
        }
    }

    return s.substring(start, start+maxLength)
}

fun expandAroundCenter(s: String , l: Int, r:Int): Int{
    var left = l
    var right = r
    while (left >= 0 && right < s.length && s[left] == s[right]){
        left--
        right++
    }
    return right-left-1
}