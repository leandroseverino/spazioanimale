/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.maxigenios.websystem.api.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <p>Address Entity</p>
 * 
 * @author Leandro Severino - lseverino@gmail.com
 * @since 1.0
 * @version 1.0 
 */
@Entity
@Table(name = "endereco")
@SequenceGenerator(name = "seq_endereco", sequenceName = "endereco_id_seq", allocationSize = 1, initialValue = 1)
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "seq_endereco", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "tipo_endereco", nullable = false, length = 1)
    private String tipoEndereco;
    
    @Column(name = "logradouro", nullable = false, length = 255)
    private String logradouro;
    
    @Column(name = "complemento", nullable = true, length = 255)
    private String complemento;
    
    @Column(name = "bairro", nullable = false, length = 255)
    private String bairro;
    
    @Column(name = "cidade", nullable = false, length = 255)
    private String cidade;
    
    @Column(name = "uf", nullable = false, length = 2)
    private String uf;
    
    @Column(name = "cep", nullable = false, length = 10)
    private String cep;
    
    @Column(name = "ponto_referencia", nullable = true, length = 250)
    private String pontoReferencia;
    
    @Column(name = "coordenada_lat", nullable = false, length = 10)
    private String coordenadaLat;
    
    @Column(name = "coordenada_long", nullable = false, length = 10)
    private String coordenadaLong;
    
    @Column(name = "fone1", nullable = false, length = 15)
    private String fone1;
    
    @Column(name = "fone2", nullable = true, length = 15)
    private String fone2;
    
    @Column(name = "fone1_whathsapp", nullable = false)
    private boolean fone1Whathsapp;
    
    @Column(name = "fone2_whathsapp", nullable = true)
    private Boolean fone2Whathsapp;
    
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empresa empresaId;

    public Endereco() {
    }

    public Endereco(Integer id) {
        this.id = id;
    }

    public Endereco(Integer id, String tipoEndereco, String logradouro, String bairro, String cidade, String uf, String cep, String coordenadaLat, String coordenadaLong, String fone1, boolean fone1Whathsapp) {
        this.id = id;
        this.tipoEndereco = tipoEndereco;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.coordenadaLat = coordenadaLat;
        this.coordenadaLong = coordenadaLong;
        this.fone1 = fone1;
        this.fone1Whathsapp = fone1Whathsapp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(String tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }

    public String getCoordenadaLat() {
        return coordenadaLat;
    }

    public void setCoordenadaLat(String coordenadaLat) {
        this.coordenadaLat = coordenadaLat;
    }

    public String getCoordenadaLong() {
        return coordenadaLong;
    }

    public void setCoordenadaLong(String coordenadaLong) {
        this.coordenadaLong = coordenadaLong;
    }

    public String getFone1() {
        return fone1;
    }

    public void setFone1(String fone1) {
        this.fone1 = fone1;
    }

    public String getFone2() {
        return fone2;
    }

    public void setFone2(String fone2) {
        this.fone2 = fone2;
    }

    public boolean getFone1Whathsapp() {
        return fone1Whathsapp;
    }

    public void setFone1Whathsapp(boolean fone1Whathsapp) {
        this.fone1Whathsapp = fone1Whathsapp;
    }

    public Boolean getFone2Whathsapp() {
        return fone2Whathsapp;
    }

    public void setFone2Whathsapp(Boolean fone2Whathsapp) {
        this.fone2Whathsapp = fone2Whathsapp;
    }

    public Empresa getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Empresa empresaId) {
        this.empresaId = empresaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Endereco {" + "id=" + id + ", tipoEndereco=" + tipoEndereco + ", logradouro=" + logradouro + ", complemento=" + complemento + ", bairro=" + bairro + ", cidade=" + cidade + ", uf=" + uf + ", cep=" + cep + ", pontoReferencia=" + pontoReferencia + ", coordenadaLat=" + coordenadaLat + ", coordenadaLong=" + coordenadaLong + ", fone1=" + fone1 + ", fone2=" + fone2 + ", fone1Whathsapp=" + fone1Whathsapp + ", fone2Whathsapp=" + fone2Whathsapp + ", empresaId=" + empresaId + '}';
    }
    
}
