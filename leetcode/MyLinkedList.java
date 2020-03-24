/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-03-15 10:18
 **/
public class MyLinkedList {

        public class Node{
            int val;
            Node next;
            public Node(){
                val = -1;
                next = null;
            }

            public Node(int val){
                this.val = val;
                next = null;
            }
        }

        private Node dummyHead;
        private Node tail;

        private int size;

        /** Initialize your data structure here. */
        public MyLinkedList() {
            dummyHead = new Node();
            tail = null;
            size = 0;

        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {

            if(index < 0 || index >= size)
                return -1;

            Node cur = dummyHead;
            while(index >= 0){
                index --;
                cur = cur.next;
            }
            return cur.val;

        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            Node node = new Node(val);
            node.next = dummyHead.next;
            dummyHead.next = node;
            if(node.next == null)
                tail = node;

            size ++;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {

            Node node = new Node(val);

            if(tail == null){
                tail = node;
                dummyHead.next = node;
            }else{
                tail.next = node;
                tail = node;
            }

            size ++;

        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if(index <= 0){
                addAtHead(val);
            }else if(index > size){
                return ;
            }else{
                Node cur = dummyHead;
                while(index > 0){
                    cur = cur.next;
                    index --;
                }
                Node node = new Node(val);
                node.next = cur.next;
                cur.next = node;

                size ++;
            }
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if( index < 0 || index >= size)
                return ;

            Node cur = dummyHead;
            while(index > 0){
                cur = cur.next;
                index --;
            }

            cur.next = cur.next.next;
            if(cur.next == null)
                tail = null;
            //6 1 2  0 4
            size --;



        }


    public static void main(String[] args){
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtIndex(3,0);
        myLinkedList.deleteAtIndex(2);
        myLinkedList.addAtHead(6);
        myLinkedList.addAtTail(4);
        myLinkedList.get(4);


    }

}
