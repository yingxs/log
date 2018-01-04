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
