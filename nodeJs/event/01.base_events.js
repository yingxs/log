var EventEmitter = require('events');


class CustomEvent extends EventEmitter {

}

var ce = new CustomEvent();

// 注册事件
ce.on('test',() => {
    console.log('this is a test! ');
});



// 触发事件
setInterval( ( )=> {
    ce.emit('test');
},500);



