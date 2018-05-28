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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * <p>Publication Entity</p>
 * 
 * @author Leandro Severino - lseverino@gmail.com
 * @since 1.0
 * @version 1.0 
 */
@Entity
@Table(name = "publicacao")
public class Publicacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;

    @Basic(optional = false)
    @Column(name = "slug")
    private String slug;

    @Basic(optional = false)
    @Column(name = "data_criacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Column(name = "data_publicacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPublicacao;

    @Column(name = "hora_publicacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaPublicacao;

    @Basic(optional = false)
    @Column(name = "descricao")
    private String descricao;

    @Basic(optional = false)
    @Column(name = "img_miniatura")
    private String imgMiniatura;

    @Basic(optional = false)
    @Column(name = "intro")
    private String intro;

    @Basic(optional = false)
    @Column(name = "conteudo")
    private String conteudo;

    @Basic(optional = false)
    @Column(name = "palavras_chaves")
    private String palavrasChaves;

    @Basic(optional = false)
    @Column(name = "destaque")
    private boolean destaque;

    @Basic(optional = false)
    @Column(name = "permite_comentario")
    private boolean permiteComentario;

    @Basic(optional = false)
    @Column(name = "rascunho")
    private boolean rascunho;

    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empresa empresaId;

    @JoinColumn(name = "tipo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoPublicacao tipoId;

    public Publicacao() {
    }

    public Publicacao(Integer id) {
        this.id = id;
    }

    public Publicacao(Integer id, String titulo, String slug, Date dataCriacao, String descricao, String imgMiniatura, String intro, String conteudo, String palavrasChaves, boolean destaque, boolean permiteComentario, boolean rascunho) {
        this.id = id;
        this.titulo = titulo;
        this.slug = slug;
        this.dataCriacao = dataCriacao;
        this.descricao = descricao;
        this.imgMiniatura = imgMiniatura;
        this.intro = intro;
        this.conteudo = conteudo;
        this.palavrasChaves = palavrasChaves;
        this.destaque = destaque;
        this.permiteComentario = permiteComentario;
        this.rascunho = rascunho;
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

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Date getHoraPublicacao() {
        return horaPublicacao;
    }

    public void setHoraPublicacao(Date horaPublicacao) {
        this.horaPublicacao = horaPublicacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImgMiniatura() {
        return imgMiniatura;
    }

    public void setImgMiniatura(String imgMiniatura) {
        this.imgMiniatura = imgMiniatura;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getPalavrasChaves() {
        return palavrasChaves;
    }

    public void setPalavrasChaves(String palavrasChaves) {
        this.palavrasChaves = palavrasChaves;
    }

    public boolean getDestaque() {
        return destaque;
    }

    public void setDestaque(boolean destaque) {
        this.destaque = destaque;
    }

    public boolean getPermiteComentario() {
        return permiteComentario;
    }

    public void setPermiteComentario(boolean permiteComentario) {
        this.permiteComentario = permiteComentario;
    }

    public boolean getRascunho() {
        return rascunho;
    }

    public void setRascunho(boolean rascunho) {
        this.rascunho = rascunho;
    }

    public Empresa getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Empresa empresaId) {
        this.empresaId = empresaId;
    }

    public TipoPublicacao getTipoId() {
        return tipoId;
    }

    public void setTipoId(TipoPublicacao tipoId) {
        this.tipoId = tipoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Publicacao)) {
            return false;
        }
        Publicacao other = (Publicacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Publicacao {" + "id=" + id + ", titulo=" + titulo + ", slug=" + slug + ", dataCriacao=" + dataCriacao + ", dataPublicacao=" + dataPublicacao + ", horaPublicacao=" + horaPublicacao + ", descricao=" + descricao + ", imgMiniatura=" + imgMiniatura + ", intro=" + intro + ", conteudo=" + conteudo + ", palavrasChaves=" + palavrasChaves + ", destaque=" + destaque + ", permiteComentario=" + permiteComentario + ", rascunho=" + rascunho + ", empresaId=" + empresaId + ", tipoId=" + tipoId + '}';
    }
    
    
}
