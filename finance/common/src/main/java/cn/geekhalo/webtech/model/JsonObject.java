package cn.geekhalo.webtech.model;

import java.io.Serializable;


/**
 * 此类用于平台json信息的封装
 * @author Gim
 *
 */
public class JsonObject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -371061027875443207L;

	public JsonObject() {
		super();
	}

	public JsonObject(boolean success, String msg, Object data) {
		super();
		this.success = success;
		this.msg = msg;
		this.data = data;
	}

	public JsonObject(boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}

	//是否成功
	private boolean success = false;
	//提示信息
	private String msg = "";
	//存放的对象
	private Object data = null;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
