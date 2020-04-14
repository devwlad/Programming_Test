package com.apps.wladimir.searchword;

public class Typo {

    public static Boolean CheckTypo(String s1, String s2){
        int typoCount = 0;
        if (s1.equals(s2)){
            return true;
        }
        int sizeDiff = (s1.length() - s2.length()) > 0
                ? (s1.length() - s2.length())
                : (s1.length() - s2.length()) * (-1);
        if (sizeDiff <= 1){
            int i = 0, j = 0;
            while (i < s1.length() && j < s2.length()){
                if (s1.charAt(i) != s2.charAt(j)){
                    typoCount++;
                    if (s1.length() != s2.length()) {
                        if (s1.length() > s2.length()) {
                            i++;
                        } else {
                            j++;
                        }
                    } else {
                        i++;
                        j++;
                    }
                } else {
                    i++;
                    j++;
                }
            }
            if (typoCount <= 1){
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
