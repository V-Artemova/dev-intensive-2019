package ru.skillbranch.devintensive.utils


object Utils {
    fun parseFullName(fullName: String): Pair<String?, String?> {
        val parts: List<String?> = fullName.split(" ")
        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)

        if (fullName.isBlank() || fullName.isEmpty()) {
            firstName = null
            lastName = null
        }
        return Pair(firstName, lastName)

    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        var nullString = "null"
        val cont = StringBuilder()
        cont.append(firstName).append(lastName)
        var check = cont.toString()
        val toStr: String;
        if (check == "nullnull" || check == " ") {
            println("$nullString"); return nullString
        }


        if (firstName == null || lastName == null) {
            if (firstName == null) {
                val lastCharacterCapitalize = lastName!!.capitalize()
                val lastCharacter: Char = lastCharacterCapitalize[0]
                println("$lastCharacter")
                toStr = lastCharacter.toString()
                return toStr
            } else {
                val firstCharacterCapitalize: String = firstName!!.capitalize()
                val firstCharacter: Char = firstCharacterCapitalize[0]
                println("$firstCharacter")
                toStr = firstCharacter.toString()
                return toStr
            }
        }


        val firstCharacterCapitalize = firstName.capitalize()
        val lastCharacterCapitalize = lastName.capitalize()

        val firstCharacter = firstCharacterCapitalize.get(0)
        val lastCharacter = lastCharacterCapitalize.get(0)

        val sb = StringBuilder()
        sb.append(firstCharacter).append(lastCharacter)

        println("$sb")
        toStr = sb.toString()
        return toStr
    }
/*
* Реализуй метод Utils.transliteration(payload divider) принимающий в качестве аргумента строку (divider по умолчанию " ")
*  и возвращающий преобразованную строку из латинских символов, словарь символов соответствия алфовитов доступен
*  в ресурсах к заданию
*/

    fun transliteration(divider: String = "",payload:String=" "): String {
        val sb = StringBuilder()
        val Str = "Not found simvols"
        val toStr: String;
        var ascCells:Int
        for (char in divider.toCharArray()) {
            when (char) {
                'а' -> sb.append("a")
                'a' -> sb.append("a")

                'А' ->sb.append("A")
                'A' ->sb.append("A")

                'б' -> sb.append("b")
                'b' -> sb.append("b")

                'Б' -> sb.append("B")
                'B' -> sb.append("B")


                'в'-> sb.append("v")
                'В'-> sb.append("V")

                'г'-> sb.append("g")
                'Г'-> sb.append("G")

                'д'->sb.append( "d")
                'Д'->sb.append( "D")

                'е'->sb.append( "e")
                'Е'->sb.append( "E")

                'ё'->sb.append( "e")
                'Ё'->sb.append( "E")

                'ж'-> sb.append("zh")
                'Ж'-> sb.append("Zh")

                'з' -> sb.append( "z")
                'З' -> sb.append( "Z")

                'и'->sb.append("i")
                'И'->sb.append("I")

                'й' ->sb.append("i")
                'Й'->sb.append("I")

                'к'->sb.append("k")
                'К'->sb.append("K")

                'л' ->sb.append( "l")
                'Л' ->sb.append( "L")

                'м'->sb.append("m")
                'М'->sb.append("M")

                'н' ->sb.append("n")
                'Н' ->sb.append("N")

                'о'->sb.append( "o")
                'О'->sb.append( "O")

                'п'->sb.append( "p")
                'П'->sb.append( "P")

                'р'->sb.append( "r")
                'Р'->sb.append( "R")

                'с'->sb.append( "s")
                'С'->sb.append( "S")

                'т'->sb.append("t")
                'Т'->sb.append("T")

                'у'->sb.append( "u")
                'У'->sb.append( "U")

                'ф'->sb.append("f")
                'Ф'->sb.append("F")

                'х' ->sb.append("h")
                'Х' ->sb.append("H")

                'ц'->sb.append( "c")
                'Ц'->sb.append( "C")

                'ч'->sb.append("ch")
                'Ч'->sb.append("Ch")

                'ш'->sb.append("sh")
                'Ш'->sb.append("Sh")

                'щ'->sb.append("sh'")
                'Щ'->sb.append("Sh'")

                'ъ'->sb.append("")
                'ы'->sb.append( "i")
                'ь'->sb.append( "")

                'э'->sb.append( "e")
                'Э'->sb.append( "E")

                'ю'->sb.append( "yu")
                'Ю'->sb.append( "Yu")

                'я'->sb.append( "ya")
                'Я'->sb.append( "Ya")
                ' '->sb.append(payload)
                else ->{  sb.append(char) } } }
        println("$sb")
        toStr = sb.toString()
        return toStr

    }
}
