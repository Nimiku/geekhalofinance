package cn.geekhalo.webtech.exception;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class JsonException extends RuntimeException implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8311926783369386306L;
		//用于存放需要的Ajax信息
		private Map<String,Object> data = new HashMap<String,Object>();
		public Map<String, Object> getData() {
			return data;
		}

		public void setData(Map<String, Object> data) {
			this.data = data;
		}

		public JsonException(String msg,Exception e){
			super(msg,e);
		}
		public JsonException(String msg,Map<String,Object> data){
			super(msg);
			this.data = data;
		}
		public JsonException(String msg){
			super(msg);
		}
}
