package com.yanghao.boot.controller;

import com.sun.xml.internal.txw2.TXW;
import com.yanghao.boot.enums.ResultCode;
import com.yanghao.boot.exception.BusinessException;
import com.yanghao.boot.response.Result;
import com.yanghao.boot.service.ScoreService;
import com.yanghao.boot.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanghao
 * @create 2020-03-17 16:34
 * @Description: 注册用户
 */
@Api(description = "注册用户接口")
@RestController
public class UserController {

    @Autowired
    private ScoreService scoreService;

    /**
     * 新增用户
     */
    @GetMapping(value="/addUser")
    public UserVO addUser(){
        return this.scoreService.addScore();
    }

    /**
     * 删除用户
     */
    @GetMapping(value="/deleteUser")
    public Result deleteUser(){
        return this.scoreService.delete();
    }

    /**
     * 捕获异常
     */
    @GetMapping(value = "/getException")
    public void getException(){
        try {
            int i = 9/0;
        }catch (Exception e){
            throw new BusinessException(ResultCode.SYSTEM_ERROR);
        }
    }

    /**
     * 捕获自定义异常
     */
    @ApiOperation(value = "捕获自定义异常")
    @GetMapping(value = "/getBusinessException")
    public void getBusinessException(){
        throw new BusinessException(ResultCode.USER_HAS_EXISTED);
    }

    @ApiOperation(value = "注册用户")
    @PostMapping(value = "/createUser")
    public void createUser(@RequestBody @Validated UserVO userVO){
        UserVO userInfo = null;
        Assert.notNull(userInfo, "用户不存在！");
        return;
    }
}



