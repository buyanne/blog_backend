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

Vue 项目基于 @vue/cli4.x 构建

JS 依赖及参考的 css：[axios](https://github.com/axios/axios)、[moment](https://github.com/moment/moment)、[nprogress](https://github.com/rstacruz/nprogress)、[v-viewer](https://github.com/fengyuanchen/viewerjs)、[prismjs](https://github.com/PrismJS/prism)、[APlayer](https://github.com/DIYgod/APlayer)、[MetingJS](https://github.com/metowolf/MetingJS)、[lodash](https://github.com/lodash/lodash)、[mavonEditor](https://github.com/hinesboy/mavonEditor)、[echarts](https://github.com/apache/echarts)、[tocbot](https://github.com/tscanlin/tocbot)、[iCSS](https://github.com/chokcoco/iCSS)



### 后台 UI

[Element UI](https://github.com/ElemeFE/element)：后台 CMS 部分完全基于 Element UI 开发



### 前台 UI

[Semantic UI](https://semantic-ui.com/)：主要使用，页面布局样式，语义化的 css，该框架 Vue 版的开发完成度不高，见 [Semantic UI Vue](https://semantic-ui-vue.github.io/#/)

[Element UI](https://github.com/ElemeFE/element)：部分使用，一些小组件，弥补了 Semantic UI 的不足，便于快速实现效果

文章排版：基于 [typo.css](https://github.com/sofish/typo.css) 修改



## 快速开始

1. 创建 MySQL 数据库`blog`，并运行`blog.sql`初始化表数据
2. 修改配置信息`blog-api/src/main/resources/application.yml`
3. 安装 Redis 并启动
4. 启动后端SpringBoot服务
5. 分别在`blog-ms`和`blog-view`目录下执行`npm install`安装依赖
6. 分别在`blog-ms`和`blog-view`目录下执行`npm run serve`启动前后台页面



## 注意事项

- 本人使用的 MySQL 版本为5.5.61
- 数据库中默认用户名密码为`admin`，`admin`，因为是个人博客，没打算做修改密码的页面，可在`util.HashUtils`下的`main`方法手动生成密码存入数据库
- 注意修改`application-dev.yml`的配置信息
  - Redis 若没有密码，留空即可
  - 注意修改`token.secretKey`，否则无法保证 token 安全性
