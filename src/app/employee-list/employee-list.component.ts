import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { CommonModule } from '@angular/common'; // Import CommonModule

@Component({
  standalone:true,
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css'],
  imports: [CommonModule]
})
export class EmployeeListComponent implements OnInit {
    employees: Employee[] = [];

  constructor(private employeeService: EmployeeService){}

  ngOnInit():void{
    this.getEmployees();
    }

    getEmployees(): void {
      this.employeeService.getEmployeeList()
        .subscribe(data => this.employees = data);
    }

    }




