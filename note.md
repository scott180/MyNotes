## note
*   [1、笔记](#note)
*   [2、资料](#document)

 <h2 id="note"></h2>

 ### 1、笔记

*************************

####  1.1、高德天气api

- 高德天气 &ensp; [api]( https://lbs.amap.com/api/webservice/guide/api/weatherinfo ) &ensp;  
- 杭州天气 &ensp; [实时]( https://restapi.amap.com/v3/weather/weatherInfo?key=0481b33d14e9830d8903940cdab327e5&city=330100 ) &ensp; [预报]( https://restapi.amap.com/v3/weather/weatherInfo?key=0481b33d14e9830d8903940cdab327e5&city=330100&extensions=all ) &ensp;  
- 安徽无为天气 &ensp; [实时](https://restapi.amap.com/v3/weather/weatherInfo?key=0481b33d14e9830d8903940cdab327e5&city=340281) &ensp; [预报](https://restapi.amap.com/v3/weather/weatherInfo?key=0481b33d14e9830d8903940cdab327e5&city=340281&extensions=all ) &ensp;  

*************************

#### 1.2、mysql logbin日志 

```mysql
https://blog.csdn.net/xu180/article/details/107694417

show binary logs;
show master status;

show binlog events in 'mysql-bin.000090' from 242985028 limit 0,1000

```

--------------------

#### 1.3、端点已使用

```sql
C:\Users\Administrator>netstat -ano|findstr "8080"
  TCP    0.0.0.0:8080           0.0.0.0:0              LISTENING       11492
  TCP    [::]:8080              [::]:0                 LISTENING       11492

C:\Users\Administrator>tasklist|findstr "11492"
javaw.exe                    11492 Console                    1    405,916 K

C:\Users\Administrator>taskkill /f /t /im 11492
成功: 已终止 PID 11492 (属于 PID 2596 子进程)的进程。

```

*************************

#### 1.4、druid 安全配置

```vb

为Druid增加权限验证措施，建议参考 https://github.com/alibaba/druid/wiki/%E9%85%8D%E7%BD%AE_StatViewServlet%E9%85%8D%E7%BD%AE
https://blog.csdn.net/my_ha_ha/article/details/86212492

http://localhost:8080/druid/datasource.json
http://localhost:8080/druid/sql.html


#Druid配置信息
    druid:
      #初始化时建立物理连接的个数。
      initial-size: 5
      #最大连接池数量
      max-active: 20
      #获取连接时最大等待时间，单位毫秒
      max-wait: 3000
      #最小连接池数量
      min-idle: 5
      #配置检测可以关闭的空闲连接间隔时间
      time-between-eviction-runs-millis: 60000
        # 配置DruidStatViewServlet
      stat-view-servlet:
          # 登录名
          login-username: hname
          # 登录密码
          login-password: pwd2020

```


*************************

#### 1.5、github登录不上解决办法

```vb
参考 https://blog.csdn.net/ych9527/article/details/114372201

1、查询github域名
搜索DNS查询 http://tool.chinaz.com/dns/?type=1&host=github.com&ip=.   得到IP

2、修改系统hosts文件
在 C:\Windows\System32\drivers\etc\hosts 加上如下文本
13.229.188.59 github.com

```
