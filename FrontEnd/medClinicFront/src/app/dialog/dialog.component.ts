import {Component, Inject, OnInit} from '@angular/core';
import {FormGroup, FormBuilder, Validators} from "@angular/forms";
import {ApiService} from "../services/api.service";
import {MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog'

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.css']
})
export class DialogComponent implements OnInit {

  medicalForm !: FormGroup;
  actionBtn : string = "Save"

  constructor(private formBuilder : FormBuilder,
              private api : ApiService,
              @Inject(MAT_DIALOG_DATA) public editData : any,
              private dialogRef : MatDialogRef<DialogComponent>) { }

  ngOnInit(): void {
    this.medicalForm = this.formBuilder.group({
      medicalClinicName : ['',Validators.required],
      numberOfBeds : ['',Validators.required],
      address : ['',Validators.required]
    })
    if (this.editData){
      this.actionBtn = "Update"
      this.medicalForm.controls['medicalClinicName'].setValue(this.editData.medicalClinicName);
      this.medicalForm.controls['numberOfBeds'].setValue(this.editData.numberOfBeds);
      this.medicalForm.controls['address'].setValue(this.editData.address);
    }
  }

  addMediclinic(){
    if (!this.editData){
      if (this.medicalForm.valid){
        this.api.addMedicalClinic(this.medicalForm.value)
          .subscribe({
            next:(res)=>{
              console.log(this.medicalForm.value)
              this.medicalForm.reset();
              this.dialogRef.close('save');
            },
            error:()=>{
              alert("Error Adding Clinic");
            }
          })
      }
    }else {
      this.updateMedClinic();
    }
  }

  updateMedClinic(){
    this.api.updateMedClinic(this.medicalForm.value,this.editData.id)
      .subscribe({
        next:(res)=>{
          alert("Update Successful");
          this.medicalForm.reset();
          this.dialogRef.close('update')
        }
      })
  }
}
