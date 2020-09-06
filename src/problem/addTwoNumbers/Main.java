/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */
package problem.addTwoNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1 = Integer.parseInt(
                reverseString(extractListNums(l1))
        );
        int num2 = Integer.parseInt(reverseString(extractListNums(l2)));
        String result = reverseString(String.valueOf(num1 + num2));

        ListNode resultNode = convertStringToLinkedList(result);

        // Integer.parseInt(reverseString(extractListNums(resultNode)));

        return resultNode;

    }

    public String extractListNums(ListNode node) {
        String extractedNum = "";
        ListNode currentNode = node;

        while (currentNode.next != null) {
            extractedNum += currentNode.val;
            currentNode = currentNode.next;
            // Returns last element after processing second last - otherwise last will be
            // skipped
        }
        if (currentNode.next == null) {
            extractedNum += currentNode.val;
        }
        // System.out.println(extractedNum);
        return extractedNum;
    }

    public String reverseString(String input) {
        StringBuilder reversedInput = new StringBuilder();
        reversedInput.append(input);
        return reversedInput.reverse().toString();
    }

    public ListNode convertStringToLinkedList(String input) {
        ListNode currentNode = new ListNode();
        ListNode rootNode = currentNode;

        for (int i = 0; i < input.length(); i++) {
            currentNode.val = Integer.parseInt(String.valueOf(input.charAt(i)));
            System.out.println(currentNode.val);
            if (i != input.length() - 1) {
                currentNode.next = new ListNode();
                currentNode = currentNode.next;
            }
        }
        return rootNode;
    }
}

class ListNode {
     int val;
    ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode l1 = stringToListNode(line);
            line = in.readLine();
            ListNode l2 = stringToListNode(line);

            ListNode ret = new Solution().addTwoNumbers(l1, l2);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}