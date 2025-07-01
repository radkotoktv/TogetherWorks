import { Component, Inject, PLATFORM_ID } from '@angular/core';
import {ReactiveFormsModule,Validators } from '@angular/forms';
import {FormControl, FormGroup} from '@angular/forms';
import { RouterModule } from '@angular/router';
import {Volunteer} from '../Volunteer';
import {RegisterService} from '../register.service';
import { isPlatformBrowser } from '@angular/common';

@Component({
  selector: 'app-login',
  standalone: true, 
  imports: [ReactiveFormsModule, RouterModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
    currVolunteer : Volunteer | undefined;
    
    constructor(
      private registerService: RegisterService,
      @Inject(PLATFORM_ID) private platformId: Object
    ) {}

    logformgroup = new FormGroup({       
        username: new FormControl<string|null>('',[Validators.required,Validators.maxLength(25),Validators.minLength(3)]),
        password: new FormControl<string|null>('',[Validators.required])
    });

    onLogin(): void {
        var m = { "username": <string>this.logformgroup.value.username,"password":<string>this.logformgroup.value.password};
        
        this.registerService.login(m).subscribe(
            (u) => {
                if(!u) {
                    this.currVolunteer = undefined;
                } else {
                    this.currVolunteer = {
                        first_name:u.first_name,
                        last_name:u.last_name,
                        gender:u.gender,
                        email:u.email,
                        username:u.username,
                        preference:u.preference,
                        project_name:u.project_name,
                        password:"temp",
                    };

                    if (isPlatformBrowser(this.platformId)) {
                      sessionStorage.setItem('first_name',this.currVolunteer.first_name);
                      sessionStorage.setItem('last_name',this.currVolunteer.last_name);
                      sessionStorage.setItem('password',this.currVolunteer.password);
                      sessionStorage.setItem('username',this.currVolunteer.username.toString());
                      sessionStorage.setItem('preference',this.currVolunteer.preference.toString());
                      sessionStorage.setItem('project_name',this.currVolunteer.project_name);
                      sessionStorage.setItem('flag','set');
                      this.registerService.goToIndex();
                    }
                }
            }
        );
        this.logformgroup.reset();      
    }
}