export interface Sport {
  id?: string
  name: string
  description: string
}

export interface SportSession {
  id?: string
  sport: Sport
  trainerId: string
  startTime: string
  endTime: string
  location: string
}

export interface SportSessionRequest {
  sportId: string
  tarinerId: string
  startTime: string
  endTime: string
  location: string
}

export interface SportSubscription {
  userID: string
  sportID: string
}

