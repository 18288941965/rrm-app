package com.rrm.module.user.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.rrm.cache.UserCacheService;
import com.rrm.module.user.domain.model.RrmUser;
import com.rrm.module.user.dto.RrmUserDTO;
import com.rrm.module.user.service.UserService;
import com.rrm.util.JwtTokenUtil;
import com.rrm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 系统的登录、权限控制等.
 *
 * @author TWL 2024/7/30 8:55
 * @since 1.0
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserCacheService userCacheService;

    @PostMapping("/login")
    public ResultVO<String> logIn(@RequestBody RrmUserDTO userDTO) {
        if (StrUtil.isBlank(userDTO.getUsername()) || StrUtil.isBlank(userDTO.getPassword())) {
            return ResultVO.unauthorized("用户名或密码为空！");
        }
        // 验证用户是否存在
        RrmUser user = userService.getUserByName(userDTO.getUsername());
        if (user == null) {
            return ResultVO.unauthorized("用户不存在！");
        }
        // 验证密码是否正确
        String s = SecureUtil.md5(userDTO.getPassword());
        if (!s.equals(user.getPassword())) {
            return ResultVO.unauthorized("密码不正确");
        }
        // 登录成功
        String token = jwtTokenUtil.generateToken(userDTO.getUsername());
        // 缓存用户信息
        userCacheService.cacheUser(user.getUsername(), user);
        return ResultVO.success(token);
    }

    @GetMapping("/logout")
    public ResultVO<String> logOut() {
        String username = jwtTokenUtil.getUsernameFromRequest();
        userCacheService.cacheUser(username, null);
        return ResultVO.success();
    }

}
