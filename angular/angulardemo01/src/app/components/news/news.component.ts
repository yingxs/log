import { Component, OnInit,ViewChild,ElementRef } from '@angular/core';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.scss']
})
export class NewsComponent implements OnInit {

  // 获取dom节点
  @ViewChild("myBox",{static:true}) mybox:ElementRef;
  
  // 获取子组件
  @ViewChild('header',{static:false}) header:any;

  
  constructor() { }



  ngOnInit() {


  }



ngAfterViewInit(): void {
  console.log(this.mybox);

  this.mybox.nativeElement.style.width='100px';
  this.mybox.nativeElement.style.height='100px';
  this.mybox.nativeElement.style.height='100px';
  this.mybox.nativeElement.style.background='red';
  console.log(this.mybox.nativeElement.innerHTML);


 
}


getChildRun(){
 // 调用子组件的方法
 this.header.run();
}



}
