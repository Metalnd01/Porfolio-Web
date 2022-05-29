export class proyectos {

    id?: Number;
    url_img_proyecto: String;
    nombreProyecto: String;
    descripcion: String;

    constructor(url_img_proyecto: String, nombreProyecto: String, descripcion: String){

        this.url_img_proyecto = url_img_proyecto;
        this.nombreProyecto = nombreProyecto;
        this.descripcion = descripcion;
    }
}