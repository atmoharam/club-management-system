import { Component } from "@angular/core"
import { type FormBuilder, type FormGroup, Validators } from "@angular/forms"
import type { UserService } from "../../services/user.service"
import type { User, CheckAction } from "../../models/user.model"

@Component({
  selector: "app-user-operations",
  templateUrl: "./user-operations.component.html",
  styleUrls: ["./user-operations.component.css"],
})
export class UserOperationsComponent {
  registerForm: FormGroup
  checkActionForm: FormGroup
  loginForm: FormGroup

  user: User | null = null
  actionResponse = ""
  loginMethod: "id" | "email" = "id"

  constructor(
    private fb: FormBuilder,
    private userService: UserService,
  ) {
    this.registerForm = this.fb.group({
      name: ["", Validators.required],
      email: ["", [Validators.required, Validators.email]],
      countryCode: ["+20", Validators.required],
      number: ["", Validators.required],
      dateOfBirth: ["", Validators.required],
      street: ["", Validators.required],
      city: ["", Validators.required],
      zip: ["", Validators.required],
    })

    this.checkActionForm = this.fb.group({
      id: ["", Validators.required],
      gate: ["", Validators.required],
      action: ["check_in", Validators.required],
    })

    this.loginForm = this.fb.group({
      loginValue: ["", Validators.required],
    })
  }

  onRegister() {
    if (this.registerForm.valid) {
      const formValue = this.registerForm.value

      const user: User = {
        name: formValue.name,
        email: formValue.email,
        phone: {
          countryCode: formValue.countryCode,
          number: formValue.number,
        },
        dateOfBirth: formValue.dateOfBirth,
        address: {
          street: formValue.street,
          city: formValue.city,
          zip: formValue.zip,
        },
      }

      this.userService.createUser(user).subscribe({
        next: (response) => {
          this.actionResponse = response
          this.registerForm.reset()
        },
        error: (error) => {
          this.actionResponse = "Error: " + error.message
        },
      })
    }
  }

  onCheckAction() {
    if (this.checkActionForm.valid) {
      const action: CheckAction = {
        id: this.checkActionForm.value.id,
        gate: this.checkActionForm.value.gate,
      }

      if (this.checkActionForm.value.action === "check_in") {
        this.userService.checkIn(action).subscribe({
          next: (response) => {
            this.actionResponse = response.message
          },
          error: (error) => {
            this.actionResponse = "Error: " + error.message
          },
        })
      } else {
        this.userService.checkOut(action).subscribe({
          next: (response) => {
            this.actionResponse = response.message
          },
          error: (error) => {
            this.actionResponse = "Error: " + error.message
          },
        })
      }
    }
  }

  onLogin() {
    if (this.loginForm.valid) {
      const loginValue = this.loginForm.value.loginValue

      if (this.loginMethod === "id") {
        this.userService.getUserById(loginValue).subscribe({
          next: (user) => {
            this.user = user
            this.actionResponse = "Login successful"
          },
          error: (error) => {
            this.actionResponse = "Error: " + error.message
          },
        })
      } else {
        this.userService.getUserByEmail(loginValue).subscribe({
          next: (user) => {
            this.user = user
            this.actionResponse = "Login successful"
          },
          error: (error) => {
            this.actionResponse = "Error: " + error.message
          },
        })
      }
    }
  }

  setLoginMethod(method: "id" | "email") {
    this.loginMethod = method
  }
}

