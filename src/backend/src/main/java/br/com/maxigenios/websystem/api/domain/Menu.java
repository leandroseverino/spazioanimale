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

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * <p>Menu Entity</p>
 * 
 * @author Leandro Severino - lseverino@gmail.com
 * @since 1.0
 * @version 1.0 
 */
@Entity
@Table(name = "menu")
@SequenceGenerator(name = "seq_menu", sequenceName = "menu_id_seq", allocationSize = 1, initialValue = 1)
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "seq_menu", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "titulo", nullable = false, length = 255)
    private String titulo;

    @Column(name = "slug", nullable = false, length = 255)
    private String slug;

    @Column(name = "ordem_exibicao", nullable = false)
    private int ordemExibicao;

    @Column(name = "nivel_menu", nullable = false)
    private int nivelMenu;

    @Column(name = "tipo_publicacao", nullable = false, length = 1)
    private String tipoPublicacao;

    @Column(name = "restrito", nullable = false)
    private boolean restrito;

    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empresa empresaId;

    @OneToMany(mappedBy = "menuPaiId", fetch = FetchType.LAZY)
    private List<Menu> menuList;

    @JoinColumn(name = "menu_pai_id", referencedColumnName = "id", nullable = true)
    @ManyToOne
    private Menu menuPaiId;

    public Menu() {
    }

    public Menu(Integer id) {
        this.id = id;
    }

    public Menu(Integer id, String titulo, String slug, int ordemExibicao, int nivelMenu, String tipoPublicacao, boolean restrito) {
        this.id = id;
        this.titulo = titulo;
        this.slug = slug;
        this.ordemExibicao = ordemExibicao;
        this.nivelMenu = nivelMenu;
        this.tipoPublicacao = tipoPublicacao;
        this.restrito = restrito;
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

    public int getOrdemExibicao() {
        return ordemExibicao;
    }

    public void setOrdemExibicao(int ordemExibicao) {
        this.ordemExibicao = ordemExibicao;
    }

    public int getNivelMenu() {
        return nivelMenu;
    }

    public void setNivelMenu(int nivelMenu) {
        this.nivelMenu = nivelMenu;
    }

    public String getTipoPublicacao() {
        return tipoPublicacao;
    }

    public void setTipoPublicacao(String tipoPublicacao) {
        this.tipoPublicacao = tipoPublicacao;
    }

    public boolean getRestrito() {
        return restrito;
    }

    public void setRestrito(boolean restrito) {
        this.restrito = restrito;
    }

    public Empresa getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Empresa empresaId) {
        this.empresaId = empresaId;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public Menu getMenuPaiId() {
        return menuPaiId;
    }

    public void setMenuPaiId(Menu menuPaiId) {
        this.menuPaiId = menuPaiId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Menu {" + "id=" + id + ", titulo=" + titulo + ", slug=" + slug + ", ordemExibicao=" + ordemExibicao + ", nivelMenu=" + nivelMenu + ", tipoPublicacao=" + tipoPublicacao + ", restrito=" + restrito + ", empresaId=" + empresaId + ", menuPaiId=" + menuPaiId + '}';
    }
    
}
