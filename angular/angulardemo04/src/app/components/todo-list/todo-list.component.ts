import { Component, OnInit } from '@angular/core';
//引入服务
import { StorageService } from '../../services/storage.service';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.scss']
})
export class TodoListComponent implements OnInit {


  public keyword:string;

  public todoList:any[]=[];

  //初始化服务
  constructor(public storage:StorageService) { 
    // console.log(storage.get());
  }

  ngOnInit() {
     // 页面组件刷新
     console.log('页面刷新会触发这个声明周期函数');
     var todoList:any = this.storage.get("todoList");
     if (todoList) {
       this.todoList = todoList;
     }
  }

  doAdd(e){
    if (e.keyCode == 13 ) {
      if (!this.todoListHasKeyword(this.todoList,this.keyword)){
        this.todoList.push({
          title:this.keyword,
          status:0                //0.待办 1.已完成
        });
        this.keyword='';
        this.storage.set("todoList",this.todoList);     
      } else {
        alert('数据已经存在');
        this.keyword='';
      }
    }
  }

  deletey(key){
    this.todoList.splice(key,1);

    this.storage.set("todoList",this.todoList);


  }


  todoListHasKeyword(todoList:any,keyword:any){
    // 异步 会存在问题
    // todoList.forEach(value => {
    //   if (value.title == keyword)  {
    //     return true;
    //   }
      
    // });
    if (!keyword) return false;
    for(var i = 0 ; i<todoList.length ; i++){
      if(todoList[i].title==keyword) {
        return true;
      }
    }
    return false;
  }


  chechboxChange(){
    console.log('chechbox Change事件触发');
    this.storage.set("todoList",this.todoList);
  }
 

}

