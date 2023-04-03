import { Component } from '@angular/core';
import {tap} from "rxjs";
import {Auftrag} from "../auftrag";
import {AuftragService} from "../auftrag.service";

@Component({
  selector: 'met-create-person',
  templateUrl: './create-auftrag.component.html',
  styleUrls: ['./create-auftrag.component.css']
})
export class CreateAuftragComponent {

  created: boolean = false;

  auftrag: Auftrag = new Auftrag();

  constructor(private auftraege: AuftragService) { }

  onSubmit() {
    this.auftraege.createAuftrag(this.auftrag)
      .pipe(tap(() => {
        this.created = true;
        this.auftrag = new Auftrag();
      })).subscribe();
  }
}
