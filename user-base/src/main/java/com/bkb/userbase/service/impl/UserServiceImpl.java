package com.bkb.userbase.service.impl;

import com.bkb.userbase.entity.User;
import com.bkb.userbase.mapper.UserMapper;
import com.bkb.userbase.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bkb
 * @since 2018-07-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
