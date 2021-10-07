import java.util.Stack;

public class SolverRough {
    public static int bracketSolver(String str){
        Stack<Integer> s = new Stack<>();
        char sign = '+';
        Integer prev = null;
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            if(!Character.isDigit(currChar)){
                if(prev != null){
                    s.push(sign == '-' ? (-1 * prev) : prev);
                    prev = null;
                }
                sign = currChar;
                continue;
            }

            // if its a number;
            if(prev == null){
                prev = Integer.parseInt(currChar + "");
            }else{
                prev = Integer.parseInt(prev+"" + currChar);
            }
            if(i == str.length()-1 && prev != null){
                s.push(sign == '-' ? (-1 * prev) : prev );
            }
        }

        int tot = 0;

        while (!s.empty()){
            tot+=s.pop();
        }


        return tot;
    }

   public static void main (String[] args){
       String input = "-12+5+(16+2)";

       int bracketedVal = 0;

       if(input.contains("(")){
           int index1 = input.indexOf('(');
           int index2 = input.indexOf(')');
           bracketedVal = bracketSolver((String) input.subSequence(index1 +1, index2));

           String temp1 = "";
           String temp2 = "";
           temp1 =  (String) input.subSequence(0, index1);
           temp2 =  (String) input.subSequence(index2, input.length()-1);
           input = temp1 + bracketedVal +  temp2;
           System.out.println(input);
           System.out.println(bracketSolver(input));

       }

       // ch

   }
}
