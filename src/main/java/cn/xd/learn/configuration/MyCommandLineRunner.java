package cn.xd.learn.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    private Logger log = LoggerFactory.getLogger(MyCommandLineRunner.class);

    @Override
    public void run(String... args) {
        log.info("in myCommandLineRunner");
    }

}
