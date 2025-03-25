import { Component } from '@angular/core';
import { EmpService } from '../emp.service';

@Component({
  selector: 'app-empnamelist',
  templateUrl: './empnamelist.component.html',
  styleUrls: ['./empnamelist.component.css']
})
export class EmpnamelistComponent {
  title = 'emsproj';
  employees:any=[];
  constructor (private empservice:EmpService ) {}
  
  ngOnInit(){
    this.employees=this.empservice.getAllEmployees().subscribe((emp) => (this.employees=emp));
    console.log(this.employees);
  }
    
}
