import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Sport } from '../models/sport/sport';
import { SportSession } from '../models/sport/sport-session';
import { SportSessionRequest } from '../models/sport/sport-session-request';

@Injectable({
  providedIn: 'root'
})
export class SportService {
  private apiUrl = 'http://localhost:8577/sport';

  constructor(private http: HttpClient) { }

  // Get all sports
  getAllSports(): Observable<Sport[]> {
    return this.http.get<Sport[]>(`${this.apiUrl}/all`);
  }

  // Add new sport
  addSport(sport: Sport): Observable<string> {
    return this.http.post<string>(this.apiUrl, sport);
  }

  // Update sport
  updateSport(sport: Sport): Observable<string> {
    return this.http.put<string>(this.apiUrl, sport);
  }

  // Delete sport
  deleteSport(id: string): Observable<string> {
    return this.http.delete<string>(this.apiUrl, { body: { value: id } });
  }

  // Add sport session
  addSportSession(session: SportSessionRequest): Observable<string> {
    return this.http.post<string>(`${this.apiUrl}/session`, session);
  }

  // Get sessions by sport name
  getSessionsBySportName(sportName: string): Observable<SportSession[]> {
    return this.http.get<SportSession[]>(`${this.apiUrl}/session/sport-name/${sportName}`);
  }

  // Get sessions by trainer ID
  getSessionsByTrainerId(trainerId: string): Observable<SportSession[]> {
    return this.http.get<SportSession[]>(`${this.apiUrl}/session/trainer/${trainerId}`);
  }

  // Get session by ID
  getSessionById(sessionId: string): Observable<SportSession> {
    return this.http.get<SportSession>(`${this.apiUrl}/session/id/${sessionId}`);
  }
}
