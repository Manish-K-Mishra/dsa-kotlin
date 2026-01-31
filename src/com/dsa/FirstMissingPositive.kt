package com.dsa

fun main() {
    println(firstMissingPositive(intArrayOf(1,2,0)))
}

fun firstMissingPositive(nums: IntArray): Int {
    val n = nums.size
    var i = 0
    while (i<n){
        val x = nums[i]
        if (x in 1..n && nums[x-1] != x){
            val temp = nums[x-1]
            nums[x-1] = nums[i]
            nums[i] = temp
        }else{
            i++
        }
    }
    for (idx in 0 until n){
        if (nums[idx] != idx+1) return idx+1
    }
    return n+1
}