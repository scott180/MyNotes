## note
*   [1、日常](#note)
*   [2、工作](#wrok)

 <h2 id="note"></h2>

### 1、日常

#### 1.1、修改文件的默认打开方式

```
修改文件的默认打开方式：

1.选择默认方式
右击--打开方式--选择默认程序

2.注册表设置
在运行里面输入regedit（注册表编辑器），HEY_CLASS_ROOT下面是所有文件的后缀名文件，找到你想取消关联的后缀名，如.ppt，单击这个文件夹，右边出现的“数据”一项，双击“（默认）”，打开对话框，将“数据”下面可以填写的部分清除，保持空白，确定。你的电脑里面所有.ppt文件就没有了任何关联和默认程序，再按自己的想法重新关联或默认就行了。
还有，要看你修改的是什么程序的默认打开方式，不一样的程序填写的数据不一样。
如果用这个办法还不行就应该不单是这个软件的问题了，可能是系统其他设置的问题。 

3.控制面板设置
控制面板-----程序----默认程序----始终使用指定的程序打开此文件类型

```


#### 1.2、红米笔记本
```

红米笔记本触摸板失灵
- 按F12 


redmibook的FN键没有作用,F1～F12功能键直接按就是调节音.
- Fn+ESC锁定

```


#### 1.3、win7无线网络连接不上

```

win7无线网络连接不上（未连接-连接可用）常用解决方法。
  开始 --控制面板（查看方式-小图标）--管理工具 --服务
WLAN AutoConfig 启动此服务且启动类型改为自动

```


#### 1.4、身高体重比例

```

标准体重是反映和衡量一个人健康状况的重要标志之一。过胖和过瘦都不利于健康，也不会给人以健美感。不同体型的大量统计材料表明，反映正常体重较理想和简单的指标，可用身高体重的关系来表示。

一、世卫计算方法
男性：(身高cm－80)×70﹪=标准体重 女性：(身高cm－70)×60﹪=标准体重
标准体重正负10﹪为正常体重
标准体重正负10﹪~ 20﹪为体重过重或过轻
标准体重正负20﹪以上为肥胖或体重不足
超重计算公式
超重%=[（实际体重－理想体重）/（理想体重）]×100%
如：（170-80）* 70%=63kg

二、BMI 法
体重指数 BMI = 体重（公斤） / 身高（米）的平方即 kg/m2
算式写法： BMI = 体重 / （身高）^2
正常体重 ： 体重指数 = 18.5 - 25 （中国体质标准:正常范围 18.5~23.9，超重24.0~27.9，肥胖≥28.0）
超重 ： 体重指数 = 25 - 30
轻度肥胖 ： 体重指数 > 30
中度肥胖 ： 体重指数 > 35
重度肥胖 ：体重指数 > 40
如：67/1.7/1.7=23.18


三、简单方法
标准体重=身高(m)×身高(m)×标准系数（女性20，男性22）
标准体重正负10﹪为正常体重
标准体重正负10﹪~ 20﹪为体重偏重或偏轻
标准体重正负20﹪以上为肥胖或体重不足
如： 1.7*1.7*22=63.58kg

四、简单方法：
标准体重（kg）=身高（cm）-105
例如，一个身高170厘米的男子，他的标准体重应该是：170（厘米）－105=65（公斤）。凡是超过标准体重10%者为偏重，超过20%以上者为肥胖；低于标准体重10%者为偏瘦，低于20%以上者为消瘦。
如： 170-105=65kg
 
注意：上述计算方法只适用于成年人。 对儿童，老年人，或者身高过于矮小的人士并不适用。


```

#### 1.5、眼睛心理学

```

眼睛心理学

眼睛往左看代表：回忆 ；往右看代表：动用情感来创造词汇。

关于眼睛的心理bai学：

1. 如果对方眼球处于左上方，表示正在进行视觉回想，也就是回忆。

2. 如果对方眼球处于左下方，表示正在思考，正在与自己对话。

3. 如果对方眼球处于右上方，表示正在创建视觉想象，也就是在脑海中创建一些现实中没有的事物。

4. 如果对方眼球处于右下方，表示ta正在感受自己的身体，感受情感的触动。

5. 如果对方眼球向一侧看，同时脑袋微微向一侧倾斜，对方看上去像是在认真聆听，这个举动与声音有关，可能是在交谈中回忆起了某个声音，这时眼球也会处于中间位置。

6. 如果对方眼球向左右平视，表示ta正在试图弄懂别人的意思。

7. 如果对方眼球迅速地左右运动，表示ta正在忙碌地思考，也有可能是感受到了压力或者心怀戒备

```

 <h2 id="work"></h2>

 ### 2、工作

*************************


####  2.1、高德天气api

- 高德天气 &ensp; [api]( https://lbs.amap.com/api/webservice/guide/api/weatherinfo ) &ensp;  
- 杭州天气 &ensp; [实时]( https://restapi.amap.com/v3/weather/weatherInfo?key=0481b33d14e9830d8903940cdab327e5&city=330100 ) &ensp; [预报]( https://restapi.amap.com/v3/weather/weatherInfo?key=0481b33d14e9830d8903940cdab327e5&city=330100&extensions=all ) &ensp;  
- 安徽无为天气 &ensp; [实时](https://restapi.amap.com/v3/weather/weatherInfo?key=0481b33d14e9830d8903940cdab327e5&city=340281) &ensp; [预报](https://restapi.amap.com/v3/weather/weatherInfo?key=0481b33d14e9830d8903940cdab327e5&city=340281&extensions=all ) &ensp;  

*************************

#### 2.2、mysql logbin日志 

```mysql
https://blog.csdn.net/xu180/article/details/107694417

show binary logs;
show master status;

show binlog events in 'mysql-bin.000090' from 242985028 limit 0,1000

```

--------------------

#### 2.3、端点已使用

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

#### 2.4、druid 安全配置

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

#### 2.5、github登录不上解决办法

```vb
参考 https://blog.csdn.net/ych9527/article/details/114372201

1、查询github域名
搜索DNS查询 http://tool.chinaz.com/dns/?type=1&host=github.com&ip=.   得到IP

2、修改系统hosts文件
在 C:\Windows\System32\drivers\etc\hosts 加上如下文本
13.229.188.59 github.com

```

*************************

#### 2.6、java常用集合方法


```java
lambda表达式

List<Integer> interceptProductIdList = interceptGoodsNumDAOS.stream().map(dao -> dao.getProductId()).distinct().collect(Collectors.toList());

List<DeliveryPackageDO> mainPackageDOList = packageDOS.stream().filter(dao -> dao.getTitle().equals(DriverPackageUtil.MAIN_PACKAGE_TEXT)).collect(Collectors.toList());

detailDAOS.stream().mapToInt(DeliveryPackageGoodsDetailDAO::getNum).sum()
	
purchaserAmountMap.values().stream().map(SupplierBillDetailVO::getAmount).reduce(BigDecimal::add).get();

LinkedHashMap<String, List<DeliveryOrderShopDAO>> addrMap = deliveryOrderShopDAOS.stream().collect(Collectors.groupingBy(DeliveryOrderShopDAO::getAddr_hash, LinkedHashMap::new, Collectors.toList()));

Map<String, List<DeliveryGoodsDO>> deliveryGoodsMap = deliveryGoodsDOS.stream().collect(Collectors.groupingBy(item -> item.getVirtualgoodsId() + "_" + item.getTitle() + "_" + item.getSpec()));

 Map<Integer, Integer> goods2ProductParam = logisticsGoodsDAOS.stream().filter(dao -> goodsIdParamList.contains(dao.getGoodsId())).
                    collect(Collectors.toMap(LogisticsGoodsDAO::getGoodsId, LogisticsGoodsDAO::getProductId, (key1, key2) -> key2));

Map<String, DeliveryDO> deliveryOrderMap = deliveryDOS.stream().collect(Collectors.toMap(DeliveryDO::getDeliveryOrder, (p) -> p));

```

```

java中Map遍历的四种方式
https://www.cnblogs.com/damoblog/p/9124937.html

Map <String,String>map = new HashMap<String,String>();
map.put("熊大", "棕色");
map.put("熊二", "黄色");


for(Map.Entry<String, String> entry : map.entrySet()){
    String mapKey = entry.getKey();
    String mapValue = entry.getValue();
    System.out.println(mapKey+":"+mapValue);
}


//key
for(String key : map.keySet()){
    System.out.println(key);
}
//value
for(String value : map.values()){
    System.out.println(value);
}


Iterator<Entry<String, String>> entries = map.entrySet().iterator();
while(entries.hasNext()){
    Entry<String, String> entry = entries.next();
    String key = entry.getKey();
    String value = entry.getValue();
    System.out.println(key+":"+value);
}


for(String key : map.keySet()){
    String value = map.get(key);
    System.out.println(key+":"+value);
}


	
```