package com.yanghao.boot;

import com.yanghao.boot.provider.InfoSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ProviderApplication.class)
class ProviderApplicationTests {

    @Autowired
    private InfoSender sender;

    @Test
    void send() {
        this.sender.send();
    }

}
