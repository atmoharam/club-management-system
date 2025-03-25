import { Injectable } from "@angular/core"
import type { HttpClient } from "@angular/common/http"
import type { Observable } from "rxjs"
import type {
  User,
  CheckAction,
  ActionResponse,
  Relationship,
  RelationshipRequest,
  RelationshipDeleteRequest,
} from "../models/user.model"

@Injectable({
  providedIn: "root",
})
export class UserService {
  private memberApiUrl = "http://localhost:8568/member"
  private securityApiUrl = "http://localhost:8531/security"

  constructor(private http: HttpClient) {}

  // User registration
  createUser(user: User): Observable<string> {
    return this.http.post<string>(this.memberApiUrl, user)
  }

  // User login by ID
  getUserById(id: string): Observable<User> {
    return this.http.get<User>(`${this.memberApiUrl}/id/${id}`)
  }

  // User login by email
  getUserByEmail(email: string): Observable<User> {
    return this.http.get<User>(`${this.memberApiUrl}/email/${email}`)
  }

  // Check-in action
  checkIn(action: CheckAction): Observable<ActionResponse> {
    return this.http.post<ActionResponse>(`${this.securityApiUrl}/check_in`, action)
  }

  // Check-out action
  checkOut(action: CheckAction): Observable<ActionResponse> {
    return this.http.post<ActionResponse>(`${this.securityApiUrl}/check_out`, action)
  }

  // Add relationship
  addRelationship(relationship: RelationshipRequest): Observable<Relationship> {
    return this.http.post<Relationship>(`${this.memberApiUrl}/relationship`, relationship)
  }

  // Get all relationships for a user
  getRelationships(userId: string): Observable<Relationship[]> {
    return this.http.post<Relationship[]>(`${this.memberApiUrl}/relationship/all`, { id: userId })
  }

  // Delete relationship
  deleteRelationship(request: RelationshipDeleteRequest): Observable<string> {
    return this.http.delete<string>(`${this.memberApiUrl}/relationship`, { body: request })
  }

  // Renew membership
  renewMembership(userId: string): Observable<string> {
    return this.http.post<string>(`${this.memberApiUrl}/renew-membership`, { userId })
  }

  // Subscribe to sport
  subscribeSport(userID: string, sportID: string): Observable<string> {
    return this.http.post<string>(`${this.memberApiUrl}/sport/subscribe-sport`, { userID, sportID })
  }
}

