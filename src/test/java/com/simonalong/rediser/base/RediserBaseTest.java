package com.simonalong.rediser.base;

import com.simonalong.rediser.BaseTest;
import com.simonalong.rediser.Rediser;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author shizi
 * @since 2020/3/14 下午12:48
 */
public class RediserBaseTest extends BaseTest {

    /**
     * 测试创建和绑定，方式1
     */
    @Test
    @SneakyThrows
    public void testCreate1() {
        Rediser rediser = Rediser.getInstance();
        rediser.bind("localhost", 6379);
        rediser.start();

        rediser.set("rediser", "testCreate");
        Thread.sleep(1000 * 1000);
        Assert.assertEquals(rediser.get("rediser"), "testCreate");
    }

    /**
     * 测试创建和绑定，方式2
     */
    @Test
    public void testCreate2() {
        Rediser rediser = Rediser.getInstance();
        rediser.bind("localhost:6379");
        rediser.start();
        rediser.set("rediser", "testCreate");
        Assert.assertEquals(rediser.get("rediser"), "testCreate");
    }
}
