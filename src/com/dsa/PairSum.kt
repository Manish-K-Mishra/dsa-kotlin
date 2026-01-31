package com.dsa

fun main() {
    println(findPairSumUnsorted(intArrayOf(1,2,3,4,6), 7).toList())
}

fun findPairSum(nums: IntArray, target: Int): IntArray {

    var start: Int = 0
    var end: Int = nums.size - 1

    while (start < end){
        val sum = nums[start] + nums[end]
        when {
            (sum == target)->
                return intArrayOf(start, end)
            (sum < target)->
                start++
            else ->
                end--
        }
    }

    return intArrayOf();
}

fun findPairSumUnsorted(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int, Int>()

    for ((i, v) in nums.withIndex()){
        val j = map[target - v]
        if (j != null) {
            return intArrayOf(j,i)
        }
        map[v] = i

    }

    return intArrayOf();
}
