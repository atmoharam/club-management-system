import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AdminPanelComponent} from './components/admin-panel/admin-panel.component';
import {UserManagementComponent} from './components/user-management/user-management.component';
import {UserOperationsComponent} from './components/user-operations/user-operations.component';

const routes: Routes = [
  { path: '', redirectTo: '/user-operations', pathMatch: 'full' },
  { path: 'user-operations', component: UserOperationsComponent },
  { path: 'user-management', component: UserManagementComponent },
  { path: 'admin-panel', component: AdminPanelComponent },
  { path: '**', redirectTo: '/user-operations' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
