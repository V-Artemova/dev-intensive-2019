package ru.skillbranch.devintensive.extensions

import java.lang.IllegalStateException
import java.lang.Math.abs
import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR
fun Date.format(pattern: String="HH:mm:ss dd.MM.yy"):String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}
fun Date.add(value:Int, units: TimeUnits=TimeUnits.MINUTE):Date {
    var time = this.time

    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
        else -> throw IllegalStateException("invalid unit")
    }
    this.time = time
    return this

}


    fun Date.humanizeDiff(date: Date = Date()):String {
        var timeDifference: Long = this.time - date.time
        var difference: Int;
        var returnStr:String="";

        when (timeDifference) {
            in -45049..45000 -> {
                difference = Math.round(timeDifference / 1000f)
                when (difference) {
                    in -1..1 -> returnStr ="только что"
                    in 1..45 -> returnStr ="через несколько секунд "
                    in -45..-1 -> returnStr ="несколько секунд назад"
                }
            }
            in -75050..-45000, in 45050..75000 -> {
                difference = Math.round(timeDifference / 1000f)
                when (difference) {
                    in 45..75 ->returnStr ="через минуту"
                    in -75..-45 -> returnStr ="минуту  назад"  }}


             in -2700050..-75000, in 75050..2700000 -> {
                difference = Math.round(timeDifference / 60000f)
                when (difference) {
                    in -45..-1 -> {difference = abs(difference);
                        returnStr =("$difference минут назад")}
                    in 1..45 -> returnStr=("через $difference минут ") } }


            in -4500050..-2700000, in 2700050..4500000 -> {
                difference = Math.round(timeDifference / 60000f)
                when (difference) {
                    in -75..-45 ->returnStr ="час назад"
                    in 45..75 -> returnStr="через час " } }

                    in -79200050..-4500000 , in 4500050..79200000 -> {
                difference = Math.round(timeDifference / 3600000f)
                when (difference) {
                    in -22..-1 ->{ difference = abs(difference); returnStr=("$difference часов назад")}
                    in 1..22 -> returnStr =("через $difference часов ") } }

            in -93600050..-79200000, in 79200050..93600000 -> {
                difference = Math.round(timeDifference / 3600000f)
                when (difference) {
                    in -26..-22 -> returnStr =("день назад")
                    in 22..26 -> returnStr =("через день ") } }


                    in -31104000050..-93600000 , in -93600050..31104000000 -> {
                difference = Math.round(timeDifference / 86400000f)
                when (difference) {
                    in -360..-1 ->{difference = abs(difference); returnStr = ("$difference дней назад")}
                    in 1..460 -> returnStr = ("через $difference дней ") } }

else -> returnStr = if (timeDifference > 0){ "больше чем через год" } else { "более года назад" } }


        return returnStr
    }




enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY;

    fun plural (value: Int):String {
        var surplus:Int = value;
        if (value>101) {
        while (surplus>101) {
            surplus = surplus - 100 }}
        when (this) {

            SECOND -> return when (surplus) {
                in 2..4, in 22..24, in 32..34, in 42..44, in 52..54, in 62..64, in 72..74, in 82..84, in 92..94-> ("$value секунды")
                in 5..20, in 25..30, in 35..40, in 45..50, in 55..60, in 65..70, in 75..80, in 85..90, in 95..100 -> ("$value секунд ")
                1, 21, 31, 41, 51, 61, 71, 81, 91, 101 -> ("$value секунда")
                else -> (" больше минуты")
            }

            MINUTE -> return when (surplus) {
                in 2..4, in 22..24, in 32..34, in 42..44, in 52..54, in 62..64, in 72..74, in 82..84, in 92..94 -> ("$value минуты")
                in 5..20, in 25..30, in 35..40, in 45..50, in 55..60, in 65..70, in 75..80, in 85..90, in 95..100 -> ("$value минут ")
                1, 21, 31, 41, 51, 61, 71, 81, 91, 101 -> ("$value минута")
                else -> ("$value больше одного часа ")
            }
            HOUR -> return when (surplus) {
                in 2..4, in 22..24, in 32..34, in 42..44, in 52..54, in 62..64, in 72..74, in 82..84, in 92..94 -> ("$value часа")
                in 5..20, in 25..30, in 35..40, in 45..50, in 55..60, in 65..70, in 75..80, in 85..90, in 95..100 -> ("$value часов ")
                1, 21, 31, 41, 51, 61, 71, 81, 91, 101 -> ("$value час ")
                else -> ("больше суток")
            }

            DAY -> return when (surplus) {
                        in 2..4, in 22..24, in 32..34, in 42..44, in 52..54, in 62..64, in 72..74, in 82..84, in 92..94 -> ("$value дня")
                        in 5..20, in 25..30, in 35..40, in 45..50, in 55..60, in 65..70, in 75..80, in 85..90, in 95..100 -> ("$value дней ")
                        1, 21, 31, 41, 51, 61, 71, 81, 91, 101 -> ("$value день ")
                        else -> ("неприемлимое значение")
                    }


        }
    }}
/*Реализуй метод plural для всех перечислений TimeUnits следующего вида TimeUnits.SECOND.plural(value:Int)
возвращающую значение в виде строки с праильно склоненной единицой измерения
*/