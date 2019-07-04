package com.github.fishjava;

import org.junit.Test;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandleTest {
    private void greet(String name){
        System.out.println("hello " + name);
    }
    private void greet(String name, String name2){
        System.out.println("hi " + name + name2);
    }
    private static void greet(MethodHandleTest methodHandleTest, String name){
        System.out.println("wow " + name);
    }

    @Test
    public void main() throws Throwable{
        MethodType methodType = MethodType.methodType(void.class, String.class);

        /**
         * 读取MethodHandleTest这个类的名为sayHello的方法
         * 因为可能出现函数重载的情况，所以我们需要传递一个methodType
         * 这里我们的methodType表明这个方法的返回值是void，参数是一个String
         * 所以会命中第一个方法，不会命中第二个方法
         */
        MethodHandle sayHelloHandle = MethodHandles.lookup()
                .findVirtual(MethodHandleTest.class, "greet", methodType);

        /**
         * 然后如果我们想调用这个函数的话，必须传递两个参数
         *   - this 这是个实例方法，所以需要传一个this
         *   - name 方法的第一个参数
         */
        MethodHandleTest thisArg = new MethodHandleTest();
        sayHelloHandle.invokeExact(thisArg, "Jon");
        // hello Jon
    }

    @Test
    public void stack(){
        new Exception().printStackTrace();
    }
}
