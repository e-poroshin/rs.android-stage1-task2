package subtask5

import java.time.LocalDate
import java.time.temporal.ChronoUnit
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        if(blockB == Int::class) {
            var sum = 0
            for(o in blockA) {
                if(o is Int) sum += o
            }
            return sum
        }
        if(blockB == String::class) {
            val sb = StringBuilder()
            for(o in blockA) {
                if(o is String) {
                    sb.append(o)
                }
            }
            return sb.toString()
        }
        else {
            val now = LocalDate.now()
            var current: LocalDate? = null
            var days: Long = 0
            for(o in blockA) {
                if(o is LocalDate) {
                    if(current == null) {
                        current = o
                        days = ChronoUnit.DAYS.between(current, now)

                    } else {
                        if (days > ChronoUnit.DAYS.between(o, now)) {
                            current = o
                            days = ChronoUnit.DAYS.between(current, now)

                        }
                    }
                }
            }
            val year: Int = current!!.year
            val month: Int = current!!.monthValue
            val dayOfMonth: Int = current!!.dayOfMonth
            return "${dayOfMonth}.${month}.${year}"
        }
    }
}
