import unittest
from Matcher import Matcher

class MatcherTester(unittest.TestCase):

	def testEmptyString(self):
		self.assertTrue(Matcher.isMatching(""))
		
	def testOnePairOfParenthesis(self):
		self.assertTrue(Matcher.isMatching("()"))
		
	def testOnePairOfBrackets(self):
		self.assertTrue(Matcher.isMatching("[]"))
		
	def testOnePairOfBraces(self):
		self.assertTrue(Matcher.isMatching("{}"))
		
	def testSingleParenthesis(self):
		self.assertFalse(Matcher.isMatching("("))
		
	def testUnmatchedSinglePair(self):
		self.assertFalse(Matcher.isMatching("(]"))
		
	def testComplexMatched(self):
		self.assertTrue(Matcher.isMatching("(){asdf[[asdf](alksjdf)]asdf}"))
	
	def testComplexFailure(self):
		self.assertFalse(Matcher.isMatching("({[(])})"))
		
	def testComplexUnmatchedException(self):
		self.assertFalse(Matcher.isMatching("(asdf[dfdas{}(asdf])"))
		
if __name__ == '__main__':
    unittest.main()