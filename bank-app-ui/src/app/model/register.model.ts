
export class Register{

    public id: number;
    public name: string;
    public mobileNumber: string;
    public email : string;
    public password: string;
    public confirmPassword: string;
    public role : string;
  
    constructor(id?: number,name?: string, mobileNumber?: string, email?: string,  password?: string, confirmPassword?: string, role?: string){
          this.id = id || 0;
          this.name = name || '';
          this.mobileNumber = mobileNumber || '';
          this.email = email || '';
          this.password = password || '';
          this.confirmPassword = confirmPassword || '';
          this.role = role || '';
    }
  
}
  