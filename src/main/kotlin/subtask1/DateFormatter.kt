package subtask1

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        val intYear = year.toInt()
        val intMonth = month.toInt()
        val intDay = day.toInt()

        return if (validateDate(intDay, intMonth)) {
            val date = LocalDate.of(intYear, intMonth, intDay)
            val formatter = DateTimeFormatter.ofPattern("dd MMMM")
            val formattedDate = date.format(formatter)
            val intDayWeek = date.dayOfWeek.value
            val dayWeek = getDayOfWeekRussianName(intDayWeek)
            "$formattedDate, $dayWeek"
        } else "Такого дня не существует"
    }

    private fun validateDate(intDay: Int, intMonth: Int): Boolean {
        when (intMonth) {
            1 -> if (intDay !in 1..31) return false
            2 -> if (intDay !in 1..28) return false
            3 -> if (intDay !in 1..31) return false
            4 -> if (intDay !in 1..30) return false
            5 -> if (intDay !in 1..31) return false
            6 -> if (intDay !in 1..30) return false
            7 -> if (intDay !in 1..31) return false
            8 -> if (intDay !in 1..31) return false
            9 -> if (intDay !in 1..30) return false
            10 -> if (intDay !in 1..31) return false
            11 -> if (intDay !in 1..30) return false
            12 -> if (intDay !in 1..31) return false
            else -> return false
        }
        return true
    }

    private fun getDayOfWeekRussianName(dayWeek: Int) : String {
        when (dayWeek) {
            1 -> return "понедельник"
            2 -> return "вторник"
            3 -> return "среда"
            4 -> return "четверг"
            5 -> return "пятница"
            6 -> return "суббота"
            7 -> return "воскресенье"
        }
        return ""
    }
}
