import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {tap} from "rxjs";
import {Person} from "../person";
import {PersonService} from "../person.service";

@Component({
  selector: 'met-create-person',
  templateUrl: './create-person.component.html',
  styleUrls: ['./create-person.component.css']
})
export class CreatePersonComponent {

  created: boolean = false;
  person: Person = new Person();

  constructor(private persons: PersonService) { }

  onSubmit() {
    this.persons.createPerson(this.person)
      .pipe(tap(() => {
        this.created = true;
        this.person = new Person();
      })).subscribe();
  }
}
