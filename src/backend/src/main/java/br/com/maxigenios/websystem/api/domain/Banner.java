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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * <p>Banner Entity</p>
 * 
 * @author Leandro Severino - lseverino@gmail.com
 * @since 1.0
 * @version 1.0 
 */
@Entity
@Table(name = "banner")
@SequenceGenerator(name = "seq_banner", sequenceName = "banner_id_seq", allocationSize = 1, initialValue = 1)
public class Banner implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "seq_banner", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "titulo", nullable = false, length = 255)
    private String titulo;

    @Column(name = "slug", nullable = false, length = 255)
    private String slug;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "link_url", nullable = true, length = 255)
    private String linkUrl;

    @Column(name = "arquivo", nullable = true, length = 255)
    private String arquivo;

    @Column(name = "acao_ao_clicar", nullable = true, length = 255)
    private String acaoAoClicar;

    @Column(name = "exibir_de", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date exibirDe;

    @Column(name = "exibir_ate", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date exibirAte;

    @Column(name = "exibir_descricao", nullable = false)
    private boolean exibirDescricao;

    @Column(name = "permite_comentario", nullable = false)
    private boolean permiteComentario;

    @Column(name = "permitir_compartilhar", nullable = false)
    private boolean permitirCompartilhar;

    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empresa empresaId;

    public Banner() {
    }

    public Banner(Integer id) {
        this.id = id;
    }

    public Banner(Integer id, String titulo, String slug, String descricao, boolean exibirDescricao, boolean permiteComentario, boolean permitirCompartilhar) {
        this.id = id;
        this.titulo = titulo;
        this.slug = slug;
        this.descricao = descricao;
        this.exibirDescricao = exibirDescricao;
        this.permiteComentario = permiteComentario;
        this.permitirCompartilhar = permitirCompartilhar;
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

    public Date getExibirDe() {
        return exibirDe;
    }

    public void setExibirDe(Date exibirDe) {
        this.exibirDe = exibirDe;
    }

    public Date getExibirAte() {
        return exibirAte;
    }

    public void setExibirAte(Date exibirAte) {
        this.exibirAte = exibirAte;
    }

    public boolean getExibirDescricao() {
        return exibirDescricao;
    }

    public void setExibirDescricao(boolean exibirDescricao) {
        this.exibirDescricao = exibirDescricao;
    }

    public boolean getPermiteComentario() {
        return permiteComentario;
    }

    public void setPermiteComentario(boolean permiteComentario) {
        this.permiteComentario = permiteComentario;
    }

    public boolean getPermitirCompartilhar() {
        return permitirCompartilhar;
    }

    public void setPermitirCompartilhar(boolean permitirCompartilhar) {
        this.permitirCompartilhar = permitirCompartilhar;
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
        if (!(object instanceof Banner)) {
            return false;
        }
        Banner other = (Banner) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Banner {" + "id=" + id + ", titulo=" + titulo + ", slug=" + slug + ", descricao=" + descricao + ", linkUrl=" + linkUrl + ", arquivo=" + arquivo + ", acaoAoClicar=" + acaoAoClicar + ", exibirDe=" + exibirDe + ", exibirAte=" + exibirAte + ", exibirDescricao=" + exibirDescricao + ", permiteComentario=" + permiteComentario + ", permitirCompartilhar=" + permitirCompartilhar + ", empresaId=" + empresaId + '}';
    }
    
}
