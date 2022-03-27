import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Auftrag} from "./auftrag";

@Injectable({
    providedIn: 'root'
})
export class AuftragService {

    constructor(private http: HttpClient) {
    }

    findAuftrag(auftragId: number): Observable<Auftrag> {
        return this.http.get<Auftrag>(`/api/shop/auftrag/${auftragId}`);
    }

    createAuftrag(auftrag: Auftrag): Observable<Auftrag> {
        return this.http.post<Auftrag>(`/api/shop/auftrag`, auftrag);
    }
}
