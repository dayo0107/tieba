# 简易tieba

## 项目介绍

  一个简单的模拟贴吧，只有两个页面，主页和帖子详情。       
## 功能介绍

1.发布帖子

    添加帖子信息，标题、内容、发帖时间、发帖人ip地址；
    

2.搜索帖子

    按发帖时间先后排列
    
        无输入则搜索全部并
    
        有输入则模糊查询
3.查看帖子
    
    显示帖子信息和所有回帖
 
 4.回帖
    
    添加回帖信息，回帖内容、回帖时间、回帖人ip地址   
    
## 数据库
1.使用hibernate默认连接池

2.表 
    
    t_topic(帖子信息)  t_reply（回帖信息）  一对多关系
    
## 框架
 Struts2 + hibernate3
## 搭建环境
  IntelliJ IDEA2018.1.4/ mysql8 /tomcat9 /jdk10    
## 项目功能截图
<img src="https://github.com/dayo0107/tieba/blob/master/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20180824132519.png" >
<img src="https://github.com/dayo0107/tieba/blob/master/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20180824132531.png" >
