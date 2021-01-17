# bigdata-openapi

## 项目说明
    数据接口，通过配置方式提供对应的API
    
## 配置方式

  * 数据源配置表：TB_DATAAPI_CONFIGURATION

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://xxx:3306/xxx"/>
                <property name="username" value="xxx"/>
                <property name="password" value="xxx"/>
                <property name="poolMaximumActiveConnections" value="3"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <mapper url="file:///%s"/>
    </mappers>
</configuration>
```

  * 数据映射配置：TB_DATAAPI_MAPPER

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.mfexcel.bigdata.openapi.mapper.BaseMapper">
    <select id="execute" parameterType="Map" resultType="Map">
        SELECT *
        FROM TB_DATAAPI_CONFIGURATION
    </select>
</mapper>
```

## 调用说明
  * post 方式
  * body 参数为 JSON 格式
