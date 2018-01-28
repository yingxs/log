## 算数运算
* 溢出(overflow)
  * 当数字运算结果，超过了js所能表示的数字上限，结果为一个特殊的无穷大值,在js中用Infinity表示
  * 同样的，当负数的值超过了js所能表示的负数范围，结果为负无穷大，在js中用-Infinity表示
* 下溢(underflow)
  * 当运算结果无比接近于零并且比js能表示的最小数值还要小的时候发生的一种情形，这种情况下js会返回负0.当一个附属发生下溢时，js返回一个特殊值负零

## NaN
被零整除并不会报错，只是简单的返回无穷大(Infinity)和无穷小(-Infinity),但是零除以零是没有意义的，这种运算结果也是一个非数字(no-a-number)值，用NaN表示。
无穷大除以无穷大，给任意负数开方运算或者算术运算符不是数字或者无法转换为数字的操作数一起使用时都会返回NaN
  * 它与任何值都不相等，包括他自身，也就是说，没有办法通过X==NaN来判断变量是否是NaN。相反应当使用X!=X来判断，当且仅当X为NaN时，表达式的结果才为true，
  函数isNaN()的作用与此类似，在js中还有一个类似的函数isFinite()在参数不是NaN、Infinity或者-Infinity的时候返回true
## 内置对象
### Global
#### URL编码
* encodeURI()
    * 只会编码中文
* encodeURIComponent()
    * 编码特殊字符和中文

#### 解码
* decodeURI()
* decodeURIComponent()

#### eval()
> 无返回值，主要担当一个字符串的解析器的作用，只接收一个参数，而这个参数就是要执行的js代码的字符串

```
eval('var box = 100');
alert(box);

eval('alert(100)');

eval("function box(){return 123}");
alert(box());
```
