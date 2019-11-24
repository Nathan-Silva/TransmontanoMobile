package com.transmontanomobile.transmontanomobile.model;

public class Endereco {

    private String Codigo;
    private String Localidade;
    private String Endereco;
    private String Bairro;
    private String HoraInicioAtendimento;
    private String HoraFinalAtendimento;
    private int icone;
    private int imgFoto;

    public Endereco(String codigo, String localidade, String endereco, String horaInicioAtendimento, String horaFinalAtendimento, int imgFoto) {
        Codigo = codigo;
        Localidade = localidade;
        Endereco = endereco;
        HoraInicioAtendimento = horaInicioAtendimento;
        HoraFinalAtendimento = horaFinalAtendimento;
        this.imgFoto = imgFoto;
    }

    public int getIcone() {
        return icone;
    }

    public void setIcone(int icone) {
        this.icone = icone;
    }

    public int getImgFoto() {
        return imgFoto;
    }

    public void setImgFoto(int imgFoto) {
        this.imgFoto = imgFoto;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public String getLocalidade() {
        return Localidade;
    }

    public void setLocalidade(String localidade) {
        Localidade = localidade;
    }


    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        Bairro = bairro;
    }


    public String getHoraInicioAtendimento() {
        return HoraInicioAtendimento;
    }

    public void setHoraInicioAtendimento(String horaInicioAtendimento) {
        HoraInicioAtendimento = horaInicioAtendimento;
    }

    public String getHoraFinalAtendimento() {
        return HoraFinalAtendimento;
    }

    public void setHoraFinalAtendimento(String horaFinalAtendimento) {
        HoraFinalAtendimento = horaFinalAtendimento;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "Codigo='" + Codigo + '\'' +
                ", Localidade='" + Localidade + '\'' +
                ", Endereco='" + Endereco + '\'' +
                ", Bairro='" + Bairro + '\'' +
                ", HoraInicioAtendimento='" + HoraInicioAtendimento + '\'' +
                ", HoraFinalAtendimento='" + HoraFinalAtendimento + '\'' +
                '}';
    }
}

