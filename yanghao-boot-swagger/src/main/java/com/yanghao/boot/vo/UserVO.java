package com.yanghao.boot.vo;

import com.yanghao.boot.annotations.Phone;
import com.yanghao.boot.annotations.Sex;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * @author yanghao
 * @create 2020-03-17 16:33
 * @Description:
 */
@Data
public class UserVO {

    private Integer id;
    @NotEmpty(message = "用户名不能为空")
    @Length(min = 6, max = 12, message = "用户名在6到12位之间")
    private String username;

    @Length(min = 6, message = "密码长度不能小于6位")
    private String password;

    @Email(message = "请输入正确的邮箱")
    private String email;

    @Phone
    private String phone;

    @Pattern(regexp = "^(\\d{18,18}|\\d{15,15}|(\\d{17,17}[x|x]))$", message = "身份证格式错误")
    private String idCard;

    @Sex
    private Byte sex;
}
