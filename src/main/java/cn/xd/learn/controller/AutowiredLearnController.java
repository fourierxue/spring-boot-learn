package cn.xd.learn.controller;

import cn.xd.learn.configuration.MyEventListener;
import cn.xd.learn.service.GeneralService;
import cn.xd.learn.service.GenericShow;
import cn.xd.learn.service.NoImplService;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * @Autowired 学习
 */
@RestController
public class AutowiredLearnController {
    Logger log = LoggerFactory.getLogger(MyEventListener.class);
    private GeneralService serviceByConstructor;

    private GeneralService serviceBySetter;

    private GeneralService serviceByMethod;

    /**
     * 默认会注入加了@primary注解的GeneralServiceImpl
     * 使用@Qualifiers注解可以指定注入相同@Qualifiers值的GeneralService
     */
    @Autowired
    @Qualifier("serviceByQualifier")
    private GeneralService serviceByQualifiers;

    /**
     * @resource会按照指定的name注入bean
     * 明确指定了name的情况下，如果找不到该名称的bean会报错
     * 如果没有明确指定name，默认的name来自于字段名或setter方法。如果是一个字段，它采用字段名。如果是setter方法，则采用Bean的属性名。
     * 因此不指定name则注入name和name为generalServiceQualifiers的bean，如果找不到，会回退到类型的 GeneralService 的primary 类型匹配。
     */
    @Resource//(name = "generalServiceImplNotPrimary")
    private GeneralService generalServiceQualifiers;

    /**
     * @Autowired 注解应用于字段
     */
    @Autowired
    private GeneralService serviceByField;

    /**
     * @Autowired 注解应用于数组
     */
    @Autowired
    private GeneralService[] serviceArray;

    /**
     * @Autowired 注解应用于集合
     */
    @Autowired
    private Set<GeneralService> serviceSet;

    /**
     * 使是类型化的 Map 实例也可以被自动注入，只要预期的key类型是 String。map的值包含所有预期类型的Bean，而key则包含相应的Bean名称
     */
    @Autowired
    private Map<String, GeneralService> serviceMap;

    /**
     * 通过将 @Autowired 中的 required 属性设置为 false，使框架能够跳过一个不可满足的注入点，否则会报错
     * 可以通过Java 8的 java.util.Optional 来表达特定依赖的非必须性质，setNoImplService方法，如果形参换成NoImplService会报错。
     * 从Spring Framework 5.0开始，你也可以使用 @Nullable 注解(任何包中的任何类型-例如JSR-305中的 javax.annotation.Nullable）
     */
    @Autowired(required = false)
    private NoImplService noImplService;
    private NoImplService noImplService1;
    @Autowired
    public void setNoImplService1(Optional<NoImplService> service) {
        service.ifPresent(implService -> this.noImplService1 = implService);
    }
    @Autowired
    public void preNoImplService1(@Nullable NoImplService service) {
        this.noImplService1 = service;
    }

    /**
     * @Autowired 注解应用于构造函数，仅有一个构造函数时，可以省略该注解，多个构造函数，至少有一个构造函数需要使用该注解。
     * @param service
     */
    //@Autowired
    public AutowiredLearnController(GeneralService service) {
        this.serviceByConstructor = service;
    }

    /**
     * @Autowired 注解应用于传统的setter方法
     * @param service
     */
    @Autowired
    public void setServiceBySetter(GeneralService service) {
        this.serviceBySetter = service;
    }

    /**
     * @Autowired 注解应用于具有任意名称和多个参数的方法
     * @param service
     */
    @Autowired
    public void preService(GeneralService service) {
        this.serviceByMethod = service;
    }

    @RequestMapping("/learn/constructor")
    String printStrByConstructor() {
        log.info("xxxxx");
        return serviceByConstructor.printStr();
    }

    @RequestMapping("/learn/setter")
    String printStrBySetter() {
        return serviceBySetter.printStr();
    }

    @RequestMapping("/learn/method")
    String printStrByMethod() {
        return serviceByMethod.printStr();
    }

    @RequestMapping("/learn/field")
    String printStrByField() {
        return serviceByField.printStr();
    }

    @RequestMapping("/learn/array")
    String printStrByArray() {
        return serviceArray[0].printStr();
    }

    @RequestMapping("/learn/set")
    String printStrBySet() {
        return serviceSet.iterator().next().printStr();
    }

    @RequestMapping("/learn/map")
    String printStrByMap() {
        return serviceMap.values().iterator().next().printStr();
    }

    @RequestMapping("/learn/qualifiers")
    String printStrByQualifiers() {
        return serviceByQualifiers.printStr();
    }

    @RequestMapping("/learn/resource")
    String printStrByResource() {
        return generalServiceQualifiers.printStr();
    }

    /**
     * 泛型被用作qualifier，GenericShow<Integer>会被注入IntegerShowImpl
     */
    @Autowired
    private GenericShow<Integer> genericShow;

    @RequestMapping("/learn/showInt")
    Integer showInt() {
        Integer i = 1;
        return genericShow.show(i);
    }
}
