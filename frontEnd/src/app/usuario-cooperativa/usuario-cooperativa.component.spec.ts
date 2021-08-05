import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsuarioCooperativaComponent } from './usuario-cooperativa.component';

describe('UsuarioCooperativaComponent', () => {
  let component: UsuarioCooperativaComponent;
  let fixture: ComponentFixture<UsuarioCooperativaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UsuarioCooperativaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UsuarioCooperativaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
