import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CreatePersonComponent} from './create-person/create-person.component';
import {FindPersonComponent} from './find-person/find-person.component';
import {CreateAddressComponent} from "./create-address/create-address.component";
import {ShowPersonComponent} from './find-person/show-person/show-person.component';
import {FormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {AuthGuard} from "../auth/auth.guard";

@NgModule({
    declarations: [
        CreatePersonComponent,
        FindPersonComponent,
        CreateAddressComponent,
        ShowPersonComponent
    ],
    imports: [
        CommonModule,
        FormsModule,
        RouterModule.forChild([
            { path: 'create-person', component: CreatePersonComponent, canActivate: [AuthGuard] },
            { path: 'create-address', component: CreateAddressComponent, canActivate: [AuthGuard] },
            { path: 'find-person', component: FindPersonComponent, canActivate: [AuthGuard] },
        ])
    ]
})
export class PersonModule {
}
