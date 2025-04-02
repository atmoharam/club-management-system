import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { User } from '../models/user/user';

@Injectable({
  providedIn: 'root'
})
export class NavigationService {
  private currentUserSubject = new BehaviorSubject<User | null>(null);
  currentUser$ = this.currentUserSubject.asObservable();

  constructor(private router: Router) { }

  // Set current user and navigate to user management
  navigateToUserManagement(user: User): void {
    this.currentUserSubject.next(user);
    this.router.navigate(['/user-management']);
  }

  // Get current user
  getCurrentUser(): User | null {
    return this.currentUserSubject.value;
  }

  // Clear current user (for logout)
  clearCurrentUser(): void {
    this.currentUserSubject.next(null);
  }
}
