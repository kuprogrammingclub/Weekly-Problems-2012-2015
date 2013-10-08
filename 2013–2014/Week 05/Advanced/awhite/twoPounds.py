#Don't do it like this, way to slow
def firstTry():
    combo = [[a,b,c,d,e,f,g,h] for a in range(201) for b in range(101) for c in range(41) for d in range(21) for e in range(11) for f in range(5) for g in range(3) for h in range(2)]
    print [combo[i] for i in len(combo) if (combo[i][0] + combo[i][1] * 2 + combo[i][2] * 5 + combo[i][3] * 10 + combo[i][4] * 20 + combo[i][5] * 50 + combo[i][6] * 100 + combo[i][7] * 200) == 200]

#This way completes in a few seconds
def main():
    sum = 0
    count = 0
    for a in range(2):
        sum += 200 * a
        if sum > 200: sum -= 200 * a; break
        for b in range(3):
            sum += 100 * b
            if sum > 200: sum -= 100 * b; break
            for c in range(5):
                sum += 50 * c
                if sum > 200: sum -= 50 * c; break
                for d in range(11):
                    sum += 20 * d
                    if sum > 200: sum -= 20 * d; break
                    for e in range(21):
                        sum += 10 * e
                        if sum > 200: sum -= 10 * e; break
                        for f in range(41):
                            sum += 5 * f
                            if sum > 200: sum -= 5 * f; break
                            for g in range(101):
                                sum += 2 * g
                                if sum > 200: sum -= 2 * g; break
                                for h in range(201):
                                    sum += h
                                    if sum == 200:
                                        print '{0}xL2 + {1}xL1 + {2}x50p + {3}x20p + {4}x10p + {5}x5p + {6}x2p + {7}x1p'.format(a, b, c, d, e, f, g, h)
                                        count += 1
                                        sum -= h
                                        break
                                    elif sum > 200: sum -= h; break
                                    sum -= h
                                sum -= 2 * g
                            sum -= 5 * f
                        sum -= 10 * e
                    sum -= 20 * d
                sum -= 50 * c
            sum -= 100 * b
        sum -= 200 * a
    print 'Count = ', count

if __name__ == '__main__':
    main()