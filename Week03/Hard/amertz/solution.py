from math import sqrt
from random import random

def magnitude(start, final):
    return sqrt(pow((start[0] - final[0]), 2) + pow((start[1] - final[1]), 2))


def generate_moves(moves):
    for n in range(moves):
        yield (random(), random())

starting_position = (0.5, 0.5)
moves = input('Enter the number of moves: ')
positions = [pos for pos in generate_moves(moves)]
positions.insert(0, starting_position)
distance = sum([magnitude(positions[i - 1], positions[i]) for i in range(1, len(positions))])

print distance
