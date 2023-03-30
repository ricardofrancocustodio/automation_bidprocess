package br.com.automation.leilao;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.automation.login.LoginPage;

public class CadastroLeilaoTest {
	
	private CadastroLeilaoPage cadastroleilao;
	
	

	@BeforeEach
	public void beforeEach()
	{
		LoginPage paginadelogin =  new LoginPage();
		paginadelogin.preencheForm("fulano", "pass");
		this.cadastroleilao = paginadelogin.clickButton1();
	}
		
	@AfterEach
	public void afterEach()
	{
		this.cadastroleilao.fechar();
	}
	
	
	@Test
	public void createNewLeilao()
	{
		cadastroleilao.clickNovoLeilaoButton();
		cadastroleilao.cadastrarLeilao();
		cadastroleilao.clickSalvarButton();
	
		Assert.assertTrue(cadastroleilao.checkEditPageRedirection());
		Assert.assertTrue(cadastroleilao.checkLeilaoCadastrado());
		
		
	}
	
	@Test
	public void checarTodasMsgsDeTodosOsCampos()
	{
		cadastroleilao.clickNovoLeilaoButton();
		cadastroleilao.clickSalvarButton();
		
		Assert.assertTrue(cadastroleilao.getMsgCampoNomeMinimoDeCaracteres());
		Assert.assertTrue(cadastroleilao.getMsgCampoNomeNaoDeveEstarEmBranco());
		Assert.assertTrue(cadastroleilao.getMsgCampoValorInicial());
		Assert.assertTrue(cadastroleilao.getMsgCampoDataAbertura());
		
	}
	
	@Test
	public void checkNomeCampoEmBranco()
	{
		cadastroleilao.clickNovoLeilaoButton();
		cadastroleilao.insertValorInicial();
		cadastroleilao.insertDataAbertura();
		cadastroleilao.clickSalvarButton();
		
		Assert.assertTrue(cadastroleilao.getMsgCampoNomeMinimoDeCaracteres());
		Assert.assertTrue(cadastroleilao.getMsgCampoNomeNaoDeveEstarEmBranco());
	}
	
	@Test
	public void checkMinimoDeCaracteresNoCampoNome()
	{
		cadastroleilao.clickNovoLeilaoButton();
		cadastroleilao.insertTwoCharsInputNome();
		cadastroleilao.insertValorInicial();
		cadastroleilao.insertDataAbertura();
		cadastroleilao.clickSalvarButton();
		
		Assert.assertTrue(cadastroleilao.getMsgCampoNomeMinimoDeCaracteres());
	}
	
	@Test
	public void checkValidationNoCampoValorInicial()
	{
		cadastroleilao.clickNovoLeilaoButton();
		cadastroleilao.insertName();
		cadastroleilao.insertDataAbertura();
		cadastroleilao.clickSalvarButton();
		
		Assert.assertTrue(cadastroleilao.getMsgCampoValorInicial());
	}
	
	
	@Test
	public void checkValidationNoCampoDataDeAbertura()
	{
		cadastroleilao.clickNovoLeilaoButton();
		cadastroleilao.insertName();
		cadastroleilao.clickSalvarButton();
		
		Assert.assertTrue(cadastroleilao.getMsgCampoDataAbertura());
	}


}
