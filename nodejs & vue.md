## nodejs
  
*   [1、说明](#introducer)
*   [2、安装](#install)
*   [3、常用命令](#usually)
*   [4、vue](#vue)


 <h2 id="introducer"></h2>

### 1、说明
[nodejs官方下载](  https://nodejs.org/en/download/ )
[安装参考](  https://blog.csdn.net/qq_44894359/article/details/89283325 )
[教程](  https://www.runoob.com/nodejs/nodejs-tutorial.html )


<h2 id="install"></h2>

### 2、安装
```
1、环境变量
NODE_HOME
D:\ProgramFiles\nodejs

PATH
%NODE_HOME%\;%NODE_HOME%\node_modules;%NODE_HOME%\node_global;

查看版本
node --version
npm -v


2、设置全局安装及缓存目录
npm config set prefix "D:\\ProgramFiles\\nodejs\node_global"
npm config set cache "D:\\ProgramFiles\\nodejs\node_cache"

查看配置列表
npm config ls

查看默认配置列表
npm config ls -l 

查看配置目录
npm root -g


设置镜像源
npm config set registry https://registry.npm.taobao.org --global
npm config set disturl https://npm.taobao.org/dist --global


安装模块
npm install -g vue
npm install express -g

使用淘宝定制的 cnpm (gzip 压缩支持) 命令行工具代替默认的 npm
npm install -g cnpm --registry=https://registry.npm.taobao.org

全局安装vue-cli
cnpm install --global vue-cli

-------------------------------
npm命令失效
https://blog.csdn.net/qq_39085705/article/details/81134453

找到  C:\Users\Super\.npmrc  （根据个人电脑找到 .npmrc文件）
删除 这个 .npmrc文件即可

重启 explorer.exe 即时生效环境变量
1，调出任务管理器：CTRL+ALT+DEL三键同时按；
2，在进程选项卡选中explorer.exe，点击下方的结束任务，确认；
3，在应用程序选项卡，最下面点新任务，输入explorer.exe，就是重启了explorer.exe.

-------------------------------
配置全局变量变量后，每次重启电脑node命令失效。
可将 默认目录下文件 C:\Users\x\.npmrc 复制到 安装目录 D:\ProgramFiles\nodejs\node_modules\npm\
重启电脑即可


```



<h2 id="usually"></h2>

### 3、常用命令 
[npm使用介绍](  https://www.runoob.com/nodejs/nodejs-npm.html )
[Webpack 入门教程]( https://www.runoob.com/w3cnote/webpack-tutorial.html )




<h2 id="vue"></h2>

### 4、vue

<h2 id="document"></h2>

#### 4.1、vue教程 

[vue官网]( https://cn.vuejs.org/ )

[教程]( https://www.runoob.com/vue2/vue-tutorial.html )

<h2 id="project"></h2>

#### 4.2、vue项目 


| git项目                                              | 地址    | demo  | 
| --------                                             | -----   | ----  |
| git@github.com:lin-xin/vue-manage-system.git         | [地址]( https://github.com/lin-xin/vue-manage-system )       | [演示]( https://lin-xin.gitee.io/example/work/#/dashboard ) |
| git@github.com:wdlhao/vue2-element-touzi-admin.git   | [地址]( https://github.com/wdlhao/vue2-element-touzi-admin ) | [演示]( http://www.jiouai.com/permission/index/index )      |


