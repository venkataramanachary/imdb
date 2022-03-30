import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }

  register(user: User) {
    return this.http.post(`http://localhost:8080/imdb/v1/userref/register`, user);
}
}
 