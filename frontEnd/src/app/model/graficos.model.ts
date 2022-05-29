export class graficos {

    id?: Number;
    nombre_skill: String;
    porcentaje: number;

    constructor(nombre_skill: String, porcentaje: number){

        this.nombre_skill = nombre_skill;
        this.porcentaje = porcentaje;
        
    }
}