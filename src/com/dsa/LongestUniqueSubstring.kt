package com.dsa

fun main(args: Array<String>) {
 println(longestSubstringBF("abcba"))
}

fun longestSubstringBF(s: String): Int {
    var maxLength = 0;
    val n = s.length

    for (i in 0 until n){
        for (j in i until n){
            val seen =  HashSet<Char>()
            var isUnique =  true

            for (k in i..j){
                val ch = s[k]
                if(seen.contains(ch)){
                    isUnique = false
                    break
                }
                seen.add(ch)
            }
            if (isUnique){
                maxLength = maxOf(maxLength, j-i+1)
            }
        }
    }
    return maxLength
}