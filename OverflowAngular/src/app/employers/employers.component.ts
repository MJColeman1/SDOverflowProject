import { Component, OnInit } from '@angular/core';
import { EmployerService } from '../employer.service';
import { Employer } from '../models/employer';
import { forEach } from '@angular/router/src/utils/collection';

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
  cityCount = 0;

  // LOADS ALL EMPLOYERS
  reload = function() {
    this.employerService.index().subscribe(
      data => {
        this.employers = data;
        this.selected = null;
        this.employersInCityCounter();
      },
      err => console.error(err)
    );
  };

  // SHOWS ONE SPECIFIC EMPLOYER
  showOneEmployer = function(employerId: number) {
    this.employerService.show(employerId).subscribe(
      data => {
        this.employer = data;
        this.selected = this.employer;
      },
      err => console.error(err)
    );
  };

  // GOES BACK TO ALL EMPLOYERS PAGE
  return = function () {
    this.reload();
  };

  // COUNTS EMPLOYERS IN CITY
  employersInCityCounter = function (city) {
   for (let i = 0; i < this.employers.length; i++) {
     if (this.employers[i].address.city === city ) {
       this.cityCount++;
     }
     this.cityCount = this.employers[i];

   }
  };

  constructor(
    private employerService: EmployerService
  ) { }

  ngOnInit() {
    this.reload();
  }

}
