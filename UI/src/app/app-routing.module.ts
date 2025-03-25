import { NgModule } from "@angular/core"
import { RouterModule, type Routes } from "@angular/router"
import { UserOperationsComponent } from "./components/user-operations/user-operations.component"
import { UserManagementComponent } from "./components/user-management/user-management.component"
import { AdminPanelComponent } from "./components/admin-panel/admin-panel.component"

const routes: Routes = [
  { path: "", redirectTo: "/user-operations", pathMatch: "full" },
  { path: "user-operations", component: UserOperationsComponent },
  { path: "user-management", component: UserManagementComponent },
  { path: "admin-panel", component: AdminPanelComponent },
  { path: "**", redirectTo: "/user-operations" },
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}

