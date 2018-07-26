import { Injectable } from '@angular/core';
import { Http,Response } from '@angular/http';
import { Observable } from "rxjs/Observable"
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch';
import { Address } from './address.model';
@Injectable()
export class AddressService {

 
  api="http://localhost:8888/getAdress?street_number=2525&street_name=ARBUTUS ST&city=newyork&unit=35&street_type=st"
  constructor(private http:Http ) { }
  getAddress(unit:string,street_number:string,street_type:string,street_name:string,city:string):Observable<Address[]>{
    var uniturl="&unit="+unit
    var street_numberurl="&street_number="+street_number
    var street_typeurl='&street_type='+street_type;
    var street_nameurl='&street_name='+street_name
    var cityurl='&city='+city;
    if(unit==null){
   uniturl='';
    }
    if(street_number==null){
      street_numberurl=''
   }
   if(street_type==null){
    street_typeurl='';
   }
   if(street_name==null){
    street_nameurl='';
   }
   if(city==null){
    cityurl='';
   }
  
   this.api='http://localhost:8888/getAdress?'+uniturl+street_numberurl+street_typeurl+street_nameurl+cityurl;
   
  
   this.api=this.api.replace(/&/i,'')
   console.log(this.api)
   
   
   
    console.log(this.api)
    return this.http.get(this.api
  
  ).map((res:Response) => res.json())
   .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }
saveAdd(address:Address){
  console.log(address.street_name+address.street_number+address.city);
return this.http.post('http://localhost:8888/saveAddress',address);
}
}
