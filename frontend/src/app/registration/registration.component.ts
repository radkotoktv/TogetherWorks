import { Component } from '@angular/core';
import {ReactiveFormsModule,Validators } from '@angular/forms';
import {FormControl, FormGroup} from '@angular/forms';
import { RouterModule } from '@angular/router';
import {User} from '../User';
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
		fname: new FormControl<string|null>('',[Validators.required,Validators.maxLength(40)]),
		lname: new FormControl<string|null>('',[Validators.required,Validators.maxLength(40)]),
		username: new FormControl<string|null>('',[Validators.required,Validators.maxLength(25),Validators.minLength(3)]),
		password: new FormControl<string|null>('',[Validators.required]),
		age: new FormControl<number|null>(14,[Validators.required,Validators.min(14)]),
		salary: new FormControl<number|null>(2000,[Validators.required,Validators.min(2000),Validators.max(10000)]),
});
    onSubmit(): void {
		
		let user: User = {
			fname: <string>this.regformgroup.value.fname,
            lname: <string>this.regformgroup.value.lname,
            username: <string>this.regformgroup.value.username,
            password: <string>this.regformgroup.value.password,
            age: <number>this.regformgroup.value.age,
            salary: <number>this.regformgroup.value.salary,
            team: "none",
			role: "player",
		};
		
		this.registerService.register(user).subscribe(u => this.registerService.goToLogin());
		
    }
}
