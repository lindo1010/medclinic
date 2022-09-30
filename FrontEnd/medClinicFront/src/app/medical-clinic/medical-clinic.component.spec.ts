import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicalClinicComponent } from './medical-clinic.component';

describe('MedicalClinicComponent', () => {
  let component: MedicalClinicComponent;
  let fixture: ComponentFixture<MedicalClinicComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MedicalClinicComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MedicalClinicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
