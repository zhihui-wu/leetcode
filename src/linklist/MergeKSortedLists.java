package linklist;

import java.util.PriorityQueue;

/**
 * @Description: 23. 合并K个升序链表
 * @Author: 吴智慧
 * @Date: 2020/9/17 21:35
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {

    public static void main(String[] args) {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();

        ListNode list1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(8);
        list1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        ListNode list2 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(7);
        list2.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;

        ListNode list3 = new ListNode(5);
        ListNode node8 = new ListNode(6);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(10);
        list3.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = null;

        ListNode list4 = new ListNode(-8);
        ListNode node21 = new ListNode(-7);
        ListNode node22 = new ListNode(-7);
        ListNode node23 = new ListNode(-5);
        ListNode node24 = new ListNode(1);
        list4.next = node21;
        node21.next = node22;
        node22.next = node23;
        node23.next = node24;
        node24.next = null;

        ListNode list5 = new ListNode(-2);

        ListNode list6 = new ListNode(-10);
        ListNode node11 = new ListNode(-10);
        ListNode node12 = new ListNode(-7);
        ListNode node13 = new ListNode(0);
        list6.next = node11;
        node11.next = node12;
        node12.next = node13;
        node13.next = null;

        ListNode list7 = new ListNode(2);

        // 例1
//        ListNode[] lists = new ListNode[]{list1, list2, list3};

        // 例2
//        ListNode[] lists = new ListNode[]{null, null};

        // 例3
        ListNode[] lists = new ListNode[]{list4, list5, list6, list7};

        // 打印链表
        LinkedListUtils.print(list1);
        LinkedListUtils.print(list2);
        LinkedListUtils.print(list3);

        // 解法一：堆排序
//        ListNode result = mergeKSortedLists.mergeKLists(lists);

        // 解法二：优先队列
        ListNode result = mergeKSortedLists.mergeKLists1(lists);


        // 打印链表
        LinkedListUtils.print(result);
    }

    /**
     * 堆排序
     * 时间复杂度：O（ （K * N）* （log K））
     * 空间复杂度：O（ 1 ）
     */
    public ListNode mergeKLists(ListNode[] lists) {
        // 去除空链表，使非空链表集中在数组前面部分
        int length = lists.length;
        for (int i = 0; i < length; i++) {
            while (lists[i] == null && i < length) {
                lists[i] = lists[length - 1];
                length--;
            }
        }
        // 只包含0、1个链表时，可直接处理
        if (length < 1) {
            return null;
        }else if (length == 1) {
            return lists[0];
        }
        // 将数组（各链表的头节点）堆化为小顶堆
        for (int i = (length - 2) / 2; i >= 0; i--) {
            heapify(lists, length, i);
        }
        // 取出堆顶（最小节点），各链表如被取走节点，使用后一个节点补上，并再次堆化
        ListNode head = new ListNode();
        ListNode temp = head;
        int i = length - 1;
        while (i > 0) {
            print(lists);
            if (lists[0] != null) {
                // 取出堆顶
                temp.next = lists[0];
                lists[0] = lists[0].next;
                temp = temp.next;
                if (lists[0] == null) {
                    // 堆顶为空，使用堆的最后一个节点补上
                    lists[0] = lists[i];
                    heapify(lists, i, 0);
                    i--;
                    if (i < 1){
                        break;
                    }
                }
                // 堆化
                heapify(lists, i + 1, 0);
            }else {
                // 堆顶为空，使用堆的最后一个节点补上
                lists[0] = lists[i];
                heapify(lists, i, 0);
                i--;
                if (i < 1){
                    break;
                }
            }
        }
        // 将剩余节点接到最后
        temp.next = lists[0];
        return head.next;
    }

    /**
     * 堆化（小顶堆）
     */
    private void heapify(ListNode[] lists, int length, int pos) {
        ListNode temp;
        while(true) {
            int minPos = pos;
            if (pos * 2 + 1 < length && lists[pos * 2 + 1].val < lists[minPos].val) {
                minPos = pos * 2 + 1;
            }
            if (pos * 2 + 2 < length && lists[pos * 2 + 2].val < lists[minPos].val) {
                minPos = pos * 2 + 2;
            }
            temp = lists[minPos];
            lists[minPos] = lists[pos];
            lists[pos] = temp;
            if (minPos == pos) {
                break;
            }
            pos = minPos;
        }
    }

    /**
     * 打印节点数组
     */
    private void print(ListNode[] lists) {
        for (ListNode node : lists) {
            System.out.print(node.val);
        }
        System.out.println("");
    }

    /**
     * 优先队列
     * 时间复杂度：O（ （K * N）* （log K））
     * 空间复杂度：O（ K ）
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        // 取各链表头节点，放入优先队列中
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }
        ListNode head = new ListNode();
        ListNode rear = head;
        while (!queue.isEmpty()) {
            // 取出头节点（即最小值节点）
            Status node = queue.poll();
            rear.next = node.ptr;
            rear = rear.next;
            // 如取出的节点，有后继节点，则将后继节点放入优先队列中
            if (node.ptr.next != null) {
                queue.offer(new Status(node.ptr.next.val, node.ptr.next));
            }
        }
        return head.next;
    }

    class Status implements Comparable<Status> {
        int val;
        ListNode ptr;

        Status(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }

        @Override
        public int compareTo(Status o) {
            return this.val - o.val;
        }
    }

    // 优先队列
    PriorityQueue<Status> queue = new PriorityQueue<>();

}

