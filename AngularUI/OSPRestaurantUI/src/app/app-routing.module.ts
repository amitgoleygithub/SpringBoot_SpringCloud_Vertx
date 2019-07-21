import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { MenuComponent } from './menu/menu.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { ContactusComponent } from './contactus/contactus.component';
import { OrderlistComponent } from './orderlist/orderlist.component';
import { WelcomeComponent } from './welcome/welcome.component';

const routes: Routes = [
  {
    path: 'welcomelink',    component: WelcomeComponent
  },
  {
    path: 'menulink',    component: MenuComponent
  },
  {
    path: 'contactuslink',    component: ContactusComponent
  }
  ,
  {
    path: '',
    component: WelcomeComponent
  }
  ,
  {
    path: '',
    outlet: 'orderlist',
    component: OrderlistComponent
  }
];


@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [ RouterModule ]

})
export class AppRoutingModule { 



  
}
