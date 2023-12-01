package cn.xd.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCTemplateController {
    @Autowired
    private JdbcTemplate template;

    @RequestMapping("/learn/getData")
    public List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = template.queryForList("select * from comm_user");
        return list;
    }
}
