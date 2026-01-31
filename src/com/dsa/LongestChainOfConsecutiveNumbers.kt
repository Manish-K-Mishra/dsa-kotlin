package com.dsa

fun main() {
    println(longest_chain_of_consecutive_numbers(intArrayOf(1, 6, 2, 5, 8, 7, 10, 3)))
}

fun longest_chain_of_consecutive_numbers_brute_force(nums: IntArray): Int {
    if (nums.isEmpty()){
        return 0
    }
    var longestChain = 0
    for (num in nums){
        var currentNum = num
        var currentChain = 1
        while (nums.contains(currentNum+1)){
            currentChain += 1
            currentNum += 1
        }
        longestChain = maxOf(longestChain, currentChain)
    }

    return longestChain
}

fun longest_chain_of_consecutive_numbers(nums: IntArray): Int{
    if (nums.isEmpty()) return 0
    val set = nums.toHashSet()
    var longestChain = 0
    for (num in set){
        if (!set.contains(num-1)){
            var currentNum = num
            var currentChain = 1
            while (set.contains(currentNum+1)){
                currentNum += 1
                currentChain += 1
            }
            longestChain = maxOf(currentChain, longestChain)
        }
    }
    return longestChain
}