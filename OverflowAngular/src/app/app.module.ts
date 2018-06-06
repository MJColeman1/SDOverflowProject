import { PostService } from './post.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { PostComponent } from './post/post.component';
import { NavigationComponent } from './navigation/navigation.component';
import { LoginComponent } from './login/login.component';
import { UserComponent } from './user/user.component';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RegisterComponent } from './register/register.component';
import { CategoryTypePipe } from './category-type.pipe';
import { LogoutComponent } from './logout/logout.component';
import { AboutComponent } from './about/about.component';
import { UserService } from './user.service';
import { OtherProfileComponent } from './other-profile/other-profile.component';
import { ProfileComponent } from './profile/profile.component';
import { OtherUserService } from './other-user.service';
import { SelectedPostService } from './selected-post.service';
import { EmployersComponent } from './employers/employers.component';

@NgModule({
  declarations: [
    AppComponent,
    PostComponent,
    NavigationComponent,
    LoginComponent,
    UserComponent,
    RegisterComponent,
    CategoryTypePipe,
    LogoutComponent,
    AboutComponent,
    OtherProfileComponent,
    ProfileComponent,
    EmployersComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    PostService,
    UserService,
    OtherUserService,
    SelectedPostService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
