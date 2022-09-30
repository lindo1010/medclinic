import { Component, OnInit, Inject } from '@angular/core';
import {FormGroup, FormBuilder, Validators} from "@angular/forms";
import {ApiService} from "../services/api.service";
import {MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog'

@Component({
  selector: 'app-provider-dialog',
  templateUrl: './provider-dialog.component.html',
  styleUrls: ['./provider-dialog.component.css']
})
export class ProviderDialogComponent implements OnInit {

  healthProviderForm !: FormGroup;
  actionBtn : string = "Save"

  constructor(private formBuilder : FormBuilder,
              private api : ApiService,
              @Inject(MAT_DIALOG_DATA) public addedData : any,
              private dialogRef : MatDialogRef<ProviderDialogComponent>) { }

  ngOnInit(): void {
    this.healthProviderForm = this.formBuilder.group({
      healthProviderName: ['', Validators.required],
      clinicName: ['', Validators.required]
    })
    if (this.addedData) {
      this.actionBtn = "update"
      this.healthProviderForm.controls['clinicName'].setValue(this.addedData.clinicName);
      this.healthProviderForm.controls['healthProviderName'].setValue(this.addedData.healthProviderName);
    }
  }

  addHealthProvider(){
    if (!this.addedData){
      if (this.healthProviderForm.valid){
        this.api.addHealthProvider(this.healthProviderForm.value)
          .subscribe({
            next:(res)=>{
              console.log(this.healthProviderForm.value)
              this.healthProviderForm.reset();
              this.dialogRef.close('save');
            },
            error:()=>{
              alert("Error Adding Clinic");
            }
          })
      }
    }else {
      this.updateHealthProvider();
    }
  }

  updateHealthProvider(){
    this.api.updateHealthProvider(this.healthProviderForm.value,this.addedData.id)
      .subscribe({
        next:(res)=>{
          alert("Update Successful");
          this.healthProviderForm.reset();
          this.dialogRef.close('update')
        }
      })
  }
}
