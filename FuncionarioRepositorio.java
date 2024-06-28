package Interfaces;

import Modelo.Funcionario;
import java.util.List;

public interface FuncionarioRepositorio {
boolean create(Funcionario funcionario);     
Funcionario read(int id);
List<Funcionario> readAll();
boolean update(Funcionario funcionario);
boolean delete(int id);


}
