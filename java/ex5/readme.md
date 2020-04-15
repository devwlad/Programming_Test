In this exercise I actually followed two approaches to the problem:

* CustomList
The first code I wrote had a SinglyLinkedList class that I created which had a method to remove duplicates.
Took me some time to write and, after I finished, I noticed it had a not so good cost O(n<sup>2<sup>). Because of that, I scrapped the idea and decided to start again.

* LinkedList
On the second code I decided to use Java's LinkedList and a HashSet. - I believe the use of the HashSet was not necessary, but I kinda like to use it because it's simple.
This time, the cost of the algorithm is lower, standing at O(n), as I only have to iterate once through the LinkedList to remove all duplicates.