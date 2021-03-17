package com.yanghao.boot.service;

import com.yanghao.boot.entity.User;
import com.yanghao.boot.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;


/**
 * @author yanghao
 * @create 2020-03-19 22:47
 * @Description:
 */
@Slf4j
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 初始化数据
     * @param user
     */
    public void saveUser(User user) {
        this.userMapper.insertSelective(user);
    }

    /**
     * 修改用户
     */
    public void updateUser(User user){
        this.userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 查询用户
     */
    public void findExample(){
        log.info("----------------按主键查询： where id=100----------------");
        this.userMapper.selectByPrimaryKey(100);

        log.info("----------------查询： where sex=1----------------");
        User user = new User();
        user.setSex((byte) 1);
        List<User> list = this.userMapper.select(user);

        log.info("----------------查询： where username=? and password=?----------------");
        User user1 = new User();
        user1.setUsername("user100");
        user1.setPassword("user100");
        User user2 = this.userMapper.selectOne(user1);

        /**
         * 复杂查询用Example.Criteria
         */
        log.info("----------------Example.Criteria查询： where username=? and password=?----------------");
        Example example = new Example(User.class);
        Example.Criteria criteria= example.createCriteria();
        criteria.andEqualTo("username", "user100");
        criteria.andEqualTo("password", "user100");
        this.userMapper.selectByExample(example);

        log.info("----------------Example.Criteria 模糊查询： where username like ? ----------------");
        Example example1 = new Example(User.class);
        Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andLike("username", "%user100%");
        this.userMapper.selectByExample(example1);

        log.info("----------------Example.Criteria 排序： where username like ? order by id desc ----------------");
        Example example2 = new Example(User.class);
        example2.setOrderByClause("id desc");
        Example.Criteria criteria2 = example2.createCriteria();
        criteria2.andLike("username", "%user100%");
        this.userMapper.selectByExample(example2);

        log.info("----------------Example.Criteria in 查询： where id  in (1,2) ----------------");
        example = new Example(User.class);
        criteria = example.createCriteria();
        List ids = new ArrayList();
        ids.add(1);
        ids.add(2);
        criteria.andIn("id", ids);
        this.userMapper.selectByExample(example);


        log.info("----------------分页查询1----------------");
        User user3 = new User();
        user3.setSex((byte) 1);
        int count = this.userMapper.selectCount(user3);
        this.userMapper.selectByRowBounds(user3, new RowBounds(0, 100));


        log.info("----------------Example.Criteria分页查询2----------------");
        example = new Example(User.class);
        criteria = example.createCriteria();
        criteria.andEqualTo("sex",1);
        count = this.userMapper.selectCountByExample(example);
        this.userMapper.selectByExampleAndRowBounds(example, new RowBounds(0,100));
    }
}
