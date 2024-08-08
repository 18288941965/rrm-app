/*

@Service
public class UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Value("${service.ybss-rk}")
    private String ybssRk;

    @Autowired
    private CommonUtil commonUtil;
    private final static String RYJBXX_URL = "/sqjwwfc/rk/rkCxZa";

    private static final String OAUTH_URL = "https://86.1.43.80/uap/v1/api/au/oauth_authorize?response_type=code&" +
            "client_id=WSZGAJDSJZX&state=f30d034f83a642348ce7a6cf3973fa67&redirect_uri=$IP$api/admin/user/oauth";
    private static final String ACCESSTOKEN_URL =  "https://$HOST$/uap/v1/api/au/oauth_accesstoken?client_secret" +
            "=Wsga@dsjzx&grant_type=authorization_code&client_id=WSZGAJDSJZX&redirect_uri=$IP$api/admin/user/oauth";
    public static final String OAUTH_LOGOUT_URL = "https://86.1.43.80/uap/v1/api/au/offline";
    private static final String OAUTH_PRIKEY = "1234567891234567";
    private static final String TEST_USER = "532627199001023116";
    private static final String TO_USER = "530000000000000000";
    private static String referer = "";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${sso.accesstoken.host}")
    private String ssoHost;
    */
/**
     * 检查登录状态
     * @author YHF
     * @date 2022/4/18 19:38
     * @param  request 参数描述
     * @param  response 参数描述
     * @return void
    *//*

    public void checkLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOG.info("checkLogin .");
        referer = request.getHeader("Referer");
        // 获取上一次离开的地址
        String leaveUrl = referer.substring(referer.indexOf('=')+1);
        LOG.info("referer is " + referer);
        referer = referer.substring(0, referer.indexOf('/',7) + 1);
        LOG.info("referer is " + referer);
        String url = OAUTH_URL.replace("$IP$", referer);
        LOG.info("url is " + referer);
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Headers", "Origin,No-Cache,X-Requested-With,If-Modified-Since,Pragma,Last-Modified,Cache-Control,Expires,Content-Type,X-E4M-With,from-axios,*");
        response.addHeader("Access-Control-Allow-Methods","POST,PUT,GET,OPTIONS,DELETE,HEA");
        response.addHeader("Access-Control-Allow-Max-Age","0");
        response.addHeader("Access-Control-Allow-Credentials","true");
        if(Strings.isNotBlank(leaveUrl)){
            url +="?url="+leaveUrl;
        }
        response.sendRedirect(url);
    }

    */
/**
     * 获取当前登录用户信息
     * @author YHF
     * @date 2022/4/18 19:38
     * @param  code 参数描述
     * @param  goUrl 参数描述
     * @return void
    *//*

    public void getUserInfoAndLogin(String code,String goUrl) throws Exception {
        LOG.info("getUserInfoAndLogin, code is "+code+",goUrl is "+goUrl);
        LOG.info("referer is " + referer);
        //如果当前已经处于登录状态，直接进入
        if(StpUtil.isLogin()&&Strings.isNotBlank(LoginUserUtils.getLoginUserInfo().getRzjgid())&&Strings.isNotBlank(goUrl)){
            SaHolder.getResponse().redirect(goUrl);
        }
        String key = "access_token";
        String url = ACCESSTOKEN_URL.replace("$HOST$", ssoHost).replace("$IP$", referer) + "&code=" + code;
        String rspStr = HttpUtil.get(url, 5000);
        JSONObject rsp = JSONUtil.parseObj(rspStr);
        if (rsp.getStr(key) != null) {
            String str = JITDecrypto.de(OAUTH_PRIKEY, rsp.getStr(key));
            JSONObject token = JSONUtil.parseObj(str);
            String cardNo = token.getJSONObject("userToken").getStr("cardNo");
            if (TEST_USER.equals(cardNo)) {
                cardNo = TO_USER;
            }
            UserBean userInfo = userMapper.queryYhxxBySfzh(cardNo);
            if(userInfo==null){
                throw new UserFirendlyException("当前用户不存在");
            }
            Result result = doLogin(userInfo);
            if (result.getCode() == SystemConstants.SUCCESS_STATE_CODE) {
                SaResponse response = SaHolder.getResponse();
                if(goUrl != null){
                    response.redirect(goUrl.substring(0, goUrl.indexOf('/',7) + 1) + "organization?redirect_uri="+goUrl);
                    return;
                }
                response.redirect(referer + "organization");
                return;
            }
        }
        throw new Exception("登录失败");
    }

    */
/**
     * 查询用户名和任职机构信息
     * @author YHF
     * @date 2022/4/18 19:39
     * @return Result
    *//*

    public Result getYhmAndRzjgs() {
        SaSession session = StpUtil.getSession(false);
        if (session == null) {
            return Result.failed("请先登录");
        }
        String yhId = session.getString("yhid");
        String xm = session.getString("xm");
        String mjbh = session.getString("mjbh");
        List<RzjgBean> rzjg = userMapper.queryYhJg(mjbh);
        rzjg.stream().forEach(e -> {
            e.setRoles(userMapper.queryYhJgJs(yhId, e.getId()).stream().map(role -> (String)role.get("mc"))
                    .collect(Collectors.toSet()));
        });
        Map<String, Object> rsp = new HashMap<>(2);
        rsp.put("yhm", xm);
        rsp.put("rzjg", rzjg);
        return Result.success(rsp);
    }

    */
/**
     * 用户登录
     * @author YHF
     * @date 2022/4/18 19:39
     * @param  user 参数描述
     * @return Result
    *//*

    private Result doLogin(UserBean user) {
        StpUtil.login(user.getYhm());
        SaSession session = StpUtil.getSession();
        //session.clear();    // 清除之前的数据
        session.set("yhid", user.getId());
        session.set("xm", user.getXm());
        session.set("mjbh", user.getMjbh());

        List<RzjgBean> rzjg = getRzjg(user, session);

        // 如果任职机构没有角色则授予：PC端普通民警角色
        int saveCount = 0;
        if (rzjg.size() > 0) {
            for (RzjgBean rzjgBean : rzjg) {
                Set<String> roles = rzjgBean.getRoles();
                if (roles.size() == 0) {
                    UserRoleDto yhjs = new UserRoleDto();
                    yhjs.setId(IdUtil.simpleUUID());
                    yhjs.setJsxxId("6e3e752ca6234f6082030c88f20dce5a");
                    yhjs.setRzjgId(rzjgBean.getId());
                    yhjs.setYhxxId(user.getId());
                    userMapper.createUserRole(yhjs);
                    saveCount++;
                }
            }
            if (saveCount > 0) {
                rzjg = getRzjg(user, session);
            }
        }

        Map<String, Object> rsp = new HashMap<>(16);
        rsp.put("rzjg", rzjg);
        // 登录成功后，返回token给前端
        String token = StpUtil.getTokenValue();
        rsp.put("token",token);
        return Result.success(rsp);
    }

    private List<RzjgBean> getRzjg (UserBean user, SaSession session) {
        List<RzjgBean> rzjg = userMapper.queryYhJg(user.getMjbh());
        rzjg.forEach(e -> {
            e.setRoles(userMapper.queryYhJgJs(user.getId(), e.getId()).stream().map(role -> (String)role.get("mc"))
                    .collect(Collectors.toSet()));
        });
        session.set("rzjg", rzjg.stream().map(e -> e.getId()).collect(Collectors.toSet()));
        return rzjg;
    }

    */
/**
     * 账号密码用户登录
     * @author YHF
     * @date 2022/4/18 19:39
     * @param  username 参数描述
     * @param  password 参数描述
     * @return Result
    *//*

    public Result login(String username, String password) {
        UserBean yhxx = userMapper.queryYhxxByYhm(username);
        if(yhxx==null){
            return Result.failed("用户信息不存在");
        }
        if(!SecureUtil.md5(password).equals(yhxx.getMm())&&!password.equals(yhxx.getMm())){
            return Result.errorUserOrPassword();
        }
        */
/*if (yhxx == null || StringUtils.isBlank(password) || !SecureUtil.md5(password).equals(yhxx.getMm())) {
            return Result.errorUserOrPassword();
        }*//*

        return doLogin(yhxx);
    }

    */
/**
     * 刷新指定用户的权限（只刷新redis）
     *
     * @param userName 用户名
     * @return
     *//*

    public Result refreshUserPower(String userName) {
        SaSession session = StpUtil.getSessionByLoginId(userName, false);
        if (session == null) {
            return Result.ok();
        }
        Set<ResourceBean> resources = userMapper.queryYhZy((String)session.get("yhid"), (String)session.get("currentJg_"+StpUtil.getTokenValue()));
        session.set("resources_"+StpUtil.getTokenValue(), resources.stream().map(e -> e.getUrl()).collect(Collectors.toSet()));
        session.set("resourceIds_"+StpUtil.getTokenValue(), resources.stream().map(e -> e.getId()).collect(Collectors.toSet()));
        return Result.ok();
    }

    */
/**
     * 刷新当前登录用户的权限
     *
     * @return
     *//*

    public Result refreshUserPower() {
        SaSession session = StpUtil.getSession();
        Set<ResourceBean> resources = userMapper.queryYhZy((String)session.get("yhid"), (String)session.get("currentJg_"+StpUtil.getTokenValue()));
        Set<String> resourceIds = resources.stream().map(e -> e.getId()).collect(Collectors.toSet());
        session.set("resources_"+StpUtil.getTokenValue(), resources.stream().filter(e -> e.getUrl() != null).map(e -> e.getUrl()).collect(Collectors.toSet()));
        session.set("resourceIds_"+StpUtil.getTokenValue(), resourceIds);
        Map<String, Object> rsp = new HashMap<>(16);
        rsp.put("resources",
                resources.stream().filter(e -> "02".equals(e.getLx())).map(e -> e.getId()).collect(Collectors.toSet()));
        return Result.success(rsp);
    }

    */
/**
     * 获取当前登录用户信息
     * @author YHF
     * @date 2021/11/23 11:52
     * @return Result
    *//*

    public Result getLoginUserInfo() {
        //如果用户没有登录，直接返回
        if(!StpUtil.isLogin()){
            return Result.success(null);
        }
        LoginUserInfo loginUserInfo = LoginUserUtils.getLoginUserInfo();
        if(Strings.isBlank(loginUserInfo.getRzjgid())){
            return Result.selectUnit(null);
        }
        return Result.success(loginUserInfo);
    }

    */
/**
     * 获取token信息
     * @author YHF
     * @date 2022/2/26 14:32
     * @return Result
    *//*

    public Result getToken() {
        //如果用户没有登录，直接返回
        if(!StpUtil.isLogin()){
            return Result.success(null);
        }
        return Result.success(StpUtil.getTokenValue());
    }

}
*/
