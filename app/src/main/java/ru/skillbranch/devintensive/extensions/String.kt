package ru.skillbranch.devintensive.extensions
fun String.truncate ( value:Int = 16): String
{
    var cutStr:String =this;
    return when{
        cutStr.trim().length<=value -> cutStr.trim()
        cutStr.trim().length>value -> "${cutStr.take(value).trim()}..."
        else -> ""
    }




}

fun String.stripHtml(): String {
    return this.replace(Regex("&.+?;|<.+?>"), " ").replace(Regex(" +"), " ").toString().trim()
}
