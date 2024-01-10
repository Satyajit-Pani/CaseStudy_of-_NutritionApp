import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FoodListServiceService {

  constructor(private _http : HttpClient) { }

    // params = new HttpParams();
    // params = params.append('query', 49000000450);


  public getProducts(query:String):Observable<any>{
   console.log(query);
    return this._http.get("http://localhost:9090/v1/nutrition/searchNutrient",{params:{query:'49000000450'}});
    // http://localhost:9090/v1/nutrition/searchNutrient?upc=49000000450
    
  }
}
