# stole these test cases...

import unittest
from solution import sum_list

class ListSumTester(unittest.TestCase):
	def testTwoNullLists(self):
		self.assertEqual(sum_list([], []),[0])

	def testOneNullList(self):
		self.assertEqual(sum_list([0], []), [0])
		self.assertEqual(sum_list([], [0]), [0])

	def testOneListOfZero(self):
		self.assertEqual(sum_list([5],[0]),[5])

	def testTwoSingleDigitNumbers(self):
		self.assertEqual(sum_list([4],[3]),[7])

	def testTwoSingleDigitNumbersWithCarry(self):
		self.assertEqual(sum_list([6],[7]), [3,1])

	def testTwoTwoDigitNumbersWithCarry(self):
		self.assertEqual(sum_list([2,7], [3,4]), [5,1,1])

	def testTwoThreeDigitNumbers(self):
		self.assertEqual(sum_list([6,5,4], [9,8,7]), [5,4,2,1])

	def testTwoNumbersOfDifferentLengths(self):
		self.assertEqual(sum_list([5,9,2], [7]), [2,0,3])

if __name__ == '__main__':
    unittest.main()
