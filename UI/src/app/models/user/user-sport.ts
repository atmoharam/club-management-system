import { Sport } from '../sport/sport';

export interface UserSport {
  id?: string;
  userId: string;
  sport: Sport;
  subscriptionDate?: string;
}
