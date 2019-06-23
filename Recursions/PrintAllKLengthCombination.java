/*
Given a set of characters and a positive integer k, print all possible strings of length k
that can be formed from the given set.

Example:

1)
Input:
ab
3

Output:
aaa
aab
aba
abb
baa
bab
bba
bbb

2)
Input:
abcd
1

Output:
a
b
c
d

*/
import java.io.*;
import java.util.*;
public class PrintAllKLengthCombination{
    static void printKLengthCombination(char[]ar,StringBuilder result, int k){
        if(k==0){
            System.out.println(result.toString());
            return;
        }
        for(int i=0;i<ar.length;i++){
            result.append(ar[i]);
            printKLengthCombination(ar,result,k-1);
            result.deleteCharAt(result.length()-1);
        }
    }
    public static void main(String [] args)throws IOException{
        StringBuilder result = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char []ar=br.readLine().toCharArray();
        int k=Integer.parseInt(br.readLine());
        printKLengthCombination(ar,result,k);
    }
}
