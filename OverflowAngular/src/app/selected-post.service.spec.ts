import { TestBed, inject } from '@angular/core/testing';

import { SelectedPostService } from './selected-post.service';

describe('SelectedPostService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SelectedPostService]
    });
  });

  it('should be created', inject([SelectedPostService], (service: SelectedPostService) => {
    expect(service).toBeTruthy();
  }));
});
