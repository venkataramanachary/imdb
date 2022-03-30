import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { AuthenticationService } from '../services/authentication.service';
import { FilmService } from '../services/film.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-film',
  templateUrl: './film.component.html',
  styleUrls: ['./film.component.scss']
})
export class FilmComponent implements OnInit {
  filmForm: FormGroup;
  loading = false;
  submitted = false;

  constructor(
      private formBuilder: FormBuilder,
      private router: Router,
      private authenticationService: AuthenticationService,
      private userService: UserService,
      private filmService: FilmService
  ) {
      // redirect to home if already logged in
      if (this.authenticationService.currentUserValue) {
          this.router.navigate(['/film']);
      }
  }

  ngOnInit() {
      this.filmForm = this.formBuilder.group({
          filmName: ['', Validators.required],
          language: ['', Validators.required]
      });
  }

  // convenience getter for easy access to form fields
  get f() { return this.filmForm.controls; }

  onSubmit() {
      this.submitted = true;
 
 
      
      if (this.filmForm.invalid) {
          return;
      }

      this.loading = true;
      this.filmService.addFilm(this.filmForm.value)
          .pipe(first())
          .subscribe(
              data => {
                  alert("Film added successfully")
                  this.loading = false;
                  this.filmForm.reset();
                  for (let control in this.filmForm.controls) {
                    this.filmForm.controls[control].setErrors(null);
                  }
                  
              },
              error => {
                  alert("Adding Film failed")
                  this.loading = false;
              });
  }
}


