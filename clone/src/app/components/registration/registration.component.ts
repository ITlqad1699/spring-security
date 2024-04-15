import { Component, OnInit } from '@angular/core';
import { Register } from 'src/app/model/register.model';
import { NgForm } from '@angular/forms';
import { getCookie } from 'typescript-cookie';
import { DashboardService } from 'src/app/services/dashboard/dashboard.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  model = new Register();

  constructor(private dashboardService: DashboardService, private router: Router) {

  }

  ngOnInit() {}

  saveMessage(contactForm: NgForm) {
    this.dashboardService.regisUser(this.model).subscribe(
      responseData => {
        this.model = <any> responseData.body;
        contactForm.resetForm();
        this.router.navigate(['/login']);
      });
      
  }
}
