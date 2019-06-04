var EventEmitter = require("events");

class CustomEvent extends EventEmitter {

}

function fn1 (){
    console.log('fn1');
}

function fn2 (){
    console.log('fn2');
}




var ce = new CustomEvent();

// 只能触发一次的事件

ce.on('test',fn1);
ce.on('test',fn2);



// 触发事件
setInterval( ( )=> {
    ce.emit('test');
},500);


setTimeout(()=>{
    //移除某一事件的某一方法
    // ce.removeListener('test',fn2);
    // ce.removeListener('test',fn1);

    // 移除该事件的所有方法
    ce.removeAllListeners('test');
},1500);



