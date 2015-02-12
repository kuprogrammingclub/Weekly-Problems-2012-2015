// Playground - noun: a place where people can play

func fib(n: Int) -> Int {
    return n < 2 ? n : (fib(n-1) + fib(n-2))
}
for i in 1...15 {
    println(fib(i))
}

