package ltd.ryantech.string.validPalindrome125

fun isPalindrome(s: String): Boolean {
    var front: Int = 0
    var end: Int = s.length - 1
    while (front < end) {
        while (front < end && !isValidChar(s[front]))
            front++
        while (front < end && !isValidChar(s[end]))
            end--
        if (s[front].toLowerCase() != s[end].toLowerCase()) {
            return false
        }
        front++
        end--
    }
    return true
}

fun isValidChar(c: Char): Boolean {
    return when (c) {
        in 'a'..'z' -> true
        in 'A'..'Z' -> true
        in '0'..'9' -> true
        else -> false
    }
}

fun main(args: Array<String>) {
    val s: String = "A man, a plan, a canal: Panama"
    println(isPalindrome(s))
}