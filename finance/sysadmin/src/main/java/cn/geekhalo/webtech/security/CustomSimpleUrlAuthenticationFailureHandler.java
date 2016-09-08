/*package cn.geekhalo.webtech.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
*//**
 * 认证失败处理器，可以进行账号锁定，错误提示等消息提示
 * @author Administrator
 *
 *//*
public class CustomSimpleUrlAuthenticationFailureHandler extends
		SimpleUrlAuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		if(exception.getClass().isAssignableFrom(BadCredentialsException.class)){
			request.setAttribute(ShouRongConstants.ERROR_MSG, "用户名或者密码错误！");
		}else if(exception.getClass().isAssignableFrom(SessionAuthenticationException.class)){
			request.setAttribute(ShouRongConstants.ERROR_MSG, "该用户已经登录！");
		}else{
			request.setAttribute(ShouRongConstants.ERROR_MSG, "登录失败！");
		}
		super.onAuthenticationFailure(request, response, exception);
	}

}
*/