import { Routes } from '@angular/router';
import {RegisterComponent} from './register/register.component';
import { BriefListComponent } from './components/brief-list/brief-list';

export const routes: Routes = [
  {path: "", component : RegisterComponent},
  {path: "brief", component: BriefListComponent}
];
