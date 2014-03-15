#!/usr/bin/python3
import sys

# Globals
literals = []
symbols = ['(', ')', '`', '&', '+']
table = []
corres = {}

# Determine how many variables are in our expression
def countVars(expr):
    for i in expr:
        if i.isalpha() == True and literals.count(i) == 0:
            literals.append(i)
    literals.sort()

# Construct Truth Table
def buildTable(expr):
    for i in range(0, len(literals)):
        table.append([])
        for j in range(0, 2 ** len(literals)):
            if (j // (2 ** (len(literals) - i - 1))) % 2 == 0:
                table[i].append(literals[i] + '`')
            else:
                table[i].append(literals[i])
"""
    for i in range(0, 2 ** len(literals)):
        col = []
        for j in range(0, len(literals)):
            col.append(table[i][j])
        evalExpr(expr, col)

def evalExpr(expr, col):
"""    

# Print a Truth Table
def printTable():
    for i in range(0, len(table)):
        for j in range(0, len(table[0])):
            if len(table[i][j]) == 2:
                print('0 ', end = ' ')
            else:
                print('1 ', end = ' ')
        print()

def main(expr):
    countVars(expr)
    buildTable(expr)
    printTable()

if __name__ == "__main__":
    main(sys.argv[1])
