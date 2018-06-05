import { Profile } from './models/profile';
import { Injectable } from '@angular/core';
import { User } from './models/user';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OtherUserService {

  private userProfile = new Profile();
  private otherUser = new BehaviorSubject<Profile>(this.userProfile);
  cast = this.otherUser.asObservable();

  getOtherUserInfo(otherUserInfo) {
    this.otherUser.next(otherUserInfo);
  }

  constructor() { }
}
