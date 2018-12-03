import unittest


def coin_problem_one(n, m):
    data = [100, 50, 20, 10, 5, 2, 1]
    remainder = n - m
    result = 0
    for i in data:
        score = remainder / i
        if score != 0:
            result += int(score)
            remainder = remainder % i
    return result


# TODO 利用递归
def coin_problem_two(n, m):
    pass


class MainTest(unittest.TestCase):
    def test_one(self):
        result = coin_problem_one(100, 29)
        self.assertEqual(result, 3)


if __name__ == '__main__':
    unittest.main()
