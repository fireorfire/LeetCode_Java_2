/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode start = fake;
        while (start.next != null && start.next.next != null) {
            ListNode first = start.next, second = first.next;
            start.next = second;
            first.next = second.next;
            second.next = first;
            start = first;
        }
        return fake.next;
    }
}/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode start = fake;
        while (start.next != null && start.next.next != null) {
            ListNode first = start.next, second = first.next;
            start.next = second;
            first.next = second.next;
            second.next = first;
            start = first;
        }
        return fake.next;
    }
}