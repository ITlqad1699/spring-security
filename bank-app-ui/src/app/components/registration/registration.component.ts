import { RegisterService } from './../../services/register/register.service';
import { Component, OnInit } from '@angular/core';
import { Register } from 'src/app/model/register.model';
import { NgForm } from '@angular/forms';
import { getCookie } from 'typescript-cookie';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  model = new Register();

  constructor(private registerService: RegisterService, private router: Router) {

  }

  ngOnInit() {}

  regisUser(regisForm: NgForm) {
    this.registerService.regisUser(this.model).subscribe(
      responseData => {
        this.model = <any> responseData.body;
        regisForm.resetForm();
        this.router.navigate(['/login']);
      });

  }
}
