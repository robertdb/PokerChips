package ram.fichaspokerapp.modelo.linkedList;
import ram.fichaspokerapp.modelo.linkedList.IteradorListaCircular;
import ram.fichaspokerapp.modelo.linkedList.ListNode;
/**
 * Created by Robert on 20/1/17.
 */

public class ListaCircular<E> {

    private ListNode start;
    int size;

    public ListaCircular()  {
        start = null;
        size = 0;
    }

    //insertAtLast
    public void add(Object data){
        insertAtLast(data);
    }

    private void insertAtLast(Object data){
        if(size==0){
            start = new ListNode(data);
            start.next = start;
            start.data = data;
        }else{
            ListNode currentNode = getNodeAt(size-1);
            ListNode newNode = new ListNode(data);
            newNode.next = start;
            currentNode.next = newNode;
        }
        size++;
    }

    private void insertAtFirst(Object data){
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

    protected ListNode  getNodeAt(int nodePos) throws ArrayIndexOutOfBoundsException{
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
    protected int findPositionElement(Object data){
        ListNode  temp = start;//Move pointer to front
        int pos = 0;
        while (temp != null && pos < size()){
            if (temp.data == data)
                break;
            pos++;
            temp = temp.next;
        }
        if(pos == size())
            throw new IllegalArgumentException();
        return pos;
    }

    private void insertAt(int position, Object data){
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

    protected ListNode  getFirst(){
        return getNodeAt(0);
    }

    protected ListNode  getLast(){
        return getNodeAt(size-1);
    }

    public E removeAtFirst(){
        if(size==0){
            throw new ArrayIndexOutOfBoundsException();
        }
        Object data = start.data;
        this.getLast().next = start.next;
        start = start.next;
        size--;
        return (E)data;
    }

    public E removeAtLast(){
        if(size==0){
            throw new ArrayIndexOutOfBoundsException();
        }
        ListNode tempNode = getNodeAt(size-2);
        Object data = tempNode.next.data;
        tempNode.next = start;
        size--;
        return (E)data;
    }

    protected E removeAt(int position){
        if(position==0){
            return (E)removeAtFirst();
        }else if(position == size-1){
            return (E)removeAtLast();
        }else{
            ListNode tempNode = getNodeAt(position-1);
            Object data = tempNode.next.data;
            tempNode.next = tempNode.next.next;
            size--;
            return (E)data;
        }
    }

    public E removeElement(Object data){
        return (E)removeAt(findPositionElement(data));
    }

    public int size(){
        return size;
    }

    public E getFirstElement(){
        return (E)getFirst().data;
    }

    public E getLastElement() {
        return (E)getLast().data;
    }

    public boolean contains(Object data) {
        try{
            findPositionElement(data);
        }catch (IllegalArgumentException e){
            return false;
        }
        return true;
    }

    public E next(Object data){

        return (E)getNodeAt(findPositionElement(data)).next.data;

    }
}


