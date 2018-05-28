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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * <p>Gallery Entity</p>
 * 
 * @author Leandro Severino - lseverino@gmail.com
 * @since 1.0
 * @version 1.0 
 */
@Entity
@Table(name = "galeria")
@SequenceGenerator(name = "seq_galeria", sequenceName = "galeria_id_seq", allocationSize = 1, initialValue = 1)
public class Galeria implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "seq_galeria", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "titulo", nullable = false, length = 255)
    private String titulo;
    
    @Column(name = "slug", nullable = false, length = 255)
    private String slug;
    
    @Column(name = "descricao", nullable = false)
    private String descricao;
    
    @Column(name = "tipo_galeria", nullable = false, length = 1)
    private String tipoGaleria;
    
    @Column(name = "data_criacao", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    
    @Column(name = "data_publicacao", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPublicacao;
    
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
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "galeriaId", fetch = FetchType.LAZY)
    private List<GaleriaMidia> galeriaMidiaList;

    public Galeria() {
    }

    public Galeria(Integer id) {
        this.id = id;
    }

    public Galeria(Integer id, String titulo, String slug, String descricao, String tipoGaleria, Date dataCriacao, boolean exibirDescricao, boolean permiteComentario, boolean permitirCompartilhar) {
        this.id = id;
        this.titulo = titulo;
        this.slug = slug;
        this.descricao = descricao;
        this.tipoGaleria = tipoGaleria;
        this.dataCriacao = dataCriacao;
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

    public String getTipoGaleria() {
        return tipoGaleria;
    }

    public void setTipoGaleria(String tipoGaleria) {
        this.tipoGaleria = tipoGaleria;
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

    public List<GaleriaMidia> getGaleriaMidiaList() {
        return galeriaMidiaList;
    }

    public void setGaleriaMidiaList(List<GaleriaMidia> galeriaMidiaList) {
        this.galeriaMidiaList = galeriaMidiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Galeria)) {
            return false;
        }
        Galeria other = (Galeria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Galeria {" + "id=" + id + ", titulo=" + titulo + ", slug=" + slug + ", descricao=" + descricao + ", tipoGaleria=" + tipoGaleria + ", dataCriacao=" + dataCriacao + ", dataPublicacao=" + dataPublicacao + ", exibirDe=" + exibirDe + ", exibirAte=" + exibirAte + ", exibirDescricao=" + exibirDescricao + ", permiteComentario=" + permiteComentario + ", permitirCompartilhar=" + permitirCompartilhar + ", empresaId=" + empresaId + '}';
    }

}
