import {Component} from '@angular/core';
import {PersonService} from "../person.service";
import {catchError, tap, throwError} from "rxjs";
import {Person} from "../person";

@Component({
  selector: 'met-find-person',
  templateUrl: './find-person.component.html'
})
export class FindPersonComponent {

  searchText: number;
  error = false;
  person: Person;

  constructor(private persons: PersonService) {
  }

  onSubmit() {
    this.persons.findPerson(this.searchText).pipe(
        tap(person => this.person = person),
        catchError(( err ) => {
          this.error = true;
          return throwError(err);
        })
    ).subscribe();
  }
}
