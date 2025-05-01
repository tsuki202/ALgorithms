import static java.util.Objects.isNull;

public class Queue<T> extends Stack<T>{
    Node<T> last;
    public void add(Node<T> node){
        if(isNull(last)){
            head=last=node;
            size++;
            return;
        }last.setNext(node);
        last=node;
        size++;
    }
    @Override
    public void pop(){
        super.pop();
        if (size == 0) {
            last = null;
        }
    }
    @Override
    public void display(){
        Node<T> temp=head;
        System.out.print("Queue: [");
        while(temp!=null){
            System.out.print(temp.getElement());
            temp=temp.getNext();
            if(temp!=null){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    @Override
    public void clear(){
        while (head != null) {
            Node<T> temp = head;
            head = head.getNext();
            temp.setNext(null);
            size--;
        }
        last = null;
    }
}