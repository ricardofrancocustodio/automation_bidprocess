package br.com.automation.leilao;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.automation.login.LoginPage;

public class LeiloesCadastradosTest {

	private LeiloesCadastradosPage leiloescadastrados;
	
	

	@BeforeEach
	public void beforeEach()
	{
		LoginPage paginadelogin =  new LoginPage();
		paginadelogin.preencheForm("fulano", "pass");
		this.leiloescadastrados = paginadelogin.clickButton();
	}
		
	@AfterEach
	public void afterEach()
	{
		this.leiloescadastrados.fechar();
	}
	

	@Test
	public void clickNovoLeilaoButton()
	{
		leiloescadastrados.clickNovoLeilaoButton();
	
		Assert.assertTrue(leiloescadastrados.urlNovoLeilaoPage());
		
	}
	
	@Test
	public void clickEditarButton() 
	{
		leiloescadastrados.clickEditarButton();
		
		Assert.assertNotNull(leiloescadastrados.checkEmptyInputs());
	}
	
	@Test
	public void clickDaLanceButton() 
	{
		leiloescadastrados.clickDarLanceButton();
		
		Assert.assertTrue(leiloescadastrados.containTextDadosDoLeilao());
	}
	
	
	
	
	
}
