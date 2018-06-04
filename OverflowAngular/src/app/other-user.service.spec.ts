import { TestBed, inject } from '@angular/core/testing';

import { OtherUserService } from './other-user.service';

describe('OtherUserService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [OtherUserService]
    });
  });

  it('should be created', inject([OtherUserService], (service: OtherUserService) => {
    expect(service).toBeTruthy();
  }));
});
