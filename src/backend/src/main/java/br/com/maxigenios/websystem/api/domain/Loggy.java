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
 * <p>Log Entity</p>
 * 
 * @author Leandro Severino - lseverino@gmail.com
 * @since 1.0
 * @version 1.0 
 */
@Entity
@Table(name = "loggy")
@SequenceGenerator(name = "seq_loggy", sequenceName = "loggy_id_seq", allocationSize = 1, initialValue = 1)
public class Loggy implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "seq_loggy", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "data_hora", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;

    @Column(name = "ip", nullable = false, length = 255)
    private String ip;

    @Column(name = "tipo_acao", nullable = false, length = 2)
    private String tipoAcao;

    @Column(name = "url_acessada", nullable = false, length = 255)
    private String urlAcessada;

    @Column(name = "valores_originais", nullable = true, length = 255)
    private String valoresOriginais;

    @Column(name = "valores_alterados", nullable = true, length = 255)
    private String valoresAlterados;

    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AuthUser usuarioId;

    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empresa empresaId;

    public Loggy() {
    }

    public Loggy(Integer id) {
        this.id = id;
    }

    public Loggy(Integer id, Date dataHora, String ip, String tipoAcao, String urlAcessada) {
        this.id = id;
        this.dataHora = dataHora;
        this.ip = ip;
        this.tipoAcao = tipoAcao;
        this.urlAcessada = urlAcessada;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTipoAcao() {
        return tipoAcao;
    }

    public void setTipoAcao(String tipoAcao) {
        this.tipoAcao = tipoAcao;
    }

    public String getUrlAcessada() {
        return urlAcessada;
    }

    public void setUrlAcessada(String urlAcessada) {
        this.urlAcessada = urlAcessada;
    }

    public String getValoresOriginais() {
        return valoresOriginais;
    }

    public void setValoresOriginais(String valoresOriginais) {
        this.valoresOriginais = valoresOriginais;
    }

    public String getValoresAlterados() {
        return valoresAlterados;
    }

    public void setValoresAlterados(String valoresAlterados) {
        this.valoresAlterados = valoresAlterados;
    }

    public AuthUser getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(AuthUser usuarioId) {
        this.usuarioId = usuarioId;
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
        if (!(object instanceof Loggy)) {
            return false;
        }
        Loggy other = (Loggy) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Loggy {" + "id=" + id + ", dataHora=" + dataHora + ", ip=" + ip + ", tipoAcao=" + tipoAcao + ", urlAcessada=" + urlAcessada + ", valoresOriginais=" + valoresOriginais + ", valoresAlterados=" + valoresAlterados + ", usuarioId=" + usuarioId + ", empresaId=" + empresaId + '}';
    }
    
}
