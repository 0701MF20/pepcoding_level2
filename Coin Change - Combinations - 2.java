Coin Change - Combinations - 2
  
1. You are given a number n, representing the count of coins.
2. You are given n numbers, representing the denominations of n coins.
3. You are given a number "amt".
4. You are required to calculate and print the combinations of the n coins (same coin can be used 
     again any number of times) using which the amount "amt" can be paid.

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
               force you but the intention is to teach a concept. Play in spirit of the question.

  import java.io.*;
public class coin_change2 {

    public static void coinChange(int i, int[] coins, int amtsf, int tamt, String asf) {
        // Base condition where the i equals to the coins total length
if(i==coins.length)
{
    //where thae total amt euals to the amt sf. 
    if(amtsf==tamt)
    {
        System.out.println(asf);
    }
    return;
}
    //Loop iterating from (tamt-amtsf)/coins[i] to 1
        for(int m=(tamt-amtsf)/coins[i];m>=1;m--)
        {
            //Then add the number into string for a number of times and after that add to the part
           String part="";
           for(int k=1;k<=m;k++)
           {
            part=part+coins[i]+"-";
           }
           //Recursive call
            coinChange(i+1,coins,amtsf+coins[i]*m,tamt,asf+part);
        }
        
        coinChange(i+1,coins,amtsf,tamt,asf);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        coinChange(0, coins, 0, amt, "");
    }
}
