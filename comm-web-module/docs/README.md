
#### 项目介绍
Springboot + shiro权限管理。<br/>
基于Spring Boot、Shiro、MyBatis、Redis、thymeleaf等框架，
前端使用adminlte模板，图表展示使用echart.js。<br/>

    音乐播放器参考：[music.nbclass.com](http://music.nbclass.com)

#### 使用说明

1. 使用IDE导入本项目
2. 新建数据库`CREATE DATABASE;`
3. 导入数据库`docs/db/sonar-createTable.sql`，添加表数据`docs/db/sonar-data.sql`
4. 修改(`resources/application.yml`)配置文件
   1. 数据库链接属性(可搜索`datasource`或定位到L.15) 
   2. redis配置(可搜索`redis`或定位到L.28)
5. 运行项目(三种方式)
   1. 项目根目录下执行`mvn -X clean package -Dmaven.test.skip=true`编译打包，然后执行`java -jar aiasp-svn-tools.jar`
   2. 项目根目录下执行`mvn springboot:run`
   3. 直接运行`ShiroBootApplication.java`
6. 浏览器访问`http://localhost:8081`

**用户密码**

_演示账号_： 账号：admin 密码：123456<br/>



