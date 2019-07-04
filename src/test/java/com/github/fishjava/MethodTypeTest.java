package com.github.fishjava;

import org.junit.Test;

import java.lang.invoke.MethodType;

/**
 * MethodType: 创建一个方法的描述信息
 *
 * https://docs.oracle.com/javase/8/docs/api/java/lang/invoke/MethodType.html
 */
public class MethodTypeTest {
    @Test
    public void main(){
        /**
         * 表明这个方法的
         *   - 返回值是long类型
         *   - 第一个参数是int类型
         *   - 第二个参数是long类型
         */
        MethodType addInteger = MethodType.methodType(long.class, int.class, int.class);

        // 获得方法参数个数
        System.out.println(addInteger.parameterCount());
        // 2

        // 在原来的参数列表的索引为2的地方插入一个String类型的参数
        MethodType addInteger2 = addInteger.insertParameterTypes(2, String.class);

        // 循环输出参数列表
        for (Class parameterType : addInteger2.parameterList()) {
            System.out.println(parameterType.getName());
        }
    }
}
