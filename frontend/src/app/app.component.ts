import { Component, OnInit} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { UploadComponent } from './components/upload/upload.component';
import {DocumentListComponent} from "./components/document-list/document-list.component";
import { MatToolbarModule } from '@angular/material/toolbar';
import { DocumentService } from './services/document.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, UploadComponent, DocumentListComponent, MatToolbarModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Document Management System';
}
