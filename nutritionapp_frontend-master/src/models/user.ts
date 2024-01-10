export class User {
	username!: string;
	password!: string;
	email!: string;
    height!: number;
    weight!: number;
    age!: number;
    gender!: boolean;
    constructor( username: string, password: string , email:string , height:number , weight:number , age: number , gender: boolean) {
        this.username = username;
        this.password = password;
		this.email = email;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.gender = gender;

      }
}
