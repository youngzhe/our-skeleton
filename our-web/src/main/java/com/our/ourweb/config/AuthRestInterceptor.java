package com.our.ourweb.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @desc: AuthRestInterceptor
 * @className:AuthRestInterceptor
 * @author: hu
 * @date: 2019/1/31
 */
@Component
public class AuthRestInterceptor extends HandlerInterceptorAdapter {
//    private static Logger logger = LoggerFactory.getLogger(AuthRestInterceptor.class);
//
////    @Autowired
////    DeviceService deviceService;
//
//    @Autowired
//    RedisUtils redisUtils;
//
//    @Autowired
//    UserService userService;
//
//    @Autowired
//    SQLInterceptor sqlInterceptor;
//
//    @Autowired
//    JeegyUtils jeegyUtils;
////    @Autowired
////    private TokenCacheService tokenCacheService;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HandlerMethod handlerMethod = (HandlerMethod) handler;
//        // 配置该注解，说明不进行用户拦截
//        IgnoreAuthToken annotation = handlerMethod.getBeanType().getAnnotation(IgnoreAuthToken.class);
//        if (annotation == null) {
//            annotation = handlerMethod.getMethodAnnotation(IgnoreAuthToken.class);
//        }
//        if (annotation != null) {
//            return super.preHandle(request, response, handler);
//        }
//        String token = request.getHeader(JwtConstants.JWT_HEADER);
//        if (StringUtils.isEmpty(token)) {
//            //jwt为空
//            throw new JwtException(ResultEnum.NO_JWT.getErrcode(), "no jwt");
//        }
//
//        String simpileJwt = JwtTokenUtil.getSimpleJwt(token);
//        if (StringUtils.isEmpty(simpileJwt)) {
//            //过滤
//            throw new JwtException(ResultEnum.ERR_JWT.getErrcode(), "err jwt");
//        }
////        String requestAccount = request.getHeader(JwtConstants.ACCOUNT_HEADER);
////
////        if (StringUtils.isEmpty(requestAccount)) {
////            //无法从请求头中年拿到用户account
////            throw new JwtException(ResultEnum.ERR_JWT.getErrcode(), "请求头错误");
////        }
//
//        Jwt jwt = JwtTokenUtil.getPayLoad(token);
//        if (jwt == null) {
////            解析payLoad部分
//            throw new JwtException(ResultEnum.ERR_JWT.getErrcode(), "err jwt");
//        }
//
////        JwtCache existJwt = tokenCacheService.getTokenFromCache(jwt.getSub());
////        if(existJwt == null){
//        //从缓存中取出该用户的登录信息
////            throw new JwtException(ResultEnum.ERR_JWT.getErrcode(),"err jwt");
////        }
////
////        if(!simpileJwt.equals(existJwt.getJwt())){
////            校验jwt是否有效
////            throw new JwtException(ResultEnum.ERR_JWT.getErrcode(),"err jwt");
////        }
//        if (JwtConstants.JWT_PC.equals(jwt.getMethod())) {
//
//            String tenantName = jwt.getTenantName();
//            User user;
//            sqlInterceptor.setTenantName(tenantName);
//            jeegyUtils.setTenantName(tenantName);
//
//            user = userService.getUser(Long.valueOf(jwt.getSub()));
//
//            if (user == null
//                    || UserStatusEnum.USER_NORMAL.getStatus().intValue() != user.getStatus().intValue()) {
//                //用户不存在或者用户状态异常
//                throw new JwtException(ResultEnum.ERR_JWT.getErrcode(), "err jwt");
//            }
//
////            //过期时间存放在redis缓存中
////            if (isTokenExpired(user.getAccount())) {
//////            校验jwt过期
////                throw new JwtException(ResultEnum.ERR_JWT.getErrcode(), "err jwt");
////            }
////
//            //从缓存中读取jwt，如果没有jwt，需要先登录
//           /* String jwtCache = (String) redisUtils.hget(user.getAccount(), JwtConstants.JWT_ISS);
//
//            if (StringUtils.isEmpty(jwtCache)) {
//                throw new JwtException(ResultEnum.ERR_JWT.getErrcode(), "鉴权失败，请先登录");
//            }*/
//
//            /**
//             * 续租,每次鉴权成功都续租--重新设置缓存的失效时间,当两次调用接口的时间间隔大于过期时间,
//             * redis缓存会根据制定的缓存失效时间定时删除缓存,这样,在读取jwt缓存时就会失败,需要重新登录
//             */
//            reletExpireTime(user.getAccount());
//
//            if (JwtTokenUtil.parseToken(simpileJwt, user.getSecret())) {
//                throw new JwtException(ResultEnum.ERR_JWT.getErrcode(), "err jwt");
//            }
//
////            根据当前用户校验对该功能模块的访问权限
//           /* Boolean funcAuthenCheck = userService.funcAuthenCheck(user.getId(), request.getRequestURI());
//            if (!funcAuthenCheck){
//                throw new JwtException(ResultEnum.USER_NO_AUTHEN_ERROR.getErrcode(), "鉴权失败，用户对该模块没有访问权限");
//            }*/
//
//        } else {
//            throw new JwtException(ResultEnum.ERR_JWT.getErrcode(), "err jwt");
//        }
//        return super.preHandle(request, response, handler);
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        SQLInterceptor.clearTenantName();
//        super.afterCompletion(request, response, handler, ex);
//    }
//
////    /**
////     * 判断jwt是否过期
////     * @param account
////     * @return
////     */
////    public Boolean isTokenExpired(String account) {
////        try {
////            final Date expiration = new Date((Long) redisUtils.hget(account, JwtConstants.ACCOUNT_EXPIRATION));
////            return expiration.before(new Date());
////        } catch (ExpiredJwtException expiredJwtException) {
////            return true;
////        }
////    }
//
//    /**
//     * 续租
//     * @param account
//     */
//    public void reletExpireTime(String account) {
//
//        redisUtils.hset(account, JwtConstants.ACCOUNT_EXPIRATION, System.currentTimeMillis() + JwtConstants.EXPIRATION, JwtConstants.EXPIRATION / 1000);
//        redisUtils.expire(account, JwtConstants.EXPIRATION / 1000);
//    }
}
