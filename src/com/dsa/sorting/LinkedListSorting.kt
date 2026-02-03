package com.dsa.sorting

fun main() {
    val head = buildList(intArrayOf(4, 2, 1, 3, 3, 0, -1, 10, 5))

    println("Before sort:")
    printList(head)

    val sorted = sortLinkedList(head)

    println("\nAfter sort:")
    printList(sorted)
}

class ListNode(var `val`: Int){
    var next: ListNode? = null
}

fun sortLinkedList(head: ListNode?): ListNode?{
    if ( head?.next == null) return head

    val secondHead = splitList(head)

    val firstHalfSorted =  sortLinkedList(head)
    val secondHalfSorted = sortLinkedList(secondHead)

    return merge(firstHalfSorted, secondHalfSorted)
}

fun merge(l1: ListNode?, l2: ListNode?): ListNode?{
    var list1= l1
    var list2 = l2
    var dummy = ListNode(0)
    var tail = dummy
    while (list1 != null && list2 != null){
        if (list1.`val` < list2.`val`){
            tail.next = list1
            list1 = list1.next
        }else{
            tail.next = list2
            list2 = list2.next
        }
        tail = tail.next!!    // safe because we just assigned tail.next
    }
    tail.next = list1 ?: list2

    return dummy.next
}

fun splitList(head: ListNode): ListNode?{
    var slow = head
    var fast = head
    while (fast.next?.next != null ){
        slow = slow.next!!
        fast = fast.next!!.next!!
    }
    val secondHead = slow.next
    slow.next = null

    return secondHead
}

fun buildList(nums: IntArray): ListNode? {
    if (nums.isEmpty()) return null

    val dummy = ListNode(0)
    var tail = dummy
    for (x in nums) {
        tail.next = ListNode(x)
        tail = tail.next!!
    }
    return dummy.next
}

fun printList(head: ListNode?) {
    var cur = head
    val sb = StringBuilder()
    while (cur != null) {
        sb.append(cur.`val`)
        if (cur.next != null) sb.append(" -> ")
        cur = cur.next
    }
    println(sb.toString())
}