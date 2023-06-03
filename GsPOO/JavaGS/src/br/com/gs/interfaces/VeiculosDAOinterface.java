package br.com.gs.interfaces;


import br.com.gs.model.Veiculo;

import java.util.List;

public interface VeiculosDAOinterface {


    public void insert(Veiculo veiculo);

    public abstract void update(Veiculo veiculo);

    public abstract void delete(int id);

    public abstract List<Veiculo> selectAll();

    public  abstract  Veiculo selectById(int id);

}
