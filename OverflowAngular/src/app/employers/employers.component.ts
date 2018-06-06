import { Component, OnInit } from '@angular/core';
import { EmployerService } from '../employer.service';
import { Employer } from '../models/employer';

@Component({
  selector: 'app-employers',
  templateUrl: './employers.component.html',
  styleUrls: ['./employers.component.css']
})
export class EmployersComponent implements OnInit {

  // CLASS FIELDS
  employers: Employer[] = [];
  employer: Employer = new Employer();
  selected = null;

  // CLASS METHODS
  reload = function() {
    this.employerService.index().subscribe(
      data => {
        this.employers = data;
        this.selected = null;
      },
      err => console.error(err)
    );
  };

  showOneEmployer = function(employerId: number) {
    this.employerService.show(employerId).subscribe(
      data => {
        this.employer = data;
        this.selected = this.employer;
      },
      err => console.error(err)
    );
  };

  return = function () {
    this.reload();
  };

  constructor(
    private employerService: EmployerService
  ) { }

  ngOnInit() {
    this.reload();
  }

}
