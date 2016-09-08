package cn.geekhalo.webtech.exception;

import java.util.Map;

/**
 * 业务异常封装类，如果页面属于页面跳转的话使用此异常，此异常会由springmvc 全局进行处理
 * @author Gim
 *
 */
public class BusinessException extends RuntimeException {
	private String errorPath ="error/business_error";
	private String errorMsg;
	private boolean forward = true;
	private Map<String,Object> map;
	/**
	 * 
	 */
	public BusinessException(){
		super();
	}
	public BusinessException(String msg){
		super(msg);
		this.errorMsg = msg;
	}
	public BusinessException(String msg,String errorPath){
		this.errorMsg = msg;
		this.errorPath = errorPath;
	}
	public BusinessException(String msg,Map<String,Object> map,String errorPath){
		this.errorMsg = msg;
		this.errorPath = errorPath;
		this.map = map;
	}
	public BusinessException(String msg,String errorPath,boolean forwardOrRedirect){
		this.errorMsg = msg;
		this.errorPath = errorPath;
		this.forward = forwardOrRedirect;
	}
	private static final long serialVersionUID = -8776794322522118594L;
	public String getErrorPath() {
		return errorPath;
	}
	public void setErrorPath(String errorPath) {
		this.errorPath = errorPath;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public boolean isForward() {
		return forward;
	}
	public void setForward(boolean forward) {
		this.forward = forward;
	}
	public Map<String,Object> getMap() {
		return map;
	}
	public void setMap(Map<String,Object> map) {
		this.map = map;
	}
	
}
