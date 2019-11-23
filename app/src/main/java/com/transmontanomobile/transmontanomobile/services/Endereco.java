package com.transmontanomobile.transmontanomobile.services;

public class Endereco {

    private String Codigo;
    private String Localidade;
    private String Sede;
    private String Endereco;
    private String Bairro;
    private String Cep;
    private String Cidade;
    private String Estado;
    private String imagem;
    private String Imagem2;
    private String Numero;
    private String Complemento;
    private String Latitude;
    private String Longitude;
    private String Telefone;
    private String DDD;
    private String HoraInicioPA;
    private String HoraFinalPA;
    private String AtendimentoPA;
    private String HoraInicioAtendimento;
    private String HoraFinalAtendimento;

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

    public String getSede() {
        return Sede;
    }

    public void setSede(String sede) {
        Sede = sede;
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

    public String getCep() {
        return Cep;
    }

    public void setCep(String cep) {
        Cep = cep;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getImagem2() {
        return Imagem2;
    }

    public void setImagem2(String imagem2) {
        Imagem2 = imagem2;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String numero) {
        Numero = numero;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String complemento) {
        Complemento = complemento;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public String getDDD() {
        return DDD;
    }

    public void setDDD(String DDD) {
        this.DDD = DDD;
    }

    public String getHoraInicioPA() {
        return HoraInicioPA;
    }

    public void setHoraInicioPA(String horaInicioPA) {
        HoraInicioPA = horaInicioPA;
    }

    public String getHoraFinalPA() {
        return HoraFinalPA;
    }

    public void setHoraFinalPA(String horaFinalPA) {
        HoraFinalPA = horaFinalPA;
    }

    public String getAtendimentoPA() {
        return AtendimentoPA;
    }

    public void setAtendimentoPA(String atendimentoPA) {
        AtendimentoPA = atendimentoPA;
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
                ", Sede='" + Sede + '\'' +
                ", Endereco='" + Endereco + '\'' +
                ", Bairro='" + Bairro + '\'' +
                ", Cep='" + Cep + '\'' +
                ", Cidade='" + Cidade + '\'' +
                ", Estado='" + Estado + '\'' +
                ", imagem='" + imagem + '\'' +
                ", Imagem2='" + Imagem2 + '\'' +
                ", Numero='" + Numero + '\'' +
                ", Complemento='" + Complemento + '\'' +
                ", Latitude='" + Latitude + '\'' +
                ", Longitude='" + Longitude + '\'' +
                ", Telefone='" + Telefone + '\'' +
                ", DDD='" + DDD + '\'' +
                ", HoraInicioPA='" + HoraInicioPA + '\'' +
                ", HoraFinalPA='" + HoraFinalPA + '\'' +
                ", AtendimentoPA='" + AtendimentoPA + '\'' +
                ", HoraInicioAtendimento='" + HoraInicioAtendimento + '\'' +
                ", HoraFinalAtendimento='" + HoraFinalAtendimento + '\'' +
                '}';
    }
}
