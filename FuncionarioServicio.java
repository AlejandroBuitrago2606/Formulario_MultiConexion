package Servicios;

import Interfaces.FuncionarioRepositorio;
import Modelo.Funcionario;
import java.util.List;

public class FuncionarioServicio {

    private FuncionarioRepositorio funcionarioRepositorio;

    public FuncionarioServicio(FuncionarioRepositorio funcionarioRepositorio) {
        this.funcionarioRepositorio = funcionarioRepositorio;
    }

    public boolean createFuncionario(Funcionario funcionario) {
        return funcionarioRepositorio.create(funcionario);
    }
     
    public Funcionario getFuncionario(int id){
        return funcionarioRepositorio.read(id);
    }
    public List<Funcionario> getAllFuncionario(){
        return funcionarioRepositorio.readAll();
    }
    public boolean updateFuncionario(Funcionario funcionario){
     return funcionarioRepositorio.update(funcionario);
    }
    public boolean deleteFuncionario(int id){
        return funcionarioRepositorio.delete(id);
    }
    

}
