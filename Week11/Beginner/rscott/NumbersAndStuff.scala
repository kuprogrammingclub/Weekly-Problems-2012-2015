object Main {
    val nums = (1 to 1000).toArray

    def numbersAndStuff(i: Int): Unit = try {
        Console.println(nums(i))
        numbersAndStuff(i + 1)
    } catch {
        case _: Throwable => () // Ignore exceptions, especially ArrayOutOfBoundsExceptions
    }

    def main(args: Array[String]): Unit = {
        numbersAndStuff(0)
    }
}
