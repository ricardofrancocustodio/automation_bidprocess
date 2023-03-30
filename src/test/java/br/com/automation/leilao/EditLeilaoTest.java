package br.com.automation.leilao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.automation.login.LoginPage;

public class EditLeilaoTest {
	
	private EditLeilaoPage editleilaopage;

	
	@BeforeEach
	public void beforeEach()
	{
		LoginPage paginadelogin =  new LoginPage();
		paginadelogin.preencheForm("fulano", "pass");
		paginadelogin.clickButton();
		paginadelogin.clickButtonEdit();
	}
		
	@AfterEach
	public void afterEach()	{
		this.editleilaopage.fechar();
	}
	
	
	@Test
	public void editCompleteForm() {
		editleilaopage.editInputName("");
		editleilaopage.editInputValorInicial("");
		editleilaopage.editInputDtaAbertura("");
		editleilaopage.clickSalvarButton();
		
	}

}
