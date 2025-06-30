import { Routes } from '@angular/router';
import {LoginComponent} from './login/login.component';
import {RegistrationComponent} from './registration/registration.component';
import {ErrorPageComponent} from './error-page/error-page.component';

export const routes: Routes = [
	{path: 'login', component: LoginComponent},
	{path: 'error', component: ErrorPageComponent},
	{path: 'registration', component: RegistrationComponent},
];
