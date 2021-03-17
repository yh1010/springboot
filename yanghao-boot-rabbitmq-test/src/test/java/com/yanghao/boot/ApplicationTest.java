package com.yanghao.boot;

import com.yanghao.boot.provider.Sender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = BootRabbitmqApplication.class)
class ApplicationTest {

    @Autowired
    private Sender sender;

    @Test
    void send() {
        this.sender.send();
    }
}
