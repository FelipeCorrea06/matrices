import { Component, OnInit, Input } from "@angular/core";

@Component({
  selector: "app-matrix-printer",
  templateUrl: "./matrix-printer.component.html",
  styleUrls: ["./matrix-printer.component.scss"]
})
export class MatrixPrinterComponent implements OnInit {
  @Input() _input: Array<Array<any>>;

  constructor() {}

  ngOnInit() {}
}
