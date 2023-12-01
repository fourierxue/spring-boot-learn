package cn.xd.learn.service.impl;

import cn.xd.learn.service.GenericShow;
import org.springframework.stereotype.Service;

@Service
public class StringShowImpl implements GenericShow<String> {
    @Override
    public String show(String value) {
        return value;
    }
}
