package labsession.problem1.service;

import java.util.*;

/**
 * This class checks if a string is balanced or not.
 */
public class BalancedString {
    // Map to store the characters and their corresponding values
    private static final Map<Character, Integer> charToIntMap = new HashMap<>();

    // Initialize the map with the characters and their values
    static {
        charToIntMap.put('(', 1); // Opening parenthesis
        charToIntMap.put(')', -1); // Closing parenthesis
        charToIntMap.put('{', 2); // Opening curly brace
        charToIntMap.put('}', -2); // Closing curly brace
        charToIntMap.put('[', 3); // Opening square bracket
        charToIntMap.put(']', -3); // Closing square bracket
    }

    /**
     * Checks if the input string is balanced or not.
     *
     * @param input The input string to be checked
     * @return True if the string is balanced, false otherwise
     */
    public static boolean isBalancedString(String input) {
        Deque<Integer> stack = new ArrayDeque<>(); // Stack to store the values

        // Iterate over each character in the input string
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            // Get the corresponding value for the character from the map
            int value = charToIntMap.getOrDefault(c, 0);

            // If the value is 0, it means the character is not in the map
            if (value == 0) {
                return false;
            }

            // If the value is positive, push it onto the stack
            if (value > 0) {
                stack.push(value);
            } else {
                // If the stack is empty or the top value of the stack plus the current value is not 0, return false
                if (stack.isEmpty() || stack.pop() + value != 0) {
                    return false;
                }
            }
        }

        // If the stack is empty, it means all opening brackets have been closed
        return stack.isEmpty();
    }
}