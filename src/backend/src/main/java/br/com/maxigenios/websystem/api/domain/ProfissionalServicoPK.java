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
import javax.persistence.Embeddable;

/**
 * <p>Professional X Service PK</p>
 * 
 * @author Leandro Severino - lseverino@gmail.com
 * @since 1.0
 * @version 1.0 
 */
@Embeddable
public class ProfissionalServicoPK implements Serializable {

    @Column(name = "profissional_id", nullable = false)
    private int profissionalId;
    
    @Column(name = "servico_id", nullable = false)
    private int servicoId;

    public ProfissionalServicoPK() {
    }

    public ProfissionalServicoPK(int profissionalId, int servicoId) {
        this.profissionalId = profissionalId;
        this.servicoId = servicoId;
    }

    public int getProfissionalId() {
        return profissionalId;
    }

    public void setProfissionalId(int profissionalId) {
        this.profissionalId = profissionalId;
    }

    public int getServicoId() {
        return servicoId;
    }

    public void setServicoId(int servicoId) {
        this.servicoId = servicoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) profissionalId;
        hash += (int) servicoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ProfissionalServicoPK)) {
            return false;
        }
        ProfissionalServicoPK other = (ProfissionalServicoPK) object;
        if (this.profissionalId != other.profissionalId) {
            return false;
        }
        if (this.servicoId != other.servicoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProfissionalServicoPK {" + "profissionalId=" + profissionalId + ", servicoId=" + servicoId + '}';
    }    
    
}
