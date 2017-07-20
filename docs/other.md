private  int recordCount;//总数据条数
private int pageIndex;//当前页面   
private int pageSize; //每页分多少条数据
private int totalSize;//总页数

page.tld：支持jsp标签的使用
HrmService:业务逻辑方法的定义
HrmServiceImpl:业务逻辑方法的实现

<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!-- 配置分页标签   -->
<%@ taglib prefix="fkjava" uri="/pager-tags" %>
