/**
* @Title: News.java
* @Package com.news.pojo
* @Description: TODO
* @author Lover
* @date 2017年5月18日
* @version V1.0
*/
package com.news.pojo;

import java.io.File;
import java.sql.Date;

import org.apache.struts2.ServletActionContext;

public class News {
	private int nid;
	private String title;
	private String content;
	private String source;
	private Date issueTime;
	private File upload;//上传的文件
	private String uploadFileName;//上传的文件名
	private String image_path;//上传文件的路径
	private int categoryId;
	private Category category;
	
	/**
	 * @return the nid
	 */
	public int getNid() {
		return nid;
	}
	/**
	 * @param nid the nid to set
	 */
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * @return the issueTime
	 */
	/**
	 * @return the issueTime
	 */
	public Date getIssueTime() {
		return issueTime;
	}
	/**
	 * @param issueTime the issueTime to set
	 */
	public void setIssueTime(Date issueTime) {
		this.issueTime = issueTime;
	}
	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getImage_path() throws Exception {
		return ServletActionContext.getServletContext().getRealPath("/upload");
	}
	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}
	
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
}
