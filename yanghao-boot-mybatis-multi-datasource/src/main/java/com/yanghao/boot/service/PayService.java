package com.yanghao.boot.service;

import com.yanghao.boot.entity.CapitalAccount;
import com.yanghao.boot.entity.RedPacketAccount;
import com.yanghao.boot.mapper.account.CapitalAccountMapper;
import com.yanghao.boot.mapper.redaccount.RedPacketAccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yanghao
 * @create 2020-03-20 1:12
 * @Description: 支付 -- 发红包
 */
@Slf4j
@Service
public class PayService {

    @Autowired
    private CapitalAccountMapper capitalAccountMapper;
    @Autowired
    private RedPacketAccountMapper redPacketAccountMapper;

    /**
     * 账户余额 扣钱
     */
    @Transactional(rollbackFor = Exception.class)
    public void payCount(Integer userId, int count){
        CapitalAccount capitalAccount = new CapitalAccount();
        capitalAccount.setId(userId);
        CapitalAccount capitalDTO = this.capitalAccountMapper.selectOne(capitalAccount);
        capitalDTO.setBalanceAmount(capitalDTO.getBalanceAmount() - count);
        this.capitalAccountMapper.updateByPrimaryKey(capitalDTO);
    }

    /**
     * 红包余额 加钱
     */
    @Transactional(rollbackFor = Exception.class)
    public void payRedPacket(int userId, int count){
        RedPacketAccount redPacketAccount = new RedPacketAccount();
        redPacketAccount.setUserId(userId);
        RedPacketAccount redPacketDTO = this.redPacketAccountMapper.selectOne(redPacketAccount);
        redPacketDTO.setBalanceAmount(redPacketDTO.getBalanceAmount() + count);
        this.redPacketAccountMapper.updateByPrimaryKey(redPacketDTO);
    }


    @Transactional(rollbackFor = Exception.class)
    public void pay(int fromUserId, int toUserId, int count){
        this.payCount(fromUserId,count);
        this.payRedPacket(toUserId, count);
    }
}
