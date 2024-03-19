# Tracking Tools


## introduction

Receptionists have to accomplish various tasks throughout the day when operating a hotel. One of those
tasks is to accept parcels for guests.
• It happens, that receptionists accept parcels for guests, that was already checked out of the
hotel.
• It happens from time to time, that guests forget to pick up their parcels before check-out and
even forget it then

1. The receptionist needs a tracking tool that knows to any given time which guests are checked
into the hotel and have not checked out, to allow the receptionist to decide whether to accept the parcel
or not.
2. The tracking tool should further allow the receptionist to check for parcels available for pick-up
when the guest is checking out.

### code structure

``` lua
TrackingTool
├── controller -- Controller is a component of the web layer responsible for processing HTTP requests and generating HTTP responses. It usually maps to one or more URL paths and calls the corresponding processing methods based on the requests on these paths.
├── mapper -- Mapper is a component of the data access layer, typically used in conjunction with the MyBatis framework, responsible for executing SQL statements and interacting with the database
├── service -- Service is a component of the business logic layer responsible for handling the core business logic of an application. It usually does not contain any code that interacts with the UI, but focuses on implementing business rules and data processing.
├── entity -- Entity class is a class that corresponds one-to-one to the fields in the database. It represents a record in the database, whose properties correspond to the fields in the database table.
├── utils -- common tools
├── VO -- VO is an object used in the page display layer, mainly used to encapsulate the data that needs to be displayed to the front-end. It encapsulates relevant data fields into an object based on the requirements of the front-end page, making it convenient for the front-end to display and process them
└── test -- test code
```

### skills

#### backend skills

| tech                 | comments                | website                                          |
| -------------------- | ------------------- | ---------------------------------------------- |
| SpringBoot           | Web framework     | https://spring.io/projects/spring-boot         |
| MyBatis              | ORM frame work             | http://www.mybatis.org/mybatis-3/zh/index.html |

| Redis                | cache datebase         | https://redis.io/                              |
| MongoDB              | NoSql         | https://www.mongodb.com                        |
| Mysql              | MySql         |                        |
| Druid                | database connect pool       | https://github.com/alibaba/druid               |
| Lombok               | Java tool      | https://github.com/rzwitserloot/lombok         |
| PageHelper           | MyBatis tools | http://git.oschina.net/free/Mybatis_PageHelper |
| Swagger-UI           | API document     | https://github.com/swagger-api/swagger-ui      |
| Hibernator-Validator | validation tool           | http://hibernate.org/validator                 |



#### system design drawing

##### system design





#### module intradoction

##### backend system `TrackingTool`






## enviroment deployment

### development tools

| tools          | comments                | website                                         |
| ------------- | ------------------- | ----------------------------------------------- |
| IDEA          | 开发IDE             | https://www.jetbrains.com/idea/download         |
| RedisDesktop  | redis客户端连接工具 | https://github.com/qishibo/AnotherRedisDesktopManager  |
| Robomongo     | mongo客户端连接工具 | https://robomongo.org/download                  |
| Navicat       | 数据库连接工具      | http://www.formysql.com/xiazai.html             |
| PowerDesigner | 数据库设计工具      | http://powerdesigner.de/                        |
| MindMaster    | 思维导图设计工具    | http://www.edrawsoft.cn/mindmaster              |
| ProcessOn     | 流程图绘制工具      | https://www.processon.com/                      |
| Snipaste      | 屏幕截图工具        | https://www.snipaste.com/                       |
| Postman       | API接口调试工具      | https://www.postman.com/                        |
| Typora        | Markdown编辑器      | https://typora.io/                              |

### development ENV

| Tools          | version | download                                                        |
| ------------- | ------ | ------------------------------------------------------------ |
| JDK           | 1.8    | https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html |
| Mysql         | 5.7    | https://www.mysql.com/                                       |
| Redis         | 7.0    | https://redis.io/download                                    |
| MongoDB       | 5.0    | https://www.mongodb.com/download-center                      |

### delop steps

> Windows ENV deployment

java -jar command to deploy,








Copyright (c) 2024 Franco GUo
