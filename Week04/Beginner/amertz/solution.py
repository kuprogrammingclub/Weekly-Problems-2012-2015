from datetime import datetime

def what_is_fine(start, end):
    if start == end:
        return 0
    elif start.year == end.year:
        if start.month == end.month:
            return (end.day - start.day) * 15
        else:
            return (end.month - start.month) * 500
    else:
        return 10000


if __name__ == '__main__':
    dates = [datetime.strptime(line.rstrip(), '%d %m %Y') for line in open('input.txt')]
    print dates
    print what_is_fine(*dates)
