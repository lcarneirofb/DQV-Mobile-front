package com.example.dqv.repositories;


import com.example.dqv.beans.Pessoa;

public class PessoaRepository {
    private Pessoa pessoa;
    private static PessoaRepository repo;

    public static PessoaRepository getInstance(){
        if(repo==null){
            repo = new PessoaRepository();
        }
        return repo;
    }
    private PessoaRepository(){
    }

    public Pessoa retornaPessoa(){
        return pessoa;
    }

    public void configPessoa(Pessoa pessoa) {
       this.pessoa=pessoa;
    }

}
