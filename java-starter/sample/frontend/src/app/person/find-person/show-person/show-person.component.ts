import {ChangeDetectionStrategy, Component, Input} from '@angular/core';
import {Person} from "../../person";

@Component({
  selector: 'app-show-person',
  templateUrl: './show-person.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class ShowPersonComponent {
  @Input() person: Person;
}
