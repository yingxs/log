import { Component, OnInit } from '@angular/core';
//引入服务
import { StorageService } from '../../services/storage.service';

/**
 不推荐
  var storage = new  StorageService();

 */


@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {


  public keyword:string;

  public historyList:any[]=[];

  constructor(public storage:StorageService) {
    // console.log(storage.get());
   }

  ngOnInit() {
    // 页面组件刷新
    console.log('页面刷新会触发这个声明周期函数');
    var searchList:any = this.storage.get("searchList");
    if (searchList) {
      this.historyList = searchList;
    }
  }

  doSearch(){

    if (this.historyList.indexOf(this.keyword) == -1) {
      this.historyList.push(this.keyword);

      // 缓存数据
      this.storage.set("searchList",this.historyList);
    }
 
    this.keyword = '';
    console.log(this.keyword);
  }


  deleteHistory(key){
    this.historyList.splice(key,1);
    console.log(key);
    // 缓存数据
    this.storage.set("searchList",this.historyList);

  }

}
