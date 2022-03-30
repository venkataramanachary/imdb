import { TestBed } from '@angular/core/testing';

import { FilmratingService } from './filmrating.service';

describe('FilmratingService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FilmratingService = TestBed.get(FilmratingService);
    expect(service).toBeTruthy();
  });
});
 