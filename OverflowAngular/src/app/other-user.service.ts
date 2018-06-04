import { Injectable } from '@angular/core';
import { User } from './models/user';

@Injectable({
  providedIn: 'root'
})
export class OtherUserService {

  private otherUser = new User();

  otherUserInfo (userInfo) {
    this.otherUser = userInfo;
  }

  constructor() { }
}
