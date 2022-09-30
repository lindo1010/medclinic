import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {Routes, RouterModule} from "@angular/router";
import {AppComponent} from "./app.component";
import {HealthProviderComponent} from "./health-provider/health-provider.component";

const routes : Routes = [
  {path: '', component: AppComponent},
  {path: 'healthProvider', component: HealthProviderComponent}
]

@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class AppRoutingModule { }
