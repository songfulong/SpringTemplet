import java.util.*;
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Test08 {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode t1 = new ListNode(2);
        list1.next = t1;
        ListNode t2 = new ListNode(3);
        t1.next = t2;
//        ListNode t3 = new ListNode(4);
//        t2.next = t3;
//        t3.next = new ListNode(5);

        ListNode res = new Test08().reverseKGroup(list1, 1);
        System.out.println(res);
    }
    /**
     *
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup (ListNode head, int k) {
        Stack<ListNode> l = new Stack<>();
        ListNode next = null;
        ListNode result = null;
        ListNode start = null;
        ListNode end = null;
        ListNode bigEnd = null;
        ListNode lastBigEnd = null;
        while (head != null){
            if(l.size() == 0){
                lastBigEnd = bigEnd;
                bigEnd = head;
            }

            next = head.next;
            head.next= null;
            l.push(head);
            head = next;
            if(l.size() == k){
                //翻转
                ListNode end2 = null;
                start = l.pop();
                ListNode temp = start;
                while (l.size() >0){
                    temp.next = l.pop();
                    temp = temp.next;
                }
                temp.next= null;
                if(result == null){
                    result = start;
                }else {
                    end.next = start;
                }
                end = temp;
            }
        }
        //不翻转
         if(result == null){
            ListNode temp = getNodeNoRev(l);
            return temp;// 原值返回
        }
        // 拼接不翻转部分
         if(lastBigEnd != null && l.size()> 0){
             lastBigEnd.next = getNodeNoRev(l);
         }
        return result;
    }

    private ListNode getNodeNoRev(Stack<ListNode> l) {
        if(l.size() == 0){
            return null;
        }
        ListNode temp = l.pop();
        temp.next = null;
        ListNode temp2 = null;
        while (l.size() >0 ){
            temp2 = l.pop();
            temp2.next = temp;
            temp = temp2;
        }
        return temp;
    }


}