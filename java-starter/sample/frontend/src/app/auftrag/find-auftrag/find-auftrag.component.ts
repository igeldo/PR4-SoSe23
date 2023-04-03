import {Component} from '@angular/core';
import {catchError, tap} from "rxjs";
import {Auftrag} from "../auftrag";
import {AuftragService} from "../auftrag.service";

@Component({
  selector: 'met-find-auftrag',
  templateUrl: './find-auftrag.component.html',
  styleUrls: ['./find-auftrag.component.css']
})
export class FindAuftragComponent {

  auftragId: number;
  error = false;
  auftrag: Auftrag;

  constructor(private auftraege: AuftragService) {
  }

  onSubmit() {
    this.auftraege.findAuftrag(this.auftragId)
      .pipe(
        tap((result: any) => {
          this.auftrag = result;
          this.error = false;
        }),
        catchError(err => {
          this.error = true;
          return err;
        })
      )
      .subscribe();
  }
}
