package com.xnux.sandbox
object Quine {
  val q = 34
  val l = List(
	"package com.xnux.sandbox",
    "object Quine",
    "  val q = 34",
    "  val l = List(",
    "    ",
    "  )",
    "  def main(args: Array[String]) {",
    "    (0 to 3).foreach(i => println(l(i)))",
    "    (0 to l.size-1).foreach(i => println(l(4) + q.toChar + l(i) + q.toChar + ','))",
    "    (4 to l.size-1).foreach(i => println(l(i)))",
    "  }",
    "}"
  )
  def main(args: Array[String]) {
    (0 to 3).foreach(i => println(l(i)))
    (0 to l.size-1).foreach(i => println(l(4) + q.toChar + l(i) + q.toChar + ','))
    (5 to l.size-1).foreach(i => println(l(i)))
  }
}