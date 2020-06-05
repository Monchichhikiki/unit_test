import com.mx.unit.test.adapter.OrderAdapter;
import com.mx.unit.test.presentation.OrderPresentation;
import com.mx.unit.test.vo.Order;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

/**
 * @author qiqi
 * @date 2020-05-31 23:18
 */
@RunWith(MockitoJUnitRunner.class)
@PrepareForTest(OrderPresentation.class)
public class OrderPresentationV2Test {
    /*InjectMocks和Mock的区别*/
    @InjectMocks
    private OrderPresentation orderPresentation;
    @Mock
    private OrderAdapter orderAdapter;

    private Order order;

    /*通用的数据可以放在before里处理*/
    @Before
    public void setUp() throws Exception {
        order = new Order();
        order.setOrderNo(777777L);
        order.setAmount(new BigDecimal(300));
    }

    @Test
    public void testV2() throws Exception {

        /*设置模拟对象的返回预期值，当前为测试方法的内部调用,测试桩*/
        when(orderAdapter.isUser(12345)).thenReturn(true);
        orderPresentation.updateDetail(order, 12345);
        Assert.assertEquals(order.getOrderNo(), 123456L);
        Assert.assertEquals(order.getAmount(), new BigDecimal(300));

    }

    @Test
    public void testV3() throws Exception {

        List list1 = Mockito.mock(List.class);

        //when(list1.get(0)).thenReturn("你好");
        list1.add("first");
        list1.add("second");
        System.out.println(list1.get(0));
        System.out.println(list1);
        /*验证执行顺序*/
        InOrder inOrder = Mockito.inOrder(list1);
//        inOrder.verify(list1).add("second");
//        inOrder.verify(list1).add("first");
        List list = new ArrayList();
        /*测试spy的数据*/
        List spy = Mockito.spy(list);
        when(spy.get(0)).thenReturn("hello");
        doReturn("hello").when(spy).get(0);
        spy.add("a");
        spy.add("b");
        System.out.println(spy.get(0));
        System.out.println(spy.size());
        System.out.println(spy);
    }

    /**
     * 测试mock()和injectmock()区别
     *
     * @throws Exception
     */
    @Test
    public void test4() throws Exception {
        OrderPresentation orderPresentation = Mockito.mock(OrderPresentation.class);
        when(orderPresentation.testPublic()).thenReturn("你好");
        String str = orderPresentation.testPublic();
        Assert.assertEquals(str, "你好");
    }


}
