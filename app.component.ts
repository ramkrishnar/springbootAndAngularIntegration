import { Component,Input } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app works!';
serverElement=[{type:'server',name:'test',content:'just test'}]
  onservercreate(serverdata:{name:string,content:string}){
    this.serverElement.push({type:'server',
  name:serverdata.name,
  content:serverdata.content
  })
  }
  
}
