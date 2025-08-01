import { TestBed } from '@angular/core/testing';

import { Breif } from './breif';

describe('Breif', () => {
  let service: Breif;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Breif);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
