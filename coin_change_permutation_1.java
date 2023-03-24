import java.io.*;

public class coin_change_permutation_1 {

    public static void coinChange(int[] coins, int amtsf, int tamt, String asf, boolean[] used){
//bASE CONDITION WHEN THE AMOUNT SO FAR REACHED TO THE TOTAL AMOUNT
if(amtsf==tamt)
{
System.out.println(asf+".");
return;
}
//HERE WE WILL GOING TO TAKE FOR EACH COIN(DUPLICATE DATA COINS ARE NOT ALLOWED).If the coins is not used then fill true in used array.

       for(int i=0;i<coins.length;i++)
       {
        //If the coin is not used then use it
        if(used[i]==false)
        {
            //assign true
        used[i]=true;
        //Recursive call
        coinChange(coins, amtsf+coins[i],tamt,asf+coins[i]+"-", used);
        //then after returning back from recursive calll change the used coin value to false in used array.
        used[i]=false;
        }
       }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        boolean[] used = new boolean[coins.length];
        coinChange(coins, 0, amt, "", used);
    }
}