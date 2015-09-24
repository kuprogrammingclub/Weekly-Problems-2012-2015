from math import sqrt
from random import random

def magnitude(start, final):
    return sqrt(pow((start[0] - final[0]), 2) + pow((start[1] - final[1]), 2))

def generate_moves(moves):
    for n in range(moves):
        yield (random(), random())

def find_distance(start, positions, distance):
    if len(positions) > 0:
        index = 0
        min_dist = magnitude(start, positions[index])
        for i in range(len(positions)):
            mag = magnitude(start, positions[i])
            if mag < min_dist:
                min_dist = mag
                index = i
        distance += min_dist
        start = positions[index]
        del positions[index]
        return find_distance(start, positions, distance)
    else:
        return distance

starting_position = (0.5, 0.5)
moves = input('Enter the number of moves: ')
positions = [pos for pos in generate_moves(moves)]
print find_distance(starting_position, positions, 0)

test_case = [(0.9, 0.7), (0.7, 0.7), (0.1, 0.1),
(0.4, 0.1), (0.6, 0.6), (0.8, 0.8)]

assert find_distance(starting_position, test_case, 0) == 1.667103925399036, 'False' 
