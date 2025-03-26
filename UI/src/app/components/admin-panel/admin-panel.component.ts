import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SportService } from '../../services/sport.service';
import { SecurityService } from '../../services/security.service';
import { Sport } from '../../models/sport/sport';
import { SportSession } from '../../models/sport/sport-session';
import { SecurityAction } from '../../models/security/security-action';

@Component({
  selector: 'app-admin-panel',
  templateUrl: './admin-panel.component.html',
  standalone:false,
  styleUrls: ['./admin-panel.component.css']
})
export class AdminPanelComponent implements OnInit {
  sportForm: FormGroup;
  sportNameForm: FormGroup;
  trainerIdForm: FormGroup;
  sessionIdForm: FormGroup;
  gateForm: FormGroup;

  sports: Sport[] = [];
  sportSessions: SportSession[] = [];
  securityActions: SecurityAction[] = [];
  selectedSession: SportSession | null = null;
  onlineUsersCount: number = 0;

  message: string = '';

  constructor(
    private fb: FormBuilder,
    private sportService: SportService,
    private securityService: SecurityService
  ) {
    this.sportForm = this.fb.group({
      id: [''],
      name: ['', Validators.required],
      description: ['']
    });

    this.sportNameForm = this.fb.group({
      sportName: ['', Validators.required]
    });

    this.trainerIdForm = this.fb.group({
      trainerId: ['', Validators.required]
    });

    this.sessionIdForm = this.fb.group({
      sessionId: ['', Validators.required]
    });

    this.gateForm = this.fb.group({
      gate: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.loadSports();
    this.getOnlineUsersCount();
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

  getOnlineUsersCount() {
    this.securityService.getOnlineUsersCount().subscribe({
      next: (count) => {
        this.onlineUsersCount = count;
      },
      error: (error) => {
        this.message = 'Error getting online users count: ' + error.message;
      }
    });
  }

  onSubmitSport() {
    if (this.sportForm.valid) {
      const sport: Sport = {
        name: this.sportForm.value.name,
        description: this.sportForm.value.description
      };

      if (this.sportForm.value.id) {
        // Update existing sport
        sport.id = this.sportForm.value.id;
        this.sportService.updateSport(sport).subscribe({
          next: (response) => {
            this.message = 'Sport updated successfully';
            this.loadSports();
            this.sportForm.reset();
          },
          error: (error) => {
            this.message = 'Error updating sport: ' + error.message;
          }
        });
      } else {
        // Add new sport
        this.sportService.addSport(sport).subscribe({
          next: (response) => {
            this.message = 'Sport added successfully';
            this.loadSports();
            this.sportForm.reset();
          },
          error: (error) => {
            this.message = 'Error adding sport: ' + error.message;
          }
        });
      }
    }
  }

  editSport(sport: Sport) {
    this.sportForm.patchValue({
      id: sport.id,
      name: sport.name,
      description: sport.description
    });
  }

  deleteSport(id: string | undefined) {
    if(id != null)
    {
      this.sportService.deleteSport(id).subscribe({
        next: (response) => {
          this.message = 'Sport deleted successfully';
          this.loadSports();
        },
        error: (error) => {
          this.message = 'Error deleting sport: ' + error.message;
        }
      });
    }

  }

  getSessionsBySportName() {
    if (this.sportNameForm.valid) {
      const sportName = this.sportNameForm.value.sportName;
      this.sportService.getSessionsBySportName(sportName).subscribe({
        next: (sessions) => {
          this.sportSessions = sessions;
          this.message = `Found ${sessions.length} sessions for sport ${sportName}`;
        },
        error: (error) => {
          this.message = 'Error getting sessions: ' + error.message;
        }
      });
    }
  }

  getSessionsByTrainerId() {
    if (this.trainerIdForm.valid) {
      const trainerId = this.trainerIdForm.value.trainerId;
      this.sportService.getSessionsByTrainerId(trainerId).subscribe({
        next: (sessions) => {
          this.sportSessions = sessions;
          this.message = `Found ${sessions.length} sessions for trainer ${trainerId}`;
        },
        error: (error) => {
          this.message = 'Error getting sessions: ' + error.message;
        }
      });
    }
  }

  getSessionById() {
    if (this.sessionIdForm.valid) {
      const sessionId = this.sessionIdForm.value.sessionId;
      this.sportService.getSessionById(sessionId).subscribe({
        next: (session) => {
          this.selectedSession = session;
          this.message = `Found session with ID ${sessionId}`;
        },
        error: (error) => {
          this.message = 'Error getting session: ' + error.message;
        }
      });
    }
  }

  getActionsByGate() {
    if (this.gateForm.valid) {
      const gate = this.gateForm.value.gate;
      this.securityService.getActionsByGate(gate).subscribe({
        next: (actions) => {
          this.securityActions = actions;
          this.message = `Found ${actions.length} actions for gate ${gate}`;
        },
        error: (error) => {
          this.message = 'Error getting actions: ' + error.message;
        }
      });
    }
  }
}
