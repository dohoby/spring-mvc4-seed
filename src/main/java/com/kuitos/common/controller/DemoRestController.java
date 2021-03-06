package com.kuitos.common.controller;

import com.kuitos.common.bean.ResponseResult;
import com.kuitos.common.bean.User;
import com.kuitos.common.util.RestResultGenerator;
import com.kuitos.common.service.DemoService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author kui.liu
 * @since 2014/09/24 下午7:54
 */
@RestController
public class DemoRestController {

    @Resource
    private DemoService demoService;

    @RequestMapping(value = "getUser", method = RequestMethod.GET)
    public ResponseResult<List<User>> getUser(String userName){

        List<User> userList = demoService.getUser(userName);
        return RestResultGenerator.genResult(userList, "成功!");
    }

    @RequestMapping(value = "saveUser", method = RequestMethod.POST)
    public ResponseResult saveUser(@Valid @RequestBody User user) {

        demoService.saveUser(user);
        return RestResultGenerator.genResult("保存成功!");
    }

}
