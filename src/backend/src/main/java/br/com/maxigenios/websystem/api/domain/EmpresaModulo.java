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
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * <p>Company X Module Entity</p>
 * 
 * @author Leandro Severino - lseverino@gmail.com
 * @since 1.0
 * @version 1.0 
 */
@Entity
@Table(name = "empresa_modulo")
public class EmpresaModulo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected EmpresaModuloPK empresaModuloPK;
    
    @Column(name = "ativo", nullable = true)
    private boolean ativo;
    
    @Column(name = "chave_ativacao", nullable = false, length = 255)
    private String chaveAtivacao;
    
    @Column(name = "data_ativacao", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtivacao;
    
    @JoinColumn(name = "empresa_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empresa empresa;
    
    @JoinColumn(name = "modulo_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Modulo modulo;

    public EmpresaModulo() {
    }

    public EmpresaModulo(EmpresaModuloPK empresaModuloPK) {
        this.empresaModuloPK = empresaModuloPK;
    }

    public EmpresaModulo(EmpresaModuloPK empresaModuloPK, boolean ativo, String chaveAtivacao, Date dataAtivacao) {
        this.empresaModuloPK = empresaModuloPK;
        this.ativo = ativo;
        this.chaveAtivacao = chaveAtivacao;
        this.dataAtivacao = dataAtivacao;
    }

    public EmpresaModulo(int empresaId, int moduloId) {
        this.empresaModuloPK = new EmpresaModuloPK(empresaId, moduloId);
    }

    public EmpresaModuloPK getEmpresaModuloPK() {
        return empresaModuloPK;
    }

    public void setEmpresaModuloPK(EmpresaModuloPK empresaModuloPK) {
        this.empresaModuloPK = empresaModuloPK;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getChaveAtivacao() {
        return chaveAtivacao;
    }

    public void setChaveAtivacao(String chaveAtivacao) {
        this.chaveAtivacao = chaveAtivacao;
    }

    public Date getDataAtivacao() {
        return dataAtivacao;
    }

    public void setDataAtivacao(Date dataAtivacao) {
        this.dataAtivacao = dataAtivacao;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empresaModuloPK != null ? empresaModuloPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EmpresaModulo)) {
            return false;
        }
        EmpresaModulo other = (EmpresaModulo) object;
        if ((this.empresaModuloPK == null && other.empresaModuloPK != null) || (this.empresaModuloPK != null && !this.empresaModuloPK.equals(other.empresaModuloPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EmpresaModulo {" + "empresaModuloPK=" + empresaModuloPK + ", ativo=" + ativo + ", chaveAtivacao=" + chaveAtivacao + ", dataAtivacao=" + dataAtivacao + ", empresa=" + empresa + ", modulo=" + modulo + '}';
    }
    
}
