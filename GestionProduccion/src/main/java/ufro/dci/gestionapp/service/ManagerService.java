package ufro.dci.gestionapp.service;

import org.springframework.stereotype.Service;
import ufro.dci.gestionapp.model.employee.register.UserRegister;
import ufro.dci.gestionapp.repository.EmployeeRepository;
import ufro.dci.gestionapp.repository.RegisterRepository;

import java.util.List;

@Service
public class ManagerService {

    final private RegisterRepository registerRepository;
    final private EmployeeRepository employeeRepository;

    public ManagerService(RegisterRepository registerRepository, EmployeeRepository employeeRepository) {
        this.registerRepository = registerRepository;
        this.employeeRepository = employeeRepository;
    }

//Lo usaremos para tomar cual es el ultimo usuario en registrarse
    public int getLastId(){
        List<UserRegister> lastId = registerRepository.findAll();
        return lastId.get(lastId.size()-1).getId();
    }
    public String getManagerRut(){
        return registerRepository.findById(getLastId()).getRut();
    }
    //----------------------------------------------------------------------------//

    public String getManagerName(){
        return this.employeeRepository.findByRut(getManagerRut()).getName() + " " + this.employeeRepository.findByRut(getManagerRut()).getLastName();
    }

    //---guardar el objeto-----//

    public void createObject(String rut){
        UserRegister userRegister = new UserRegister(rut);
        saveObjeto(userRegister);
    }
    private void saveObjeto(UserRegister userRegister){
        registerRepository.save(userRegister);
    }
    //-----------------------------------------------
}
