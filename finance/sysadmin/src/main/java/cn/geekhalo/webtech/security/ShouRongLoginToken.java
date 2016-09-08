/*package cn.geekhalo.webtech.security;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class ShouRongLoginToken extends AbstractAuthenticationToken{
	*//**
	 * 
	 *//*
	private static final long serialVersionUID = 359865752968827264L;
	Object principal;
	Object credentials;
	public ShouRongLoginToken(Object principal,Object credentials,Collection<? extends GrantedAuthority> authorities){
		 super(authorities);
		 this.principal = principal;
	     this.credentials = credentials;
	     super.setAuthenticated(true);
	}
	public ShouRongLoginToken(Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return credentials;
	}

	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return principal;
	}
	
}
*/