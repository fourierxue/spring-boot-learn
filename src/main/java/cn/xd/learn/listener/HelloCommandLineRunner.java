package cn.xd.learn.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class HelloCommandLineRunner implements CommandLineRunner {

    private Logger log = LoggerFactory.getLogger(HelloCommandLineRunner.class);

    @Override
    public void run(String... args) {
        System.out.println("CommandLineRunner...run..." + Arrays.asList(args));
        log.info("in myCommandLineRunner");
    }

}
