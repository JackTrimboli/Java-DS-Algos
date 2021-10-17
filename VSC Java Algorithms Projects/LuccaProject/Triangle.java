package LuccaProject;
import java.io.*;
import java.util.Scanner;

public class Triangle {
    public static void main(String [] args) throws IOException{
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        int charPos = 0;
        int arrPos = 0;
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        while(flag){
            if(arrPos == 0)
                continue;
            else if(charPos > strs[arrPos].length())
                flag = false;
            else if(strs[arrPos].charAt(charPos) != (strs[arrPos-1].charAt(charPos)))
                flag = false;
            else if((strs[arrPos].charAt(charPos) == (strs[arrPos-1].charAt(charPos)) && arrPos == strs.length)){
                sb.append((strs[arrPos].charAt(charPos)));
                arrPos = 0;
                charPos++;
            }
            else{
                arrPos++;
                charPos++;
            }

        }
        return sb.toString();                  
    }
}

