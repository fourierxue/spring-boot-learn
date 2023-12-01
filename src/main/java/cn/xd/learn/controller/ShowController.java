package cn.xd.learn.controller;

import cn.xd.learn.exception.MyException.MyException;
import cn.xd.learn.service.GenericShow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class ShowController {
    Logger logger = LoggerFactory.getLogger(ShowController.class);

}
