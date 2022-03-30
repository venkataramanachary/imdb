import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';
import { FilmRating } from '../models/filmrating';
import { User } from '../models/user';
import { AuthenticationService } from '../services/authentication.service';
import { FilmService } from '../services/film.service';
import { FilmratingService } from '../services/filmrating.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  currentUser:User ;
  loading = false;
  submitted = false;
  films = [];
  //filmNameSearch = '';
	constructor(private filmService:FilmService,
    private authenticationService: AuthenticationService,
    private filmRatingService: FilmratingService){
      this.currentUser = this.authenticationService.currentUserValue;
      
    }
	ngOnInit() {


		this.getCall();
	}

  public filmNameSearch: string | String;

	public getCall(){
		this.filmService.getAllFilms().pipe(first())
    .subscribe(films => this.films = films);
	}

  public clearList(){
    this.filmNameSearch = '';
    this.getCall();
  }

	public film:any = {};
  public filmRating:FilmRating;

	public searchList() {
		if (this.filmNameSearch !== '') {
			this.filmService.getSearchedFilms(this.filmNameSearch).pipe(first())
    .subscribe(films => this.films = films);
		}
	}

	public updateRating(index, event:number) {
    this.loading = true;
		let item = this.films[index];
		item["rating"] = event;

    }

    public updateTask(index) {
      this.loading = true;
      let item = this.films[index];
      //this.film["filmRatingId"] = item["filmRatingId"];	
      this.filmRating = {
        "filmId" : item["filmId"],
        "rating" : item["rating"],
        "userId" : this.currentUser.userId,
  
      }
	
		this.filmRatingService.addFilmRating(this.filmRating).pipe(first()).subscribe(
      data => {
          alert("Rating saved successfully")
          this.loading = false;
          this.getCall();
      },
      error => {
          alert("Rating save failed")
          this.loading = false;
      });
}
}
