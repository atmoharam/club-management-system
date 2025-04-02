import { Phone } from './phone';
import { Address } from './address';

export interface User {
  id?: string;
  name: string;
  email: string;
  phone?: Phone;
  dateOfBirth: string;
  address?: Address;
  membershipStatus?: string;
  renewalDate?: string;
  createdAt?: string;
  updatedAt?: string;
}
