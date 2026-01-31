package com.kotlin.training

fun main() {
    println(ops(3) { x -> x * x })
    println(ops(3, fun(x): Int{
        if (x> 10){
            return 10
        }else{
            return x*x
        }
    }) )
}

fun ops(x: Int, op: (Int) -> Int): Int{
    return op(x)
}


