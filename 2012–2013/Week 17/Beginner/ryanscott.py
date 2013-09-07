import sys

def read_points():
	points = []
	for num in range(0, 4):
		points += tuple(int(x) for x in input('Enter point '+str(num+1)+': ').replace('(', '').replace(')', '').split(',')),
		if len(points) > 1 and points[num] in points[:-1]:
			print('ERROR: identical points')
			sys.exit(1)
	return points

def euclid_dist(pointA, pointB):
	return ((pointA[0] - pointB[0])**2 + (pointA[1] - pointB[1])**2)**0.5

def defines_square(quad_points):
	dist_set = set()
	dist_dict = {}
	side1_pointA = () #A point that forms a square side with pointA
	side2_pointA = ()
	diag_pointA = () #The point diagonally across the square from pointA
	side_dist = int()
	notA_points = quad_points[1:]
	for pointB in notA_points:
		pointA = quad_points[0]
		dist = euclid_dist(pointA, pointB)
		dist_set.add(dist)
		if dist in dist_set: #Then pointB must form a square side, since the diagonal distance must be longer
			side_dist = dist
			side1_pointA = pointB
		dist_dict[pointB] = dist
		if len(dist_set) > 2: #The only two unique distances should be the side and diagonal lengths
			return False
	diag_dist = (dist_set - {side_dist}).pop()
	notA_points.remove(side1_pointA)
	if dist_dict[notA_points[0]] == side_dist:
		side2_pointA = notA_points[0]
		diag_pointA = notA_points[1]
	else:
		diag_pointA = notA_points[0]
		side2_pointA = notA_points[1]
	#Verify that the remaining line segments have the expected distances
	for point1, point2, dist in [(side1_pointA, side2_pointA, diag_dist), \
						(side1_pointA, diag_pointA, side_dist), \
						(side2_pointA, diag_pointA, side_dist)]:
		if euclid_dist(point1, point2) != dist:
			return False
	return True

if __name__ == '__main__':
	quad_points = read_points()
	if defines_square(quad_points):
		print("Yup, it's a square")
	else:
		print('Nope, not a square')
			