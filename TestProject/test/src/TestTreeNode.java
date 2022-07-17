

public class TestTreeNode {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode t1 = new ListNode(3);
        list1.next = t1;
        ListNode t2 = new ListNode(5);
        t1.next = t2;


        ListNode list2 = new ListNode(2);
        ListNode s1 = new ListNode(4);
        list2.next = s1;
        ListNode s2 = new ListNode(6);
        s1.next = s2;


        new TestTreeNode().Merge(list1, list2);
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode newList = null;
        ListNode nextNode = null;
        while(true){
            if(list1 == null && list2 == null){
                break;
            }
            if(list1 != null && list2 != null && list1.val < list2.val || list2 == null){
                  if(newList == null){
                    nextNode = list1;
                    newList = nextNode;
                }else{
                    nextNode.next = list1;
                    nextNode = nextNode.next;
                }
                list1 = list1.next;;
            }else{
                if(newList == null){
                    nextNode = list2;
                    newList = nextNode;
                }else {
                    nextNode.next = list2;
                    nextNode = nextNode.next;
                }
                list2 = list2.next;
            }
        }
        return newList;
    }
}
