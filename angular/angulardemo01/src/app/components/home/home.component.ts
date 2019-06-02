import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  public flag:boolean=true;

  constructor() { }

  ngOnInit() {

    // 组件和指令初始化完成 并不是真正的dom加载完成

  }


  // 视图加载完成之后触发的方法 dom加载完成(建议把dom操作放在这里)
  ngAfterViewInit(): void {
    let oBox:any = document.getElementById('box');
    console.log(oBox.innerHTML);
    oBox.style.color='red';

    let oBox1:any = document.getElementById('box1');
    console.log(oBox1.innerHTML);
    oBox1.style.color='red';
  }

}
