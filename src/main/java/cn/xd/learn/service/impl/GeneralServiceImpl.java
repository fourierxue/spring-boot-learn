package cn.xd.learn.service.impl;

import cn.xd.learn.service.GeneralService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * 按类型自动注入单值GeneralService有多个候选者（GeneralServiceImpl， GeneralServiceImplNotPrimary）
 * 通过@Primary进行选择
 * 注入数据或者集合时，每个候选者都会注入
 */
@Primary
@Service
public class GeneralServiceImpl implements GeneralService {
    @Override
    public String printStr() {
        return "str";
    }
}
