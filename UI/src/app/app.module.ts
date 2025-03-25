import { NgModule } from "@angular/core"
import { BrowserModule } from "@angular/platform-browser"
import { HttpClientModule } from "@angular/common/http"
import { ReactiveFormsModule } from "@angular/forms"

import { AppRoutingModule } from "./app-routing.module"
import { AppComponent } from "./app.component"
import { UserOperationsComponent } from "./components/user-operations/user-operations.component"
import { UserManagementComponent } from "./components/user-management/user-management.component"
import { AdminPanelComponent } from "./components/admin-panel/admin-panel.component"

@NgModule({
  declarations: [AppComponent, UserOperationsComponent, UserManagementComponent, AdminPanelComponent],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, ReactiveFormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}

