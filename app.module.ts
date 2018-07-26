import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import {Router, Routes, RouterModule} from '@angular/router';
import { AppComponent } from './app.component';
import { ServerComponent } from './server/server.component';
import {AddressService } from './address.service';
import { CockpitComponent } from './cockpit/cockpit.component';
import { BasicdirDirective } from './basicdir.directive';

import { AngularcurdComponent } from './angularcurd/angularcurd.component';
import { UsersComponent } from './users/users.component';
const approute:Routes=[{path:'cockpit',component:CockpitComponent},
{path:'server', component:ServerComponent},
{path:'Address/:id/:name', component:UsersComponent},
{path:'Address', component:AngularcurdComponent}]

@NgModule({
  declarations: [
    AppComponent,
    ServerComponent,
    CockpitComponent,
    BasicdirDirective,
   
    AngularcurdComponent,
   
    UsersComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(approute)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
