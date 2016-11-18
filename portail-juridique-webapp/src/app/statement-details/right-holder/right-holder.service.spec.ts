/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { RightHolderService } from './right-holder.service';

describe('Service: RightHolder', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RightHolderService]
    });
  });

  it('should ', inject([RightHolderService], (service: RightHolderService) => {
    expect(service).toBeTruthy();
  }));
});
