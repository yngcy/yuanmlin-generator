# 源码林 - 定制化代码生成项目

源码林是一个基于 React、Spring Boot 和 Picocli 的在线代码生成器使用和制作平台，支持用户在线搜索、制作、使用和分享各类代码生成器。它致力于解决重复性编码、效率低下的问题，满足实际开发的定制化需求，帮助开发者提高定制化开发效率。

## 解决的问题

1. 重复性编码：代码生成器能够自动生成常见、重复性的代码片段，解决开发者在编写重复代码上的时间和精力浪费。
2. 定制化需求：现有的代码生成器往往不能满足实际开发的定制化需求，如需在每个类上增加特定的注解和注释。源码林提供工具帮助开发者快速定制属于自己的代码生成器，满足个性化需求。
3. 团队协作：在团队开发中，需要频繁变化和持续更新维护生成的代码。源码林支持在线编辑和共享生成器，有利于团队协作共建，提高开发效率和代码质量。

## 实际应用

源码林适用于多种实际应用场景，例如：

1. 算法题目开发：为经常做算法题目的同学提供一套 Java-ACM 代码输入模板，支持多种不同输入模式。
2. 项目初始化：为新项目开发的同学提供初始化项目模板的代码，如一键生成 Controller 层代码、整合 Redis 和 MySQL 依赖等。
3. 项目换皮工具：制作项目“换皮”工具，支持一键给网络热门项目换皮，如替换项目的名称、Logo 等。

## 技术选型

### 前端

- React：使用 React 开发框架和 Ant Design 组件库构建用户界面。
- Open API：提供 Open API 代码生成工具，方便生成 API 文档和客户端 SDK。
- 复杂嵌套表单：支持复杂嵌套表单的设计和验证，满足用户数据输入需求。
- 前端工程化：采用 EsLint、Prettier 和 Typescript 进行前端项目工程化管理，提升代码质量和可维护性。

### 后端

- Java Spring Boot：使用 Java Spring Boot 构建后端应用程序，提供稳定可靠的 API 接口。
- MySQL 和 MyBatis Plus：使用 MySQL 作为数据库存储，结合 MyBatis Plus 简化数据库操作和对象映射。
- Picocli：利用 Picocli 框架开发命令行应用，方便用户使用和操作生成器。
- FreeMarker 模板引擎：采用 FreeMarker 模板引擎动态生成代码，满足用户自定义模板的需求。
- Caffeine 和 Redis：使用 Caffeine 和 Redis 提供多级缓存机制，提高系统性能和响应速度。
- 分布式任务调度系统：采用分布式任务调度系统实现后台任务的调度和管理。
- 设计模式和核心思想：采用多种设计模式和系统设计的核心思想（如单一职责原则、开放封闭原则等）来构建健壮、可维护的后端系统。
- 对象存储：利用对象存储服务存储生成的代码和其他文件数据。
- Vert.x：采用 Vert.x 响应式编程框架提高系统的响应性能和并发处理能力。