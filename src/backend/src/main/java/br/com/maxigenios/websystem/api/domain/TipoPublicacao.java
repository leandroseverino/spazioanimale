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
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <p>Publication Type Entity</p>
 * 
 * @author Leandro Severino - lseverino@gmail.com
 * @since 1.0
 * @version 1.0 
 */
@Entity
@Table(name = "tipo_publicacao")
@SequenceGenerator(name = "seq_tipo_publicacao", sequenceName = "tipo_publicacao_id_seq", allocationSize = 1, initialValue = 1)
public class TipoPublicacao implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "seq_tipo_publicacao", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "titulo", nullable = false, length = 255)
    private String titulo;
    
    @Column(name = "slug", nullable = false, length = 255)
    private String slug;
    
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empresa empresaId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoId", fetch = FetchType.LAZY)
    private List<Publicacao> publicacaoList;

    public TipoPublicacao() {
    }

    public TipoPublicacao(Integer id) {
        this.id = id;
    }

    public TipoPublicacao(Integer id, String titulo, String slug) {
        this.id = id;
        this.titulo = titulo;
        this.slug = slug;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Empresa getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Empresa empresaId) {
        this.empresaId = empresaId;
    }

    public List<Publicacao> getPublicacaoList() {
        return publicacaoList;
    }

    public void setPublicacaoList(List<Publicacao> publicacaoList) {
        this.publicacaoList = publicacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TipoPublicacao)) {
            return false;
        }
        TipoPublicacao other = (TipoPublicacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoPublicacao {" + "id=" + id + ", titulo=" + titulo + ", slug=" + slug + ", empresaId=" + empresaId + '}';
    }

    
    
}
