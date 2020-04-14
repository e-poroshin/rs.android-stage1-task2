package subtask2

class TimeConverter {

    fun toTextFormat(hour: String, minute: String): String {
        val intHour = hour.toInt()
        val intMinute = minute.toInt()

        if (validateTime(intHour, intMinute)) {
            val nums = arrayOf(
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine",
                "ten", "eleven", "twelve", "thirteen",
                "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen", "twenty", "twenty one",
                "twenty two", "twenty three", "twenty four",
                "twenty five", "twenty six", "twenty seven",
                "twenty eight", "twenty nine")

            return when {
                intMinute == 0 -> nums[intHour] + " o' clock"
                intMinute == 1 -> "one minute past " + nums[intHour]
                intMinute == 59 -> "one minute to " + nums[intHour % 12 + 1]
                intMinute == 15 -> "quarter past " + nums[intHour]
                intMinute == 30 -> "half past " + nums[intHour]
                intMinute == 45 -> "quarter to " + nums[intHour % 12 + 1]
                intMinute <= 30 -> nums[intMinute] + " minutes past " + nums[intHour]
                intMinute > 30 -> nums[60 - intMinute] + " minutes to " + nums[intHour % 12 + 1]
                else -> ""
            }
        } else return ""
    }

    private fun validateTime(intHour: Int, intMinute: Int): Boolean {
        if (intHour !in 0..11) return false
        if (intMinute !in 0..59) return false

        return true
    }
}
