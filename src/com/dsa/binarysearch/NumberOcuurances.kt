package com.dsa.binarysearch

fun main() {
    println(firstAndLastOccurrences(intArrayOf(1, 2, 3, 4, 4, 4, 5, 6, 7, 8, 9, 10, 11), 4).toList())
}
fun firstAndLastOccurrences(nums: IntArray, target: Int): IntArray{
    var left = 0
    var right = nums.size-1
    var firstIndex = -1
    var lastIndex = -1

    while (left < right){
        var mid = (left+right)/2
        if (nums[mid] > target){
            right = mid -1
        }else if (nums[mid] < target){
            left = mid+1
        }else{
            firstIndex = mid
            while (firstIndex >= left){
                if (nums[firstIndex-1] == target){
                    firstIndex--
                }else{
                    break
                }
            }
            lastIndex = mid
            while (lastIndex <= right){
                if (nums[lastIndex+1] == target){
                    lastIndex++
                }else{
                    break
                }
            }
        }

    }
    return intArrayOf(firstIndex,lastIndex)
}