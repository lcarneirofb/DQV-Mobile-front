package com.example.dqv.repositories;

import com.example.dqv.beans.Horario;

import java.util.List;

public class HorarioRepository {
    private List<Horario> horarios;
    private static HorarioRepository repo;

    private HorarioRepository(){
    }

    public HorarioRepository getInstance(){
        if(repo==null){
            repo=new HorarioRepository();
        }
        return repo;
    }

    public void configHorarios(List<Horario> horarios){
        this.horarios=horarios;
    }

    public List<Horario> retornaHorarios(){
        return this.horarios;
    }
}
