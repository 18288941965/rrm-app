/*


*/
/**
 * 用户管理
 * @author Administrator
 * @date 2021/11/18 15:15
 *//*

@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @ApiOperation("用户登录")
    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    @AuthorTag(AuthorStatusCode.OPEN)
    public Result doLogin(@RequestBody UserLoginDto params) {
        return userService.login(params.getUsername(), params.getPassword());
    }

    @ApiOperation("用户管理-组件单选用户查询")
    @RequestMapping(value = "/queryUser", method = RequestMethod.POST)
    @AuthorTag(AuthorStatusCode.LOGIN)
    public Result queryUser(@RequestBody UserDto dto) {
        return userService.queryUser(dto);
    }

    @ApiOperation("用户管理-组件单选查询用户和机构")
    @RequestMapping(value = "/queryUserAndInstitution", method = RequestMethod.POST)
    @AuthorTag(AuthorStatusCode.LOGIN)
    public Result queryUserAndInstitution(@RequestBody UserDto dto) {
        return userService.queryUserAndInstitution(dto);
    }

    @ApiOperation("用户管理-组件多选用户查询")
    @RequestMapping(value = "/queryUsers", method = RequestMethod.POST)
    @AuthorTag(AuthorStatusCode.LOGIN)
    public Result queryUsers(@RequestBody UserDto dto) {
        return userService.queryUsers(dto);
    }

    @ApiOperation("用户管理-根据用户IDS查询组件回显民警")
    @RequestMapping(value = "/queryUserByIds", method = RequestMethod.POST)
    @AuthorTag(AuthorStatusCode.LOGIN)
    public Result queryUserByIds(@RequestBody UserDto dto) {
        return userService.queryUserByIds(dto);
    }

    @ApiOperation("用户管理-组件单选机构查询")
    @RequestMapping(value = "/queryInstitution", method = RequestMethod.GET)
    @AuthorTag(AuthorStatusCode.LOGIN)
    public Result queryInstitution(@RequestParam("param") String param) {
        return userService.queryInstitution(param);
    }

    @ApiOperation("退出登录")
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @AuthorTag(AuthorStatusCode.OPEN)
    public Result logout(HttpServletRequest request) {
        StpUtil.logout();
        String referer = request.getHeader("Referer");
        Map<String,String> map = new HashMap<String,String>(16);
        map.put("oauth_logout_url",UserService.OAUTH_LOGOUT_URL);
        map.put("referer",referer);
        return Result.success("注销成功", map);
    }

    @ApiOperation("切换任职机构")
    @RequestMapping(value = "/changedw", method = RequestMethod.POST)
    @AuthorTag(AuthorStatusCode.LOGIN)
    public Result changeDw(@RequestBody RzJgxxDto rzJgxxDto, HttpServletRequest request) throws Exception {
        LOG.info("切换任职单位:"+ rzJgxxDto.getRzjgid());
        return userService.changeDw(rzJgxxDto.getRzjgid(),request);
    }

    @ApiOperation("用户信息-是否登录")
    @RequestMapping(value = "/isLogin", method = RequestMethod.POST)
    @AuthorTag(AuthorStatusCode.OPEN)
    public Result isLogin() {
        LOG.info("-----------------isLoginxxxxxxx-------------------");
        boolean islogin = StpUtil.isLogin();
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        LOG.info("tokenInfo.tokenActivityTimeout:"+tokenInfo.tokenActivityTimeout);
        LOG.info("tokenInfo.tokenSessionTimeout:"+tokenInfo.tokenSessionTimeout);
        LOG.info("tokenInfo.tokenName:"+tokenInfo.tokenName);
        LOG.info("tokenInfo.tokenValue:"+tokenInfo.tokenValue);
        LOG.info("-----------------isLogin:"+islogin);
        LOG.info("-----------------user:"+ LoginUserUtils.getLoginUserInfo());
        return Result.success(islogin);
    }

    @ApiOperation("用户信息-验证token是否在有效期内")
    @RequestMapping(value = "/checkToken", method = RequestMethod.POST)
    @AuthorTag(AuthorStatusCode.OPEN)
    public Result checkToken() {
        LOG.info("-----------------检查token有效期-------------------");
        if(StpUtil.isLogin()){
            return Result.success("token有效");
        }
        return Result.failed("token无效");
    }

    @ApiOperation("刷新当前登录用户权限")
    @RequestMapping(value = "/refreshPower", method = RequestMethod.POST)
    @AuthorTag(AuthorStatusCode.LOGIN)
    public Result refreshPower()  {
        return userService.refreshUserPower();
    }

    @ApiOperation("刷新指定用户的权限")
    @RequestMapping(value = "/refreshPowerCache", method = RequestMethod.GET)
    public Result refreshPowerCache(@RequestParam("userName") String userName) {
        return userService.refreshUserPower(userName);
    }

    @ApiOperation("检查登录状态-省厅单点登录集成")
    @RequestMapping(value = "/checkLogin", method = RequestMethod.GET)
    @AuthorTag(AuthorStatusCode.OPEN)
    public void checkLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        userService.checkLogin(request, response);
    }

    @ApiOperation("接收单点登录返回的code并获取用户信息")
    @RequestMapping(value = "/oauth", method = RequestMethod.GET)
    @AuthorTag(AuthorStatusCode.OPEN)
    public void oauth(@RequestParam("code") String code,@RequestParam(name = "url",required=false)String url) throws Exception {
        userService.getUserInfoAndLogin(code,url);
    }

    @ApiOperation("登录成功后获取用户名和所有任职机构")
    @RequestMapping(value = "/getYhmAndRzjgs", method = RequestMethod.POST)
    @AuthorTag(AuthorStatusCode.LOGIN)
    public Result getYhmAndRzjgs() {
        return userService.getYhmAndRzjgs();
    }

    @ApiOperation("获取token信息")
    @RequestMapping(value = "/getToken", method = RequestMethod.GET)
    @AuthorTag(AuthorStatusCode.LOGIN)
    public Result getToken(){
        return userService.getToken();
    }

    @ApiOperation("用户管理-查询用户信息")
    @RequestMapping(value = "/queryList", method = RequestMethod.POST)
    public Result queryYhList(@RequestBody UserDto userDto) {
        return userService.queryList(userDto);
    }

    @ApiOperation("用户管理-查询用户角色信息")
    @RequestMapping(value = "/queryUserRole", method = RequestMethod.POST)
    public Result queryUserRole(@RequestBody UserRoleDto userRoleDto) {
        return userService.queryUserRole(userRoleDto);
    }

    @ApiOperation("用户管理-新建用户角色信息")
    @RequestMapping(value = "/createUserRole", method = RequestMethod.POST)
    public Result createUserRole(@RequestBody UserRoleDto userRoleDto) {
        return userService.createUserRole(userRoleDto);
    }

    @ApiOperation("用户管理-删除用户角色信息")
    @RequestMapping(value = "/deleteUserRole", method = RequestMethod.POST)
    public Result deleteUserRole(@RequestBody UserRoleDto userRoleDto) {
        return userService.deleteUserRole(userRoleDto);
    }

    @ApiOperation("用户管理-查询用户资源信息")
    @RequestMapping(value = "/querySelectedMenuResource", method = RequestMethod.POST)
    public Result querySelectedMenuResource(@RequestBody UserResourceDto userResourceDto) {
        return userService.querySelectedMenuResource(userResourceDto);
    }

    @ApiOperation("用户管理-新建用户资源信息")
    @RequestMapping(value = "/createUserResource", method = RequestMethod.POST)
    public Result createUserResource(@RequestBody UserResourceDto userResourceDto) {
        return userService.createUserResource(userResourceDto);
    }

    @ApiOperation("用户管理-删除用户资源信息")
    @RequestMapping(value = "/deleteUserResource", method = RequestMethod.POST)
    public Result deleteUserResource(@RequestBody UserResourceDto userResourceDto) {
        return userService.deleteUserResource(userResourceDto);
    }

    @ApiOperation("用户管理-新建用户资源信息")
    @RequestMapping(value = "/createUserResourceByMenuId", method = RequestMethod.POST)
    public Result createUserResourceByMenuId(@RequestBody UserResourceDto userResourceDto) {
        return userService.createUserResourceByMenuId(userResourceDto);
    }

    @ApiOperation("用户管理-删除用户资源信息")
    @RequestMapping(value = "/deleteUserResourceByMenuId", method = RequestMethod.POST)
    public Result deleteUserResourceByMenuId(@RequestBody UserResourceDto userResourceDto) {
        return userService.deleteUserResourceByMenuId(userResourceDto);
    }

    @ApiOperation("用户管理-获取当前登录用户信息")
    @RequestMapping(value = "/getLoginUserInfo", method = RequestMethod.GET)
    @AuthorTag(AuthorStatusCode.LOGIN)
    public Result getLoginUserInfo() {
        return userService.getLoginUserInfo();
    }

    @ApiOperation("用户管理-查询用户拥有的菜单信息(只包含没有子菜单的菜单)")
    @RequestMapping(value = "/querySelectedMenu", method = RequestMethod.POST)
    public Result querySelectedMenu(@RequestBody UserResourceDto userResourceDto) {
        return userService.querySelectedMenu(userResourceDto);
    }

    @ApiOperation("用户管理-新建用户菜单信息")
    @RequestMapping(value = "/createUserMenu", method = RequestMethod.POST)
    public Result createUserMenu(@RequestBody UserResourceDto userResourceDto) {
        return userService.createUserMenu(userResourceDto);
    }

    @ApiOperation("用户管理-删除用户菜单信息")
    @RequestMapping(value = "/deleteUserMenu", method = RequestMethod.POST)
    public Result deleteUserMenu(@RequestBody UserResourceDto userResourceDto) {
        return userService.deleteUserMenu(userResourceDto);
    }

    @AuthorTag(AuthorStatusCode.LOGIN)
    @ApiOperation("用户管理-查询用户信息")
    @RequestMapping(value = "/queryYhxp", method = RequestMethod.GET)
    public Result<XtglYhxxXpBean> queryYhxp() {
        return userService.queryYhxp();
    }

}
*/
