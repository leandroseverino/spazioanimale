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
import java.util.Date;
import java.util.List;

/**
 * <p>Company Entity</p>
 * 
 * @author Leandro Severino - lseverino@gmail.com
 * @since 1.0
 * @version 1.0 
 */
@Entity
@Table(name = "empresa")
@SequenceGenerator(name = "seq_empresa", sequenceName = "empresa_id_seq", allocationSize = 1, initialValue = 1)
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "seq_empresa", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "titulo", nullable = false, length = 255)
    private String titulo;
    
    @Column(name = "slug", nullable = false, length = 255)
    private String slug;
    
    @Column(name = "descricao", nullable = false)
    private String descricao;
    
    @Column(name = "data_cadastro", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    
    @Column(name = "ativa", nullable = false)
    private boolean ativa;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaId", fetch = FetchType.LAZY)
    private List<AuthGroup> authGroupList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaId", fetch = FetchType.LAZY)
    private List<TipoPublicacao> tipoPublicacaoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaId", fetch = FetchType.LAZY)
    private List<Mensagem> mensagemList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaId", fetch = FetchType.LAZY)
    private List<Parametro> parametroList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaId", fetch = FetchType.LAZY)
    private List<AuthPermission> authPermissionList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaId", fetch = FetchType.LAZY)
    private List<AuthGroupPermissions> authGroupPermissionsList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaId", fetch = FetchType.LAZY)
    private List<CategoriaProduto> categoriaProdutoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaId", fetch = FetchType.LAZY)
    private List<Profissional> profissionalList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaId", fetch = FetchType.LAZY)
    private List<Loggy> loggyList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaId", fetch = FetchType.LAZY)
    private List<AuthUser> authUserList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaId", fetch = FetchType.LAZY)
    private List<AuthUserGroups> authUserGroupsList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaId", fetch = FetchType.LAZY)
    private List<Galeria> galeriaList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaId", fetch = FetchType.LAZY)
    private List<AuthUserUserPermissions> authUserUserPermissionsList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaId", fetch = FetchType.LAZY)
    private List<GaleriaMidia> galeriaMidiaList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaId", fetch = FetchType.LAZY)
    private List<Endereco> enderecoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaId", fetch = FetchType.LAZY)
    private List<Especialidade> especialidadeList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaId", fetch = FetchType.LAZY)
    private List<Banner> bannerList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaId", fetch = FetchType.LAZY)
    private List<Menu> menuList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaId", fetch = FetchType.LAZY)
    private List<Publicacao> publicacaoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.LAZY)
    private List<EmpresaModulo> empresaModuloList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaId", fetch = FetchType.LAZY)
    private List<Produto> produtoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaId", fetch = FetchType.LAZY)
    private List<Servico> servicoList;

    public Empresa() {
    }

    public Empresa(Integer id) {
        this.id = id;
    }

    public Empresa(Integer id, String titulo, String slug, String descricao, Date dataCadastro, boolean ativa) {
        this.id = id;
        this.titulo = titulo;
        this.slug = slug;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
        this.ativa = ativa;
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

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public List<AuthGroup> getAuthGroupList() {
        return authGroupList;
    }

    public void setAuthGroupList(List<AuthGroup> authGroupList) {
        this.authGroupList = authGroupList;
    }

    public List<TipoPublicacao> getTipoPublicacaoList() {
        return tipoPublicacaoList;
    }

    public void setTipoPublicacaoList(List<TipoPublicacao> tipoPublicacaoList) {
        this.tipoPublicacaoList = tipoPublicacaoList;
    }

    public List<Mensagem> getMensagemList() {
        return mensagemList;
    }

    public void setMensagemList(List<Mensagem> mensagemList) {
        this.mensagemList = mensagemList;
    }

    public List<Parametro> getParametroList() {
        return parametroList;
    }

    public void setParametroList(List<Parametro> parametroList) {
        this.parametroList = parametroList;
    }

    public List<AuthPermission> getAuthPermissionList() {
        return authPermissionList;
    }

    public void setAuthPermissionList(List<AuthPermission> authPermissionList) {
        this.authPermissionList = authPermissionList;
    }

    public List<AuthGroupPermissions> getAuthGroupPermissionsList() {
        return authGroupPermissionsList;
    }

    public void setAuthGroupPermissionsList(List<AuthGroupPermissions> authGroupPermissionsList) {
        this.authGroupPermissionsList = authGroupPermissionsList;
    }

    public List<CategoriaProduto> getCategoriaProdutoList() {
        return categoriaProdutoList;
    }

    public void setCategoriaProdutoList(List<CategoriaProduto> categoriaProdutoList) {
        this.categoriaProdutoList = categoriaProdutoList;
    }

    public List<Profissional> getProfissionalList() {
        return profissionalList;
    }

    public void setProfissionalList(List<Profissional> profissionalList) {
        this.profissionalList = profissionalList;
    }

    public List<Loggy> getLoggyList() {
        return loggyList;
    }

    public void setLoggyList(List<Loggy> loggyList) {
        this.loggyList = loggyList;
    }

    public List<AuthUser> getAuthUserList() {
        return authUserList;
    }

    public void setAuthUserList(List<AuthUser> authUserList) {
        this.authUserList = authUserList;
    }

    public List<AuthUserGroups> getAuthUserGroupsList() {
        return authUserGroupsList;
    }

    public void setAuthUserGroupsList(List<AuthUserGroups> authUserGroupsList) {
        this.authUserGroupsList = authUserGroupsList;
    }

    public List<Galeria> getGaleriaList() {
        return galeriaList;
    }

    public void setGaleriaList(List<Galeria> galeriaList) {
        this.galeriaList = galeriaList;
    }

    public List<AuthUserUserPermissions> getAuthUserUserPermissionsList() {
        return authUserUserPermissionsList;
    }

    public void setAuthUserUserPermissionsList(List<AuthUserUserPermissions> authUserUserPermissionsList) {
        this.authUserUserPermissionsList = authUserUserPermissionsList;
    }

    public List<GaleriaMidia> getGaleriaMidiaList() {
        return galeriaMidiaList;
    }

    public void setGaleriaMidiaList(List<GaleriaMidia> galeriaMidiaList) {
        this.galeriaMidiaList = galeriaMidiaList;
    }

    public List<Endereco> getEnderecoList() {
        return enderecoList;
    }

    public void setEnderecoList(List<Endereco> enderecoList) {
        this.enderecoList = enderecoList;
    }

    public List<Especialidade> getEspecialidadeList() {
        return especialidadeList;
    }

    public void setEspecialidadeList(List<Especialidade> especialidadeList) {
        this.especialidadeList = especialidadeList;
    }

    public List<Banner> getBannerList() {
        return bannerList;
    }

    public void setBannerList(List<Banner> bannerList) {
        this.bannerList = bannerList;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public List<Publicacao> getPublicacaoList() {
        return publicacaoList;
    }

    public void setPublicacaoList(List<Publicacao> publicacaoList) {
        this.publicacaoList = publicacaoList;
    }

    public List<EmpresaModulo> getEmpresaModuloList() {
        return empresaModuloList;
    }

    public void setEmpresaModuloList(List<EmpresaModulo> empresaModuloList) {
        this.empresaModuloList = empresaModuloList;
    }

    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    public List<Servico> getServicoList() {
        return servicoList;
    }

    public void setServicoList(List<Servico> servicoList) {
        this.servicoList = servicoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Empresa {" + "id=" + id + ", titulo=" + titulo + ", slug=" + slug + ", descricao=" + descricao + ", dataCadastro=" + dataCadastro + ", ativa=" + ativa + '}';
    }
    
}
