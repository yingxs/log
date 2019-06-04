var EventEmitter = require("events");

class CustomEvent extends EventEmitter {

}

var ce = new CustomEvent();

ce.once('test',( ) => {

console.log("test event");
});



// 触发事件
setInterval( ( )=> {
    ce.emit('test');
},500);



