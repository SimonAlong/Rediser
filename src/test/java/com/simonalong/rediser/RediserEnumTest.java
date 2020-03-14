package com.simonalong.rediser;

import com.simonalong.rediser.entity.TestEntity;
import org.junit.Test;

import static com.simonalong.rediser.enums.BusinessCacheEnum1.LK_U;

/**
 * 针对业务的枚举类型读取
 *
 * @author shizi
 * @since 2020/3/14 下午1:19
 */
public class RediserEnumTest extends BaseTest{

    @Test
    public void testEnum1(){
        Rediser rediser = Rediser.getInstance();
        rediser.bind("localhost:6379");

        TestEntity testEntity = new TestEntity();
        testEntity.setName("ok");
        testEntity.setAge(12);
        rediser.set(KeyBuilder.build(LK_U, 12), testEntity);

        TestEntity result = rediser.get(KeyBuilder.build(LK_U, 12), TestEntity.class);
        show(result);
    }
}
