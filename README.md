- 仿照mybatis写一个简单的支持缓存的ORM框架
- 目录结构
```
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       ├── entity
    │   │       │   └── User.java   测试实体类
    │   │       ├── mapper
    │   │       │   └── UserMapper.java   测试Mapper层接口
    │   │       └── system
    │   │           ├── Configuration.java   配置类，包含MappedStatement
    │   │           ├── MappedStatement.java   对应xml中的节点，其中包含方法的全限定名、sql、参数类型等
    │   │           ├── SimpleCatch.java   缓存，使用LRU算法实现，可定义初始化大小
    │   │           ├── XSqlSession.java   Sqlsession工厂，实现接口的实例化及方法的暴露
    │   │           ├── executor
    │   │           │   ├── BaseExecutor.java   基础执行器实现类
    │   │           │   └── Executor.java   执行器接口
    │   │           └── utils
    │   │               ├── UnderlineAndHumpUtil.java   驼峰与下划线互转
    │   │               └── XmlUtil.java   使用dom4j解析xml
    │   └── resources
    │       ├── mapper
    │       │   └── UserMapper.xml   测试Mapper
    │       └── xuwei-mybatis.xml   配置文件
    └── test
        └── java
            └── XWTest.java
```