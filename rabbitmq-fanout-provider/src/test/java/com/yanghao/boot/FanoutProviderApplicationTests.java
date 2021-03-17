package com.yanghao.boot;

import com.yanghao.boot.provider.OrderSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FanoutProviderApplicationTests {

    @Autowired
    private OrderSender orderSender;

    @Test
    void send() {
        this.orderSender.send();
    }

}
