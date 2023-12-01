package cn.xd.learn.service.impl;

import cn.xd.learn.service.GeneralService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//@Primary
@Service
public class GeneralServiceImplNotPrimary implements GeneralService {
    @Override
    public String printStr() {
        return "str in not primary";
    }
}
