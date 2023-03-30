package br.com.automation.login;


//  TEST PAGE MUST NOT CONTAIN SELENIUM API. ONLY JUNIT
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class LoginTest {
	
	private LoginPage paginadelogin;
	

	@BeforeEach
	public void beforeEach()
	{
		this.paginadelogin = new LoginPage();
	}
	
	@AfterEach
	public void afterEach()
	{
		this.paginadelogin.fechar();
	}
	

	@Test
	public void LoginLeilao()
	{
		paginadelogin.preencheForm("fulano", "pass");
		paginadelogin.clickButton();
		
		//check if i'm not in the login page
		Assert.assertFalse(paginadelogin.paginaAtual());
		Assert.assertEquals("fulano", paginadelogin.usuarioLogado());
		
	}
	
	@Test
	public void naoDeveriaLogarComDadosInvalidos()
	{

		paginadelogin.preencheForm("beltrano", "123");
		paginadelogin.clickButton();
		
		//check if i'm in the login?error page
		Assert.assertTrue(paginadelogin.errorPage());
		Assert.assertTrue(paginadelogin.ContainTextUsuarioESenhaInvalidos());
		
	}
	
	
	@Test
	public void naoDeveriaAcessarPaginaRestritaSemEstarLogado()
	{
		paginadelogin.acessoDashboard();
		
		Assert.assertTrue(paginadelogin.paginaAtual());
		Assert.assertTrue(paginadelogin.loginScreenPage());
		
		
	}

}
