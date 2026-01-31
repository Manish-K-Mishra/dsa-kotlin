fun main() {
    println(isValid("([]{)}"))
}

fun isValid(s: String): Boolean{
    val stack = ArrayDeque<Char>(s.length)
    for (ch in s){
        when(ch){
            '(', '{', '[' -> stack.addLast(ch)
            ')' -> if (stack.isEmpty() || stack.removeLast() != '(' ) return false
            '}' -> if (stack.isEmpty() || stack.removeLast() != '{' ) return false
            ']' -> if (stack.isEmpty() || stack.removeLast() != '[' ) return false
        }
    }
    return true
}