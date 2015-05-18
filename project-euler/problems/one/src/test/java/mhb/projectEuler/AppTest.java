package mhb.projectEuler;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AppTest 
{

    @Test
    public void oneTest()
    {
        int x = App.one();
        int y = App.oneStreamSum();
        int z = App.oneStreamsSumAndDifference();
        int u = App.oneStreamSumAndDifference();
        int v = App.oneParallelStreamSum();
        assertEquals(x, y);
        assertEquals(y, z);
        assertEquals(x, z);
        System.out.println(x+" "+y+" "+z+" "+u+" " + v);
    }
}
