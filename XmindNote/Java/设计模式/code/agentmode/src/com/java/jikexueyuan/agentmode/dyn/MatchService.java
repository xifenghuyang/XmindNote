package com.java.jikexueyuan.agentmode.dyn;

import java.lang.reflect.Proxy;

/**
 * 匹配和打分服务Service
 */
public class MatchService {
    public MatchService() {

        // 创建并获取个人信息对象joe
        PersonBean joe = getPersonInfo("joe", "male", "running");

        // 获取joe的个人代理(即将joe传入个人代理类中控制访问)
        PersonBean OwnerProxy = getOwnerProxy(joe);

        System.out.println("Name is " + OwnerProxy.getName());
        System.out.println("Interests is " + OwnerProxy.getInterests());

        OwnerProxy.setInterests("Bowling");
        System.out.println("Interests are " + OwnerProxy.getInterests());
        OwnerProxy.setHotOrNotRating(50);
        System.out.println("Rating is " + OwnerProxy.getHotOrNotRating());
        OwnerProxy.setHotOrNotRating(40);
        System.out.println("Rating is " + OwnerProxy.getHotOrNotRating());

        System.out.println("**************");

        // 非自己访问
        PersonBean nonOwnerProxy = getNonOwnerProxy(joe);
        System.out.println("Name is " + nonOwnerProxy.getName());
        System.out.println("Interests are " + nonOwnerProxy.getInterests());
        nonOwnerProxy.setInterests("haha");
        System.out.println("Interests are " + nonOwnerProxy.getInterests());
        nonOwnerProxy.setHotOrNotRating(60);
        System.out.println("Rating is " + nonOwnerProxy.getHotOrNotRating());

    }

    PersonBean getPersonInfo(String name, String gender, String interests) {
        PersonBean person = new PersonBeanImpl();
        person.setName(name);
        person.setGender(gender);
        person.setInterests(interests);
        return person;
    }

    // 动态产生代理的过程
    // 创建代理实例。
    // 传入对象类、对象方法、new一个对象的代理
    PersonBean getOwnerProxy(PersonBean person) {
        return (PersonBean) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new OwnerInvocationHandler(person));
    }

    PersonBean getNonOwnerProxy(PersonBean person) {
        return (PersonBean) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new NonOwnerInvocationHandler(person));
    }
}
