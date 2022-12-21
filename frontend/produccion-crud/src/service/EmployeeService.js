//Se importa la libreria de axios, la cual nos da toda la funcionalidad
import axios from 'axios';

//Se detalla la url del proyecto en este caso del EmployeeController 
const url = "http://localhost:8080/employee/"

//Se exporta aqui mismo
class  PersonaService {
    //Se retorna (la url + "la seccion")
    getAll(){
        return axios.get(this.url + "login")
    }
}

export default new EmployeeService();