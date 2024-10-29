import { Component, OnInit } from '@angular/core';
import { DocumentService } from '../../services/document.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatTableModule } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';
import {MatButton, MatIconButton} from "@angular/material/button";
import { MatIconModule } from '@angular/material/icon';
import {UploadComponent} from "../upload/upload.component";



@Component({
  selector: 'app-document-list',
  standalone: true,
  imports: [CommonModule, FormsModule, MatTableModule, MatToolbarModule, MatButton, MatIconModule, UploadComponent, MatIconButton],
  templateUrl: './document-list.component.html',
  styleUrl: './document-list.component.css'
})
export class DocumentListComponent implements OnInit {
  documents: any[] = [];
  displayedColumns: string[] = ['id', 'name', 'actions'];

  constructor(private documentService: DocumentService) {}

  ngOnInit(): void {
    this.loadDocuments();
  }

  loadDocuments(): void {
    this.documentService.findAllDocuments().subscribe({
      next: (data) => {
        this.documents = data;
      },
      error: (error) => {
        console.error('Error loading documents:', error);
      }
    });
  }

  /*deleteDocument(id: number): void {
    this.documentService.deleteDocument(id).subscribe(() => {
      this.loadDocuments();
    });
  }*/
}
