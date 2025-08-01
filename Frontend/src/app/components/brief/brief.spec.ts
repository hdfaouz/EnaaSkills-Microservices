import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Brief } from './brief';

describe('Brief', () => {
  let component: Brief;
  let fixture: ComponentFixture<Brief>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Brief]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Brief);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
