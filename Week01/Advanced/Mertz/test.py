import unittest
from adv2 import sum_number

class TestAdvTwo(unittest.TestCase):

    def test_32678(self):
        self.assertEqual(sum_number(32678), 26)

if __name__ == '__main__':
    unittest.main()
