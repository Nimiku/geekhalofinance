/*package cn.geekhalo.webtech.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.shourong.invest.config.ShouRongConstants;
import com.shourong.invest.service.ISystemConfigService;
import com.shourong.invest.service.IUserFailureLogService;

public class ShourongCaAuthenticationLoginFilter extends UsernamePasswordAuthenticationFilter {
	*//**
	 * Logger for this class
	 *//*
	private static final Logger logger = Logger.getLogger(ShourongCaAuthenticationLoginFilter.class);

	// 可以在此配置其他的配置参数
	private String extraParams;
	@Autowired
	private IUserFailureLogService failureService;
	@Autowired
	private ISystemConfigService configService;

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		Authentication auth = null;
		try {
			auth = super.attemptAuthentication(request, response);
		} catch (UsernameNotFoundException e1) {
			logger.info("用户名或者密码错误");
			request.setAttribute(ShouRongConstants.ERROR_MSG, "用户名或者密码错误");
			throw e1;
		} catch (BadCredentialsException e2) {
			logger.info("用户名或者密码错误");
			request.setAttribute(ShouRongConstants.ERROR_MSG, "用户名或者密码错误，密码错误超5次账户锁定");
			throw e2;
		} catch (LockedException e3) {
			request.setAttribute(ShouRongConstants.ERROR_MSG, "账户已经被锁定，请联系客服人员");
			//request.setAttribute(ShouRongConstants.ERROR_MSG, "系统正在上线调试，暂时无法登陆");
			//throw new LockedException("系统正在上线调试，暂时无法登陆");
			throw new LockedException("账户已经被锁定，请联系客服人员");
		} catch (DisabledException e4) {
			request.setAttribute(ShouRongConstants.ERROR_MSG, "账户已经被禁用，请联系客服人员");
			throw new DisabledException("账户已经被禁用");
		} catch (Exception e) {
			logger.error("用户登录出现异常", e);
			// 将异常信息隐藏
			throw new UsernameNotFoundException("用户名或者密码错误");
		}
		return auth;

	}

	public String getExtraParams() {
		return extraParams;
	}

	public void setExtraParams(String extraParams) {
		this.extraParams = extraParams;
	}

}
*/