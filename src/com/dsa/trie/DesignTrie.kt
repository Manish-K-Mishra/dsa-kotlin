package com.dsa.trie

/*
Design and Implement Trie Data Structure that support following operations:
->> insert(word: str) ->> void: Insert a word into trie
->> search(word: str) ->> Boolean: Return true if a word exists in a trie , and false if not
->> has_prefix(prefix: str) ->> Boolean: Return true if a trie contains a word with the given prefix , and false if not
Input: [
  insert('top'),
  insert('bye'),
  has_prefix('to'),
  search('to'),
  insert('to'),
  search('to')
]
Output: [True, False, True]

Constraints:
-> the word and prefixes consist only of lowercase English letters.
-> The length of each word and prefix is at least one character
 */


class TrieNode(
    val children: MutableMap<Char, TrieNode> =  mutableMapOf(),
    var isWord: Boolean = false
)

class Trie {
    private val root: TrieNode = TrieNode()

    fun insert(word: String){
        var node = root
        for (c in word){
            if (!node.children.containsKey(c)){
                node.children[c] = TrieNode()
            }
            node =  node.children[c]!!
        }
        node.isWord =  true
    }

    fun search(word: String): Boolean{
        var node = root
        for (c in word){
            if (!node.children.containsKey(c)){
                return false
            }
            node =  node.children[c]!!
        }
        return node.isWord
    }

    fun hasPrefix(word: String): Boolean{
        var node = root
        for (c in word){
            if (!node.children.containsKey(c)){
                return false
            }
            node =  node.children[c]!!
        }
        return true
    }
}

// --- Test runner using "map" / MutableMap-based TrieNode ---
data class Op(val name: String, val arg: String)

fun main() {
    val trie = Trie()

    val ops = listOf(
        // Your required scenario
        Op("insert", "top"),
        Op("insert", "bye"),
        Op("hasPrefix", "to"),   // true (top starts with "to")
        Op("search", "to"),      // false ("to" not inserted yet)
        Op("insert", "to"),
        Op("search", "to"),      // true

        // Extra tests (recommended)
        Op("search", "top"),     // true
        Op("search", "bye"),     // true
        Op("search", "by"),      // false (prefix only)
        Op("hasPrefix", "b"),    // true
        Op("hasPrefix", "byt"),  // false
        Op("search", "tops"),    // false
        Op("hasPrefix", ""),     // true (empty prefix always true)
        Op("search", "")         // false unless you insert ""
    )

    val results = mutableListOf<Boolean>()

    for (op in ops) {
        when (op.name) {
            "insert" -> trie.insert(op.arg)
            "search" -> results.add(trie.search(op.arg))
            "hasPrefix" -> results.add(trie.hasPrefix(op.arg))
            else -> error("Unknown op: ${op.name}")
        }
    }

    println("Results:  $results")

    val expected = listOf(
        true,  // hasPrefix("to")
        false, // search("to")
        true,  // search("to") after insert
        true,  // search("top")
        true,  // search("bye")
        false, // search("by")
        true,  // hasPrefix("b")
        false, // hasPrefix("byt")
        false, // search("tops")
        true,  // hasPrefix("")
        false  // search("")
    )

    println("Expected: $expected")
    println("Match: ${results == expected}")
}




