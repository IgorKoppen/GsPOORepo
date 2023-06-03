package br.com.gs.model;

import br.com.gs.util.CriptografiaUtils;

import java.sql.Date;
public final class Veiculo {
    private int codVeiculo;
    private String tipoVeiculo;
    private String refrigerado;
    private String proprietario;
    private String marca;
    private String modelo;
    private String placa;
    private Date dataEntrada = new Date(System.currentTimeMillis());
    private String tipoCombustivel;
    private float cargaMax;
    private float tanqueMax;

    public Veiculo() {
    }

    public Veiculo( String tipoVeiculo, String refrigerado, String proprietario, String marca, String modelo,String placa,  String tipoCombustivel, float cargaMax, float tanqueMax) {
        this.tipoVeiculo = tipoVeiculo;
        this.refrigerado = refrigerado;
        this.proprietario = proprietario;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.tipoCombustivel = tipoCombustivel;
        this.cargaMax = cargaMax;
        this.tanqueMax = tanqueMax;

    }



    public int getCodVeiculo() {
        return codVeiculo;
    }

    public void setCodVeiculo(int codVeiculo) {
        this.codVeiculo = codVeiculo;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public String getRefrigerado() {
        return refrigerado;
    }
    public  void setRefrigerado(String refrigerado){
        this.refrigerado = refrigerado;
}

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public Date getDateEntrada(){
        return dataEntrada;
    }


    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public float getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(float cargaMax) {
        this.cargaMax = cargaMax;
    }

    public float getTanqueMax() {
        return tanqueMax;
    }

    public void setTanqueMax(float tanqueMax) {
        this.tanqueMax = tanqueMax;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        try {
            this.placa = CriptografiaUtils.criptografar(placa);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
