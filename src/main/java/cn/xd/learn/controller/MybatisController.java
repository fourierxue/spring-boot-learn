package cn.xd.learn.controller;

import cn.xd.learn.entity.CommUser;
import cn.xd.learn.mapper.CommUserMapper;
import cn.xd.learn.mapper.XmlCommUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MybatisController {
    @Autowired
    private CommUserMapper commUserMapper;

    @Autowired
    private XmlCommUserMapper xmlCommUserMapper;

    @GetMapping("/learn/user/{id}")
    public CommUser retrieve(@PathVariable("id") String id) {
        CommUser userById = commUserMapper.getUserById(id);
        return userById;
    }

    @GetMapping("/learn/user")
    public CommUser create(CommUser user) {
        commUserMapper.insertUser(user);
        return user;
    }

    @GetMapping("/learn/xmlUser/{id}")
    public CommUser xmlRetrieve(@PathVariable("id") String id) {
        return xmlCommUserMapper.getById(id);
    }
}
