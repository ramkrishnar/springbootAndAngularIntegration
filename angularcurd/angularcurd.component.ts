import { Component, OnInit,Input, } from '@angular/core';
import { Http,Response } from '@angular/http';
import { AddressService } from '../address.service';
import { Address } from '../address.model';
@Component({
  selector: 'app-angularcurd',
  templateUrl: './angularcurd.component.html',
  styleUrls: ['./angularcurd.component.css'],
  providers:[AddressService]
})
export class AngularcurdComponent implements OnInit {
private add:Address[];
  constructor(private address:AddressService) { }
  userform:boolean=false;
  edituserform:boolean=false;
  isNewForm=false;
user=[{id:1,name:'rama',mobile:777777777,city:'hyd'},
{id:2,name:'ram',mobile:44444444,city:'hyd'},
{id:3,name:'raj',mobile:33333333333,city:'hyd'},
{id:4,name:'raja',mobile:11111111,city:'hyd'}]
emp={id:1,name:'',mobile:44,city:''}
addres:Address=new Address();

id:number=1;
name:string='';
v:any;
mobile:number=0;
city:string='';
  ngOnInit() {
  }
  onSave(){
    
this.user.push({id:this.emp.id,name:this.emp.name,mobile:this.emp.mobile,city:this.emp.city});
  }
  onDelete(id:number){
    console.log();
this.user.splice(id,1);
  }
updateuser(u,i){
  if(this.user)
this.emp=u;
}
saveAddress(){
this.address.saveAdd(this.addres).subscribe(
  (response:Response)=>{
    console.log('data saved');
  },
  (err)=>{
    console.log('server problem');
  }
)

}
onGet(unit:string,street_number:string,street_type:string,street_name:string,city:string){
 if(unit==''){
   unit=null;
 }
 if(street_number==''){
  street_number=null;
}
if(street_type==''){
  street_type=null;
}
if(street_name==''){
  street_name=null;
}
if(city==''){
  city=null;
}

  console.log(unit);
this.address.getAddress(unit,street_number,street_type,street_name,city).subscribe(add=>{
  this.add=add;

  console.log(add[0].street_name);
  }
  
)
}

}
