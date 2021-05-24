package linklist;

/**
 * @Description: 2. 两数相加
 * @Author: 吴智慧
 * @Date: 2021/5/24 15:40
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    public static void main(String[] args) {

    }

    /**
     * 遍历
     * 时间复杂度：O（ N ）
     * 空间复杂度：O（ 1 ）
     * 需注意，进位情况，可能再中间，也可能在最高位
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean flag = false;
        ListNode tempHead = new ListNode();
        tempHead.next = l1;
        ListNode point = tempHead, l2Point = l2;
        while(point.next != null && l2Point != null) {
            int sum = point.next.val + l2Point.val;
            sum = flag ? sum + 1 : sum;
            flag = sum > 9;
            point.next.val = sum % 10;
            point = point.next;
            l2Point = l2Point.next;
        }
        if (point.next == null) {
            if (l2Point == null){
                if (flag) {
                    ListNode rear = new ListNode();
                    rear.val = 1;
                    point.next = rear;
                }
            }else {
                if (flag) {
                    addOne(l2Point);
                }
                point.next = l2Point;
            }
        }else {
            if (flag){
                addOne(point.next);
            }
        }
        return tempHead.next;
    }

    private void addOne(ListNode head){
        ListNode temp = head;
        while(temp != null) {
            temp.val++;
            if (temp.val > 9) {
                temp.val = temp.val % 10;
                if (temp.next == null){
                    ListNode rear = new ListNode();
                    rear.val = 1;
                    temp.next = rear;
                    break;
                }
            }else {
                break;
            }
            temp = temp.next;
        }
    }
}
