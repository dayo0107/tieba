<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>大木BBS</title>
  <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
  <body>
    <!-- 简单搜索表单 -->
    <div style="margin: 15px auto; " >
      <!-- 搜索表单 -->
      <s:form action="TopicAction_list" namespace="/" theme="simple" cssClass="simpleSearchForm" >
        <font class="logoLabel">大木BBS</font>
        <s:textfield name="key" cssClass="queryString" />
        <input type="submit" value="搜 索" />
      </s:form>
    </div>
    <!-- 菜单 -->
    <div class="menubar"></div>
    <!-- 主题列表 -->
    <table cellspacing="0">
      <tbody class="list topicList">
      <!--显示表头-->
      <tr class="title">
        <td width="25">编号</td>
        <td width="25">回复</td>
        <td width="500">标题</td>
        <td width="110">作者</td>
        <td width="145">最后回复时间</td>
      </tr>
      <s:iterator value="#list" var="topic" >
        <!-- 显示主题列表 -->
        <tr class="data">
          <td class="num"><s:property  value="tid" /> </td>
          <td class="num"><s:property  value="replySet.size" /></td>
          <s:url action="TopicAction_replyList" var="aURL" >
            <s:param name="topic.tid" value="tid"/>
          </s:url>
          <td><s:a href="%{aURL}"><s:property value="title" /></s:a></td>
          <td class="info"><s:property  value="ipAddr" /></td>
          <td class="info"><s:date name="createDate" format="yyyy-MM-dd hh:mm:ss" /></td>
        </tr>
      </s:iterator>
      <tr>
        <td colspan="5" class="num">共有主题数<font color="red"><s:property value="#list.size" /> </font>个</td>
      </tr>
      </tbody>
    </table>

   <div style="margin-bottom: 15px"></div>
   <!--发表主题表单-->
    <s:form action="TopicAction_add" namespace="/" theme="simple">
  <%--<form action="" class="addNewTopicForm">--%>
      <table class="publishArticleForm">
        <tr>
          <td>标　题:</td>
          <td>
            <s:textfield name="topic.title" cssClass="title"/>
          </td>
        </tr>
        <tr>
          <td>内　容:</td>
          <td>
            <s:textarea name="topic.topicContext" cssClass="content"/>
          </td>
        </tr>
        <tr>
          <td></td>
          <td><input type="submit" value="发　表" /></td>
        </tr>
      </table>
    </s:form>
  </body>
</html>
