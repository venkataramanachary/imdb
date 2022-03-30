import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Film } from '../models/film';

@Injectable({
  providedIn: 'root'
})
export class FilmService {
 
  constructor(private http:HttpClient) { }

  addFilm(film: Film) {
    return this.http.post(`http://localhost:8080/imdb/v1/film/addFilm`, film);
}
getAllFilms() {
  return this.http.get<Film[]>(`http://localhost:8080/imdb/v1/film/getAllFilms`);
}
getSearchedFilms(filmname: String) {
  return this.http.get<Film[]>(`http://localhost:8080/imdb/v1/film/getSearchFilms?filmName=`+filmname);
}
}
