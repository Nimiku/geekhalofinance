/*package cn.geekhalo.webtech.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.shourong.invest.config.ShouRongConstants;
import com.shourong.invest.config.SystemConfigConstants;
import com.shourong.invest.pojo.SystemConfig;
import com.shourong.invest.pojo.UserAccount;
import com.shourong.invest.pojo.UserFailureLog;
import com.shourong.invest.service.ISystemConfigService;
import com.shourong.invest.service.IUserAccountService;
import com.shourong.invest.service.IUserFailureLogService;
import com.shourong.invest.util.StringUtil;

public class CustomAuthenticationProvider extends DaoAuthenticationProvider {
	@Autowired
	private IUserAccountService accountService;
	@Autowired
	private IUserFailureLogService failureService;
	@Autowired
	private ISystemConfigService configService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		try {
			return super.authenticate(authentication);
		} catch (AuthenticationException e) {
			// 如果是密码错误，那么进行密码错误特殊处理，进行锁定账户，添加登录错误信息
			if (e.getClass().isAssignableFrom(BadCredentialsException.class)) {
				// 获取用户名
				String username = authentication.getName();
				UserAccount account = accountService.getUserByUsername(username);
				if (null == account) {
					throw e;
				}
				// 查询五分钟之内登录失败的次数
				int count = failureService.getFailureTimesInFiveMinutes(username);
				SystemConfig config = configService.getConfigInfoByKey(SystemConfigConstants.ALLOW_FAILURE_TIMES);
				String configTimes = (config == null) ? "5" : config.getValue();
				if (count > Integer.parseInt(configTimes)) {
					logger.info("用户" + username + "登录错误次数超过了" + configTimes + "将会进行账户锁定");
					// 如果登录的错误次数超过了配置的允许次数，锁定账户
					try {
						account.setNoLocked(ShouRongConstants.NO);
						account.setLockDate(new Date());
						accountService.updateByPrimaryKeySelective(account);
					} catch (Exception e1) {
						logger.error("锁定用户" + username + "出错！", e1);
					}
				} else {
					// 如果没有超过那么只保存错误日志
					// 获取配置项，五分钟内连续登录几次进行账户锁定
					if (!StringUtil.isEmpty(username)) {
						UserFailureLog log = new UserFailureLog();
						log.setId(StringUtil.generateUUID());
						log.setLoginTime(new Date());
						log.setLoginUser(username);
						log.setRemark("用户" + username + "登录失败");
						try {
							failureService.insertSelective(log);
						} catch (Exception t) {
							logger.error("插入登录错误信息出错", t);
						}
					}
				}
			}
			throw e;
		}
	}

}
*/