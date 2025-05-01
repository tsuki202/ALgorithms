import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StackTest extends CommonTest {
    @Test
    void pushStackSuccess(){
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i <inputElements.size() ; i++) {
            stack.add(new Node(inputElements.get(i)));
        }
        List<Integer> actual =stack.getElements();
        Collections.reverse(inputElements);
        assertThat(actual).isEqualTo(inputElements);
    }
    @Test
    void PopSuccess(){
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i <inputElements.size() ; i++) {
            stack.add(new Node(inputElements.get(i)));
        }
        stack.pop();
        List<Integer> actual =stack.getElements();
        inputElements.remove(inputElements.size()-1);
        Collections.reverse(inputElements);
        assertThat(actual).isEqualTo(inputElements);
    }

    @Test
    void displayStackSuccess(){
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i <inputElements.size() ; i++) {
            stack.add(new Node(inputElements.get(i)));
        }
        stack.display();
    }

    @Test
    void clearStackSuccess(){
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i <inputElements.size() ; i++) {
            stack.add(new Node(inputElements.get(i)));
        }
        stack.clear();
        assertThat(stack.head).isNull();
        assertThat(stack.size).isEqualTo(0);
    }
}