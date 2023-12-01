package cn.xd.learn.service.impl;

import cn.xd.learn.service.GenericShow;
import org.springframework.stereotype.Service;

@Service
public class IntegerShowImpl implements GenericShow<Integer> {
    @Override
    public Integer show(Integer value) {
        return value;
    }
}
