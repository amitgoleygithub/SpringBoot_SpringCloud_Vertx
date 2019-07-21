import { Component, OnInit } from '@angular/core';
import { MenuItem } from './MenuItem';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  menuItemsArray: MenuItem[] = [
    {itemname: 'Chicken Biryani', itemprice: 10.99, itemimage: '/assets/images/menuitems/chicken_biryani.png' ,itemid: 100},
    {itemname: 'Veg Biryani', itemprice: 9.99, itemimage: '/assets/images/menuitems/veg_biryani.png' ,itemid: 101},
    {itemname: 'Paneer Tikka Masala', itemprice: 12.99, itemimage: '/assets/images/menuitems/paneer_tikka_masala.png' ,itemid: 102},
    {itemname: 'Pizza', itemprice: 15.99, itemimage: '/assets/images/menuitems/pizza.png' ,itemid: 103},
    {itemname: 'Tandoori Chicken', itemprice: 10.99, itemimage: '/assets/images/menuitems/tandoori_chicken.png' ,itemid: 104},
    {itemname: 'Fish Curry', itemprice: 13.99, itemimage: '/assets/images/menuitems/fish_curry.png' ,itemid: 105},
    {itemname: 'Daal Tadka', itemprice: 8.99, itemimage: '/assets/images/menuitems/daal_tadka.png' ,itemid: 106},
    {itemname: 'Palak Paneer', itemprice: 10.99, itemimage: '/assets/images/menuitems/palak_paneer.png' ,itemid: 107}
    ];

  constructor() { }

  ngOnInit() {
  }

}
