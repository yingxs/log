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
### 动态加载脚本与样式
```
//动态加载js脚本文件
window.onload = function(){
    
    alert(typeof BrowserDetect);
    
}

var flag = true;
if(flag){
    loadScript('browserdetect.js);
}

function loadScript(url){
    var script = document.createElement('script');
    script.type='text/javascript';
    script.src=url;
    document.getElementByTagName('head')[0].appendChild(script);
}
```

```
//动态加载js脚本
window.onload = function(){
    
}

var flag = true;
if(flag){
    var script = document.createElement('script');
    script.type='text/javascript';
   // script.appendChild(document.createTextNode("alert('Lee')"));   //IE不支持
   script.text = "alert('Lee')";
    document.getElementByTagName('head')[0].appendChild(script);
}


```

### 动态样式
```
//动态加载样式文件
window.onload = function(){
    
}
var flag = true;
if(flag){
    var link = document.createElement('link');
    link.rel='stylesheet';
    link.type='text/css';
    link.href='basic.css';
    document.getElementByTagName('head')[0].appendChild(link);
    
}
```
```
//动态加载style
window.onload = function(){
    
}
var flag = true;
if(flag){
    var style = document.createElement('style');
    style.type='text/css';
    //style.appendChild(document.createTextNode('#box {width:200px;height:200px;background:red;}'));//IE不支持
    
    document.getElementByTagName('head')[0].appendChild(style);
    insertRule(document.styleSheets[0],'#box','width:200px;height:200px;background:red;',0)
}

function insertRule(sheet,selectorText,cssText,position){
    //如果是非IE
    if(sheet.insertRule){
        sheet.insertRule(selectorText+' {'+ cssText +'}',position);
    //如果是IE    
    }else if(sheet.addRule){
        sheet.addRule(selectorText,cssText,position);
    }
}
```

### 事件入门
```
window.onload = function(){
    var input = document.getElementsByTagName('input')[0];
    
    //input.onclick = box();
    //让事件处理函数执行一个函数的时候，通过赋值方式，那么直接将函数名赋值给事件处理函数即可
    input.onclick = box;
}

function box(){
    alert('Lee');
}
```

##### this
```
window.onload=function(){
    document.onclick=function(){
        alert(this);    //HTMLDocument,代表的是document
    }
}

```

```
window.onload=function(){
    document.onclick=box;   //因为box()函数被onclick绑定了，所以里面的this代表document
}

function box(){
    alert(this);    //HTMLDocument,代表的是document
}
```
##### 事件对象
```
window.onload=function(){
    document.onclick = function(){
        alert(arguments.length);    //如果是事件处理函数绑定的函数，浏览器会默认传递一个参数，这个参数就是event对象
    }
}
```
event的获取兼容
```
window.onload=function(){
    document.onclick = function(evt){
        var e = evt || window.event;    //W3C || IE
        alert(e);    
        //alert(e);
        //alert(window.event);
        
    }
    
}
```
> window.event这个属性是IE所支持的，Chrome也是支持的，但是Chrome是支持W3C的，如果说IE和W3C都支持的话，以W3C为准

跨浏览器鼠标按钮监测
```
window.onload=function(){
    document.onmouseup = function(evt){
        alert(getButton(evt));  
    }
    
}

function getButton(evt){
    var e = evt || window.event;    //W3C || IE
    if(evt){
        return e.button;
    }else if(window.event){
        switch(e.button){
            case 1 : return 0;
            case 4 : return 1;
            case 2 : return 2;
            case 0 : return 2;      //360浏览器 onmouseup正常onmousedown右键会有bug
        }
    }
}

```
##### 可视区和屏幕坐标
> 事件对象提供了两组来获取浏览器坐标的属性，一组是页面可视区左边，另一组是屏幕坐标

* clientX 可视区X坐标，距离左边框的位置
* clientY 可视区Y坐标，距离上边框的位置
* screenX 屏幕区X坐标，距离左屏幕的位置
* screenY 屏幕区Y坐标，距离上屏幕的位置
```
window.onload = function(){
    document.onclick = function(evt){
        var e = evt || window.event;
        alert(e.clientX +','+e.clientY);    //可视区坐标
        //alert(e.clientX + document.documentElement.scrollTop+','+e.clientY);
        //Chrome要用 alert(e.clientX + document.body.scrollTop+','+e.clientY);
        alert(e.screenX +','+e.screenY);    //屏幕坐标
        
    }
}
```
##### 修改键
```
window.onload = function(){
    document.onclick = function(evt){
        var e = evt || window.event;
        alert(e.shiftKey);
        //判断是否按下shift键
    }
}
```

```
window.onload = function(){
    document.onclick = function(evt){
        alert(getKey(evt));
       
    }
}

function getKey(evt){
    var e = evt || window.event;
    var keys = [];
    if(e.shiftKey) keys.push('shift');
    if(e.ctrlKey) keys.push('ctrl');
    if(e.altKey) keys.push('alt');      //360在单击+ALT键的识别上有bug，会和浏览器本身的快捷键冲突
    
    return keys;
}
```
##### 键码
> 键码可以返回任意键的编码，而且字母不区分大小写

```
window.onload = function(){
    document.onkeydown = function(evt){
        var e = evt || window.event;
        alert(e.keyCode);   //返回键码
    }
}
```
> 如果用keypress返回KeyCode，发现Fixfor浏览器把所有字符键都返回0，Chrome支持keypress返回KeyCode，而且还区分大小写，，IE支持keypress返回KeyCode，而且还区分大小写


#### 字符编码
> charCode在使用keypress的情况下，Firefox会返回字符键盘的编码，支持大小写。IE和Opera不支持charCode这个属性

跨浏览器兼容字符按键
```
window.onload = function(){
    document.onkeypress = function(evt){
        //alert(e.charCode);    //返回字符编码
        alert(getCharCode(evt));
        alert(String.fromCharCode(getCharCode(evt)));   //String.fromCharCode()将ASCII编码转换成字符
    }
}

function getCharCode(evt){
    var e = evt || window.event;
    if(typeof e.charCode == 'number'){
        return e.charCode;
    }else{
        return e.keyCode;
    }
}
```

跨浏览器取消事件冒泡
```
function setStop(evt){
    var e = evt || window.event;
    typeof e.stopPropagation == 'function' ? e.stoppropagation() : e.cancelBubble = true;
}
```

```
alert(typeof window.onload);
//一开始没有window.onload，旧版火狐显示undefined,新版火狐显示object,IE和火狐也是Object

window.onload = function(){
    //alert('yingxs');
}

alert(typeof window.onload);
//如果有的时候大家统一返回function

window.onload = function(){
    //alert('yingxs.com');
}
```

解决覆盖问题
```
window.onload = function(){
    alert('yingxs');
}

if(typeof window.onload=='function'){
    var saved = null;           //保存上一个事件对象
    saved = window.onload;
}

window.onload = function (){
    if(saved) saved();                    //执行上一个事件
    alert('yinxs.com');         //执行本事件
}

```
事件切换器
```
window.onload = function(){
    var box = document.getElementById('box');
    box.onclick = toBlue;
};

function toRed(){
    this.className = 'red';
    this.onclick = toBlue;
    
}

function toBlue(){
    this.className = 'blue';
    this.onclick = toRed;
}
//如果toBlue()绑定了box.onclick,里面的this代表box,如果是全局执行，那么，this代表window
```
事件切换器的覆盖问题
```
window.onload = function(){
    var box = document.getElementById('box');
//    box.onclick = function(){     //被覆盖
//        alert('Lee');
//    }
    box.onclick = function (){
        alert('Lee');           //只能执行第一次，第二次又被覆盖了
        toBlue.call(this);       //通过匿名函数执行某一函数，函数中的this就代表的是window，可以通过call传递this
    }
};

function toRed(){
    this.className = 'red';
    this.onclick = toBlue;
    
}

function toBlue(){
    this.className = 'blue';
    this.onclick = toRed;
}
//如果toBlue()绑定了box.onclick,里面的this代表box,如果是全局执行，那么，this代表window
```

添加事件函数
```
function addEvent(obj,type,fn){
    //用于保存上一个事件
    var saved = null;
    //用于判断事件是否存在
    if(typeof obj['on'+type] == 'function'){
        saved = obj['on'+type];
    }
    //执行事件
    obj['on'+type] = function(){
        if(saved) saved();
        fn();
    };
}

addEvent(window,'load',function(){
    alert('yingxs');
});
addEvent(window,'load',function(){
    alert('yingxs.com');
});
addEvent(window,'load',function(){
    alert('www.yingxs.com');
});
```
> 当不停的切换事件的时候，浏览器突然卡死，并且报错too much recursion 太多的递归，因为积累的太多的保存的时间，解决方案，就是用完的事件，就立即移除掉

事件添加函数+事件删除函数+事件切换器
```
//事件添加函数
function addEvent(obj,type,fn){
    //用于保存上一个事件
    var saved = null;
    //用于判断事件是否存在
    if(typeof obj['on'+type] == 'function'){
        saved = obj['on'+type];
    }
    //执行事件
    obj['on'+type] = function(){
        if(saved) saved();
        //alert('this:'+this);
        fn.call(this);
    };
}

//事件删除函数
function removeEvent(obj,type){
    if(obj['on'+type]) obj['on'+type]=null;
}


//事件切换器
addEvent(window,'load',function(){
    var box = document.getElementById('box');
    addEvent(box,'click',toBlue);
});

function toRed(){
    this.className = 'red';
    removeEvent(this,'click');
    addEvent(box,'click',toBlue);

}

function toBlue(){
    this.className = 'blue';
    removeEvent(this,'click');
    addEvent(box,'click',toRed);
}
```
> 以上的事件移除函数，只是简单的一刀切，虽然解决了递归和卡死的问题，但是也删除了其他的事件处理函数。导致得不到自己想要的效果，如果需要删除指定的事件处理函数，那么就 需要遍历查找


#### IE事件处理
* 覆盖问题 解决，但还是有不同，执行顺序是倒过来的
    ```
    window.attachEvent('onload',function(){
        alert('yingxs');
    });
    window.attachEvent('onload',function(){
        alert('yingxs.com');
    });
    window.attachEvent('onload',function(){
        alert('www.yingxs.com');
    });
    ```
* 未解决相同函数的屏蔽问题
* 不能传递this
* 


#### IE切换器
```
window.attachEvent('onload',function(){
    var box = document.getElementById('box');
    box.attachEvent('onclick',toBlue);
});

function toRed(){
    var that = window.event.srcElement;
    that.className = 'red';
    that.detachEvent('onclick',toRed);
    that.attachEvent('onclick',toBlue);
}

function toBlue(){
    var that = window.event.srcElement;
    that.className = 'blue';
    that.detachEvent('onclick',toBlue);
    that.attachEvent('onclick',toRed);
}
```
####  IE中事件对象的获取
```
window.attachEvent('onload',function(){
    var box = document.getElementById('box');
    //box.onclick = function (evt){     //传统方法低版本IE无法通过参数事件对象evt
    //    alert(evt);
    //};

    box.attachEvent('onclick',function(evt){
       alert(evt);
        alert(evt.type);
        alert(evt.srcElement.tagName);
        alert(window.event.srcElement.tagName);     //两种方法都可以获取事件对象
    });
});
```

跨浏览器兼容
```

//跨浏览器添加事件
function addEvent(obj,type,fn){
    if(obj.addEventListener){
        obj.addEventListener(type,fn,false);
    }else if(obj.attachEvent){
        obj.attachEvent('on'+type,fn);
    }
}

//跨浏览器删除事件
function removeEvent(obj,type,fn){
    if(obj.removeEventListener){
        obj.removeEventListener(type,fn,false);
    }else if(obj.detachEvent){
        obj.detachEvent('on'+type,fn);
    }
}
//跨浏览器获取目标对象
function getTarget(evt){
    if(evt.target){                         //W3C
        return evt.target;
    }else if(window.event.srcElement){      //IE
        return window.event.srcElement;
    }
}


addEvent(window,'load',function(){
    var box = document.getElementById('box');
    addEvent(box,'click',toBlue);
    addEvent(box,'click',function(){
        alert('yingxs');
    });
    addEvent(box,'click',function(){
        alert('yingxs.com');
    });
});



function toRed(evt){
    var that = getTarget(evt);
    that.className = 'red';
    removeEvent(that,'click',toRed);
    addEvent(that,'click',toBlue);
}

function toBlue(evt){
    var that = getTarget(evt);
    that.className = 'blue';
    removeEvent(that,'click',toBlue);
    addEvent(that,'click',toRed);
}

```
* 实践中基本不用attachEvent和detachEvent
    * IE9全面支持W3C中的事件绑定函数
    * IE的事件绑定函数无法传递this
    * IE的事件绑定机制不支持捕获
    * 同一个函数注册后，没有屏蔽掉
    * 有内存泄漏问题


事件对象中的relatedTarget

```
addEvent(window,'load',function(){
    var box = document.getElementById('box');
    
    //W3C
    addEvent(box,'mouseover',function(evt){
        alert(evt.raletedTarget);               //得到移入box最近的DOM对象
    });
    addEvent(box,'mouseout',function(evt){
        alert(evt.relatedTarget);               //从box移除最近的那个DOM对象
    });

    //IE
    addEvent(box,'mouseover',function(){
        alert(window.event.fromElement.tagName);    //得到移入box最近的DOM对象
    });
    addEvent(box,'mouseout',function(){
        alert(window.event.toElement.tagName);      //从box移除最近的那个DOM对象
    });

    //兼容
    addEvent(box,'mouseover',function(evt){
        alert(getTarget(evt));
    });

});
```

阻止默认行为
```
addEvent(window,'load',function(){
    var link = document.getElementByName('a')[0];
    //link.onclick = function(){
    //  return false;
    //    alert('yingxs');
    //};
    /**
     * return false ；必须在最后，但是又可能导致根本无法阻止默认行为，最好是放到前面，但是放到前面后，后面的代码又无法执行
     */
    /*
    addEvent(link,'click',function(){
        return false;                           //无效
    });
    */
    addEvent(link,'click',function(evt){
       evt.preventDefault();
        alert('yingxs');
        return true;                        //不会影响阻止默认事件
    });

    //兼容
    addEvent(link,'click',function(evt){
        preDef();
    });

});


function preDef(){
    var e = evt || window.event;
    if(e.preventDefault){
        e.preventDefault();
    }else {
        e.returnValue = false;
    }
}
```

#### 卸载前事件
```
addEvent(window,'beforeunload',function(evt){
    preDef(evt);
});

```

#### 鼠标滚轮事件
```
//非火狐
addEvent(document,'mousewheel',function(evt){
    var e = evt || window.event;
    alert(e.wheelDelta);
});

//火狐
addEvent(document,'DOMMouseScroll',function(evt){
    alert(-evt.detail*40);

});



//兼容
addEvent(document,'mousewheel',function(evt){
    alert(WD(evt));
});
//兼容
addEvent(document,'DOMMouseScroll',function(evt){
    alert(WD(evt));

});

//兼容
function WD(evt){
    var  e = evt || window.event;
    if(e.wheelDelta){
        return e.wheelDelta;
    }else if(evt.detail){
        return -evt.detail*40;
    }
}


```

##### 表单事件
```
addEvent(window,'load',function(){
    //var fm = document.getElementById('myForm');
    //var fm = document.getElementsById('myForm');
    //var fm = document.forms['0'];    //HTML DOM通过下标0获取
    //var fm = document.forms['yourForm'];    //HTML DOM通过name获取
    var fm = document.yourForm;    //向下兼容，不推荐使用
    alert(fm);

    //阻止提交
    addEvent(fm,'submit',function(evt){
        //阻止提交
        preDef(evt);
    });
    //PS：submit事件，用传统的方式：fm.onsubmit = function (){};

    //使用fm.submit()方法，让非submit按钮实现提交
    var button = document.getElementById('button');
    addEvent(button,'click',function(){
        fm.submit();                        //可以让非submit按钮提交表单
    });

    //实现ctrl+enter实现提交
    addEvent(document,'keydown',function(evt){
        var e = evt || window.event;
        if(e.ctrlKey && e.keyCode==13) fm.submit();
    });


});
```


#### 阻止表单重复提交
```
addEvent(window,'load',function(){
    /*
    //只能阻止通过submit按钮进行的提交
   var fm = document.getElementById('myForm');
    //阻止提交
    addEvent(fm,'submit',function(evt){
        preDef(evt);
        //模拟延迟
        alert('提交');
        //这种方法，仅限于通过提交按钮防止重复提交
        document.getElementById('sub').disabled=true;   //第一次提交后，将按钮禁用
        setTimeout(function(){
            fm.submit();
        },5000);
    })
    */

    var fm = document.getElementById('myForm');
    var flag = false;
    //阻止提交
    addEvent(fm,'submit',function(evt){
        preDef(evt);
        if(flag==true) return ;
        flag=true;
        alert('提交')
        document.getElementById('sub').disabled=true;   //第一次提交后，将按钮禁用
        setTimeout(function(){
            fm.submit();
        },5000);
    })
});

```

### 表单处理-文本框脚本
```
//文本域value的获取
addEvent(window,'load',function(){
    var fm = document.getElementById('myForm');
    var user = fm.elements['user'];
    var content = fm.elements['content'];

    alert(user.value);
    alert(content.value);
    //PS:在HTML中input有value属性，textarea没有Value属性
    //PS:在js中input和textarea都有Value属性
    
    //使用标准DOM获取
    alert(user.getAttribute('value'));
    alert(content.getAttribute('value'));   //兼容性会有一些问题，IE可以获取，非IE获取不到
    //并且标准DOM无法获取更改后的value

    alert(user.defaultValue);       //获取一开始设置的值，不会改变
    
    user.select();   //选定当前文本域所有文本
});
```
```

addEvent(window,'load',function(){
    var fm = document.getElementById('myForm');
    var user = fm.elements['user'];
    var content = fm.elements['content'];

   
});
```
```
//选择文本
addEvent(window,'load',function(){
    var fm = document.getElementById('myForm');
    var user = fm.elements['user'];
    var content = fm.elements['content'];

    //选择部分文本
    //user.setSelectionRange(0,1);                    //选择从第0个位置到第1个位置的文本
    user.setSelectionRange(0,user.value.length);        //选择全部，IE不支持
    user.focus();         //焦点移入
    //非IE是从第N个到第M个位置


    //IE想要选择部分文本，可以使用IE的范围操作
    var range = user.createTextRange();         //创建range文本范围对象
    range.collapse(true);                       //将文本光标指针移到开头
    range.moveStart('character',0);     //逐字移动，从0开始
    range.moveEnd('character',1);          //从第0个位置开始，选择一个
    range.select();

    //IE是从第N个开始选择M个


});

```
##### 跨浏览器兼容选定文本
```
//选择文本,兼容
addEvent(window,'load',function(){
    var fm = document.getElementById('myForm');
    var user = fm.elements['user'];
    var content = fm.elements['content'];

    getSelectText(user,2,3);


});
//跨浏览器选定部分文本
function getSelectText(text,start,num){
    if(text.setSelectionRange){
        text.setSelectionRange(start,num);
        text.focus();
    }else if(text.createTextRange()){
        var range = text.createTextRange();
        range.collapse(true);
        range.moveStart('character',start);
        range.moveEnd('character',num-start);       //个数=最后的位置-开始的位置
        range.select();
    }
}

```
##### 文本选择事件
```
//文本选择事件
addEvent(window,'load',function(){
    var fm = document.getElementById('myForm');
    var user = fm.elements['user'];
    var content = fm.elements['content'];

    addEvent(user,'select',function(){
        alert('yingxs');
    });

    //非IE选定文本且释放鼠标后出发select事件
    //IE是只要选定了一个字符，就会触发select事件，如果你的速度够快，就可以选择多个，但是不稳定
});

```
##### 获取选择的文本
```
//获取选择的文本
addEvent(window,'load',function(){
    var fm = document.getElementById('myForm');
    var user = fm.elements['user'];
    var content = fm.elements['content'];

    addEvent(user,'select',function(){
        //alert('yingxs');
        //alert(this.value);
        //alert(this.selectionStart);   //选择开始的位置
        //alert(this.selectionEnd);     //选择结束的位置


        //非IE(IE9+)获取选择的文本
        //alert(this.value.substring(this.selectionStart,this.selectionEnd));

        //IE(IE8-)获取选择的文本，IE浏览器提供了document.selection对象
        //document.selection对象createRange()方法可以创建文本范围对象
        //该对象有一个属性是text,可以得到你选择的文本
        //alert(document.selection.createRange().text);
        document.getElementById("p").innerHTML = getSelectText(user);
    });

});

//跨浏览器选择文本
function getSelectText(text){
    if(typeof text.selectionStart == 'number'){
        return text.value.substring(text.selectionStart,text.selectionEnd);
    }else if(document.selection){
        return document.selection.createRange().text;
    }
}


```

##### 过滤输入
```
//过滤输入
/**
 * 过滤输入模式：纯数字
 * 1.禁止或屏蔽非数字键的输入，阻止数字键的默认行为
 * 2.验证后取消，你可以先输入非法字符，然后判断后，取消你刚输入的文本
 */
addEvent(window,'load',function(){
    var fm = document.getElementById('myForm');
    var user = fm.elements['user'];
    var content = fm.elements['content'];

    //屏蔽非数字键的输入
    addEvent(content,'keypress',function(){
        var e = evt || window.event;
        var  charCode = getCharCode(evt);
        //alert(charCode);
        //正则表达式来获取文本是否为数字
        if(!/\d/.test(String.fromCharCode(charCoded)) && charCode>8){
            preDef(evt);
        }
    });

});

//跨浏览器获取字符编码
function getCharCode(evt){
    var e = evt || window.event;
    if(typeof e.charCode == 'number'){
        return e.charCode;
    }else{
        return e.keyCode;
    }
}

```
##### 阻止复制事件
```
addEvent(window,'load',function(){
    var fm = document.getElementById('myForm');
    var user = fm.elements['user'];
    var content = fm.elements['content'];

    //鼠标右击复制和Ctrl+c组合键时触发
    addEvent(content,'copy',function(evt){
       preDef(evt);     //阻止复制事件
    });
    addEvent(content,'cut',function(evt){
       preDef(evt);     //阻止剪切事件
    });
    addEvent(content,'paste',function(evt){
       preDef(evt);     //阻止粘贴事件
    });
    
    //复制前触发
    addEvent(content,'beforecopy',function(){
       alert('复制前！');
    });
    
});

```

##### 屏蔽中文输入法


* css方式
```
style = "ime-mode:diabled"              //CSS直接编写
areaField.style.imrMode = 'disabled';   //在js中设置也可以
```
> Chrome浏览器无法禁止输入法调出，所以为了解决谷歌浏览器的兼容问题，最好使用正则表达式验证已输入的文本,并且屏蔽到输入法的用户体验不是很好，用户会以为是电脑坏了

#### 验证数据非法后取消输入
> 过滤输入模式的第二种方式，即验证后取消

```
addEvent(window,'load',function(){
    var fm = document.getElementById('myForm');
    var user = fm.elements['user'];
    var content = fm.elements['content'];

    addEvent(content,'keyup',function(evt){
        this.value = this.value.replace(/[^\d]/g,'');       //将非字符键替换为空白键
    });

});
```

##### 自动切换焦点
```
//自动切换焦点
addEvent(window,'load',function(){
    var fm = document.getElementById('myForm');
    var user = fm.elements['user'];
    var content = fm.elements['content'];

    addEvent(fm.elements['a1'],'keyup',tabForWard);
    addEvent(fm.elements['a2'],'keyup',tabForWard);
    addEvent(fm.elements['a3'],'keyup',tabForWard);

    function tabForWard(evt){
        var e = evt || window.event;
        //判断内容当前长度，是否和我们设置的一致
        if(this.value.length == this.maxLength){
            //遍历所有控件
            for(var i=0;i < fm.elements.length ; i++){
                if(fm.elements[i] == this){
                    fm.elements[i+1].focus();
                    return ;
                }
            }
        }
    }
});

```

##### cookie与存储
```
alert(typeof  document.cookie);

 //向本地磁盘写入cookie
 document.cookie = 'user=王昊';
 alert(document.cookie);


 //编码
 document.cookie = 'user='+encodeURIComponent('王昊');
 //alert(document.cookie);
 alert(decodeURIComponent(document.cookie));

 完整形式：
 document.cookie = 'user=值;[expires=失效时间;path=路径访问;secure=安全的https限制通信]'
 domain 限制域名访问
 secure 指定必须通过https来通信访问

 var date = new Date();
 date.setDate((date.getDate()-7));      //删除cookie的方法，真正的额删掉了
 document.cookie = 'user='+encodeURIComponent('王昊')+';expires='+date;

```

##### cookie的封装
```
//设置cookie
function setCookie(name,value,expires,path,domain,secure){
  var cookieName = encodeURIComponent(name) + "=" +encodeURIComponent(value);
  if(expires instanceof Date){
   cookieName += ";expires="+expires;
  }
 if(path){
  cookieName += ";path="+path;
 }
 if(domain){
  cookieName += ";domain="+domain;
 }
 if(secure){
  cookieName += ";secure";
 }

 document.cookie = cookieName;
}

//user=%EF%BF%BD%EF%BF%BD%EF%BF%BD; usl=yingxs.com; email=admin%40yingxs.com
/**
 * cookieName 得到 user= 或者 usl= 或者 email=
 * cookieStart 得到user=和其他的开始的位置user=为0，usl=为34，不存在就是-1
 * cookieEnd   得到user=结束的位置是32，
 * @param name
 */
//获取cookie
function getCookie(name){

 var cookieName = encodeURIComponent(name) + '=';
 var cookieStart = document.cookie.indexOf(cookieName);
 var cookieValue = null;
 if(cookieStart > -1){
  var cookieEnd = document.cookie.indexOf(';',cookieStart);
  if(cookieEnd == -1){
    cookieEnd = document.cookie.length;
  }
  cookieValue = document.cookie.substring(cookieStart+cookieName.length,cookieEnd);
  return decodeURIComponent(cookieValue);
 }
}

//alert(getCookie('user'));

//alert(document.cookie);
alert(getCookie('email'));


//设置过期时间
function setCookieDate(day){
 var date = null;

 if(typeof day == 'number' && day>0){
  date = new Date();
  date.setDate(date.getDate()+day);

 }else{
  throw new Error('你传递的天数不合法！必须是数字而且大于0');
 }
 return date;
}

setCookie('user','王昊',setCookieDate(7));
setCookie('usl','yingxs.com',setCookieDate(7));
setCookie('email','admin@yingxs.com',setCookieDate(7));

```
### 跨浏览器获取XHR对象
```
function createXHR(){
 if(typeof XMLHttpRequest!='undefined'){
  return new XMLHttpRequest();
 }else if(typeof ActiveXObject != 'undefined'){
  var version = [
      'MSXML2.XMLHttp.6.0',
      'MSXML2.XMLHttp.3.0',
      'MSXML2.XMLHttp'
  ];
  for(var i=0;i<version.length;i++){
   try{
    return new ActiveXObject(version[i]);
   }catch(e){
    //跳过
   }
  }
 }else{
  throw new Error("你的系统或浏览器不支持XHR对象");
 }

}
```


```
//使用同步方式
addEvent(document,'click',function(){
 var xhr = createXHR();               //创建XHR对象
 xhr.open('get','demo.php?rand='+Math.random(),false);  //准备发送数据，false表示同步

 xhr.send(null);                      //发送请求，get不需要数据提交，则填写为null
 if(xhr.status==200){
  alert(xhr.responseText);
 }else{
  alert('获取数据错误！错误代号：'+xhr.status+'错误信息：'+xhr.statusText);
 }

});

//PS:IE浏览器第一次回想服务端请求，获取最新的数据，而第二次他就默认获取的缓存数据，导致数据不能及时更新
//PS：怎么处理缓存，可以使用JS随机字符串

```

```
//使用异步方式
addEvent(document,'click',function(){
 var xhr = createXHR();
 xhr.onreadystatechange = function(){
  //alert(xhr.readyState);
  if(xhr.readyState == 4){
    if(xhr.status==200){
     alert(xhr.responseText);
    }else{
     alert('获取数据错误！错误代号：'+xhr.status+'错误信息：'+xhr.statusText);
    }
  }
 };
 xhr.open('get','demo.php?rand='+Math.random(),true);

 xhr.send(null);
 //xhr.abort();     //取消异步请求

});
```


```
//头信息
addEvent(document,'click',function(){
 var xhr = createXHR();
 xhr.onreadystatechange = function(){
  if(xhr.readyState == 4){
   if(xhr.status==200){
    //alert(xhr.getAllResponseHeaders());                 //获取全部请求头信息
    alert(xhr.getResponseHeader('Content-Type'));         //获取单个请求头信息
   }else{
    alert('获取数据错误！错误代号：'+xhr.status+'错误信息：'+xhr.statusText);
   }
  }
 };
 xhr.open('get','demo.php?rand='+Math.random(),true);
 xhr.setRequestHeader('myheader','Lee');                 //设置请求头信息，一般没什么用，在POST提交请求是时有用
 xhr.send(null);

});

```


##### Get请求
```
//GET请求
addEvent(document,'click',function(){
 var xhr = createXHR();
 var url = 'demo.php?rand='+Math.random();
 url = params(url,'name','Lee');
 url = params(url,'gae',100);
alert(url);

 xhr.onreadystatechange = function(){
  if(xhr.readyState == 4){
   if(xhr.status==200){
     alert(xhr.responseText);
   }else{
    alert('获取数据错误！错误代号：'+xhr.status+'错误信息：'+xhr.statusText);
   }
  }
 };
 xhr.open('get','demo.php?rand='+Math.random()+'&name=yingxs',true);
 xhr.send(null);

});


function params(url,name,value){
 url += url.indexOf('?') == -1 ? '?' : '&';
 url +=  encodeURIComponent(name) + '=' + encodeURIComponent(value);
 return url;
 //特殊字符需要通过encodeURIComponent()来编码解决，
}

```


##### post访问
```
//POST请求、
addEvent(document,'click',function(){
 var xhr = createXHR();
 var url = 'demo.php?rand='+Math.random();
 xhr.onreadystatechange = function(){
  if(xhr.readyState == 4){
   if(xhr.status==200){
    alert(xhr.responseText);
   }else{
    alert('获取数据错误！错误代号：'+xhr.status+'错误信息：'+xhr.statusText);
   }
  }
 };
 xhr.open('post','demo.php?rand='+Math.random(),true);                                 //第一步，改为post
 xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');             //第三步，模拟表单提交
 xhr.send('name=yingxs&age=100');                                                      //第二步，将键值对放入send方法中

});
```


##### JSON文件加载
```
//JSON加载
addEvent(document,'click',function(){
 var xhr = createXHR();
 var url = 'demo.json?rand='+Math.random();
 xhr.onreadystatechange = function(){
  if(xhr.readyState == 4){
   if(xhr.status==200){
    //alert(xhr.responseText);
    var box = JSON.parse(xhr.responseText);
    alert(box);
   }else{
    alert('获取数据错误！错误代号：'+xhr.status+'错误信息：'+xhr.statusText);
   }
  }
 };
 xhr.open('get',url,true);
 xhr.send(null);

});

```

##### 封装Ajax
```
//格式化参数
function params(data){
 var arr =[];
 for(var i in data){
  arr.push(encodeURIComponent(i)+'='+encodeURIComponent(data[i]));
 }
 return arr.join('&');
}


//封装ajax
function ajax(obj){
 var xhr = createXHR();
 obj.url = obj.url+'?rand='+Math.random();
 obj.data = params(obj.data);
 if(obj.method === 'get') obj.url += obj.url.indexOf("?") == -1 ? '?'+obj.data : '&'+obj.data;
 //alert(obj.url);

 if(obj.async===true){
  xhr.onreadystatechange = function(){
   if(xhr.readyState == 4){
     callback();
   }
  };
 }

 xhr.open(obj.method,obj.url,obj.async);
 if(obj.method === 'post'){
  xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
  xhr.send(obj.data);
 }else if(obj.method === 'get'){
  xhr.send(null);
 }else{
  throw  new Error('未知的请求方式：'+obj.method);
 }

 if(obj.async === false){
  callback();
 }



 function callback(){
  if(xhr.status==200){
   obj.success(xhr.responseText);         //回调传递参数
  }else{
   return '获取数据错误！错误代号：'+xhr.status+'错误信息：'+xhr.statusText;
  }
 }

}

//调用ajax
addEvent(document,'click',function(){

 ajax({
  method:'post',
  url:'demo.php',
  data:{
   'an&me':'Lee',
   'age':100
  },
  success:function(text){
   alert(text);
  },
  async:false
 });



});

/*
//作用域，无法返回
function a(){
 function b(){
  return 123;
 }
 return 456;
}

alert(a());

*/


```























