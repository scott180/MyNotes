## git笔记
  
*   [1、上传下载](#pull)
*   [2、配置](#config)
*   [3、分支](#branch)
*   [4、其他](#other)


 <h2 id="pull"></h2>

### 1、上传下载
```
http://170.18.10.134/diffusion/449/idsplus研发.git
http://170.18.10.134/diffusion/450/idsplus发布.git

git clone git@170.18.10.134:222/diffusion/449/idsplus研发.git

ssh://git@170.18.10.134:222/diffusion/449/idsplus研发.git
```

```
添加文件到缓存：
	git add test.txt    单个文件
	git add .           当前目录全部文件

提交(包含注释)到本地仓库：	
	git commit -m '第一次版本提交'	


上传文件到远程仓库：
	git push origin [本地分支名]:[远端分支名]  
	当然如果你的本地分支名和远端分支名是一样的，那么就只需要git push origin [分支名称]就可以了。 
    git push origin master

恢复最近版本文件
	git fetch
	git reset --hard origin/master   //恢复到远程仓库，删除git add和commit的文件


	
git pull   拉取 从远程拉取最新版本到本地，并自动合并 merge

git fetch  获取 从远程获取最新版本到本地，不会自动合并 merge，需要手动合并
git merge  合并 使用fetch 可以在merge之前可以看清楚更新情况，再决定是否合并。
```

```
撤销操作
	git reset    
		撤销git add 缓存的文件
	
	git reset —soft + 版本号
		回退到某个版本，只回退了commit的信息，不会改变已经修改过的代码。
		git reset --soft HEAD^
		
	git reset —hard + 版本号
		彻底回退到某个版本，本地的代码也会改变上一个版本内容。
		
		
		HEAD 最近一个提交
		HEAD^ 上一次提交
		HEAD^^ 上一次的 上一次的提交（倒数第三次）
		HEAD^^^ 倒数 第四次的 提交

	----------------------

		HEAD~0 最近一个提交
		HEAD~1 上一次提交

		HEAD^2 上一次的 上一次的提交（倒数第三次）
		HEAD^3 倒数 第四次的 提交
		
```

 <h2 id="config"></h2>
 
### 2、配置

```
vi /etc/ssh/sshd_config

查看版本：
	git --version

查看配置：
	git config --list

设置配置：
	git config --global pack.windowMemory 1024m

	git config --global pack.packsizelimit 1g
	
	git config --global http.postBuffer 1g

删除配置：
	git config --global --unset pack.deltacachesize
	
```

 <h2 id="branch"></h2>
 
### 3、分支

```

https://edu.aliyun.com/jiaocheng/1834?spm=5176.11182473.menu.7.k6ksTN

创建分支命令（复制当前分支下文件）：
	git branch (branchname)
	
提交分支到仓库命令：
	git push origin (branchname)

切换分支命令:
	git checkout (branchname)
	
列出分支基本命令：
	git branch -a

删除分支命令：
	git branch -d (branchname)
	
我们也可以使用 git checkout -b (branchname) 命令来创建新分支并立即切换到该分支下，从而在该分支中操作。
	git checkout -b newtest

	
合并分支：
	git checkout master
	git meger test   // test分支合并到master分支
	git push origin master
	
	
展示文件  ls
删除文件  git rm test2.txt 

查看分支：git branch -a
删除本地分支 git branch -D branch-name
删除远程分支：git push origin --delete branch-name
			  
			  
查看当前配置有哪些远程仓库
	git remote -v
	
```
 <h2 id="other"></h2>
 
### 4、其他	
```
	
类似linux
	touch test.txt
	vi   test.txt    // :wq  保存
	mkdir  dir
	rm   test.txt

	
git status 命令用于查看项目的当前状态。
git status -s  查看详情
	
git diff   
git diff --stat

执行 git diff 来查看执行 git status 的结果的详细信息。

git diff 命令显示已写入缓存与已修改但尚未写入缓存的改动的区别。
git diff 有两个主要的应用场景。
	尚未缓存的改动：git diff 
	查看已缓存的改动： git diff --cached 
	查看已缓存的与未缓存的所有改动：git diff HEAD 
	显示摘要而非整个 diff：git diff --stat

退出git diff  : q


查看未推送

查看全部分支的已经commit但是没有push的：
	git log --branches --not --remotes

查看全部分支的全部的最近的commit：
	git log --branches --not --remotes --simplify-by-decoration --decorate --online

```


```
## github添加ssh公钥

ssh-keygen -t rsa

cat ~/.ssh/id_rsa.pub

https://github.com/settings/keys   依次点击"Setting -> SSH Keys"->"New SSH key"

ssh -T git@github.com
```