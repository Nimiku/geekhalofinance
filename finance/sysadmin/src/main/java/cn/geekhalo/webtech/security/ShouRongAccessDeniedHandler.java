/*package cn.geekhalo.webtech.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.csrf.InvalidCsrfTokenException;
import org.springframework.security.web.csrf.MissingCsrfTokenException;

import com.shourong.invest.config.ShouRongConstants;

public class ShouRongAccessDeniedHandler extends AccessDeniedHandlerImpl {
	//因为使用了csrfToken的缘故如果用户是用之前的页面登录，那么会报错要求用户重新登录，那么记住之前的地址为登录地址，所有需要进行跳转配置
	private String invalidCsrfTokenPage;//无效token页面
	private String authPage;//身份认证的页面
	private String loginPage;
	private String sysErrorPage;//系统异常页面
	private String defaultPage;//默认没有权限页面
	*//**
	 * Logger for this class
	 *//*
	private static final Logger logger = Logger
			.getLogger(ShouRongAccessDeniedHandler.class);

	@Override
	public void handle(HttpServletRequest request,
			HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException,
			ServletException {
		//SavedRequest savedRequest = new HttpSessionRequestCache().getRequest(request, response);
		try{
			if(MissingCsrfTokenException.class.isAssignableFrom(accessDeniedException.getClass())){
				if(!response.isCommitted())
	                request.setAttribute("SPRING_SECURITY_403_EXCEPTION", accessDeniedException);
	                response.setStatus(403);
	                logger.info("Missing token");
	                RequestDispatcher dispatcher = request.getRequestDispatcher(invalidCsrfTokenPage);
	                dispatcher.forward(request, response);
	                return ;
				}
			if(InvalidCsrfTokenException.class.isAssignableFrom(accessDeniedException.getClass())){
				//token失效
				logger.info("Invalid token");
				RequestDispatcher dispatcher = request.getRequestDispatcher(loginPage);
	            dispatcher.forward(request, response);
	            return ;
			}
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			//此处也可以用SecurityContextHolder
			AuthenticationTrustResolverImpl at = new AuthenticationTrustResolverImpl();
			if(at.isRememberMe(auth)){
				//如果是匿名那么要求用户从新登录
				 request.setAttribute("tip", "为了安全起见，您需要重新登录");
				 RequestDispatcher dispatcher = request.getRequestDispatcher(loginPage);
	             dispatcher.forward(request, response);
	             return ;
			}else{
				//如果不是匿名的那么取出用户的所有权限进行判断，缺少什么权限跳转到什么页面，如果没有investor 要求认证，如果没有loaner权限那么跳转到
				Collection<? extends GrantedAuthority>  list = auth.getAuthorities();
				List<String> authList = new ArrayList<String>();
				if(null!=list&&list.size()>0){
					for(GrantedAuthority s : list){
						authList.add(s.getAuthority());
					}
				}
				if(!authList.contains(ShouRongConstants.USER_ROLE_INVESTOR)){
					//如果没有投资权限跳转到实名认证页面
					RequestDispatcher dispatcher = request.getRequestDispatcher(authPage);
		            dispatcher.forward(request, response);
		            return ;
				}
				if(!authList.contains(ShouRongConstants.USER_ROLE_LOANER)){
					//如果没有借款人权限，跳转到提示页面 
				}
				//默认就跳转到没有权限页面
				RequestDispatcher dispatcher = request.getRequestDispatcher(defaultPage);
	            dispatcher.forward(request, response);
			}
		}catch(Exception e){
			logger.error("权限拒绝处理器，发生异常，跳转到系统异常页面", e);
			RequestDispatcher dispatcher = request.getRequestDispatcher(sysErrorPage);
            dispatcher.forward(request, response);
		}
		
	}

	public String getInvalidCsrfTokenPage() {
		return invalidCsrfTokenPage;
	}

	public void setInvalidCsrfTokenPage(String invalidCsrfTokenPage) {
		this.invalidCsrfTokenPage = invalidCsrfTokenPage;
	}

	public String getAuthPage() {
		return authPage;
	}

	public void setAuthPage(String authPage) {
		this.authPage = authPage;
	}

	public String getLoginPage() {
		return loginPage;
	}

	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}

	public String getSysErrorPage() {
		return sysErrorPage;
	}

	public void setSysErrorPage(String sysErrorPage) {
		this.sysErrorPage = sysErrorPage;
	}

	public String getDefaultPage() {
		return defaultPage;
	}

	public void setDefaultPage(String defaultPage) {
		this.defaultPage = defaultPage;
	}

}
*/