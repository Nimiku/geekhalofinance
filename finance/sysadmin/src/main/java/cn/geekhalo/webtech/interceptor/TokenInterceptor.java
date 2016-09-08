/*package cn.geekhalo.webtech.interceptor;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import payment.tools.util.StringUtil;

import com.shourong.invest.base.annotation.TokenForSubmit;
import com.shourong.invest.base.exception.BusinessException;

public class TokenInterceptor extends HandlerInterceptorAdapter{
	public static final String TOKEN_NAME = "sr_token";
	public static final String TOKEN_HASH_KEY = "token:duplicate:";
	public static final int EXPIRE_TIME = 30; //token 失效时间
	@Autowired
	private RedisTemplate<String, String> redisService;
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		  if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
			  TokenForSubmit annotation = ((HandlerMethod)handler).getMethodAnnotation(TokenForSubmit.class);
	             if (annotation != null ) {
	                 boolean create = annotation.create();
	                 if (create) {
	                	 String token = UUID.randomUUID().toString();
	                	 redisService.opsForValue().set(TOKEN_HASH_KEY+token, token);
	                	 redisService.expire(TOKEN_HASH_KEY+token, EXPIRE_TIME, TimeUnit.MINUTES);
	                     request.getSession().setAttribute( TOKEN_NAME , token);
	                 }
	                 boolean needRemoveSession = annotation.remove();
	                 if (needRemoveSession) {
	                	 //判断是否重复提交了
	                     if (isDuplicate(request)) {
	                    	 throw new BusinessException("不能重复提交数据");
	                     }
	                 }
	             }
	             return true ;
	         } else {
	             return super .preHandle(request, response, handler);
	         }
	}
	
	private boolean isDuplicate(HttpServletRequest request){
		 String clinetToken = request.getParameter(TOKEN_NAME);
         if (clinetToken == null ) {
             return true ;
         }
         String value = redisService.opsForValue().get(TOKEN_HASH_KEY+clinetToken);
    	 if(StringUtil.isEmpty(value)){
    		 return true;
    	 }
    	 redisService.delete(TOKEN_HASH_KEY+clinetToken);
         return false ;
	}
}
*/