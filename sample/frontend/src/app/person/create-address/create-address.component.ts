import {Component} from '@angular/core';
import {tap} from "rxjs";
import {Address} from "../person";
import {PersonService} from "../person.service";

@Component({
    selector: 'met-create-person',
    templateUrl: './create-address.component.html',
    styleUrls: ['./create-address.component.css']
})
export class CreateAddressComponent {

    created: boolean = false;
    personId: number | undefined;
    address: Address = new Address();

    constructor(private persons: PersonService) {
    }

    onSubmit() {
        this.persons.createAddressForPerson(this.personId, this.address)
            .pipe(tap(() => {
                this.created = true;
                this.address = new Address();
                this.personId = undefined;
            })).subscribe();
    }
}
