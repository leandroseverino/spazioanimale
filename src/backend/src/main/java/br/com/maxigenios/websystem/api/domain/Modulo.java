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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <p>Module Entity</p>
 * 
 * @author Leandro Severino - lseverino@gmail.com
 * @since 1.0
 * @version 1.0 
 */
@Entity
@Table(name = "modulo")
@SequenceGenerator(name = "seq_modulo", sequenceName = "modulo_id_seq", allocationSize = 1, initialValue = 1)
public class Modulo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "seq_modulo", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "titulo", nullable = false, length = 255)
    private String titulo;

    @Column(name = "slug", nullable = false, length = 255)
    private String slug;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "base_path", nullable = false, length = 255)
    private String basePath;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modulo", fetch = FetchType.LAZY)
    private List<EmpresaModulo> empresaModuloList;

    public Modulo() {
    }

    public Modulo(Integer id) {
        this.id = id;
    }

    public Modulo(Integer id, String titulo, String slug, String descricao, String basePath) {
        this.id = id;
        this.titulo = titulo;
        this.slug = slug;
        this.descricao = descricao;
        this.basePath = basePath;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public List<EmpresaModulo> getEmpresaModuloList() {
        return empresaModuloList;
    }

    public void setEmpresaModuloList(List<EmpresaModulo> empresaModuloList) {
        this.empresaModuloList = empresaModuloList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Modulo)) {
            return false;
        }
        Modulo other = (Modulo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modulo {" + "id=" + id + ", titulo=" + titulo + ", slug=" + slug + ", descricao=" + descricao + ", basePath=" + basePath + '}';
    }

}
