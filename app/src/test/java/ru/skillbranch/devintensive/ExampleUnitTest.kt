package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.*
import ru.skillbranch.devintensive.models.*
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    //Task 1
    @Test
    fun test_factory() {
        val user = User.makeUser("Veronika Artemova")
    }

    //Task2
    @Test
    fun test_abstract_factory() {
        val user = User.makeUser("Veronika Artemova")
        val txtMessage =
            BaseMessage.makeMessage(user, Chat("0"), type = "text", payload = "any text message")
        val imgMessage =
            BaseMessage.makeMessage(user, Chat("1"), type = "image", payload = "any image url")

        println(txtMessage.formatMessage())
        println(imgMessage.formatMessage())
    }

    //Task3
    @Test
    fun test_parseFullName() {
        val (firstName1, lastName1) = Utils.parseFullName("Artemova") //Artemova null
        println("Name of the person $firstName1 $lastName1")
        val (firstName2, lastName2) = Utils.parseFullName("null")
        println("Name of the person $firstName2 $lastName2")
        val (firstName3, lastName3) = Utils.parseFullName(" ")
        println("Name of the person $firstName3 $lastName3")
        val (firstName4, lastName4) = Utils.parseFullName("")
        println("Name of the person $firstName4 $lastName4")

    }

    //Task4
    @Test
    fun test_dateFormat() {
        println("${Date().format()}")
        println("${Date().format("HH:mm")}")

    }
     //Task5
    @Test
    fun test_dateAdd()
     {

         println("${  Date().add(11,TimeUnits.MINUTE)}")
         println("${  Date().add(-11,TimeUnits.HOUR)}")
     }

    //Task6
    @Test
    fun test_toInitials(){
        Utils.toInitials("veronika", "artemova") //VA
        Utils.toInitials(" ","") //null удалить пробел
        Utils.toInitials(""," ") //null удалить пробел
        Utils.toInitials(null,null) //null
        Utils.toInitials("veronika",null) //V
        Utils.toInitials(null,"Artemova") //A
    }
 //Task7
    @Test
    fun test_transliteration() {
     Utils.transliteration("Женя Стереотипов") //Zhenya Stereotipov
     Utils.transliteration("Amazing Петр", "_") //Amazing Petr
 }
 //Task8
     @Test
     fun test_humanizeDiff(){

    println(Date().add(-2, TimeUnits.HOUR).humanizeDiff())  //2 часа назад
     println(Date().add(-5, TimeUnits.DAY).humanizeDiff()) //5 дней назад
     println(Date().add(2, TimeUnits.MINUTE).humanizeDiff()) //через 2 минуты
     println(Date().add(7, TimeUnits.DAY).humanizeDiff()) //через 7 дней
     println(Date().add(-400, TimeUnits.DAY).humanizeDiff()) //более года назад
     println(Date().add(400, TimeUnits.DAY).humanizeDiff()) //более чем через год
 }

//Task9
    @Test
    fun test_builder(){
    val user:User = User.Builder().id("1")
            .firstName("Veronika")
            .lastName("Artemova")
            .avatar("")
            .rating(1)
            .respect(1)
            .lastVisit(Date())
            .isOnline(true)
            .build()

println("$user") }

//Task10
   @Test
   fun test_plural(){
    println  (TimeUnits.SECOND.plural(1))//1 секунду
    println( TimeUnits.MINUTE.plural(4)) //4 минуты
    println(TimeUnits.HOUR.plural(19)) //19 часов
    println(  TimeUnits.DAY.plural(222)) //222 дня
}
//Test11
   @Test
   fun test_truncate(){
  println ("Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate())
    println ("Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate(15))
   println ( "A     ".truncate(3)) }
//Test12
 @Test
 fun test_stripHtml() {
    println("<p>   Образовательное              IT-сообщество Skill Branch</p>".stripHtml()) //Образовательное IT-сообщество Skill Branch


}
}

