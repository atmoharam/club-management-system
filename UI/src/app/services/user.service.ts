import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user/user';
import { CheckAction } from '../models/user/check-action';
import { ActionResponse } from '../models/user/action-response';
import { Relationship } from '../models/user/relationship';
import { RelationshipRequest } from '../models/user/relationship-request';
import { RelationshipDeleteRequest } from '../models/user/relationship-delete-request';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private memberApiUrl = 'http://localhost:8686/member';
  private securityApiUrl = 'http://localhost:8686/security';

  constructor(private http: HttpClient) { }

  // User registration
  createUser(user: User): Observable<string> {
    return this.http.post<string>(this.memberApiUrl, user);
  }

  // User login by ID
  getUserById(id: string): Observable<User> {
    return this.http.get<User>(`${this.memberApiUrl}/id/${id}`);
  }

  // User login by email
  getUserByEmail(email: string): Observable<User> {
    return this.http.get<User>(`${this.memberApiUrl}/email/${email}`);
  }

  // Check-in action
  checkIn(action: CheckAction): Observable<ActionResponse> {
    return this.http.post<ActionResponse>(`${this.securityApiUrl}/check_in`, action);
  }

  // Check-out action
  checkOut(action: CheckAction): Observable<ActionResponse> {
    return this.http.post<ActionResponse>(`${this.securityApiUrl}/check_out`, action);
  }

  // Add relationship
  addRelationship(relationship: RelationshipRequest): Observable<Relationship> {
    return this.http.post<Relationship>(`${this.memberApiUrl}/relationship`, relationship);
  }

  // Get all relationships for a user
  getRelationships(userId: string): Observable<Relationship[]> {
    return this.http.get<Relationship[]>(`${this.memberApiUrl}/relationship/all/${userId}`,);
  }

  // Delete relationship
  deleteRelationship(request: RelationshipDeleteRequest): Observable<string> {
    return this.http.delete<string>(`${this.memberApiUrl}/relationship`, { body: request });
  }

  // Renew membership
  renewMembership(userId: string): Observable<string> {
    return this.http.post<string>(`${this.memberApiUrl}/renew-membership`, { userId });
  }

  // Subscribe to sport
  subscribeSport(userID: string, sportID: string): Observable<string> {
    return this.http.post<string>(`${this.memberApiUrl}/sport/subscribe-sport`, { userID, sportID });
  }
}
