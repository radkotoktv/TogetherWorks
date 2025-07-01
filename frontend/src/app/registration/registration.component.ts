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
		username: new FormControl<string|null>('',[Validators.required,Validators.min(14)]),
		password: new FormControl<string|null>('', [Validators.required, Validators.minLength(8)]),
		age: new FormControl<string|null>(null, [Validators.required, Validators.min(18)]),
		salary: new FormControl<number|null>(null, [Validators.required, Validators.min(0)]),
		email: new FormControl<string|null>('',[Validators.required]),
});
    onSubmit(): void {
		
		let Volunteer: Volunteer = {
			first_name: <string>this.regformgroup.value.first_name,
            last_name: <string>this.regformgroup.value.last_name,
            gender: <string>this.regformgroup.value.gender,
            email: <string>this.regformgroup.value.email,
            username: <string>this.regformgroup.value.username,
            preference: "none",
            project_name:"none",
			password: "temp",
		};
		
		this.registerService.register(Volunteer).subscribe(u => this.registerService.goToLogin());
		
    }
}
