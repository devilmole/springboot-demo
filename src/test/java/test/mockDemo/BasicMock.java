package test.mockDemo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by Administrator on 2016/10/27 0027.
 */
public class BasicMock {

    List list=mock(List.class);
    LinkedList linkedList=mock(LinkedList.class);

    @Test
    public void basic1() throws Exception {

        when(list.get(0)).thenReturn("this is one");
        when(list.get(1)).thenThrow(new RuntimeException("11111"));
        doThrow(new RuntimeException("22222")).when(list).clear();
        when(linkedList.get(anyInt())).thenReturn("element");
        System.out.println(linkedList.get(3));
    }

    @Test
    public void basic2() throws Exception {
        List list=mock(List.class);
        list.add("1");
        verify(list).add("1");
        verify(list,times(1)).add("1");
        verify(list,atLeast(1)).add("1");
        verify(list,atMost(1)).add("1");
    }

    @Test
    public void basic3() throws Exception {
        when(list.size()).thenReturn(100);
        Assert.assertEquals(100,list.size());
    }

}
