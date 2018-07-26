import { Component, OnInit,Output,EventEmitter } from '@angular/core';


@Component({
  selector: 'app-cockpit',
  templateUrl: './cockpit.component.html',
  styleUrls: ['./cockpit.component.css']
})
export class CockpitComponent implements OnInit {
  servername='';
  servercontent='';
@Output('test')servercreatedevent=new EventEmitter<{name:string,content:string}>();


  constructor() { }
  addserver(){
    this.servercreatedevent.emit({name:this.servername,content:this.servercontent});
  }
  ngOnInit() {
    
  }

}
