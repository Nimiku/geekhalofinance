/*package cn.geekhalo.webtech.security;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.shourong.invest.pojo.UserAccount;
import com.shourong.invest.pojo.UserFund;
import com.shourong.invest.service.IUserAccountService;
import com.shourong.invest.service.IUserFundService;
import com.shourong.invest.util.MoneyUtil;
public class CustomDaoUserDetailsService implements UserDetailsService {
	*//**
	 * Logger for this class
	 *//*
	private static final Logger logger = Logger
			.getLogger(CustomDaoUserDetailsService.class);

	@Autowired
	private IUserAccountService userAccountService;
	@Autowired
	private IUserFundService userFundService;
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UserAccount user = userAccountService.getUserByUsername(username);
		if(null==user){
			throw new UsernameNotFoundException("用户名或者密码错误");
		}
		Set<? extends GrantedAuthority> authSet = new HashSet<SimpleGrantedAuthority>();
		authSet = userAccountService.getAuthoritiesByUserId(user.getId());
		logger.info(user.getUsername()+"权限"+authSet.toString());
		//将用户的信息保存在session之中
		//
		SpringSessionInfo info = new SpringSessionInfo(user, authSet);
		UserFund  fund = userFundService.selectFundByUserId(user.getId());
		if(null!=fund){
			double total = MoneyUtil.add(MoneyUtil.add(fund.getTotalReturnBonus().doubleValue(), fund.getTotalPunishMoney().doubleValue()),fund.getTotalReturnInterest().doubleValue());
			String totalstr = MoneyUtil.formatToMoneyDisplay(total);
			info.setTotalEarn(totalstr);
		}
		return info;
	}
	
}
*/