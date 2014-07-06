object TeachersAssistantBot {

	// Because I'm too lazy to create input parsing code
	val input = "10 10\n" +
			"ABIGAIL 11 3 5 20 4 2 8 17 4 5\n" +
			"ALEXANDER 2 12 20 0 6 10 3 4 9 7\n" +
			"AVA 11 15 2 19 14 5 16 18 15 19\n" +
			"ETHAN 6 12 0 0 5 11 0 11 12 15\n" +
			"ISABELLA 16 0 10 7 20 20 7 2 0 1\n" +
			"JACOB 2 14 17 7 1 11 16 14 14 7\n" +
			"JAYDEN 10 10 3 16 15 16 8 17 15 3\n" +
			"MADISON 10 11 19 4 12 15 7 4 18 13\n" +
			"SOPHIA 5 17 14 7 1 17 18 8 1 2\n" +
			"WILLIAM 12 12 19 9 4 3 0 4 13 14\n"

	// Prints a double with only two decimal points
 	def format(num : Double) = {
		"%.2f".format(num)
	}

	def avg(scores : Array[Float], students : Float) = {
		scores.sum / students
	}

	def main(args: Array[String]) {
		val lines = input.split("\n") // Split dem lines. Gotta have my array
		val Array(n, m) = lines(0).split(" ").map(_.toInt) // I don't really need these values, but I'll use them anyway
		val data = lines.drop(1).map(_.split(" ")).take(m) // Get an array of arrays of student/score values (currently all strings)
		val students = data.flatMap(_.filter(_.forall(!_.isDigit))) // Get an array of strings that aren't numbers (i.e., student names)
		val avgScores = data.map(_.filter(_.forall(_.isDigit)).map(_.toFloat)).map(x => avg(x, m))
		
		// Print dem results
		println(format(avg(avgScores, n)))
		for (x <- students.zip(avgScores)) { // Create array of student–average score pairs
			print(x._1) // Student name
			println(" " + format(x._2)) // Average student score
		}
	}

}