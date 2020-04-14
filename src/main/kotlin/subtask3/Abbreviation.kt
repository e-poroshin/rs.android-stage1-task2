package subtask3

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        val sb = StringBuilder()
        val bCharArray = b.toCharArray()
        val bLength = b.length
        for(i in 0 until bLength) {
            sb.append("[a-z]*(${bCharArray[i]}|${bCharArray[i].toLowerCase()})[a-z]*")
        }

        if (a.matches(Regex(sb.toString()))) return "YES"
        return "NO"
    }
}
