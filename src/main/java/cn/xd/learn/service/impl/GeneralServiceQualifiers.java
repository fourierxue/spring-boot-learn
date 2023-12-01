package cn.xd.learn.service.impl;

import cn.xd.learn.service.GeneralService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("serviceByQualifier")
public class GeneralServiceQualifiers implements GeneralService {
    @Override
    public String printStr() {
        return "str in qualifiers";
    }
}
