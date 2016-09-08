/*package cn.geekhalo.webtech.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;

import com.shourong.invest.pojo.UserAccount;
import com.shourong.invest.pojo.UserLoginLog;
import com.shourong.invest.service.IUserAccountService;
import com.shourong.invest.service.IUserLoginLogService;
import com.shourong.invest.util.StringUtil;
import com.shourong.invest.util.UrlTool;
*//**认证成功之后处理逻辑类
 * (加入用户登录的审计日志)
 * @author Gim
 *
 *//*
public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	@Autowired
	private IUserLoginLogService logService;
	@Autowired
	private IUserAccountService accountService;
	
	*//**
	 * Logger for this class
	 *//*
	private static final Logger logger = Logger
			.getLogger(CustomAuthenticationSuccessHandler.class);
	private static final String CSRF_TOKEN = "srToken";

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws ServletException, IOException {
		SpringSessionInfo info = (SpringSessionInfo)authentication.getPrincipal();
		try{
			UserLoginLog log = new UserLoginLog();
			log.setLoginUser(info.getUsername());
			log.setId(StringUtil.generateUUID());
			log.setLoginIp(StringUtil.getIpAddr(request));
			log.setLoginTime(new Date());
			//log.setTargetUrl(request.getRequestURL().toString());
			log.setLoginUserId(info.getId());
			log.setRemark("用户"+info.getUsername()+"登录成功");
			logService.insertSelective(log);
			//更新用户最新登录时间
			UserAccount ua = new UserAccount();
			ua.setId(info.getId());
			ua.setLastLoginDate(log.getLoginTime());
			accountService.updateByPrimaryKeySelective(ua);
		}catch(Exception e){
			logger.error("登录成功审计日志记录失败！"+e.getLocalizedMessage(),e);
		}
		
		String ctoken = (String) request.getSession().getAttribute(CSRF_TOKEN);
        DefaultSavedRequest defaultSavedRequest = (DefaultSavedRequest) request.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST_KEY");
        if( defaultSavedRequest != null && ctoken != null ) {
            String requestUrl = defaultSavedRequest.getRequestURL() + "?" + defaultSavedRequest.getQueryString();
            requestUrl = UrlTool.addParamToURL(requestUrl, CSRF_TOKEN, ctoken, true);
            getRedirectStrategy().sendRedirect(request, response, requestUrl);
        } else {
            super.onAuthenticationSuccess(request, response, authentication);
        }
	}

}
*/