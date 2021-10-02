package LengthLongestPath_Oct1_2021;

import java.util.HashMap;

// 	https://leetcode.com/problems/longest-absolute-file-path
public class LengthLongestPath_Ayokunle {




        private boolean checkIfFile(String s){

            for(int i =0; i < s.length(); i++){
                char item = s.charAt(i);
                if( item == '.'){
                    return true;
                }
            }

            return false;

        }
        public int lengthLongestPath(String input) {
            if(input == null || input.length() == 0) return 0;

            int max = 0;
            var split = input.split("\\n");

            // System.out.println(Arrays.toString(split));

            HashMap<Integer, Integer> map = new HashMap<>();

            for(int i =0; i < split.length; i++){
                String item = split[i];
                // System.out.println(item);
                boolean isFile = checkIfFile(item);

                if(i ==0 && !isFile){
                    // then its root

                    map.put(i,3);
                }else {
                    var x = item.split("\\t");
                    String alt = x[x.length-1];

                    int no = item.length() - alt.length();
                    int prev = map.containsKey(no-1) ? map.get(no -1) : 0;


                    // check if its a folder

                    if(isFile){
                        max = Math.max(prev  + alt.length(),max);
                    }else {

                        map.put( no, prev + 1 + alt.length() );
                    }

                }


            }

            return max;


        }








    public static void main(String[] args) {
        System.out.println("Hello");

    }


}
