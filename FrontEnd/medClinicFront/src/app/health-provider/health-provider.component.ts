import { Component, OnInit, ViewChild } from '@angular/core';
import {MatDialog, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import {ApiService} from "../services/api.service";
import {Router} from "@angular/router";
import {ProviderDialogComponent} from "../provider-dialog/provider-dialog.component";

@Component({
  selector: 'app-health-provider',
  templateUrl: './health-provider.component.html',
  styleUrls: ['./health-provider.component.css']
})
export class HealthProviderComponent implements OnInit {

  displayedColumns: string[] = ['healthProviderId', 'healthProviderName', 'clinicName', 'action'];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private dialog : MatDialog,
              private api : ApiService,
              private router : Router) {
  }


  ngOnInit(): void {
    this.getAllHealthProviders();
  }

  openDialog() {
    this.dialog.open(ProviderDialogComponent, {
      width:'30%'
    }).afterClosed().subscribe(val=>{
      if (val==='save'){
        this.getAllHealthProviders();
      }
    })
  }

  getAllHealthProviders(){
    this.api.getHealthProvider()
      .subscribe({
        next:(res)=>{
          // @ts-ignore
          this.dataSource = new MatTableDataSource(res);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
        },
        error:()=>{
          alert("No Health Providers Found")
        }
      })
  }

  editHealthProvider(row : any){
    this.dialog.open(ProviderDialogComponent,{
      width: '30%',
      data: row
    }).afterClosed().subscribe(value => {
      if (value==='update'){
        this.getAllHealthProviders();
      }
    })
  }

  deleteHealthProvider(id :number){
    this.api.deleteHealthProvider(id)
      .subscribe({
        next:(res)=>{
          this.getAllHealthProviders();
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

  routToMedicalClinic(){
    this.router.navigate(['home'])
  }

}
