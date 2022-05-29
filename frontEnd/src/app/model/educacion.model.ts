export class educacion{

    id?:number;
    url_img_institucion: String;
    nombreInstitucion: String;
    entreAnios: String;
    descripcion: String;

    constructor(url_img_institucion: String, nombreInstitucion: String, 
                entreAnios: String, descripcion: String){
        
        this.url_img_institucion = url_img_institucion;
        this.nombreInstitucion = nombreInstitucion;
        this.entreAnios = entreAnios;
        this.descripcion = descripcion;
    }

}