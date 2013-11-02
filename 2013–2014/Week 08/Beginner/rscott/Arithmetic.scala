package com.xnux.sandbox

import scala.annotation.tailrec
import scala.util.Random

object Arithmetic {	
	
	val SECONDS = 1000000000 // A very important, zero-y number
	type BinIntOp = (String, (Int, Int) => Int) // Include name of op as string for convenience
	
	def randomOp: BinIntOp = Random.nextFloat match {
		case f if (f <= 1.0/3.0) => (" + ", (_+_))
		case f if (f <= 2.0/3.0) => (" - ", (_-_))
		case _ => (" * ", (_*_))
	}
	
	def readAnswer(answer: Int, rights: Int = 0, wrongs: Int = 0): (Int, Int) = {
		try {
			val guess = readLine.toInt
			if (guess == answer) {
				println("Right!")
				(rights + 1, wrongs)
			} else {
				println("What?")
				readAnswer(answer, rights, wrongs + 1)
			}
		} catch {
			case e: Exception => println("Please type a number."); readAnswer(answer, rights, wrongs)
		}
	}
	
	def parseMult(l: List[Any]): List[Any] = l match {
		case (n1: Int) :: (op: BinIntOp) :: (n2: Int) :: tail if (op._1 == " * ") => parseMult(op._2(n1, n2) :: tail)
		case (n1: Int) :: (op: BinIntOp) :: (n2: Int) :: tail => n1 :: op :: parseMult(n2 :: tail)
		case (n: Int) :: Nil => l
		case _ => throw new IllegalArgumentException
	}
	
	/** Go through the expression and ONLY evalate multiplications... */
	@tailrec def parseAddSub(l: List[Any]): Int = l match {
		case (n1: Int) :: (op: BinIntOp) :: (n2: Int) :: tail => parseAddSub(op._2(n1, n2) :: tail)
		case (n: Int) :: Nil => n
		case _ => throw new IllegalArgumentException
	}
	
	@tailrec def arithmetic(rights: Int, wrongs: Int, startTime: Long): Unit = {
		val n1 = Random.nextInt(10)
		val n2 = Random.nextInt(10)
		val n3 = Random.nextInt(10)
		val n4 = Random.nextInt(10)
		val op1 = randomOp
		val op2 = randomOp
		val op3 = randomOp
		val expr = List(n1, op1, n2, op2, n3, op3, n4)
		
		print(n1 + op1._1 + n2 + op2._1 + n3 + op3._1 + n4 + " =   ")
		val ans = parseAddSub(parseMult(expr))
		val (newRights, newWrongs) = readAnswer(ans)
		val totalRights = rights + newRights
		val totalWrongs = wrongs + newWrongs
		val totalProbs = totalRights + totalWrongs
		
		if (totalProbs % 20 == 0) {
			val rightPercent = math.round(100*totalRights.toFloat / totalProbs)
			val curTime = System.nanoTime
			val timeSpent = curTime - startTime
			val timePerProb = timeSpent / (totalProbs * SECONDS.toFloat)
			lazy val waitTime = System.nanoTime - curTime
			
			println("\n\nRights %d; Wrongs %d; Score %d%%".format(totalRights, totalWrongs, rightPercent))
			println("Total time %d seconds; %.1f seconds per problem\n".format(timeSpent/SECONDS, timePerProb))
			println("Press RETURN to continue...")
			Console.readLine
			println
			arithmetic(totalRights, totalWrongs, startTime + waitTime)
		} else {
			arithmetic(totalRights, totalWrongs, startTime)
		}
	}
	
	def main(args: Array[String]) = arithmetic(0, 0, System.nanoTime)

}