import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UuarioCooperativaComponent } from './uuario-cooperativa.component';

describe('UuarioCooperativaComponent', () => {
  let component: UuarioCooperativaComponent;
  let fixture: ComponentFixture<UuarioCooperativaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UuarioCooperativaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UuarioCooperativaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
