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
### apply和call
```
function box(num1,num2){
    return num1+num2;
}

function sum(num1,num2){
    return box.apply(this,[num1,num2])   //this代表window作用域，[]表示传递的参数
}

function sum2(){
    return box.apply(this.arguments)    //可以当做数组传递，代表函数参数
}

alert(sum(10,10));
```
eg
```
var color = '红色的';
var box = {
    color:'蓝色的'
};

function sayColor(){
    alert(this.color);
}
//用call是实现对象冒充，冒充box下
sayColor.call(box);
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
## 继承

使用原型链继承
```
function Box(){         //被继承的函数叫做超类型(父类，基类)
    this.name = 'Lee';
}

function Desk(){        //继承的函数叫做子类型(子类，派生类)
    this.age = 100;
}

function Table(){
    this.level = 'AAAA';
}

//通过原型链继承，超类型实例化后的对象实例，赋值给子类型的原型属性
//new Box()会将Box构造里的信息和原型里的信息都交给Desk
//Desk的原型得到的事Box的构造+原型里的信息
Desk.prototype = new Box();
Table.prototype = new Desk();

var desk = new Desk();
alert(desk.name);

var table = new Table();
alert(table.name);
alert(table.age);

```

使用对象冒充继承
```
function Box(name,age){
    this.name = name;
    this.age = age;
}

function Desk(name,age){
    Box.call(this,name,age);        //对象冒充，只能继承构造中的信息
}

var desk = new Desk('lee',100);
alert(desk.name);
```
组合模式继承(原型链+借用构造函数)
```

```
原型式继承(临时中转函数)
```
function obj(o){            //o表示将要传递进来的一个对象
    function F(){}          //F构造是一个临时新建的对象，用来存储传递过来的对象
    F.prototype = o;        //将o对象实例赋值给F构造的原型对象
    return new F();         //最后返回这个得到传递过来对象的对象实例
}

//这是字面量的声明方式，
var box = {
    name :'Lee',
    age:100
}
//box1等于new F()
var box1 = obj(box);
alert(box1.name);
```


## 匿名函数和闭包
> 匿名函数就是没有名字的函数，闭包是可访问一个函数作用域里变量的函数

```
//匿名函数
function (){            //单独的匿名函数是无法运行的
    return 'yingxs';    //就算能运行也无法调用，因为没有名称
}

//把匿名函数赋值给变量
var box = function(){   //将匿名函数赋值给变量
    return 'yingxs';
};
alert(box());


//通过表达式自我执行匿名函数
(function (){           //(匿名函数)();
    return 'yingxs';
})();

//自我执行的传参
(function (age){          
    alert(age);
})(100);

//一个函数中放一个匿名函数
function box (){
    return function(){      //闭包
        return 'yingxs';
    }
}
alert(box);
alert(box());
alert(box()());
```
### 闭包
> 闭包是指有权访问另一个函数作用域中的变量的函数，创建闭包的常见方式，就是在一个函数内部创建另一个函数，通过另一个函数访问这个函数的局部变量

* 使用闭包有一个优点，但也是他的缺点：就是可以把局部变量驻留在内存中，可以避免使用全局变量。(全局变量污染导致应用程序不可预测性，每个模块都可调用必将引发灾难，所以推荐使用私有的封装的局部变量)
```
//通过匿名函数返回局部变量
function box(){
    var age = 100;
    return function(){
        retrun age;
    };
}

alert(box());
```
* 累加演示
```
//全局变量实现累加
var age = 100;
function box(){
    age++;
}
alert(age);
box();
alert(age);


//使用局部变量无法实现累加
function box(){
    var age = 100;
    age++;
    return age;
}

alert(box());
alert(box());
//每次执行，变量age都会初始化，无法实现累加

```
```
//使用匿名函数实现局部变量驻留内存从而实现累加
function box(){
    var age = 100;
    return function (){
        age++;
        return age;
    }
}
var b = box();
alert(b());
alert(b());
alert(b());
alert(b());

b=null;         //解除引用，等待垃圾回收
alert(b());

```
* 闭包循环问题
```
function box(){
    var arr = [];
    for(var i = 0 ; i< 5;i++){
        arr[i] = function(){
            return i;
        };
    }
    return arr;
}
var b = box();      //返回arr数组
for(var i=0;i<5;i++){
    alert(b[i]());      //5 5 5 5 5
}

```
```


//改1
 function box(){
 var arr = [];
 for(var i = 0 ; i< 5;i++){
 arr[i] = (function(num){
 return num;
 })(i);
 }
 return arr;
 }
 var b = box();      //返回arr数组
 for(var i=0;i<5;i++){
 alert(b[i]);
 }
 alert(typeof b);

```

```
//改2
function box(){
    var arr = [];
    for(var i = 0 ; i< 5;i++){
        arr[i] = (function(num){        //因为闭包可以将变量驻留在内存中，和累加类似
           return function(){
               return num;
           }
        })(i);
    }

    //已經執行完畢，num为什么可以0，1，2，3，4
    return arr;
}
var b = box();      //返回arr数组
for(var i=0;i<5;i++){
    alert(b[i]());
}
```

#### this
> 闭包中this指针指向window

```
var user = 'The Window';
var box = {
    user:'The Box',
    getUser : function(){
        return function(){
            return this.user;
        }
    }
};
alert(box.getUser()());

```
* 解决方案
    * 对象冒充 
    ```
    var user = 'The Window';
    var box = {
        user:'The Box',
        getUser : function(){
            return function(){
                return this.user;
            }
        }
    };
    //alert(box.getUser()());           // The Window
    alert(box.getUser().call(box));     // The box
    ```
    * 另行赋值
    ```
    var user = 'The Window';
    var box = {
        user:'The Box',
        getUser : function(){
            //这里作用域的this是Box
            var that = this;
            return function(){
                //这里作用域的this是window
                return that.user;
            }
        }
    };
    //alert(box.getUser()());             // The Window
    alert(box.getUser().call(box));     // The box
    ```
#### 模仿块级作用域
> javascript中没有块级作用域的概念

* 在全局作用域总使用块级作用域可以减少闭包占用的内存问题，因为没有指向匿名函数的引用，只要函数执行完毕，就可以立即销毁起作用域链

```
function box(){
    for(var i=0;i<5;i++){}
    alert(i);
}
box();

```
* 使用自我执行的匿名函数实现私有作用域
```
function box(){
    (function(){
        for(var i=0;i<5;i++){}
    })();
    alert(i);   //报错，无法访问
}
box();
```
#### 私有属性
> javascript没有私有属性，所有的属性都是公有的，却有一个私有变量的概念，任何在函数中定义的变量，都可以认为是私有变量，因为不能在函数的外部访问这些变量

```
function Box(){
    var age=100;                //私有变量
    function run(){             //私有函数，因为没有名字，无法调用
        return '运行中...';
    }
    this.publicGo = function(){ //对外的可见的公共接口
        return age+run();
    };
    this.getAge = function(){
        return age;
    }
}

var box = new Box();
alert(box.getAge());
```


#### 静态私有变量
```
(function(){
    var user = '';
    //function Box(){}    //构造函数，但在函数里写构造函数，不支持，因为私有作用域里的函数，外部访问不到
    Box = function(value){   //全局构造函数
        user = value;
        this.getUser = function(){
            return user; 
        }
    };
})();

var box = new Box('yingxs');
alert(box.getUser());
var box2 = new Box("123");
alert(box.getUser());




(function(){
    var user = '';
    //function Box(){}    //构造函数，但在函数里写构造函数，不支持，因为私有作用域里的函数，外部访问不到
    
    Box = function(value){   //全局构造函数
        user = value;
       
    };
    Box.prototype.getUser = function(){
        return user;
    }
    Box.prototype.setUser = function(value){
        user=value;
    }
})();

var box = new Box('yingxs');
alert(box.getUser());
var box2 = new Box("123");
alert(box.getUser());


//以上两种方式均可实现私有变量user的共享
```

```
var box = {         //只实例化一次，为单例
    
}

var box = function(){
    var user = 'Lee';
    function run(){
        return '运行中...';
    }
    
    return {
        publicGo : function(){      //对外公共接口的特权方法
            return user+run();
        }
    };
}();


```
#### 浏览器嗅探器
```
var client=function(){
     var client=function(){
   //引擎
   var engine={
       ie:false,
       gecko:false,
       webkit:false,
       khtml:false,
       opera:false,
       ver:0           //引擎版本
   };

   //浏览器
   var browser={
       ie:false,
       firefox:false,
       chrome:false,
       safari:false,
       opera:false,
       //浏览器版本
       ver:0,
       //浏览器通用名称
       name:''
   };
   //系统
   var system={
       win:false,
       mac:false,
       x11:false,

       sysname:''
   };

   //核心监测区域
   var ua = navigator.userAgent;
   var p = navigator.platform;

   if(p.indexOf('Win')==0){
       system.win=true;
       system.sysname='Windows';
   }else if(p.indexOf('Mac')==0){
       system.mac=true;
       system.sysname='Macintosh';
   }else if(p.indexOf('X11')==0 || p.indexOf('Linux')==0){
       system.x11=true;
       system.sysname='Linux';
   }

   if(window.opera){
       engine.opera = true;
       browser.opera = true;
       engine.ver=browser.ver=window.opera.version();
       browser.name='Opera';
   }else if(/AppleWebKit\/(\S+)/.test(ua)){
       engine.webkit=true;
       engine.ver=RegExp['$1'];
       if(/Chrome\/(\S+)/.test(ua)){
           browser.chrome = true;
           browser.ver = RegExp['$1'];
           browser.name='Chrome';
       }else{
           browser.safari = true;
           if(/Version\/(\S)/.test(ua)){
               browser.ver = RegExp['$1'];
           }
           browser.name='safari';
       }

   } else if(/rv:([^\)]+)\) Gecko\/\d{8}/){
   engine.gecko=true;
   engine.ver=RegExp['$1'];
   if(/Firefox\/(\S+)/.test(ua)){
       browser.firefox = true;
       browser.ver = RegExp['$1'];
       browser.name='Firefox';
   }
}else if(/MSIE ([^;]+)/.test(ua)){
   engine.ie=true;
   browser.ie = true;
   engine.ver=browser.ver=RegExp['$1'];
   browser.name='IE';
}

return {
   engine:engine,
   browser:browser,
   system:system
}
}();

alert(client.system.sysname +"\n"+ client.browser.name+client.browser.ver);

```


#### 忽略空白节点
```
window.onload = function(){
    var box = document.getElementById('box');
    alert(filterWhiteNode(box.childNodes).length);
}

function filterWhiteNode(node){
    var ret=[];
    for(var i=0;i < node.length;i++){
        if(node[i].nodeType === 3 && /^\s+$/.test(node[i].nodeValue)){
            countinue;
        }else{
            ret.push(node[i]);
        }
    }
    return ret;
}
```

#### 移除空白节点
```
window.onload = function(){
    var box = document.getElementById('box');
    alert(removerWhiteNode(box.childNodes).length);
}

function removerWhiteNode(node){

    for(var i=0;i < node.length;i++){
        if(node[i].nodeType === 3 && /^\s+$/.test(node[i].nodeValue)){
            node[i].parentNode.removeChild(node[i]);
        }
    }
    return node;
}
```

```
window.onload = function(){
    var box = document.getElementById('box');
    alert(removerWhiteNode(box.childNodes).firstChild.nodeName);
}

function removerWhiteNode(node){
    
    for(var i=0;i < node.length;i++){
        if(node[i].nodeType === 3 && /^\s+$/.test(node[i].nodeValue)){
            node[i].parentNode.removeChild(node[i]);
        }
    }
    return node;
}

```

#### contains方法兼容
```
function contains(refNode,otherNode){
    if(typeof refNode.contains != 'undefined'){
        return refNode.contains(otherNode);
    }else if(typeof refNode.compareDocumentPosition=='function'){
        return refNode.compareDocumentPosition(otherNode)>16;
    }else{
        var node = otherNode.paretNode;
        do{
            if(node==refNode){
                return true;
            }else{
                node = otherNode.paretNode;
            }
        }while(node != null);
        return false;
    }
}
```
#### innerText与textContent兼容
```
function getInnerText(element){
    if(typeod element.textContent == 'string'){
        return element.textContent;
    }else{
        return element.innerText;
    }
}


function setInnerText(element,text){
    if(typeof element.textContent == 'string'){
        element.textContent = text;
    }else{
        element.innerText = text;
    }
}

```
#### hasClass()
```
window.onload = function(){
    hasClass(box,'aaa');
};

//判断一个class是否存在
function hasClass(element,cName){
    return !!element.className.match(new RegExp('(\\s|^)'+cName+'(\\s|$)'));
}

//添加一个class
function addClass(element,cName){
    if(!hasClass(element,cName)){
        element.className += ' '+cName;
    }
}

//移除一个class
function removeClass(element,cName){
    if(hasClass(element,cName)){
        element.className = element.className.replace(new RegExp('(\\s|^)'+cName+'(\\s|$)'),' ');
    }
}

```


#### sheet
```
var link = document.getElementByTagName('link')[0];
//alert(link);  //HTMLLinkElement
//var sheet = link.sheet;   //CSSStyleSheet,表示链接的CSS样式表对象，IE不支持

//为了兼容IE
var sheet = link.sheet || link.styleSheet;

```

```

//更加简便的获取sheet的方法
var sheet = document.styleSheets[0];
alert(sheet);       //document.styleSheets得到的是StyleSheetList集合
```

```
var sheet = document.styleSheets[0];
alert(sheet.cssRules);      //CSSRuleList，是样式规则集合，一群样式的集合表示一个规则
alert(sheet.cssRules[0]);   //获取第一条规则 CSSStyleRule
alert(sheet.cssRules[0].cssText);   //获取第一条规则的CSS文本
alert(sheet.cssRules[0].selectorText);  //得到第一个规则的选择符

```

```
//跨浏览器兼容获取CSSRuleList
var rules = sheet.cssRules || sheet.rules;

//跨浏览器兼容删除第一条规则
deleteRule(sheet,0);

//跨浏览器兼容添加第一条规则
insertRule(sheet,'body','background-color:red',0);

//跨浏览器兼容删除第一条规则
function deleteRule(sheet,postion){
    if(sheet.deleteRule){
        sheet.deleteRule(position);
    }else if(sheet.removeRule){
        sheet.removeRule(postiion);
    }
}

//跨浏览器兼容添加第一条规则
function insertRule(sheet,selectorText,cssText,position){
    if(sheet.insertRule){
        sheet.insertRule(selectorText+' {'+ cssText +'}',position);
    }else if(sheet.addRule){
        sheet.addRule(selectorText,cssText,position);
    }
}

```


```
var sheet = document.stySheets[0];
var rules = sheet.cssRules || sheet.rules;
var rule1 = rules[0];
alert(rule1.cssText);    //获取当前样式文本，IE不支持
alert(rule1.selectorText);    //获取当前样式选择符文本
alert(rule1.style.color);
rule1.style.color='blue';   //控制的是样式规则，而不是行内样式

```
### DOM元素尺寸和位置
```
//style获取行内的css大小
var box = document.getElementById('box');
alert(box.style.width);
alert(box.style.height);

```
```
//获取计算后的CSS大小，如果没有设置值，非IE会获取默认大小，IE会理解为0，返回auto
var style = window.getComputedStyle? window.getComputedStyle(box,null):null ||  box.currentStyle; 
alert(style.width);
alert(style.height);

```

```
//使用CSSStyleSheet对象中的cssRule属性
var box = document.getElementById('box');
var sheet = document.styleSheets[0];
var rule = (sheet.cssRules || sheet.rules)[0];
alert(rule.style.width);
alert(rule.style.height);
```

> 这三种方式都无法获取元素的实际大小

### 获取元素实际大小
#### clientWidth和clientHeight
> 这组属性可以获取元素可视区的大小，可以得到元素内容以及内边距所占据的空间大小 

```
var box = document.getElementById('box');
alert(box.clientWidth);
alert(box.clientHeight);
//返回number 没有单位，但是默认是px
//如果设置了其他的单位，返回来的结果还是会转换为px像素
//忽略边框和外边距
//内边距会增加大小，而滚动条会减少实际大小，不把滚动大小条算进实际大小
//在没有内边距和滚动条的情况下，没有设置CSS大小，IE浏览器会理解为0

```
#### scrollWidth和scrollHeight
> 这组属性可以获取滚动内容的元素实际大小 

```
var box = document.getElementById('box');
alert(box.scrollWidth);
alert(box.scrollHeight);
//IE浏览器在指定的高度下获取srcollHeight会理解为获取有效内容的高度
//如果文本溢出了，没加滚动条，不同的浏览器也不太兼容
```
#### offsetWidth和offsetHeight
> 这组属性可以返回元素的实际大小，包含边框，内边距和滚动条

> 对于元素大小的获取，一般是块级(block)元素并且设置的CSS大小的元素较为方便，如果是内联元素(inline)或者没有设置大小的元素就尤为麻烦。

### 获取元素周边大小

* clientLeft和clientTop
    * 这组属性可以获取元素设置了左边框和上边框的大小
* offsetParent和offsetParnet

> IE浏览器理解的根上的父元素为HTML，非IE理解的根上的父元素为BODY，但问题不大，如果没有设置定位，问题多多

#### 求出元素与页面口之间的距离
```
alert(offsetTop(box));

function offsetTop(element){
    var top = element.offsetTop;
    var parent = element.offsetParent;
    
    while(parent !== null){
        top += parent.offsetTop;
        parent = parent.offsetParent;
    }
    
    return top;
}
```
* scrollTop和scrollLeft
    * 这组属性可以获取滚动条被隐藏的区域大小，也可以定位到该区域
    
```
scrollInit(box);
//滚动条回到初始位置
function scrollInit(element){
    if(element.scrollTop != 0){
        element.scrollTop=0;
    }
}
```

