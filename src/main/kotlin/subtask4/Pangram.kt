package subtask4

class Pangram {

    fun getResult(inputString: String): String {
        if(inputString == "") return ""

        val inputString1 = inputString.replace('\n', ' ').trim()
        val words = inputString1.split(Regex(" +"))
        if(words.size == 1 && words[0] == "") return ""
        if(isPangram(inputString)) {
            val result = words.sortedBy { countVowels(it) }
            val sb = StringBuilder()
            for(word in result) {
                if(word.isEmpty()) continue
                var w = countVowels(word).toString() + word
                for(i in w.indices) {
                    if(isVowel(w[i])) w = w.replace(w[i], w[i].toUpperCase())
                }
                sb.append(w)
                sb.append(" ")
            }
            return sb.toString().trim()
        }
        else {
            val result = words.sortedBy { countConsonants(it) }
            val sb = StringBuilder()
            for(word in result) {
                var w = countConsonants(word).toString() + word
                for(i in w.indices) {
                    if(isConsonant(w[i])) w = w.replace(w[i], w[i].toUpperCase())
                }
                sb.append(w)
                sb.append(" ")
            }
            return sb.toString().trim()
        }
    }

    private fun isPangram(input: String): Boolean {
        for(c in 'A'..'Z') {
            if(!input.toLowerCase().contains(c.toLowerCase())) {
                return false
            }
        }
        return true
    }

    private fun isVowel(c: Char): Boolean {
        if(c in listOf('a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y')) return true
        return false
    }
    private fun isConsonant(c: Char): Boolean {
        if(c in 'A'..'z' && !isVowel(c)) return true
        return false
    }
    private fun countVowels(input: String): Int {
        var count = 0
        for(c in input) {
            if(isVowel(c)) count++
        }
        return count
    }
    private fun countConsonants(input: String): Int {
        var count = 0
        for(c in input) {
            if(isConsonant(c)) count++
        }
        return count
    }
}
