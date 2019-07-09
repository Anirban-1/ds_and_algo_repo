/*
Given an input string and a dictionary of words, find out if the input string can
be segmented into a space-separated sequence of dictionary words.
Notes:
1) Same word in the dictionary can be reused.
2) You can consider the dictionary will contain unique words.
Example:

1)Input:
i like
ilike

Output:
true

2) Input:
apple pen
applepenapple

Output:
true

3) Input:
a
b

Output:
false
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class WordBreak {
    static Set<String>set;
    static String str;
    static int[][]dp;
    static boolean f(int i,int j){
        if(i>j)return false;
        if(dp[i][j]!=-1)return dp[i][j]==1;
        if(set.contains(str.substring(i,j+1))){
            dp[i][j]=1;
            return true;
        }
        boolean ans=false;
        for(int k=i;k<j;k++){
            ans=ans||(f(i,k)&&f(k+1,j));
        }
        dp[i][j]=ans?1:0;
        return ans;
    }
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        set=new HashSet<String>();
        String[]in=br.readLine().split(" ");
        for(int i=0;i<in.length;i++)set.add(in[i]);
        str=br.readLine();
        int n=str.length();
        dp=new int[n][n];
        for(int i=0;i<n;i++)for(int j=0;j<n;j++)dp[i][j]=-1;
        System.out.println(f(0,n-1));
    }
}
