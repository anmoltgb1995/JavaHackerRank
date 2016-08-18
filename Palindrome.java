import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {

    public static void printArray(char[] num){
        for(int i=0;i<num.length;i++){
                System.out.print(num[i]);
            }
    }

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        System.out.print("Enter no. of characters/digits: ");
        int n = in.nextInt();
        System.out.print("Enter k(no. of max allowed changes): ");
        int k = in.nextInt();
        System.out.print("Enter string: ");
        char[] num;
        String number = in.next();
        num = number.toCharArray();
/*
        num = new char[n];
        BufferedReader buffer = new BufferedReader(
                 new InputStreamReader(System.in));
        int c = 0;
        for(int j=0;j < n;j++) {
            c = buffer.read();
            num[j] = (char) c;     
            System.out.println(num[j]);          
        }       
        */

        boolean[] ar = new boolean[n/2]; //n/2 is no. of pairs of characters in string

        //minimum no. of necessary changes required to 
        //make the string a palindrome
        int minChanges=0;

        //process string to find min. no. of necessary changes required
        for(int i=0;i<n/2;i++){
            //to denote an identical pair
            if(num[i] == num[(n-1)-i]){ 
                ar[i]=true;
            }
            else minChanges++;
        }

//System.out.println("k= "+k+" minChanges= " + minChanges);

        //if allowed changes < min. requirement
        if(k==0 || minChanges > k){
            System.out.println("-1");
            return;
        }

        //odd length palindrome and k=1
        else if(minChanges==0 && n%2==1 && k==1){
            if(num[n/2] == '9'){
                System.out.println("-1");
                return;
            }else{
                //only element to change is middle element
                num[n/2] = '9';
                printArray(num);
                return;
            }
        }

        //for even length palindrome, k must be at least 2
        else if(minChanges==0 && n%2==0 && k<2){
            System.out.println("-1");
            return;
        }

        /*
        Else process string and make required changes
        */
        else{
            //num of extra changes allowed
            int extra = k-minChanges;
            //traverse only for no. of pairs(n/2) and not whole array
            for(int i=0;i<n/2;i++){
                //if matching(identical) pair
                if(ar[i]){
                    if(extra>1 && num[i]!='9'){
                    //set to highest digit
                    num[i] = '9';
                    num[(n-1)-i] = '9';
                    extra-=2;
                    }
                }
                //if non-matching pair
                else {
                    if(num[i]=='9' || num[(n-1)-i] == '9'){
                        //if one of them is 9 already, no need to spend 'extra' changes
                        num[i] = '9';
                        num[(n-1)-i] = '9';
                    }
                    //if none of them is 9
                    else{
                        //use extra change and change them both to 9
                        if(extra>0){
                            num[i] = '9';
                            num[(n-1)-i] = '9';
                            extra--;
                        }
                        else{ //if no extra change
                            //make both characters equal to the bigger of them
                            if(num[i] > num[(n-1)-i])  num[(n-1)-i] = num[i];
                            else num[i] = num[ (n-1)-i ];
                        }
                    }
                }
            }

            //output new string that is the palindrome of highest value
            System.out.print("New string: ");
            printArray(num);

        }
    }
}
