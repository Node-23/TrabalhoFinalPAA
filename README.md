## How this code works?

# 1- This code gets the number of vertexes in the graph and convert to a binary as large as the vertexes number(Variable binary), then fill it with 1's (sizeToBinary function)

# 2- Get this variable binary and convert to integer, that way we get the number of max combination possibilities for that graph size.

# 3- Then we check if the dominant set of the graph is a solo vertex (isSoloDominant function)

# 4- Next we iterate all the combination possibilities checking if there is a dominant set.
    -> To check this we transform the variable j of the For loop in binary and sum all the 1's in it. If it's value is equal to the i variable in the first For loop to see if the number of vertexes is equal to the sum of vertexes in that combination

# 5- If j is equal to sum (line 30 of DominantSet.java), then we sum the lines of that vertexes in the graph matrix

# 6- Next we get that sum and check if it is filled by 1's, if so, the answer is true, then the dominant set is the that combinantion of vertexes.