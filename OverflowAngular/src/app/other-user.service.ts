import { Injectable } from '@angular/core';
import { User } from './models/user';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OtherUserService {

  private user = new User();
  private otherUser = new BehaviorSubject<User>(this.user);
  cast = this.otherUser.asObservable();

  getOtherUserInfo(otherUserInfo) {
    this.otherUser.next(otherUserInfo);
  }

  constructor() { }
}
