export class login {

    id?: Number;
    email: String;
    password: String;

    constructor(email: String, password: String){

        this.email = email;
        this.password = password;
    }
}