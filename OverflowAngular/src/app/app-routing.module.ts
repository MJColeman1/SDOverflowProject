import { RegisterComponent } from './register/register.component';
import { PostComponent } from './post/post.component';
import { NavigationComponent } from './navigation/navigation.component';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserComponent } from './user/user.component';
import { AboutComponent } from './about/about.component';
import { ProfileComponent } from './profile/profile.component';

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'posts'},
  {path: 'about', component: AboutComponent},
  {path: 'login', component: LoginComponent},
  {path: 'posts', component: PostComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'user', component: UserComponent},
  {path: 'profile', component: ProfileComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
