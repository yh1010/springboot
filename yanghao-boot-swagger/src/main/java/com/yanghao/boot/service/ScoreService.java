package com.yanghao.boot.service;

import com.yanghao.boot.enums.ResultCode;
import com.yanghao.boot.response.Result;
import com.yanghao.boot.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author yanghao
 * @create 2020-03-17 18:28
 * @Description:
 */
@Service
@Slf4j
public class ScoreService {

    public UserVO addScore(){
        UserVO userVO = new UserVO();
        userVO.setId(1);
        userVO.setUsername("TEST");
        userVO.setPassword("123456");
        log.info("---------新增积分-------返回成功--------");
        return userVO;
    }

    public Result delete(){
        log.info("---------删除积分-------返回失败--------");
        return Result.fail(ResultCode.SYSTEM_ERROR);
    }
}
