import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-song-list',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatCardModule,
    MatButtonModule,
    MatIconModule
  ],
  templateUrl: './song-list.component.html',
  styleUrls: ['./song-list.component.css']
})
export class SongListComponent {

  selectedFilter: string = '';
  filterType: string = 'artist';

  songs = [
    { name: 'Shape of You', artist: 'Ed Sheeran', album: 'Divide', duration: '3:53', rating: 4.9 },
    { name: 'Blinding Lights', artist: 'The Weeknd', album: 'After Hours', duration: '3:20', rating: 4.8 },
    { name: 'Numb', artist: 'Linkin Park', album: 'Meteora', duration: '3:05', rating: 4.7 },
    { name: 'Unravel', artist: 'TK from Ling Tosite Sigure', album: 'Tokyo Ghoul OST', duration: '4:05', rating: 4.6 },
    { name: 'My Heart Will Go On', artist: 'Celine Dion', album: 'Titanic', duration: '4:40', rating: 4.5 },
    { name: 'Believer', artist: 'Imagine Dragons', album: 'Evolve', duration: '3:24', rating: 4.3 }
  ];

  get filteredSongs() {
    if (!this.selectedFilter) return this.songs;
    return this.songs.filter(song =>
      song[this.filterType as 'artist' | 'album'].toLowerCase().includes(this.selectedFilter.toLowerCase())
    );
  }

  clearFilter() {
    this.selectedFilter = '';
  }
}
