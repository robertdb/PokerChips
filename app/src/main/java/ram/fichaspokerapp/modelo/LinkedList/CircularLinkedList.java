package ram.fichaspokerapp.modelo.linkedList;

/**
 * Created by Robert on 20/1/17.
 */

public class CircularLinkedList {

    private ListNode start;
    int size;

    public CircularLinkedList()  {
        start = null;
        size = 0;
    }

    //insertAtLast
    public void add(Object data){
        insertAtLast(data);
    }

    public void insertAtLast(Object data){
        if(size==0){
            start = new ListNode(data);
            start.next = null;
            start.data = data;
        }else{
            ListNode currentNode = getNodeAt(size-1);
            ListNode newNode = new ListNode(data);
            newNode.next = start;
            currentNode.next = newNode;
        }
        size++;
    }

    public void insertAtFirst(Object data){
        if(size==0){
            start = new ListNode(data);
            start.next = null;
        }else{
            ListNode newNode = new ListNode(data);
            newNode.next = start;
            start = newNode;
        }
        size++;
    }

    public ListNode  getNodeAt(int nodePos) throws ArrayIndexOutOfBoundsException{
        if(nodePos>=size || nodePos<0){
            throw new ArrayIndexOutOfBoundsException();
        }
        ListNode  temp = start;//Move pointer to front
        int counter = 0;
        for(;counter<nodePos;counter++){
            temp = temp.next;
        }
        return temp;
    }
    public int findPositionElement(Object data){
        ListNode  temp = start;//Move pointer to front
        int pos = 0;
        while (temp != null || pos < size()){
            if (temp.data == data)
                break;
            pos++;
            temp = temp.next;
        }
        return pos;
    }

    public void insertAt(int position, Object data){
        if(position == 0){
            insertAtFirst(data);
        }else if(position==size-1){
            insertAtLast(data);
        }else{
            ListNode  tempNode = getNodeAt(position-1);
            ListNode  newNode = new ListNode(data);
            newNode.next = tempNode.next;
            tempNode.next = newNode;
            size++;
        }
    }

    public ListNode  getFirst(){
        return getNodeAt(0);
    }

    public ListNode  getLast(){
        return getNodeAt(size-1);
    }

    public Object removeAtFirst(){
        if(size==0){
            throw new ArrayIndexOutOfBoundsException();
        }
        Object data = start.data;
        this.getLast().next = start.next;
        start = start.next;
        size--;
        return data;
    }

    public Object removeAtLast(){
        if(size==0){
            throw new ArrayIndexOutOfBoundsException();
        }
        ListNode tempNode = getNodeAt(size-2);
        Object data = tempNode.next.data;
        tempNode.next = start;
        size--;
        return data;
    }

    public Object removeAt(int position){
        if(position==0){
            return removeAtFirst();
        }else if(position == size-1){
            return removeAtLast();
        }else{
            ListNode tempNode = getNodeAt(position-1);
            Object data = tempNode.next.data;
            tempNode.next = tempNode.next.next;
            size--;
            return data;
        }
    }

    public int size(){
        return size;
    }

    public Object getFirstElement(){
        return getFirst().data;
    }

    public Object getLastElement() {
        return getLast().data;
    }

    public boolean contains(Object data) {
        return true;
    }
}


