import {Component} from '@angular/core';
import {Observable, tap} from "rxjs";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Router} from "@angular/router";
import {AuthService} from "../auth.service";

@Component({
    selector: 'met-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent {

    constructor(private http: HttpClient, private router: Router, private authService: AuthService) {
    }

    userCredentials = {
        username: 'java-starter-user',
        password: 'passKeycloakUser'
    };

    onSubmit() {
        this.login(this.userCredentials.username, this.userCredentials.password).subscribe();
    }

    login(username: string, password: string): Observable<any> {
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/x-www-form-urlencoded'
            })
        };

        const params = new HttpParams({
            fromObject: {
                grant_type: 'password',
                client_id: 'java-starter-client',
                username: username,
                password: password
            }
        });

        return this.http.post('/auth/realms/java-starter-realm/protocol/openid-connect/token', params, httpOptions)
            .pipe(tap((response: any) => {
                this.authService.setToken(response.access_token);

                this.router.navigate(['/create-person']);
            }));
    }
}
