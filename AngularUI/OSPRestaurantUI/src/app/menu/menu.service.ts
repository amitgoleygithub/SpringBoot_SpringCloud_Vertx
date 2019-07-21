import { Injectable } from '@angular/core';
import { Observable, Subject, of } from 'rxjs';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http'; 
import { BillingResponse } from './billingresponse';


@Injectable({
  providedIn: 'root'
})
export class MenuService {

        constructor(private http: HttpClient) { 
            
        }   
      
       callBillingService() : Observable<BillingResponse>{

        console.log("calling blling service");
        let url = "http://localhost:8761/ospapi/billing-service/billing?amount=100&ordername=furniture";
         
        return this.http.get<BillingResponse>(url, {responseType : 'json'});
    
     }



}
