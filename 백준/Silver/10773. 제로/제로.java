import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();

        for (int i=0;i<K;i++) {
            int y = scanner.nextInt();
            if(y!=0){
                stack.push(y);
            }else{
                stack.pop();
            }
        }
        if(stack.isEmpty()){
            System.out.println(0);
        }else{
            int sum = 0;
            for(int y : stack){
                sum+=y;
            }
            System.out.println(sum);
        }
    }
}