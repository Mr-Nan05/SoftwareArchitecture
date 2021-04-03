# README

### 数据库配置

数据库类型：本地数据库mysql

配置信息如下：

```properties
server.port=8080
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/db_example
spring.datasource.username=spring
spring.datasource.password=19990505

spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html
spring.thymeleaf.mode=HTML5
spring.thymeleaf.encoding=UTF-8
spring.thymeleaf.servlet.content-type=text/html
spring.thymeleaf.cache=false
```

### 系统操作简介

##### 一般操作

启动系统后浏览器输入localhost:8080/manager/进入导航页，根据首页html页面的导航进行操作

由于json格式展示已经很清楚，故没有设置html页面

##### postman操作

添加学生信息：可使用postman向localhost:8080/manager/add发送post请求，参数请求体为form-data形式

更新学生信息：路由：manager/update，参数同add操作

查询学生信息：除使用id查询外，在service中添加使用name查询方法

删除学生信息：/delete，使用学生学号（id）删除

另：manager/students可展示全部学生信息