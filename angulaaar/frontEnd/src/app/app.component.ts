import { Component } from '@angular/core';
import { FormControl, FormGroup } from "@angular/forms";//O FormGroup cria  um objeto que representa os campos dos formularios

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  form: FormGroup = new FormGroup({
    description: new FormControl("")//OBS: como é um objeto JavaScript, você coloca :
  })

  submit(){
    console.log(this.form.value)//Esse comando vai pegar tudo que esta dentro dos inputs

  }
}
