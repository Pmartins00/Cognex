package br.com.cognex.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.cognex.model.Configuracao;

@RequestScoped
@ManagedBean(name="configuracaoBean")
public class ConfiguracaoBean {
	
	private Configuracao configuracao;
	
	public ConfiguracaoBean() {
		this.configuracao = new Configuracao();
		this.configuracao.setAtivo(true);
	}

	public Configuracao getConfiguracao() {
		return this.configuracao;
	}

}
