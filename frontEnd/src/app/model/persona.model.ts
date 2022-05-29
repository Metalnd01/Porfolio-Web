export class persona {
    id?: number;
    fullname: String;
    titulo: String;
    foto_perfil: String;

    constructor(fullname: String, titulo: String, foto_perfil: String) {
        this.fullname = fullname;
        this.titulo = titulo;
        this.foto_perfil = foto_perfil;
    }
}