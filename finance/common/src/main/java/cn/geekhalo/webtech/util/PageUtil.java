package cn.geekhalo.webtech.util;


/**
 * 分页工具类
 * @author Gim
 *
 * @param 
 */
public class PageUtil {
	/**
	 * 排序的字段
	 */
	private String sortStr;
	
	private String params;
	/**
	 * 排序的方式 asc,desc
	 */
	private String sortOrder;
	/**
	 * 第几页
	 */
	private Integer pageIndex=1;
	/**
	 * 每页几条
	 */
	private Integer pageSize = 20;
	/**
	 * 共几页
	 */
	@SuppressWarnings("unused")
	private Integer pagecount=0;
	/**
	 * 从第几条开始
	 */
	private Integer startNum=0;
	/**
	 * 到第几条结束
	 */
	@SuppressWarnings("unused")
	private Integer endNum=0;
	/**
	 * 共多少条
	 */
	private Integer count=0;
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageIndex() {
		if(this.pageIndex<1){
			this.pageIndex =1;
		}
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getPagecount() {
		if (this.count % this.pageSize == 0) {
			return (this.count / this.pageSize);
		}
		return (this.count / this.pageSize + 1);
	}
	public void setPagecount(Integer pagecount) {
		this.pagecount = pagecount;
	}
	public Integer getStartNum() {
		return (this.pageIndex-1)*this.pageSize+1;
	}
	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}
	public Integer getEndNum() {
		if(this.startNum.equals(this.pageIndex)){
			return this.count;
		}else{
			return this.getStartNum()+this.pageSize-1;
		}
		
	}
	public void setEndNum(Integer endNum) {
		this.endNum = endNum;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
		if(count%pageSize == 0&&count >= pageSize){
			this.pagecount = count/pageSize;
		}else{
			this.pagecount = count/pageSize+1;
		}
	}
	public static void main(String[] args) {
		PageUtil page = new PageUtil();
		page.setCount(6);
		page.setPageSize(10);
		page.setPageIndex(2);
		System.out.println(page.getStartNum());
	}
	public String getSortStr() {
		return sortStr;
	}
	public void setSortStr(String sortStr) {
		this.sortStr = sortStr;
	}
	public String getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
}
