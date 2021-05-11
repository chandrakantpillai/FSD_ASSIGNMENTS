import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {
  employee: Employee = new Employee();
  registerForm: FormGroup;
  submitted = false;

  constructor(private employeeService: EmployeeService,
    private router: Router,
    private fb: FormBuilder
                    ) { }

  ngOnInit(): void {
    this.registerForm = this.fb.group({
      firstName: ['', [Validators.required, Validators.minLength(4)]],
      lastName: ['', [Validators.required,Validators.minLength(4)]],
      emailId: ['', [Validators.required,Validators.email]]
  })
  }
  get registerFormControl() {
    return this.registerForm.controls;
  }

  saveEmployee(){
    this.employeeService.createEmployee(this.employee).subscribe( data =>{
      console.log(data);
      this.goToEmployeeList();
    },
    error => console.log(error));
  }

  goToEmployeeList(){
    this.router.navigate(['/employees']);
  }
  
  onSubmit(){
    this.submitted = true;
    if (this.registerForm.valid) {
      alert('Information Submitted succesfully!!!\n Check the  Employee list.');
      console.table(this.registerForm.value);  
  }
  console.log(this.employee);
    this.saveEmployee();

}
}
