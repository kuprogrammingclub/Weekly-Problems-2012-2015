import sys
dic = {'a':'4', 'b':'8', 'e':'3', 'g':'6', 'h':'#', 'k':'|<', 'l':'1', 'o':'0', 's':'5', 't':'7', 'z':'2'}
for ch in sys.argv[1].lower():
    if ch in dic:
        sys.stdout.write(dic.get(ch))
    else:
        sys.stdout.write(ch)
sys.stdout.write('!!!!1111!')
