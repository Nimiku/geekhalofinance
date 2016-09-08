/*package cn.geekhalo.webtech.security;

import java.util.Collection;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.core.Authentication;

import com.shourong.invest.base.exception.CustomAccessDeniedException;
//定制投票器
@SuppressWarnings("deprecation")
public class CustomUnanimousBased extends UnanimousBased {
	@Override
	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> attributes)
			throws AccessDeniedException {
		try {
			super.decide(authentication, object, attributes);
		} catch (AccessDeniedException ade) {
			throw new CustomAccessDeniedException(ade.getMessage(), authentication,
					object, attributes);
		}
	}
	
}
*/