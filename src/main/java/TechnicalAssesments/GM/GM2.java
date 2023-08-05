package TechnicalAssesments.GM;

public class GM2 {
    There are three stacks of disks. Disks on each stack are sorted by size in increasing order from the bottom to the top.

Our goal is to move all disks from these stacks onto the fourth stack, which is initially empty. In one move the top element of one of the stacks can be moved to the fourth stack. After moving all disks onto the fourth stack, they should be sorted by size in decreasing order from bottom to the top.

You are given three arrays: stack1 of N1 integers, stack2 of N2 integers, and stack3 of N3 integers. Each array represents a stack in which the elements are listed from bottom to top (i.e. the last element of the array is the top element of the stack).

Find the sequence of moves after which all the disks will be on the fourth stack, sorted by size in descending order. You may assume that there are no two disks of the same size.

For example, for stack1 = [2, 7], stack2 = [4, 5] and stack3 = [1], the sequence of moves is 1−2−2−1−3:

move disk of size 7 from stack 1
move disk of size 5 from stack 2
move disk of size 4 from stack 2
move disk of size 2 from stack 1
move disk of size 1 from stack 3
After these moves, the elements of the fourth stack are sorted in descending order: [7, 5, 4, 2, 1], and all other stacks are empty.

Write a function:

arduino
Copy code
class Solution {
    public String solution(int[] stack1, int[] stack2, int[] stack3);
}
that, given three arrays, stack1, stack2, and stack3, returns a string representing the sequence of moves that should be performed. The J-th character of the string should be the stack number (1, 2, or 3) from whose top the element should be moved in the J-th move.

Examples:

Given stack1 = [2, 7], stack2 = [4, 5] and stack3 = [1], the function should return "12213", as explained above.
Given stack1 = [10, 20, 30], stack2 = [8] and stack3 = [1], the function should return "11123".
Given stack1 = [7], stack2 = [] and stack3 = [9], the function should return "31".
Assume that:

N1, N2, and N3 are integers within the range [0..100];
each element of arrays stack1, stack2, and stack3 is an integer within the range [1..1,000];
disk sizes are unique, i.e. there are no two disks of the same size;
on each stack disks are sorted by size in ascending order.
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
}
