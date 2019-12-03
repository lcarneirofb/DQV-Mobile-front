package com.example.dqv.repositories;

import com.example.dqv.beans.Especialista;
import com.example.dqv.beans.Medico;

import java.util.List;

public class EspecialistaRepository {
    private List<Especialista> especialistas;
    private List<Medico> medicos;

    private static EspecialistaRepository repo;

    private EspecialistaRepository(){
    }

    public EspecialistaRepository getInstance(){
        if(repo==null){
            repo=new EspecialistaRepository();
        }
        return repo;
    }

    public void configEspecialistas(List<Especialista> especialistas){
        this.especialistas=especialistas;
    }

    public List<Especialista> retornaEspecialistas() {
        return this.especialistas;
    }

    public void configMedicos(List<Medico> medicos){
        this.medicos=medicos;
    }

    public List<Medico> retornaMedicos() {
        return this.medicos;
    }
}
