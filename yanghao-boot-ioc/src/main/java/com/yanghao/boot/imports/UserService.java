package com.yanghao.boot.imports;

import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * @author yanghao
 * @create 2020-03-21 18:00
 * @Description:
 */
@Component
@Import(UserBean.class)
public class UserService {
}
