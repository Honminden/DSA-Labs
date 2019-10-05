# LAB 1  INT ARRAY EDITOR

## Problem
To implement a most powerful editor for integer sequences. The sequence is just an empty list when initialized, and the editor for the sequence should support the following 5 operations:

| Operation | Description |
| :--- | :--- |
| I | Insert after the cursor |
| L | Move the cursor left unless it’s at the first element |
| R | Move the cursor right unless it’s at the last element |
| D | Delete the element before the cursor |
| Q | Suppose the current sequence before the cursor is a1,..., an, Output max(sum(a1, ..., ai))(1<=i<=k). |

## De Facto Deadline
19 Sep 2019 19:00

## Revision After Submission
* bug: fix the problem that head and tail are left unchanged after a remove operation
* others: several decorations
