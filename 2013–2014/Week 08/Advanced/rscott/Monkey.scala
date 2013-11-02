package com.xnux.sandbox

import java.io.PrintWriter

object Monkey {
	
	def sumDigits(n: Int): Int = n.toString.map(_.asDigit).sum
	
	def safe(x: Int, y: Int): Boolean = sumDigits(math.abs(x)) + sumDigits(math.abs(y)) <= 19
	
	def monkeySee(x: Int, y: Int, tested: Set[(Int, Int)] = Set()): Set[(Int, Int)] = {
		List((x+1,y), (x-1, y), (x, y+1), (x, y-1)).foldLeft(tested)((set, coords) => {
			if (safe(coords._1, coords._2) && !set.contains(coords)) {
				monkeySee(coords._1, coords._2, set + coords)
			} else {
				set
			}
		})
	}
	
	def main(args: Array[String]) = {
		val ms = monkeySee(0, 0)
		println(ms.size)
		
		val (maxY, minX, maxX, minY) = ms.foldLeft((-1, 1, -1, 1))((extrs, coords) => {
			val largerY = extrs._1 < coords._1
			val smallerX = extrs._2 > coords._2
			val largerX = extrs._3 < coords._2
			val smallerY = extrs._4 > coords._1
			(if (largerY) coords._1 else extrs._1, if (smallerX) coords._2 else extrs._2,
					if (largerX) coords._2 else extrs._3, if (smallerY) coords._1 else extrs._4)
		})
		
		// Write the grid to file, because why not
		Some(new PrintWriter("output.txt")) foreach(p => {
			maxY to minY by -1 foreach(y => {
				minY to maxY foreach(x => {
					if (ms.contains((x,y))) {
						if (x == 0 || y == 0) {
							p.print('█')
						} else {
							p.print('X')
						}
					} else {
						p.print(' ')
					}
				})
				p.println()
			})
			p.close()
		})
	}
}