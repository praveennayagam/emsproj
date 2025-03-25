import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, retry, throwError } from 'rxjs';
import { Employee } from 'src/Employee';

@Injectable({
  providedIn: 'root'
})
export class EmpService {

  // employees = [{
  //   eid: 111,
  //   ename:"Praveen",
  //   email:"praveennayagam03@gmail.com",
  //   password:"pass",
  //   gender:"Male",
  //   isMarried:true,

  // },
  // {
  //   eid: 123,
  //   ename:"rithik",
  //   email:"rithik@gmail.com",
  //   password:"pass",
  //   gender:"Male",
  //   isMarried:true,

  // },
  // ];
  employees =[];
  apiUrl :string='http://localhost:8067/demosprboot/api/semployee';
  httpOptions ={
    headers:new Headers({
      'Content-Type':'application/json',
    }),
  };
  constructor(private http : HttpClient) { }
  getAllEmployees():Observable<any>{
    return this.http.get<any>(this.apiUrl + '/listallemp').pipe(retry(1), catchError(this.handleError));
  }
  
createEmployee(employee:Employee):Observable<Employee>{
  return this.http.post<Employee>(this.apiUrl  + '/addemp', employee).pipe(retry(1), catchError(this.handleError));
}

deleteEmployee(id:number):Observable<Employee>{
  return this.http.delete<Employee>
  (`${this.apiUrl}/deletebyid/${id}`).pipe(retry(1), catchError(this.handleError));
}
getEmployeeById(id: number): Observable<Employee> {
  return this.http.get<any>(`${this.apiUrl}/getempbyid/${id}`) .pipe(retry(1), catchError(this.handleError));
}
updateEmployee(employee: Employee): Observable<Employee> {
  return this.http.put<Employee>(this.apiUrl + '/updateemp', employee) .pipe(retry(1), catchError(this.handleError));
}
 
handleError(error: any) {
  let errorMessage = '';
  if (error.error instanceof ErrorEvent) {
    errorMessage = error.error.message;
  } else {
    errorMessage = `Error Code : ${error.status} \n Error Message : ${error.message} `;
  }

window.alert(errorMessage);
    return throwError(errorMessage);
  }
}

