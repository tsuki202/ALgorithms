import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Stack<T> {
    Node<T> head;
    int size;
    public void add(Node<T> element){
        element.setNext(head);
        head=element;
        size++;
    }
    public void pop(){
        if (Objects.isNull(head)) {
            return;
        }
        head=head.getNext();
        size--;
    }
    public List<T> getElements(){
        Node<T> temp=head;
        List<T> elements=new ArrayList<>();
        while(temp!=null){
            elements.add(temp.getElement());
            temp=temp.getNext();
        }
        return elements;
    }
    public void display(){
        Node<T> temp=head;
        System.out.print("Stack: [");
        while(temp!=null){
            System.out.print(temp.getElement());
            temp=temp.getNext();
            if(temp!=null){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    public void clear(){
        while (head != null) {
            head = head.getNext();
            size--;
        }
    }
}