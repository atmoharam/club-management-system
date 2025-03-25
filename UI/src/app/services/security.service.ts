import { Injectable } from "@angular/core"
import type { HttpClient } from "@angular/common/http"
import type { Observable } from "rxjs"
import type { SecurityAction } from "../models/security.model"

@Injectable({
  providedIn: "root",
})
export class SecurityService {
  private apiUrl = "http://localhost:8531/security"

  constructor(private http: HttpClient) {}

  // Get count of online users
  getOnlineUsersCount(): Observable<number> {
    return this.http.get<number>(`${this.apiUrl}/count-now`)
  }

  // Get actions by gate
  getActionsByGate(gate: string): Observable<SecurityAction[]> {
    return this.http.get<SecurityAction[]>(`${this.apiUrl}/gate/${gate}`)
  }
}

