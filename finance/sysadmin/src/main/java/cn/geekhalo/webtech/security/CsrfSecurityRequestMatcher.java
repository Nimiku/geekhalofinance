/*package cn.geekhalo.webtech.security;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
*//**
 * 哪些页面不需要csrf 校验
 * @author GIM
 *
 *//*
public class CsrfSecurityRequestMatcher implements RequestMatcher {

	 private Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");
	 private AntPathRequestMatcher unprotectedMatcher = new AntPathRequestMatcher("/project/*", null);
	 private AntPathRequestMatcher unprotectedMatercher2 = new AntPathRequestMatcher("/app/*", null);
	 private AntPathRequestMatcher unprotectedMatercher3 = new AntPathRequestMatcher("/userApp/*", null);
	 
	    @Override
	    public boolean matches(HttpServletRequest request) {
	        if(allowedMethods.matcher(request.getMethod()).matches()){
	            return false;
	        }
	        return !unprotectedMatcher.matches(request)&&!unprotectedMatercher2.matches(request)&&!unprotectedMatercher3.matches(request);
	    }

}
*/