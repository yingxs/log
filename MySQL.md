## 数据库基础知识
### 数据库基本概念
* 什么是数据？
    * 指存储在某种介质上能够识别的物理符号，如文字、图像、声音、视频等
* 什么是数据库？
    * 保存在磁盘等介质上的数据集合，能被各类用户所共享，数据冗余度低，按一定的数据模型组织，描述和存储，较高的数据地独立性和易扩展性
* 什么是数据库管理系统(DBMS)
    * 用户和操作系统之间的数据管理软件呢，如ACCESS,MYSQL,是数据库系统的核心
    * 功能：
        * 1.数据定义
        * 2.数据操纵
        * 数据库的运行管理
        * 数据库的建立与维护
        * 提供方便的、有效存取数据库信息的接口和工具
* 什么是数据库系统？
    * 引入数据库后的计算机，是一个集合体，包括：应用系统，数据库，数据库管理系统、应用开发工具、数据库管理员和用户。
    * 
![image](http://www.yingxs.com/markimg/m1.png)

* 数据库系统的特点
    * 数据节结构化
    * 数据冗余度低
    * 数据共享性好
    * 数据独立性高
    * 数据库保护
* 数据库系统的结构
    *　客户/服务器(client/server,c/s)结构
        * 数据库的使用者使用命令行客户端、图形化界面工具或应用程序等来连接数据库管理系统，并对其中的数据进行操作。分为单机方式和网络方式
    *　浏览器/服务器(brower/server,b/s)结构
        * 也叫三层客户/服务器结构，江南客户端分为“表示层”和“处理层”，表示层通常是浏览器
* 数据模型
> 在数据库中，用数据模型来抽象、表示和处理现实世界中的数据和信息
    * 概念模型：实体-联系模型（E-R），抽象、表示现实世界的各种事物及其联系
    * 逻辑模型：层次结构、网状模型、关系模型、面向对象模型等
    * 物理模型：用于供述数据在存储介质上的组织结构
* 概念模型
    * 实体(entiy):客观存在并相互区别的万事万物，也可以是抽象的事件，如一堂课
    * 属性(attribute):实体的特征(外在表现)。如学生的学好，姓名等
    * 实体集(entity set):性质相同的同类实体的集合
    * 码(key):唯一标识实体的属性集
    * 域(domain):属性的取值范围
    * 联系(relationship):分为实体内部的联系和实体之间的联系，主要来看实体之间的联系
        * 一对一(1:1):表A中的一条记录只与表B中的一条记录联系
        * 一对多(1:N):表A中的一条记录与表B中多条记录联系
        * 多对多(M:N):表A中的一条记录与表B中的多条记录联系，反之如此
        ![](http://www.yingxs.com/markimg/m2.png)

### 关系数据库
* 关系的数据结构---用二维表表示
    * 关系：一个“表”就是一个关系，即一个二维表
    * 元祖：一个二维表中，水平方向的行称为元组，一行就是一个元组
    * 属性：二维表中垂直方向的列称为属性(字段)
    * 域：属性的取值范围
    * 关系模型：对关系的描述，表示为关系名(属性1，属性2，... , 属性n),Mysql中的表:表名(字段1，字段2，... ，字段n)
* 基本概念
    * 表：由行和列组成
    * 行：表中的一条记录
    * 列：表中的一个字段
    * 主键：其值能够唯一标识一个元组的属性或属性的集合，也叫主码或主关键字
    * 候选键：一个表中具有多个能够位置标识一个元组的属性
    * 外键：表中的一个字段不是本表的主关键字，而是另外一张表中的主关键字，这个字段就称为外关键字
    * 数据类型：所允许的数据类型

### 数据库设计
> 分为六个阶段：需求分析，概念结构设计，逻辑结构设计，数据库实施，数据库运行与维护

* 概念结构设计
    * 将用户需求抽象为信息结构，是整个数据库设计的关键，通常用E-R图来描述现实世界的概念模型 
* 逻辑结构设计
    * 把E-R图转换为关系模型(表及其联系)对其性能进行优化，逻辑模式规范化及调整、实现，根据需要设计更符合局部用户需要的用户外模式 

### MYSQL概述
> MYSQl是一个中小型关系型数据库管理系统，具有体积小，速度快，开放源代码，遵循GPL等特点，许多中小型网站选择MYSQL作为网站数据库
具有可移植性，支持多种操作系统平台，支持多种语言，方便支持上千万条记录，为多种编程语言提供API，提供多种数据库的连接途径等。

* MYSQL在internet上构建网站与信息管理系统应用环境主要有两种
    * LAMP (Linux+Apache+Mysql+php/perl/python)
    * WAMP (windows+apache+mysql+php+perl+python)

### Mysql语言组成
* 数据定义语言(DDL) 对数据库及数据库中各种对象进行创建、删除、修改等操作CREATE(创建)、ALTER(修改)、DROP(删除)
* 数据操纵语言(DML) 操纵数据控中各种对象，主要是检索和修改数据SELECT(选择)、INSERT(插入)、UPDATE(修改)、DETELE(删除)
* 数据控制语言(DCL) 用于安全管理：GRANT、REVOKE
* MYSQL扩展增加的语言要素
    * 常量，程序运行中值不变的量
    * 变量，用于临时存放数据，有名字和数据类型两个属性，分为用户变量和系统变量，用户变量会在前加一个@，系统变量会在前加两个@
        * set @name = ‘王林’ 
        * SELECT @@VERSION
    * 运算符 位运算符
    * 比较运算符 = < > >= <= != 
    * 逻辑运算符 NOT或！ AND或&& OR或|| XOR逻辑异或
    * 表达式，表达式的值也是具有某种数据类型的
    * 内置函数，函数名后有圆括号，如NOW()

### Mysql函数
#### 聚合函数
* COUNT()函数 返回所选集合中所有行的数目
* SUM()函数 求出表中某个字段取值的总和
* AVG()函数 求出表中某个字段取值的平均值
* MAX()函数 求出表中某个字段的最大值
* MIX()函数 求出表中某个字段的最小值

#### 数学函数
* ABS()函数 求出某个字段取值的绝对值
* FLOOR(x)函数 返回小于或等于参数x的最大整数
* RAND()函数 返回0~1之间的随机数
* TRUNCATE(x,y)函数 返回X保留到小数点后y位的值
* SQRT(x)函数 求X的平方根

#### 字符串函数
* UPPER(s)函数和和UCASE(s)函数 用于将字符串s中所有字母变成大写字母
* LEFT(s,n)函数 返回字符串s的前n个字符
* SUBSTRING(s,n,len)函数 用于从字符串s的第n个位置开始获取长度为len的字符串

#### 日期和时间函数
* CURDATE()和CURRENT_DATE()函数 用于获取当前日期
* CURTIME()和CURRENT_TIME()函数 用于获取当前时间
* NOW()函数 获取当前日期和时间（CURRENT_TIMESTAMP() ,LOCALTIME(), SYSDATE(), LOCATIMESTAMP())

#### 其他函数
* IF(expr,v1,v2)函数 如果expr成立，则执行v1，否则执行v2
* IFNULL(v1,v2)函数 如果表达式v1不为空，则显示v1的值，否则显示v2的值
* VERSION()函数 系统信息函数，获取数据库版本号
* 
### 定义数据库
#### 创建数据库
```
CRETE{DATABASE|SCHEMA}[IF NOT EXISTS] db_name
[DEFAULT] CHARACTER SET [=] charset_name
[[DEFAULT]COLLATE[=]collation_name];
eg:创建一个名为mysql_test的数据库
CREATE DATABASE mysql_test;
```

#### 选择数据库
USE db_name;
只有使用USE命令指定某数据库为当前数据库，才能对该数据库及其存储对象执行各种后续操作

#### 查看数据库
```
SHOW {DATABASES|SCHEMAS};
```

查看当前可用数据库，只会列出当前用户权限范围内所能查看到的数据库的名称

##### 修改数据库
```
CRETE{DATABASE|SCHEMA} [db_name]
[DEFAULT] CHARACTER SET [=] charset_name
[DEFAULT] COLLATE [=] collation_name;
```

#### 删除数据库
```
DROP {DATABASE|SCHEMA} [IF EXISTS] db_name
eg：删除数据库mytest
DROP DATABASE IF EXISTS mytest;
```

### 定义表
#### 数据类型
* 数值
* 日期和时间
* 字符串类型

#### 创建表
```
CREATE TABLE tbl_name
(字段名1 数据类型 [列级完整性约束条件] [默认值]
[,字段名2 数据类型 [列级完整性约束条件] [默认值]]
[,表级完整约束条件]
)[ENGLISH=引擎类型];
```
* 指定表名和字段名
* 完整性约束条件
    * 实体完整性约束(PRIMARY KEY ,UNIQUE) 
    * 参加完整性约束(FOREIGN KEY)
    * 用户定义约束(NOT NULL , DEFAULT ,CHECK)
* NULL和NOT NULL
* AUTO_INCREMENT
* DEFAULT
* 存储引擎类型

#### 查看表
##### 查看有哪些表(表名)
```
SHOW TABLES [{ FROM | IN } db_name]
eg:查看当前数据库可见的表
SHOW TANLES;
```

##### 查看数据表的基本结构
```
SHOW COLUMNS {FROM | IN} tbl_name [{FROM|IN} db_name];

DESC tbl_name;
```

##### 查看数据表的详细结构
```
SHOW CREATE TABLE tb_name
Eg:查看数据库db_school中表tb_student的详细信息
SHOW CREATE TABLE tb_student
使用该语句不仅可以查看创建表时的详细语句，还可以查看存储引擎和字符编码

```
#### 修改表
ALTER TABLE语句
##### 添加字段
```
ADD [COLUMN]子句
增加新列，可同时增加多个列
ALTE RTABLE tb_name ADD [COLUMN] 新字段名 数据类型 [约束条件][FIRST|AFTER 已有字段名] 
```
![](http://www.yingxs.com/markimg/xiugaibiao1.PNG)
![](http://www.yingxs.com/markimg/xiugaibiao2.PNG)
##### 修改字段
```
CHANGE [COLUMN]子句
同时修改表中指定列的名称和数据类型，多个CHANGE[COLUMN]子句，彼此见用逗号分隔
ALTER TABLE tb_name CHANGE [COULUMN] 原字段名 新字段名 数据类型 [约束条件]；
```

```
ALTER [COLUMN]子句
修改或删除表中指定列的默认值
ALTER TABLE tb_name ALTER [COLUMN] 字段名 {SET|DROP} DEFAULT'
```

```
MODIFY [CULUMN]子句
只修改指定列的数据类型，可通过FIRST或AFTER指定列在表中的位置
ALTER TABLE tb_name MODIFY [COLUMN] 字段名 数据类型 [约束条件] [FIRST|AFTER 已有字段名];
```
![](http://www.yingxs.com/markimg/xiugaibiao3.PNG)
![](http://www.yingxs.com/markimg/xiugaibiao4.PNG)
![](http://www.yingxs.com/markimg/xiugaibiao5.PNG)
![](http://www.yingxs.com/markimg/xiugaibiao6.PNG)
##### 删除字段

DROP [COLUMN]子句
删除列的同时列中的一切内容也被删除
ALTER TABLE tb_name DROP [COLUMN] 字段名;
```
Eg：删除数据库db_school.tb_student2的字段
ALTER TABLE db_school.tb_student2 DROP COLUMN id;
```
##### 重命名表
RENAME [TO]子句
```
ALTER TABLE tbl_name RENAME [TO] new_tabl_name;
Eg:使用RENAME [TO]子句将数据库db_school中的表tb_student重新命名为backup_tb_student
ALTER TABLE db_school.tb_student RENAME TO db_school.backup_tb_student;
```

RENAME TABLE子句
```
RENAME TABLE tbl_name TO new_tbl_name [,tbl_name2 TO new_tbl_name2]...;
Eg:使用RENAME TABLE语句，将数据库db_school中的表backup_tb_student重命名为tb_student
RENAME TABLE db_school.backup_tb_student TO db_school.tb_student
```
##### 删除表
```
DPOR TABLE [IF EXISTS] tbl_name[,tbl_name]...;
表被删除时，存储的数据和分区信息均会被删除
Eg：删除数据库db_school中的tb_student、tb_student1和tb_student2
DPOR TABLE db_school.tb_student,db_student1,db_school.tb_student1,db_school.tb_student2;
```
### 数据的完整性约束
> 定义了完整性约束，MYSQL服务器会随时检测处于更新状态的数据库内容是否符合相关的完整性约束，保证数据的一致性与正确性

* 实体完整性
    * 实体完整性规则是指关系的主属性，即关系的主属性不能为空，关系的主属性不能为NULL
    * 主键约束
        * 每个表只能定义一个主键
        * 键值唯一且不能为NULL
        * 复合主键不能包含不必要的多余列
        * 一个列名在复合主键的列表中只能出现一次
    * 可通过CREATE TABLE或ALTER TABLE语句中使用PRIMARY KEY实现方式有两种
        * 列的完整性约束：在表中某个列的属性定义之后加上PRIMARY KEY
        * 表的完整性约束：在表中所有列的属性定义后加上PRIMARY KEY(index-col-name),主键由表中多列构成只能用这种方法
    ```
    例如：在数据库db_school中重新定义学生表tb_student,要求以列级完整性约束方式定义主键
    CREATE TABLE tb_student(
        studentno CHAR(10) PRIMARY KEY,
        studentname VARCHAR(20) NOT NULL,
        sex CHAR(2) NOT NULL,
        birthday DATE,
        native VARCHAR(20),
        nation VARCHAR(10) DEFAULT '汉',
        classno char(6))
        ENGINE=InnoDB;
    )
    
    例如：在数据库db_school中重新定义学生表tb_student,要求以表级完整性约束方式定义主键
    CREATE TABLE tb_student(
        studentno CHAR(10),
        studentname VARCHAR(20) NOT NULL,
        sex CHAR(2) NOT NULL,
        birthday DATE,
        native VARCHAR(20),
        nation VARCHAR(10) DEFAULT '汉',
        PRIMARY KEY(studentno))
        ENGINE=InnoDB;
    )
    ```
    * 完整性约束的命名
    CONSTRAINT [symbol]
    
    ```
    例如：在数据库db_school中重新定义学生表tb_student,要求以表记完整性约束方式定义主键，并指定主键约束名称为PK_student
    CREATE TABLE tb_student(
        studentno CHAR(10),
        studentname VARCHAR(20) NOT NULL,
        sex CHAR(2) NOT NULL,
        birthday DATE,
        native VARCHAR(20),
        nation VARCHAR(10) DEFAULT '汉',
        classno char(6),
        CONSTRAINT PK_student PRIMARY KEY (studentno))
        ENGINE=InnoDB;
    )
    ```
    * 候选键约束
    > 候选键必须唯一，且不能为NULL，通过在CREATE TABLE或ALTER TABLE中UNIQUE定义，候选键和主键之间的区别：一个表只能有一个主键，可以有若干个候选键
    
    ```
    例如：在数据库db_school中定义班级表tb_class,使用InnoDB引擎存储数据
    ```
    
* 含义 | 字段名 | 数据类型 | 宽度
    ---|---|---|---
    班级编号 | classno | 字符型 | 6
    班级名称 | classname | 字符型 | 20
    所属院系 | department | 字符型 | 30
    年级     | grade | 数值型 |  |
    班级最大人数 | classnum | 数值型|  |
```
USE db_school;
CREATE TABLE tb_class(
    classno CHAR(6) PRIARY KEY,
    classname VARCHAR(20) NOT NULL,
    department VARCHAR(30) ,
    grade SMALLINT,
    classnum TINYINT)
    CONSTRAINT UQ_class UNIQUE(ckassname)
    ENGINE=InnoDB;
)
```
    
* 参照完整性
    * 教师(_职工号_,姓名,性别,职称,_系编号_)
    * 系(_系编号_,系名,办公地点,办公电话)
        * 外键是一个表中的一个或一组属性，它对应另一个表的主键
        * 参照完整性规则是定义_外键_和_主键_之间的引用规则，是对关系间引用数据的一种限制，外码要么空，要么取被参照关系中的_主键值_
    * 参照完整性通过在CREATE TABLE 或ALTER TABLE时定义一个外键声明来实现
        * 在某个列属性定义后加上reference_definition;
        * 在表中所有列的属性定义后添加FOREIGN KEY(index_col_name,...)refence_definition;
    ```
    l例如：在数据库db_school中重新定义学生表tb_student 要求以表记完整性约束方式定义外键
    CREATE TABLE tb_student(
        studentno CHAR(10),
        studentname VARCHAR(20) NOT NULL,
        sex CHAR(2) NOT NULL,
        birthday DATE,
        native VARCHAR(20),
        nation VARCHAR(10) DEFAULT '汉',
        classno char(6),
        CONSTRAINT PK_student PRIMARY KEY (studentno))
        CONSTRAINT PK_student FOREIGN KEY (classno))REFERENCES tb_class(classno)
        ENGINE=InnoDB;
    )
    ```
    reference_option:参照完整性约束的实现策略如下
    RESTRICT:限制策略，默认使用，违法就拒绝
    CASCADE:级联策略，被参照表中删除或更新记录记录行时，自动删除或更新参照表中的匹配记录行
    SET NULL:置空策略，被参照表中删除或更新记录时，设置参照表中对应外键列值为NULL
    NO ACTION:不采取实施策略
    SET DEFAULT:默认值策略，被参照表中删除或更新记录时，设置参照表中对应外键列值为默认值
    ```
    在数据库db_school中重新定义学生表tb_student,要求是定义外键的同时定义相应的参照动作
    
     CREATE TABLE tb_student(
        studentno CHAR(10),
        studentname VARCHAR(20) NOT NULL,
        sex CHAR(2) NOT NULL,
        birthday DATE,
        native VARCHAR(20),
        nation VARCHAR(10) DEFAULT '汉',
        classno char(6),
        CONSTRAINT PK_student PRIMARY KEY (studentno),
        CONSTRAINT PK_student FOREIGN KEY (classno))REFERENCES tb_class(classno)
        ON UPDATE RESTRICT//若有修改键值列的操作，拒绝该操作
        ON UDELETE CASCADE//当删除班级表中的记录时候，学生表中的匹配记录一同被删除
        )ENGINE=InnoDB;
    )
    ```
    * 注意
        * 被参照表必须存在且有主键
        * 被参照表名指定的列或列组合必须是被参照表的主键或候选键
        * 外面允许出现空值
        * 外键列的数目、数据类型必须与悲惨招标中的数据、数据类型相同
* 用户定义的完整性
    * 反应某一具体应用多涉及的数据英满足的要求。Mysql中支持集中用户自定义完整性约束， 分别是非空约束，CHECK约束和触发器
    * 非空约束NOT NULL
    * CHECK约束 CHECK(expr)
    

##### 例1
    ```
    在数据库db_school中定义课程表tb_course要求自定义约束:煤16课时对应一个学分
    
    ```
    含义 | 字段名 | 数据类型 | 宽度
    课程号 | courseno | 字符型 | 6
    课程名 | coursename | 字符型 | 20
    学分 | credit | 数值型 | |
    课时数 | coursehour | 数值型 | |
    开课学期 | term | 字符型 | 2 |
    先修课程 | priorcourse | 字符型 |6 |
    
    ```
    CREATE TABLE tb_course(
        courseno CHAR(6),
        coursename VARCHAR(20) NOT NULL,
        credit INT NOT NULL,
        courseHour INT NOT NULL,
        term CHAR(2),
        priorcourse CHAR(6),
        CONSTRAINT PK_course PRIMARY KEY(courseno),
        CONSTRAINT FK_course FOREIGN KEY (prorcourse) REFERENCES tb_course(courseno),
        CONSTRAINT CK_course CHECK(credit=coursehour/16)
        )ENGINE = InnoDB;
    ```
##### 例2
    ```
    在数据库db_school中定义成绩表tb_student,要求成绩取值只能在0-100之间
    ```
    含义 | 字段名 | 数据类型 | 宽度
    学号 | studentno | 字符型 | 10
    课程号 | courseno | 字符型 | 6
    成绩 | score | 数值型 |
    ```
    CREATE TABLE tb_score(
        student CHAR(10),
        courseno CHAR(10),
        courseno CHAR(6),
        score FLOAT CHECK (score >= 0 AND score <= 100)
        CONSTRAINT PK_score PRIMARY KEY(studentno,courdeno)
        CONSTRAINT FK_score1 FOREIGN KEY(studentno)
        REFERENCES tb_student(studentno),
        CONSTRAINT FK_score2 FOREIGN KEY(courseno)
        REDERENCES tb_course(courseno)
    )ENGINE = InnoDB;
    ```
#### 更新完整性约束
##### 删除约束-ALTER TABLE语句
###### 删除外键约束
ALTER TABLE <表名> DROP FORIGN KEY <外键约束名>，
```
例：删除表tb_score在student上定义的外键约束FK_score1
ALTER TABLE tb_score DROP FOREIGN KEY FK_score1

例：在表tb_score在studentno上定义了一个无明明的外键约束，然后删除它
ALTER TABLE tb_score ADD FOREIGN KEY(studentno)REFERENCES tb_student(studentno);
SHOW CREATE TABLE tb_score;//查看外键约束名

```
###### 删除主键约束
ALTER TABLE <表名> DROP PRIMARY KEY；
```
例如：删除在学生表上定义的主键约束
ALTER TABLE tb_student DROP PRIMARY KEY;
```

###### 删除候选键约束
ALTER TABLE <表名> DROP { 约束名 | 候选键字段名}；
```
例：删除在班级表tb_class的字段classname 上定义的候选键约束
ALTER TABLE tb_class DROP INDEX classname
ALTER TABLE tb_class DROP INDEX UQ_class;
```
##### 添加约束- ALTER TABLE 语句实现
###### 添加主键约束
ALTER TABLE <表名> ADD [CONSTRAIN <约束名>] PRIMARY KEY(主键字段);
```
例如 重新定义在学生表tb_student的字段studentno上的主键约束
ALTER TABLE tb_student ADD CONSTRAINT PK_student PRIMARY KEY(studentno);
```
###### 添加外键约束
ALTER TABLE <表名> ADD [CONSTRAIN <约束名>] FOREIGN KEY (外键字段名) REDERENCES <被参照表名> (主键字段值)
```
例如 重新定义在成绩表tb_score的字段student 上的外键约束
ALTER TABLE tb_score ADD CONSTRAINT FK_score1 FOREIGN KEY (student) REFERENCES tb_student(studentno);
``` 

###### 添加候选键约束
ALTER TABLE <表名> ADD [CONSTRAINT <约束名>] UNIQUE KEY(字段名);
```
例如：重新定义班级表tb_class的字段classname上的候选键约束ALTER TABLE tb_class ADD CONSTRAINT UQ_class UNIQUE KEY(classname);

```
* 注意：
    * 完整性约束不能直接被修改
    * ALTER TABLE 值删除完整性约束 DROP TABLE删除一个表
    

