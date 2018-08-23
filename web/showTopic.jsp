<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title><s:property value="#topic.title" /> </title>
	<link rel="stylesheet" type="text/css" href="css/main.css"> 
</head>
<body>
	<!-- 简单搜索表单 -->
	<div style="margin: 15px auto; " >
		<!-- 搜索表单 -->
		<%--<form action="" class="simpleSearchForm" onsubmit="alert('暂不支持此功能！');return false;">--%>
			<font class="logoLabel">大木BBS</font>
			<%--<input type="text" name="queryString" class="queryString"/>--%>
			<%--<input type="submit" value="搜 索" />--%>
		<%--</form>--%>
	</div>
	<!-- 菜单 -->
	<div class="menubar">
		<s:url action="TopicAction_list" var="aURL">
		</s:url>
		<s:a href="%{aURL}">主题列表</s:a>
	</div>
	
	<!-- 当前主题贴数 -->
	<div style="padding: 10px 30px; font-size: 12px; font-family:'宋体'">
		共有<font color="red"><s:property value="#replyList.size" /> </font>个回帖
	</div>
	
	<!-- 显示主题 -->
	<table class="postList" cellspacing="0">
	    <tr class="title">
	        <td width="20" class="num">1</td>
	        <td><s:property value="#topic.title"/></td>
	    </tr>
	    <tr class="content">
	        <td></td>
	        <td><pre><s:property value="#topic.topicContext"/></pre></td>
	    </tr>
	    <tr class="info">
	        <td></td>
	        <td>
				作者：<font color="blue"><s:property  value="#topic.ipAddr" /></font> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            <font color="#999999"><s:date name="#topic.createDate" format="yyyy-MM-dd hh:mm:ss" /></font>
	        </td>
	    </tr>
	</table>
	
	<!-- 显示回复列表 -->
	<s:iterator value="#replyList" var="reply">
		<table class="postList" cellspacing="0">
			<tr class="title">
				<td width="20" class="num"><s:property  value="rid+1" /> </td>
				<td></td>
			</tr>
			<tr class="content">
				<td></td>
				<td><pre><s:property value="replyContext" /></pre></td>
			</tr>
			<tr class="info">
				<td></td>
				<td>
					作者：<font color="blue"><s:property  value="ipAddr" /></font> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<font color="#999999"><s:date name="createDate" format="yyyy-MM-dd hh:mm:ss" /></font>
				</td>
			</tr>
		</table>
	</s:iterator>
    
    <div style="margin-bottom: 20px"></div>
	<!-- 发表回复表单 -->
	<s:form action="TopicAction_reply" namespace="/" theme="simple">

	<%--<form action="" class="addNewTopicForm">--%>
		<table class="publishArticleForm">
	        <tr>
	            <td class="label">内　容:<s:hidden name="topic.tid" value="%{topic.tid}"/></td>
	            <td><s:textarea name="reply.replyContext" cssclass="content"/></td>
	        </tr>
	        <tr>
	            <td></td>
	            <td><input type="submit" value="回　贴"/></td>
	        </tr>
	    </table>
	</s:form>
</body>
</html>