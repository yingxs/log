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
SELECT * FROM tb_student
WHERE native IN ('北京','天津','上海')；
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

