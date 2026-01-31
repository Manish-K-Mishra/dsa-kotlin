package com.dsa

fun main() {
    println(longest_substring_with_unique_chars("abcba"))
}

fun longest_substring_with_unique_chars(s: String): Int {
    val set = HashSet<Char>()
    var left = 0
    var right = 0
    var maxLength = 0
    while (right < s.length){
        while (set.contains(s[right])){
            set.remove(s[left])
            left++
        }
        maxLength  = maxOf(maxLength, right-left+1)
        set.add(s[right])
        right++
    }

  return maxLength
}