import com.mx.unit.test.presentation.CalculatorPresentation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;

/**
 * @author qiqi
 * @date 2020-06-03 00:02
 */
@RunWith(MockitoJUnitRunner.class)
@PrepareForTest(CalculatorPresentation.class)
public class OrderPresentationV3Test {
    @Test
    public void testSumXXBySpy_Not_Call_Private_Method() throws Exception {
        CalculatorPresentation cal = PowerMockito.spy(new CalculatorPresentation());
        PowerMockito.doReturn(2).when(cal, "sumXX", anyInt(), anyInt());
        assertEquals(2, cal.callSumXX(1, 2));
    }

    @Test
    public void testSumXXByMock_Not_Call_Real_Method() throws Exception {
        CalculatorPresentation cal = PowerMockito.mock(CalculatorPresentation.class);
        PowerMockito.when(cal, "sumXX", anyInt(), anyInt()).thenReturn(2);
        assertEquals(0, cal.callSumXX(1, 2));
    }

}
