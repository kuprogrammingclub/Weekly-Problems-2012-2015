import httplib
import urllib
import xml.etree.ElementTree as ET
import re
import sys
from collections import deque
import copy

DEPTH_FIRST = 0
BREADTH_FIRST = 2
SPIKY = 1


"""
Inspiration!!!!!! 

implement the dictionary in GetData and figure out what the error is about.

Copy the queue and go through it, "getting data" for everything, then use the dictionary made until it runs out

"""

cache = {}
futureRequests = []
def __main__():
    handler(BREADTH_FIRST)



def handler(searchType):
    path = []
    startpoint = raw_input("Input the Wikipedia page where you'd like to start: ")

    endpoint = raw_input("Input your desired Wikipedia endpoint: ")
    data =  getData(startpoint)
    page = startpoint
    #graph is wikipedia, vertex is page, edge is link (vertices and edges are about the same thing
    cache[page.lower()] = process(data)
    
    if searchType == DEPTH_FIRST:
        path = dfs(page, endpoint,5)
        path.append(startpoint)
        path.reverse() #the path is returned in reverse order, so I'll reverse it before printing it.
    elif searchType == SPIKY:
        path = spikyDfs(page, endpoint,5)
        path.append(startpoint)
        path.reverse() 
    elif searchType == BREADTH_FIRST:
        bfs(page, endpoint, 5)

    
    print path




def bfs(page, end, depth):
    path = []
    visited = []
    queue = deque([[page]]) # pages to be searched
    #use queue.popleft() to get the first person in line
    iterations = 0
    while len(queue) > 0 and iterations <= depth:
        thisPagePath = queue.popleft()
        print thisPagePath
        iterations = len(thisPagePath)
        #print iterations
        thisPage = thisPagePath[len(thisPagePath)-1]
        if thisPage.lower() == end.lower():
            return thisPagePath
        data = getData(thisPage)
        if data != None:
            cache[thisPage.lower()] = process(data)
            for edge in cache[thisPage.lower()]:
                if not edge in visited:
                    visited.append(edge)
                    appendedPath = copy.deepcopy(thisPagePath)
                    appendedPath.append(edge)
                    queue.append(appendedPath)
                    if edge.lower == end.lower():
                        return appendedPath
    return "No path was found"
                    
    
    
def spikyDfs(page, end, depth):
    """Depth first search through wikipedia for endpoint - 
    looks at all links on page before diving to the next page,
    I think that will work a bit better."""
    
    print "Visiting:", page
    #raw_input("enter to continue")

    for link in cache[page.lower()]:
        if link.lower() == end.lower():
            print "      found!"
            print "      returning",end
            return [end]
    if depth <= 0:
        print "----Max depth reached!", depth
        return None
    for link in cache[page.lower()]:
        if not link.lower() in cache:
            print "Caching:", link
            data = getData(link)
            if data == None:
                return None
            cache[link.lower()] = process(data)
            path = spikyDfs(link, end, depth-1)
            if path != None:
                path.append(link)
                print "      returning", path
                return path
                
                #path returns none when it didn't find the answer,
        else:
            #link has already been visited, no need to continue!
            print "      Visited! We've already seen", link
            pass
    print "      Returning None"
    return None

def dfs(page, end, depth):
    """Depth first search through wikipedia for endpoint"""
    if depth <=0:
        return None
    print page
    #raw_input("enter to continue")
    for link in cache[page.lower()]:
        if link.lower() == end.lower():
            print "      found!"
            print "      returning",end
            return [end]
        elif not link.lower() in cache:
            data = getData(link)
            if data == None:
                return None
            cache[link.lower()] = process(data)
            path = dfs(link, end, depth - 1)
            if path != None:
                path.append(link)
                print "      returning", path
                return path
                
                #path returns none when it didn't find the answer,
        else:
            #link has already been visited, no need to continue!
            print "      Visited! We've already seen", link
            pass
    print "      pReturning None"
    return None
    



def process(string):
    links = [] #will contain ALL links on the page that apply to the criteria
    if len(sys.argv) > 1 and sys.argv[1] == "raw":
        print data
    
    #removeReferences attempts to remove <ref></ref> tags in order to delete irrelevant links
    data = removeReferences(string)
    imagelessData = removeImages(data)
    protected = protectParentheses(imagelessData)
    protectedRemoved = remove(protected)
    finalData = returnParentheses(protectedRemoved)
    if len(sys.argv) > 1 and sys.argv[1] == "final":
        print finalData
    matches = re.finditer("\[\[.+?\]\]", finalData)

    for link in matches:
        stringlink = link.group(0)
        
        #trim off leading [[ and trailing ]] and everything after |
        stringlink = stringlink.strip("[]")
        match = re.search("\|", stringlink)
        if stringlink[0] != "#": #My program should not follow links that start with # because those are page-internal links
            if match:
                links.append(stringlink[:match.start()])
            else:
                links.append(stringlink)
        
        
            
    
    return links



def removeReferences(string):
    """attempt to remove <ref orange="stuff">THIS [[invalid link]]</ref> from text"""
    pattern = "<ref[^>/]*?>.+?</ref>"
    return re.sub(pattern, "", string, flags=re.DOTALL)


def removeImages(string):

    #handles images and other edge cases
    match = re.search("\[\[[^:\]]*?[:][^\]]+?\]\]", string)
    while match:

        endString = 0
        numBrackets = 0
        for x in range(match.start(), len(string)):
            #find the end of the entireeee thing
            if string[x] == "[":
                numBrackets += 1

            elif string[x] == "]":
                numBrackets -= 1

            if numBrackets == 0:
                endString = x
                break
        if match.start() <= endString:
            string = string[:match.start()] + string[endString+1:]
            
        else:
            print "          Error: Unbalanced brackets detected", match.start(), endString
            print "          Removing the culprit..."

            string = string[:match.start()+1] + string[match.start() + 3:]
            #sys.exit(0)
            
        match = re.search("\[\[[^:\]]*?[:][^\]]+?\]\]", string)

    #Edge case 1:
    
    match = re.search("{", string)
    
    while match:

        endString = 0
        numBrackets = 0
        for x in range(match.start(), len(string)):
            
            #find the end of the entireeee thing
            if string[x] == "{":
                numBrackets += 1
                #print numBrackets

            elif string[x] == "}":
                numBrackets -= 1
                #print numBrackets

            if numBrackets == 0:
                endString = x
                break
        if match.start() < endString:
            string = string[:match.start()] + string[endString+1:]
        #elif match.start() == endString:
            #pass
        else:
            print "          Error: Unbalanced braces detected", match.start(), endString
            print "          Removing the culprit..."
            string = string[:match.start()] + string[match.start() + 1:]
        match = re.search("{", string)
        
    return string

def protectParentheses(string):
    matchBox = re.finditer("\[\[[^\]]+?\]\]", string)
    parenDic = {}
    for match in matchBox:

        
        for x in range(match.start(), match.end()):

            if string[x] == "(":
                parenDic[x] = "("

            elif string[x] == ")":
                parenDic[x] = ")"
        
    parenLocations = parenDic.keys()
    parenLocations.sort()
    parenLocations.reverse()
    #go through the string backwards so that the future indices of parentheses are unchanged
    for location in parenLocations:
        if parenDic[location] == "(":
            tempString = string[:location] + "&?5203;" + string[location+1:]
            string = tempString
        elif parenDic[location] == ")":
            tempString = string[:location] + "&?7203;" + string[location+1:]
            string = tempString
        
    return string

def returnParentheses(string):
    string = re.sub("&\?5203;", "(", string)
    string = re.sub("&\?7203;", ")", string)
    return string


def remove(string):
    pattern = "([^']''[^']+?''[^'])|(<!--.+?-->)|(<nowiki>.+?</nowiki>)|(\(.+?\))"
    return re.sub(pattern, "", string, flags=re.DOTALL)


WikiPath.bulkDataBackend(['Mathematics','HAL 9000','GLaDOS'])


f = open("file.filefile", "w")
def getData(userInput):
    #connection settings
    conn = httplib.HTTPConnection("en.wikipedia.org")
    prefix = "/w/api.php?"
    format = "xml"
    action = "query"
    titles = urllib.quote(userInput)
    prop = "revisions"
    rvprop = "content"
    #build the url
    request = "{0}format={1}&action={2}&titles={3}&prop={4}&rvprop={5}".format(prefix, format, action, titles, prop, rvprop)
    #print request
    #get the url
    conn.request("GET", request)
    r1 = conn.getresponse()
    temp = r1.read()

    f.write(request)
    xml = ET.fromstring(temp)
    #get only what I want from the response
    try:
        data = xml[0].find("pages")[0][0][0].text.encode('ascii', 'xmlcharrefreplace')
    except IndexError:
        print "          Error: dead end page"
        return None
    
    return data



def bulkDataBackend(userInput):
    """takes an array of pages and adds them to the cache dictionary"""
    #connection settings
    conn = httplib.HTTPConnection("en.wikipedia.org")
    prefix = "/w/api.php?"
    format = "xml"
    action = "query"
    titles = ""
    for title in userInput:
        titles = titles + urllib.quote(title) + '|'
    prop = "revisions"
    rvprop = "content"
    #build the url
    request = "{0}format={1}&action={2}&titles={3}&prop={4}&rvprop={5}".format(prefix, format, action, titles, prop, rvprop)
    f.write(request)
    #print request
    #get the url
    conn.request("GET", request)
    r1 = conn.getresponse()
    temp = r1.read()

    xml = ET.fromstring(temp)
    #get only what I want from the response
    
    for page in xml.iter('page'):
        try:
            tempData = page[0][0].text.encode('ascii', 'xmlcharrefreplace')
            toAdd = process(tempData)
            cache[page.attrib['title'].lower()] = toAdd
            print "added", page.attrib['title']
        except IndexError:
            print "          Error: dead end page"
        
    
    #return data    

    
if __name__ == "__main__":
    __main__()
