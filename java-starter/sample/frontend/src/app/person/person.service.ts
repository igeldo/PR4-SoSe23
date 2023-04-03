import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Address, Person} from "./person";

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  constructor(private http: HttpClient) {
  }

  findPerson(searchText: number): Observable<Person> {
    return this.http.get<Person>(`/api/shop/person/${searchText}`);
  }

  createPerson(person: Person): Observable<Person> {
    return this.http.post<Person>('/api/shop/person', person);
  }

  createAddressForPerson(personId: number | undefined, address: Address): Observable<Address> {
    return this.http.post<Address>(`/api/shop/person/${personId}/address`, address);
  }
}
