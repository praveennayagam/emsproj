import { Component } from '@angular/core';
import { Router } from '@angular/router';
import {AuthService} from '../auth.service'
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  loginForm:FormGroup;

  // user = { username: '', password: '' };

  constructor(
    private fb:FormBuilder,
    private authService: AuthService,
    private router: Router
  ) {
    this.loginForm=this.fb.group({
      username: [
        '',
        [
          Validators.required,
          Validators.minLength(3),
          Validators.pattern(/^[a-zA-Z0-9]+$/),
        
        ],
      ],
        password:[
          '',[

            
          Validators.required,
          Validators.minLength(6),
          Validators.pattern(/[A-Z]/), // At least one uppercase
          Validators.pattern(/[0-9]/), // At least one number
          Validators.pattern(/[!@#$%^&*(),.?":{}|<>]/), // At least one special character
        ],
      ],
      });
  }

  get f() {
    return this.loginForm.controls;
  }

  // Helper methods for validation
  hasUpperCase(): boolean {
    return /[A-Z]/.test(this.f['password'].value);
  }

  hasNumber(): boolean {
    return /[0-9]/.test(this.f['password'].value);
  }

  hasSpecialCharacter(): boolean {
    return /[!@#$%^&*(),.?":{}|<>]/.test(this.f['password'].value);
  }

  login() {
    if (this.loginForm.invalid) {
      return;
    }

    this.authService.login(this.loginForm.value).subscribe(
      (response: any) => {
        console.log(response);
        localStorage.setItem('userToken', response);
        alert('Login Successful!');
        this.router.navigate(['/emplist']);
      },
      () => alert('Invalid Credentials')
    );
  }


  // login() {
  //   this.authService.login(this.user).subscribe(
  //     (response: any) => {
  //       console.log(response);
  //       localStorage.setItem('userToken', response);
  //       alert('Login Successful!');
  //       this.router.navigate(['/emplist']);
  //     },
  //     () => alert('Invalid Credentials')
  //   );
  // }

}