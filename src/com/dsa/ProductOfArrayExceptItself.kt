package com.dsa

fun main() {
    println(productExceptSelf(intArrayOf(1,2,3,4)).asList())
}

fun productExceptSelf(nums: IntArray): IntArray {
    if (nums.isEmpty()) return intArrayOf()
    val res = IntArray(nums.size)
    val n = nums.size

    var left = 1
    for (i in 0 until n){
        res[i] = left
        left *= nums[i]
    }

    var right = 1
    for (i in n-1 downTo 0){
        res[i] *= right
        right *= nums[i]
    }

    return res
}