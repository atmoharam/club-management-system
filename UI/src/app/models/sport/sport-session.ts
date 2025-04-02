import { Sport } from './sport';

export interface SportSession {
  id?: string;
  sport: Sport;
  trainerId: string;
  startTime: string;
  endTime: string;
  location: string;
}
