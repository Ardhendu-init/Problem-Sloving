Logic:
The tricky part of this question is identifying when to use a ladder or when to use bricks. At first it may seem like we should only use ladders in situations where we can't use bricks. Actually, this isn't too far from how this implementation works! We can reword this to instead say that we prefer to use ladders at larger height jumps.
​
We'll use the below example with inputs: heights = [1,3,4,6,1,4,5], bricks = 3, ladders = 2. The numbers below the buildings indicate the height required to jump to that building.
image
​
Key Observation:
​
If we can hypothetically make it to any index i, then we would like to use our ladders for all the largest jumps and our bricks for the smallest jumps! Observe the following sequences to see how this works in our above example.
​
Link :-https://leetcode.com/problems/furthest-building-you-can-reach/discuss/2176616/Visual-Explanation-or-JAVA-Max-Heap
​
How to Implement This in Code:
The algorithm for this is quite simple! We'll store all the non-zero height jumps in a priority queue to represent our max heap. We can do this because we only ever care about the greatest height jump that occurred so far that hasn't been occupied by a ladder. As such, we don't really care about where it is!
Whenever we run out of bricks, we'll add the top of the heap (i.e. the largest height so far) back to our bricks and subtract 1 ladder. If we're out of both supplies, we return our current index.