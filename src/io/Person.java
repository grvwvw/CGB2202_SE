package io;

import java.io.Serializable;
import java.util.Arrays;

/*
    使用当前实例测试对象流的序列化和反序列化操作
 */
public class Person implements Serializable { //签名接口，没有任何抽象方法，只是为了证明使用序列化
    /*
        实现序列化接口后最好主动定义序列化版本号这个常量。
        这样一来对象序列化时就不会主动根据类的结构生成一个版本号，而是使用该固定值
        那么反序列化时，只要还原的对象和当前的版本号一致就可以进行还原
     */
    public static final long serialVersionUID = 42L; //固定一下版本号
    private String name;
    private int age;
    private String gender;
    /*
        当一个属性被关键字transient修饰后，那么当进行对象序列化时，该属性会被忽略
        忽略不必要的属性可以达到对象瘦身的目的，减少资源开销
     */
    private transient String[] otherInfo;

    //java bean
    public Person() {
    }

    public Person(String name, int age, String gender, String[] otherInfo) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.otherInfo = otherInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String[] otherInfo) {
        this.otherInfo = otherInfo;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", otherInfo=" + Arrays.toString(otherInfo) +
                '}';
    }
}

