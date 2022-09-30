import { Component, OnInit, ViewChild } from '@angular/core';
import {MatDialog, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import {DialogComponent} from "../dialog/dialog.component";
import {ApiService} from "../services/api.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-medical-clinic',
  templateUrl: './medical-clinic.component.html',
  styleUrls: ['./medical-clinic.component.css']
})
export class MedicalClinicComponent implements OnInit {

  title = 'medClinicFront';

  displayedColumns: string[] = ['id', 'medicalClinicName', 'address', 'numberOfBeds', 'action'];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private dialog : MatDialog,
              private api : ApiService,
              private router : Router) {
  }

  ngOnInit(): void {
    this.getAllMedClinics();
  }

  openDialog() {
    this.dialog.open(DialogComponent, {
      width:'30%'
    }).afterClosed().subscribe(val=>{
      if (val==='save'){
        this.getAllMedClinics();
      }
    })
  }

  getAllMedClinics(){
    this.api.getMedicalClinic()
      .subscribe({
        next:(res)=>{
          // @ts-ignore
          this.dataSource = new MatTableDataSource(res);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
        },
        error:()=>{
          alert("No Medical Clinics Found")
        }
      })
  }

  editClinic(row : any){
    this.dialog.open(DialogComponent,{
      width: '30%',
      data: row
    }).afterClosed().subscribe(value => {
      if (value==='update'){
        this.getAllMedClinics();
      }
    })
  }

  deleteClinic(id :number){
    this.api.deleteMedClinic(id)
      .subscribe({
        next:(res)=>{
          this.getAllMedClinics();
        }
      })
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  routToHealthProvider(){
    this.router.navigate(['healthProvider'])
  }

}
