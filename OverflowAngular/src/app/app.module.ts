import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { PostComponent } from './post/post.component';
import { NavigationComponent } from './navigation/navigation.component';
import { LoginComponent } from './login/login.component';
import { UserComponent } from './user/user.component';

@NgModule({
  declarations: [
    AppComponent,
    PostComponent,
    NavigationComponent,
    LoginComponent,
    UserComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
