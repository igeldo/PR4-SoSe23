import {ChangeDetectionStrategy, Component, Input} from '@angular/core';
import {Auftrag} from "../../auftrag";

@Component({
  selector: 'app-show-auftrag',
  templateUrl: './show-auftrag.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class ShowAuftragComponent {
  @Input() auftrag: Auftrag;
}
