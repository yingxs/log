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

### 工厂模式
```
function createObject(name,age){
    var obj = new Object();
    obj.name = name;
    obj.age = age;
    obj.run() = function(){
        return this.name + this.age +'运行中...'
    };
    return obj;     //返回对象引用
}
```
### 原型
```
function Box(){}
Box.prototype.name = 'lee';
Box.prototype.age = 100;
Box.prototype.run = function(){
    return this.name + this.age + "运行中..."
};


var box1 = new Box();
var box2 = new Box();

//如果是实例方法，不同的实例对象，他们的方法地址是不一样的，是唯一的
//如果是原型方法，那么他们的地址是共享的，大家都是一样的

alert(box1 == box2); //true

```

* alert(box1.prototype);
    * 这个属性是一个对象，访问不到
* alert(box1.\_\_proto\_\_);
    * 这个属性是一个指针，指向prototype对象(IE不支持)
* alert(box1.constructor);
    * 构造属性,可以获取构造函数本身
    * 作用是被原型指针定位，然后得到构造函数本身
    * 其实就是对象实例对应的原型对象的作用

* alert(Box.prototype.isPrototypeOf(box));
* 判断一个对象实例(对象引用是否指向了原型对象，基本上，只要实例化了，都是自动指向的)

* 删除实例或原型中的属性
```
    alert(box1.name);
    delete box1.name;               //删除实例中属性
    delete Box.prototype.name;      //删除原型中的属性
    Box.prototype.name;             //覆盖原型中的属性
    alert(box1.name)
```
* 判断实例中是否存在指定属性
```
alert(box1.hasOwnProperty('name'));
```
* 不管实例属性或原型属性是否存在，只要有就返回true,两边都没有，返回false
```
alert('name' in box1);
```
* 只判断原型中是否有属性
```
function isPropery(object,property){
    return !object.hasOwnProperty(property) && (property in object)
}
```

```
//原型
function Box(){}
Box.prototype.name = 'Lee';
Box.prototype.age = 100;
Box.prototype.run = function(){
    return this.name + this.age + "运行中..."
};
var box1 = new Box();
//alert(box.prototype)    //使用对象实例无法访问到prototype
//alert(box.__proto__)    //使用对象实例访问__prototype__
//alert(Box.prototype)    //使用构造函数名(对象名)访问prototype




//使用字面量的方式创建原型对象，这里{}就是对象，是Object , new Object就相当于{}

function Box(){}
Box.prototype={
    constructor:Box,            //强制指向Box
    name:'Lee',
    age:100,
    run:function(){
        return this.name + this.age + '运行中...';
    }
};


```
使用构造函数创建原型对象和使用字面量创建原型对象在使用上基本相同，但还是有一些区别，字面量创建的方式使用constructor属性不会指向实例，而会指向Object，构造函数创建的方式则相反

#### 重写了原型对象
```
function Box(){}
Box.prototype={
    constructor:Box,            //强制指向Box
    name:'Lee',
    age:100,
    run:function(){
        return this.name + this.age + '运行中...';
    }
};


Box.prototype={
    age:200     //这里不会保留之前原型的任何信息了，把原来的原型对象和构造函数对象实例之间的关系切断了
};

var box = new Box();
alert(box.name);

```
#### 内置引用类型的功能扩展
```
String.prototype.addstring = function(){
    return this + ',被添加了！'; 
};
 var box = 'Lee';
 alert(box.addstring());
```

#### 组合构造函数+原型模式
```
funciton Box(name,age){         //保持独立的用构造函数
    this.name = name;
    this.age = age;
    this.family = ['哥哥','姐姐','妹妹'];
}

Box.prototype = {               //保持共享的用原型
    constructor:Box,
    run:function(){
       return this.name + this.age + "运行中..."; 
    }
}
```

#### 动态原型模式(推荐)
第一种
```
//这种方式将原型封装进构造函数中，
//但是原型的初始化，只要第一次初始化就够了，没必要每一次函数实例化的时候都初始化
funtion Box(name,age){
    this.name = name;
    this.age = age;
    this.family = ['哥哥','姐姐','妹妹'];
    
    Box.prototype.run = function(){
        return this.name + this.age + "运行中..."; 
    }
}

```
*第二种
```
funtion Box(name,age){
    this.name = name;
    this.age = age;
    this.family = ['哥哥','姐姐','妹妹'];
    
    if(typeof this.run != 'function'){          //判断this.run是否存在，如果存在就不初始化了
        Box.prototype.run = function(){
            return this.name + this.age + "运行中..."; 
        }
    }
    
}
```

#### 寄生构造函数(工厂模式+构造函数)
```
function Box(name,age){
    var obj = new Object();
    obj.name = name;
    obj.age = age;
    obj.run = function(){
        return this.name + this.age + "运行中..."; 
    };
    return obj;
    
}

```
#### 稳妥构造函数
> 在一些安全的环境中，比如禁止使用this和new,这里的this是构造函数里不使用this，这里的new实在外部实例化构造函数时不使用new。这种创建方式叫做稳妥构造函数

```
function Box(name,age){
    var obj = new Object();
    obj.name = name;
    obj.age = age;
    obj.run = function(){
        return this.name + this.age + "运行中..."; 
    };
    return obj;
}

var box1 = Box('Lee',100);
alert(box1.run());
var box2 = Box('Jack',200);
alert(box2.run());

```
