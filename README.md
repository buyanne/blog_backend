<p align="center">
	<a href="" target="_blank">
		<img src="https://cdn.jsdelivr.net/gh/buyanne/JsDelivr/static/blog/favicon-gif.gif" alt="Blog · Logo" style="width: 200px; height: 200px">
	</a>
</p>
<p align="center">
	<img src="https://img.shields.io/badge/JDK-1.8+-orange">
	<img src="https://img.shields.io/badge/SpringBoot-2.2.7.RELEASE-brightgreen">
	<img src="https://img.shields.io/badge/MyBatis-3.5.5-red">
	<img src="https://img.shields.io/badge/Vue-2.6.11-brightgreen">
    <img src="https://img.shields.io/badge/Redis-3.2.100-brightgreen">
	<img src="https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2Frawchen%2FBlog&count_bg=%2379C83D&title_bg=%23555555&icon=&icon_color=%23E7E7E7&title=hits&edge_flat=false">
</p>



## 简介

前后端分离Blog系统，基于 Spring Boot + Vue 前后端分离博客系统

## 后端

1. 核心框架：[Spring Boot](https://github.com/spring-projects/spring-boot)
2. Token 认证：[jjwt](https://github.com/jwtk/jjwt)
3. 持久层框架：[MyBatis](https://github.com/mybatis/spring-boot-starter)
4. 分页插件：[PageHelper](https://github.com/pagehelper/Mybatis-PageHelper)
5. NoSQL缓存：[Redis](https://github.com/redis/redis)
6. Markdown 转 HTML：[commonmark-java](https://github.com/commonmark/commonmark-java)

基于 JDK8 开发，8以上要添加依赖：

```xml
<dependency>
    <groupId>javax.xml.bind</groupId>
    <artifactId>jaxb-api</artifactId>
    <version>2.3.0</version>
</dependency>
```



## 前端

核心框架：Vue2.x、Vue Router、Vuex

Vue 项目基于 @vue/cli5.x 构建


### 后台 UI

[Element UI](https://github.com/ElemeFE/element)：后台 CMS 部分完全基于 Element UI 开发

### 前台 UI
[Element UI](https://github.com/ElemeFE/element)：部分使用
## 快速开始

1. 创建 MySQL 数据库`blog`，并运行`blog.sql`初始化表数据
2. 修改配置信息`blog-api/src/main/resources/application.yml`
3. 安装 Redis 并启动
4. 启动后端SpringBoot服务
5. 分别在`blog-ms`和`blog-view`目录下执行`npm install`安装依赖
6. 分别在`blog-ms`和`blog-view`目录下执行`npm run serve`启动前后台页面
