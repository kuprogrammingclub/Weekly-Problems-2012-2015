""" Requires beautifulsoup4 to be installed with pip """
from bs4 import BeautifulSoup
import urllib2
url = "http://www.weather.com/weather/5-day/Lawrence+KS+USKS0319:1:US"

# Open up a connection and create a bs4 obj
f = urllib2.urlopen(url)
soup = BeautifulSoup(f.read())
# Make a simple dict to hold everything
days = {}
# Loop over all the divs that have all our information
for block in soup.find_all('div', class_='wx-daypart'):
    info = {}
    # Grab out the day information because it's at the root of the div
    day = block.h3.contents[0].strip()
    info['date'] = block.h3.span.contents[0].strip()
    # Loop over each of our div's and p's to try and find required class
    for div in block.find_all(['div', 'p']):
        c = div['class']
        # Switch on class and extract the data
        if 'wx-temp' in c:
            info['temp_high'] = div.contents[0].strip()
        elif 'wx-temp-alt' in c:
            info['temp_low'] = div.contents[0].strip()
        elif 'wx-phrase' in c:
            info['condition'] = div.contents[0].strip()
        elif 'wx-details' in c and 'wx-event-details-link' in c:
            dl = div.find_all('dl')
            info['precip_chance'] = dl[0].dd.contents[0].strip()
            info['wind'] = dl[1].dd.contents[0].strip()
    # put the information into the big dict
    days[day] = info
# read out the information all pretty
for day, info in days.iteritems():
    print "{} : {}".format(day, info['date'])
    print "    High: {}".format(info['temp_high'])
    print "    Low: {}".format(info['temp_low'])
    print "    Description: {}".format(info['condition'])
    print "    Wind: {}".format(info['wind'])
    print "    Chance of Precipitation: {}".format(info['precip_chance'])
