package com.rrm.module.user.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.rrm.annotations.PermissionRequired;
import com.rrm.cache.RrmUserCache;
import com.rrm.cache.UserCacheService;
import com.rrm.module.user.domain.model.RrmUser;
import com.rrm.module.user.dto.RrmUserDTO;
import com.rrm.module.user.service.RrmUserService;
import com.rrm.util.JwtTokenUtil;
import com.rrm.vo.ResultVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 系统的登录、权限控制等.
 *
 * @author TWL 2024/7/30 8:55
 * @since 1.0
 */
@ApiOperation(value = "权限控制")
@RestController
@RequestMapping("/auth")
public class RrmAuthController {

    @Autowired
    private RrmUserService rrmUserService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserCacheService userCacheService;

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    @PermissionRequired(PermissionRequired.AuthCodeEnum.OPEN)
    public ResultVO<String> logIn(@RequestBody RrmUserDTO userDTO) {
        if (StrUtil.isBlank(userDTO.getUsername()) || StrUtil.isBlank(userDTO.getPassword())) {
            return ResultVO.unauthorized("用户名或密码为空！");
        }

        // 验证用户是否存在
        RrmUser user = rrmUserService.getUserByName(userDTO.getUsername());
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
        RrmUserCache cache = new RrmUserCache();
        cache.setId(user.getId());
        cache.setUsername(user.getUsername());
        userCacheService.cacheUser(user.getUsername(), cache);

        return ResultVO.success(token);
    }


    @ApiOperation(value = "检查是否登录")
    @GetMapping("/isLogin")
    @PermissionRequired(PermissionRequired.AuthCodeEnum.OPEN)
    public ResultVO<Boolean> isLogin() {
        RrmUserCache userInfo = jwtTokenUtil.getUserInfo();
        if (userInfo == null || StrUtil.isBlank(userInfo.getUsername())) {
            return ResultVO.success(false);
        } else {
            return ResultVO.success(true);
        }
    }

    @ApiOperation(value = "退出登录")
    @GetMapping("/logout")
    @PermissionRequired(PermissionRequired.AuthCodeEnum.OPEN)
    public ResultVO<String> logOut() {
        String username = jwtTokenUtil.getUsernameFromRequest();
        if (username != null) {
            userCacheService.cacheUser(username, null);
        }
        return ResultVO.success();
    }

    @ApiOperation(value = "选择项目")
    @PutMapping("/select")
    public ResultVO<String> selectItem(@RequestBody RrmUserCache rrmUserCache) {
        RrmUserCache userInfo = jwtTokenUtil.getUserInfo();
        userInfo.setItemCode(rrmUserCache.getItemCode());
        userCacheService.cacheUser(userInfo.getUsername(), userInfo);
        return ResultVO.success();
    }
}
