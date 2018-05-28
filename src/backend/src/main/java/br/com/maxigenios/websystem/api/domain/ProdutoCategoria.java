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
 * <p>Product X Category Entity</p>
 * 
 * @author Leandro Severino - lseverino@gmail.com
 * @since 1.0
 * @version 1.0 
 */
@Entity
@Table(name = "produto_categoria")
public class ProdutoCategoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected ProdutoCategoriaPK produtoCategoriaPK;

    @Column(name = "empresa_id", nullable = false)
    private int empresaId;

    @JoinColumn(name = "categoria_produto_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CategoriaProduto categoriaProduto;

    @JoinColumn(name = "produto_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produto produto;

    public ProdutoCategoria() {
    }

    public ProdutoCategoria(ProdutoCategoriaPK produtoCategoriaPK) {
        this.produtoCategoriaPK = produtoCategoriaPK;
    }

    public ProdutoCategoria(ProdutoCategoriaPK produtoCategoriaPK, int empresaId) {
        this.produtoCategoriaPK = produtoCategoriaPK;
        this.empresaId = empresaId;
    }

    public ProdutoCategoria(int produtoId, int categoriaProdutoId) {
        this.produtoCategoriaPK = new ProdutoCategoriaPK(produtoId, categoriaProdutoId);
    }

    public ProdutoCategoriaPK getProdutoCategoriaPK() {
        return produtoCategoriaPK;
    }

    public void setProdutoCategoriaPK(ProdutoCategoriaPK produtoCategoriaPK) {
        this.produtoCategoriaPK = produtoCategoriaPK;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    public CategoriaProduto getCategoriaProduto() {
        return categoriaProduto;
    }

    public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (produtoCategoriaPK != null ? produtoCategoriaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ProdutoCategoria)) {
            return false;
        }
        ProdutoCategoria other = (ProdutoCategoria) object;
        if ((this.produtoCategoriaPK == null && other.produtoCategoriaPK != null) || (this.produtoCategoriaPK != null && !this.produtoCategoriaPK.equals(other.produtoCategoriaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProdutoCategoria {" + "produtoCategoriaPK=" + produtoCategoriaPK + ", empresaId=" + empresaId + ", categoriaProduto=" + categoriaProduto + ", produto=" + produto + '}';
    }
    
}
