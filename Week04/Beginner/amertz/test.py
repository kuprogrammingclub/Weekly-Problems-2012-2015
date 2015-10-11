from datetime import datetime
import unittest

from solution import what_is_fine

class TestSolution(unittest.TestCase):

    def test_same_date(self):
        a = datetime(2015, 9, 9)
        b = datetime(2015, 9, 9)
        self.assertEqual(what_is_fine(a, b), 0, 'Same date failed')

    def test_same_month(self):
        a = datetime(2015, 9, 6)
        b = datetime(2015, 9, 9)
        self.assertEqual(what_is_fine(a, b), 45, 'Same month failed')

    def test_same_year(self):
        a = datetime(2015, 9, 6)
        b = datetime(2015, 12, 9)
        self.assertEqual(what_is_fine(a, b), 1500, 'Same year failed')

    def test_different_year(self):
        a = datetime(2015, 9, 6)
        b = datetime(2016, 9, 9)
        self.assertEqual(what_is_fine(a, b), 10000, 'Different year failed')


if __name__ == '__main__':
    unittest.main()
