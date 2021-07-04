# README

使用docker容器启动多个程序时，本地数据库ip不可使用localhost，故此处修改为本机的一个ip，mysql及redis配置信息如下

```properties
server.port=9090
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://172.21.0.1:3306/db_example
spring.datasource.username=spring
spring.datasource.password=19990505

spring.cache.type=redis
spring.cache.host=localhost
spring.cache.port=6379
```

ps:启动本程序前请启动redis，若图片无法直接显示，请单独打开图片查看

#### 无缓存水平扩展

使用gatling做压力测试，模拟100个用户访问

1个廉价机器的运行情况如下，平均耗时2.2s

![image-20210325194130425](image-20210325194130425.png)

4个廉价机器做水平扩展运行情况如下，平均耗时1s

![image-20210325194053396](image-20210325194053396.png)

#### 设置4个docker容器程序过程如下

![image-20210325194438882](image-20210325194438882.png)

#### Redis缓存测试

使用localhost:18080/manager/students第一次访问，耗时1248ms

![image-20210325211831834](image-20210325211831834.png)

以后每次访问所有学生信息耗时只有5ms左右

![image-20210325211945660](image-20210325211945660.png)

#### 有Redis缓存Gatling压力测试

模拟100个用户无缓存情况，平均耗时600ms

![image-20210325220609854](image-20210325220609854.png)

模拟100个用户有缓存情况，平均耗时344ms

![image-20210325220107062](image-20210325220107062.png)

同时开启两个程序使用同一个redis服务做缓存时二者的缓存如下

![image-20210326005324545](image-20210326005324545.png)

二者访问信息如下

![image-20210326005358222](image-20210326005358222.png)

![image-20210326005409935](image-20210326005409935.png)