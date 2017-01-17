import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.rules.ExpectedException.*;


public class StackShould {
    @Rule
    public ExpectedException thrown = none();
    private Stack stack;


    @Before
    public void setUp() throws Exception {
        stack = new Stack();
    }

    @Test
    public void throw_exception_if_popped_when_empty() throws Exception {

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("you can not pop an empty stack");

        stack.pop();
    }

    @Test
    public void pop_last_pushed_object(){
        Object pushed = "pushed";
        stack.push(pushed);

        Object popped = stack.pop();

        assertThat(popped, is(pushed));
    }

    @Test
    public void pop_objects_in_reverse_push_order(){
        Object firstPushed = "first pushed";
        Object lastPushed = "last pushed";

        stack.push(firstPushed);

        stack.push(lastPushed);

        Object poppedFirst = stack.pop();
        Object poppedSecond = stack.pop();

        assertThat(poppedFirst, is(lastPushed));
        assertThat(poppedSecond, is(firstPushed));
    }
}
