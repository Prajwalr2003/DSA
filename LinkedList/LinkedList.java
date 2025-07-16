import java.util.*;
class LinkedList
{
    public static class Node
    {
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=next;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        //Step1 = create new node
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        //Step2 = newNode next - head
        newNode.next = head;
        //step3 = head - newNode
        head = newNode;
    }

    public void addLast(int data){

        Node newNode = new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
        }

        tail.next=newNode;
        tail=newNode;
    }

    public void print(){
        if(head==null){
            System.out.println("LinkedList is empty");
            return;
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add(int index, int data){

        if(index==0){
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;

        Node temp = head;
        int i=0;

        while(i<index-1){
            temp=temp.next;
            i++;
        }

        newNode.next=temp.next;
        temp.next=newNode;
    }

    public void delete(int data){
        Node temp=head;
        while(temp.next.data!=data){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        size--;
    }
    public static void main(String[] args){

        LinkedList link = new LinkedList();

        // link.head = new Node(1);
        // link.head.next = new Node(2);

        // link.print();
        link.addFirst(1);
        link.addFirst(2);
        link.addLast(3); 
        link.addLast(4);
        link.add(2, 9);
        link.print();

        System.out.println(link.size);
        link.delete(9);
        link.print();
    }
}