package com.transmontanomobile.transmontanomobile.model;

public class ListHome {

    private int id;
    private int icone;
    private String descricao;

    public ListHome(int id, int icone, String descricao) {
        this.id = id;
        this.icone = icone;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getIcone() {
        return icone;
    }

    public void setIcone(int icone) {
        this.icone = icone;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

