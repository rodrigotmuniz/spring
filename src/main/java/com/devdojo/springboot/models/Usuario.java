/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devdojo.springboot.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author breno.melo
 */
@Entity
@Table(name = "usuarios", schema = "sigtel")
public class Usuario extends AbstractEntity { 

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String senha;
    @Temporal(TemporalType.TIMESTAMP)
    private Date alteracao;
    @Column(name = "ultimo_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimoLogin;
    @Temporal(TemporalType.TIMESTAMP)
    private Date inclusao;
    private Boolean ativo;
    @Column(name = "acesso_sigtel", columnDefinition = "boolean DEFAULT FALSE")
    private Boolean acessoSigtel;
    
    @Column(name = "acesso_exclusivo_sigtel")
    private Boolean acessoExclusivoSigtel;
    
    @Column(name = "chave_acesso")
    private String chaveAcesso;
    

    public Usuario() {
    }

    public Usuario(Long id) {
        this.id = id;
    }

    public Usuario(Long id, String nome, String senha, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.ativo = ativo;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getAlteracao() {
        return alteracao;
    }

    public void setAlteracao(Date alteracao) {
        this.alteracao = alteracao;
    }

    public Date getInclusao() {
        return inclusao;
    }

    public void setInclusao(Date inclusao) {
        this.inclusao = inclusao;
    }

    public Boolean getAtivo() {
        return ativo;
    }
    public Boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        Integer hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return "br.ufmg.hc.sigtel.entidades.Usuarios[ id=" + id + " ]";
    }


    public Date getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(Date ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    public Boolean getAcessoSigtel() {
        return acessoSigtel;
    }

    public void setAcessoSigtel(Boolean acessoSigtel) {
        this.acessoSigtel = acessoSigtel;
    }

    public Boolean getAcessoExclusivoSigtel() {
        return acessoExclusivoSigtel;
    }

    public void setAcessoExclusivoSigtel(Boolean acessoExclusivoSigtel) {
        this.acessoExclusivoSigtel = acessoExclusivoSigtel;
    }

    public String getChaveAcesso() {
        return chaveAcesso;
    }

    public void setChaveAcesso(String chaveAcesso) {
        this.chaveAcesso = chaveAcesso;
    }

}