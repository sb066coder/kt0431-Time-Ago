fun main() {
    var seconds = 10
    println("$seconds сек. - ${ agoToText(seconds) }")
    seconds = 60 + 1
    println("$seconds сек. - ${ agoToText(seconds) }")
    repeat(15){
        seconds *= 2
        println("$seconds сек. - ${ agoToText(seconds) }")
    }
}

fun agoToText(seconds: Int): String {
    return when (seconds) {
        in 0..60 -> "был(а) только что"                             // lees than 1 min
        in 0..3_600 -> "был(а) ${stringMinutes(seconds)} назад"     // less than 1 hour
        in 0..86_400 -> "был(а) ${stringHours(seconds)} назад"      // less than 1 day
        in 0..172_800 -> "был(а) сегодня"                           // less than 2 days
        in 0..259_200 -> "был(а) вчера"                             // less than 3 days
        else -> "был(а) давно"                                            // more than 3 days
    }
}

fun stringMinutes(seconds: Int): String {
    val minutes = seconds / 60
    return when {
        (minutes % 10 == 1 && minutes != 11) -> "$minutes минуту"
        (minutes % 10 == 2 && minutes != 12) ||
        (minutes % 10 == 3 && minutes != 13) ||
        (minutes % 10 == 4 && minutes != 14) -> "$minutes минуты"
        else -> "$minutes минут"
    }
}

fun stringHours(seconds: Int): String {
    val hours = seconds / 3600
    return when {
        (hours % 10 == 1 && hours != 11) -> "$hours час"
        (hours % 10 == 2 && hours != 12) ||
        (hours % 10 == 3 && hours != 13) ||
        (hours % 10 == 4 && hours != 14) -> "$hours часа"
        else -> "$hours часов"
    }
}
