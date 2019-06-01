import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {



  public title:string = '我是一个title';
  public picUrl = 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1559381099392&di=bb99e64e2157e279097fb37fd9afab43&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fdc54564e9258d1092f7663c9db58ccbf6c814d30.jpg';


  public list:any[]=[
    {
      'title':'我是新闻1'
    },{
      'title':'我是新闻2'
    },{
      'title':'我是新闻3'
    },{
      'title':'我是新闻3'
    },
  ]

  public flag:boolean = true;
  public orderStatus:any =  "1";  
  /*
  1. 已经支付
  2.支付并确认订单
  3.已经发货
  4.已经收获
  5.无效
  */

  public attr:string = 'red';

  public today:any = new Date();

  public keywords:string='默认值';

  constructor() { 
    console.log(this.today);
  }

  ngOnInit() {
  }


  run(){
    alert('执行自定义方法');
  }

  getData(){
    alert(this.title);
  }

  setData(){
    this.title = '我是改变后的title'

  }

  keyDown(e){
    if (e.keyCode == 13) {
      //按一下回车
      console.log('按一下回车');
    } else {
      console.log(e.keyCode);
      // 获取DOM对象
      ///console.log(e.target.value);

    }
    
  }

  keyuUp(e){
    if (e.keyCode == 13) {
      //按一下回车
      console.log('按一下回车');
      console.log(e.target.value);
    } 
  }


  runEvent(e){
    var dom:any = e.target;
    dom.style.color='red';
  }

  changeKeywords(){
    this.keywords='我是改变后的值';
  }

  getKeywords(){
    console.log(this.keywords);
  }
}
