/*package cn.geekhalo.webtech.interceptor;

import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.shourong.invest.base.annotation.AdminAudit;
import com.shourong.invest.base.exception.SystemException;
import com.shourong.invest.config.ShouRongConstants;
import com.shourong.invest.pojo.UserAuditLog;
import com.shourong.invest.service.IUserAuditLogService;
import com.shourong.invest.util.SpringSecurityUtil;
import com.shourong.invest.util.StringUtil;
*//**
 * 审计日志工具类，在此处可以进行用户操作的审计日志记录
 * @author Administrator
 *
 *//*
public class LogInterceptor extends HandlerInterceptorAdapter {
	private NamedThreadLocal<Long> local = new NamedThreadLocal<Long>("timeContainer");
	private NamedThreadLocal<Date> dateContainer = new NamedThreadLocal<Date>("dateContainer");
	@Autowired
	private IUserAuditLogService auditLogService;
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
			AdminAudit auditLog = ((HandlerMethod)handler).getMethodAnnotation(AdminAudit.class);
			if(null!=auditLog){
					try{
					Long endTime = System.currentTimeMillis();
					Long startTime = local.get();
					Long duration = endTime -startTime;
					UserAuditLog log = new UserAuditLog();
					log.setOperationLevel(auditLog.operateLevel());
					log.setOperateName(auditLog.name());
					log.setOperateDuration(new BigDecimal(duration));
					log.setOperateMethod(((HandlerMethod)handler).getMethod().getName());
					log.setLoginIp(StringUtil.getIpAddr(request));
					log.setOperateUrl(request.getRequestURL().toString());
					log.setOperateTime(dateContainer.get());
					log.setId(StringUtil.generateUUID());
					log.setOperateEndTime(new Date());
					log.setOperateUser(SpringSecurityUtil.getUsername());
					if(!StringUtil.isEmpty(auditLog.param())){
						log.setRequestId(request.getParameter(auditLog.param()));
					}
					auditLogService.insertSelective(log);
				}catch(Exception e){
					throw new SystemException(ShouRongConstants.SYSTEM_ERROR_MESSAGE);
				}
				
			}
		}
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		Long startTime = System.currentTimeMillis();
		local.set(startTime);
		dateContainer.set(new Date());
		return super.preHandle(request, response, handler);
	}
	
}
*/