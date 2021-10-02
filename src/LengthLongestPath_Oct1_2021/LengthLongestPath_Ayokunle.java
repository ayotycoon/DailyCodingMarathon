package LengthLongestPath_Oct1_2021;

import java.util.HashMap;

// 	https://leetcode.com/problems/longest-absolute-file-path
public class LengthLongestPath_Ayokunle {
    public static int lengthLongestPath(String input) {
        if(input == null || input.length() == 0) return 0;
        int max = 0;
        var split = input.split("\\n");
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i =0; i < split.length; i++){
            String item = split[i];
            // System.out.println(item);
            boolean isFile =item.contains(".");

            if(i ==0 && !isFile){
                // then its root

                map.put(i,item.length());
            }else {
                var x = item.split("\\t");
                String alt = x[x.length-1];
                int no = item.lastIndexOf("\t")+1;
                int prev = map.containsKey(no-1) ? map.get(no -1) : 0;

                if(isFile){
                    max = Math.max(prev  + (prev == 0 ? 0 :1) + alt.length(),max);
                }else {
                    map.put( no, prev + (prev == 0 ? 0 :1) + alt.length() );
                }
            }
        }

        return max;
    }






    public static void main(String[] args) {
        lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");
    }


}
