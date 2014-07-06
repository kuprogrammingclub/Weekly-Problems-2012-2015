import re
import sys

PATH = '/home/xnux/workspace/PySandbox/solved/words.txt'

def load_dictionary(path, chosen_len):
	words = open(path, 'r')
	dictionary = []
	for word in words:
		word = word.strip()
		if re.match('^[a-z]*$', word) and len(word) == chosen_len:
			dictionary.append(word)
	return dictionary

def find_close_matches(dictionary):
	matches = {}
	for word in dictionary:
		for i in range(len(word)):
			pattern = word[:i] + '_' + word[i+1:]
			if pattern in matches:
				matches[pattern] += [word]
			else:
				matches[pattern] = [word]
	return matches

def make_graph(matches):
	graph = {}
	for pattern in matches.keys():
		for wordA in matches[pattern]:
			for wordB in matches[pattern]:
				if wordA != wordB:
					if wordA in graph:
						graph[wordA] += [wordB]
					else:
						graph[wordA] = [wordB]
	return graph

def bf_search(graph, start, end, q=[]):
	temp_path = [start]
	q += [temp_path]
	while len(q) > 0:
		tmp_path = q.pop(0)
		last_node = tmp_path[len(tmp_path)-1]
		if last_node == end:
			return tmp_path
		for link_node in graph[last_node]:
			if link_node not in tmp_path:
				new_path = []
				new_path = tmp_path + [link_node]
				q += [new_path]

if __name__ == '__main__':
	sys.setrecursionlimit(50000)
	start = input('Enter your starting word: ')
	end = input('Enter your ending word: ')
	if len(start) != len(end):
		print('ERROR: Starting and ending word are not the same length')
		sys.exit(1)
	
	dictionary = load_dictionary(PATH, len(start))
	if start not in dictionary or end not in dictionary:
		print('ERROR: Starting or ending word is not dictionary word')
		sys.exit(1)
	
	matches = find_close_matches(dictionary)
	graph = make_graph(matches)
	print(bf_search(graph, start, end))