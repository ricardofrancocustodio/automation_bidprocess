package br.com.automation.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import br.com.automation.leilao.CadastroLeilaoPage;
import br.com.automation.leilao.EditLeilaoPage;
import br.com.automation.leilao.LeiloesCadastradosPage;


public class LoginPage {

	private WebDriver chrome;
	
	public LoginPage()
	{
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		
		this.chrome = new ChromeDriver();
		chrome.navigate().to("http://localhost:8080/login");
		
		
	}

	public void fechar() {
		// TODO Auto-generated method stub
		this.chrome.quit();
		
	}

	/**
	 * 
	 * 
	 * @param username
	 * @param password
	 */
	public void preencheForm(String username, String password) {
		chrome.findElement(By.name("username")).sendKeys(username);
		chrome.findElement(By.name("password")).sendKeys(password);
		
	}

	public LeiloesCadastradosPage clickButton() {
		// TODO Auto-generated method stub
		chrome.findElement(By.id("login-form")).submit();
		return new LeiloesCadastradosPage(chrome);
	}
	
	public CadastroLeilaoPage clickButton1() {
		// TODO Auto-generated method stub
		chrome.findElement(By.id("login-form")).submit();
		return new CadastroLeilaoPage(chrome);
	}
	
	public EditLeilaoPage clickButtonEdit() {
		// TODO Auto-generated method stub
		chrome.findElement(By.id("edit")).click();
		return new EditLeilaoPage(chrome);
	}


	public boolean paginaAtual() {
		// TODO Auto-generated method stub
		return chrome.getCurrentUrl().equals("http://localhost:8080/login");
	}

	public Object usuarioLogado() {
		// TODO Auto-generated method stub
		try {
			return chrome.findElement(By.id("loggeduser")).getText();
			
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			return null+" Usuário não está logado no sistema";
		}
		
	}

	public boolean errorPage() {
		// TODO Auto-generated method stub
		return chrome.getCurrentUrl().equals("http://localhost:8080/login?error");
	}

	public boolean ContainTextUsuarioESenhaInvalidos() {
		// TODO Auto-generated method stub
		return chrome.getPageSource().contains("Usuário e senha inválidos.");
	}

	public boolean loginScreenPage() {
		// TODO Auto-generated method stub
		return chrome.getPageSource().contains("Login");
	}

	public void acessoDashboard() {
		// TODO Auto-generated method stub
		this.chrome.navigate().to("http://localhost:8080/leiloes/2");
		
	}

	
}
