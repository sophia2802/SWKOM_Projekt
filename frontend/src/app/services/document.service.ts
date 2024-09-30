import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DocumentService {

  private documentUrl = 'http://localhost/api/documents';
  private _headers: HttpHeaders = new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'});

  constructor(private http: HttpClient) {}

  uploadDocument(file: File): Observable<any> {
    const formData: FormData = new FormData();
    formData.append('file', file);

    return this.http.post<string>(this.documentUrl + '/upload', formData, { responseType: 'text' as 'json' });
  }

  findAllDocuments(): Observable<any[]> {
    return this.http.get<any[]>(this.documentUrl + '/all');
  }

  findDocumentById(id: number): Observable<any> {
    return this.http.get<any>(this.documentUrl + '/' + id);
  }

  deleteDocument(id: number): Observable<any> {
    return this.http.delete<any>(this.documentUrl + '/' + id);
  }
}
