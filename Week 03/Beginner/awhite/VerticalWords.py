import sys

def main():
    num_words = int(sys.stdin.readline())
    words = []
    
    for i in range(num_words):
        words.append(sys.stdin.readline())
    print '----------------------'
        
    for i in range(256):
        for word in words:
            if len(word) - 1 > i: sys.stdout.write(word[i])
            else: sys.stdout.write(' ')
        sys.stdout.write('\n')

if __name__ == '__main__':
    main()