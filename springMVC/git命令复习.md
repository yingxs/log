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



## 分支操作

* 创建分支

  * git branch  <branchname>

* 查看所有分支

  * git branch

* 查看所有分支的HEAD提交

  * git branch -v

* 合并分支

  * git merge <branchname>

    ```git
    (master) git merge hotfix     将hotfix合并到master分支上
    ```

* 删除分支

  * git branch -d <branchname>
* 切换分支

  * git checkout <branchname>
* 创建并切换分支

  * git checkout  -b <branchname>
* 修改分支名称
  * git branch -m old_name new_name
  * git branch -M old_name new_name   # 强制
* 删除分支
  * git branch -d <branchname>
  * git branch -D <branchname>
* 列出远程分支

  * git branch -r
* 查看已合并的分支
  * git branch --merged
  * git branch --no-merged
* 列出远程合并的分支

  * git branch -r merged
* 取出远程foo分支

  * git checkout -t origin/foo
* 推送分支

  * (iss53) git push -u origin foo
* 删除远程分支
  * git push origin <space>:<remote branch>
  * git fetch -p
* 合并分支 拒绝fast forward 产生合并commit

  * git merge - -no-ff

## 冲突的发生情况

1. 在不同得到分支上，修改了同一个文件；
2. 不同的人，修改了同一个文件
3. 不同的仓库，修改了同一个文件
4. 冲突只在合并分支的时候才会发生
5. 解决冲突，重新提交，commit时不给message
6. 冲突信息的格式





## git stash

1. 保存进度

   ```git
   git stash
   ```

2. 弹出进度

   ```git
   gitg  stash pop
   ```

3. 查看stash列表

   ```git
   git stash list
   ```

4. 删除stash列表

   ```
   git stash clear
   ```
