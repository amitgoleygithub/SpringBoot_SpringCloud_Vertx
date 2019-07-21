import { Component, OnInit } from '@angular/core';
import {MenuService} from './menu.service';
import { BillingResponse } from './billingresponse';
import { error } from 'util';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  billingResponse: BillingResponse;

  constructor(private menuService: MenuService) { }

  ngOnInit() {

       console.log("menu component in init");
   
       this.menuService.callBillingService().subscribe(
                billingResponseData => {
                 console.log("billing response data received = "+billingResponseData);
                 this.billingResponse = billingResponseData;
                },
                error => {
                  console.log("in error = "+error);
                }
         );
   
         console.log("menu component in init completed");

  }

}
