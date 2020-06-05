import com.mx.unit.test.adapter.OrderAdapter;
import com.mx.unit.test.presentation.CalculatorPresentation;
import com.mx.unit.test.presentation.OrderPresentation;
import com.mx.unit.test.vo.Order;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;

import static org.powermock.api.mockito.PowerMockito.mock;

/**
 * @author qiqi
 * @date 2020-05-31 15:38
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(OrderPresentation.class)

@Transactional
public class OrderPresentationTest {

    @InjectMocks
    private OrderPresentation orderPresentation;
    @Mock
    private OrderAdapter orderAdapter;

    @Test
    public void getOrderDetailTest() throws Exception {
        /*测试私有方法*/
        long orderNo = 123456L;
        Order order1 = new Order();
        order1.setOrderNo(666666L);
        //OrderPresentation orderPresentation = mock(OrderPresentation.class);
        //PowerMockito.when(orderPresentation, "getOrder", Mockito.anyLong()).thenReturn(order1);
        Method method = PowerMockito.method(OrderPresentation.class, "getOrder", long.class);
        /*因为是mock出来的数据，order==null*/
        Order order = (Order) method.invoke(orderPresentation, orderNo);
        System.out.println(order);
        /*验证是否调用*/
        Mockito.verify(orderAdapter).getOrderDetail(Mockito.anyInt());
        /*验证调用次数，可以验证never，atleast，atmost*/
        Mockito.verify(orderAdapter, Mockito.times(2)).getOrderDetail(Mockito.anyInt());
        /*验证至少执行一次*/
        Mockito.verify(orderAdapter, Mockito.atLeastOnce()).getOrderDetail(Mockito.anyInt());

    }

    @Test
    public void testStaticMethod() throws Exception {
        /*验证静态方法*/
        PowerMockito.mockStatic(OrderPresentation.class);
        PowerMockito.when(OrderPresentation.test(Mockito.anyLong())).thenReturn(false);
        CalculatorPresentation presentation = new CalculatorPresentation();
        boolean isTrue = presentation.testStatic();
        Assert.assertFalse(isTrue);
    }

    @Test
    public void testFinalMethod() throws Exception {
        /*验证final方法*/
        OrderPresentation orderPresentation = mock(OrderPresentation.class);
        PowerMockito.when(orderPresentation.testFinal(Mockito.anyLong())).thenReturn(true);

        Assert.assertTrue(orderPresentation.testFinal(12345L));

    }
}
