package my.first.sample;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by devesh on 12/7/14.
 */
public class FirstTest {
    public FirstSample firstSample ;

    @Before
    public void setUp() throws Exception{
        firstSample = new FirstSample();
    }
    @Test
    public void firstTest() throws Exception{
        assert(firstSample.runSuccess());
    }
}
