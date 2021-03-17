package com.yanghao.boot;

import com.yanghao.boot.provider.OrderSender;
import com.yanghao.boot.provider.ProductSender;
import com.yanghao.boot.provider.UserSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TopicProviderApplicationTests {

    @Autowired
    private OrderSender orderSender;
    @Autowired
    private ProductSender productSender;
    @Autowired
    private UserSender userSender;

    @Test
    void send() {
        this.orderSender.send();
        this.productSender.send();
        this.userSender.send();
    }
}
