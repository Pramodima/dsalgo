package dp;
/*
* In 1965, Vladimir Levenshtein defined the distance between two words as the
minimum number of "edits" it would take to transform the misspelled word into a
correct word, where a single edit is the insertion, deletion, or substitution of a single
character. For example, the Levenshtein distance between "Saturday" and "Sundays"
is 4 delete the first 'a' and 't', substitute V by 'n' and insert the trailing 's'.
—
Write a program that takes two strings and computes the minimum number of edits
needed to transform the first string into the second string.
*
* */
public class LevenshteinDistance {
}

/*
*  DP Table for Levenshtein distance
*    ______________________________________________________________________________
*   |           |         |         |        |       |        |         |         |
*   |           |   ""    |    A    |   G    |   G   |   T    |  A      |   B     |
*   |___________|_________|_________|________|_______|_______ |_________|_________|
*   |           |         |         |        |       |        |         |         |
*   |      ""   |    0    |    1    |   2    |   3   |   4    |  5      |   6     |
*   |___________|_________|_________|________|_______|________|_________|_________|
*   |           |         |         |        |       |        |         |         |
*   |       G   |   1     |    1    |    1   |   2   |   3    |   4     |  5      |
    | __________|_________|_________|________|_______|________|_________|_________|
    |           |         |         |        |       |        |         |         |
*   |       X   |   2     |    2    |   2    |  2    |   3    |  4      |  5      |
    | __________|_________|_________|________|_______|________|_________|_________|
    |           |         |         |        |       |        |         |         |
*   |       T   |    3    |    3    |   3    |   3   |   2    |  3      |   4     |
*   |___________|_________|_________|________|_______|________|_________|_________|
*   |           |         |         |        |       |        |         |         |
*   |       X   |   4     |    4    |   4    |  4    |  3     |  3      |  4      |
    | __________|_________|_________|________|_______|________|_________|_________|
    |           |         |         |        |       |        |         |         |
*   |       A   |   5     |    4    |  5     |   5   |  4     |   3     |   4     |
    | __________|_________|_________|________|_______|________|_________|_________|
    |           |         |         |        |       |        |         |         |
*   |      Y    |   6     |    5    |  5     |  6    |  5     |   4     |  4      |
    | __________|_________|_________|________|_______|________|_________|_________|
    |           |         |         |        |       |        |         |         |
    |      B    |   7     |    6    |   6    |  6    |   6    |   5     |    4    |
    |___________|_________|_________|________|_______|________|_________|_________|
    *
* */
