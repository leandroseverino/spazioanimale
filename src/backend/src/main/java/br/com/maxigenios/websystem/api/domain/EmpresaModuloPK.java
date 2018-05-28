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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * <p>Company X Module PK</p>
 * 
 * @author Leandro Severino - lseverino@gmail.com
 * @since 1.0
 * @version 1.0 
 */
@Embeddable
public class EmpresaModuloPK implements Serializable {

    @Column(name = "empresa_id", nullable = false)
    private int empresaId;
    
    @Column(name = "modulo_id", nullable = false)
    private int moduloId;

    public EmpresaModuloPK() {
    }

    public EmpresaModuloPK(int empresaId, int moduloId) {
        this.empresaId = empresaId;
        this.moduloId = moduloId;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    public int getModuloId() {
        return moduloId;
    }

    public void setModuloId(int moduloId) {
        this.moduloId = moduloId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) empresaId;
        hash += (int) moduloId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EmpresaModuloPK)) {
            return false;
        }
        EmpresaModuloPK other = (EmpresaModuloPK) object;
        if (this.empresaId != other.empresaId) {
            return false;
        }
        if (this.moduloId != other.moduloId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EmpresaModuloPK {" + "empresaId=" + empresaId + ", moduloId=" + moduloId + '}';
    }
}
