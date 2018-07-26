import { Component, OnInit,Input } from '@angular/core';

@Component({
  selector: 'app-server',
  templateUrl: './server.component.html',
  styleUrls: ['./server.component.css']
})
export class ServerComponent implements OnInit {
  @Input() element:{type:string,name:string,content:string}
serverid:number=10;
serverstaus:string='offline';
allowserver=false;
servername='testserver';
servercreation='no server created';
server=['test','run'];
servercreated=false
  constructor() { 
    setTimeout(()=>{
      this.allowserver=true;
    },2000)
  }
getserverstatus(){
  
return this.serverstaus;
}
oncreateserver(){
  this.servercreated=true;
  this.server.push(this.servername);
  this.serverstaus='online';
  this.servercreation='server created';
  }
 onupdateserver(event:Event){
  this.servername=(<HTMLInputElement>event.target).value;
}
getcolor(){
  return this.serverstaus==='online' ? 'green':'red';
}
  ngOnInit() {
  }

}
