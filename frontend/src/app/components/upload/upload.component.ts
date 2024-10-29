import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import { FormsModule } from '@angular/forms';
import { DocumentService } from '../../services/document.service';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-upload',
  standalone: true,
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css'],
  imports: [FormsModule, MatIconModule],
})
export class UploadComponent {
  @ViewChild('fileInput') fileInput!: ElementRef; // Referenz zum versteckten Input
  selectedFile: File | null = null;

  constructor(private documentService: DocumentService) {}

  onFileButtonClick(): void {
    this.fileInput.nativeElement.click();
  }

  onFileSelected(event: any): void {
    this.selectedFile = event.target.files[0];
    if (this.selectedFile) {
      this.onSubmit(); // Automatischer Upload nach Auswahl
    }
  }

  onSubmit() {
    if (this.selectedFile) {
      console.log('File ready for upload:', this.selectedFile.name);
      this.documentService.uploadDocument(this.selectedFile).subscribe({
        next: (response) => {
          console.log('File uploaded successfully', response);
        },
        error: (error) => {
          console.error('Error uploading file', error);
        }
      });
    }
  }
}
