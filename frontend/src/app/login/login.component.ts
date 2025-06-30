import { Component } from '@angular/core';
import {ReactiveFormsModule,Validators } from '@angular/forms';
import {FormControl, FormGroup} from '@angular/forms';
import { RouterModule } from '@angular/router';
import {User} from '../User';
import {RegisterService} from '../register.service';

@Component({
  selector: 'app-login',
  imports: [ReactiveFormsModule,RouterModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
	currUser : User | undefined;
	constructor(private registerService: RegisterService) {
		
	}
	logformgroup = new FormGroup({		
		username: new FormControl<string|null>('',[Validators.required,Validators.maxLength(25),Validators.minLength(3)]),
		password: new FormControl<string|null>('',[Validators.required]),		
    });
	onLogin(): void {
		/* let m= new Map<string,string>();
		m.set("username",<string>this.logformgroup.value.username);
		m.set("password",<string>this.logformgroup.value.password); */
		var m = { "username": <string>this.logformgroup.value.username,"password":<string>this.logformgroup.value.password};
		
		this.registerService.login(m).subscribe
		(
			(u) =>
			{
				if(!u)
				{
					this.currUser = undefined;
				}
				else
				{
					this.currUser =
					{
						fname:u.fname,
						lname:u.lname,
						username:u.username,
						password:u.password,
						age:u.age,
						salary:u.salary,
						team:u.team,
						role:u.role
					}
					sessionStorage.setItem('fname',this.currUser.fname);
					sessionStorage.setItem('lname',this.currUser.lname);
					sessionStorage.setItem('username',this.currUser.username);
					sessionStorage.setItem('password',this.currUser.password);
					sessionStorage.setItem('age',this.currUser.age.toString());
					sessionStorage.setItem('salary',this.currUser.salary.toString());
					sessionStorage.setItem('team',this.currUser.team);
					sessionStorage.setItem('role',this.currUser.role);
					sessionStorage.setItem('flag','set');
					this.registerService.goToIndex();

				}
				
		
			}
		);
		
		
		
		this.logformgroup.reset();		
	}
}
