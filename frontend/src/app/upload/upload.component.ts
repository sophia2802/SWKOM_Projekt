import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { DocumentService } from '../services/document.service';

@Component({
  selector: 'app-upload',
  standalone: true,
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css'],
  imports: [FormsModule],
})
export class UploadComponent {
  selectedFile: File | null = null;

  constructor(private documentService: DocumentService) {}

  onFileSelected(event: any) {
    this.selectedFile = event.target.files[0];
    console.log(this.selectedFile);
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
