package com.dsa

fun main(args: Array<String>) {
    println("Hello")
    println(substring_anagram("caabab", "aba"))
}

fun substring_anagram(s: String, t: String ): Int{
    val lenS =  s.length
    val lenT = t.length
    if (lenT > lenS){
        return 0
    }

    var count: Int = 0
    val expectedFreqs =  IntArray(26)
    val windowFreqs = IntArray(26)
    for (c in t){
        expectedFreqs[c- 'a'] +=1
    }
    var left: Int = 0
    var right: Int = 0
    while (right < lenS){
        windowFreqs[s[right] - 'a']++
        if (right - left + 1 == lenT){
            var isMatch = true
            for (i in 0 until 26){
                if (expectedFreqs[i] != windowFreqs[i]){
                    isMatch = false
                    break
                }
            }
            if (isMatch){
                count++
            }
            windowFreqs[s[left] - 'a']--
            left++
        }
        right++
    }
    return count
}