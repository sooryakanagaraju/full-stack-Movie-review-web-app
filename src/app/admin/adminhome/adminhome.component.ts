import { Component, OnInit , ViewChild} from '@angular/core';
import { MaterialModule } from 'src/app/material/material.module';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { MatDialog } from '@angular/material/dialog';
import { MovieService } from 'src/app/shared/services/movie.service';
import { CrudoperationComponent } from './crudoperation/crudoperation.component';
import { CoreService } from '../services/core.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-adminhome',
  templateUrl: './adminhome.component.html',
  styleUrls: ['./adminhome.component.css']
})
export class AdminhomeComponent implements OnInit {

  displayedColumns: string[] = [
    'movId',
    'name',
    'genre',
    'released',
    'director',
    'starring',
    'description',
    'image',
    'action',
  ];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(
    private md: MatDialog,
    private ms: MovieService,
    private cs: CoreService,
  ) {}

  ngOnInit(): void {
    this.getMovieList();
  }

  AddEditMovie() {
    const dialogRef = this.md.open(CrudoperationComponent);
    dialogRef.afterClosed().subscribe({
      next: (val) => {
        if (val) {
          this.getMovieList();
        }
      },
    });
  }

  getMovieList() {
    this.ms.getMovieList().subscribe({
      next: (res) => {
        this.dataSource = new MatTableDataSource(res);
        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;
      },
      error: console.log,
    });
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  deleteMovie(movId: number) {
    this.ms.deleteMovie(movId).subscribe({
      next: (res) => {
        this.cs.openSnackBar('Movie deleted!', 'done');
        this.getMovieList();
    
      },
      error: console.log
    });
  }

  EditMovie(data: any) {
    const dialogRef = this.md.open(CrudoperationComponent, {
      data,
    });

    dialogRef.afterClosed().subscribe({
      next: (val) => {
        if (val) {
          this.getMovieList();
        }
      },
    });
    
  }
}
