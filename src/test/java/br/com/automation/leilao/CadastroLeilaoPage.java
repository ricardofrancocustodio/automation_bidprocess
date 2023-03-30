package br.com.automation.leilao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CadastroLeilaoPage {
	
	private WebDriver chrome;
	private static final String URL_NOVO_LEILAO = "http://localhost:8080/leiloes/new";
	private static final String URL_EDIT_PAGE = "http://localhost:8080/leiloes";
	
	String nome	 = "Novo Leilao Teste 1";
	String valorInicial = "700.00";
	String dataAbertura = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	
	
	public CadastroLeilaoPage(WebDriver chrome)
	{
		this.chrome = chrome;
	}

	public void fechar() 
	{
		this.chrome.quit();
	}
	
	
	public boolean urlNovoLeilaoPage() {		
		return chrome.getCurrentUrl().equals(URL_NOVO_LEILAO);
	}
	
	
	public boolean checkTitleNameLabel()
	{
		return chrome.findElement(By.xpath("//label[contains(text(),'nome')]")).isDisplayed();
	}
	
	public boolean checkInputBoxName()
	{
		return chrome.findElement(By.id("nome")).isDisplayed();
	}
	

	public boolean checkLabelValorInicial()
	{
		//return chrome.findElement(By.xpath("//label[contains(text(),'')]")).isDisplayed();
		return chrome.findElement(By.xpath("label[@for='valorInicial']")).isDisplayed();
		
	}
	
	public boolean checkInputBoxValorInicial()
	{
		return chrome.findElement(By.id("valorInicial")).isDisplayed();
	}
	
	
	public boolean checkLabelDataAbertura()
	{
		//return chrome.findElement(By.xpath("//label[contains(text(),'dataAbertura')]")).isDisplayed();
		return chrome.findElement(By.xpath("label[@for='dataAbertura']")).isDisplayed();
	}
	
	public boolean checkInputBoxDataAbertura()
	{
		return chrome.findElement(By.name("dataAbertura")).isDisplayed();
	}
	
	
	public boolean checkLabelUsuario()
	{
		//return chrome.findElement(By.xpath("//value[contains(text(),'fulano')]")).isDisplayed();
		return chrome.findElement(By.xpath("label[@for='usuario']")).isDisplayed();
	}
	
	public boolean checkInputBoxUsuario()
	{
		return chrome.findElement(By.id("usuario")).isEnabled();
	}
	

	public boolean checkButtonSalvar()
	{
		return chrome.findElement(By.id("button-submit")).isEnabled();
	}
	

	public boolean checkButtonVoltar()
	{
		return chrome.findElement(By.xpath("a[@class='btn btn-primary mt-2']")).isDisplayed();
	}
	
	
	public CadastroLeilaoPage clickNovoLeilaoButton() {
		chrome.findElement(By.id("novo_leilao_link")).click();
		return new CadastroLeilaoPage(chrome);
	}
	
	//send data to fill the form 
	public void cadastrarLeilao() 
	{
				
		chrome.findElement(By.id("nome")).sendKeys(nome);
		chrome.findElement(By.id("valorInicial")).sendKeys(valorInicial);
		chrome.findElement(By.id("dataAbertura")).sendKeys(dataAbertura);		
		
	}
	
	
	public void clickSalvarButton()
	{
		chrome.findElement(By.id("button-submit")).click();
	}
	
	
	public boolean checkEditPageRedirection()
	{
		return chrome.getCurrentUrl().equals(URL_EDIT_PAGE);
	}
	
	public boolean checkLeilaoCadastrado()
	{
		//get each cell of last row
		String primeiraCelUltimaLinhaDaTabela = chrome.findElement(By.cssSelector("#tabela-leilao > tbody > tr:last-child > td:nth-child(1)")).getText();
		String segundaCelUltimaLinhaDaTabela = chrome.findElement(By.cssSelector("#tabela-leilao > tbody > tr:last-child > td:nth-child(2)")).getText();
		String terceiraCelUltimaLinhaDaTabela = chrome.findElement(By.cssSelector("#tabela-leilao > tbody > tr:last-child > td:nth-child(3)")).getText();
		
		return primeiraCelUltimaLinhaDaTabela.equals(nome) 
				&& segundaCelUltimaLinhaDaTabela.equals(dataAbertura) 
				&& terceiraCelUltimaLinhaDaTabela.equals(valorInicial);
	}
	
	public void insertName()
	{
		chrome.findElement(By.id("nome")).sendKeys("Novo Leilão 2");
	}
	
	public void insertTwoCharsInputNome()
	{
		chrome.findElement(By.id("nome")).sendKeys("ab");
	}
	
	
	public void insertValorInicial()
	{
		chrome.findElement(By.id("valorInicial")).sendKeys("800.00");
	}
	
	public void insertDataAbertura()
	{
		chrome.findElement(By.id("dataAbertura")).sendKeys("19/10/2021");
	}
	
	
	public boolean getMsgCampoNomeMinimoDeCaracteres()
	{
		return chrome.getPageSource().contains("minimo 3 caracteres");
	}
	
	
	public boolean getMsgCampoNomeNaoDeveEstarEmBranco()
	{
		return chrome.getPageSource().contains("não deve estar em branco");
	}
	
	public boolean getMsgCampoValorInicial()
	{
		return chrome.getPageSource().contains("deve ser um valor maior de 0.1");
	}
	
	public boolean getMsgCampoDataAbertura()
	{
		return chrome.getPageSource().contains("deve ser uma data no formato dd/MM/yyyy");
	}
	
	
	
	
}
