import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../../services/user.service';
import { SportService } from '../../services/sport.service';
import { User } from '../../models/user/user';
import { Relationship } from '../../models/user/relationship';
import { RelationshipRequest } from '../../models/user/relationship-request';
import { Sport } from '../../models/sport/sport';
import { SportSessionRequest } from '../../models/sport/sport-session-request';

@Component({
  selector: 'app-user-management',
  templateUrl: './user-management.component.html',
  standalone:false,
  styleUrls: ['./user-management.component.css']
})
export class UserManagementComponent implements OnInit {
  currentUser: User | null = null;
  relationships: Relationship[] = [];
  sports: Sport[] = [];

  relationshipForm: FormGroup;
  sportSessionForm: FormGroup;

  message: string = '';

  constructor(
    private fb: FormBuilder,
    private userService: UserService,
    private sportService: SportService
  ) {
    this.relationshipForm = this.fb.group({
      secondUserId: ['', Validators.required],
      relationType: ['', Validators.required]
    });

    this.sportSessionForm = this.fb.group({
      sportId: ['', Validators.required],
      startTime: ['', Validators.required],
      endTime: ['', Validators.required],
      location: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.loadSports();
  }

  loadSports() {
    this.sportService.getAllSports().subscribe({
      next: (sports) => {
        this.sports = sports;
      },
      error: (error) => {
        this.message = 'Error loading sports: ' + error.message;
      }
    });
  }

  setCurrentUser(user: User) {
    this.currentUser = user;
    this.loadRelationships();
  }

  loadRelationships() {
    if (this.currentUser?.id) {
      this.userService.getRelationships(this.currentUser.id).subscribe({
        next: (relationships) => {
          this.relationships = relationships;
        },
        error: (error) => {
          this.message = 'Error loading relationships: ' + error.message;
        }
      });
    }
  }

  addRelationship() {
    if (this.relationshipForm.valid && this.currentUser?.id) {
      const relationship: RelationshipRequest = {
        firstUserId: this.currentUser.id,
        secondUserId: this.relationshipForm.value.secondUserId,
        relationType: this.relationshipForm.value.relationType
      };

      this.userService.addRelationship(relationship).subscribe({
        next: (response) => {
          this.message = 'Relationship added successfully';
          this.loadRelationships();
          this.relationshipForm.reset();
        },
        error: (error) => {
          this.message = 'Error adding relationship: ' + error.message;
        }
      });
    }
  }

  deleteRelationship(familyMemberId: string | undefined) {
    if (this.currentUser?.id && familyMemberId != null) {
      this.userService.deleteRelationship({
        firstUserId: this.currentUser.id,
        secondUserId: familyMemberId
      }).subscribe({
        next: (response) => {
          this.message = 'Relationship deleted successfully';
          this.loadRelationships();
        },
        error: (error) => {
          this.message = 'Error deleting relationship: ' + error.message;
        }
      });
    }
  }

  renewMembership() {
    if (this.currentUser?.id) {
      this.userService.renewMembership(this.currentUser.id).subscribe({
        next: (response) => {
          this.message = response;
        },
        error: (error) => {
          this.message = 'Error renewing membership: ' + error.message;
        }
      });
    }
  }

  subscribeSport(sportId: string | undefined) {
    if (this.currentUser?.id && sportId != null) {
      this.userService.subscribeSport(this.currentUser.id, sportId).subscribe({
        next: (response) => {
          this.message = response;
        },
        error: (error) => {
          this.message = 'Error subscribing to sport: ' + error.message;
        }
      });
    }
  }

  addSportSession() {
    if (this.sportSessionForm.valid && this.currentUser?.id) {
      const formValue = this.sportSessionForm.value;

      const session: SportSessionRequest = {
        sportId: formValue.sportId,
        tarinerId: this.currentUser.id,
        startTime: formValue.startTime,
        endTime: formValue.endTime,
        location: formValue.location
      };

      this.sportService.addSportSession(session).subscribe({
        next: (response) => {
          this.message = 'Sport session added successfully';
          this.sportSessionForm.reset();
        },
        error: (error) => {
          this.message = 'Error adding sport session: ' + error.message;
        }
      });
    }
  }
}
