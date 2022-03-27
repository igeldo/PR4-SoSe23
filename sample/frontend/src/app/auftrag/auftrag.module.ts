import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CreateAuftragComponent} from "./create-auftrag/create-auftrag.component";
import {FindAuftragComponent} from "./find-auftrag/find-auftrag.component";
import {ShowAuftragComponent} from './find-auftrag/show-auftrag/show-auftrag.component';
import {FormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {AuthGuard} from "../auth/auth.guard";
import {FindPersonComponent} from "../person/find-person/find-person.component";
import {HttpClientModule} from "@angular/common/http";
import {AuthModule} from "../auth/auth.module";

@NgModule({
    declarations: [
        CreateAuftragComponent,
        FindAuftragComponent,
        ShowAuftragComponent
    ],
    imports: [
        CommonModule,
        FormsModule,
        HttpClientModule,
        AuthModule,
        RouterModule.forChild([
            { path: 'create-auftrag', component: CreateAuftragComponent, canActivate: [AuthGuard] },
            { path: 'find-person', component: FindPersonComponent, canActivate: [AuthGuard] },
            { path: 'find-auftrag', component: FindAuftragComponent, canActivate: [AuthGuard] }
        ])
    ]
})
export class AuftragModule {
}
