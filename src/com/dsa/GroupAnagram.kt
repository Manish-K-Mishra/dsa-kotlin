package com.dsa

fun main() {
    val input = listOf(
        "eat", "tea", "tan", "ate", "nat", "bat",
        "tab", "ant", "tna",
        "", ""
    )
 println(groupAnagrams(input))
}

fun groupAnagrams(strs: List<String>): List<List<String>>{
    val map = mutableMapOf<String, MutableList<String>>()

    for (str in strs){
        val count = IntArray(26)
        for (ch in str) count[ch - 'a']++

        val key = count.joinToString ("#" )
        map.getOrPut(key){ mutableListOf() }.add(str)

    }

    return map.values.toList()
}