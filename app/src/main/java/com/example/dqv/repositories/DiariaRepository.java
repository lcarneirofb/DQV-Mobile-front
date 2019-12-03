package com.example.dqv.repositories;

import com.example.dqv.beans.Diaria;

import java.util.List;

public class DiariaRepository {
    private List<Diaria> diarias;
    private static  DiariaRepository repo;

    private DiariaRepository(){
    }

    public DiariaRepository getInstance(){
        if(repo==null){
            repo=new DiariaRepository();
        }
        return repo;
    }

    public void configDiarias(List<Diaria> diarias){
        this.diarias=diarias;
    }

    public List<Diaria> retornaDiarias(){
        return this.diarias;
    }
}
