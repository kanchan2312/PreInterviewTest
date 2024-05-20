package org.example;

/*
Task 3: Review multiplication method
 */
public class MutliplyMethod {

    public static final Integer multiply(Integer x, Integer y)
    {
          return (y == 0) ? 0 : multiply(x, y - 1) + x;
    }
/*
Review comments:
1) This method will fail in the case where y is negative; Please consider the case in which one of the numbers can be negative.
2) Can add condition or Exception checks like
    if x is zero or y is zero return 0  if (x == 0 || y == 0) return 0;
    if (x < 0) throw new ArgumentException("must be positive integer", "x");
    if (y < 0) throw new ArgumentException("must be positive integer", "y");
3) Should add a stopping condition right at the top that tells the function when to stop, avoiding an infinite stack in recursive calls.
 */

 //Redefine your solution as below. This solution will work for both when y>=0 and y<0

    public int multiplyNumbers(final int x, final int y) {
        if (y != 0 && x != 0) {
            if (y > 0) {
                return multiply(x, y - 1) + x;
            } else {
                return multiply(x, y + 1) - x;
            }
        }
        return 0;
    }
}
