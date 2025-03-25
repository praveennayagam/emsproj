import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'emsproj';
employees:any=[];

constructor(private router: Router) {}

isAuthenticated(): boolean {
  return !!localStorage.getItem('userToken'); // Check if JWT exists
}

logout() {
  localStorage.removeItem('userToken'); // Remove JWT
  this.router.navigate(['/login']); // Redirect to home page
}
  
}
