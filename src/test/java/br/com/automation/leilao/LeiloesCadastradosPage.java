package br.com.automation.leilao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LeiloesCadastradosPage {

	private WebDriver chrome;
	
	private static final String URL_NOVO_LEILAO = "http://localhost:8080/leiloes/new";
	
	
	public LeiloesCadastradosPage(WebDriver chrome)
	{
		this.chrome = chrome;
	}


	public void fechar() {
		this.chrome.quit();
		
	}
	
	
	/**
	 * @return Edit Leilão Page Object
	 */
	public EditLeilaoPage clickEditarButton() {
		chrome.findElement(By.id("edit")).click();
		return new EditLeilaoPage(chrome);
	}
	
	
	/**
	 * @return Register New Leilão Page Object
	 */
	public CadastroLeilaoPage clickNovoLeilaoButton() {
		chrome.findElement(By.id("novo_leilao_link")).click();
		return new CadastroLeilaoPage(chrome);
	}

	
	/**
	 * @return Dar Lance Page Object
	 */
	public DarLancePage clickDarLanceButton() {
		chrome.findElement(By.id("darlance")).click();
		return new DarLancePage(chrome);
	}


	public boolean containTextLeiloesCadastrados() {
		return chrome.getPageSource().contains("Leilões cadastrados");
	}
	
	public boolean containTextDadosDoLeilao() {
		return chrome.getPageSource().contains("Dados do Leilão");
	}
		

	public boolean urlNovoLeilaoPage() {		
		return chrome.getCurrentUrl().equals(URL_NOVO_LEILAO);
	}
	
	public EditLeilaoPage checkEmptyInputs() {	
		
		 String name = chrome.findElement(By.id("nome")).getText();
		 	
		 	if (!name.isBlank()) {
		 		return null;
		 	}
		 		
		 	 return new EditLeilaoPage(chrome);	
	}
	
	
	


	
}
