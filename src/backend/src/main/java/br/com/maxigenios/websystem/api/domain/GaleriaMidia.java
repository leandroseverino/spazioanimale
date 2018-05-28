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
 * <p>Gallery Media Entity</p>
 * 
 * @author Leandro Severino - lseverino@gmail.com
 * @since 1.0
 * @version 1.0 
 */
@Entity
@Table(name = "galeria_midia")
@SequenceGenerator(name = "seq_galeria_midia", sequenceName = "galeria_midia_id_seq", allocationSize = 1, initialValue = 1)
public class GaleriaMidia implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "seq_galeria_midia", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "link_url", nullable = true, length = 255)
    private String linkUrl;
    
    @Column(name = "arquivo", nullable = true, length = 255)
    private String arquivo;
    
    @Column(name = "acao_ao_clicar", nullable = true, length = 255)
    private String acaoAoClicar;
    
    @Column(name = "tipo_galeria", nullable = false, length = 1)
    private String tipoGaleria;
    
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empresa empresaId;
    
    @JoinColumn(name = "galeria_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Galeria galeriaId;

    public GaleriaMidia() {
    }

    public GaleriaMidia(Integer id) {
        this.id = id;
    }

    public GaleriaMidia(Integer id, String tipoGaleria) {
        this.id = id;
        this.tipoGaleria = tipoGaleria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public String getAcaoAoClicar() {
        return acaoAoClicar;
    }

    public void setAcaoAoClicar(String acaoAoClicar) {
        this.acaoAoClicar = acaoAoClicar;
    }

    public String getTipoGaleria() {
        return tipoGaleria;
    }

    public void setTipoGaleria(String tipoGaleria) {
        this.tipoGaleria = tipoGaleria;
    }

    public Empresa getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Empresa empresaId) {
        this.empresaId = empresaId;
    }

    public Galeria getGaleriaId() {
        return galeriaId;
    }

    public void setGaleriaId(Galeria galeriaId) {
        this.galeriaId = galeriaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof GaleriaMidia)) {
            return false;
        }
        GaleriaMidia other = (GaleriaMidia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GaleriaMidia {" + "id=" + id + ", linkUrl=" + linkUrl + ", arquivo=" + arquivo + ", acaoAoClicar=" + acaoAoClicar + ", tipoGaleria=" + tipoGaleria + ", empresaId=" + empresaId + ", galeriaId=" + galeriaId + '}';
    }
    
}
