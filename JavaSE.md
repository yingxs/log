## Scanner
> java.util.Scanner 
>  无法继承

### 常用构造
* Scanner(InputStream source) 
	* 构造一个新的Scanner，从指定的输入流扫描
### 常用方法

* int nextXxx()   键盘获取一个xxx数据
* boolean hasNextXxx() 判断键盘录入对象是不是Xxx，是 返回true
* String  nextLine（）  获取一个字符串
## String 

### 常用构造

* String（）	
	* 空构造
* String(byte[] bytes) 
	* 将字节数组转换成字符串;通过使用平台的默认字符集解码指定的 byte 数组，构造一个新的 String。
* String(byte[] bytes,int index,int length)
	*  将字节数组的一部分转换为字符串， 通过使用平台的默认字符集解码指定的 byte 子数组，构造一个新的 String。
*  String（char[] value）将字符数组转换成字符串
*  String(char[] value,int index ,int length) 将字符数组一部分转换成字符串
*  String(String original)将字符串常量转换成字符串
### 常用方法

#### 判断

* boolean equals(Object obj)  比较字符串的内容是否相同区分大小写
* Boolean equalsIgnoreCase(String str) 比较字符串内容是否相等，忽略大小写
* Boolean contains(String str)判断该字符串中是否包含子字符串str
* Boolean  startsWith(string str)判断字符串是否是以某个指定的字符串开头的
* Boolean endsWith(String str)判断字符串是否是以某个指定的字符串结尾的
* Boolean isEmpty()判断字符串是否为空


#### 获取
* int length()获取字符串的长度
* char charAt(int index)获取指定索引位置的字符
* int indexOf(int ch)返回指定字符在该字符串中第一次出现处的索引
* int indexOf(String str)返回指定字符串在此字符串中第一次出现初的索引
* int indexOf(int ch,int formIndex)返回指定字符在此字符串中从指定位置后第一次出现处的索引
* int indexOf(String str,int formIndex)返回指定字符串在此字符串中从指定位置后第一次出现处的索引
* int lastIndexof(从后往前,方法同上)
* String substring(int start)从指定位置位置开始截取字符串，默认到末尾
* String substring(int start,int end)截取指定位置的字符串


#### 转换
* byte[] getBytes()将字符串转换为字节数组
* char[] toCharArray()将字符串转换为字符数组
* static String valueOf(char[] ch)转换为字符串
* string toLowerCase()把字符串转成小写
* string toUpperCase()把字符串转成大写
* string concat(String str)把字符串拼接


#### 其他
* String replace(char old,char new)    字符替换
* String replace(char old,String new)
* String trim()去除两侧空格

## StringBuffer
### 常用构造
* public StringBuffer() 无参构造
* public StringBuffer(int capacity)指定容量的字符串缓冲区对象
* public StringBuffer(String str)指定字符串内容的字符串缓冲区对象
### 常用方法
* public int capacity()返回当前容量（理论值）
* public int length()返回长度（字符数，实际值 ）
* public StringBuffer append（String str）可以把任意数据类型添加到缓冲区，并返回缓冲区对象
* public StringBuffer insert（int offset ，String str）在指定位置把任意类型数据插入到缓冲区里面，并返回缓冲区对象
* public StringBuffer deleteCharAt(int index)删除指定位置的字符
* public StringBuffer delete(int start , int end)删除从指定位置开始指定位置结束的内容
* public StringBUffer replace(int start,int end,String str) 将制定位置的字符串用str进行替换
* public StringBuffer reverse()字符串反转
* public String substring(int start)从指定位置截取到末尾
* public String substring(int start，int end)截取指定字符序列 含头不含尾
### String与StringBuffer的相互转换
* String--Stringbuffer
	* 通过构造方法传入字符串
	* 通过append()方法 
* StringBuffer--String
	* 通过构造方法传入StringBuffer
	* 通过toString()方法
	* 通过subString(0,length)截取

String虽然是引用数据类型但是当它作为参数传递时，和基本输数据类型是一样的

## Arrays
### 常用方法
* public static String toString(int[] a)数组转换成字符串
* public static void sort(int[] a)排序
* public static int binaryAearch(int[] a,int key)二分法查找

## 基本数据类型包装类
## Integer（int包装类）
### 常用字段
* MAX_VALUE 值为2^31-1的常量 表示int类型能够表示的最大值
* MIN_VALUE 值为-2^31的常量 表示int类型能够表示的最小值


### 构造方法
* public Integer(int value)
* public Integer(String s)


### 常用方法
* static String toBinaryString(int i)将int数转换成二进制字符串形式
* static String toHexString(int i)将int数转换成十六进制字符串形式
* static String toOctalString(int i)将int数转换成八进制字符串形式
* int Value()返回该Integer所表示的int值
* static int parseInt（String s）将字符串转换成int数据*

#### String和int之间的相互转换
* int --> String 
	*  与" "进行拼接*
	*  public static String valueof(int i)*
	*  int --> Integer --> String(Integer类的toString方法())
	*  public static String toString(int i)(Integer类的静态方法) 
*  String --> int
	*  String --> Integer --> int
	*  public static int parseInt(String s)
	

## 自动装箱与自动拆箱
* 自动装箱：把基本数据类型转换为包装类型
* 自动拆箱：把包装类型转换为基本数据类型
	* int x = 100;
	* Intrger i1 = new Integer(x);//将基本数据类型包装成对象，装箱
	* int y = i1.intValue();//将对象转换为基本数据类型，拆箱
	* 
	* Intger i2 = 100;//自动装箱，把基本数据类型转换为对象
	* int  z = i2 + 200；//自动拆箱，把对象转换成基本数据类型
	* 
	* Integer i3 = null；
	* int a = i3 + 100; //底层用i3调用intValue，但是i3是nul，用null调用方法就会出现空指针异常
	* System.out.println(a);//空指针异常java.lang.NullPointerException
* 面试题
	* Integer i5 = 127；
	* Integer i6 = 127；
	* System.out.println(i5 == i6);//true
	* System.out.println(i5.equals(i6));//true
	* 
	* Integer i7 = 128；
	* Integer i8 = 128；
	* System.out.println(i7 == i8);//false
	* System.out.println(i7.equals(i8));//true
	
> -128~127是byte的取值范围，如果在这个取值范围内，自动装箱就不会储藏间新对象。而是从常量池中获取，如果超过了byte取值范围就会再新建对象

## 正则表达式
> Boolean mathes()函数可以检测字符串是否符合此正则表达式的规范
> String[] aplit()根据给定的正则表达式的匹配拆分字符串
> public String replacceAll(String regex,String replacement)


* 字符类
	* []代表单个字符
	* [abc] a、b或c
	* [^abc]任何字符，除了a、b、c的任何字符
	* [a-zA-Z]a-z或A-Z的任意字符
	* [a-d[m-p]]a-d或m-p之间的任何字符
	* [a-z&&[def]]d、e或f取交集
	* [a-z%%[^bc]]a-z之间除了b和c；
	* [a-z&&[^m-p]]a-z之间除去m-p
* 预定义字符类
	* . 任意字符
	* \d 任意单个数字字符
	* \D 代表非数字[^0-9]
	* \s 空白字符 [ \t\n\x0B\f\r]
	* \S 非空白字符[^\s]
	* \w 单词字符[a-zA-Z_0-9]
	* \W 非单词字符[^\w]
	

## 数量词
* x? 一次或一次也没有
* x* 零次或多次
* x+ 一次或多次
* x{n} 恰好n次
* x{n,} 至少n词
* x{n,m} 至少n次但不超过m次

## Pattern类

* 常见pattera的使用步骤
	* Pattera p = Pattera.compile("a*b");获取到正则表达式
	* Matcher m = p.matcher("aaaaaab");获取匹配器
	* boolean b = m.matches();看看是否匹配，匹配就返回true
	* System.out.println(b);
	* -----------
	* System.out.println("aaaaaab".matches("a*b"));与上面的结果一致
	* 
	

## Macher
* find()寻找是否包含有匹配器所匹配的字符串
* group（）获取到与此正则表达式匹配的字符串并返回
* 例如：
	* String s = "我的手机号是18609206907，曾经用过18182536706，还用过18182502058";
	* String regex = "1[3578]\\d{9}";
	* Pattern p = Pattern.compile(regex);
	* Matcher m = p.matcher(s);
	* while(m.find())
	* System.out.println(m.group());

## Math类
### 成员方法
* public static int abs(int a)求绝对值
* public static double ceil(double a)向上取整结果为boolean
* public static double floor(double a)向下取整，结果为boolean
* public static int max(int a,int b)获取最大值
* public static double pow(double a,double b)指数运算
* public static double random();伪随机生成0.0到1.0之间的小数包含0.0不包含1.0
* public static int round(float a)四舍五入
* public static double sqrt(double a)开方

## Random类
### 构造
* Random()创建一个新的随机数生成器
* Random(long seed)使用单个种子创建一个新的随机数生成器
## 常用方法
* int nextInt(int n) 生成0到(n-1)之间均匀分布的int数据

## System类
> System类包含一些有用的类字段和方法，他不能被实例化


## 成员方法
* public static void gc()运行垃圾回收器
* public static void exit(int status)退出java虚拟机
* public static long currentTimeMillis()返回以毫秒值伪单位的当前时间
* public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
	* 复制数组 
	* src 原数组
	* srcPos 原数组中的起始位置
	* dest 目标数组
	* destPos 目标数组中的起始位置
	* length 要复制的数组元素数量

## BigInteger类
> 可以让超过Integer范围内的数据进行运算


### 构造
* public BigInteger(String val)
###常用方法
* public BigInteger add(BigInteger val) 加
* public BigInteger subtract(BigInteger val)减
* public BigInteger multiply(BigInteger val)乘
* public BigInteger divide(BigInteger val)除
* public BigInteger[] divi deAndRemainder(BigInteger val)取除数和余数

## BigDecimal类
> 更精确的表示浮点型数据

### 常用构造
* public BigDecimal(String Val)



### 常用方法
* public BigDecimal add(BigInteger val) 加
* public BigDecimal subtract(BigInteger val)减
* public BigDecimal multiply(BigInteger val)乘
* public BigDecimal divide(BigInteger val)除
* public static BigDecimal valueof(double val)将数据包装成Bigdecimal对象并返回


## Date类
> 表示日期时间的类 表示特定瞬间


## 常用构造
* public Date()当前时间对象
* public Date(long date)通过毫秒值传递时间对象（如果传入0，则代表1970年1月1日）
## 常用方法
* public long getTime()返回自1970年一月一日00:00:00 GMT至此Date对象所表示的毫秒数
* public void setTime(long time)设置从1970/1/1的毫秒值，改变时间对象

## SimpleDateFormat类
> DateFormat 是日期/时间格式化子类的抽象类，它以与语言无关的方式格式化解析日期或时间

### 常用构造
* public SimpleDateFormat()创建日期格式化类对象，空参表示默认格式
* public SimpleDateFormat(String pattern)创建日期格式化类对象，例如参数课为指定格式"yyyy年MM月dd日 HH:mm:ss"


### 常用方法
* public final String format(Date date)将时间对象转换成字符串
* public Date parse(String source)将字符串转换成事件对象

## Calendar
> Calendar是一个抽象类，为日历类
> Canlendar c = Canlendar.getInstance()

### 常用方法
* public static Calendar getInstance()
* public int get(int field)获取制定字段的值c.get(Calendar.YEAR)
	* c.get(Calendar.YEAR)通过字段获取年
	* c.get(Calendar.MONTH)通过字段获取月（月份从零开始编号）
	* c.get(Calendar.DAY_OF_MONTH)月中第几天
	* c.get(Calendar.DAY_OF_WEEK)获取星期值 周日是1，周六是7
* public void add(int field,int amount)对指定字段进行加减运算
* public final void set(int year,int month,int date)设置指定字段

# 集合
## 集合继承体系图
* Collection 单列集合的根接口
	* List 有序(存和取的顺序一致)，有索引，可以存储重复
		* ArrayList 数组实现
		* LinkedList 链表实现
		* Vector 数组实现
	* Set 无序(存和取的顺序不 一致)，无索引，不可以存储重复
		* HashSet 哈希算法
		* TreeSet二叉树算法

## Collection
### 常用方法
* boolean add(E e)添加
* boolean remov e(Object o)删除
* void clear()清空
* boolean contains(Object o)是否包含某元素
* boolean isEmpty()判断是否为空
* int size()获取集合中元素个数
* boolean addAll(Collection c)将指定Collection中的元素都添加到此Collection中
* boolean removeAll(Collection c)删除交集
* boolean containsAll(Collextion c)判断传入的集合是否为调用的集合真子集
* boolean retainAll(Collection c)取交集，并将交集赋予调用集合，如果调用集合改变就返回true，不改变就返回flase


### 迭代
> 集合用来存储元素，存储的元素需要查看，那么就需要迭代(遍历)

* Iterator<E> iterator()获取迭代器
* boolean hasNext()判断集合中是否还有元素可以迭代
* E next()获取元素 
* void remove()


## List集合  
### 常用方法
* void add(int index,E element)指定位置插入元素index<=size
* boolean addAll(Collection<? extends E> c)
* E remove(int index)删除指定对象并返回
* E get(int index)通过索引获取指定元素
* E set(int index,E element)修改指定位置的元素

## 并发修改异常
```
	public static void main(String[] args) {
		List list = new ArrayList();
		
		list.add("a");
		list.add("b");
		list.add("world");
		list.add("c");
		list.add("d");
		list.add("e");
		
		/*
		Iterator it = list.iterator();
		while(it.hasNext()){ 
			String str = (String) it.next();
			if("world".equals(str)){
				list.add("javaee");              //遍历的同时增加元素  并发修改异常 通过ListIterator解决
			}
		}*/
		
		ListIterator lit = list.listIterator();  //获取迭代器
		while(lit.hasNext()){ 
			String str = (String) lit.next();
			if("world".equals(str)){
				//list.add("javaee");
				lit.add("javaee");
			}
		}
		
		System.out.println(list);
	}
```

