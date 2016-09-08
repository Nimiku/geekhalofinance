package cn.geekhalo.webtech.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.web.util.HtmlUtils;
import org.springframework.web.util.JavaScriptUtils;

public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {  
    public XssHttpServletRequestWrapper(HttpServletRequest servletRequest) {
        super(servletRequest);
    }
    public String[] getParameterValues(String parameter) {
      String[] values = super.getParameterValues(parameter);
      if (values==null)  {
                  return null;
          }
      int count = values.length;
      String[] encodedValues = new String[count];
      for (int i = 0; i < count; i++) {
                 encodedValues[i] = cleanXSS(values[i]);
       }
      return encodedValues;
    }
    public String getParameter(String parameter) {
          String value = super.getParameter(parameter);
          if (value == null) {
                 return null;
                  }
          return cleanXSS(value);
    }
    private String cleanXSS(String value) {
        return HtmlUtils.htmlEscape(value);
    }

} 
