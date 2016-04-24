基于S2SH的练习项目
1.开发环境
  MyEclipse8.5
  Tomcat 6.0.35
  Mysql 5.1.10
  hibernate3.5.6
  jstl
  junit4.4
  kindeditor
  slf4j
  spring2.5.5
  struts2.1.8
2.主要功能：
  系统管理
    部门管理
    用户管理
    权限操作
  网上交流
    论坛管理
    论坛
  审批流转
    审批流程管理
    申请模板管理 
    起草申请
    待我审批
    我的申请查询
 3.在config文件夹中存放着项目的所有配置文件
    其中在/config/hibernate/jdbc.properties中修改数据库连接信息
    /config/log4j.properties 中可配置日志输出信息
    本项目spring采用注解的方式
    /config/spring/applicationContext-db.xml 包含数据库连接和sessionFactory
    /config/spring/applicationContext.xml包含事物的处理方式
