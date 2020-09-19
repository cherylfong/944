# Delete Columns to Make Sorted #944

## What is a Greedy Algorithm?

A [greedy algorithm](https://brilliant.org/wiki/greedy-algorithm/) is a simple, intuitive algorithm used in optimization
problems. The algorithm makes the optimal choice at each step as it attempts to find the overall optimal way to solve
the entire problem.

In other words,
> the algorithm makes the choice that looks best at the moment, i.e. a **locally optimal choice** that may **lead** to a
> **globally optimal solution**.
>
>  &mdash; Introduction to Algorithms on page 414

This sounds like dynamic programming, however, one major difference is that dynamic programming finds optimal solutions
to subproblems before making an informed decision/choice. While greedy algorithms do not bother to with possible or
related subproblems.

## What is the Problem?

See problem [#944 on Leetcode](https://leetcode.com/problems/delete-columns-to-make-sorted/).

### Runtime and Space Complexity

The bulk of the computation occurs in `minDeletionSize(String[] A)` with an average runtime complexity of `O(N)`.

`N` is number of rows (i.e. the number of elements in `A`) multiped by the number of columns (or the length of an
element in `A`).

At first glance, the function seems to indicate an O(N^2) runtime. But the inner for-loop does not always have to be
running at the same size as the outer for-loop and, vice versa. However, in the case where `rows == columns`, then the
runtime is said to be `O(N^2)`.

The space complexity is `O(N`) where `N` is the size of the list `deleteIndices`, which is the return type of
`minDeletionSize(String[] A)`.

### What is a non-decreasing sorted order?

Non-decreasing order is to sort values (including duplicates) in ascending magnitude. It is not the same as increasing
order because `2 ≮ 2` for example in the sorted sequence `1, 2, 2, 3`. Non-decreasing order means, ordering in the form
`n ≤ n + 1`.

Hence in the case of the problem, a column is considered sorted in non-decreasing order if e.g. a column contains the a
similar sequence `[c, c, g, i, i, i, x, z]` where values are sorted in the form `n ≤ n + 1` . And of course, the
contrains of this problem assumes that all letters are lowercase (e.g. ASCII `a` in decimal is greater than `A`).