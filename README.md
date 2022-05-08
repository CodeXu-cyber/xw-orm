目录结构
system--|

        BaseExecutor--基础的执行器

        Configuration--配置类，包含MappedStatement

        Executor--执行器接口

        SimpleCatch--LRU缓存

        MappedStatement--对应xml中的节点，其中包含方法的全限定名、sql、参数类型等

        XSqlSession--sqlsession工厂，实现接口的实例化及方法的暴露

utils--|

        UnderlineAndHumpUtil--驼峰与下划线互转

        XmlUtil--使用dom4j解析xml
