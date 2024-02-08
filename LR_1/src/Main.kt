fun main() {

    task1()
    task2()
    task3()
    task4()
    task5()

}

fun task1() {
    println("=====================")
    println("Задание 1")
    println("Введите количество чисел")
    val n = readln().toInt()
    var b = 0

    for (i in 0..<n) {
        println("Введите число")
        val a = readln().toInt()
        if (i % 2 == 0) {
            b += a
        } else {
            b -= a
        }
    }

    println("Результат = $b")
    println("=====================")
}

fun task2() {
    println("=====================")
    println("Задание 2")
    println("Введите количество дорог")
    val number = readln().toInt()
    var maximum = 0
    var road = 1

    for (i in 0..<number) {
        val iroad = i+1
        println("Введите количество туннелей для $iroad дороги")
        val tunnel = readln().toInt()
        var m = 100000000

        for (j in 0..<tunnel) {
            val jtunnel = j+1
            println("Введите высоту $jtunnel туннеля")
            val height = readln().toInt()
            if (m > height) {
                m = height
            }
        }

        if (maximum < m) {
            maximum = m
            road = i + 1
        }
    }

    println("Номер нужной дороги: $road наибольшая высота грузовика: $maximum")
    println("=====================")
}

fun task3() {
    println("=====================")
    println("Задание 3")
    println("Введите трехзначное число:")
    val number = readln().toInt()

    if (number in 100..999) {
        val digit1 = number / 100
        val digit2 = (number / 10) % 10
        val digit3 = number % 10

        val sumIsEven = (digit1 + digit2 + digit3) % 2 == 0
        val mulIsEven = (digit1 * digit2 * digit3) % 2 == 0

        if (sumIsEven && mulIsEven) {
            println("Число $number является дважды четным.")
        } else {
            println("Число $number не является дважды четным.")
        }
    } else {
        println("Введённое число не является трёхзначным")
    }

    println("=====================")
}

fun task4() {
    println("=====================")
    println("Задание 4")
    println("Введите строку")
    val charFor4 = readln()
    uniqueStringFinder("charFor4")
    val result = uniqueStringFinder(charFor4)
    println("Уникальная строка: $result")
    println("=====================")
}

fun task5() {
    println("=====================")
    println("Задание 5")

    println("Введите количество строк (m): ")
    val m = readln().toInt()

    println("Введите количество столбцов (n): ")
    val n = readln().toInt()

    val matrix = Array(m) { IntArray(n) }

    for (i in 0..<m) {
        for (j in 0..<n) {
            print("Введите значение для a[$i][$j]: ")
            matrix[i][j] = readln().toInt()
        }
    }

    val maxValues = findMaxInRows(matrix)

    println("Максимальные значения в каждой строке: ${maxValues.contentToString()}")
    println("=====================")
}

fun uniqueStringFinder(input: String): String {
    var maxLength = 0
    var start = 0
    var currentStart = 0
    val charIndexMap = mutableMapOf<Char, Int>()

    for ((index, char) in input.withIndex()) {
        if (charIndexMap.containsKey(char) && charIndexMap[char]!! >= currentStart) {
            currentStart = charIndexMap[char]!! + 1
        }
        val currentLength = index - currentStart + 1
        if (currentLength > maxLength) {
            maxLength = currentLength
            start = currentStart
        }
        charIndexMap[char] = index
    }
    return input.substring(start, start + maxLength)
}

fun findMaxInRows(matrix: Array<IntArray>): IntArray {
    val m = matrix.size
    val n = matrix[0].size
    val maxValues = IntArray(m)

    for (i in 0..<m) {
        var max = matrix[i][0]

        for (j in 0..<n) {
            if (matrix[i][j] > max) {
                max = matrix[i][j]
            }
        }

        maxValues[i] = max
    }

    return maxValues
}


