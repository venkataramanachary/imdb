import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FilmRating } from '../models/filmrating';

@Injectable({
  providedIn: 'root'
})
export class FilmratingService {

  constructor(private http:HttpClient) { }

  addFilmRating(filmRating: FilmRating) {
    return this.http.post(`http://localhost:8080/imdb/v1/filmrating/saveFilmRating`, filmRating);
}
} 
 