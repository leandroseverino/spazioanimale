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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * <p>Professional X Service Entity</p
 * 
 * @author Leandro Severino - lseverino@gmail.com
 * @since 1.0
 * @version 1.0 
 */
@Entity
@Table(name = "profissional_servico")
public class ProfissionalServico implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected ProfissionalServicoPK profissionalServicoPK;
    
    @Column(name = "empresa_id", nullable = false)
    private int empresaId;
    
    @JoinColumn(name = "profissional_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Profissional profissional;
    
    @JoinColumn(name = "servico_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Servico servico;

    public ProfissionalServico() {
    }

    public ProfissionalServico(ProfissionalServicoPK profissionalServicoPK) {
        this.profissionalServicoPK = profissionalServicoPK;
    }

    public ProfissionalServico(ProfissionalServicoPK profissionalServicoPK, int empresaId) {
        this.profissionalServicoPK = profissionalServicoPK;
        this.empresaId = empresaId;
    }

    public ProfissionalServico(int profissionalId, int servicoId) {
        this.profissionalServicoPK = new ProfissionalServicoPK(profissionalId, servicoId);
    }

    public ProfissionalServicoPK getProfissionalServicoPK() {
        return profissionalServicoPK;
    }

    public void setProfissionalServicoPK(ProfissionalServicoPK profissionalServicoPK) {
        this.profissionalServicoPK = profissionalServicoPK;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profissionalServicoPK != null ? profissionalServicoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ProfissionalServico)) {
            return false;
        }
        ProfissionalServico other = (ProfissionalServico) object;
        if ((this.profissionalServicoPK == null && other.profissionalServicoPK != null) || (this.profissionalServicoPK != null && !this.profissionalServicoPK.equals(other.profissionalServicoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProfissionalServico {" + "profissionalServicoPK=" + profissionalServicoPK + ", empresaId=" + empresaId + ", profissional=" + profissional + ", servico=" + servico + '}';
    }
    
}
