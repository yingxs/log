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
    

## 数据库查询
### SELECT语句
SELECT [ALL | DISTINCT | DISTINCTROW] 
<目标表达式> [,<目标表达式2>]...FROM 表名1或视图名1[,<表名2或视图名2>]...
[WHERE <条件表达式>]
[GROUP BY <列名1> [HAVING <条件表达式>]
[ORDER BY <列名2> ASC|DESC]]
[LIMIT [m,]n];

#### 单表查询
SELECT 目标表达式1,目标表达式2,...目标表达式n FROM 表名;
```
查询指定字段
例如：查询所有班级的班级编号，所属学院和班级名称
SELECT classno,department,classname FROM tb_class;

例如：
从班级表tb_class中查询出所有的院系名称
SELECT department FROM tb_class;

//去重复
SELECT DISTINCT department FROM tb_class;
SELECT DISTINCTROW department FROM tb_class;

```
#### 查询所有字段
SELECT * FROM 表名;

#### 查询列出经过计算的值
目标表达式出了字段名，可以是字段、字符串常量、函数
```
例如：查询全体学生的姓名、性别和年龄
SELECT studentname,sex,'age',YEAR(NOW())-YEAR(birthday) FROM tb_student;
```
#### 定义字段别名
字段名 [AS] 字段别名
```
例如：查询全日学生的姓名、性别、年龄，要求给目标字段取别名
SELECT studentnam AS 姓名,sex AS 性别,YEAR(NOW())-YEAR(birtday) AS 年龄 FROM tb_student;

```
#### 选择指定记录
WHERE子句指定过滤条件
SELECT 目标列表达式1,目标列表达式2,...,目标列表达式n
FROM 表名 WHERE 查询条件

* 比较大小
    * 比较运算符 
```
查询课时大于等于48学时的课程名称和学分
SELECT coursename,credit,FROM tb_score WHERE coursename >= 48;
或
SELECT coursename,credit,FROM tb_score WHERE NOT coursename < 48;

```
* BETWEEN...AND 或 [NOT] BETWEEN ...AND
```
查询出生日期在1997-01-01和1997-12-31之间的学生，姓名和出生日期
SELECT studentname,sex,birthday
FROM tb_student
WHERE birthday BETWEEN '1997-01-01' AND '1997-13-31'
```
##### 带IN关键字的集合查询( [NOT] IN )
查找字段值属于指定集体范围内的记录
```
查询籍贯是北京、天津、上海的学生信息
SELECT * FROM tb_student WHERE native IN ('北京','天津','上海')；
```
##### 带LIKE关键字的字符串匹配查询
[NOT] LIKE '<匹配串>' [ESCAPE '<换码字符>']
常用通配符 "%"和 "_"
```
例如：查询学号为2014210102的学生的详细情况
SELECT * FROM tb_student
WHERE studentno LIKE '2014210102';

查询所有姓王的学生的学号、姓名和班号
SELECT studentno,studentname,classno FROM tb_student
WHERE studentname LIKE '王%';

查询姓名中包含林的学生的学号、姓名、和班号
SELECT studentno,studentname,classno FROM tb)student
WHERE studentname LIKE '%林%';

查询姓陈且姓名长度为三个中文的学生的学号、姓名和班号
SELECT studentno,studentname,class FROM tb_student
WHERE studentame LIKE '陈__';

```
##### 换码字符
当被检索的数据中含有通配符时
使用 ESCAPE '<换码字符>' 把通配符转换成普通字符
注意：%不能匹配控制NULL
```
查询课程名称中含有下划线“——”的课程信息
SELECT * FROM tb_course
WHERE coursename LIKE '%#_%' ESCAPE'#';

```

##### 使用正则表达式查询
检索或替换符合某个模式的文本内容
[NOT][ REGEXP | RLIKE ]<正则表达式>
```
查询课程名称中带有中文“系统”的课程信息
SELECT * FROM tb_course
WHERE coursename REDEXP '系统';

查询课程名称重含有管理 信息 系统 中文字符的所有课程信息
SELECT * FROM tb_course
WHERE coursename REGEXP '管理|信息|系统'；
```
##### IS NULL 或 IS NOT NULL
```
查询缺少先行课的课程信息
SELECT * FROM tb_course
WHERE priorcourse IS NULL;
```
##### 带AND或OR的多条件查询
AND 满足所有的查询条件的记录才会被返回
OR 满足其中一个查询条件的记录即可被返回
```
查询学分大于或等于3且学时数大于32的课程名称，学分和学时数
SELECT coursename,cresit,coursehour FROM tb_scourse
WHERE credit>=3 AND coursehour>32;

查询籍贯是北京或湖南的少数民族男生的姓名、籍贯和民族
SELECT studentname,,native,nation,FROM tb_student
WHERE (native='北京' OR native='湖南')AND nation!='汉' 
AND sex='男';
```

##### 对单表查询结果进行排序
ORDER BY
ASC 升序 DESC降序
```
例如：查询学生的姓名、籍贯和民族，并将查询结果按姓名升序排列
SELECT studentname,native,nation FROM tb_student
OEDER BY studentname;

例如：查询学生选课成绩大于85分的学号、课程号和成绩信息，并将查询结果先按学号升序排序再按成绩降序排序
SELECT * FROM tb_score WHERE score>85 
ORDER  BY studentno,score DESC;
注意:空值作为最小值进行排序

```
##### 限制查询结果的数量
LIMIT [位置偏移量,] 行数 或 LIMIT 行数 OFFSET 位置偏移量
第一行的位置偏移量是0，第二条是1
```
例如：查询成绩排名第三至第五的学生学号，课程号，成绩
SELECT studentno,courseno,score FROM tb_score ORDER BY score DESC LIMIT 2，3;

或

SELECT studentno,courseno,score FROM tb_score ORDER BY score DESC LIMIT 3 OFFSET 2;
注意:LIMIT子句必须位于ORDER BY 子句之后

```
##### 分组聚合查询
###### 使用聚合函数查询
COUNT() MAX() MIN() SUM() AVG()
```
例如：查询学生的总人数
SELECT COUNT(*) FROM tb_student;

例如: 查询选修了课程的学生总人数
SELECT COUNT(DISTINCT studentno) FROM tb_score;
//对去除重复之后的记录进行计数

计算学号2013110203的平均成绩
SELECT AVG(score) FROM tb_score WHERE studentno=2013110203  ;

计算学号2013110203的最高分
SELECT MAX(score) FROM tb_score WHERE studentno=2013110203;
```
######　分组聚合查询
GROUP BY 分组运算
```
[GROUP BY 字段列表][HAVING <条件表达式>]
查询各个课程号及相应的选课人数
SELECT courseno,COUNT(studentno) FROM tb_score
GROUP BY courseno;

查询每个学生的选课门数、平均分和最高分
SELECT studentno,COUNT(*) 选课门数,AVG(score) 平均分,
MAX(score) 最高分 FROM tb_score GROUP BY studentno;

查询平均分在85分以上的每个同学的选课门数、平均分和最高分
SELECT studentno,COUNT(*)选课门数,AVG(score)平均分,MAX(score) 最高分
FROM tb_score GROUP BY studentno
HAVING AVG(score)>=85;

查询所有学生选课的平均成绩 但只有当平均成绩大于等于85的情况下才输出
SELECT AVG(score)平均分 FROM tb_score HAVING AVG(score)>=85;

```
##### 连接查询
如果一个查询同时涉及两个或多个表，则称为连接查询
* 交叉查询
* 内连接
* 外连接
* 


######  交叉连接
会产生一些没有意义的记录 很少使用
SELECT * FROM 表1 CROSS JOIN 表2；
SELECT * FROM 表1，表2；
查询结果集的记录和等于所连接的两张表记录行数乘积
```
例如：查询学生表与成绩表的交叉连接
SELECT * FROM tb_student,tb_score;
```
###### 内连接(INNER JOIN)
```
SELECT 目标表达式1，目标表达式2，目标表达式3，...，目标表达式n
FROM 表1 [INNER] JOIN 表2 ON 连接条件 [WHERE 过滤条件];


SELECT 目标表达式1，目标表达式2，...，目标表达式n
FROM 表1,表2 WHERE 连接条件 [AND 过滤条件];
```
###### 等值连接与非等值连接
```
[<表名1>.]<字段名1> <比较运算符> [<表名2>.]<字段名2>

例如：查询每个学生选修课程的情况
SELECT tb_student.*,tbscore.*FROM tb_student,tb_score
WHERE tb_student.studentno=tb_score.studentno;

查询会计学院全体同学的学号、姓名、籍贯、班级编号和所在班级名称
SELECT studentno,studentname,native,tb_student.classno,classname
FROM tb_student,tb_clss
WHERE tb_student.classno=tb_class.classno AND
department='会计学院';

查询选修了课程名为管理学"的学生学号、姓名和成绩
SELECT a.studentno,studentname,score
FROM tb_student AS a,tb_course b,tb_score c
WHERE a.studentno=c.studentno AND b.courseno=c.courseno AND
coursename="管理学";
```
自连接
某个表与自身进行连接，需要为表指定多个不同的别名，且对所有查询字段的引用必须使用表别名限定
```
查询与"会计学"这门课程学分相同的课程信息
SELECT c1.* FROM tb_course c1,tb_course c2
WHERE c1.credit=c2.credit AND c2.coursename='会计学';
或
SELECT c1.* DORM tb_course c1. JOIN tb_course c2
ON c1.credit=c2.crdit
WHERE c2.coursename='会计学';
```
自然连接(NATURAL JOIN )
只有当连接字段在两张表中的字段名都相同时才可以使用，不需要指定连接条件
```
用自然连接查询每个学生及其选修课程的情况，要求显示学号 姓名 选修的课程和成绩
SELECT a.studentno,studentname,courseno,score
FROM tb_student a NATURAL JOIN tb_score b;
```
##### 外链接
左外连接(LEFT OUTER JOIN或LEFT JOIN)
```
例如：使用左外连接查询所有学生及其选修课程的情况，包括没有选修课程的学生，要求西安市
学号、姓名、性别、班号、选修课程号和成绩
SELECT a.studentno,studentname,sex,classno,courseno,score
FROM tb_student a LEFT OUTER JOIN tb_score b
ON a.studentno=b.studentno
```
右外连接(RIGHT OUTER JOIN 或 RIGHT JOIN)
```
例如:使用右外连接连接查询所有学生及其选修课程的 情况，包括没有选修的学生
要求显示学号、姓名、班号、选修的课程号和成绩

SELECT couseno,score,b.studentno,studentname,sex,classno
FROM tb_score a RIGHT OUTER JOIN tb_student b
ON a.studentno=b.studentno;
```
#### 子查询
##### 带IN关键字的子查询
```
查询选修了课程的学生姓名

SELECT studentname FROM tb_student
WHERE tb_student.studentno IN (SELECT DISTINCT tb_score.studentno FROM tb_score);



查询没选修课程的学生姓名

SELECT studentname FROM tb_student
WHERE tb_student.studentno NOT IN (SELECT DISTINCT tb_score.studentno FROM tb_score);

```

##### 带比较运算符的子查询
```
查询班级"会计13-1"所有学生的学号，姓名
SELECT studentno,studentname FROM tb_student
WHERE classno = (SELECT classno FROM tb_class WHERE classname='会计13-1班')

查询与'孟颖'在同一个班的学生的学号、姓名
SELECT studentno,studentname,classno FROM tb_student s1
WHERE clasno = (SELECT classno FROM tb_student s2 WHERE studentname=)
AND studentname!='孟颖';

查询男生中比某个女生出生年份晚的学生姓名和出生年份
SELECT studentname,YEAR(birthday) FROM tb_student
WHERE sex='男' AND YEAR(birthday)> ANY
(SELECT YEAR(birthday) FROM tb_student WHERE sex='女')

查询男生中比所有女生出生年份晚的学生姓名和出生年份
SELECT studentname,YEAR(birthday) FROM tb_student
WHERE sex='男' AND YEAR(birthday)> ALL
(SELECT YEAR(birthday) FROM tb_student WHERE sex='女')

```
##### 带EXISTS 或 NOT EXISTS关键字的子查询
带EXISTS子查询只返回TRUE和FALSE，内层查询的SELECT子名给出字段名没有实际意义
目标列表达式通畅用*
```
查询选修了课程11003的学生姓名
SELECT studentname FROM tb_student a
WHERE EXISTS
(SELECT * FROM tb_score b WHERE a.studentno = b.studentno
AND courseno = 11003);


查询选修了课程11003的学生姓名
SELECT studentname FROM tb_student
WHERE studentno IN
(SELECT studentno FROM tb_score WHERE
courseno=11003);

查询没有选修课程11003的学生姓名
SELECT studentname FROM tb_student a 
WHERE NOT EXISTS
(SELECT * FROM tb_score b WHERE a.studentno=b.studentno AND 
courseno=11003);

查询没有选修课程11003的学生姓名
SELECT studentname FROM tb_student a 
WHERE NOT IN
(SELECT * FROM tb_score b WHERE a.studentno=b.studentno AND 
courseno=11003);

```

##### 联合查询
可把来自多个SELECT语句的结果组合到一个结果集中
合并时，多个SELECT子句对应的字段数和数据类型必须相同
```
SELECT-FROM-WHERE
UNION [ALL]
SELECT-FROM-WHERE
[...UNION[ALL]]
SELECT-FROM-WHERE]


使用UNION ALL联合查询选修了会计学或计算机基础学生学号
SELECT studentno FROM tb_score,tb_course
WHERE tb_score.courseno=tb_coursee.courseno AND
coursename='会计学'
UNION //不加ALL则会去除重复
SELECT studentno FROM tb_score,tb_course
WHERE tb_score.courseno=tb_course.courseno AND
coursename='计算机基础';

查询选修了 会计学 和 计算机基础 学生学号
SELECT studentno FROM tb_score,tb_course
WHERE tb_score.courseno=tb_course.courseno AND
coursename='会计学' AND studentno IN (
SELECT studentno FROM tb_score,tb_course
WHERE tb_score.courseno=tb_course.courseno AND
coursename='计算机基础');


查询选修了 会计学 但没有选修 计算机基础 学生学号
SELECT studentno FROM tb_score,tb_course
WHERE tb_score.courseno=tb_course.courseno AND
coursename='会计学' AND studentno NOT IN (
SELECT studentno FROM tb_score,tb_course
WHERE tb_score.courseno=tb_course.courseno AND
coursename='计算机基础');
```

#### 插入数据
##### 插入完整的数据记录
```
INSERT INTO tb_name(column_list)VALUES(value_list)
tb_name 表名
colum_list 字段，如向所有列插入数据，列名可省略
但不安全，日过只是部分列插入数据，需要明确指定字段
VALUES 子句 数据顺序与列的顺序相对应

例如 向表tb_student中插入一条记录('2014210102','王玲','女','1998-02-12','安徽','汉','CS1401')

INSERT INTO tb_student VALUES ('2014210102','王玲','女','1998-02-12','安徽','汉','CS1401')
这些值的顺序必须和表中定义的顺序完全相同

向表tb_student中插入一条记录('2014210102','赵婷婷','女'，'1996-11-30','天津','汉','AC1301')
INSERT INTO tb_student(student,studentname,seex,birthday,native,nation,classno)
VALUES
('2014210102','赵婷婷','女'，'1996-11-30','天津','汉','AC1301')


向表tb_student中插入一条记录,学号为2014310103，姓名为孙新，性别为男，民族傣，班号为IS1401

INSERT INTO tb_student
(studentno,studentname,sex,nation,classno)
VALUES
('2014310103','孙新','男','傣','IS1401');
```
##### 同时插入多条记录
向数据表中插入多条记录时，每个值列表之间用逗号分隔

```
INSERT INTO tb_name(column_list)
VALUES(values_list1),(value_list2)...(value_listn);
```
##### 插入查询结果
INSERT 语句还可将SELECT语句查询的结果插入到表中
```
INSERT INTO tb_name1(column_list1)
SELECT solumn_list2 FROM tb_name2 WHERE(condition)
两个列表(column_list1,column_list2)中的字段个数必须相同，且数据类型匹配

例如:假设要为表tb_student制作一个备份表tb_student_copy两个表结构完全一致
使用INSERT...SELECT语句将表tb_student中的数据备份到表tb_student_copy中

CREATE TABLE tb_student_copy(
studentno CHAR(10),
studentname VARCHAR(20) NOT NULL
sex CHAR(2) NOT NULL
birthday DATE,
narive VARCHAR(20),
nation VARCHAR(20),
classno char(6),
CONSTRAINT pk_student PRIMARY KEY (studentno);
)

INSERT INTO
tb_student_copy(studentno,studentname,sex,birthday,native,nation,classno)
SELECT
studentno,studentname,sex,birthday,native,nation,classno FROM tb_student;
``` 

##### 使用REPLACE语句插入表数据
使用REPLACE语句可在插入数据之前将表中与待插入的新纪录相冲突的旧记录删除，从而保证新纪录能正常插入
```
REPLACE INTO tb_name(column_list)
VALUES(value_list);

当前表tb_student_copy中已存在一条记录('2014310107','赵鹏','男','1997-10-16','吉林','朝鲜','IS1401')其中sttudentno是主键，现向表再次插入一行数据('2014310107','周旭','男','1997-10-17','湖南','朝鲜','AC1301')

REPLACE INTO
tb_student_copy(studentno,studentname,sex,birthday,native,nation,classno)
VALUES('2014310107','周旭','男','1997-10-17','湖南','朝鲜','AC1301')

Ps：如果数据表中的某个字段上定义了外码，使用REPLACE INTO插入数据时依然会出错

```

##### 修改数据记录
```
UPADTE tb_name
SET
column1=value1,column2=value2...,columnn=valuen
[WHERE <condition>]

修改特定数据记录
例如 通过WHERE子句指定被修改的记录所需满足的条件
将表tb_student中学号为"2014210102" 的学生姓名改为"黄涛"
籍贯修改为"湖北",民族修改为缺省值。

UPDATE tb_student
SET studentname="黄涛",native="湖北",nation="汉"
WHERE studentno='2014210102';


不需要指定WHERE子句的情况
例如：将表tb_score所有学生的成绩提高5%
UPDATE tb_score
SET score=score*1.05;


如果待修改数据的表与设置修改条件的表不相同，需要用子查询来构造修改条件
例如:将选修"程序设计"这门课程的学生成绩置零
UPDATE tb_score
SET score=0
WHERE courseno=(SELECT course FROM  
tb_course WHERE coursename="程序设计");


实操题目
 使用UPDATE语句将数据库db_test的表content中留言人姓名为"MYSQL初学者"的留言内容修改为"如何使用INSERT语句"
 USE db_test;
 UPDATE content
 SET words='如何使用INSERT语句' WHERE
 username='MYSQL初学者';

实操题目
使用UPDATE语句将数据库mysql_test的表customers中姓名为'李四'的cust_contact的值更新为"武汉"
UPDATE mysql_test.customers
SET cust_contact='武汉' WHERE cust_name='李四';

```

##### 删除数据记录
```
DELETE FROM tb_name [WHERE <conditions>]
```
```
删除特定的数据记录
通过WHERE子句指定被删除的记录所需满足的条件
例如:删除表tb_student中姓名为"孟颖"学生记录
DELETE FROM tb_student WHERE studentname="孟颖";

如果待删除的数据表与设置删除条件的表不相同
需要用子查询来构造删除条件

例如：将"程序设计"这门课程的所有选课记录删除
DELETE FROM tb_score WHERE courseno
=(SELECT courseno FROM tb_score WHERE
coursename='程序设计')；
```
##### 删除所有的数据记录
```
DELETE语句删除的是表中数据,而不会删除表的定义
例如：
删除所有学生的选课记录
DELETE FROM tb_score;
```
```
TRUNCATE语句，执行的速度比DETELE操作更快
使用TRUNCATE语句删除数据表tb_student的备份tb_student_copy中的所有记录
TRUNCATE tb_student_copy;

```
```
实操题目
使用DETELE语句将数据库db_test的表content中留言人姓名为"MYSQL初学者"的留言信息删除
DETELE FROM db_test.contect WHERE
username='MYSQL初学者';

使用DETELE语句将数据库mysql_test.customers WHERE cust_address='南京';

```

### 索引
> 索引是一张描述索引的列值与原表中的记录行之间一一对应关系的有序表，好比是一本书的目录，可加快数据库的查询速度，用来定位。

根据用途，索引分为：
* 普通索引(INDEX) ,INDEX或KEY创建，可以取空值或者重复
* 唯一性索引(UNIQUE),索引列中所有值只能出现一次，可以使空值
* 主键(PRIMARY KEY),每个表中只能有一个主键，不能为空
* 全文索引(FULLTEXT) 只能在VARCHAR或TEXT MyISAM中创建
* 聚簇索引，物理存储顺序
索引在实际应用中又可分为； 
* 单列索引
* 组合索引，也称复合索引或多列索引

##### 查看数据表上建立的索引
SHOW {INDEX|INDEXS|KEYS} {FROM|IN} tbl_name
[{FROM|IN} db_name]

```
例如:
SHOW INDEX FROM db_school.tb_score \G;
```

##### 创建索引
1.使用CREATE TABLE创建索引
```
CREATE TABLE tbl_name [col_name data_type]
[CONSTRAINT index_name] [UNIQUE] [INDEX | KEY]
[index_name] (index_col_name [length]) [ASC|DESC]
```

```
例如:
在创建新表的同时建立普通索引，建立一个表tb_student1,在创建表的同时在studentname字段上建立普通索引
CREATE TABLE tb_student1(
studentno CHAR(10) NOT NULL,
studentname CHAR(10) NOT NULL,
sex CHAR(2) NOT NULL,
birthday DATE,
native VARCHAR(20),
nation VARCHAR(10) DEFAULT '汉',
classno char(6),
INDEX (studentname));
```

```
在创建新表的同时建立唯一索引,建立一个表tb_student2,
在创建表的同时在studentno字段上建立唯一性索引
CREATE TABLE tb_student2(
studentno CHAR(10) NOT NULL UNIQUE,
studentname VARCHAR(20) NOT NULL,
sex CHAR(2) NOT NULL
birthday DATE,
native VARCHAR(20),
nation VARCHAR(10) DEFAULT '汉',
classno char(6)
);
```

```
在创建新表的同时建立主键索引
CREATE TABLE tb_score1(
studentno CHAR(10),
courseno char(5),
score float
);

在MYSQL中,创建表时,若指定表的主键或外键系统自动建立索引


在创建新表的同时建立主键索引
CREATE TABLE tb_score2(
studentno CHAR(10),
courseno char(5),
score float,
CONSTRAINT pl_score PRIMARY KEY (studentno,corse),
CONSTRAINT fl_score1 FOREIGN KEY(studentno) REFERENCES
tb_student(studentno),
CONSTRAINT fl_score2 FOREIGN KEY(courseno) REFERENCES
tb_course(courseno)

);

```

##### 2.使用CREATE INDEX创建普通索引
```
CREATE [UNIQUE] INDEX index_name
ON tbl_name(col_name [(length] [ASC | DESC],...);

例如:在表tb_student上建立一个普通索引，索引字段是学号studentno

CREATE INDEX index_stu ON
db_school.tb_student(studentno);


```

```
创建基于字段值前缀字符的索引
在表tb_course上建立一个索引，按课时名称coursename值的前三个字符建立降序索引

CREATE INDEX index_course ON
db_school.tb_course(coursename(3) DESC);

```

```

创建组合索引
在表tb_book上建立图书类别(升序)和书名(降序)
组合索引,索引名称为index_book
CREATE INDEX index_book ON
db_school.tb_book(bclassno,bookname DESC);

```

```
用CREATE INDEX在db_test数据库的content表中,根据留言标题列的前三个字符采用默认的索引类型建立一个升序索引index_subject

USE db_test;
CREATE INDEX index_subject
ON content(subject(3) ASC);
```

##### 使用ALTER TABLE创建索引
ALTER TABLE tbl_name ADD [UNIQUE|FULLTEXT]
[INDEX|KEY] [index_name]
(col_name[length] [ASC|DESC],...)

```
使用 ALTER TABLE 语句建立普通索引,在tb_student1表studentname列上建立一个普通索引，索引名为idx_studentname
ALTER TABLE db_school.tb_student1
ADD INDEX idx_studentname(studentname);
```
创建普通索引时 通常使用的饿关键字是INDEX或KEY
创建唯一性索引时，通常使用的关键字是UNIQUE

### 删除索引
#### 使用DROP INDEX删除索引
```
DROP INDEX index_name ON tbl_name

例如:删除索引index_studentname
DROP INDEX index_studentname ON
db_school.tb_student1;
```

#### 使用ALTER TABLE删除索引
```
ALTER TABLE tbl_name DROP INDEX index_name

例如:使用ALTER TABLE 删除索引
ALTER TABLE db_school.tb_student
DROP INDEX index_stu;


```

PS:所删除的列是索引的组成部分，则该列也会从索引中删除
    组成缩印的所有列都被删除，整个索引将被删除
    
索引弊端：
在提高查询速度的同时，降低更新表中数据的速度
索引以文件形式存储，增加存储空间 

### 视图

#### 创建视图
```
CREATE [OR REPLACE] VIEW view_name[(column_list)]
AS select_statement [WITH [CASCADED | LOCAL] CHECK OPTION]

OR REPLACE 替换数据库中已有同名视图
view_name 视图名称 数据库中唯一，不能与其他表或视图同名
WITH CHECK OPTION 视图上所进行的修改都需要符合select_statement 中所限定的条件
```
```
在数据库db_school中创建视图v_student,要求驶入包含tb_student表中所有男生的信息，并且要求保证今后对该图数据的修改都必须符合学生性别为男这个条件

CREATE OR REPLACE VIEW db_school.v_student
AS
SELECT * FROM db_school.tbstudent
WHERE sex='男'
WITH CHECK OPTION;

```

```
在数据库db_school中创建视图v_score_avg,要求视图tb_score表中所有学生的学号和平均成绩，并按学号studentno进行排序

CREATE VIEW db_school.v_score_avg(studentno,score_avg)
AS
SELECT studentno,AVG(score) FROM tb_score
GROUP BY studentno;

```
```
在数据库db_test中创建视图content_view,要求该视图包含表content找那个所有留言人姓名为"MYSQL初学者"的信息，并且要求保证今后对该视图数据的修改都必须符合留言人姓名为"MYSQL"这个条件
USE db_test;
CREATE VIEW content_view AS
SELECT * FROM content
WHERE username='MYSQL初学者'
WITH CHECK OPTION;
```
##### WITH CHECK OPTION
```
对数据库db_school中的表tb_score创建视图v_score,要求视图包含表tb_score中所有score<90的学生学号、课程号和成绩信息，分别使用WITH LOCAL CHECK OPTION 、
WITH CASCADDED CHECK OPTION子句创建视图v_score_local和v_score_cascades要求改视图包含表tb_score中所有score>80的学生学号、课程号和成绩信息。

CREATE VIEW v_score AS
SELECT * FROM db_school.tb_score WHERE score<90
WITH CHECK OPTION;


CREATE VIEW v_score_local AS
SELECT * FROM db_school.v_score WHERE score>80
WITH LOCAL CHECK OPTION;//每次更新数据只检查数据是否满足自身条件

CREATE VIEW v_score_cascaded AS
SELECT * FROM db_school.v_score WHERE score>80
WITH CASCADED CHECK OPTION;//每次更新数据除了检查是否满足自身条件外，还检查是否满足其他视图条件
```
##### 删除视图

```
DEOP VIEW［IF EXISTS］view_name[,view_name]...

Eg:
DROP VIEW IF EXIST db_school.v_student;
```
##### 修改视图
```
ALTER VIEW view_name [(column_list)]
AS select_statement
[WITH [CASCADED|LOCAL] CHECK OPTION]
```
```
修改视图v_student的定义，要求视图包含学生表tb_student中性别为'男'
民族为汉的学生学号、姓名和所属班级，并且要去保证今后对该视图数据的修改都
必须符合学生性别为"男"，民族为汉这个条件
ALTER VIEW
db_school.v_student(studentno,studentname,classno)
AS
SELECT studentno,studentname,classno FROM
db_school.tb_student
WHERE sex='男' AND nation='汉'
WITH CHECK OPTION;
```
```
使用CREATE OR REPLACE VIEW语句修改视图v_student的定义，
要求视图包含学生表tb_student中性别为'男'
民族为汉的学生学号、姓名和所属班级，并且要去保证今后对该视图数据的修改都
必须符合学生性别为"男"，民族为汉这个条件

CREATE OR REPLACE VIEW
db_school.v_student(studentno,studentname,classno)
AS
SELECT studentno,studentname,classno FROM
db_school.tb_student
WHERE sex='男' AND nation='汉'
WITH CHECK OPTION;
```

##### 查看视图定义
```
SHOW CREATE VIEW view_name;
```

##### 更新视图数据
只有满足可更新条件的视图才能进行更新 需要该视图中的行和基础表哦的行是一对一的关系

下列情况视图不可更新
聚合函数、DISTINCT关键字、GROUP BY子句
ORDER BY子句 HAVING子句、UNION运算符
选择列表中的子查询、FROM子句包含多个表、WHERE子句中的子查询
SELECT语句中引用了不可更新的视图等。

##### 更新视图数据

```
例如：想视图v_student插入下面一条记录(2014310108,'周明','男','1997-08-16','辽宁','汉','IS1401')

INSERT INTO db_school.v_student VALUES (2014310108,'周明','男','1997-08-16','辽宁','汉','IS1401')

```

```
使用UPDATE语句通过视图修改基础表的数据

例如：
将视图v_student中所有学生native列更新为"河南"
UPDATE db_school.v_student SET native='河南';
```

```
使用DELETE语句通过视图修改基础表的数据

例如:
删除视图v_student中姓名为'周明'的学生信息

DETELE FROM db_school.v_student
WHERE studentname='周明';

```

##### 查询视图数据
```
在v_student中查找classno为IS1401的学生学号和姓名
SELECT studentno,studentname
FROM v_student
WHERE classno='IS1401';
```

##### 触发器
触发器用于保护表中的数据，当有操作影响到触发器所保护的数据时，触发器会自动执行
保障数据库中国数据的完整性，以及一致性
MYSQL响应INSERT、UPDATE和DELETE语句而自动执行的一条MYSQL语句，位于BEGIN和END语句之间

##### 创建触发器
```
CREATE TRIGGER trigger_name trigger_time trigger_event
ON tbl_name FOR EACH ROW trigger_body

trigger_name 触发器名称唯一
trigger_time 触发器被触发的时刻，分为BEFORE 和AFTER
trigger_event 触发事件，分为INSERT UPDATE DELETE
tbl_name引用永久性表，同一个表不能拥有两个相同触发时刻和事件的触发器
FOR EACH ROW 每一行都能激活触发器
trigger_body 动作主体，如执行多个语句，可用BEGIN...END结构


在数据库db_school的tb_student表中创建一个触发器tb_student_insert_trigger用于每次向表tb_student钟插入一行数据时，将学生变量str的值设置为"one student added!""

CREATE TRIGGER db_school.tb_student_insert_trigger
AFTER INSERT ON db_school.tb_student
FOR EACH ROW SET @str='one student added!'
```

##### 查看触发器
```
SHOW TRIGGERS [{FROM | IN} db_name]
```

##### 删除触发器
DROP TRIGGER [IF EXISTS] [schema_name,]
trigger_name

删除表的同时删除触发器，触发器不能更新或覆盖，只能先删除再重新创建
```
删除数据库db_school中的触发器
tb_student_insert_trigger

DROP TRIGGER IF EXISTS db_school.tb_student_insert_trigger;
```

###### INSERT触发器
可引用一个名为NEW的虚拟表，来访问被插入的行；在BEFORE INSERT触发器中，NEW中的值可更新

```
例如
在数据库db_school的表tb_student上重新创建触发器tb_student_insert_trigger用于每次向表tb_student中插入一行数据，将用户变量str的值设置为新插入的学生的学号

CREATE TRIGGER db_school.tb_student_insert_trigger
AFTER INSERT
ON db_school.tb_student FROM EACH ROW SET
@str=NEW.studentno;


假设有两个表tb1和tb2分别都只有一个字段tb1_id和tb2_id，通过触发器实现增加tb1中的记录后自动将记录增加到tb2

CREATE TRIGGER t_afterinsert_on_tb1 AFTER INSERT ON
tb1 FOR EACH ROW
insert into tb2(tb2_id)values(NEW.tb1_id);

检验：
INSERT into tb1 values(1);
select * from tb1;
select * from tb2;
```
###### DELETE触发器
可引用一个名为OLD的虚拟表来访问被删除的行，OLD中的值全部只读不能被更新

```
例如：
在数据库db_test的表content中创建一个触发器content_delete_trigger用于每次
删除表content中一行数据时，将用户变量设置成"old content deleted"

USE db_test;
CREATE TRIGGER content_delete_trigger AFTER DELETE ON
content FOR EACH ROW SET @str="old content deleted!";

通过触发器实现删除tb1中的记录后自动将tb2中的记录删除

CRETAE TRIGGER t_afterdelete_on_tb1 AFTER DELETE
ON tb1 FOR EACH ROW
delete from tb2 where tb2.id=old.tb1.id;
```
###### UPDATE触发器
可以引用OLD虚拟表访问以前的数据，也可以引用NEW虚拟表访问更新后的数据；
在BEFORE UPDATE触发器中，NEW值可更新，触发器涉及对表自身的更改操作时
只能使用BEFORE UPATE触发器
```
例题：
在db_school的表tb_student中创建一个触发器
tb_student_updent_trigger,用于每次更新表tb_student时将该表中nation列中的值设置为native列的值

USE db_school;
CREATE TRIGGER ttb_student_update_trigger
BEFORE UPDATE ON tb_student FOR EACH ROW 
SET NEW.nation=OLD.native;
```
MYSQL支持的触发器是比较低级的
执行时自动的
多用除非保证数据的一致性，完整性，和正确性
可使用触发器吧表更改状态之前和之后的状态记录到另一张数据表中


### 事件
* MYSQL5.1版本起，事件才开始被支持
* 事件指在指定的时刻才被执行的某些特定任务，通常是一些确定的SQL语句，通过事件调度器执行
* 是临时触发器，但事件是基于特定时间周期触发来执行任务，触发器是基于某个表所产生的事件触发

通过以下语句查看事件调度器是否开启
SHOW VARIABLES LIKE 'EVENT_SCHEDULER'
或
SELECT @@EVENT_SCHEDULER;

激活事件调度器
SET GLOBAL EVENT_SCHEDULER=1;

##### 创建事件
```
CREATE EVENT [IF NOT EXISTS] event_name
ON SCHEDULE schedule
[ENABLE | DISABLE | DISABLE ON SLAVE] DO event_body

schedule:AT timestamp [+INTERVAL interval]...| EVERY interval
[STARTS timestamp [+INTERVAL interval]...]
ENDS timestamp [+INTERVAL interval]...}
interval:YEAR | QUARTER | MONTH | DAY | HOUR | MINUTE
| WEEK | SECOND | YEAR_MONTH | DAY_HOUR | DAY_MINUTE |
DAY_SECOND | HOUR_MINUTE | HOUR_SECOND |
MINUTE_SECOND

schedule:时间调度，AT子句指定在某个时刻发生
EVERY子句用于表示事件在指定时间区间内每间隔多长时间发生一次
其中STARTS子句用于指定开始的时间
ENDS子句用于指定结束时间
EVENT)body:指定事件启动时执行的代码，多条语句时可使用BEGIN....END结构

```

```
在数据库db_school中创建一个事件，用于每个月向表tb_student中插入一条数据，该事件
开始于下个月并且在2016年12月31号结束

USE db_school;
DELIMITER $$ //重新定义结束符，也就是用$$替换分号
CREATE EVENT IF NOT EXISTS event_insert
ON SCHEDULE EVERY 1 MONTH
STARTS CURDATE()+INTERVAL 1 MONTH //获取当前时间并间隔一个月之后
ENDS '2016-12-31'
DO
BEGIN
IF YEAR(CURDATE()) <= 2016 THEN
INSERT INTO tb_student
VALUES(NULL ,'张小勇' ,'男','1997-12-11','山西','汉','AC1301');
END IF;
END $$

```

```
在数据库db_test中创建一个事件，用于每个月将表customers中姓名为"mysql初学者"
的留言信息全部删除，该事件开始于下月并在2016年12月31日结束

USE db_test;
DELIMITER $$
CREATE EVENT IF NOT EXISTS event_delete_content
ON SCHDULE EVERT 1 MONTH
STARTS CURDATE()+INTERVAL 1 MONTH
ENDS '2016-12-31'
DO
BEGIN
IF YEAR(CURDATE())<=2016 THEN
DELETE FROM content
WHERE username='mysql'；
NED IF;
END $$
```

##### 修改事件
```
ALTER EVENT event_name [ON SCHEDULE schedule]
[RENAME TO new_event_name]
[ENABLE | DISABLE | DISABLE ON SLAVE]
[DO event_body]
```
```
例如：
临时关闭事件event_insert
ALTER EVENT event_insert DISABLE

开启临时关闭的事件event_insert
ALTER EVENT event_insert ENABLE;

将event_insert的名字改为e_insert
ALTER EVENT event_insert RENAME TO e_insert;

```

##### 删除事件
DROP EVENT [IF EXISTS] event_name
```
例如:
删除名为e_insert的事件

DROP EVENT IF EXISTS e_insert;
```

# 存储过程与存储函数
* 了解MYSQL中存储函数的使用方法及其存储过程的区别
* 掌握MYSQL中存储过程的使用方法

## 存储过程
> 存储过程是一组为了完成某种特定功能的SQl语句集，由声明式的SQl语句(如CREATE UPDATE等语句)和过程式的SQL语句(如 IF-THEN-ELSE控制结构语句)组成，经编译后存储在数据库中，用户通过存储过程名称和参数即可调用执行

* 优点：
    * 增强SQl语句的功能和灵活性
    * 良好的封装性
    * 高性能
    * 减少网络流量
    * 作为安全机制来确保数据库的安全性和数据的完整性
    * 
    * 

### 创建存储过程
```
CREATE PROCEDURE sp_name([proc_parameter[,...]])
[characteristic...] routine_body

sp_name 名称 避免与MYSQL的内置函数相同
proc_parameter:参数列表 格式为
[IN | OUT | INOUT] param_name type,多个参数之间用逗号隔开，可以
没有参数，但是必须有括号，参数名与列名不能相同
routine_body 主体部分，包含过程调用时必须执行的SQL语句，以BEGIN
开始,END结束，可嵌套使用BEGIN-END
DELIMITER:可将MYSQL语句的结束标志临时修改为其他符号，格式：
DELTMITER $$ 需注意避免使用后"\“字符

```

```
在数据库db_school中创建一个存储过程，用于实现给定表tb_student中一个
学生的学号即可修改表tb_student中该学生的性别为一个指定的性别

USE db_school;
DELIMITER $$
CREATE PROCEDURE sp_upade_sex(IN sno CHAR(20) , IN ssex CHAR(2))
BEGIN
IPDATE tb_studemt SET sex=ssex WHERE
studentno = sno;
END $$
```

### 查看存储过程
SHOW PROCEDURE STATUS

### 查看存储过程的具体信息
SHOW CREATE PROCEDU sp_name  

### 存储过程体
##### 1.局部变量
```
DECLACE var_name [,...]type[DEFAUTE value]

例如 声明一个字符型局部变量sno
DECLARE sno CHAR(10);

注意：只能存储过程体的BEGIN...END语句块中，在存储过程体开头处声明
作用局限于BRGIN...END语句块，声明时前面没有使用@，不同于用户变量

```

##### 2.SET语句
```
SET var_name = expr[,var_name=expr]...
```
```
例如：将之前声明的局部变量sno赋予"2013110101"
SET sno='2013110101';

```
###### 3.SELECT...INTO语句
```
SELECT col_name[,...] INTO var_name[,...] table_expr
```
返回的结果集只能有一行数据

##### 4.流程控制语句
* 条件判断语句
```
IF search_condition THEN statement_list
[ELSE IF search_condition THEN statement_list]...
[ELSE statement_list]
END IF
```
* CASE条件判断语句
```
写法一：

CASE case_value
WHEN when_value THEN statenemrnt_list
[WHEN when_value THEN statement_list]
[ELSE statement_list]
END CASE
```

```
写法二：

CASE
    WHEN search_condition THEN statement_list
    [WHEN sraech_condition THEN statement_list]
    [ELSE statement_list]
END CASE
```

* WHILE 循环
```
[begin_label:] WHILE search_condition DO 
statenement_list
END WHILE[END _label]
```
* REPEAT 循环
条件为假继续循环，条件为真继续循环
```
[begin_label:]REPEAT statement_list
UNTIL search_condition
END REPEAT[end_label]
```
* LOOP循环
```
[begin_label:]LOOP statement_list
END LOOP[end_label]
一致循环直到使用LEAVE语句退出整个循环

ITERATE label可使用在三个循环当中，退出当前循环
```
##### 游标
存储过程中的SELECT...INTO返回的是一行数据，而SELECT进行检索时返回的是
一组结果集的数据行，通过游标来一行一行处理
注：游标可用于存储函数与存储过程，一个BEGIN...END语句块中游标名字唯一，是SELECT检索出来的结果集

```
声明游标
SECLARE cursor_name CURSOR FOR select_statement

打开游标
OPEN cursor_name

读取数据
FETCH cursor_name INTO var_name[,var_name]

关闭游标
CLOSE sursor_name

```

```
在数据库db_school中创建一个存储过程，用于计算表tb_student中数据行的行数

USE db_school;
DELIMITER $$
CREATE PROCEDURE sp_sumpfrow(OUT ROWS INT)
BEGIN
    DECLARE sno CHAR(10);
    DECLRE F BOOLEAN DEFAULT TRUE;
    DECLARE cur CURSOR FOR
        SELECT studentno FROM tb_student;
    DECLARE CONTINUE HANDLER FOR NOT FOUND
        SET F=FALSE;
    SET ROWS=0;
    OPEN cur;
    FETCH cur INTO sno;
    WHILE F DO
        SET ROWS=ROWS+1;
        FETCH cur INTO sno;
    END WHILE
    CLOSE cur;
END $$
DELIMITER ;

调用存储过程
CALL sp_sumofrow(@rows);
查看存储过程的结果
SELECT @rows;
```
注意：
    CONTUNE HANDLER句柄用于控制循环语句 实现游标的下移
    DECLARE定义顺序：局部变量 游标 句柄

##### 调用存储过程
```
CALL sp_name([parameter[,..]])
CALL sp_name[()]
```

```
例如：调用数据库db_school中的存储过程sp_update_sex,将学号为"20131110203"的学生性别修改为'男'
CALL sp_update_sex(2013110202,'男')；
```
##### 删除存储过程
```
DROP PROCEDURE [IF EXISTS] sp_name
```
```
例如：
删除数据库db_school中存储过程sp_update_sex
DROP PROCEDURE sp_update_sex;
```

```
题目：
在数据库db_test中创建一个存储过程，用于实现给定表中content中留言人的姓名即可修改表content中该留言人的电子邮件地址为一个给定的值

USE db_test;
DELIMITER $$
CREATE PROCEDURE sp_update_email(IN user_name VARCHAR(50),IN e-mail VARCHAR(50))
BEGIN
    UPDATE content SET email=e_mail WHERE username=user_nmae;
END $$

检测

DELIMITER
CALL sp_update_email('mysql初学者','wanghua@hoatmail.com')
SELECT * FROM content;

```

### 存储函数
存储过程与存储函数的区别
存储函数不能有输出参数，存储过程可以有
直接调用存储函数不需要CALL
存储函数中必须包含RETRRN有进步，存储过程不允许

##### 创建存储函数
```
CREATE FUNCTION sp_name([dunc_parameter[,...]])
RETURNS type routine_body

sp_name 不能与存储过程具有相同的名字
funv_paramenter 参数只能有参数名和参数类型，不能有IN OUT INOUT
RETURNS 声明返回值的数据类型 通过哟type指定
routine_body：存储函数体，必须包含一个RETURN value语句
```

```
例如：在数据库db_school中创建一个存储函数，要求函数能根据给定的学号返回学生的
性别，如果数据库中没有该学号  则返回“没有该学生”

USE db_school;
DELIMITER $$
CREATE FUNCTION fn_search(sno CHAR(10))
    RETURN CHAR(10)
    DETERMINISTIC
BEGIN
    DECLARE ssex CHAR(2)
    SELECT sex INTO ssex FROM tb_student\
        WHERE studentno=sno;
    IF ssex IS NULL THEN
        RETURN(SELECT '没有该学生')；
    ELSE IF ssex='女' THEN
        RETURN(SELECt '女')；
      ELSE RETURN(SELECT '男');
      END IF;
     END IF;
END $$
```

注意：RETURN返回包含SELECT语句时，SELECT返回结果只能是一行且只能有一列值

查看数据库中存在哪些存储函数
SHOW FUNCTION STATUS
查看数据库中某个具体的存储函数
SHOW CREATE FUNCTION sp_name

#### 调用存储函数
```
SELECT sp_name([func_paramrter[,..]])
```

```
例如：调用数据库db_school的存储函数fn_search
SELECT fn_search('20121101010');
```

#### 删除存储函数
```
DROP FUNCTION [IF EXISTS] sp_name
```
```
例如：删除数据库db_school中存储函数fn_search
DROP FUNCTION IF EXISTS fn_search;
```

# 访问控制与安全管理
## 用户账号管理
MYSQL中的用户账户以及相关信息都存储在一个名为mysql的MYSQl数据库中，user表中
user列存储用户名
SELECT user FROM mysql.user;
//查看当前数据库的用户名列表
root对整个MYSQL服务器具有完全的控制的权限

### 创建用户账号
```
CREATE USER user_specification[,user_specification]...

user_specification:user[
IDENTIFIED BY [PASSWORD] 'password' |
IDENTIFIED WITH auth_plugin[AS 'quth_string']] 

user:格式为'user_name' @ 'host_name' ,如果没给出主机名，
主机名默认为 "%"
IDENTIFIED BY 子句:指定账号对应口令
PASSWORD :用于指定散列口令
password :指定账号口令，由字母和数字组成的明文
```

```
在MYSQL服务器中添加两个新的用户，其用户名分别为zhangsan和lisi,它们的主机名均为
localhost,用户zhangsan的口令设置为明文123,用户lisi的口令设置为对明文456使用
PASSWORD()函数返回的散列值

SELECT PASSWORD(456);
//显示456的散列值

CREATE USER 'zhangsan' @ 'localhost' IDETIFIED BY '123' , 
'lisi' @ 'localhost' IDENTIFIED BY PASSWORD
'*F4A84EF3A1E5F4A6EF51FAE54F13A5E1F5E4F68EF4R4A4F3AA4TG3YT4343YUJ';


```
* 说明：
    * 使用CREATE USER语句,必须具有mysql数据库的INSERT权限或全局CREATE USER 权限
    * 创建用户后,mysql中user表添加一条新记录
    * 如果两用户同名不同主机名，会视为不同用户；
    * 如果没有为用户指定口令，可以不使用口令登录系统，
    * 新建的用户权限很少

    
### 删除用户
DROP USER user[,user]...
例如：删除前面创建的用户lisi
DROP USER lisi@localhost;

* 说明
    * 使用DROP USER 语句，必须具有mysql数据库的DELETE权限或全局CREATE USER 权限
    * 使用DROP USER 语句时，没有明确给出账户主机名，会默认%；
    * 删除用户并不会影响他们建的表等其他数据库对象。
    

### 修改用户账户
```
RENAME USER old_user TO new_user [,old_user TO new_user]...
```
例如：将前例中用户zhangsan的名字改为wangwu
RENAME USER 'zhangsan'@'loaclhost' TO 'wangwu'@'localhost';

### 修改用户口令
SET PASSWORD[FOR user]={PASSWORD('new_password')|'encrypted password'}

```
例如：
将前例中wangwu的口令修改为明文'hello'对应的散列值
SELECT PASSWORD('hello');
//显示hello的散列值

SET PASSWORD FOR 'wangwu'@'localhost'='*4F6A4DF6A4SFD6A4EF4AE3F13ASE31F54A8ES9';
```

### 查看账户权限
SHOW GRANTS FOR 'wangwu'@'localhost'
//查看wangwu账户的权限

### 账户权限的管理
####  权限的授予
```
GRANT priv_type[(column_list)][,priv_type[(column_list)]]
ON[object_type]priv_level TO
user_specification[,user_specification]...
[REQUIRE{NONE | ssl_opotion[[AND]ssl_option]...}]
[WITH with_option...]

priv_type:指定权限的名称 如SEECT UPDATE DELETE等
object_type:包括TABLE FUNCTION PROCEDURE
priv_level:列权限，表权限，数据库权限，用户权限

* 当前库中的所有表
*.* 所有库中的所有表
db_name.* 某个数据库中的所有表
db_name.tbl_name  谋和数据库中的某个表
tbl_name 某个表
db_name.routine_name 某个数据中的存储

TO子句：设定用户口令一级指定被授予权限的用户、创建用户账号
WITH子句：用于实现权限的转移或限制
```

```
授予用户wangwu在数据库db_school的表tbstudent上拥有对studentno和studentname的
SELECT权限

GRANT SELECT (studentno,studeentname) ON db_school.tb_student
TO 'wangwu'@'localhost';
```

```
创建两个用户liming和huang,并设置对应登录口令，授予他们在数据库db_school的表tb_student上拥有SELECT和UPDATE权限

GRANT SELECT,UPDATE ON db_school.tbstudent
TO 'liming'@'localhost' IDENTIFIED BY '123',
'huang'@'localhost' IDENTIFIED BY '789';
```

```
授予系统中已经存在的用户wangwu可以在数据库db_school中执行所有数据库操作的权限
GRANT ALL ON db_school.* TO 'wangwu'@'localhost';

授予系统上wangwu拥有创建用户的权限
GRANT CRAATE USER　ON *.* TO 'wangwu'@'localhost';
```

##### 权限的转移与限制
###### 权限转移
WITH GRANT OPTION
```
授予当前不存在的用户zhou咋数据库db_school的表tb_student上拥有SELECT
和UPDATE的权限,口令为123，
并允许其可以将自身的这个权限授予其他用户

GRANT SELECT,UPDATE ON db_schoool.tb_student
TO 'zhou'@'localhost' IEDNTIFIED BY '123'
WITH GRANT OPTION'

```

###### 限制权限
* MAX_QUERIES_PER_HOUR count:限制每小时可以查询数据库的次数
* MAX_UPDATES_PER_HOUR count:限制每小时可以修改数据库的次数
* MAX_CONNETCTIONS_PER_HOUR count:限制每小时可以连接数据的次数
* MAX_USER_CONNECTIOS count:限制同时连接MYSQL的最大用户数

```
授予与系统中的用户huang在数据库db_school的表tb_student上每小时只能处理一条
DELECT语句的权限

GRANT DELECT ON db_school.tbstudent
TO 'huang'@'localhost'
WITH MAX_QUERIES_PER_HOUR 1;
```

###### 权限的撤销
REVOKE priv_type[(column_list)]
[,priv_type[(column_list)]]...
ON [object_type] priv_level
FROM user[,user]...
REVOKE ALL PRIVILEGES,GRANT OPTION FROM
user[,user...]

```
回收系统中用户zhou在数据库db_school的表tb_student的SELECT权限
REVOKE SELECT ON db_school.tb_student FROM 'zhou'@'localhost'

```

# 备份与恢复
> 面对可能的因素造成的数据丢失或破坏的风险，数据库系统提供了备份和恢复策略
来保证数据库中数据的可靠性和完整性

> 备份是指导出数据或者复制表文件的方式来制作数据库的副本，恢复是指当数据库
出现故障或者遭到破坏时，将备份的数据库加载到系统

* MYSQL数据库备份与恢复的方法
    * 使用SQL语句备份和恢复表数据
    * 使用MYSQL客户端实用程序备份和恢复数据
    * 使用MYSQL图形界面工具备份和恢复数据
    * 直接复制
    

### 使用SQL语句备份和恢复表数据
#### 备份
SELECT INTO...OUTFILE语句
```
SELECT * INTO OUTFILE 'file_name' export_options | 
INTO DUMPFILE 'file_name'

Export_options:
[FIELDS [TERMINATED BY 'string']     //定义以什么样的形式分隔字段
[[OPTIONALLY] ENCLOSED BY 'char']    //定义字符包含形式 加上可选项为全部
[ESCAPED BY 'char']]
[LINES TERMINATED BY 'string']      //定义每一行数据通过什么进行分离

若不指定FIELDS和LINES子句，默认声明如下
FIELDS TERMINATED BY '\t' ENCLOSED BY ''
ESCAPED BY '\\' LINES TERMINATED BY '\n'
```
#### 恢复
LOAD DATA INFILE 语句
```
LOAD DATA INFILE 'file_name.txt' [REPLACE | IGNORE] 
INTO TABLE tbl_name
[FIELDS [TERMINATED BY 'string']
[[OPTIONALLY] ENCLOSED BY 'char']
[ESCAPED BY 'char']]
[LINES [STARTING BY 'string']
[TERMINATED BY 'string']] [IGNORE number LINES]
[(col_name_or_user_var,..) ] [SET col_name=expr,..]
```

```
备份数据库db_school中表tb_student的全部数据到C盘下的BACKUP目录下一个名为
backupfile.txt文件中，要求字段值如果是字符用双引号标注。然后，将备份后的数据导入
一个和tb_student表结构相同的空表tb_student_copy中

备份：
SELECT * FROM db_school.tb_student
INTO OUTFILE 'C:/BACKUP/backupfile.txt'
FIELDS TERMINATED BY ','      //每个字段之间用逗号分隔
OPTIONALLY ENCLOSED BY '"'    //所有的字段值用双引号包含
LINES TERMINATED BY '?';      //每一行用"?"分隔



SELECT * FROM db_school.tb_student
INTO OUTFILE 'C:/BACKUP/backupfile.txt'
FIELDS TERMINATED BY ','      
OPTIONALLY ENCLOSED BY '"'    
LINES TERMINATED BY '?';      



恢复:
USE db_school;
CREATE TABLE tb_student_copy LIKE tb_student;
LOAD DATA INFILE 'C:/BACKUP/backupfile.txt'
INTO TABLE db_school.tb_student_copy
FIELDS TERMINATED BY ','
OPTIONALLY ENCLOSED BY '"'
LINES TERMINATED　BY '?';
```

多用户操作数据库时，为了得到一致备份，需在指定表上使用
LOCK TABLES tbl_name READ 读锁定，恢复数据时则需要使用
LOCK TABLES tbl_name WRITE写锁定，在数据库备份与恢复完毕之后使用
UNLOCK TABLES解锁

### 使用MYSQL客户端使用程序备份和恢复数据
> 通过客户端程序mysqldumo实现MYSQl数据库的备份
除了导出表数据文件还包含数据库中表结构的SQl语句

```
备份：
mysqldump [OPTIONS] database [tables] > filename

database 若没有指定表名，则备份整个数据库
filename 默认路径是bin目录
-h -u -p[password]

使用mysqldump备份数据库db_school中的表tb_student

mysqldump -h localhost -u root -p123456 db_schoool 
tb_student > c:\BACKUP\file.sql

备份数据库：
mysqldump --databases DB1 [DB2 DB3...] > filename
例如：备份数据库db_school到C盘BACKUP目录下
mysqldump -u root -p123456 --databases db_school >
C:\BACKUP\data.sql

备份整个数据库
mysqldump --all-databases > filename

例如：备份MYSQL服务器上所有的数据库
mysqldump -u root -p123456 -all-databases > 
C:\BACKUP\alldata.sql

```

在mysqldump中通过 --tab 分开数据和创建表的SQl语句
不能与--databases或--all-databases同时使用，且mysqldump必须
运行在服务器主机上

```
例如：将数据库db_school中所有表的表结构合数据分别备份到C盘的BACKUP目录
mysqldump -u root -p123456 --tab=c:\BACKUP\ db_school;
生成所有表名.txt 所有表名.sql等文件


```

#### 使用MYSQL命令恢复数据
```
例如：假设db_school数据库被破坏，用db_school的备份文件
data.sql将其恢复
mysql -u root -p123456 db_school < c:\BACKUP\data.sql;
```

```
例如：假设数据库db_school中表tb_student的表结构被损坏，试将存储表tb_student
结构的备份文件tb_student.sql恢复到服务器
USE db_school;
source C:\BACKUP\tb_student.sql;
```
使用mysqlimport程序恢复数据
mysqlimport database textfile...

```
将C盘BACKUP目录下的tb_classt.txt文件恢复到数据库db_school的表tb_class中

mysqlimport -u root -p123456 --low-priority --replace db_schol C:\BACKUP\tb_class.txt

```

#### 直接复制
* 暂时关闭MYSQL服务器
* 复制对应的文件目录上所有的表文件
* 重启服务器
* 把这些文件拷贝到另外一个MYSQL服务器的数据库目录下即可
* 注意：两个服务器的MYSQL版本必须相同或兼容
* 两个服务器必须硬件结构相同或相似
* 


## 二进制日志文件的使用
* 找到MYSQL安装目录下的my.ini文件
* 找到[mysqld]标签，在下面添加
```
log-bin[=filenmae]
log-bin=C:/Program Files/MySQL Server 5.5/bin/bin_log
```
* 保存修改 重启MYSQL服务器可在MYSQL的DATA文件夹下看到两个文件filename.数字编号，filename.index

#### 查看二进制日志文件
mysqlbinlog log_files...
mysqlbinlog bin-log.000001
或 重定向到一个文件中
mysqlbinlog bin-log.000001 > C:\BACKUP\bin_log000001.txt

#### 使用二进制日志文件恢复数据
mysqlbinlog log_files... | mysql

```
例如：假设系统管理员在本周一下午五点公司下班前，使用mysqldump
工具进行了数据库sb_school的整个完全备份，备份文件名为alldata.sql
接着，从本周一下午开始启用日志，bin_log.000001文件保存了从本周一
下午五点到本周三上午九点的所有更改信息，在本周三上午九点运行一条日志刷新语句
即FLUSH LOGS 此时系统自动创建一个新的二进制日志文件bin_log.000002
直至本周五上午十点公司数据库服务器系统崩溃，现要求公司数据库恢复到本周五上午十点系统崩溃之前的状态

1.恢复到本周一下午五点之前的状态
mysql -u root -p123456 db_school < alldata.sql

2.使用mysqlbinlog将数据库恢复到本周三商务九点之前的状态
mysqlbinlog bin_log.000001 | mysql -u root -p123456

3.使用mysqlbinlog将数据库恢复到周五上午十点之前的状态
mysqlbinlog bin_log.000002 | mysql -u root -p123456
```

##### 清除所有日志文件
RESET MASTER;

# MYSQL应用编程
> PHP内置了许多函数，同时为了在PHP程序中实现对MYSQL数据库的
各种操作，应该在PHP的配置文件php.ini中将;extension=php_mysql.dll
的分号去掉，并重启WEB服务器

* 编程步骤
    * 与MYSQL服务器建立连接
    * 选择对其进行操作的数据库
    * 执行对应的数据库操作，如添加,删除，修改和查询等
    * 关闭与MYSQl数据库服务器得到连接
    均通过PHP5内置函数库mysql中的相应函数完成


###　连接数据库
使用mysql_connect()建立非持久连接
mysql_connect([servername,[username[,password]]])

servername 默认值localhost:3306
usernam 默认值root
passworld 默认值为空串
执行成功返回一个连接标志号(TRUE)，否则为FALSE

```
例如：编写一个connect.php 要求以超级用户root及其密码123456连接本地主机中的
MYSQL数据库服务器,使用$con保存连接结果

<?php
    $con = mysql_connect("localhost:3306","root","123456");
    if(!$con){
        echo "连接失败<br>"
        echo "错误编号：".mysql_errno()."<br>";
        echo "错误信息：".mysql_error()."<br>";
        die();
        
    }
    echo "连接成功!<br>";
?>

```
使用函数mysql_pconnect()建立连接
mysql_pconnect([servername[,username[,passworld]]])
此函数与mysql_connect的区别
mysql_connect()建立的连接会在数据操作结束后自动关闭
mysql_pconnect()建立的连接会一直存在
mysql_pconnect()每次建立前都会检查是否使用相同的sername username passworld
mysql_connect()建立的连接用mysql_close()关闭，而mysql_pconnect()不能、

```
编写pconnect.php,通过mtsql_pconnect()以root用户以及密码123456连接本地主机中的数据库服务器

<?php
    $server = "localhost:3306";
    $user = "root";
    $pwd = "123456";
    $con = mysql_pconnect($server,$user,$pws);
    If(!$con)
    {
        die("连接失败！".mysql_error());
        echo "MYSQL服务器$server<br>用户名：$user<br>";
        echo "使用函数mysql_pconnect()永久连接数据库<br>";
        
    }
?>
```
#### 选择数据库
mysql_select_db(database[,connection])

```
例如：编写selectdv.php,要求选定数据库db_school作为当前工作数据库

<?php
    $con = mysql_connect("localhost:3306","root","123456");
    If(mysql_errnno())
    {
        echo "数据库服务器连接失败！<br>"
        die();
    }
    mysql_select_db();
    mysql_select_db("db_school",$con);
    If(mysql_errno())
    {
        echo "数据库选择失败！<br>";
        die();
    }
    echo "数据库选择成功!<br>";
?>
```

#### 执行数据库操作
mysql_query(query[,connection])
##### 数据的添加
将insert语句置于函数mysql_query中
```
例如：编写insert.php 要求可以向数据库db_school的表tb_student添加一个名为
"张晓勇"的学生的全部信息

<?php
    $con = mysql_connect("localhost:3306" , "root" , "123456") 
     or die("数据库服务器连接失败！<br>");
    mysql_select_db("db_school",$con)or die("数据库服务器连接失败!<br>");
    mysql_query("set names 'gnk' ");
    $sql = "INSERT INTO 
    tb_student(studentno,studentname,sex,birthday,native,nation,classno)";
    $sql = $sql."VALUES('2013110101','张晓勇','男','1997-12-11','山西','汉','AC1301')";
    IF(mysql_query($sql,$con))
        echo "学生添加成功!<br>";
    else
        echo "学生添加失败!<br>";
?>

```
##### 数据的修改
将update语句置于函数mysql_query()中实现对数据库表中修改数据

```
例如：编写update.php 可将数据库db_school的表tb_student中一个
名为 "张晓勇"的学号是呢过籍贯修改为 "广州市"

<?php
    $con = mysql_connect("localhost:3306","root","123456") or
    die("数据库服务器连接失败!<br>");
    mysql_select_db("db_school",$con) or die("数据库服务器连接失败!<br>");
    mysql_query("set name 'gbk' ");
    $sql = "UPDATE tb_student SET native = '广州市' ";
    $sql = $sql."WHERE studentname = '张晓勇' "；
    IF(mysql_query($sql,$con))
        echo "学生籍贯修改成功!<br>" ;
    else
        echo "学生籍贯修改失败!<br>" ;
?>
```
##### 数据的删除
将DELETE的语句置于函数mysql_query()中实现将数据库表中指定的数据删除

```
例题：
编写delete.php,将数据库db_school的表tb_student中一个名为 "张晓勇"的学生
信息全部删除

<?php
    $con = mysql_connect("localhost:3306" ,"root" , "123456" ) or die
    ("数据库服务器连接失败!<br>");
    mysql_select_db("db_school",$con) or die("数据库服务器连接失败")  ;
    mysql_query("set name 'gbk' ");
    $sql = "DELETE FROM tb_student";
    $SQL = $sql."WHERE studentname = '张晓勇' ";
    IF(mysql_query($sql,$con))
        echo "学生删除成功!<br>" ;
    else
        echo "学生删除失败!<br>" ;
?>

```

##### 数据的查询
将SELECT语句置于函数mysql_query()中，实现在选定的数据库中查询数据

###### 读取结果集中的记录
```
mysql_fetch_array(data[,array_type])
mysql_fetch_row(data)
mysql_fetch_assoc(data)

data: 指向mysql_query()产生的结果集的数据指针
array_type: 类型,指定函数返回值的形式，有效值为MYSQL_NUM(数字数组)
            MYSQL_ASSOC(关联数组)、MYSQL_BOTH(默认)
```

```
编写select.php,要求在数据库db_school的表tb_student中查询学号为2013110101
的学生的姓名

<?php
    $con = mysql_connect("localhost:3306","root" , "123456") or die("数据库服务器连接失败!<br>");
    mysql_select_db("db_school",$con) or die("数据库选择失败!<br>");
    mysql_query("set name  'gbk' ");
    $sql = "SELECT studentname From tb_student";
    $sql = $sql."WHERE studentno = 2013110101";
    $result = mysql_query($sql,$con);
    IF($result)
    {
        echo "学号查询成功!<br>";
        $array = mysql_fetch_array($result,MYSQL_NUM);
        if($array)
        {
            echo "读取到学生信息!<br>";
            echo "所要查询学生的姓名是:".$array[0];
        }
        else echo "没有读取到学生信息!<br>"
    }
    else echo "客户查询失败!<br>";
    
?>
```
###### 读取结果集中的记录数
mysql_num_rows(data)

```
例如：编写num.php ，要求在数据库db_school的表tb_student中查询女学生的人数

<?php
    $con = mysql_connect("localhost:3306" , "root" , "123456")
    or die ("数据库服务器连接失败!<br>");
    mysql_select_db("db_school" , $con) or die("数据库选择失败!<br>");
    mysql_query("set name 'gbk' ");
    $sql = "SELECT * FROM tb_student";
    $sql = $sql."WHERE sex= '女' "；
    $result = mysql_query($sql,$con);
    if($result)
    {
        echo "查询成功!<br>";
        $num = mysql_num_rows($result);
        echo "数据库db_school中女学生人数为：".$num."位"；
    }
    else echo "查询失败!<br>";
?>
```

###### 读取指定记录号的记录
mysql_data_seek(data,row)

```
例如： 编写seek.php,要求在数据库mysql_test的表custmoers中查询第三位
女学生的姓名

<?php
    $con = mysql_connect("localhost:3306" , "root" , "123456")
    or die("数据库服务器连接失败!<br>");
    mysql_select_db("db_school" , $con) or die("数据库选择失败!<br>");
    mysql_query(" set name 'gbk' ");
    $sql = "SELECT * FROM tb_student";
    $sql = $sql."WHERE sex = '女' ";
    $result = mysql_query($sql,$con);
    if($result)
    {
        echo "查询成功!<br>";
        if(mysql_data_seek($result,2))
        {
            $array = mysql_fetch_array($result,MYSQL_NUM);
            echo "数据库db_school中第三位女学生:".$array[1];
        }else echo "记录定位失败!<br>";
    }else echo "查询失败!<br>";
?>
    

```
##### 关闭与数据库服务器的连接
使用mysql_close()来关闭由mysql_connect()建立的非持久连接
mysql_close([connection])

```
编写close.php
<?php
    $con = mysql_connect("localhost:3306" , "root" , "123456") 
    or die("数据库服务器连接失败!<br>");
    echo "已经成功建立与服务器的连接!<br>";
    mysql_select_db("db_school" , $con) or die("数据库选择失败!<br>");
    echo "已成功选择数据库db_school!<br>";
    mysql_close($con) or die("关闭与数据库的连接失败!<br>")；
    echo "已成功关闭与MYSQL数据库服务器的连接!<br>";
?>
```




##### 开发实例
* 需求分析
* 系统分析与设计
* 数据库设计与实现
* 应用系统的编程与实现


##### 需求描述
学生成绩管理系统主要负责管理与维护本系统内部所有的学生的基本
信息以及每个学生的成绩信息

#####　系统分析与设计

* 学生成绩管理系统
    * 学生管理
    * 班级管理
    * 课程管理
    * 成绩管理
    *

###### 数据库设计与实现
学生表tb_student

含义 | 字段名称 | 数据类型 | 宽度
---|---|---|---
学号 | studentno | 字符型 | 10
姓名 | studentname | 字符型 | 20
性别 | sex | 字符型 | 2
出生日期 | birthday | 日期类型 | 
籍贯 | native | 字符型 | 20
民族 | nation | 字符型 | 30
所属班级 | classno | 字符型 |6



班级表tb_class

含义 | 字段名称 | 数据类型 | 说明 
--- | --- | --- | --- | --- |6
班级编号 | classname | 字符型 | 20
所属院系 | department | 字符型 |30
年级 | grade | 数值型 | |
班级最大人数 | classnum | 数值型 | |



课程表tb_course

含义 | 字段名称 | 数据类型 | 说明
--- | --- | --- | --- | ---
课程号 | courseno | 字符型 | 6
课程名 | coursename | 字符型 | 20
学分 | credit | 数值型 |
课时数 | coursehour | 数值型 |
开课学期 | term | 字符型 | 2
先修课程 | priorcourse | 字符型 |6



成绩表tb_score

含义 | 字段名 | 数据类型 | 宽度
--- | --- | --- | ---
学号 | studentno | 字符型 | 10
课程号 | courseno | 字符型 | 6
成绩 | score | 数值型 | 


# 实操
## 数学函数
ABS()求绝对值
![image](http://www.yingxs.com/markimg/ABS.jpg)
FLOOR()向下取整
![image](http://www.yingxs.com/markimg/FLOOR.jpg)
RAND()得到一个0~1之间的随机数
![image](http://www.yingxs.com/markimg/RAND.jpg)
TRUNCATE(x,y)取x小数点后y位
![image](http://www.yingxs.com/markimg/TRUNCATE.jpg)
SQRT(x)求平方根
![image](http://www.yingxs.com/markimg/SQRT.jpg)

## 字符串函数
UPPER(s) UCASE(s) 
将字符串中所有的字符转换成大写
![image](http://www.yingxs.com/markimg/UPPER.jpg)
LEFT(s,n)
截取字符串s前n个字符
![image](http://www.yingxs.com/markimg/LEFT.jpg)
SUBSTRING(s,n,len)
从字符串s的第n个位置开始截取长度为len的字符串
![image](http://www.yingxs.com/markimg/SUBSTRING.jpg)

## 日期和时间函数
CURDATE() CURRENT_DATE()
获取日期
![image](http://www.yingxs.com/markimg/CURDATE.jpg)

CURTIME() CURRENT_TIME() 
获取时间
![image](http://www.yingxs.com/markimg/CURTIME.jpg)

NOW()
获取当日期和时间
![image](http://www.yingxs.com/markimg/NOW.jpg)

IF(expr,v1,v2)
条件判断
![image](http://www.yingxs.com/markimg/IF.jpg)

IFNULL(v1,v2)
若v1不为空则执行v1,反之执行v2
![image](http://www.yingxs.com/markimg/IFNULL.jpg)

VERSION()
查看当前MYSQL版本号
![image](http://www.yingxs.com/markimg/version.jpg)