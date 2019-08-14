import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SolutionTest {
    private List<Interval> input1;
    private Interval input2;
    private List<Interval> expected;
    private Solution soln = new Solution1();

    public SolutionTest(List<Interval> input1, Interval input2, List<Interval> output) {
        this.input1 = input1;
        this.input2 = input2;
        this.expected = output;
    }

    @Parameterized.Parameters
    public static Collection parameters() {
        return Arrays.asList(new Object[][]{
                {
                        Arrays.asList(
                                new Interval(1,3), new Interval(6,9)
                        ),
                        new Interval(2,5),
                        Arrays.asList(
                                new Interval(1,5), new Interval(6,9)
                        )
                }
        });
    }

    @Test
    public void testInsert() {
        assert(checkEqual(expected, soln.insert(input1, input2)));
    }

    private boolean checkEqual(List<Interval> expected, List<Interval> actual) {
        if (expected.size() != actual.size()) {
            return false;
        } else {
            for (int i = 0; i < expected.size(); i++) {
                if (!expected.get(i).equals(actual.get(i))) {
                    return false;
                }
            }
            return true;
        }
    }
}