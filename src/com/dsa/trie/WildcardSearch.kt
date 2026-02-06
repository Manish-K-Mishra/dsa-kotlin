package com.dsa.trie

/*
Insert and Search Words with Wildcards
Design and implement a data structure that supports the following operations:
insert(word: str) -> None: Inserts a word into the data structure.
search(word: str) -> bool: Returns true if a word exists in the data structure and false if not. The word may contain wildcards ('.') that can represent any letter.

Input: [
  insert('band'),
  insert('rat'),
  search('ra.'),
  search('b..'),
  insert('ran'),
  search('.an')
]
Output: [True, False, True]
Approach: So, At any point of search , we need to handle two scenarios:
1. When we encounter a letter , we proceed to the child of the current node that corresponds with this letter in the trie
2. When we encounter a wildcard , we explore a child nodes , as the '.' may match any char. We can perform recursive call for each child node to search for the remainder of the word.

 */
class WildcardTrie{
    private val root = TrieNode()

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
    fun search(s: String): Boolean{
        return searchHelper(0, s, root )
    }

    private fun searchHelper(index: Int, word: String, node: TrieNode): Boolean{
        var root = node
        for (i in index until word.length){
            if (word[i] == '.'){
                for (child in root.children.values){
                    if (searchHelper(i+1, word, child)){
                        return true
                    }
                }
                return false
            }else if (root.children.containsKey(word[i])){
                root = root.children[word[i]]!!
            }else{
                return false
            }
        }
        return root.isWord
    }
}

fun main() {
    val trie = WildcardTrie()

    val ops = listOf(
        // Your required scenario
        Op("insert", "band"),
        Op("insert", "rat"),
        Op("search", "ra."),
        Op("search", "b.."),
        Op("insert", "ran"),
        Op("search", ".an"),
    )

    val results = mutableListOf<Boolean>()

    for (op in ops) {
        when (op.name) {
            "insert" -> trie.insert(op.arg)
            "search" -> results.add(trie.search(op.arg))
            else -> error("Unknown op: ${op.name}")
        }
    }

    println("Results:  $results")

    val expected = listOf(
        true,
        false,
        true,
    )

    println("Expected: $expected")
    println("Match: ${results == expected}")
}