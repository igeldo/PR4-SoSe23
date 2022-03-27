import { Injectable } from '@angular/core';
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  token: string | undefined;

  constructor(private router: Router) { }

  public getToken(): string | undefined {
    if(!this.token && this.getTokenFromStorage()) {
      this.token = this.getTokenFromStorage();
    }
    return this.token;
  }

  public setToken(token: string) {
    this.token = token;
    localStorage.setItem('jwtoken', token);
  }

  get isAuthenticated(): boolean {
    return this.getToken() !== undefined;
  }

  getTokenFromStorage(): string | undefined {
    const token = localStorage.getItem('jwtoken');
    return token !== null ? token : undefined;
  }

  doLogout() {
    this.clearToken();
    if(this.token === undefined) {
      this.router.navigate(['/login']);
    }
  }

  clearToken() {
    this.token = undefined;
    localStorage.removeItem('jwtoken');
  }
}
