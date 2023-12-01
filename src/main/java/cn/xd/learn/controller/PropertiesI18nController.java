package cn.xd.learn.controller;

import cn.xd.learn.configuration.LearnProperties;
import cn.xd.learn.exception.MyException.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ConfigurationProperties获取配置文件，也可以使用@Value
 * @Value("${}) 通常用于注入外部化properties
 * @Value("#{})用来使用SpEL表达式
 * 单个配置用@Value，整个配置类使用@ConfigurationProperties
 * @ConfigurationProperties支持松散绑定（last-name可以绑定到变量lastName），@Value不支持
 */
@RestController
public class PropertiesI18nController {
    @Autowired
    private MessageSource messageSource;

    @Value("${server.description}")
    private String description;

    @Autowired
    private LearnProperties properties;

    @RequestMapping("/learn/i18n")
    String showMessage() throws MyException {
        return messageSource.getMessage("message", null, LocaleContextHolder.getLocale());
    }

    @RequestMapping("/learn/properties")
    String home() {
        StringBuilder sb = new StringBuilder();
        sb.append(description);
        sb.append("   ");
        sb.append(properties.getUuid());
        sb.append("   ");
        sb.append(properties);
        return sb.toString();
    }
}
