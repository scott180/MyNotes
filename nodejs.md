## nodejs
  
*   [1、说明](#introducer)
*   [2、安装](#install)


 <h2 id="introducer"></h2>

### 1、说明
```
官方下载  https://nodejs.org/en/download/
安装参考  https://blog.csdn.net/qq_44894359/article/details/89283325
教程     https://www.runoob.com/nodejs/nodejs-tutorial.html
```

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
```
