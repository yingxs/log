import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-new',
  templateUrl: './new.component.html',
  styleUrls: ['./new.component.scss']
})
export class NewComponent implements OnInit {


  public title = '我是新闻组件';

  public msg = '新闻组件的msg';

  // 推荐any表示  任意类型
  public student:any='我是一个学生的属性';

  public messsage:any;
  
  public userInfo:object={
    username : "张三",
    age :'20'
  }


  public content ="<h2>我是一个html标签</h2>";

  //定义数组
  public arr = ['111','222','333'];   //等同于 public arr:any[] = [''];

  // 推荐
  public list:any[] = ['我是第一个新闻',222222,'我是第三个新闻'];

  // 类似java泛型的概念
  public items:Array<any> = ['我是第一个新闻',222222,'我是第三个新闻'];
 
  // public items:Array<number> = ['我是第一个新闻',222222,'我是第三个新闻'];

  public userlist:any[]=[{
    username:'张三',
    age:20
  },{
    username:'李四',
    age:21
  },{
    username:'王五',
    age:23
  }];


  public  cars:any[]=[
    {
      cate:'宝马',
      list:[
        {
          'title':'宝马x1',
          'price':'20w',
        },{
          'title':'宝马x2',
          'price':'30w',
        },{
          'title':'宝马x3',
          'price':'40w',
        }
      ]
    },
    {
      cate:'奥迪',
      list:[
        {
          'title':'奥迪A4',
          'price':'20w',
        },{
          'title':'奥迪A6',
          'price':'50w',
        },{
          'title':'奥迪A8',
          'price':'100w',
        },{
          'title':'奥迪RS6',
          'price':'80w',
        }
      ]
    }
  ]

  constructor() { 
    this.messsage = '这是给属性的赋值--改变属性的值';
    console.log(this.msg);
  }

  ngOnInit() {
  }

}
