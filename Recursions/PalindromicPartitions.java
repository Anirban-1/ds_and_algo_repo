/*
* Given a string, print all possible palindromic partitions of the given string.
Example:
=============
1)
Input:
meoem

Output:
m | e | o | e | m
m | eoe | m
meoem

2)
Input:
abc

Output:
a | b | c

3)
Input:
noition

Output:
n | o | i | t | i | o | n
n | o | iti | o | n
n | oitio | n
noition
*/
import java.util.*;
import java.io.*;
class PalindromicPartitions{
    static LinkedList<String>q;
    static boolean isPalindrome(String str, int i, int j){
        while(i<=j){
            if(str.charAt(i)!=str.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
    static void print(String str, int start, int n){
        if(start>=n){
            for(int i=0;i<q.size();i++){
                System.out.print(q.get(i));
                if(i<q.size()-1)System.out.print(" | ");
            }
            System.out.println();
            return;
        }
        for(int i=start;i<n;i++){
            if(isPalindrome(str,start,i)){
                q.addLast(str.substring(start,i+1));
                print(str,i+1,n);
                q.removeLast();
            }
        }
    }
    public static void main(String [] args)throws IOException{
        q=new LinkedList<String>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        print(str,0,str.length());
    }
}
