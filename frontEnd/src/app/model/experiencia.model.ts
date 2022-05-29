export class experiencia {
    id?: Number;
    url_img_empresa: String;
    nombreEmpresa: String;
    entreAnios: String;
    descripcion: String;

    constructor(url_img_empresa: String, nombreEmpresa: String, 
                entreAnios: String, descripcion: String){

        this.url_img_empresa = url_img_empresa;
        this.nombreEmpresa = nombreEmpresa;
        this.entreAnios = entreAnios;
        this.descripcion = descripcion;
    }
}