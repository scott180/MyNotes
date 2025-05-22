# note

<br />

[note]( https://scott180.github.io/reco-blog ) &ensp;  [gitlab]( https://gitlab.com/xuyq123/mynotes ) &ensp; [gitee]( https://gitee.com/xy180/MyNotes ) &ensp; [github]( https://github.com/scott180/MyNotes ) &ensp; [blog]( https://xuyq123.gitlab.io/mkdocs-blog )

<br />

## 1、日常

### 1.1、文件操作

#### 1.1.1、windows常用快捷键

```java
windows常用快捷键

Ctrl+C  复制
Ctrl+V  粘贴
Ctrl+S  保存
Ctrl+A  选中全部内容
Ctrl+X  剪切
Ctrl+F  查找与替换
        
Ctrl+W  关闭程序
Ctrl+Z  撤销刚才进行的操作
Ctrl+Y  恢复刚才进行的操作
Ctrl+N  新建一个空白文档
Ctrl+P  打开打印
Ctrl+O  打开文档

Ctrl+Shift	输入法切换
Ctrl+Home	光标快速移到文件头
Ctrl+End	光标快速移到文件尾

Ctrl+Shift+End	选中当前到末尾所有内容
Ctrl+Shift+Esc	打开任务管理器
Ctrl+Shift+Del	浏览器打开清除缓存对话框

Alt+Tab     程序切换-小图标
Win+Tab     程序切换-大图标

Win     显示开始菜单
Win+L   锁定计算机
Win+E   启动"我的电脑"
Win+D   快速显示桌面

Win+R		打开运行-输入命令开启相关功能
cmd			命令行控制台
reg			注册表
mstsc			远程登录
services.msc		本地服务
	
F2   文件改名
F5   浏览器页面刷新
F11  浏览器进入全屏状态
F12  浏览器打开调试

Shift+PgUp	向上选中内容
Shift+PgDn	向下选中内容

Shift+光标+右键	 选中内容

```

<br/>

#### 1.1.2、修改文件的默认打开方式

修改文件的默认打开方式： <br/>

**1.修改属性** <br/>
右击--属性--常规--打开方式--选择默认程序

**2.选择默认方式** <br/>
右击--打开方式--选择默认程序

**3.注册表设置** <br/>
Win+R 在运行里面输入regedit（注册表编辑器），`HEY_CLASS_ROOT`下面是所有文件的后缀名文件，找到你想取消关联的后缀名，如.ppt。 <br/>
单击这个文件夹，右边出现的“数据”一项，双击“（默认）”，打开对话框，将“数据”下面可以填写的部分清除，保持空白，确定。 <br/>

你的电脑里面所有.ppt文件就没有了任何关联和默认程序，再按自己的想法重新关联或默认就行了。 <br/>
还有，要看你修改的是什么程序的默认打开方式，不一样的程序填写的数据不一样。 <br/>
如果用这个办法还不行就应该不单是这个软件的问题了，可能是系统其他设置的问题。

**4.控制面板设置** <br/>
控制面板-----程序----默认程序----始终使用指定的程序打开此文件类型 <br/>

<br/>

#### 1.1.3、notepadd++小知识

```java
无扩展名文件默认打开程序设置Notepad++

在命令提示符cmd以管理员身份下输入
assoc .="No Extension"
ftype "No Extension"="D:\ProgramFiles\Notepadd++\Notepad++\notepad++.exe" "%1"

```

```
notepad++常用插件：Compare、JSTool、Json Viewer、MIME Tools
将dll文件放在如下目录，重启notepad即可
D:\ProgramFiles\Notepadd++\Notepad++\plugins

```

```
notepadd++  txt,md格式 文字高亮
设置 - 语言格式设置 - 自定义扩展名

```

```
notepad竖向选择
先把鼠标光标放在起始位置，然后同时按Alt+shift键或者只按Alt键就可以，然后移动鼠标选取内容。

```

<br/>

#### 1.1.4、markdown

```
markdown在线编辑
作业部落  https://www.zybuluo.com/mdeditor
马克飞象  https://maxiang.io/
菜鸟工具  http://c.runoob.com/front-end/712
Marked    https://marked.js.org/demo/
gitlab    https://gitlab.com/-/ide/project/gitlab-org/gitlab/edit/master/-/doc/user/markdown.md


markdown软件
typora	https://www.typora.io/
Dillinger https://dillinger.io/
https://blog.csdn.net/davidhzq/article/details/100815332

```

```
将markdown文件导出为带图片的PDF 
Ⅰ.使用Typora 打开 markdown文件
Ⅱ.点击 文件-导出-HTML
Ⅲ.浏览器打开文件-打印-另存为PDF


markdown转PDF文件分页
<div STYLE="page-break-after: always;"></div>


markdown空格符号
&ensp;
&emsp;

```

```java
markdown表格宽度设置

| git仓库 | 布署方法 | <span style="white-space:nowrap;">备注&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</span> |

```

```
gitlab、github、gitee布署mkdocs主题仓库
https://gitlab.com/xuyq123/mynotes

gitlab mkdocs主题仓库   
	https://gitlab.com/xuyq123/plain-mkdocs   
	https://xuyq123.gitlab.io/plain-mkdocs 

	https://gitlab.com/xuyq123/myblog-mkdocs   
	https://xuyq123.gitlab.io/myblog-mkdocs	
	
---	
	
git平台docsify布署markdown文件
https://github.com/scott180/MyNotes

gitlab docsify主题仓库 	
	https://gitlab.com/xuyq123/plain-docsify 
	https://xuyq123.gitlab.io/plain-docsify/
	
	https://gitlab.com/xuyq123/myblog-mkdocs
	https://xuyq123.gitlab.io/myblog-docsify/	
	
```

<br/>

#### 1.1.5、bat脚本

```
具有 .bat 文件扩展名的文件是 Windows 批处理文件。它是一个纯文本文件，包含用于重复任务或逐个运行脚本组的各种命令。
所有类型的软件都将 bat 文件用于各种目的，例如复制或删除文件、运行应用程序以及关闭进程。
下面是 bat 文件的另一个示例，该文件使用 ping 命令来查看计算机是否可以访问具有该特定 IP 地址的路由器：

ping 192.168.1.1
pause

```

```java
Win+R		打开运行-输入命令开启相关功能
cmd			命令行控制台


Windows批处理(cmd/bat)常用命令
https://www.cnblogs.com/hwrex/p/18663235
https://www.cnblogs.com/xpwi/p/9626959.html

cd 	显示当前目录名或改变当前目录
md 	创建目录
dir 显示目录中的文件和子目录列表

echo 		显示消息或开启/关闭回显
pause		暂停并等待用户按键
ipconfig	显示、修改TCP/IP设置

```

```bat
:: StartRedis.bat
echo "启动redis"
D: & cd D:\ProgramFiles\Redis-x64-3.2.100
redis-server.exe redis.windows.conf
```


```bat
echo "启动Ollama"
cd C:\Users\Administrator\AppData\Local\Programs\Ollama
Start ollama
```

<br/>


#### 1.1.6、部署网站


| 序号  | 平台    | 仓库地址    |  git静态页面   |  说明 |
| ----- | -----   | ----------- |  ------------- |  ---- |
| 1     | github  | [**reco-blog**]( https://github.com/scott180/reco-blog )  	      | [github.io/reco-blog]( https://scott180.github.io/reco-blog )         |  vuepress-reco部署网站 |
| 2     | github  | [**vuepress-blog**]( https://github.com/scott180/vuepress-blog )  | [github.io/vuepress-blog]( https://scott180.github.io/vuepress-blog ) |  vuepress部署网站      |
| 3     | github  | [blog]( https://github.com/scott180/blog )  					  | [github.io/blog]( https://scott180.github.io/blog )   				  |  vuepress部署网站      |
| 4     | github  | [tool]( https://github.com/scott180/tool )  	 				  | [github.io/tool]( https://scott180.github.io/tool )                   |  工具网站              |
| 5     | github  | [docsify-blog]( https://github.com/scott180/docsify-blog )  	  | [github.io/docsify]( https://scott180.github.io/docsify-blog/ )       |  docsify部署网站       |
| 6     | **github**  | [gitbook-blog]( https://github.com/scott180/gitbook-blog )    | [github.io/gitbook]( https://scott180.github.io/gitbook-blog )        |  gitbook部署网站 |
| 7     | gitlab      | [mkdocs-blog]( https://gitlab.com/xuyq123/mkdocs-blog ) | [gitlab.io/mkdocs]( https://xuyq123.gitlab.io/mkdocs-blog )                 | mkdocs部署网站  |
| 8     | gitlab      | [**MyNotes**]( https://gitlab.com/xuyq123/mynotes )     | [files]( https://gitlab.com/xuyq123/mynotes/-/blob/master/%E6%96%87%E6%A1%A3%E7%9B%AE%E5%BD%95.md )              |  **编程笔记** |
| 9     | gitcode     | [**document**]( https://gitcode.net/xu180/document )  	| [note]( https://gitcode.net/xu180/document/-/blob/master/article/%E9%9A%8F%E7%AC%94/%E6%97%A5%E5%B8%B8Note.md )  |  生活随笔     |
| 10    | npm         | [xushufa]( https://www.npmjs.com/~xushufa )             | [img]( https://cdn.jsdelivr.net/npm/xushufa-shu/yan/duo1-1000/0001大.jpg ) 	                                   |  资料管理     |
| 11    | bitbucket   | [**imgs**]( https://bitbucket.org/xu12345/document/src/master/imgs/ )    | [img]( https://bitbucket.org/xu12345/document/raw/87e65566e45e063244eab491abe2dab0f43de59d/imgs/shufa/%E7%8E%8B%E7%BE%B2%E4%B9%8B-%E5%85%B0%E4%BA%AD%E9%9B%86%E5%BA%8F.jpg )  | 图片仓库   |
| 12    | sourceforge | [xdocument]( https://sourceforge.net/p/xdocument/code/ci/master/tree/ )  | [readMe]( https://sourceforge.net/p/xdocument/code/ci/master/tree/README.md ) 	               |  图片仓库     |



<br/>

### 1.2、网络&笔记本

#### 1.2.1、远程登录

```js
远程登录
win+R   输入 mstsc
Administrator/123456

远程登录复制文件
本地资源 - 本地设备和资源 - 详细信息 - 驱动器

```

#### 1.2.2、红米笔记本问题

```
红米笔记本触摸板失灵
- 按F12 


redmibook的FN键没有作用,F1～F12功能键直接按就是调节音.
- Fn+ESC锁定

```

#### 1.2.3、无线网连不上 & 代理连接失败

```
win7无线网络连接不上（未连接-连接可用）常用解决方法。
  开始 --控制面板（查看方式-小图标）--管理工具 --服务
  WLAN AutoConfig 启动此服务且启动类型改为自动

```

代理连接失败 （-130 ERR_PROXY_CONNECTION_FAILED ）

**治本方法**：<br/>
控制面板 - 网络和Internet - Internet选项 - 连接 - 局域网设置 - 代理服务器 - 为LAN使用代理服务器[这些设置不用于拨号或VPN连接][X] <br/>
去掉勾选-确定

<br/>

**治根方法**：<br/>
参考 https://www.zhihu.com/question/25686082?sort=created

**方法1**：<br/>
网上能找到的方法都试过了，没解决。<br/>
最后忘了从哪找到的方法，把WinHttpAutoProxySvc 服务给禁用了，似乎是好了，几个小时了没有再出现问题。<br/>
忘了说了，我是用完fiddler之后出现的问题。

禁用需要编辑注册表：<br/>
`Computer\HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Services\WinHttpAutoProxySvc`<br/>
右边Start值改为4（禁止启动）。<br/>
然后重启电脑。


**方法2**：<br/>
进到这个目录下：`HKEY_CURRENT_USER/Software/Microsoft/Windows/CurrentVersion/Internet Settings/Connections`<br/>
通过目录找到Connections，把整个文件夹删除。<br/>
不放心的话可以把Connections改名。


进入服务：   控制面板 - 系统和安全 - 管理工具 - 服务<br/>
进入注册表： WIN+R - regedit

---

#### 1.2.4、关闭Chrome浏览器更新通知

如何关闭Chrome 浏览器提示“若要接收后续 google chrome 更新,您需使用 windows 10 或更高版本”

```
方法一：新建注册表文件
原文链接：https://www.ahaoyw.com/article/827.html

1、首先在桌面或者其他文件夹内新建一个记事本文件

2、打开新建的记事本文件，复制下面这段代码，粘贴其中，保存关闭

Windows Registry Editor Version 5.00

[HKEY_CURRENT_USER\Software\Policies\Google\Chrome]
"SuppressUnsupportedOSWarning"=dword:00000001

3、将记事本的名称改为 .reg 后缀（注意连 .txt 的后缀也得删除一并改掉），
例如closeChromeUpdate.reg （名字可以自定义但是后缀一定要.reg）然后双击运行该文件，点击是

4、系统弹出包含的项和值已经成功添加到注册表中，点击确定完成

5、最后重启Chrome浏览器

```

```
方法二：编辑注册表
原文链接：https://blog.csdn.net/haobiliuxiang/article/details/128232476

1. 打开“开始”，输入 regedit.exe，选择注册表编辑器。

2. 转到 HKEY_CURRENT_USER / Software / Policies / Google / Chrome。
如果其中一个键不存在，在前面的键上点击右键，选择新建 > 键。给它起个相应的名字。

3. 右键点击 Chrome，选择新建 > Dword（32 位）值。

4. 将其命名为 SuppressUnsupportedOSWarning。

5. 双击该名称并将其值设为 1。

6. 重新启动浏览器。

```


#### 1.2.5、shell批量推送git

> 批量推送git、压缩打包xushufa部署项目

```sh
#!/bin/bash
#sh push-ca.sh
#批量推送git
copyPush(){
	cp -r /e/Project/gitlab/calligraphy/*.md $data_dir
	cp -r /e/Project/gitlab/calligraphy/书法字帖 $data_dir
	cd $data_dir
	echo $PWD 'begin...'
	git add .
	git commit -m "fix"
	git push
	echo '.........end.........'
}

# *// calligraphy git 

#agit 1
data_dir=/e/Project/gitlab/agit/calligraphy
copyPush

#bitbucket 2
data_dir=/e/Project/gitlab/bitbucket/calligraphy
copyPush

#codeberg 3
data_dir=/e/Project/gitlab/codeberg/calligraphy
copyPush

#coding 4
data_dir=/e/Project/gitlab/coding/calligraphy
copyPush

#gitcode 5
data_dir=/e/Project/gitlab/gitcode/calligraphy
copyPush

#gitea 6
data_dir=/e/Project/gitlab/gitea/calligraphy
copyPush

#sourceforge 7  need password

#gitee 8
data_dir=/e/Project/gitee/calligraphy
copyPush

#github 9
data_dir=/e/Project/github/calligraphy
copyPush


```

```sh
#!/bin/bash
#sh zipProject.sh
#压缩xushufa布署项目。zip有时不能压缩隐藏文件，tar中文乱码。
zipProject(){
	# tar -zcvf /e/Project/github/xushufa-project/xushufa.tar.gz /e/Project/github/docsify-blog/
	# zip -r xu.zip /e/Project/github/docsify-blog/
	file_name=/e/Project/github/xushufa-project/$(date -d now +%Y%m%d_%H%M%S)_$project_type.$project_name.zip
	source_dir=/e/Project/$project_type
	cd $source_dir
	zip -r $file_name $project_name
	#zip -r $file_name $project_name/.[^.]*
	# -r表示目录所有文件。.[^.]*表示所有文件，包含隐藏文件。
	echo $file_name '...success...'
}


tarProject(){
	# tar -zcvf /e/Project/github/xushufa-project/xushufa.tar.gz /e/Project/github/docsify-blog/
	file_name=/e/Project/github/xushufa-project/$(date -d now +%Y%m%d_%H%M%S)_$project_type.$project_name.tar.gz
	source_dir=/e/Project/$project_type
	cd $source_dir
	tar -zcvf $file_name $project_name/
	echo $file_name '...success...'
}

#reco-blog 1
project_name=reco-blog
project_type=github
zipProject

#vuepress-blog 2
project_name=vuepress-blog
project_type=github
zipProject

#blog 3
project_name=blog
project_type=github
zipProject

#tool 4
project_name=tool
project_type=github
zipProject

#docsify-blog 5
project_name=docsify-blog
project_type=github
zipProject

#gitbook-blog 6
project_name=gitbook-blog
project_type=github
zipProject


#mkdocs-blog 7
project_name=mkdocs-blog
project_type=gitlab
zipProject




```

<br/>

#### 1.2.6、github访问不了，配置DNS与IP


问题：github网站访问不了，不能推送文件，不能获取项目						<br/>
方法：本机hosts文件配置DNS与IP                                              <br/>
步骤：                                                                      <br/>
1、工具网站DNS查询与IP归属地查询                                            <br/>
https://tool.chinaz.com/dns/www.github.com                                  <br/>
https://tool.lu/ip/index.html                                               <br/>
https://www.itdog.cn/dns/github.com                                         <br/>
                                                                            <br/>
输入github.com查到对应IP：                                                  <br/>
20.27.177.113                                                               <br/>
20.205.243.166                                                              <br/>
20.248.137.48                                                               <br/>
...                                                                         <br/>
 
2、本机hosts文件配置解析                                                    <br/>
在 `C:\Windows\System32\drivers\etc\hosts` 文件添加一行对应解析映射         <br/>
`20.27.177.113 github.com`                                                  <br/>
                                                                            <br/>
注意：**只需添加一行**，这个ip要是访问不了的话要删掉，换另一个。            <br/>
如果配置多行的话，域名可能会访问不能解析的ip，因此只配置一行能解析的ip即可。<br/>




---

### 1.3、杂学

#### 1.3.1、身高体重比例


标准体重是反映和衡量一个人健康状况的重要标志之一。过胖和过瘦都不利于健康，也不会给人以健美感。不同体型的大量统计材料表明，反映正常体重较理想和简单的指标，可用身高体重的关系来表示。

**一、世卫计算方法** <br/>
男性：(身高cm－80)×70﹪=标准体重 女性：(身高cm－70)×60﹪=标准体重 <br/>
标准体重正负10﹪为正常体重 <br/>
标准体重正负10﹪~ 20﹪为体重过重或过轻 <br/>
标准体重正负20﹪以上为肥胖或体重不足 <br/>
超重计算公式 <br/>
超重%=[（实际体重－理想体重）/（理想体重）]×100% <br/>
如：（170-80）* 70%=63kg

**二、BMI 法** <br/>
体重指数 BMI = 体重（公斤） / 身高（米）的平方即 kg/m2 <br/>
算式写法： BMI = 体重 / （身高）^2 <br/>
正常体重 ： 体重指数 = 18.5 - 25 （中国体质标准:正常范围 18.5~23.9，超重24.0~27.9，肥胖≥28.0） <br/>
超重 ： 体重指数 = 25 - 30 <br/>
轻度肥胖 ： 体重指数 > 30 <br/>
中度肥胖 ： 体重指数 > 35 <br/>
重度肥胖 ：体重指数 > 40 <br/>
如：67/1.7/1.7=23.18


**三、简单方法** <br/>
标准体重=身高(m)×身高(m)×标准系数（女性20，男性22） <br/>
标准体重正负10﹪为正常体重 <br/>
标准体重正负10﹪~ 20﹪为体重偏重或偏轻 <br/>
标准体重正负20﹪以上为肥胖或体重不足 <br/>
如： 1.7 * 1.7 * 22=63.58kg


**四、简单方法**： <br/>
标准体重（kg）=身高（cm）-105 <br/>
例如，一个身高170厘米的男子，他的标准体重应该是：170（厘米）－105=65（公斤）。凡是超过标准体重10%者为偏重，超过20%以上者为肥胖；低于标准体重10%者为偏瘦，低于20%以上者为消瘦。 <br/>
如： 170-105=65kg <br/>
 
注意：上述计算方法只适用于成年人。 对儿童，老年人，或者身高过于矮小的人士并不适用。

<br/>

#### 1.3.2、眼睛心理学

如果对方眼球处于**右上方**，表示正在创建视觉想象，也就是在脑海中创建一些现实中没有的事物。说明在撒谎，在想象。


眼睛心理学。眼睛往左看代表：回忆；往右看代表：动用情感来创造词汇。 <br/>
1、如果对方眼球处于左上方，表示正在进行视觉回想，也就是回忆。 <br/>
2、如果对方眼球处于左下方，表示正在思考，正在与自己对话。 <br/>

3、如果对方眼球处于右上方，表示正在创建视觉想象，也就是在脑海中创建一些现实中没有的事物。 <br/>
4、如果对方眼球处于右下方，表示ta正在感受自己的身体，感受情感的触动。 <br/>

5.、如果对方眼球向一侧看，同时脑袋微微向一侧倾斜，对方看上去像是在认真聆听，这个举动与声音有关，可能是在交谈中回忆起了某个声音，这时眼球也会处于中间位置。 <br/>
6、如果对方眼球向左右平视，表示ta正在试图弄懂别人的意思。 <br/>
7、如果对方眼球迅速地左右运动，表示ta正在忙碌地思考，也有可能是感受到了压力或者心怀戒备。

<br/>

#### 1.3.3、春联上联和下联怎么区分


在以往，我国春节贴的春联，大多是请村子里学问高的先生到家里来写，然后在先生的指导下贴上的。那过年春联上联和下联怎么区分如何贴？上联贴在左边还是右边？

上联下联的区分：

1、按字调平仄分。
对联比较讲究平仄，这是对联的特点。具体来说，上联的最后一个字一般是仄声，下联的最后一个字一般是平声，否则，读起来就会感到非常别扭。 <br/>
2、按左右方位分。
贴对联时应将上联贴在右边，下联贴在左边，左与右则以面对大门或壁柱来分。之所以这样张贴，是因为直行书写都是从右到左，所以念对联也是从右向左念。 <br/>
3、按时序先后分。
就是时间在前的为上联，时间在后的则为下联。如“门迎春夏秋冬福，户纳东西南北祥”。 <br/>

4、按语言习惯分。
比如“福如东海长流水，寿比南山不老松”。 <br/>
5、按因果关系分。
就是“因”为上联，“果”为下联。 <br/>
6、按场面范围分。
在时间、空间、具体事物上一般是从左到右、从大到小，比如“年年过年年年好，月月赏月月月圆”。 <br/>


最简办法，看最后一个字：**三四声为上联**，**一二声为下联**。位置：**面对门右上左下**。古人写字即右向左这是沿承下来的。

<br/>

#### 1.3.4、视频会员和电信流量兑换

```js
视频会员：腾讯视频、优酷、爱奇艺、芒果TV等视频网站会员积分兑换

微信支付-支付有优惠-兑换好礼
安徽掌上10000APP兑换币、积分
安徽电信公众号-个人中心-金币兑换
中国联通APP积分
电信营业厅 APP积分
微众银行APP积分
支付宝会员积分
云闪付APP签到金
--2021


招商银行 腾讯超V联名卡 腾讯权益六选一
平安悦享白金卡 百变好礼月月享
--2022


```

---


各位小伙伴，现在主要有以下几个方法正规免费获取流量：

1、安徽电信公众号--福利专区--个人中心--#签到有礼 。每日连续签到，使用金币兑换流量，一个月大概有4G多免费流量。活动到2023年12月31结束。

2、安徽电信公众号--福利专区--个人中心--#夏日送福利 （顶部动态活动）。每日签到，有几率获取流量、翼支付权益金、视频会员等等。活动到2023年8月31结束。

3、安徽电信公众号--福利专区--个人中心-#福利大放送 （顶部动态活动）。每月参与一次抽奖，有几率获取金币、流量、翼支付权益金、视频会员等等。活动到2023年12月31结束。

4、安徽电信掌上10000--福利中心--#玩酷大转盘。消耗兑换币、分享活动等方式获取抽奖机会，有几率获取金币、流量、翼支付权益金、视频会员等等。活动到2023年9月30结束。

--2023.08.01

<br/>

#### 1.3.5、天干地支

十天干指的是：甲、乙、丙、丁、戊、己、庚、辛、壬、癸。                                                 <br/>
十二地支指的是：子、丑、寅、卯、辰、巳、午、未、申、酉、戌、亥。                                       <br/>
十二地支与十二生肖对应:子鼠、丑牛、寅虎、卯兔、辰龙、巳蛇、午马、未羊、申猴、酉鸡、戌狗、亥猪。        <br/>


天干地支时间对照表

1、子时：夜半，又名子夜、中夜，十二时辰的第一个时辰。对应23时至01时。												 <br/>
2、丑时：鸡鸣，又名荒鸡，十二时辰的第二个时辰。对应01时至03时。                                                      <br/>
3、寅时：平旦，又称黎明、早晨、日旦等，是夜与日的交替之际。对应03时至05时。                                          <br/>
4、卯时：日出，又名日始、破晓、旭日等，指太阳刚刚露脸，冉冉初升的那段时间。对应05时至07时。                          <br/>
5、辰时：食时，又名早食等，古人“朝食”之时也就是吃早饭时间，对应07时至09时。                                          <br/>
6、巳时：隅中，又名日禺等，临近中午的时候称为隅中。对应09 时至11时。                                                 <br/>
7、午时：日中，又名日正、中午等，对应11时至13时。                                                                    <br/>
8、未时：日昳，又名日跌、日央等，太阳偏西为日跌。对应13时至15时。                                                    <br/>
9、申时：哺时，又名日铺、夕食等，对应15时至17时。                                                                    <br/>
10、酉时：日入，又名日落、日沉、傍晚，意为太阳落山的时候。对应17时至19时。                                           <br/>
11、戌时：黄昏，又名日夕、日暮、日晚等，此时太阳已经落山，天将黑未黑。天地昏黄，万物朦胧，故称黄昏。对应19时至21时。 <br/>
12、亥时：人定，又名定昏等，代表此时夜色已深，人们也已经停止活动，安歇睡眠了。人定也就是人静。对应21时至23时。       <br/>

<br/>

#### 1.3.6、二十四节气

节气歌  <br/>
春雨惊春清谷天，夏满芒夏暑相连。 <br/>
秋处露秋寒霜降，冬雪雪冬小大寒。 <br/>


| 春季  | 日 期	     |  夏季  | 日　期	     |  秋季 | 日　期	    | 冬季	| 日　期      | 
| ----- | ---------- |  ------| -----------  | ----- | ------------ | ----- | ----------- |
| 立春	| 2月3-5日	 |  立夏  | 5月5-7日	 |  立秋 | 8月7-9日	    | 立冬	| 11月7-8日   | 
| 雨水	| 2月18-20日 | 	小满  | 5月20-22日	 |  处暑 | 8月22-24日   | 小雪	| 11月22-23日 | 
| 惊蛰	| 3月5-7日	 |  芒种  | 6月5-7日	 |  白露 | 9月7-9日	    | 大雪	| 12月6-8日   | 
| 春分	| 3月20-22日 | 	夏至  | 6月21-22日	 |  秋分 | 9月22-24日	| 冬至	| 12月21-23日 | 
| 清明	| 4月4-6日	 |  小暑  | 7月6-8日	 |  寒露 | 10月8-9日	| 小寒	| 1月5-7日    | 
| 谷雨	| 4月19-21日 | 	大暑  | 7月22日-24日 | 	霜降 | 10月23-24日	| 大寒	| 1月20-21日  | 

<br/>

### 1.4、工作

#### 1.4.1、善事利器

```js
工欲善其事必先利其器

git ：gitlab、github、gitee、gitcode、coding、bitbucket
网盘：阿里云网盘、百度网盘、阿里云个人邮箱网盘、坚果云、天翼云、微云、wps云盘
社区：SegmentFault 思否、csdn、stackoverflow、博客园、稀土掘金、知乎、豆瓣、简书 
笔记：有道云笔记、作业部落、金山文档、语雀、腾讯文档、飞书、qq邮箱记事本、notion、flomo
搜索：谷歌、百度、头条、必应
工具：idea、notepadd++、navicat、postman、fiddler、typora、eclipse、vscode

```


#### 1.4.2、mysql logbin日志 

```
mysql开启log-bin日志.md  https://gitlab.com/xuyq123/mynotes

一 、logbin日志 记录新增、更新、删除的sql 
show binary logs;
show master status;
show binlog events in 'mysql-bin.000090' from 242985028 limit 0,1000


二、general_log 记录增删改查所有日志 
select * from mysql.general_log where argument like '%select%'   ORDER BY event_time DESC limit 50;

TRUNCATE table mysql.general_log

```


#### 1.4.3、端点已使用

```sh
C:\Users\Administrator>netstat -ano|findstr "8080"
  TCP    0.0.0.0:8080           0.0.0.0:0              LISTENING       11492
  TCP    [::]:8080              [::]:0                 LISTENING       11492

C:\Users\Administrator>tasklist|findstr "11492"
javaw.exe                    11492 Console                    1    405,916 K

C:\Users\Administrator>taskkill /f /t /im 11492
成功: 已终止 PID 11492 (属于 PID 2596 子进程)的进程。

```


#### 1.4.4、druid 安全配置

```
为Druid增加权限验证措施，建议参考 
https://github.com/alibaba/druid/wiki/%E9%85%8D%E7%BD%AE_StatViewServlet%E9%85%8D%E7%BD%AE
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

#### 1.4.5、小工具

| 序号   | 地址        |  备注          |
| -----  | ----------- |  ------------- |
| 1      | [json]( https://scott180.github.io/tool/json )                     | json 格式化工具             |
| 2      | [yaml解析]( https://scott180.github.io/tool/yaml-parse )           | yaml解析为json              |
| 3      | [Json2Excel]( https://scott180.github.io/tool/Json2Excel )         | Json转Excel文件             |
| 4      | [时间毫秒值转换]( https://scott180.github.io/tool/time-format )    | 时间毫秒值转换              |
|        | 解码编码                                                   |                             |
| 5      | [url解码]( https://scott180.github.io/tool/url-encode )            | url解码编码                 |
| 6      | [unicode解码]( https://scott180.github.io/tool/unicode-encode )    | unicode解码编码             |
| 7      | [文字转二维码]( https://scott180.github.io/tool/words-QRcode )     | 文字转二维码                |
| 8      | [二维码生成扫描识别]( https://scott180.github.io/tool/HtmlQRCode ) | 二维码生成扫描识别          |
|        | markdown                                                   |                             |
| 9      | [md2wx]( https://scott180.github.io/tool/md2wx/docs )              | 在线Markdown微信格式化工具            |
| 10     | [editormd]( https://scott180.github.io/tool/markdown-editormd )    | 开源的、可嵌入的 Markdown 在线编辑器  |
| 11     | [markthing]( https://scott180.github.io/tool/markdown-markthing )  | 一个MarkDown编辑器                    |
| 12     | [mpeditor]( https://scott180.github.io/tool/markdown-mpeditor )    | 专注于微信公众号的编辑阅读器          |
|        | 项目布署                                                   |                                       |
| 13     | [tool]( https://github.com/scott180/tool )                 | github仓库                            |
| 14     | [blog]( https://scott180.github.io/reco-blog )             | 个人网站                              |


*************************


#### 1.4.6、AI助手

| 序号   | 地址        |  备注          |
| -----  | ----------- |  ------------- |
| 1      | [文心一言]( https://yiyan.baidu.com/ )                     | 你的智能伙伴             |
| 2      | [通义千问]( https://tongyi.aliyun.com/qianwen/ )           | 一个不断进化的AI大模型   |
| 3      | [讯飞星火]( https://xinghuo.xfyun.cn/ )         			  |  认知大模型              |
| 4      | [ChatGPT]( https://openai.com/blog/chatgpt )          	  |  聊天机器人模型          |
| 5      | [deepseek]( https://chat.deepseek.com  )          	      |  探索未至之境            |



## 2、java

### 2.1、java编程

[calligraphy-boot]( https://gitlab.com/xuyq123/calligraphy-boot )  &ensp; [util]( https://gitlab.com/xuyq123/calligraphy-boot/-/blob/dev_20210728/calligraphy-boot-common/src/main/java/com/xu/calligraphy/boot/common/util/LogisticsUtil.java )

#### 2.1.1、常用方法

> @Data、JSON、@JsonFormat、ThreadPoolTaskExecutor、@MapKey、@Select
> Map遍历、创建数组、快速添加list、UnsupportOperationException

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComboboxVO {}


MessageResult result = JSON.parseObject(text, new TypeReference<MessageResult>() {});
List<DiffRegionLogisticsDetailVO> cateList = JSON.parseObject(text, new TypeReference<List<DiffRegionLogisticsDetailVO>>() {});

String detail = JSON.toJSONStringWithDateFormat(billDO, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
			
				
# 格式化全局时间
spring.jackson.date-format=yyyy-MM-dd HH:mm:ss
spring.jackson.time-zone=GMT+8


@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
private Date createTime;


Assert.isTrue(!StringUtils.isEmpty(param.getPhone()), "联系方式不能为空");

ExecutorService ex = Executors.newCachedThreadPool();
Runtime.getRuntime().availableProcessors();
ThreadPoolTaskExecutor
CountDownLatch
CyclicBarrier 

```

```java
@MapKey("operatorId")
List<Map<Integer, String>> queryOperatorList();

<select id="queryOperatorList" resultType="java.util.Map">
	select operator_id operatorId,operator_name operatorName from ins_region_log
	GROUP BY operator_id
</select>


@Select("<script>" +
        "select process_instance_id processInstanceId, business_id businessId, " +
        "settlement_no settlementNo, price, status, create_time createTime " +
        "from ins_settlement_process " +
        "WHERE settlement_no in " +
        "<foreach collection= 'billOrderList' item= 'billOrder' open='(' separator= ',' close=')'>" +
        "#{billOrder} " +
        "</foreach> order by create_time desc " +
        "</script>")
List<SettlementProcessInstanceDO> querySettlementProcessInstanceList(@Param("billOrderList") List<String> billOrderList);


```


```java

// java中Map遍历的四种方式
https://www.cnblogs.com/damoblog/p/9124937.html

Map<String,String> map = new HashMap<String,String>();
map.put("熊大", "棕色");
map.put("熊二", "黄色");


for(Map.Entry<String, String> entry : map.entrySet()){
    String mapKey = entry.getKey();
    String mapValue = entry.getValue();
    System.out.println(mapKey+":"+mapValue);
}

 map.entrySet().forEach(en->{
                en.getKey();
                en.getValue();
            });

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


```java
// 创建数组的四种方法
int[] a1;
int[] a2 = {1, 2, 3};
int[] a3 = new int[]{1, 2, 3};

int[] a4 = new int[3];
a4[0] = 1;
a4[2] = 2;
a4[3] = 3;

```

```java
// 几个快速添加list的方法
1. 使用Collections.addAll()方法，前提还是需要手动 new ArrayList
ArrayList<String> s = new ArrayList();
Collections.addAll(s,"1","2","3")

2. 使用Arrays.asList(...args) 直接返回一个List
List<String> s = Arrays.asList("1","2","3")
// 可能会抛异常 UnsupportOperationException

3. 如果引入了Guava的工具包，可以使用他的Lists.newArrayList(...args)方法
List<String> list = Lists.newArrayList("1","2","3")

4. 如果是Java9，可以使用自带的List类
List<String> s = List.of("1","2","3")

```

```
使用Arrays.asList()报错 UnsupportOperationException 原因

常常使用Arrays.asLisvt()后调用add，remove这些method时出现java.lang.UnsupportedOperationException异常。这是由于：
Arrays.asLisvt() 返回java.util.Arrays$ArrayList， 而不是ArrayList。

Arrays$ArrayList和ArrayList都是继承AbstractList，remove，add等 method在AbstractList中是默认throw UnsupportedOperationException而且不作任何操作。
ArrayList override这些method来对list进行操作，但是Arrays$ArrayList没有override remove(int)，add(int)等，所以throw UnsupportedOperationException。

解决方法：
List<String> list=new ArrayList(Arrays.asList(nameList));
 
```



#### 2.1.2、lambda表达式

> AtomicInteger、stream/map/filter/mapToInt/reduce/groupingBy/toMap/max、Optional、flatmap、peek

```java

/*** lambda表达式 */

// 循环
AtomicInteger total = new AtomicInteger(0);
productLogisticsDAOS.stream().forEach(dao -> {
	int temp = dao.getAmount() * dao.getCount();
	total.addAndGet(temp);
});
	
List<Integer> interceptProductIdList = interceptGoodsNumDAOS.stream().map(dao -> dao.getProductId()).distinct().collect(Collectors.toList());

List<DeliveryPackageDO> mainPackageDOList = packageDOS.stream().filter(dao -> dao.getTitle().equals(DriverPackageUtil.MAIN_PACKAGE_TEXT)).collect(Collectors.toList());


// 求和  值为null时会报错 No value present
Integer sum = detailDAOS.stream().mapToInt(DeliveryPackageGoodsDetailDAO::getNum).sum();
BigDecimal paymentAmount = purchaserAmountMap.values().stream().map(SupplierBillDetailVO::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
BigDecimal paymentAmount = purchaserAmountMap.values().stream().map(SupplierBillDetailVO::getAmount).reduce(BigDecimal::add).get();

// filter过滤空值且使用BigDecimal.ZERO 则不报错
list.stream().filter(val->val.getSalesAmount()!=null).map(SupplierJointSalesDO::getSalesAmount).reduce(BigDecimal.ZERO,BigDecimal::add);


/*** list转map */

// list转map-排序
LinkedHashMap<String, List<DeliveryOrderShopDAO>> addrMap = deliveryOrderShopDAOS.stream().collect(Collectors.groupingBy(DeliveryOrderShopDAO::getAddr_hash, LinkedHashMap::new, Collectors.toList()));

// list转map-多字段分组
Map<String, List<DeliveryGoodsDO>> deliveryGoodsMap = deliveryGoodsDOS.stream().collect(Collectors.groupingBy(item -> item.getVirtualgoodsId() + "_" + item.getTitle() + "_" + item.getSpec()));

// list转map-值为单个对象
Map<String, DeliveryDO> deliveryOrderMap = deliveryDOS.stream().collect(Collectors.toMap(DeliveryDO::getDeliveryOrder, a -> a));

// list转map-值为单个对象 （如有重复，用第一个）
Map<String, DeliveryDO> deliveryOrderMap = deliveryDOS.stream().collect(Collectors.toMap(DeliveryDO::getDeliveryOrder, a-> a,(k1,k2)->k1));


// list转map-值为对象的字段
 Map<Integer, Integer> goods2ProductParam = logisticsGoodsDAOS.stream().filter(dao -> goodsIdParamList.contains(dao.getGoodsId())).
                    collect(Collectors.toMap(LogisticsGoodsDAO::getGoodsId, LogisticsGoodsDAO::getProductId, (key1, key2) -> key2));


// 取最大最小值
Student ageMax = list.stream().max(Comparator.comparing(Student::getAge)).get();
Student ageMin = list.stream().min(Comparator.comparing(Student::getAge)).get();


Optional.ofNullable(type).orElse(0).intValue();

public static final int cpuNum = Runtime.getRuntime().availableProcessors();


```

```java
/*** list对象分组求和 */

List<WarehouseLogisticsDAO> basketList = warehouseLogisticsDOMapper.queryWarehouselogisticsBasket(warehouselogisticsOrderGoodQuery);

List<WarehouseLogisticsDAO> list = new ArrayList<>();

//（同一商家的数量相加）

// 分组求和1
basketList.stream().collect(Collectors.groupingBy(item -> item.getAddrTele() + "_" + item.getAddrAddress())).forEach((key, groupList) -> {
                WarehouseLogisticsDAO dao = new WarehouseLogisticsDAO();
                dao.setAmount(groupList.stream().mapToInt(WarehouseLogisticsDAO::getAmount).sum());
                dao.setAddrAddress(key);
                list.add(dao);
            });
			
// 分组求和2
basketList.parallelStream().collect(Collectors.groupingBy(item -> item.getAddrTele() + "_" + item.getAddrAddress(), Collectors.toList()))
		.forEach((key, groupList) -> {
					groupList.stream().reduce((a, b) -> {
						WarehouseLogisticsDAO dao = new WarehouseLogisticsDAO();
						dao.setAddrAddress(key);
						dao.setAmount(a.getAmount() + b.getAmount());
						return dao;
					}).ifPresent(list::add);
				}
		);
		
// map computeIfAbsent   如果不存在这个 key，则添加到 Map 中
Map<String,BigDecimal> map = new HashMap<>();
String key = String.format("%s_%s", salaryDriverDAO.getRegion(), deliveryMonth);	
map.computeIfAbsent(key, k -> BigDecimal.ZERO);
map.put(key, map.get(key).add(salaryDriverDAO.getExpectIncomeAmount()));

Map<Integer, List<DamagedProduct>> standardMap = new LinkedHashMap<>();
standardMap.computeIfAbsent(standardType, k -> new ArrayList<>()).add(damagedProduct);

// summarizingDouble json 对象列表数字求和
double catePercentageAmount = dayList.stream().map(DeliverySalaryDriverDAO::getCatePlan).collect(Collectors.summarizingDouble(e ->
                            e.getBigDecimal("catePercentageAmount").doubleValue())).getSum();			 
```

---

---

```java
JAVA8 中的flatmap

使用flatMap方法的效果是，各个数组并不是分别映射一个流，而是映射成流的内容，所有使用map(Array::stream)时生成的单个流被合并起来，即扁平化为一个流。
https://blog.csdn.net/liyantianmin/article/details/96178586
https://blog.csdn.net/zhuwukai/article/details/82888316
https://www.jianshu.com/p/ecb8e8f77a89

 public static void main(String[] args) {
	List<User> uList = Lists.newArrayList();
	User u1 = new User();
	u1.setAddr("a1;a2;a3;a4;a5");

	User u2 = new User();
	u2.setAddr("b1;b2;b3;b4;b5");

	uList.add(u1);
	uList.add(u2);

	List<String> addrList = uList.stream().map(x -> x.getAddr()).flatMap(x-> Arrays.stream(x.split(";"))).collect(Collectors.toList());
	//或者
	List<String> ridStrList = uList.stream().map(x -> x.getAddr()).map(x -> x.split(";")).flatMap(Arrays::stream).collect(Collectors.toList());
	System.out.println(addrList);
}

@Data
@NoArgsConstructor
public class User{
	private   String addr;
}


---


public static class User {
        private String name;
        private List<String> relativeUserList;
}
// 获取list中的list字段
List<String> strings = users.stream()
  .flatMap(user -> user.getRelativeUserList().stream())
  .collect(Collectors.toList());
	
```


```
Java 8 Stream peek 与 map的区别
原文链接：https://blog.csdn.net/tckt75433/article/details/81510743
总结：peek接收一个没有返回值的λ表达式，可以做一些输出，外部处理等。map接收一个有返回值的λ表达式，之后Stream的泛型类型将转换为map参数λ表达式返回的类型。

```



#### 2.1.3、通用工具

> 深度复制、正则分割中文和数字、特殊字符检测、sql注入检测

```java
<dependency>
    <groupId>net.sf.dozer</groupId>
    <artifactId>dozer</artifactId>
    <version>5.5.1</version>
</dependency>


/**
 * 深度复制
 * @param sourceObject
 * @param targetObject
 */
public static void copyPropertiesByDeep(Object sourceObject, Object targetObject) {
    DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
    dozerBeanMapper.map(sourceObject, targetObject);
}

	
	
	
/**
 * 正则分割中文和数字
 *
 * @param region
 * @return
 */
public static List spitRegion(String region) {
	Pattern REGION_PATTERN = Pattern.compile("[\\u4e00-\\u9fa5]+|\\d+");
	
    List<String> list = new ArrayList<>();
    Matcher m = REGION_PATTERN.matcher(region);
    while (m.find()) {
        list.add(m.group());
    }
    return list;
}
	
```

```java

    /**
     * 特殊字符检测
     *
     * @param str
     * @return
     */
    public static Boolean filterString(String str) {
        String regEx = "[`~!@#$%^&*()+=|{}':;'\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim().length() != str.length();
    }

    /**
     * sql注入检测
     *
     * @param str
     * @return
     */
    public static Boolean filterStringSql(String str) {
        Pattern pattern = Pattern.compile("\\b(and|exec|insert|select|drop|grant|alter|delete|update|count|chr|mid|master|truncate|char|declare|or)\\b|(\\*|;|\\+|'|%)");
        Matcher matcher = pattern.matcher(str.toString().toLowerCase());
        return matcher.find();
    }
```



#### 2.1.4、java排序

> Arrays.sort、Collections.sort、new Comparator、compareTo、stream/Comparator/comparing

```java
java排序

public static void main(String[] args) {
        // 1、数组排序
        int[] arr = {2, 3, 4, 5, 2, 1};
        Arrays.sort(arr);
        System.out.println(JSON.toJSON(arr));

        // 2、列表排序
        List<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(1);
        Collections.sort(list);
        System.out.println(JSON.toJSON(list));

        Random random = new Random();
        List<BuffProductNumDAO> numDAOList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            BuffProductNumDAO buffProductNumDAO = new BuffProductNumDAO();
            buffProductNumDAO.setProductId(random.nextInt(10));
            numDAOList.add(buffProductNumDAO);
        }
        System.out.format("Comparator before list=%s", JSON.toJSON(numDAOList));
		
        // 3、Comparator排序
        Collections.sort(numDAOList, new Comparator<BuffProductNumDAO>() {
            @Override
            public int compare(BuffProductNumDAO p1, BuffProductNumDAO p2) {
                // 调用compare方法大于0，就把前一个数和后一个数交换，也就是把大的数放后面了，
                // 即所谓的升序了。如果第二个参数与第一个参数调换顺序，也就是降序了。
                int product = p2.getProductId() - p1.getProductId();
                return product;
            }
        });
        System.out.println();
        System.out.format("Comparator after list=%s", JSON.toJSON(numDAOList));

        Collections.sort(logisticsDAOList, Comparator.comparing(WarehouseLogisticsDAO::getSort).thenComparing(WarehouseLogisticsDAO::getDistance));
				
				
        // 4、Comparable排序
        List<Goods> goodsList = new ArrayList<>();
        Collections.sort(goodsList);

    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Goods implements Comparable<Goods> { //实现Comparable接口，利用泛型限定比较的类型
        private Integer productId; //商品编号
        private String name; //商品名称
        private double price; //商品价格

        @Override
        public int compareTo(Goods o) {  //重写compareTo方法。
            //取出商品价格
            double price1 = this.getPrice();
            double price2 = o.getPrice();
            int n = new Double(price2 - price1).intValue();  //double类型的差值转为int
            return n;
        }
    }
	
	
```


```sql
Java8排序stream.sorted() 
https://blog.csdn.net/qq_34996727/article/details/94472999

System.out.println("---Natural Sorting by Name---");
List<Student> slist = list.stream().sorted().collect(Collectors.toList());
slist.forEach(e -> System.out.println("Id:" + e.getId() + ", Name: " + e.getName() + ", Age:" + e.getAge()));

System.out.println("---Natural Sorting by Name in reverse order---");
slist = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
slist.forEach(e -> System.out.println("Id:" + e.getId() + ", Name: " + e.getName() + ", Age:" + e.getAge()));

System.out.println("---Sorting using Comparator by Age---");
slist = list.stream().sorted(Comparator.comparing(Student::getAge)).collect(Collectors.toList());
slist.forEach(e -> System.out.println("Id:" + e.getId() + ", Name: " + e.getName() + ", Age:" + e.getAge()));

System.out.println("---Sorting using Comparator by Age with reverse order---");
slist = list.stream().sorted(Comparator.comparing(Student::getAge).reversed()).collect(Collectors.toList());
slist.forEach(e -> System.out.println("Id:" + e.getId() + ", Name: " + e.getName() + ", Age:" + e.getAge()));


分组排序
https://www.toutiao.com/article/7096484701099295263

TreeMap<TypeEnum, List<Customer>> treeMap4 = customers.stream().sorted(Comparator.comparing(Customer::getAge, Comparator.nullsLast(Integer::compareTo)))
		.collect(Collectors.groupingBy(Customer::getType, TreeMap::new, Collectors.toList()));
	
	
Map<String, List<LogisticsStatisticsDAO>> logisticsRegionMap = logisticsStatisticsDAOS.stream().
		collect(Collectors.groupingBy(LogisticsStatisticsDAO::getRegion, WarehouseUtil::getCustomSortTreeMap, Collectors.toList()));
		
public static TreeMap<String, List<LogisticsStatisticsDAO>> getCustomSortTreeMap() {
	// return new TreeMap<>(Comparator.comparingInt(TypeEnum::getPriority));
	TreeMap<String, List<LogisticsStatisticsDAO>> map = new TreeMap<String, List<LogisticsStatisticsDAO>>(new Comparator<String>() {
		@Override
		public int compare(String r1, String r2) {
			// 升序
			return CommonUtil.regionSort(r1, r2);
		}
	});
	return map;
}
	
```

#### 2.1.5、死锁Deadlock

```
--查询一下mysql的事务处理表
select * from information_schema.INNODB_TRX  

--杀掉进程
kill 进程ID

详情见笔记
https://gitlab.com/xuyq123/mynotes/-/blob/master/%E6%95%B0%E6%8D%AE%E5%BA%93/mysqlNote.md?ref_type=heads#user-content-36%E6%AD%BB%E9%94%81deadlock

https://xushufa.cn/docs/bian-cheng/shu-ju-ku/mysqlnote.html

```



---

### 2.2、idea基本配置与快捷键

#### 2.2.1、idea配置与插件


```java
idea基本配置  File -- Settings

1、修改快捷键
Keymap  Eclipse

2、调整字体
font  - Size

3、配置 maven
Maven home directory:   D:/ProgramFiles/apache-maven-3.6.0
User setting file:      D:\ProgramFiles\apache-maven-3.6.0\conf\settings.xml
Local repository:       D:\ProgramFiles\apache-maven-localRepository

新项目配置maven
Settings for New Projects...
New Projects Setup

4、配置Git命令行
Terminal - Shell path
D:\ProgramFiles\git\Git\bin\bash.exe

5、自动生成作者信息
file and code Templates -- Includes -- File Header
/**
 * @author xyq
 * @date ${DATE} ${TIME}
 */

 
6、代码自动导入包
Settings→Editor→General→Auto Import
选中Optimize imports on the fly 和 Add unambiguous imports on the fly

7、代码自动定位文件
Project - Show Options Menu - Autoscroll From Source

8、显示成员变量及方法
Project - Show Options Menu - Show Members

9、初始化idea（删除所有配置及历史记录）
删除目录 C:\Users\Administrator\.IdeaIC2019.1

```

```
idea常用插件 File -- Settings -- Plugins
lombok
Free Mybatis plugin    MybatisX
GenerateAllSetter      Alt+Enter
Spring Assistant 
Translation

Alibaba Java Coding Guidelines
Markdown
swagger
```

#### 2.2.2、idea常用快捷键

```
eclipse & idea常用快捷键

sout            打印
fori            循环
Shift+Enter     另起一行
Alt+Enter       快速命名
Ctrl+h          全局关键词搜索
Ctrl+f          当前文件查找、替换
Ctrl+shift+r    全局文件查找
Ctrl+shift+f    整理代码格式
Ctrl+shift+u    大小写
Ctrl+shift+o    整理导入包
Alt+insert      快速生成get和set方法、构造方法
Alt+shift+r     批量重命名
Alt+shift+m     提取本地变量及方法

---
    
Ctrl+Alt+↑      往上或下复制当前内容
Alt+↓           将当前行的内容往上或下移动
Alt+/           导入一个包
Ctrl+m          编辑器窗口最大化
Ctrl+o          快速outline，查找方法
Ctrl+e          快速转换编辑器
syso+Alt+/      输出

```

---

### 2.3、java软件

#### 2.3.1、jdk java软件

| 软件     | 下载地址      |
| -------- | --------      |
| idea     | [idea官方下载]( https://www.jetbrains.com/idea/download/other.html ) &ensp; [idea2019]( https://www.aliyundrive.com/s/oWgxBBNqGj9 )     |
| maven    | [maven官方下载]( https://archive.apache.org/dist/maven/maven-3/ )            |
| mysql    | [mysql_5.7]( https://www.aliyundrive.com/s/pymjQca3DbY )                     |
| javaSoft | [java软件]( https://www.aliyundrive.com/s/fWXemUwcsUs )  redis/mongo/Navicat/kafka/zookeeper/git/Xshell...                              |
| tomcat   | [tomcat官网]( https://archive.apache.org/dist/tomcat/ ) &ensp; ([云盘]( https://pan.baidu.com/s/1yPhAfIcACTGkpIOYlEds1g )  密码: j9ug ) |
| eclipse  | [eclipse官方下载]( http://www.eclipse.org/downloads/packages )               |

---

> Java Development Kit (JDK) 是Sun公司（已被Oracle收购）针对Java开发员的软件开发工具包。自从Java推出以来，JDK已经成为使用最广泛的Java SDK（Software development kit）。

- [ ] jdk来自[官网]( http://www.oracle.com/technetwork/java/archive-139210.html ) ，这些软件有三种格式：tar.gz、zip、bin
- 1、zip是windoxs软件，解压后会有exe格式的jdk软件，直接安装即可。
- 2、tar.gz是linux软件，需要用 `tar -zxvf xx.tar.gz` 解压。
- 3、bin也是linux软件，需解压：
   - 添加执行权限 
    `chmod u+x jdk-6u45-linux-x64.bin`
   - 解压 
    `./jdk-6u45-linux-x64.bin`
   
- [ ] 软件名称里含有x64则是64位软件，32位为则没有。如下：
- `jdk-8u162-windows-x64.zip`  `jdk-8u162-linux-x64.tar.gz`  是64位软件
- `jdk-8u72-windows-i586.zip`  `jdk-8u72-linux-i586.tar.gz`  是32位软件


| 云盘链接                                                      | 密码 |
| --------------------------------                              | ---  |
| [jdk6]( https://pan.baidu.com/s/1z3p1DecyBVugP7cECIupyg )     | 829h |
| [jdk7]( https://pan.baidu.com/s/17ik9x-g3RkYEu6vah9CZVw )     | muvr |
| [jdk8]( https://pan.baidu.com/s/1MT8zldLnH9PuZsVR77DEAw )     | mv5i |
| [jdk9]( https://pan.baidu.com/s/1SMGJqedJKR3hULrpWn4eLA )     | hai6 |
| [jdk10]( https://pan.baidu.com/s/1SHA7XNoPxBdOkaed3cunow )    | hgyn |

---

```
java mysql maven  
idea git navicat notepad++  
postman xshell fillder typora VMware
redis mongo kafka zookeeper tomcat eclipse
python nodejs npm vue github gitlab gitee gitcode
Google Chrome 火绒安全软件 向日葵 Everything
```

---

#### 2.3.2、java maven环境变量

```java
java环境变量配置    注意：环境变量中都是英文符号，结尾以英文分号;结束
创建  JAVA_HOME     C:\Program Files\Java\jdk1.8.0_162
添加  Path          %JAVA_HOME%\bin;%JAVA_HOME%\jre\bin;
创建  CLASSPATH     .;%JAVA_HOME%\lib;%JAVA_HOME%\lib\tools.jar;

验证 java -version

---

maven环境变量配置
创建  MAVEN_HOME    D:\ProgramFiles\apache-maven-3.6.0
添加  Path          %MAVEN_HOME%\bin;

验证 mvn -version

---

tomcat环境变量配置
创建  TOMCAT_HOME   E:\ProgramFiles\apache-tomcat-8.5.31
添加  CLASSPATH     %TOMCAT_HOME%\BIN;

验证 
启动 bin/startup.bat 
访问 http://localhost:8080/ （或 http://127.0.0.1:8080/ ）

```

---


#### 2.3.3、postman配置

```js
postman环境变量配置
--manage environments
https://blog.csdn.net/mt122/article/details/104530439
https://www.jianshu.com/p/391e995881c0

--Tests
var jsonData = JSON.parse(responseBody);
tests["success"] = jsonData.code === 200;
postman.setGlobalVariable("authorityToken", jsonData.data.token);
 

postman 出现Error: connect ECONNREFUSED 127.0.0.1:端口
https://blog.csdn.net/weixin_45993202/article/details/109072188

Settings--Proxy
去掉勾选 Use the system proxy

```

```
导出所有数据，一键导出集合、接口和环境变量
1、浏览器登录postman，进入 https://web.postman.co/me/export  页面
2、点击 Export Data
3、刷新页面，成功后会发生邮件，有下载链接


```

---

### 2.4、springboot项目打包布署

```sh
springboot项目打包布署
https://gitlab.com/xuyq123/calligraphy-boot

方法一：maven打包jar、运行jar
前提：安装java软件、构建jar项目

Administrator@ho-xyq MINGW64 /e/Project/gitlab/calligraphy-boot (dev_2021072301)
$ mvn clean package

Administrator@ho-xyq MINGW64 /e/Project/gitlab/calligraphy-boot/calligraphy-boot-start/target (dev_2021072301)
$ java -jar calligraphy-boot-start-1.0-SNAPSHOT.jar


方法二：maven打包war、布署tomcat
前提：安装java软件、构建war项目

1、mvn clean package  生成war
2、将 calligraphy-boot.war 复制到 E:\ProgramFiles\apache-tomcat-8.5.31\webapps
3、启动tomcat   E:\ProgramFiles\apache-tomcat-8.5.31\bin\startup.bat


----

maven常用打包命令
1、mvn compile 编译,将Java 源程序编译成 class 字节码文件。
2、mvn test 测试，并生成测试报告
3、mvn clean 将以前编译得到的旧的 class 字节码文件删除
4、mvn pakage 打包,动态 web工程打 war包，Java工程打 jar 包。
5、mvn install 将项目生成 jar 包放在仓库中，以便别的模块调用
6、mvn clean install -Dmaven.test.skip=true  抛弃测试用例打包

```

---


### 2.5、我的网站

> **平台**

- 若有志同道合的小伙伴想联系本人，可通过以下方式发邮件或私信。路漫漫其修远兮，吾将上下而求索。共勉。

| 平台           | 链接           |
| -------------- | -------------- |
|  **项目仓库**  | [gitlab]( https://gitlab.com/xuyq123/mynotes ) &ensp; [gitcode]( https://gitcode.net/xu180/MyNotes ) &ensp; [github]( https://github.com/scott180/MyNotes )  &ensp; [bitbucket]( https://bitbucket.org/xu12345/calligraphy ) &ensp; [gitee]( https://gitee.com/xy180/MyNotes ) &ensp; [sourceforge]( https://sourceforge.net/p/calligraphy/code )  &ensp; [vuepress]( https://scott180.github.io/vuepress-blog )    |
|  **资讯账号**  | [微信公众号]( https://mp.weixin.qq.com/s/HmdDsCaeumuZg_DfitIdlw ) &ensp; [头条]( https://www.toutiao.com/c/user/token/MS4wLjABAAAA2_bWhiknCbcKNu4c6VTM2B7m2vr7zBrh0x6fSyOrtGU ) &ensp;  [豆瓣]( https://www.douban.com/people/80730595/photos ) &ensp;  [知乎]( https://www.zhihu.com/people/xu-xian-sheng-72-29/posts )     |
|  **个人邮箱**  | 1021151991@qq.com   |

***

> **公众号**

- 注册了微信公众号及今日头条号：[**无为徐生**]( https://scott180.github.io/calligraphy/%E6%97%A0%E4%B8%BA%E5%BE%90%E7%94%9F )，将书法练习轨迹、程序员笔记以及一些随笔感想更新在此。<br/>

| 无为徐生   | 微信公众号                                               	 |  &ensp; |  今日头条号        |
| ---------  | ------------------------------------------------------------- |  -      |  ----------        |
|  二维码    | ![w]( https://bitbucket.org/xu12345/document/raw/114a5f5c292cc412cd46304dc1d20cfda7c7a7f8/imgs/weixin/wuweixusheng_weixin.png ) | <br/> | ![t]( https://bitbucket.org/xu12345/document/raw/114a5f5c292cc412cd46304dc1d20cfda7c7a7f8/imgs/toutiao/wuweixusheng_toutiao.png )     |

***

> **我的网站**

- 生活随笔-编程笔记-书法练习轨迹

| 博客   | 地址        |  备注          |
| -----  | ----------- |  ------------- |
| 1      | [reco-blog]( https://scott180.github.io/reco-blog )          | `vuepress-theme-reco`构建的博客网站。|
| 2      | [vuepress-blog]( https://scott180.github.io/vuepress-blog )  | `vuepress`构建的博客网站。           |
| 3      | [mkdocs-blog]( https://xuyq123.gitlab.io/mkdocs-blog )   	| `mkdocs`构建的博客网站。             |

***

