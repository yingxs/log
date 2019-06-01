
// 根组件
//引入核心模块里面的Component
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',                     //使用这个组件的名称
  templateUrl: './app.component.html',      //组件的html
  styleUrls: ['./app.component.scss']       //组件的css
})
export class AppComponent {
  title = 'angulardemo02';              //定义属性

  constructor(){ // 构造函数

  }
}
