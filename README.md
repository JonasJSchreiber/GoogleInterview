Given a continent represented by a 2d matrix with values denoting altitude at this point, find a path moving west to east where you can continuously ascend then continuously descend. If such a path exists, return the x,y values of the highest point

input:
3 2 9

2 2 2

3 4 3

output: 
{3,2} - the altitude is four and the path is 2->3->4->3

input 2: (why you need backtracking)
0  3  4  4 -1 -2

0 -1  2  1  0  2

0 -1  3 -1 -1  2

0 -1 -1 -1 -2  2

output: 
{0,2} - the altitude is 4 and the path is 0->3->4->2->1->0->(-1)->(-2) 
