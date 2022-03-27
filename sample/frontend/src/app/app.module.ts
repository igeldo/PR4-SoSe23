import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {PageLayoutComponent} from './page-layout/page-layout.component';
import {FormsModule} from "@angular/forms";
import {PersonModule} from "./person/person.module";
import {AuftragModule} from "./auftrag/auftrag.module";
import {AuthModule} from "./auth/auth.module";
import {RouterModule} from "@angular/router";

@NgModule({
    declarations: [
        AppComponent,
        PageLayoutComponent
    ],
    imports: [
        RouterModule.forRoot([]),
        BrowserModule,
        FormsModule,
        HttpClientModule,
        PersonModule,
        AuftragModule,
        AuthModule
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
