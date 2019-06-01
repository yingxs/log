import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent implements OnInit {


  public peopleInfo:any = {
    username:'111',
    sex:'1',
    cityList:['深圳','上海','北京','广州'],
    city:'北京',
    hobby:[{
      title:'吃饭',
      checked:false
    },{
      title:'睡觉',
      checked:false
    },{
      title:'看电视',
      checked:true
    }],
    mark:''
  }

  constructor() { }

  ngOnInit() {
  }

  doSubmit(){
    // 获取值的方式
    //1.jquery的dom操作  不推荐
    /*
    let nameDom:any = document.getElementById("username");
    alert(nameDom.value);
    */

    //2.双向绑定

      console.log(this.peopleInfo.username);
    





  }

}
