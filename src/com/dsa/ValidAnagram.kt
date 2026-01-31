package com.dsa

fun main() {
    println(isAnagram("anagram", "nagaram"))
}

fun isAnagram(s: String, t: String): Boolean{
    if (s.length != t.length) return false
    val freq = IntArray(26)

    for (i in s.indices){
       freq[s[i] - 'a']++
        freq[t[i] - 'a']--
    }

    for (v in freq){
        if (v != 0){
            return false
        }
    }

    return true
}