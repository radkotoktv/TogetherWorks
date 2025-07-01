import { Component } from '@angular/core';
import {ReactiveFormsModule,Validators } from '@angular/forms';
import {FormControl, FormGroup} from '@angular/forms';
import { RouterModule } from '@angular/router';
import {Volunteer} from '../Volunteer';
import {RegisterService} from '../register.service';

@Component({
  selector: 'app-registration',
  imports: [ReactiveFormsModule,RouterModule],
  templateUrl: './registration.component.html',
  styleUrl: './registration.component.css'
})
export class RegistrationComponent {
	constructor(private registerService: RegisterService) {
		
	}
	regformgroup = new FormGroup({
		first_name: new FormControl<string|null>('',[Validators.required,Validators.maxLength(40)]),
		last_name: new FormControl<string|null>('',[Validators.required,Validators.maxLength(40)]),
		gender: new FormControl<string|null>('',[Validators.required,Validators.maxLength(25),Validators.minLength(3)]),
		email: new FormControl<string|null>('',[Validators.required]),
		username: new FormControl<string|null>('',[Validators.required,Validators.min(14)]),
		preference: new FormControl<string|null>('',[Validators.required,Validators.min(2000),Validators.max(10000)]),
});
    onSubmit(): void {
		
		let Volunteer: Volunteer = {
			first_name: <string>this.regformgroup.value.first_name,
            last_name: <string>this.regformgroup.value.last_name,
            gender: <string>this.regformgroup.value.gender,
            email: <string>this.regformgroup.value.email,
            username: <string>this.regformgroup.value.username,
            preference: <string>this.regformgroup.value.preference,
            project_name:"none",
		};
		
		this.registerService.register(Volunteer).subscribe(u => this.registerService.goToLogin());
		
    }
}
