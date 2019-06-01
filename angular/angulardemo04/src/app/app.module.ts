import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

// 引入表单相关的模块，才可以实现双向数据绑定
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { FormComponent } from './components/form/form.component';
import { SearchComponent } from './components/search/search.component';
import { TodoListComponent } from './components/todo-list/todo-list.component';


// 引入并且配置服务
import { StorageService } from './services/storage.service';

@NgModule({
  declarations: [
    AppComponent,
    FormComponent,
    SearchComponent,
    TodoListComponent
  ],
  imports: [
    BrowserModule,FormsModule
  ],
  //服务
  providers: [StorageService],
  bootstrap: [AppComponent]
})
export class AppModule { }
