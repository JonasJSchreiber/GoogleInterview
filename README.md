Given a continent represented by a 2d matrix with values denoting altitude at each position, find a path moving west to east where you can continuously ascend then continuously descend. If such a path exists, return the x,y values of the highest point

input:

     3 2 9
     2 2 2
     3 4 3

output: 

{3,2} - the altitude is four and the path is 2->3->4->3

input 2: 

Why you need backtracking: 

Suppose you always tried east, then south, then north and optimistically chose the path if using lookahead one turn determined that you have a viable path that way. 

You'd wind up in a dead end (0->3->4->2->1->0->-1->-2 (at 4th row 5th column) with 2 to the east, and -1 to the west, both violating the up/down constraint.

     0  3  4  4 -1 -2
     0 -1  2  1  0  2
     0 -1  3 -1 -1  2
     0 -1 -1 -1 -2  2

output: 

{0,2} - the altitude is 4 and the path is 0->3->4->2->1->0->(-1)->(-2) 
