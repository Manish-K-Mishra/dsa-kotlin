package com.dsa.binarysearch

/*
Find the insertion Index
Given : Sorted array that contains unique value, return its index
Conditions:
1)If the array contain the targeted value return its index
2) Otherwise return the insertion index. This is the index where the target would be ifit were inserted in order, maintaining the sorted sequence of the array.

Example:1
Input nums = [1,2,3,5,7,8,9], target = 5
Output: 3
Example 2:
Input: nums = [1, 2, 4, 5, 7, 8, 9], target = 6
Output: 4
 */

fun main() {
    println(findInsertionIndex(nums = intArrayOf(1,2,3,5,7,8,9), 5))
    println(findInsertionIndex(nums = intArrayOf(1,2,3,5,7,8,9), 6))
}
fun findInsertionIndex(nums: IntArray, target: Int): Int{
    if (nums.isEmpty()) return 0
    var left = 0
    var right = nums.size // Here we are taking size total as n since number may need to insert as last number
    while (left < right){
        var mid = (left+right)/2
        if (nums[mid] >= target){
            right = mid
        }else {
            left = mid + 1
        }
    }
    return left
}