import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, of } from 'rxjs';
import { Employee } from './employee';


@Injectable({
  providedIn: 'root'
})
export class EmployeeService {



  displayMessage() {
    // Utilisez console.log() pour afficher des messages
    console.log('Bonjour depuis Angular !');
    console.log('Ceci est un message de journalisation.');
    }

  private baseurl="http://localhost:8080/api/v1/employees";

  constructor(private httpClient:HttpClient  ) {this.displayMessage(); }

  getEmployeeList(){

  this.httpClient.get('${this.baseurl}')
    .subscribe(response => console.log(response));
    this.employee = Response;
};



}
// getEmployeeList():Observable<Employee[]>{
//   return this.httpClient.get<Employee[]>('${this.baseurl}');


//   getEmployeeList(): Observable<Employee[]> {
//     const url = `${this.baseurl}`; // Construire l'URL complète

//     return this.httpClient.get<Employee[]>(url)
//       .pipe(
//         // Ajouter des opérateurs optionnels pour traiter la réponse (ex: map, catchError)
//         catchError(this.handleError) // Gestion d'erreurs (exemple)
//       );
//   }

//   // Méthode de gestion d'erreurs (exemple)
//   private handleError(error: HttpErrorResponse) {
//     if (error.error instanceof ErrorEvent) {
//       // Erreur côté client
//       console.error('Une erreur est survenue:', error.error.message);
//     } else {
//       // Erreur côté serveur
//       console.error(
//         `Erreur de statut : ${error.status}, ` +
//         `Message d'erreur : ${error.message}`
//       );
//     }
//     // Renvoyer une valeur observable vide en cas d'erreur
//     return of([]);
//   }




// }







