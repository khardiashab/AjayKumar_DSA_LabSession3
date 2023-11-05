package labsession.problem1.main;

import java.util.Scanner;
import labsession.problem1.service.BalancedString;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a string: ");
        String input = sc.nextLine();
        
        boolean isBalanced = BalancedString.isBalancedString(input);
        
        if(isBalanced){
            System.out.println("Entered string has balanced brackets.");
        } else {
            System.out.println("Entered string does not contain balanced brackets.");
        }
    }
}