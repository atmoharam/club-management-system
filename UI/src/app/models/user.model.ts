export interface Phone {
  countryCode: string
  number: string
}

export interface Address {
  street: string
  city: string
  zip: string
}

export interface User {
  id?: string
  name: string
  email: string
  phone?: Phone
  dateOfBirth: string
  address?: Address
  membershipStatus?: string
  renewalDate?: string
  createdAt?: string
  updatedAt?: string
}

export interface CheckAction {
  id: string
  gate: string
}

export interface ActionResponse {
  status: string
  message: string
}

export interface Relationship {
  user: User
  familyMember: User
  relation: string
  createdAt: string
}

export interface RelationshipRequest {
  firstUserId: string
  secondUserId: string
  relationType: string
}

export interface RelationshipDeleteRequest {
  firstUserId: string
  secondUserId: string
}

