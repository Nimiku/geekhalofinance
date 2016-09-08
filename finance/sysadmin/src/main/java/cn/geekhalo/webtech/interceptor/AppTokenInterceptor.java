/*package cn.geekhalo.webtech.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.shourong.invest.base.exception.AppRequestTokenMissException;
import com.shourong.invest.config.AppConstants;
import com.shourong.invest.service.IAppBaseService;
import com.shourong.invest.util.StringUtil;

public class AppTokenInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	private IAppBaseService appService;
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		  if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
			  	 String appRequestToken = request.getParameter(AppConstants.REQUEST_TOKEN_NAME);
			  	 if(StringUtil.isEmpty(appRequestToken)){
			  		 throw new AppRequestTokenMissException("token为空，请求拒绝",AppConstants.APP_CODE_MISS_TOKEN);
			  	 }
			  	 String userId = appService.getUserIdByToken(request);
			  	 if(StringUtil.isEmpty(userId)){
			  		 throw new AppRequestTokenMissException("token无效或者已经过期",AppConstants.APP_CODE_INVALID_TOKEN);
			  	 }
	             return true ;
	         } else {
	             return super .preHandle(request, response, handler);
	         }
	}
}
*/