import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserOperationsComponent } from './components/user-operations/user-operations.component';
import {ReactiveFormsModule} from '@angular/forms';
import { UserManagementComponent } from './components/user-management/user-management.component';
import { AdminPanelComponent } from './components/admin-panel/admin-panel.component';
import {HttpClientModule} from '@angular/common/http';
import {NavigationService} from './services/navigation.service';
import {UserService} from './services/user.service';
import {SportService} from './services/sport.service';
import {SecurityService} from './services/security.service';

@NgModule({
  declarations: [
    AppComponent,
    UserOperationsComponent,
    UserManagementComponent,
    AdminPanelComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    UserService,
    SportService,
    SecurityService,
    NavigationService

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
