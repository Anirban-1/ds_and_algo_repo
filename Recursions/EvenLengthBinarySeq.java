/*
Given a number n, find all binary sequences of length 2n such that sum of first n
bits is same as sum of last n bits.

Example:
1)

Input:
2

Output:
0000
0101
0110
1001
1010
1111

Approach:
==========
Let's consider 2 n bit numbers that needs to be filled with 1s and 0s. With sum
of digits in each number being same the difference (diff) will be 0 when n places
have been filled in arbitrary order which will give our answer.

Let's say the left sum is x and the right sum is y.
In case we add 1 or 0 to both x and y at ith position (0<=i<n) then the current
diff remains as it is.  ----------------------------------------------------------- (1)

In case we add 1 to x and 0 to y, then the equation becomes like:
(x+1)-y which implies diff+1. ----------------------------------------------------- (2)

In case we add 0 to x and 1 to y, then the equation becomes like:
x-(y+1) which implies diff-1 ------------------------------------------------------ (3)

Therefore, implimenting the above 3 equations in the program.
*/
import java.io.*;
import java.util.*;
public class EvenLengthBinarySeq{
    static void buildSeq(StringBuilder left,StringBuilder right, int diff, int n){
        if(n==0){
            if(diff==0)
                System.out.println(left.toString()+right.toString());
            return;
        }
        for(int i=0;i<=1;i++){
            left.append(i);
            for(int j=0;j<=1;j++){
                right.append(j);
                if(i==j)
                    buildSeq(left,right,diff,n-1);
                else if(i==1)
                    buildSeq(left,right,diff+1,n-1);
                else buildSeq(left,right,diff-1,n-1);
                right.deleteCharAt(right.length()-1);
            }
            left.deleteCharAt(left.length()-1);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        buildSeq(new StringBuilder(), new StringBuilder(), 0, n);
    }
}
