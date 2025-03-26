import { User } from './user';

export interface Relationship {
  user: User;
  familyMember: User;
  relation: string;
  createdAt: string;
}
