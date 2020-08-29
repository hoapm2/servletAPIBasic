package model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractModel <T>{
   private long id;
   private Timestamp createDate;
   private Timestamp modifiedDate;
   private String createBy;
   private String modifiedBy;
   private long [] ids;
   private List<T> listResult= new ArrayList<>();
   private Integer page; // trang bat dau
   private Integer maxItemOnPage;
   private Integer totalPage;
   private Integer totalItem;
   private String sortName;
   private String sortBy;
   private String type; // dung de quy dinh nhung hanh dong cua client doi voi moi controller: them sua xoa
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public Timestamp getCreateDate() {
	return createDate;
}
public void setCreateDate(Timestamp createDate) {
	this.createDate = createDate;
}
public Timestamp getModifiedDate() {
	return modifiedDate;
}
public void setModifiedDate(Timestamp modifiedDate) {
	this.modifiedDate = modifiedDate;
}
public String getCreateBy() {
	return createBy;
}
public void setCreateBy(String createBy) {
	this.createBy = createBy;
}
public String getModifiedBy() {
	return modifiedBy;
}
public void setModifiedBy(String modifiedBy) {
	this.modifiedBy = modifiedBy;
}
public long [] getIds() {
	return ids;
}
public void setIds(long [] ids) {
	this.ids = ids;
}
public List<T> getListResult() {
	return listResult;
}
public void setListResult(List<T> listResult) {
	this.listResult = listResult;
}
public Integer getPage() {
	return page;
}
public void setPage(Integer page) {
	this.page = page;
}
public Integer getMaxItemOnPage() {
	return maxItemOnPage;
}
public void setMaxItemOnPage(Integer maxItemOnPage) {
	this.maxItemOnPage = maxItemOnPage;
}
public Integer getTotalPage() {
	return totalPage;
}
public void setTotalPage(Integer totalPage) {
	this.totalPage = totalPage;
}
public Integer getTotalItem() {
	return totalItem;
}
public void setTotalItem(Integer totalItem) {
	this.totalItem = totalItem;
}
public String getSortBy() {
	return sortBy;
}
public void setSortBy(String sortBy) {
	this.sortBy = sortBy;
}
public String getSortName() {
	return sortName;
}
public void setSortName(String sortName) {
	this.sortName = sortName;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

   
   
}
