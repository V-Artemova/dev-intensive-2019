package ru.skillbranch.devintensive.models
import java.util.Date
//1 Task
data class User(
    val id:String,
    var firstName:String?,
    var lastName:String?,
    var avatar:String?,
    var rating:Int = 0,
    var respect:Int=0,
    var lastVisit:Date?=Date(),
    var isOnline:Boolean = false)
{
    constructor(id:String,firstName:String?,lastName: String?):this(id = id,firstName=firstName,lastName=lastName, avatar = null)
    companion object Factory{
        private var lastId  = -1
        fun makeUser (fullName:String):User {
            lastId++;
            val parts : List<String> = fullName.split(" ")
            val firstName = parts[0]
            val lastName = parts[1]
            println("Name of the person $firstName $lastName, id = $lastId")
            return User(id = "$lastId",firstName = firstName,lastName = lastName )

        }}

    class Builder {
        var id:String = "1"
        var firstName:String? =null
        var lastName:String? = null
        var avatar:String?=null
        var rating:Int = 0
        var respect:Int=0
        var lastVisit:Date?=Date()
        var isOnline:Boolean = false
        fun id (value:String) = apply {this.id = value}
        fun firstName (value: String?) = apply {firstName = value}
        fun lastName (value: String?) = apply {lastName = value}
        fun avatar (value:String?) = apply { avatar = value }
        fun rating (value:Int) = apply { rating = value }
        fun respect (value: Int) = apply { respect = value }
        fun lastVisit (value: Date?) = apply { lastVisit = value }
        fun isOnline (value: Boolean) = apply { isOnline=value}

        fun build()= User(id=id,firstName = firstName,lastName = lastName,avatar = avatar,rating = rating,respect = respect,lastVisit = lastVisit,isOnline =isOnline)



    }


}


