import io

def remove_punc(word):
    new_word = ''
    for idx in range(len(word)):
        if word[idx] in ('abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'):
            new_word += word[idx]
    return new_word

if __name__ == '__main__':
    book_stream = io.open('book.txt', 'r', encoding='utf8')
    book = book_stream.read()
    word_counts = {}
    
    for word in book.split():
        word = remove_punc(word)
        if word not in word_counts.keys():
            word_counts[word] = 1
        else:
            word_counts[word] += 1
    for word in word_counts.keys():
        print '{0}:{1}'.format(word, word_counts[word])
    
    