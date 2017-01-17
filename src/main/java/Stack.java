import java.util.ArrayList;
import java.util.List;


public class Stack {

    private List<Object> pushed = new ArrayList<Object>();

    public Object pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException("you can not pop an empty stack");
        }
        return pushed.remove(pushed.size() - 1);
    }

    private boolean isEmpty() {
        return pushed.isEmpty();
    }

    public void push(Object pushed) {
        this.pushed.add(pushed);
    }

}
