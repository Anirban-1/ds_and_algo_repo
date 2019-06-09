/*
Given two integers ‘m’ and ‘sum’, find count of all m digit numbers with sum of digits
as ‘sum’. Leading 0’s are not counted as digits.
*/
import java.io.*;
import java.util.*;
public class MDigitNumberWithSumS{
    public static void main(String[] args)throws IOException{
        final int MOD=1000000007;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[]in=br.readLine().split(" ");
        int m=Integer.parseInt(in[0]),sum=Integer.parseInt(in[1]);
        int[][]dp=new int[m+1][sum+1];
        dp[0][0]=1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=sum;j++){
                for(int digit=(i==1)?1:0;digit<=9;digit++){
                    if(j>=digit)
                        dp[i][j]=(dp[i][j]%MOD+dp[i-1][j-digit]%MOD)%MOD;
                }
            }
        }
        if(dp[m][sum]==0)dp[m][sum]=-1;
        System.out.println(dp[m][sum]);
    }
}
