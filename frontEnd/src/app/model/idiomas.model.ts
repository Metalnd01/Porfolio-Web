export class idiomas {

    id?: Number;
    url_img_institucion: String;
    nombreIdioma: String;
    entreAnios: String;
    descripcion: String;

    constructor(url_img_institucion: String, nombreIdioma: String, 
                entreAnios: String, descripcion: String){

        this.url_img_institucion = url_img_institucion;
        this.nombreIdioma = nombreIdioma;
        this.entreAnios = entreAnios;
        this.descripcion = descripcion;
    }
}