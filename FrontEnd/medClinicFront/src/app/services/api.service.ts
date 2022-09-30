import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http : HttpClient) { }

  addMedicalClinic(data : any){
    return this.http.post<any>("http://localhost:9011/medicalclinic/add/",data)
  }

  getMedicalClinic(){
    return this.http.get("http://localhost:9011/medicalclinic/listAll")
  }

  updateMedClinic(data : any, id : number){
    return this.http.put<any>("http://localhost:9011/medicalclinic/update/"+id, data);
  }

  deleteMedClinic(id : number){
    return this.http.delete<any>("http://localhost:9011/medicalclinic/delete/"+id);
  }

  addHealthProvider(data : any){
    return this.http.post<any>("http://localhost:9011/healthprovider/add/",data)
  }

  getHealthProvider(){
    return this.http.get("http://localhost:9011/healthprovider/listAll")
  }

  updateHealthProvider(data : any, id : number){
    return this.http.put<any>("http://localhost:9011/healthprovider/update/"+id, data);
  }

  deleteHealthProvider(id : number){
    return this.http.delete<any>("http://localhost:9011/healthprovider/delete/"+id);
  }
}
