# linux笔记-xyq
  
*   [1、命令](#command)
    *   [1.1、常用命令](#commonCommand)
    *   [1.2、命令说明](#commonIntroduce)
    *   [1.3、软件操作及安装](#soft)
    *   [1.4、IP及防火墙](#IP)
    *   [1.5、知识点](#knowledge)
*   [2、shell编程](#shell)
    *   [2.1、shell概述及优势](#shellIntroduce)
    *   [2.2、shell创建、执行](#shellExecute)
    *   [2.3、shell 变量、引号、数组、传递参数](#shellParams)
    *   [2.4、shell 运算符](#shellOperator)
    *   [2.5、shell 常用命令](#shellCommonCommand)
    *   [2.6、shell 流程控制](#shellFlow)
    *   [2.7、shell 函数](#shellFunction)
    *   [2.8、shell 输入、输出重定向](#shellIO)
    *   [2.9、shell 文件包含](#shellFileContain)
*   [3、vi命令详解](#viCommand)
*   [4、其他](#endOther)
    *   [4.1、修改linux时间](#updateLinuxTime)
    *   [4.2、星期月份英语](#EnglishTranlator)

*2017年8月22日-至今*

标签（空格分隔）： linux xyq customeDirectoy [toc]

>  [作业部落]( https://www.zybuluo.com/mdeditor )    [linux]( https://github.com/scott180/MyNotes/blob/master/linux%E7%AC%94%E8%AE%B0-x.md ) [CSDN]( https://me.csdn.net/xu180 )  [马克飞象]( https://maxiang.io )   [markdown]( https://jbt.github.io/markdown-editor/ )    

<h2 id="command"></h2>

## 1、命令说明 
 <h3 id="commonCommand"></h3>
 
### 1.1 常用命令

说明                | 命令
-----------------   | -----------------------------------------------------------------  
进入目录       		| cd dir1
创建目录       		| mkdir dir1   
创建多级目录  		| mkdir -p  d1/d2/d3   
查看当前目录		| pwd
复制文件       		| cp srcname  targetname
复制目录 			| cp -r dir1/ dir2/
修改名称(移动文件)  | mv readme.txt readme.doc
跨服务器复制        | scp /data/ROOT.tar.gz root@192.168.239.35:/opt/sudytech/db_backup
删除普通文件a.txt   | rm a.txt (-f:表示强制)
目录a删除           | rm -rf a       (-f:表示强制; -r:表示目录)
建立新文件  		| touch test.txt
清空文件            | cat /dev/null >json.log
`-----------------` | `-----------------------------------------------------------------`  
查看磁盘空间     	| df -h
查看文件大小        | du -h filepath
显示文件或目录类型	| file test
查询程序的位置	    | which test
统计文件信息	    | wc testfile
3 92 598 testfile   | testfile文件的行数为3、单词数92、字节数598 
`-----------------` | `-----------------------------------------------------------------`  
压缩tar   | tar -zcvf /home/love.tar.gz /home/yx/love
解压tar   | tar -zxvf /home/love.tar.gz
压缩zip   | zip  test.zip  test
解压zip   | unzip test.zip
`-----------------` | `-----------------------------------------------------------------`  
模糊查找当前目录文件   	 | find *txt
从根目录查找文件         | find / -name test 
查找文件               	 | find /home -name 'test.log' -type f -print
查找目录                 | find / -name 'tech' -type d -print
查找当前目录及子目录文件 | find . -name "*root*" -maxdepth 1  （maxdepth指层数）
查找大文件               | find / -type f -size +400M | xargs ls -hlrt
`-----------------` | `-----------------------------------------------------------------`  
从旧到新并显示大小 | ls -hlrt （ls -lrt 从旧到新） 
从新到旧并显示大小 | ls -hlt  （ls -lt  从新到旧 ）
按大小升序		   | ls -hSlr
按大小降序		   | ls -hSl
模糊查找文件	   | ls name*  (ls /etc/rc.d/init.d/my*)
显示当前目录文件   | ls
`-----------------` | `-----------------------------------------------------------------`  
查看linux版本      	| cat /proc/version      lsb_release -a
查看linux内核版本   | uname -a
查看centos版本 	    | cat /etc/redhat-release
查看java版本        | java -version
查看进程			| ps 
查看tomcat进程      | ps -ef | grep tomcat
`-----------------` | `-----------------------------------------------------------------` 
上传				| sz filename   (安装上传下载 yum install lrzsz)
下载    			| sz
显示10行历史记录	| history 10
查看ip             	| ifconfig
清楚屏幕           	| clear
查看时间           	| date
时间格式化          | date "+%Y-%m-%d %H:%M:%S"
查看指定年月日历   	| cal 3 2013
建立链接 			| ln -fs /opt/tech/mysql/bin/mysql /usr/local/bin/mysql
删除链接 			| rm -rf name
查看所有别名   		| alias
添加别名       		| alias test="tar -zcvf "
删除别名       		| unalias test
显示所有分区的信息	| fdisk -l 
帮助				| help
查看命令手册 		| man ls  
树状结构展示目录	| tree   (安装tree命令 yum  install tree)  
输出重定向(保存文件)| ls > dir.txt
追加文件            | ls >> dir.txt 
`-----------------` | `-----------------------------------------------------------------` 
关机				| halt              
重启       			| reboot  
关机重启        	| shutdown -r
关机不重启        	| shutdown -h
立刻关机        	| shutdown now
********************************************************


 <h3 id="commonIntroduce"></h3>
 
### 1.2 命令说明
#### 1.2.1 vi操作
```
:wq (输入「wq」，存盘并退出vi)
:q! (输入q!， 不存盘强制退出vi)
:set fileencoding  查看文件编码
:set nu 显示行数

查找  /关键字
按「G」：移动到文章的最后。
按「g」：移动到文章的开头。
dd  : 删除当前行
x   : 删除光标位置字符
u   ：后退 返回 上一步

/string 向前搜索指定字符串
?string 向后搜索指定字符串
n 搜索指定字符串的下一个出现位置
N 搜索指定字符串的上一个出现位置
:%s/old/new/g 全文替换指定字符串 
```
********************************************************


#### 1.2.2 环境变量export
```
查看所有环境变量    export
查看环境变量 	    echo $PATH
				    export $hello
					
设置临时环境变量    export PATH=$PATH:/usr/local/mysql/bin
					export hello="hello world"

设置系统环境变量	
	vi /etc/profile

		export PATH=$PATH:/usr/local/mysql/bin  # 在配置文件中加入此行配置
		export hello="hello world"  # 在配置文件中加入此行配置

	需要注意的是：修改完这个文件必须要使用 以下命令在不用重启系统的情况下使修改的内容生效。

	source /etc/profile

	或者是用 ‘.’：

	. /etc/profile

	查看：
	echo $PATH
		/usr/kerberos/sbin:/usr/kerberos/bin:/usr/local/sbin:/usr/local/bin:/sbin:/bin:/usr/sbin:/usr/bin:/root/bin:/usr/local/mysql/bin
	
	echo $hello
		hello world
	
	配置已经生效
	
```
********************************************************


#### 1.2.3  head tail less more 
``` 
1. 如果你只想看文件的前100行，可以使用head命令，如
head -100  filename
2. 如果你想查看文件的后100行，可以使用tail命令，如：
tail -100  filename 或 tail -n 100  filename
3. 查看文件中间一段，你可以使用sed命令，如：
sed -n '100,200p' filename 
这样你就可以只查看文件的第100行到第200行。

截取的文件可以用重定向输入到新的文件中：
head -100  filename >a.txt

tail -f cata.log  打印日志

cat  test.txt        显示文件开头
tac  test.txt        显示文件结尾
more test.txt        逐页显示文件 
less test.txt        逐页显示文件（优化more）
head -n 20 test.txt  显示文件前20行  head -100  filename
tail -n 20 test.txt  显示文件后20行  tail -100  filename 


如果文件太长，用cat命令只能看到文件的最后一页，而用more命令时可以一页一页地显示。执行more命令后，进入more状态，用【Enter】键可以向后移动一行；用【Space】键可以向后移动一页；用“q”键可以退出。在more状态下还有许多功能，可用man more命令获得。

less实际上是more的改进版，其命令的直接含义是more的反义。less的功能比more更灵活。例如：用【Pgup】键可以向前移动一页，用【Pgdn】键可以向后移动一页，用向上光标键可以向前移动一行，用向下光标键可以向后移动一行。“q”键、【Enter】键、【Space】键的功能和more类似。

用【G】键可以移动文件到结尾，用【g】键可以移动到文件开头。
``` 
********************************************************************


#### 1.2.4 cat详解
```
cat命令是linux下的一个文本输出命令，通常是用于观看某个文件的内容。
cat主要有三大功能：
	1.一次显示整个文件。
		$ cat   filename
		
	2.从键盘创建一个文件。
		$ cat  >  filename                                     
		只能创建新文件,不能编辑已有文件
		
	3.将几个文件合并为一个文件。
		$cat   file1   file2  > file


	cat具体命令格式为 : cat [-AbeEnstTuv] [--help] [--version] fileName
		说明：把档案串连接后传到基本输出(屏幕或加 > fileName 到另一个档案)
		参数：
		-n 或 –number 由 1 开始对所有输出的行数编号
		-b 或 –number-nonblank 和 -n 相似，只不过对于空白行不编号
		-s 或 –squeeze-blank 当遇到有连续两行以上的空白行，就代换为一行的空白行
		-v 或 –show-nonprinting
		范例：
		cat -n linuxfile1 > linuxfile2 把 linuxfile1 的档案内容加上行号后输入 linuxfile2 这个档案里
		cat -b linuxfile1 linuxfile2 >> linuxfile3 把 linuxfile1 和 linuxfile2 的档案内容加上行号(空白行不加)之后将内容附加到linuxfile3 里。
		范例：
		把 linuxfile1 的档案内容加上行号后输入 linuxfile2 这个档案里
		cat -n linuxfile1 > linuxfile2
		把 linuxfile1 和 linuxfile2 的档案内容加上行号(空白行不加)之后将内容附加到 linuxfile3 里。
		cat -b linuxfile1 linuxfile2 >> linuxfile3
	
	
	cat /dev/null > /etc/test.txt 此为清空/etc/test.txt档案内容
		
----------------------------------------------------------

cat << EOF的语句说明
	EOF是“end of file”，表示文本结束符。EOF在这里没有特殊的含义，你可以使用FOE或OOO等（当然也不限制在三个字符或大写字符）。

简单描述一下常见的使用方式及其作用：
	1、cat<<EOF，以EOF输入字符为标准输入结束：
	2、cat>filename，创建文件，并把标准输入输出到filename文件中，以ctrl+d作为输入结束：
	注意：输入时是没有'>'的。
	3、cat>filename<<EOF，以EOF作为输入结束，和ctrl+d的作用一样。

命令：
	$ cat > test.txt << EOF
	> 说明cat及EOF
	> 测试
	> EOF
	
	$ cat test.txt
	说明cat及EOF
	测试

其他写法：
	cat >> test.txt << EOF 在test.txt里追加内容，不会覆盖原有文件。

	$ cat >> test.txt << END     //这里的“END”就代替了“EOF”的功能。结果是相同的。
	> 追加内容
	> END

	$ cat test.txt
	说明cat及EOF
	测试
	追加内容
```		
********************************************************************
 
#### 1.2.5 grep 
 
 [grep命令]( http://www.cnblogs.com/end/archive/2012/02/21/2360965.html )
``` 
查询文件中内容并保存
	more linux.txt | grep mysql > test.txt      // > 创建新文件
	cat linux.txt | grep 软件 >> test.txt      // >> 是在文件中追加内容
	
	grep mysql linux.txt > test.txt
	
查询文件内容行数
	cat linux.txt | grep mysql | w -l
	
	
查询运行的进程
	ps -ef | grep mysql
	ps -ef | grep java
		-e   显示所有进程。
		-f    全格式。
		
		
grep '^root' /etc/group 匹配正则表达式的开始行 
grep 'root$' /etc/group 匹配正则表达式的结束行 

RE（正则表达式） 
\ 忽略正则表达式中特殊字符的原有含义 
^ 匹配正则表达式的开始行 
$ 匹配正则表达式的结束行 
\< 从匹配正则表达式的行开始 
\> 到匹配正则表达式的行结束 
[ ] 单个字符；如[A] 即A符合要求 
[ - ] 范围 ；如[A-Z]即A，B，C一直到Z都符合要求 
. 所有的单个字符 
* 所有字符，长度可以为0 
``` 
********************************************************************


 <h3 id="soft"></h3>
 
### 1.3 软件操作及安装  

#### 1.3.1  mysql 
```java
指令 ps -ef|grep mysql 得出结果
    root     17659     1  0  2011 ?        00:00:00 /bin/sh /usr/bin/mysqld_safe --datadir=/var/lib/mysql --socket=/var/lib/mysql/mysql.sock --log-error=/var/log/mysqld.log --pid-file=/var/run/mysqld/mysqld.pid   
    mysql    17719 17659  0  2011 ?        03:14:57 /usr/libexec/mysqld --basedir=/usr --datadir=/var/lib/mysql --user=mysql --pid-file=/var/run/mysqld/mysqld.pid --skip-external-locking --socket=/var/lib/mysql/mysql.sock  

usr/bin/mysql 是指：mysql的运行路径
var/lib/mysql 是指：mysql数据库文件的存放路径
usr/lib/mysql 是指：mysql的安装路径 


导出数据库 /opt/tech/mysql/bin/mysqldump -uroot -p1234 webpro > /opt/tech/20170814.sql
 
导入数据  mysql -uroot -pSudy.web123 UCPPLUS < /opt/sql/ucpplus_v4_0_5.sql

mysql导入时出现"ERROR at line : Unknown command '\''."的解决办法
		 mysql -uroot -p12344  --default-character-set=utf8 IMP_V12_1 < E:\ids-1.1.2.sql

导出查询语句 /opt/sudytech/mysql/bin/mysql -uroot -p12344 -e "use IDSPLUS;select id,loginName from T_USER where id=1\G;" >> /opt/test.txt

导出表   /opt/tech/mysql/bin/mysqldump -uroot -p1234 webpro t_user > /opt/tech/t_user.sql

创建数据库
CREATE DATABASE UCPPLUS DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
use UCPPLUS;
 
登录mysql  /opt/tech/mysql/bin/mysql -uroot -p1234 
           /opt/tech/mysql/bin/mysql -uroot -padmin

创建、使用数据库   create database test;  use test;
导入sql数据 	source /root/20151010.sql


复制表数据到新表
CREATE TABLE T_MENU1 LIKE T_MENU;
INSERT INTO T_MENU1 SELECT * FROM T_MENU;

/opt/tech/apache-tomcat-6.0.45/webapps/add20170814.sql

修改max_allowed_packet  vi /etc/my.cnf

58.246.98.94
mysql -u root -p12344



navicat连接mysql失败，授权：
GRANT ALL PRIVILEGES ON `db1`.* TO 'user1'@'192.171.1.18' identified by 'pwd1' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON `IDSPLUS`.* TO 'sudy'@'192.171.1.18' identified by 'shhg12344' WITH GRANT OPTION;

grant all privileges on *.* to root@'%' identified by 'Sudy.web123' with grant option;

-- flush privileges;


查询权限
select * from mysql.user
select Host,User,password_last_changed from mysql.user

取消权限
revoke  all on *.* from 'root'@'192.168.0.197' ;

删除用户权限
Delete from mysql.user where user = "user_name" and host = "host_name" ; 


 
linux 的mysql配置文件  /etc/my.cnf

查看编码
show variables like 'character%'; 

设置编码
set character_set_server='utf8';  

查看sql_mode
SELECT @@GLOBAL.sql_mode;

识别大小写
lower_case_table_names = 2

启动mysql
  /opt/sudytech/mysql/support-files/mysql.server start
  
  /opt/sudytech/mysql/bin/mysqld_safe --user=mysql --basedir=/opt/sudytech/mysql --datadir=/opt/sudytech/mysql/data & 
  
  cd /opt/sudytech/mysql/
  ./bin/mysqld_safe &
  
  
  chmod -R 775 mysql
  
  
  cd /data/sudytech/mysql/&&./bin/mysqld_safe &
  cd /opt/sudytech/mysql/ && bin/mysqld_safe --user=root &
  
```
********************************************************************


#### 1.3.2 mongo   
[mongo笔记]( https://github.com/scott180/MyNotes/blob/master/mongo.md )
```
配置文件启动
cd /opt/sudytech/mongodb           
./bin/mongod --config /opt/mongodb/conf/mongo.conf 
	
自定义路径启动										 
  /opt/sudytech/mongodb/bin/mongod --dbpath=/opt/sudytech/mongodb/data --logpath=/opt/sudytech/mongodb/logs --logappend  --port=27017 --fork
  
登陆mongo
cd /opt/sudytech/mongodb/bin
mongo
```
********************************************************************


#### 1.3.3 redis
``` 
windows下redis安装 
http://www.runoob.com/redis/redis-install.html
进入redis目录
启动  redis-server.exe redis.windows.conf

登录  redis-cli.exe -h 127.0.0.1 -p 6379
	  redis-cli -a sudy12344


Redis 设置密码登录 
修改redis.windows.conf
#requirepass foobared。设置密码的方法就是去掉注释的#，把foobared替换成自己的密码即可，例如将密码设置为123456


服务自启动
redis-server --service-install redis.windows.conf --loglevel verbose 


问题 Invalid argument during startup: unknown conf file parameter : requirepass
redis 设置来密码，出现来这个错误，
把配置文件那一行的空格去掉
# requirepass foobared
改成
requirepass 123456


启动redis
./redis/src/redis-server ./redis/redis.conf &

关闭redis
./redis/src/redis-cli -h host -p port -a password shutdown
host值在./redis/redis.conf文件中搜索bind
port值在./redis/redis.conf文件中搜索port
password值在/redis/redis.conf文件中搜索requirepass

进入redis命令行
./redis/src/redis-cli -h host -p port -a password



[root@localhost src]# cd /opt/sudytech/custom/redis-2.8.17/
[root@localhost redis-2.8.17]# redis-server redis.conf              //启动redis                 
[root@localhost ~]# redis-cli       //进入redis客户端
127.0.0.1:6379> keys *              //取出所有的key 
(empty list or set)
127.0.0.1:6379> quit                //退出客户端   

127.0.0.1:6379> set key1 value1		//set
OK
127.0.0.1:6379> get key1			//get
"value1"
127.0.0.1:6379> del k1				//删除一个key
(integer) 1
127.0.0.1:6379> flushdb				//清空所有数据



Exception in thread "main" redis.clients.jedis.exceptions.JedisDataException: DENIED Redis is running in protected mode because protected mode is enabled。。。。

进入客户端设置模式：
redis-cli
config set protected-mode "no"

``` 
********************************************************


#### 1.3.4 tomcat命令 
```
Linux下Tomcat的启动、关闭、杀死进程   （进入tomcat的bin目录 启动 sh startup.sh）
	打开终端
	进入tomcat目录
	cd /Java/tomcat
	#执行
	bin/startup.sh #启动tomcat
	bin/shutdown.sh #停止tomcat
	tail -f logs/catalina.out #看tomcat的控制台输出；

	#看是否已经有tomcat在运行了
	ps -ef |grep tomcat 
	#如果有，用kill;
	kill -9 pid #pid 为相应的进程号

	例如 ps -ef |grep tomcat 输出如下

	sun 5144 1 0 10:21 pts/1 00:00:06 /java/jdk/bin/java -Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager -Djava.endorsed.dirs=/java/tomcat/common/endorsed -classpath :/java/tomcat/bin/bootstrap.jar:/java/tomcat/bin/commons-logging-api.jar -Dcatalina.base=/java/tomcat -Dcatalina.home=/java/tomcat -Djava.io.tmpdir=/java/tomcat/temp org.apache.catalina.startup.Bootstrap start

	则 5144 就为进程号 pid = 5144
	kill -9 5144 就可以彻底杀死tomcat
	
查看tomcat
	ps -ef |grep tomcat 
杀死tomcat 
	kill -9 pid        //pid 为相应的进程号
启动tomcat
    /opt/tech/appStore/apache-tomcat-6.0.35/bin/startup.sh

```
********************************************************************


#### 1.3.5 为每个tomcat配置单独的jdk
``` 
一、安装jdk，如jdk-6u45-linux-x64.bin
1、添加执行权限 
	chmod u+x jdk-6u45-linux-x64.bin
2、解压 
	./jdk-6u45-linux-x64.bin

二、配置tomcat的 ../bin/setclasspath.sh	在文件的开头添加以下
export JAVA_HOME=/opt/sudytech/jdk1.6.0_45  
export JRE_HOME=/opt/sudytech/jdk1.6.0_45/jre

三、重启tomcat



部署多个tomcat主要修改三个端口：

1.HTTP端口，默认8080，如下改为8081
<Connector port="8081" protocol="HTTP/1.1" 
               connectionTimeout="60000" 
               redirectPort="8443" disableUploadTimeout="false"  executor="tomcatThreadPool"  URIEncoding="UTF-8"/>


2.远程停服务端口，默认8005，如下改为8006
<Server port="8006" shutdown="SHUTDOWN">......


3.AJP端口，默认8009，如下改,8010
<Connector port="8010" protocol="AJP/1.3" redirectPort="8443" />

``` 
********************************************************************


#### 1.3.6 yum rpm安装卸载软件 
```
yum安装：
       # yum install 包名
yum卸载：
       # yum -y remove 包名
	   
查询所有安装软件     rpm -qa
查看是否安装软件     rpm -qa | grep java	  
卸载软件			 rpm -e    如果提示有依赖，可以加上 --nodeps 

[root@localhost openldap]# rpm -qa | grep openldap
openldap-2.4.44-15.el7_5.x86_64
openldap-servers-2.4.44-15.el7_5.x86_64
compat-openldap-2.3.43-5.el7.x86_64

[root@localhost openldap]# rpm -e --nodeps openldap-2.4.44-15.el7_5.x86_64
[root@localhost openldap]# rpm -e --nodeps openldap-servers-2.4.44-15.el7_5.x86_64
[root@localhost openldap]# rpm -e --nodeps compat-openldap-2.3.43-5.el7.x86_64
```
********************************************************************


#### 1.3.7 make安装卸载软件
``` 
用于linux源码安装软件，一般下载源码包得到文件：xxxx.tgz

1、解包软件
tar zxf xxxx.tgz

2、配置
cd xxxx
./configure ....

3、编译
make

4、安装
make install

5、卸载
make uninstall

``` 
********************************************************************


 <h3 id="IP"></h3>
 
### 1.4  IP及防火墙
#### 1.4.1 查看ip及端口是否可以访问、开放端口
```
	wget http://127.0.0.1:8080
 
	ping + ip： 查看某一个ip地址是否能够连通，如： ping 114.80.67.193
 
	telnet ip port ： 查看某一个机器上的某一个端口是否可以访问，如：telnet 114.80.67.193 8080
 
	netstat -nal  查看网络通信情况
 

查看端口占用
	netstat -ntlp   //查看当前所有tcp端口·
	netstat -ntulp |grep 80   //查看所有80端口使用情况·
	netstat -an | grep 3306   //查看所有3306端口使用情况·
	
	
查看开放的端口	
firewall-cmd --list-all

开放端口
firewall-cmd --zone=public --add-port=4789/udp --permanent
firewall-cmd --zone=public --add-port=80/tcp --permanent  
firewall-cmd --zone=public --add-port=80/udp –permanen
firewall-cmd --zone=public --add-port=8060/tcp --permanent

刷新
firewall-cmd --reload
```	
********************************************************************


#### 1.4.2 关闭centos的防火墙
``` 
一、firewall方式

	firewall-cmd --state    查看防火墙状态
	
	systemctl stop firewalld.service     关闭防火墙，centos7下
	
	systemctl disable firewalld.service    关闭开机启动


二、service方式

	查看防火墙状态： 

	[root@centos6 ~]# service iptables status

	iptables：未运行防火墙。

	开启防火墙：

	[root@centos6 ~]# service iptables start

	关闭防火墙：

	[root@centos6 ~]# service iptables stop
	
	 /etc/sysconfig/iptables

三、iptables方式

	先进入init.d目录，命令如下：

	[root@centos6 ~]# cd /etc/init.d/

	[root@centos6 init.d]# 

	然后

	查看防火墙状态：

	[root@centos6 init.d]# /etc/init.d/iptables status

	暂时关闭防火墙：

	[root@centos6 init.d]# /etc/init.d/iptables stop

	重启iptables：

	[root@centos6 init.d]# /etc/init.d/iptables restart


``` 
********************************************************************


 <h3 id="knowledge"></h3>
 
### 1.5  知识点
#### 1.5.1  查看内存

``` 
top
free -m  
cat /proc/meminfo 机器的内存使用信息
cat /proc/pid/maps pid为进程号，显示当前进程所占用的虚拟地址。
cat /proc/pid/statm 进程所占用的内存

[root@localhost webapps]# free 
             total       used       free     shared    buffers     cached
Mem:       4043716    3783532     260184          0      31424     340132
-/+ buffers/cache:    3411976     631740
Swap:      2096472     993204    1103268

输入：free

total:总计物理内存的大小

used:已使用多大

free:可用有多少

Shared:多个进程共享的内存总额

Buffers/cached:磁盘缓存的大小

第三行(-/+ buffers/cached)

used:已使用多大

free:可用有多少

第四行就不多解释了。

区别：第二行(mem)的used/free与第三行(-/+ buffers/cache) used/free的区别。 这两个的区别在于使用的角度来看，第一行是从OS的角度来看，因为对于OS，buffers/cached 都是属于被使用，所以他的可用内存是260184KB,已用内存是3783532KB,第三行所指的是从应用程序角度来看，对于应用程序来说，buffers/cached 是等于可用的，因为buffer/cached是为了提高文件读取的性能，当应用程序需在用到内存的时候，buffer/cached会很快地被回收。所以从应用程序的角度来说，可用内存=系统free memory+buffers+cached。

 如上例：631740=260184+31424+340132
``` 
********************************************************************


#### 1.5.2  linux标准输入输出2>&1
```
linux标准输入输出2>&1

 /home/share/timerSearch/timerSearchDB.sh >> /home/share/timerSearch/record.txt 2>&1
 
linux中有三种标准输入输出，分别是STDIN，STDOUT，STDERR，对应的数字是0，1，2。
     STDIN是标准输入，默认从键盘读取信息；STDOUT是标准输出，默认将输出结果输出至终端；STDERR是标准错误，默认将输出结果输出至终端。
     由于STDOUT与STDERR都会默认显示在终端上，为了区分二者的信息，就有了编号的0，1，2的定义，用1表示STDOUT，2表示STDERR。
     2>&1，指将标准输出、标准错误指定为同一输出路径

eg1:cat >>filetest 2>&1 <<END      -------建立filetest文件，当输入遇到END时，退出

eg2:
     1、以普通用户执行 find /etc -name passwd 命令，默认会将命令的执行结果（STDOUT）与错误信息（STDERR）都输出至终端显示器。
     2、执行find /etc -name passwd >find.out 2>find.err，会将STDOUT与STDERR分别存放至find.out和find.err中。该命令也可以写成下面三种形式
          find /etc -name passwd 1>find.out 2>find.err
          find /etc -name passwd 2>find.err >find.out
          find /etc -name passwd 2>find.err 1>find.out
     3、若要将所有标准输出及标准错误都输出至文件，可用&表示全部1和2的信息，eg：
          find /etc -name passwd &>find.all 或 find /etc -name passwd >find.all 2>&1
     4、2>&1 ---标准错误重新定向到标准输出
     5、用法：find /etc -name passwd &2>&1 |less
          可分解成
          find /etc -name passwd & 表示前面的命令放到后台执行。
          2>&1 |less 表示将标准错误重定向至标准输出，并用less进行分页显示
		  
https://www.cnblogs.com/jacob-tian/p/6110606.html

```
********************************************************************


#### 1.5.3  定时执行脚本[笔记](https://github.com/scott180/MyNotes/blob/master/bash/%E5%AE%9A%E6%97%B6%E6%89%A7%E8%A1%8C%E8%84%9A%E6%9C%AC/%E5%AE%9A%E6%97%B6%E6%89%A7%E8%A1%8C%E8%84%9A%E6%9C%AC.txt )
```
定时查询docker的mysql数据库并保存
#!/bin/bash
#file=/home/share/timerSearch/record.txt
#crontab -uroot -e
#*/1 * * * * /bin/bash /home/share/timerSearch/timerSearchDB.sh >> /home/share/timerSearch/record.txt 2>&1
echo "===============begin=========================" 
echo "定时查询脚本启动了。。。" 
date "+%Y-%m-%d %H:%M:%S" 

docker_name=mobile_ucp_db_1
sql="use UCPPLUS;select id,loginName,name,password,idcard,field29 from T_USER where loginName='admin'\G;"
#docker exec -it ${docker_name} mysql -uroot -pSudy.web123 -e $sql  >> $file
docker exec -i mobile_ucp_db_1 mysql -uroot -pSudy.web123 -e "select now();use UCPPLUS;select id,loginName,name,password,idcard,field29 from T_USER where loginName='admin'\G;"  >> /home/share/timerSearch/recordDB.txt

echo "" 
echo "" 




#crontab -uroot -e
0 3 * * 5 /data/sudytech/shell/copyCasSecret.sh

说明：
分钟   小时   日   月   星期   命令
*        *      *    *     *       *

第1列表示分钟1～59 每分钟用*或者 */1表示
第2列表示小时1～23（0表示0点）
第3列表示日期1～31
第4列 表示月份1～12
第5列标识号星期0～6（0表示星期天）
第6列要运行的命令

```
********************************************************************


#### 1.5.4 文件权限 
```
查看文件属性 	ls -l test.sh
赋予执行权限    chmod +x test.sh
赋予全部权限    chmod 777 test.sh

改变文件属性（二进制）      chmod #chmod 664 chap1.txt	       110110100  
改变文件属性（字母）        chmod u=rw,g=rw,o=r chap1.txt	   r w x
改变文件所属用户		    chown user1 chap1.txt
改变文件所属用户及所属组    chown user1:root chap1.txt
改变文件所属组              chgrp root chap1.txt


Linux系统是个多用户系统，应该能做到不同的用户能同时访问不同的文件，因此一定要有文件权限控制机制。Linux系统的权限控制机制和Windows的权限控制机制有着很大的差别。Linux的文件或目录都被一个用户拥有时，这个用户称为文件的拥有者(或所有者)，同时文件还被指定的用户组所拥有，这个用户组称为文件所属组。 

用户 u --所属组 g --其他用户 o -- 所有用户 a
 user - group - other - all

要说明的是，一个用户可以是不同组的成员，这可以由管理员控制，我们将在用户管理这一章介绍如何控制的问题。文件的权限由权限标志来决定，权限标志决定了文件的拥有者、文件的所属组、其他用户对文件访问的能力。可以使用“ls –l”命令来显示权限标志。例如：
[test @redflag test]$ls -l
-rw-rw-r-- 1 longkey root 16 20A 24 22:23 chap1.txt
本例中，文件chap1.txt的拥有者是longkey，所属组是root。这里我们特别关心的是输出行前面的第1～10个字符。第1个字符代表文件类别，第2～4个字符“rw-”是文件拥有者的权限，第5～7个字符“rw-”是文件所属组的权限，第8～10个字符“r--”是其他用户(即除了root用户和longkey用户组里的用户之外的用户)文件拥有者的权限。而权限均用三个字符表示，依次为读(r)、写(w)、执行(x)，如果某一位为“-”，则表示没有相应的权限，例如：“rw-”表示有读、写的权限，没有执行的权限。在本例中，文件拥有者longkey用户对文件有读、写的权限，root组的所有用户对文件也有读、写的权限，而其他用户对文件只有读的权限。

设定文件权限时，在模式中常用以下的字母代表用户或用户组：
u——文件的拥有者；
g——文件的所属组；
o——其他用户；
a——代表所有用户(即u+g+o)。
权限用以下字符表示：
r ——读权限；
w——写权限；
x——执行权限；
最后要指明是增加(+)还是减少(-)权限，或是绝对权限(=)。

 [root @redflag /root]chmod o+w chap1.txt
chap1.txt的权限由原来的“rw-rw-r--”变为“rw-rw-rw-”，表示增加其他用户对文件的写权限。
 
 [root @redflag /root]chmod u=rw,g=rw,o=r chap1.txt  chap1.txt的权限变为“rwxrw-r---”，不论原来的权限是什么，这表示拥有者对文件有读、写的权限，所属组的用户对文件也有读、写的权限，而其他用户只有读的权限。

我们在以上设置权限时，用字符表示权限和用户，实际上我们也经常使用八进制来表示。读、写、执行依次各自对应一个二进制位“???”，如果某位为“0”，则表示无权限；如果某位为“1”，则表示有权限。例如：文件权限为r---w---x时，用二进制表示为100010001，用十进制可以表示为421。例如：
         [root @redflag /root]#chmod 664 chap1.txt 
 等同于：
  [root @redflag /root]#chmod u=rw,g=rw,o=r chap1.txt
		

chown 用户名 文件或目录名——改变文件(或目录)的拥有者或所属组
       例如：
     [root @redflag /root]#chown longkey chap1.txt
把文件chap1.txt的拥有者改为longkey用户。
     [root @redflag /root]#chown longkey:root chap1.txt
把文件的拥有者改为longkey用户，同时文件的所属组改为root组。


chgrp组 文件或目录——改变文件或目录的所属组
	 chown可以同时改变文件拥有者和所属者，chgrp只具有改变所属组的功能。例如：
	[root @redflag /root]#chgrp root chap1.txt
		文件chap1.txt的所属组设为root组。
		
```
********************************************************************
 
 
####  1.5.5 用户和组的管理
```
su         切换root
su user1   切换用户

groups         查看当前用户所在组
groups  user1  查看user1用户所在的组
whoami         查看当前登录用户名

/etc/group  文件包含所有组及用户
/etc/shadow和/etc/passwd系统存在的所有用户名

创建用户      useradd  user1;
设置用户密码  passwd user1;
删除用户      userdel user1;
删除用户（包括主目录文件 /home/user1）  userdel -r user1;

groupadd testgroup  组的添加
groupdel testgroup  组的删除

只有root和组管理员能够改变组的成员：
gpasswd –a user1 users    把 user1加入users组
gpasswd –d user1 users    把 user1退出users组
groupmod –n user users    修改组名user为users

锁定用户  passwd -l user1
解锁用户  passwd -u user1

用户添加到组
usermod -a -G groupA user
-a 代表 append， 也就是 将自己添加到 用户组groupA 中，而不必离开 其他用户组
 
```
#### 1.5.6 问题
```
查看句柄
	    ulimit -n  
	    
修改句柄  有三种办法: 
https://blog.csdn.net/skieske/article/details/79261469

①:ulimit -n 65536 
这种是一次性的,当服务器重启或者重新登录服务器就会变成1024

②:vi /etc/security/limits.conf 
修改linux系统参数。添加

*　　soft　　nofile　　65536
*　　hard　　nofile　　65536

这种办法需要重启服务器 

③:vim /etc/profile 
添加/或者修改: 
ulimit -SHn 65536 

然后使修改生效: 
source /etc/profile 

然后再ulimit -a


建议三种方法都要试一下

```

```
	history 历史记录显示时间        
	在/etc/profile 中增加  export HISTTIMEFORMAT="%Y-%m-%d %H:%M:%S "
	写入环境变量		   source /etc/profile
```	
	
```
centos7虚拟机不能上网    
	在存储linux目录的CentOS.vmx文件加入  ethernet0.virtualDev = "e1000"  再重启虚拟机
	
linux虚拟机上传下载文件  
	打开虚拟机linux，使用命令 ifconfig 查看ip，再使用xshell连接。
```
	
```
微信企业号连接超时： connect timed out
  wget https://qyapi.weixin.qq.com/cgi-bin/gettoken
  ping qyapi.weixin.qq.com
  
  1、可能是防火墙打开了
  2、/etc/hosts  策略配置错了
```
********************************************************************


## 2、Shell编程 <h2 id="shell"></h2>

### 2.1、shell概述及优势 <h3 id="shellIntroduce"></h3>
```java
==============================================================
  Shell是一个命令语言解释器，它拥有自己内建的Shell命令集，Shell也能被系统中其他应用程序调用。
  当普通用户成功登录后，系统将执行一个称为Shell的程序。正是Shell进程提供了命令行提示符。作为默认值，对普通用户用“$”作提示符，对超级用户(root)用“#”作提示符。
 
  Linux中的Shell有多种类型，其中最常见的是Bourne Shell (sh)、C Shell (csh)和Korn Shell (ksh)。三种Shell各有优缺点。Bourne Shell是Unix最初始的Shell，并且在每种Unix上都可以使用。Bourne Shell在Shell编程方面相当优秀，但在处理与用户的交互方面做得不如其他几种Shell。Bash(Bourne Again Shell)是Bourne Shell的扩展，与Bourne Shell完全向下兼容，并且增加了许多特性。它还包含了很多C Shell和Korn Shell中的优点，有灵活和强大的编程接口，同时又有很友好的用户界面。
  C Shell是一种比Bourne Shell更适于编程的Shell，它的语法与C语言很相似。Linux为喜欢使用C Shell的人员提供了Tcsh。Tcsh是C Shell的一个扩展版本。Tcsh包括命令行编辑、可编程单词补全、拼写矫正、历史命令替换、作业控制和类似C语言的语法，它提供比Bourne Shell更多的提示符参数。
  Korn Shell集合了C Shell和Bourne Shell的优点并且和Bourne Shell完全兼容。Linux系统提供了pdksh(ksh的扩展)，它支持任务控制，可以在命令行上挂起、后台执行、唤醒或终止程序。


	Bash是大多数Linux系统(包括红旗Linux系统)的默认Shell。Bash有以下的优点：
	(1) 补全命令。当你在Bash命令提示符下输入命令或程序名时，你不必输全命令或程序名，按【Tab】键，Bash将自动补全命令或程序名。
	(2) 通配符。在Bash下可以使用通配符“*”和“？”。“*”可以替代多个字符，而“？”则替代一个字符。
    (3) 历史命令。Bash能自动跟踪用户每次输入的命令，并把输入的命令保存在历史列表缓冲区。缓冲区的大小由HISTSIZE变量控制。当用户每次登录后，home目录下的“.bash_history”文件将初始化历史列表缓冲区。也能通过history和fc命令执行、编辑历史命令。
	(4) 别名。在Bash下，可用alias和unalias命令给命令或可执行程序起别名和清除别名，这样就可以用自己习惯的方式输入命令。
	``` 
     查看所有别名   alias
	 添加别名       alias test="tar -zcvf "
	 删除别名       unalias test
	``` 
    (5)输入/输出重定向。输入重定向用于改变命令的输入，输出重定向用于改变命令的输出。输出重定向更为常用，它经常用于将命令的结果输入到文件中，而不是屏幕上。输入重定向的命令是“<”，输出重定向的命令是“>”
	```  
	① 输入重定向：
	[root@redflag /root]#wc</etc/passwd
	20 23 726
	② 输出重定向:
	[root@redflag /root]#ls>dir.out                        
	上面命令将ls命令的输出保存为文件dir.out。
	[root@redflag /root]#ls>>dir1.out	 “>>”表示要将一条命令的输出结果追加到文件dir1.out的后面，该文件的原有内容不被破坏，如果使用“>”，则文件原有内容被覆盖。
	``` 
     (6) 管道。管道用于将一系列的命令连接起来，也就是把前面命令的输出作为后面命令的输入。管道的命令是“|”。
    ``` 
	root@redflag /root]# cat dir.out|grep "test "|wc –l
	管道将cat命令(列出一个文件的内容)的输出送给grep命令，grep命令在输入里查找单词test，grep的输出则是所有包含单词test的行，这个输出又被送给wc命令，wc命令统计出输入中的行数。
    ``` 
	(7) 提示符。
	(8) 作业控制。
	
    最简单的方式是执行echo命令，查询系统环境变量的值：
    [root@redflag /root]# echo $SHELL
    /bin/bash
	

```

### 2.2、shell创建、执行 <h3 id="shellExecute"></h3>
```java
==============================================================
	Shell 脚本（shell script），是一种为 shell 编写的脚本程序。业界所说的 shell 通常都是指 shell 脚本。
	
一、创建 Shell 脚本
	打开文本编辑器(可以使用 vi/vim 命令来创建文件)，新建一个文件 test.sh，扩展名为 sh（sh代表shell），扩展名并不影响脚本执行，见名知意就好，如果你用 php 写 shell 脚本，扩展名就用 php 好了。
	输入一些代码，一般是这样：
	```
    	#!/bin/bash
    	echo "Hello World !"
    ```
	#! 是一个约定的标记，它告诉系统这个脚本需要什么解释器来执行，即使用哪一种 Shell。
	① 如果Shell脚本的第一个非空白字符不是“#”，则它会使用Bourne Shell。
    ② 如果Shell脚本的第一个非空白字符是“#”，但不是以“#！”开头时，则它会使用C Shell。
	③ 如果Shell脚本以“#！”开头，则“#！”后面所跟的字符串就是所使用Shell的绝对路径名。Bourne Shell的路径名称为/bin/sh，而C Shell则为/bin/csh。
	echo 命令用于向窗口输出文本。
	
	
二、运行 Shell 脚本有两种方法：
	1、作为可执行程序
	将上面的代码保存为 test.sh，并 cd 到相应目录：
	```
	chmod +x ./test.sh  #使脚本具有执行权限
	./test.sh  #执行脚本
	```
	注意，一定要写成 ./test.sh，而不是 test.sh，运行其它二进制的程序也一样，直接写 test.sh，linux 系统会去 PATH 里寻找有没有叫 test.sh 的，而只有 /bin, /sbin, /usr/bin，/usr/sbin 等在 PATH 里，你的当前目录通常不在 PATH 里，所以写成 test.sh 是会找不到命令的，要用 ./test.sh 告诉系统说，就在当前目录找。
	
	2、作为解释器参数
	这种运行方式是，直接运行解释器，其参数就是 shell 脚本的文件名，如：
	```
	/bin/sh test.sh
	/bin/php test.php
	```
	这种方式运行的脚本，不需要在第一行指定解释器信息，写了也没用。
 
==============================================================
```


### 2.3、shell 变量、引号、数组、传递参数 <h3 id="shellParams"></h3>
```java
==============================================================
http://www.runoob.com/linux/linux-shell-variable.html 转自菜鸟教程

test="测试引号"
echo "双引号 this is a ${test}"
echo '单引号 this is a ${test}'
echo "反引号 当前目录pwd `pwd` "

`变量：`
注意，变量名和等号之间不能有空格，这可能和你熟悉的所有编程语言都不一样。同时，变量名的命名须遵循如下规则：
首个字符必须为字母（a-z，A-Z）。
中间不能有空格，可以使用下划线（_）。
不能使用标点符号。
不能使用bash里的关键字（可用help命令查看保留关键字）。

#使用一个定义过的变量，只要在变量名前面加美元符号即可，如：
your_name="qinjx"
echo $your_name
echo ${your_name}
变量名外面的花括号是可选的，加不加都行，加花括号是为了帮助解释器识别变量的边界

`单引号:`
#单引号里的任何字符都会原样输出，单引号字符串中的变量是无效的；
单引号字串中不能出现单引号（对单引号使用转义符后也不行）

`双引号:`
	your_name='qinjx'
	str="Hello, I know your are \"$your_name\"! \n"
双引号的优点：
#双引号里可以有变量
双引号里可以出现转义字符

`数组:`
#!/bin/sh
arr=(12 '单引号' “双引号” 22)
echo "第二个值：" ${arr[1]}
echo “所有元素：” ${arr[@]}
echo "数组长度： ${#arr[@]}"

数组赋值 my_array[0]=A 

`注释`
以"#"开头的行就是注释，会被解释器忽略。

'传递参数：'
参数处理	说明
$#	传递到脚本的参数个数
$*	以一个单字符串显示所有向脚本传递的参数。
如"$*"用「"」括起来的情况、以"$1 $2 … $n"的形式输出所有参数。
$$	脚本运行的当前进程ID号
$!	后台运行的最后一个进程的ID号
$@	与$*相同，但是使用时加引号，并在引号中返回每个参数。
如"$@"用「"」括起来的情况、以"$1" "$2" … "$n" 的形式输出所有参数。
$-	显示Shell使用的当前选项，与set命令功能相同。
$?	显示最后命令的退出状态。0表示没有错误，其他任何值表明有错误。
```
|参数处理        | 说明   | 
| ------   | -----  | 
| `$#`  | `传递到脚本的参数个数` |  
| `$*`  | `以一个单字符串显示所有向脚本传递的参数` |  
| `$@`  | `与$*相同，但是使用时加引号，并在引号中返回每个参数` |  
```
$* 与 $@ 区别：
相同点：都是引用所有参数。
不同点：只有在双引号中体现出来。假设在脚本运行时写了三个参数 1、2、3，，则 " * " 等价于 "1 2 3"（传递了一个参数），而 "@" 等价于 "1" "2" "3"（传递了三个参数）。
#!/bin/bash
# author:菜鸟教程
# url:www.runoob.com

echo "传递参数个数 \$# $#"
echo "-- \$* 演示 ---"
for i in "$*"; do
    echo $i
done

echo "-- \$@ 演示 ---"
for i in "$@"; do
    echo $i
done

执行脚本，输出结果如下所示：
$ chmod +x test.sh 
$ ./test.sh 1 2 3
#或/bin/sh test.sh 1 2 3
-- $* 演示 ---
1 2 3
-- $@ 演示 ---
1
2
3

==============================================================
```

### 2.4、shell 运算符 <h3 id="shellOperator"></h3>
```java
==============================================================

原生bash不支持简单的数学运算，但是可以通过其他命令来实现，例如 awk 和 expr，expr 最常用。
expr 是一款表达式计算工具，使用它能完成表达式的求值操作。
例如，两个数相加(注意使用的是反引号 ` 而不是单引号 ')：

#!/bin/bash
val=`expr 2 + 2`
echo "两数之和为 : $val"

两点注意：
表达式和运算符之间要有空格，例如 2+2 是不对的，必须写成 2 + 2，这与我们熟悉的大多数编程语言不一样。
完整的表达式要被 ` ` 包含，注意这个字符不是常用的单引号，在 Esc 键下边。


EQ 就是 EQUAL等于
NQ 就是 NOT EQUAL不等于 
GT 就是 GREATER THAN大于　 
LT 就是 LESS THAN小于 
GE 就是 GREATER THAN OR EQUAL 大于等于 
LE 就是 LESS THAN OR EQUAL 小于等于
```
#### 2.4.1、算术运算符
```
`算术运算符`
下表列出了常用的算术运算符，假定变量 a 为 10，变量 b 为 20：
运算符	说明	举例
+	加法	`expr $a + $b` 结果为 30。
-	减法	`expr $a - $b` 结果为 -10。
*	乘法	`expr $a \* $b` 结果为  200。
/	除法	`expr $b / $a` 结果为 2。
%	取余	`expr $b % $a` 结果为 0。
=	赋值	a=$b 将把变量 b 的值赋给 a。
==	相等。用于比较两个数字，相同则返回 true。	[ $a == $b ] 返回 false。
!=	不相等。用于比较两个数字，不相同则返回 true。	[ $a != $b ] 返回 true。

#注意：条件表达式要放在方括号之间，并且要有空格，例如: [$a==$b] 是错误的，必须写成 [ $a == $b ]。

算术运算符实例如下：
#!/bin/bash
# author:菜鸟教程
# url:www.runoob.com

a=10
b=20

val=`expr $a + $b`
echo "a + b : $val"

val=`expr $a - $b`
echo "a - b : $val"

val=`expr $a \* $b`
echo "a * b : $val"

val=`expr $b / $a`
echo "b / a : $val"

val=`expr $b % $a`
echo "b % a : $val"

if [ $a == $b ]
then
   echo "a 等于 b"
fi
if [ $a != $b ]
then
   echo "a 不等于 b"
fi
执行脚本，输出结果如下所示：
a + b : 30
a - b : -10
a * b : 200
b / a : 2
b % a : 0
a 不等于 b

注意：
乘号(*)前边必须加反斜杠(\)才能实现乘法运算；
if...then...fi 是条件语句，后续将会讲解。
在 MAC 中 shell 的 expr 语法是：$((表达式))，此处表达式中的 "*" 不需要转义符号 "\" 。
```

#### 2.4.2、关系运算符
```
`关系运算符`
关系运算符只支持数字，不支持字符串，除非字符串的值是数字。
下表列出了常用的关系运算符，假定变量 a 为 10，变量 b 为 20：

运算符	说明	举例
-eq	检测两个数是否相等，相等返回 true。	[ $a -eq $b ] 返回 false。
-ne	检测两个数是否相等，不相等返回 true。	[ $a -ne $b ] 返回 true。
-gt	检测左边的数是否大于右边的，如果是，则返回 true。	[ $a -gt $b ] 返回 false。
-lt	检测左边的数是否小于右边的，如果是，则返回 true。	[ $a -lt $b ] 返回 true。
-ge	检测左边的数是否大于等于右边的，如果是，则返回 true。	[ $a -ge $b ] 返回 false。
-le	检测左边的数是否小于等于右边的，如果是，则返回 true。	[ $a -le $b ] 返回 true。

关系运算符实例如下：
#!/bin/bash
# author:菜鸟教程
# url:www.runoob.com

a=10
b=20

if [ $a -eq $b ]
then
   echo "$a -eq $b : a 等于 b"
else
   echo "$a -eq $b: a 不等于 b"
fi
if [ $a -ne $b ]
then
   echo "$a -ne $b: a 不等于 b"
else
   echo "$a -ne $b : a 等于 b"
fi
if [ $a -gt $b ]
then
   echo "$a -gt $b: a 大于 b"
else
   echo "$a -gt $b: a 不大于 b"
fi
if [ $a -lt $b ]
then
   echo "$a -lt $b: a 小于 b"
else
   echo "$a -lt $b: a 不小于 b"
fi
if [ $a -ge $b ]
then
   echo "$a -ge $b: a 大于或等于 b"
else
   echo "$a -ge $b: a 小于 b"
fi
if [ $a -le $b ]
then
   echo "$a -le $b: a 小于或等于 b"
else
   echo "$a -le $b: a 大于 b"
fi
执行脚本，输出结果如下所示：
10 -eq 20: a 不等于 b
10 -ne 20: a 不等于 b
10 -gt 20: a 不大于 b
10 -lt 20: a 小于 b
10 -ge 20: a 小于 b
10 -le 20: a 小于或等于 b
```

#### 2.4.3、布尔运算符
```
`布尔运算符`
下表列出了常用的布尔运算符，假定变量 a 为 10，变量 b 为 20：
运算符	说明	举例
!	非运算，表达式为 true 则返回 false，否则返回 true。	[ ! false ] 返回 true。
-o	或运算，有一个表达式为 true 则返回 true。	[ $a -lt 20 -o $b -gt 100 ] 返回 true。
-a	与运算，两个表达式都为 true 才返回 true。	[ $a -lt 20 -a $b -gt 100 ] 返回 false。
实例
布尔运算符实例如下：
#!/bin/bash
# author:菜鸟教程
# url:www.runoob.com

a=10
b=20

if [ $a != $b ]
then
   echo "$a != $b : a 不等于 b"
else
   echo "$a != $b: a 等于 b"
fi
if [ $a -lt 100 -a $b -gt 15 ]
then
   echo "$a 小于 100 且 $b 大于 15 : 返回 true"
else
   echo "$a 小于 100 且 $b 大于 15 : 返回 false"
fi
if [ $a -lt 100 -o $b -gt 100 ]
then
   echo "$a 小于 100 或 $b 大于 100 : 返回 true"
else
   echo "$a 小于 100 或 $b 大于 100 : 返回 false"
fi
if [ $a -lt 5 -o $b -gt 100 ]
then
   echo "$a 小于 5 或 $b 大于 100 : 返回 true"
else
   echo "$a 小于 5 或 $b 大于 100 : 返回 false"
fi
执行脚本，输出结果如下所示：
10 != 20 : a 不等于 b
10 小于 100 且 20 大于 15 : 返回 true
10 小于 100 或 20 大于 100 : 返回 true
10 小于 5 或 20 大于 100 : 返回 false
逻辑运算符
以下介绍 Shell 的逻辑运算符，假定变量 a 为 10，变量 b 为 20:
运算符	说明	举例
&&	逻辑的 AND	[[ $a -lt 100 && $b -gt 100 ]] 返回 false
||	逻辑的 OR	[[ $a -lt 100 || $b -gt 100 ]] 返回 true
实例
逻辑运算符实例如下：
#!/bin/bash
# author:菜鸟教程
# url:www.runoob.com

a=10
b=20

if [[ $a -lt 100 && $b -gt 100 ]]
then
   echo "返回 true"
else
   echo "返回 false"
fi

if [[ $a -lt 100 || $b -gt 100 ]]
then
   echo "返回 true"
else
   echo "返回 false"
fi
执行脚本，输出结果如下所示：
返回 false
返回 true
```

#### 2.4.4、字符串运算符
```
`字符串运算符`
下表列出了常用的字符串运算符，假定变量 a 为 "abc"，变量 b 为 "efg"：
运算符	说明	举例
=	检测两个字符串是否相等，相等返回 true。	[ $a = $b ] 返回 false。
!=	检测两个字符串是否相等，不相等返回 true。	[ $a != $b ] 返回 true。
-z	检测字符串长度是否为0，为0返回 true。	[ -z $a ] 返回 false。
-n	检测字符串长度是否为0，不为0返回 true。	[ -n $a ] 返回 true。
str	检测字符串是否为空，不为空返回 true。	[ $a ] 返回 true。
实例
字符串运算符实例如下：
#!/bin/bash
# author:菜鸟教程
# url:www.runoob.com

a="abc"
b="efg"

if [ $a = $b ]
then
   echo "$a = $b : a 等于 b"
else
   echo "$a = $b: a 不等于 b"
fi
if [ $a != $b ]
then
   echo "$a != $b : a 不等于 b"
else
   echo "$a != $b: a 等于 b"
fi
if [ -z $a ]
then
   echo "-z $a : 字符串长度为 0"
else
   echo "-z $a : 字符串长度不为 0"
fi
if [ -n $a ]
then
   echo "-n $a : 字符串长度不为 0"
else
   echo "-n $a : 字符串长度为 0"
fi
if [ $a ]
then
   echo "$a : 字符串不为空"
else
   echo "$a : 字符串为空"
fi
执行脚本，输出结果如下所示：
abc = efg: a 不等于 b
abc != efg : a 不等于 b
-z abc : 字符串长度不为 0
-n abc : 字符串长度不为 0
abc : 字符串不为空
```

#### 2.4.5、文件测试运算符
```
`文件测试运算符`
文件测试运算符用于检测 Unix 文件的各种属性。
属性检测描述如下：

操作符	说明	举例
-b file	检测文件是否是块设备文件，如果是，则返回 true。	[ -b $file ] 返回 false。
-c file	检测文件是否是字符设备文件，如果是，则返回 true。	[ -c $file ] 返回 false。
-d file	检测文件是否是目录，如果是，则返回 true。	[ -d $file ] 返回 false。
-f file	检测文件是否是普通文件（既不是目录，也不是设备文件），如果是，则返回 true。	[ -f $file ] 返回 true。
-g file	检测文件是否设置了 SGID 位，如果是，则返回 true。	[ -g $file ] 返回 false。
-k file	检测文件是否设置了粘着位(Sticky Bit)，如果是，则返回 true。	[ -k $file ] 返回 false。
-p file	检测文件是否是有名管道，如果是，则返回 true。	[ -p $file ] 返回 false。
-u file	检测文件是否设置了 SUID 位，如果是，则返回 true。	[ -u $file ] 返回 false。
-r file	检测文件是否可读，如果是，则返回 true。	[ -r $file ] 返回 true。
-w file	检测文件是否可写，如果是，则返回 true。	[ -w $file ] 返回 true。
-x file	检测文件是否可执行，如果是，则返回 true。	[ -x $file ] 返回 true。
-s file	检测文件是否为空（文件大小是否大于0），不为空返回 true。	[ -s $file ] 返回 true。
-e file	检测文件（包括目录）是否存在，如果是，则返回 true。	[ -e $file ] 返回 true。

实例
变量 file 表示文件"/var/www/runoob/test.sh"，它的大小为100字节，具有 rwx 权限。下面的代码，将检测该文件的各种属性：
#!/bin/bash
# author:菜鸟教程
# url:www.runoob.com

file="/var/www/runoob/test.sh"
if [ -r $file ]
then
   echo "文件可读"
else
   echo "文件不可读"
fi
if [ -w $file ]
then
   echo "文件可写"
else
   echo "文件不可写"
fi
if [ -x $file ]
then
   echo "文件可执行"
else
   echo "文件不可执行"
fi
if [ -f $file ]
then
   echo "文件为普通文件"
else
   echo "文件为特殊文件"
fi
if [ -d $file ]
then
   echo "文件是个目录"
else
   echo "文件不是个目录"
fi
if [ -s $file ]
then
   echo "文件不为空"
else
   echo "文件为空"
fi
if [ -e $file ]
then
   echo "文件存在"
else
   echo "文件不存在"
fi
执行脚本，输出结果如下所示：
文件可读
文件可写
文件可执行
文件为普通文件
文件不是个目录
文件不为空
文件存在


==============================================================
```

### 2.5、shell 常用命令 <h3 id="shellCommonCommand"></h3>
#### 2.5.1、shell echo命令
```java
==============================================================
Shell echo命令
Shell 的 echo 指令与 PHP 的 echo 指令类似，都是用于字符串的输出。命令格式：
echo string
您可以使用echo实现更复杂的输出格式控制。

1.显示普通字符串:
echo "It is a test"
这里的双引号完全可以省略，以下命令与上面实例效果一致：
echo It is a test

2.显示转义字符
echo "\"It is a test\""
结果将是:
"It is a test"
同样，双引号也可以省略

3.显示变量
read 命令从标准输入中读取一行,并把输入行的每个字段的值指定给 shell 变量
#!/bin/sh
read name 
echo "$name It is a test"
以上代码保存为 test.sh，name 接收标准输入的变量，结果将是:
[root@www ~]# sh test.sh
OK                     #标准输入
OK It is a test        #输出

4.显示换行
echo -e "OK! \n" # -e 开启转义
echo "It it a test"
输出结果：
OK!

It it a test

5.显示不换行
#!/bin/sh
echo -e "OK! \c" # -e 开启转义 \c 不换行
echo "It is a test"
输出结果：
OK! It is a test

6.显示结果定向至文件
echo "It is a test" > myfile

7.原样输出字符串，不进行转义或取变量(用单引号)
echo '$name\"'
输出结果：
$name\"

8.显示命令执行结果
echo `date`
注意： 这里使用的是反引号 `, 而不是单引号 '。
结果将显示当前日期

==============================================================
```
#### 2.5.2、shell printf命令
```java
==============================================================
printf 命令模仿 C 程序库（library）里的 printf() 程序。
标准所定义，因此使用printf的脚本比使用echo移植性好。
printf 使用引用文本或空格分隔的参数，外面可以在printf中使用格式化字符串，还可以制定字符串的宽度、左右对齐方式等。默认printf不会像 echo 自动添加换行符，我们可以手动添加 \n。
printf 命令的语法：
printf  format-string  [arguments...]
参数说明：
format-string: 为格式控制字符串
arguments: 为参数列表。
实例如下：
$ echo "Hello, Shell"
Hello, Shell
$ printf "Hello, Shell\n"
Hello, Shell
$
接下来,我来用一个脚本来体现printf的强大功能：
#!/bin/bash
# author:菜鸟教程
# url:www.runoob.com
 
printf "%-10s %-8s %-4s\n" 姓名 性别 体重kg  
printf "%-10s %-8s %-4.2f\n" 郭靖 男 66.1234 
printf "%-10s %-8s %-4.2f\n" 杨过 男 48.6543 
printf "%-10s %-8s %-4.2f\n" 郭芙 女 47.9876 
执行脚本，输出结果如下所示：
姓名     性别   体重kg
郭靖     男      66.12
杨过     男      48.65
郭芙     女      47.99
%s %c %d %f都是格式替代符
%-10s 指一个宽度为10个字符（-表示左对齐，没有则表示右对齐），任何字符都会被显示在10个字符宽的字符内，如果不足则自动以空格填充，超过也会将内容全部显示出来。
%-4.2f 指格式化为小数，其中.2指保留2位小数。
更多实例：
#!/bin/bash
# author:菜鸟教程
# url:www.runoob.com
 
# format-string为双引号
printf "%d %s\n" 1 "abc"

# 单引号与双引号效果一样 
printf '%d %s\n' 1 "abc" 

# 没有引号也可以输出
printf %s abcdef

# 格式只指定了一个参数，但多出的参数仍然会按照该格式输出，format-string 被重用
printf %s abc def

printf "%s\n" abc def

printf "%s %s %s\n" a b c d e f g h i j

# 如果没有 arguments，那么 %s 用NULL代替，%d 用 0 代替
printf "%s and %d \n" 
执行脚本，输出结果如下所示：
1 abc
1 abc
abcdefabcdefabc
def
a b c
d e f
g h i
j  
 and 0
printf的转义序列
序列	说明
\a	警告字符，通常为ASCII的BEL字符
\b	后退
\c	抑制（不显示）输出结果中任何结尾的换行字符（只在%b格式指示符控制下的参数字符串中有效），而且，任何留在参数里的字符、任何接下来的参数以及任何留在格式字符串中的字符，都被忽略
\f	换页（formfeed）
\n	换行
\r	回车（Carriage return）
\t	水平制表符
\v	垂直制表符
\\	一个字面上的反斜杠字符
\ddd	表示1到3位数八进制值的字符。仅在格式字符串中有效
\0ddd	表示1到3位的八进制值字符
实例
$ printf "a string, no processing:<%s>\n" "A\nB"
a string, no processing:<A\nB>

$ printf "a string, no processing:<%b>\n" "A\nB"
a string, no processing:<A
B>

$ printf "www.runoob.com \a"
www.runoob.com $                  #不换行

笔记列表

%d %s %c %f 格式替代符详解:
d: Decimal 十进制整数 -- 对应位置参数必须是十进制整数，否则报错！
s: String 字符串 -- 对应位置参数必须是字符串或者字符型，否则报错！
c: Char 字符 -- 对应位置参数必须是字符串或者字符型，否则报错！
f: Float 浮点 -- 对应位置参数必须是数字型，否则报错！
如：其中最后一个参数是 "def"，%c 自动截取字符串的第一个字符作为结果输出。
$  printf "%d %s %c\n" 1 "abc" "def"
1 abc d
==============================================================
```

#### 2.5.3、shell test命令
```java
==============================================================
Shell中的 test 命令用于检查某个条件是否成立，它可以进行数值、字符和文件三个方面的测试。
数值测试
参数	说明
-eq	等于则为真
-ne	不等于则为真
-gt	大于则为真
-ge	大于等于则为真
-lt	小于则为真
-le	小于等于则为真
实例演示：
num1=100
num2=100
if test $[num1] -eq $[num2]
then
    echo '两个数相等！'
else
    echo '两个数不相等！'
fi
输出结果：
两个数相等！
代码中的 [] 执行基本的算数运算，如：
#!/bin/bash

a=5
b=6

result=$[a+b] # 注意等号两边不能有空格
echo "result 为： $result"
结果为:
result 为： 11

`字符串测试`
参数	说明
=	等于则为真
!=	不相等则为真
-z 字符串	字符串的长度为零则为真
-n 字符串	字符串的长度不为零则为真
实例演示：
num1="ru1noob"
num2="runoob"
if test $num1 = $num2
then
    echo '两个字符串相等!'
else
    echo '两个字符串不相等!'
fi
输出结果：
两个字符串不相等!

`文件测试`
参数	说明
-e 文件名	如果文件存在则为真
-r 文件名	如果文件存在且可读则为真
-w 文件名	如果文件存在且可写则为真
-x 文件名	如果文件存在且可执行则为真
-s 文件名	如果文件存在且至少有一个字符则为真
-d 文件名	如果文件存在且为目录则为真
-f 文件名	如果文件存在且为普通文件则为真
-c 文件名	如果文件存在且为字符型特殊文件则为真
-b 文件名	如果文件存在且为块特殊文件则为真
实例演示：
cd /bin
if test -e ./bash
then
    echo '文件已存在!'
else
    echo '文件不存在!'
fi
输出结果：
文件已存在!
另外，Shell还提供了与( -a )、或( -o )、非( ! )三个逻辑操作符用于将测试条件连接起来，其优先级为："!"最高，"-a"次之，"-o"最低。例如：
cd /bin
if test -e ./notFile -o -e ./bash
then
    echo '有一个文件存在!'
else
    echo '两个文件都不存在'
fi
输出结果：
有一个文件存在!
==============================================================
```

### 2.6、shell 流程控制 <h3 id="shellFlow"></h3>
#### 2.6.1、if
```java
==============================================================
if elif else fi

if else
if
if 语句语法格式：
if condition
then
    command1 
    command2
    ...
    commandN 
fi
写成一行（适用于终端命令提示符）：
if [ $(ps -ef | grep -c "ssh") -gt 1 ]; then echo "true"; fi
末尾的fi就是if倒过来拼写，后面还会遇到类似的。
if else
if else 语法格式：
if condition
then
    command1 
    command2
    ...
    commandN
else
    command
fi
if else-if else
if else-if else 语法格式：
if condition1
then
    command1
elif condition2 
then 
    command2
else
    commandN
fi
以下实例判断两个变量是否相等：
a=10
b=20
if [ $a == $b ]
then
   echo "a 等于 b"
elif [ $a -gt $b ]
then
   echo "a 大于 b"
elif [ $a -lt $b ]
then
   echo "a 小于 b"
else
   echo "没有符合的条件"
fi
输出结果：
a 小于 b
if else语句经常与test命令结合使用，如下所示：
num1=$[2*3]
num2=$[1+5]
if test $[num1] -eq $[num2]
then
    echo '两个数字相等!'
else
    echo '两个数字不相等!'
fi
输出结果：
两个数字相等!
```
#### 2.6.2、for
```
for 循环
与其他编程语言类似，Shell支持for循环。
for循环一般格式为：
for var in item1 item2 ... itemN
do
    command1
    command2
    ...
    commandN
done
写成一行：
for var in item1 item2 ... itemN; do command1; command2… done;
当变量值在列表里，for循环即执行一次所有命令，使用变量名获取列表中的当前取值。命令可为任何有效的shell命令和语句。in列表可以包含替换、字符串和文件名。
in列表是可选的，如果不用它，for循环使用命令行的位置参数。
例如，顺序输出当前列表中的数字：
for loop in 1 2 3 4 5
do
    echo "The value is: $loop"
done
输出结果：
The value is: 1
The value is: 2
The value is: 3
The value is: 4
The value is: 5
顺序输出字符串中的字符：
for str in 'This is a string'
do
    echo $str
done
输出结果：
This is a string
```

#### 2.6.3、while
```
while 语句
while循环用于不断执行一系列命令，也用于从输入文件中读取数据；命令通常为测试条件。其格式为：
while condition
do
    command
done
以下是一个基本的while循环，测试条件是：如果int小于等于5，那么条件返回真。int从0开始，每次循环处理时，int加1。运行上述脚本，返回数字1到5，然后终止。
#!/bin/sh
int=1
while(( $int<=5 ))
do
    echo $int
    let "int++"
done
运行脚本，输出：
1
2
3
4
5
使用中使用了 Bash let 命令，它用于执行一个或多个表达式，变量计算中不需要加上 $ 来表示变量，具体可查阅：Bash let 命令
。
while循环可用于读取键盘信息。下面的例子中，输入信息被设置为变量FILM，按<Ctrl-D>结束循环。

echo '按下 <CTRL-D> 退出'
echo -n '输入你最喜欢的网站名: '
while read FILM
do
    echo "是的！$FILM 是一个好网站"
done
运行脚本，输出类似下面：
按下 <CTRL-D> 退出
输入你最喜欢的网站名:菜鸟教程
是的！菜鸟教程 是一个好网站
无限循环
无限循环语法格式：
while :
do
    command
done
或者
while true
do
    command
done
或者
for (( ; ; ))
```

#### 2.6.4、until
```
until 循环
until循环执行一系列命令直至条件为真时停止。
until循环与while循环在处理方式上刚好相反。
一般while循环优于until循环，但在某些时候—也只是极少数情况下，until循环更加有用。
until 语法格式:
until condition
do
    command
done
条件可为任意测试条件，测试发生在循环末尾，因此循环至少执行一次—请注意这一点。
```

#### 2.6.5、case
```
`case  esac`
Shell case语句为多选择语句。可以用case语句匹配一个值与一个模式，如果匹配成功，执行相匹配的命令。case语句格式如下：
case 值 in
模式1)
    command1
    command2
    ...
    commandN
    ;;
模式2）
    command1
    command2
    ...
    commandN
    ;;
esac
case工作方式如上所示。取值后面必须为单词in，每一模式必须以右括号结束。取值可以为变量或常数。匹配发现取值符合某一模式后，其间所有命令开始执行直至 ;;。
取值将检测匹配的每一个模式。一旦模式匹配，则执行完匹配模式相应命令后不再继续其他模式。如果无一匹配模式，使用星号 * 捕获该值，再执行后面的命令。
下面的脚本提示输入1到4，与每一种模式进行匹配：
echo '输入 1 到 4 之间的数字:'
echo '你输入的数字为:'
read aNum
case $aNum in
    1)  echo '你选择了 1'
    ;;
    2)  echo '你选择了 2'
    ;;
    3)  echo '你选择了 3'
    ;;
    4)  echo '你选择了 4'
    ;;
    *)  echo '你没有输入 1 到 4 之间的数字'
    ;;
esac
输入不同的内容，会有不同的结果，例如：
输入 1 到 4 之间的数字:
你输入的数字为:
3
你选择了 3
```

#### 2.6.6、break和continue
```

跳出循环
在循环过程中，有时候需要在未达到循环结束条件时强制跳出循环，Shell使用两个命令来实现该功能：break和continue。
break命令
break命令允许跳出所有循环（终止执行后面的所有循环）。
下面的例子中，脚本进入死循环直至用户输入数字大于5。要跳出这个循环，返回到shell提示符下，需要使用break命令。
#!/bin/bash
while :
do
    echo -n "输入 1 到 5 之间的数字:"
    read aNum
    case $aNum in
        1|2|3|4|5) echo "你输入的数字为 $aNum!"
        ;;
        *) echo "你输入的数字不是 1 到 5 之间的! 游戏结束"
            break
        ;;
    esac
done
执行以上代码，输出结果为：
输入 1 到 5 之间的数字:3
你输入的数字为 3!
输入 1 到 5 之间的数字:7
你输入的数字不是 1 到 5 之间的! 游戏结束

continue
continue命令与break命令类似，只有一点差别，它不会跳出所有循环，仅仅跳出当前循环。
对上面的例子进行修改：
#!/bin/bash
while :
do
    echo -n "输入 1 到 5 之间的数字: "
    read aNum
    case $aNum in
        1|2|3|4|5) echo "你输入的数字为 $aNum!"
        ;;
        *) echo "你输入的数字不是 1 到 5 之间的!"
            continue
            echo "游戏结束"
        ;;
    esac
done
运行代码发现，当输入大于5的数字时，该例中的循环不会结束，语句 echo "Game is over!" 永远不会被执行。
esac
case的语法和C family语言差别很大，它需要一个esac（就是case反过来）作为结束标记，每个case分支用右圆括号，用两个分号表示break。
==============================================================
```

### 2.7、shell 函数 <h3 id="shellFunction"></h3>
```java
==============================================================
linux shell 可以用户定义函数，然后在shell脚本中可以随便调用。
shell中函数的定义格式如下：
[ function ] funname [()]

{

    action;

    [return int;]

}
说明：
1、可以带function fun() 定义，也可以直接fun() 定义,不带任何参数。
2、参数返回，可以显示加：return 返回，如果不加，将以最后一条命令运行结果，作为返回值。 return后跟数值n(0-255

下面的例子定义了一个函数并进行调用：
#!/bin/bash
# author:菜鸟教程
# url:www.runoob.com

demoFun(){
    echo "这是我的第一个 shell 函数!"
}
echo "-----函数开始执行-----"
demoFun
echo "-----函数执行完毕-----"
输出结果：
-----函数开始执行-----
这是我的第一个 shell 函数!
-----函数执行完毕-----


下面定义一个带有return语句的函数：
#!/bin/bash
# author:菜鸟教程
# url:www.runoob.com

funWithReturn(){
    echo "这个函数会对输入的两个数字进行相加运算..."
    echo "输入第一个数字: "
    read aNum
    echo "输入第二个数字: "
    read anotherNum
    echo "两个数字分别为 $aNum 和 $anotherNum !"
    return $(($aNum+$anotherNum))
}
funWithReturn
echo "输入的两个数字之和为 $? !"
输出类似下面：
这个函数会对输入的两个数字进行相加运算...
输入第一个数字: 
1
输入第二个数字: 
2
两个数字分别为 1 和 2 !
输入的两个数字之和为 3 !
函数返回值在调用该函数后通过 $? 来获得。
注意：所有函数在使用前必须定义。这意味着必须将函数放在脚本开始部分，直至shell解释器首次发现它时，才可以使用。调用函数仅使用其函数名即可。
函数参数
在Shell中，调用函数时可以向其传递参数。在函数体内部，通过 $n 的形式来获取参数的值，例如，$1表示第一个参数，$2表示第二个参数...


带参数的函数示例：
#!/bin/bash
# author:菜鸟教程
# url:www.runoob.com

funWithParam(){
    echo "第一个参数为 $1 !"
    echo "第二个参数为 $2 !"
    echo "第十个参数为 $10 !"
    echo "第十个参数为 ${10} !"
    echo "第十一个参数为 ${11} !"
    echo "参数总数有 $# 个!"
    echo "作为一个字符串输出所有参数 $* !"
}
funWithParam 1 2 3 4 5 6 7 8 9 34 73
输出结果：
第一个参数为 1 !
第二个参数为 2 !
第十个参数为 10 !
第十个参数为 34 !
第十一个参数为 73 !
参数总数有 11 个!
作为一个字符串输出所有参数 1 2 3 4 5 6 7 8 9 34 73 !
注意，$10 不能获取第十个参数，获取第十个参数需要${10}。当n>=10时，需要使用${n}来获取参数。
另外，还有几个特殊字符用来处理参数：
参数处理	说明
$#	传递到脚本的参数个数
$*	以一个单字符串显示所有向脚本传递的参数
$$	脚本运行的当前进程ID号
$!	后台运行的最后一个进程的ID号
$@	与$*相同，但是使用时加引号，并在引号中返回每个参数。
$-	显示Shell使用的当前选项，与set命令功能相同。
$?	显示最后命令的退出状态。0表示没有错误，其他任何值表明有错误。
==============================================================
```

### 2.8、shell 输入、输出重定向 <h3 id="shellIO"></h3>
```java
==============================================================
http://www.runoob.com/linux/linux-shell-io-redirections.html
Shell 输入/输出重定向
大多数 UNIX 系统命令从你的终端接受输入并将所产生的输出发送回​​到您的终端。一个命令通常从一个叫标准输入的地方读取输入，默认情况下，这恰好是你的终端。同样，一个命令通常将其输出写入到标准输出，默认情况下，这也是你的终端。
`
重定向命令列表如下：
命令	说明
command > file	将输出重定向到 file。
command < file	将输入重定向到 file。
command >> file	将输出以追加的方式重定向到 file。
n > file	将文件描述符为 n 的文件重定向到 file。
n >> file	将文件描述符为 n 的文件以追加的方式重定向到 file。
n >& m	将输出文件 m 和 n 合并。
n <& m	将输入文件 m 和 n 合并。
<< tag	将开始标记 tag 和结束标记 tag 之间的内容作为输入。
需要注意的是文件描述符 0 通常是标准输入（STDIN），1 是标准输出（STDOUT），2 是标准错误输出（STDERR）。
`

`输出重定向`
重定向一般通过在命令间插入特定的符号来实现。特别的，这些符号的语法如下所示:
#command1 > file1 这个命令执行command1然后将输出的内容存入file1。
注意任何file1内的已经存在的内容将被新内容替代。如果要将新内容添加在文件末尾，请使用>>操作符。

执行下面的 who 命令，它将命令的完整的输出重定向在用户文件中(users):
$ who > users
执行后，并没有在终端输出信息，这是因为输出已被从默认的标准输出设备（终端）重定向到指定的文件。
你可以使用 cat 命令查看文件内容：
$ cat users
_mbsetupuser console  Oct 31 17:35 
tianqixin    console  Oct 31 17:35 
tianqixin    ttys000  Dec  1 11:33 

输出重定向会覆盖文件内容，请看下面的例子：
$ echo "菜鸟教程：www.runoob.com" > users
$ cat users
菜鸟教程：www.runoob.com

如果不希望文件内容被覆盖，可以使用 >> 追加到文件末尾，例如：
$ echo "菜鸟教程：www.runoob.com" >> users
$ cat users
菜鸟教程：www.runoob.com
菜鸟教程：www.runoob.com


`输入重定向`
和输出重定向一样，Unix 命令也可以从文件获取输入，语法为：
# command1 < file1 这样，本来需要从键盘获取输入的命令会转移到文件读取内容。
注意：输出重定向是大于号(>)，输入重定向是小于号(<)。

接着以上实例，我们需要统计 users 文件的行数,执行以下命令：
$ wc -l users
       2 users
也可以将输入重定向到 users 文件：
$  wc -l < users
       2 
注意：上面两个例子的结果不同：第一个例子，会输出文件名；第二个不会，因为它仅仅知道从标准输入读取内容。

command1 < infile > outfile
同时替换输入和输出，执行command1，从文件infile读取内容，然后将输出写入到outfile中。


`重定向深入讲解`
一般情况下，每个 Unix/Linux 命令运行时都会打开三个文件：
标准输入文件(stdin)：stdin的文件描述符为0，Unix程序默认从stdin读取数据。
标准输出文件(stdout)：stdout 的文件描述符为1，Unix程序默认向stdout输出数据。
标准错误文件(stderr)：stderr的文件描述符为2，Unix程序会向stderr流中写入错误信息。
默认情况下，command > file 将 stdout 重定向到 file，command < file 将stdin 重定向到 file。
如果希望 stderr 重定向到 file，可以这样写：
$ command 2 > file
如果希望 stderr 追加到 file 文件末尾，可以这样写：
$ command 2 >> file
2 表示标准错误文件(stderr)。
如果希望将 stdout 和 stderr 合并后重定向到 file，可以这样写：
$ command > file 2>&1

或者

$ command >> file 2>&1
如果希望对 stdin 和 stdout 都重定向，可以这样写：
$ command < file1 >file2
command 命令将 stdin 重定向到 file1，将 stdout 重定向到 file2。

Here Document
Here Document 是 Shell 中的一种特殊的重定向方式，用来将输入重定向到一个交互式 Shell 脚本或程序。
它的基本的形式如下：
command << delimiter
    document
delimiter
它的作用是将两个 delimiter 之间的内容(document) 作为输入传递给 command。
注意：
结尾的delimiter 一定要顶格写，前面不能有任何字符，后面也不能有任何字符，包括空格和 tab 缩进。
开始的delimiter前后的空格会被忽略掉。
实例
在命令行中通过 wc -l 命令计算 Here Document 的行数：
$ wc -l << EOF
    欢迎来到
    菜鸟教程
    www.runoob.com
EOF
3          # 输出结果为 3 行
$
我们也可以将 Here Document 用在脚本中，例如：
#!/bin/bash
# author:菜鸟教程
# url:www.runoob.com

cat << EOF
欢迎来到
菜鸟教程
www.runoob.com
EOF
执行以上脚本，输出结果：
欢迎来到
菜鸟教程
www.runoob.com


`/dev/null 文件`
如果希望执行某个命令，但又不希望在屏幕上显示输出结果，那么可以将输出重定向到 /dev/null：
# command > /dev/null
/dev/null 是一个特殊的文件，写入到它的内容都会被丢弃；如果尝试从该文件读取内容，那么什么也读不到。但是 /dev/null 文件非常有用，将命令的输出重定向到它，会起到"禁止输出"的效果。
如果希望屏蔽 stdout 和 stderr，可以这样写：
$ command > /dev/null 2>&1
注意：0 是标准输入（STDIN），1 是标准输出（STDOUT），2 是标准错误输出（STDERR）。

`笔记列表`

$ command > file 2>&1
$ command >> file 2>&1
这里的&没有固定的意思
放在>后面的&，表示重定向的目标不是一个文件，而是一个文件描述符，内置的文件描述符如下
1 => stdout
2 => stderr
0 => stdin
换言之 2>1 代表将stderr重定向到当前路径下文件名为1的regular file中，而2>&1代表将stderr重定向到文件描述符为1的文件(即/dev/stdout)中，这个文件就是stdout在file system中的映射
而&>file是一种特殊的用法，也可以写成>&file，二者的意思完全相同，都等价于
>file 2>&1
此处&>或者>&视作整体，分开没有单独的含义
顺序问题：
find /etc -name .bashrc > list 2>&1
# 我想问为什么不能调下顺序,比如这样
find /etc -name .bashrc 2>&1 > list
这个是从左到右有顺序的
第一种
xxx > list 2>&1
先将要输出到stdout的内容重定向到文件，此时文件list就是这个程序的stdout，再将stderr重定向到stdout，也就是文件list
第二种
xxx 2>&1 > list
先将要输出到stderr的内容重定向到stdout，此时会产生一个stdout的拷贝，作为程序的stderr，而程序原本要输出到stdout的内容，依然是对接在stdout原身上的，因此第二步重定向stdout，对stdout的拷贝不产生任何影响
==============================================================
```

### 2.9、shell 文件包含 <h3 id="shellFileContain"></h3>
```java
==============================================================
和其他语言一样，Shell 也可以包含外部脚本。这样可以很方便的封装一些公用的代码作为一个独立的文件。
Shell 文件包含的语法格式如下：
. filename   # 注意点号(.)和文件名中间有一空格

或

source filename
实例
创建两个 shell 脚本文件。
test1.sh 代码如下：
#!/bin/bash
# author:菜鸟教程
# url:www.runoob.com

url="http://www.runoob.com"
test2.sh 代码如下：
#!/bin/bash
# author:菜鸟教程
# url:www.runoob.com

#使用 . 号来引用test1.sh 文件
. ./test1.sh

# 或者使用以下包含文件代码
# source ./test1.sh

echo "菜鸟教程官网地址：$url"
接下来，我们为 test2.sh 添加可执行权限并执行：
$ chmod +x test2.sh 
$ ./test2.sh 
菜鸟教程官网地址：http://www.runoob.com
注：被包含的文件 test1.sh 不需要可执行权限。
==============================================================
```

## 3、vi命令详解 <h2 id="viCommand"></h2>
```java
==============================================================
 linux vi命令详解

刚开始学着用linux，对vi命令不是很熟，在网上转接了一篇。

vi编辑器是所有Unix及Linux系统下标准的编辑器，它的强大不逊色于任何最新的文本编辑器，这里只是简单地介绍一下它的用法和一小部分指 令。由于 对Unix及Linux系统的任何版本，vi编辑器是完全相同的，因此您可以在其他任何介绍vi的地方进一步了解它。Vi也是Linux中最基本的文本编 辑器，学会它后，您将在Linux的世界里畅行无阻。
1、vi的基本概念
　　基本上vi可以分为三种状态，分别是命令模式（command mode）、插入模式（Insert mode）和底行模式（last line mode），各模式的功能区分如下：
    1) 命令行模式command mode）
　　控制屏幕光标的移动，字符、字或行的删除，移动复制某区段及进入Insert mode下，或者到 last line mode。
    2) 插入模式（Insert mode）
　　只有在Insert mode下，才可以做文字输入，按「ESC」键可回到命令行模式。
    3) 底行模式（last line mode）
　　将文件保存或退出vi，也可以设置编辑环境，如寻找字符串、列出行号……等。
 
    不过一般我们在使用时把vi简化成两个模式，就是将底行模式（last line mode）也算入命令行模式command mode）。
2、vi的基本操作 
a) 进入vi
   　在系统提示符号输入vi及文件名称后，就进入vi全屏幕编辑画面：
　　　$ vi myfile
不过有一点要特别注意，就是您进入vi之后，是处于「命令行模式（command mode）」，您要切换到「插入模式（Insert mode）」才能够输入文字。初次使用vi的人都会想先用上下左右键移动光标，结果电脑一直哔哔叫，把自己气个半死，所以进入vi后，先不要乱动，转换到 「插入模式（Insert mode）」再说吧！
 
b) 切换至插入模式（Insert mode）编辑文件
　　在「命令行模式（command mode）」下按一下字母「i」就可以进入「插入模式（Insert mode）」，这时候你就可以开始输入文字了。
 
c) Insert 的切换
　　您目前处于「插入模式（Insert mode）」，您就只能一直输入文字，如果您发现输错了字！想用光标键往回移动，将该字删除，就要先按一下「ESC」键转到「命令行模式（command mode）」再删除文字。
 
d) 退出vi及保存文件
　　在「命令行模式（command mode）」下，按一下「：」冒号键进入「Last line mode」，例如：
: w filename （输入 「w filename」将文章以指定的文件名filename保存）
: wq (输入「wq」，存盘并退出vi)
: q! (输入q!， 不存盘强制退出vi)

3、命令行模式（command mode）功能键
1）. 插入模式
       按「i」切换进入插入模式「insert mode」，按"i"进入插入模式后是从光标当前位置开始输入文件；
　　按「a」进入插入模式后，是从目前光标所在位置的下一个位置开始输入文字；
　　按「o」进入插入模式后，是插入新的一行，从行首开始输入文字。
 
2）. 从插入模式切换为命令行模式
      按「ESC」键。
 
3）. 移动光标
　　vi可以直接用键盘上的光标来上下左右移动，但正规的vi是用小写英文字母「h」、「j」、「k」、「l」，分别控制光标左、下、上、右移一格。
　　按「ctrl」+「b」：屏幕往"后"移动一页。
　　按「ctrl」+「f」：屏幕往"前"移动一页。
　　按「ctrl」+「u」：屏幕往"后"移动半页。
　　按「ctrl」+「d」：屏幕往"前"移动半页。
　　按数字「0」：移到文章的开头。
　　按「G」：移动到文章的最后。
　　按「$」：移动到光标所在行的"行尾"。
　　按「^」：移动到光标所在行的"行首"
　　按「w」：光标跳到下个字的开头
　　按「e」：光标跳到下个字的字尾
　　按「b」：光标回到上个字的开头
　　按「#l」：光标移到该行的第#个位置，如：5l,56l。
 
4）. 删除文字
　　「x」：每按一次，删除光标所在位置的"后面"一个字符。
　　「#x」：例如，「6x」表示删除光标所在位置的"后面"6个字符。
　　「X」：大写的X，每按一次，删除光标所在位置的"前面"一个字符。
　　「#X」：例如，「20X」表示删除光标所在位置的"前面"20个字符。
　　「dd」：删除光标所在行。
　　「#dd」：从光标所在行开始删除#行
 
5）. 复制
　　「yw」：将光标所在之处到字尾的字符复制到缓冲区中。
　　「#yw」：复制#个字到缓冲区
　　「yy」：复制光标所在行到缓冲区。
　　「#yy」：例如，「6yy」表示拷贝从光标所在的该行"往下数"6行文字。
　　「p」：将缓冲区内的字符贴到光标所在位置。注意：所有与"y"有关的复制命令都必须与"p"配合才能完成复制与粘贴功能。
 
6）. 替换
　　「r」：替换光标所在处的字符。
　　「R」：替换光标所到之处的字符，直到按下「ESC」键为止。
 
7）. 回复上一次操作
　　「u」：如果您误执行一个命令，可以马上按下「u」，回到上一个操作。按多次"u"可以执行多次回复。
 
8）. 更改
　　「cw」：更改光标所在处的字到字尾处
　　「c#w」：例如，「c3w」表示更改3个字
 
9）. 跳至指定的行
　　「ctrl」+「g」列出光标所在行的行号。
　　「#G」：例如，「15G」，表示移动光标至文章的第15行行首。

4、Last line mode下命令简介
在使用「last line mode」之前，请记住先按「ESC」键确定您已经处于「command mode」下后，再按「：」冒号即可进入「last line mode」。

A) 列出行号

　「set nu」：输入「set nu」后，会在文件中的每一行前面列出行号。

B) 跳到文件中的某一行

　「#」：「#」号表示一个数字，在冒号后输入一个数字，再按回车键就会跳到该行了，如输入数字15，再回车，就会跳到文章的第15行。

C) 查找字符

　「/关键字」：先按「/」键，再输入您想寻找的字符，如果第一次找的关键字不是您想要的，可以一直按「n」会往后寻找到您要的关键字为止。

　「?关键字」：先按「?」键，再输入您想寻找的字符，如果第一次找的关键字不是您想要的，可以一直按「n」会往前寻找到您要的关键字为止。

D) 保存文件

　「w」：在冒号输入字母「w」就可以将文件保存起来。

E) 离开vi

　「q」：按「q」就是退出，如果无法离开vi，可以在「q」后跟一个「!」强制离开vi。

　「qw」：一般建议离开时，搭配「w」一起使用，这样在退出的时候还可以保存文件。

5、vi命令列表
1、下表列出命令模式下的一些键的功能：

h
左移光标一个字符

l
右移光标一个字符

k
光标上移一行

j
光标下移一行

^
光标移动至行首

0
数字"0"，光标移至文章的开头

G
光标移至文章的最后

$
光标移动至行尾

Ctrl+f
向前翻屏

Ctrl+b
向后翻屏

Ctrl+d
向前翻半屏

Ctrl+u
向后翻半屏

i
在光标位置前插入字符

a
在光标所在位置的后一个字符开始增加

o
插入新的一行，从行首开始输入

ESC
从输入状态退至命令状态

x
删除光标后面的字符

#x
删除光标后的＃个字符

X
(大写X)，删除光标前面的字符

#X
删除光标前面的#个字符

dd
删除光标所在的行

#dd
删除从光标所在行数的#行

yw
复制光标所在位置的一个字

#yw
复制光标所在位置的#个字

yy
复制光标所在位置的一行

#yy
复制从光标所在行数的#行

p
粘贴

u
取消操作

cw
更改光标所在位置的一个字

#cw
更改光标所在位置的#个字


2、下表列出行命令模式下的一些指令
w filename
储存正在编辑的文件为filename

wq filename
储存正在编辑的文件为filename，并退出vi

q!
放弃所有修改，退出vi

set nu
显示行号

/或?
查找，在/后输入要查找的内容

n
与/或?一起使用，如果查找的内容不是想要找的关键字，按n或向后（与/联用）或向前（与?联用）继续查找，直到找到为止。


对于第一次用vi，有几点注意要提醒一下：
1、 用vi打开文件后，是处于「命令行模式（command mode）」，您要切换到「插入模式（Insert mode）」才能够输入文字。切换方法：在「命令行模式（command mode）」下按一下字母「i」就可以进入「插入模式（Insert mode）」，这时候你就可以开始输入文字了。
2、编辑好后，需从插入模式切换为命令行模式才能对文件进行保存，切换方法：按「ESC」键。
3、保存并退出文件：在命令模式下输入:wq即可！（别忘了wq前面的:） 

```

## 4、其他 <h2 id="endOther"></h2>
### 4.1、修改linux时间 <h3 id="updateLinuxTime"></h3>
```java
==============================================================
http://blog.chinaunix.net/uid-20672257-id-3013282.html
调整linux系统时间和时区与Internet时间同步
一、修改时区：
# cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
修改为中国的东八区
# vi /etc/sysconfig/clock
ZONE="Asia/Shanghai"
UTC=false
ARC=false
二、配置新的时间
日期设定：
# date -s 2008/05/06
时间设定：
# date -s 18:40:00
查看硬件时间（BIOS的）：
    hwclock [-rw] 
    -r:查看现有BIOS时间，默认为－r参数
    -w:将现在的linux系统时间写入BIOS中
    当我们进行完 Linux 时间的校时后，还需要以 hwclock -w 来更新 BIOS 的时间，因为每次开机的时候，系统会重新由 BIOS 将时间读出来，所以， BIOS 才是重要的时间依据。
# hwclock
Tue 06 May 2008 03:49:37 PM CST  -0.039646 seconds
同步BIOS时钟，强制把系统时间写入CMOS：
# clock -w


先使用 date -s 10/17/2008 修改日期
然后 date -s 10:12:13 修改时间
clock -w    写入bios

==============================================================
```

### 4.2、星期月份英语 <h3 id="EnglishTranlator"></h3>
```java
==============================================================
星期一： Mon.=Monday        Monday
星期二： Tues.=Tuesday      Tuesday 
星期三：Wed.=Wednesday      Wednesday
星期四： Thur.=Thursday     Thurday
星期五： Fri.=Friday        Friday
星期六： Sat.=Saturday      Saturday 
星期天： Sun.=Sunday        Sunday

一月份＝JAN. Jan.=January   January
二月份＝FEB. Feb.=February  February
三月份＝MAR. Mar.=March     March
四月份＝APR. Apr.=April     April
五月份＝MAY May=May         May
六月份＝JUN. Jun.=June      June 
七月份＝JUL. Jul.=July      July
八月份＝AUG. Aug.=August    August
九月份＝SEP. Sept.=September  September
十月份＝OCT. Oct.=October   October
十一月份＝NOV. Nov.=November  November
十二月份＝DEC. Dec.=December  December

东西南北  East West South North  ===  e w s n

==============================================================
```