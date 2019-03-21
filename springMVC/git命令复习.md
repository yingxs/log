### git blame

 ##### 1. 逐行查看文件的修改历史

```git
git blame <filename>
```

##### 2.从第100行开始，到第110行逐行查看文件修改历史

```git
git blam -L 100,10 <filename>
```



### git clean

##### 1.列出打算清除的档案
```git
git clean -n
```

##### 2.真正删除

```
git clean -f
```

##### 3.连同.gitnore中忽略的档案也清除

```
git clean -x -f
```

### 信息查看

##### 1.查看某个提交

```
git show HEAD 
git show HEAD^ #倒数第二个提交
git show HEAD^^/HEAR~2 #倒数第三个提交
```

##### 2.查看提交历史

```
git log -n #打印n条提交历史
git log -n <filename> #查看某个文件的提交历史也可以用 git hi [-n] <filename>
git log --grep <msg> #过滤与有关<message>的提交
```

### git diff

> 整个仓库进行对比

![](http://md.yingxs.com/gitdiff.png)

```
git tag <tager> HEAD 标记
git diff --cached maint 暂存区与第一版比较
```



