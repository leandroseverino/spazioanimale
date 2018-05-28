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
 * <p>Product X Category PK</p>
 * 
 * @author Leandro Severino - lseverino@gmail.com
 * @since 1.0
 * @version 1.0 
 */
@Embeddable
public class ProdutoCategoriaPK implements Serializable {

    @Column(name = "produto_id", nullable = false)
    private int produtoId;
    
    @Column(name = "categoria_produto_id", nullable = false)
    private int categoriaProdutoId;

    public ProdutoCategoriaPK() {
    }

    public ProdutoCategoriaPK(int produtoId, int categoriaProdutoId) {
        this.produtoId = produtoId;
        this.categoriaProdutoId = categoriaProdutoId;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public int getCategoriaProdutoId() {
        return categoriaProdutoId;
    }

    public void setCategoriaProdutoId(int categoriaProdutoId) {
        this.categoriaProdutoId = categoriaProdutoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) produtoId;
        hash += (int) categoriaProdutoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ProdutoCategoriaPK)) {
            return false;
        }
        ProdutoCategoriaPK other = (ProdutoCategoriaPK) object;
        if (this.produtoId != other.produtoId) {
            return false;
        }
        if (this.categoriaProdutoId != other.categoriaProdutoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProdutoCategoriaPK{" + "produtoId=" + produtoId + ", categoriaProdutoId=" + categoriaProdutoId + '}';
    }    
    
}
