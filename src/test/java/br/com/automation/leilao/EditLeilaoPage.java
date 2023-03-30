package br.com.automation.leilao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditLeilaoPage {
	
	
	private WebDriver chrome;
		
		public EditLeilaoPage(WebDriver chrome){
			this.chrome = chrome;
		}

		// go to backgroundSteps
		public void fechar() {
			this.chrome.quit();
		}
		
		public boolean checkLabelNome() {
			return chrome.findElement(By.xpath("//label[@for='nome']")).isDisplayed();
		}
		
		public boolean checkLabelValorInicial() {
			return  chrome.findElement(By.xpath("//label[@for='valorInicial']")).isDisplayed();
		}
		
		public boolean checkLabelDataAbertura() {
			return  chrome.findElement(By.xpath("//label[@for='dataAbertura']")).isDisplayed();
		}
		
		public boolean checkLabelUsuario() {
			return  chrome.findElement(By.xpath("//label[@for='usuario']")).isDisplayed();
		}
		
		public boolean checkLabelBotaoSalvar() {
			 return chrome.findElement(By.xpath("//label[@for='button-submit']")).isDisplayed();
		}
		
		public boolean checkLabelBotaoVoltar() {
			return  chrome.findElement(By.xpath("//label[@for='button-back']")).isDisplayed();
		}
		
		public boolean checkNotEmptyInput() {
			WebElement checkInputName = chrome.findElement(By.id("nome"));
			String textInsideInputName = checkInputName.getAttribute("value");
			
			//Assert true
			return !textInsideInputName.isEmpty();
			
		}
		
		public void editInputName(String data) {
			chrome.findElement(By.id("nome")).sendKeys(data);	
		}
		
		public void editInputValorInicial(String data) {
			chrome.findElement(By.id("valorInicial")).sendKeys(data);	
		}
		
		public void editInputDtaAbertura(String data) {
			chrome.findElement(By.id("dataAbertura")).sendKeys(data);	
		}
		
		public LeiloesCadastradosPage clickSalvarButton() {
			chrome.findElement(By.id("button-submit")).click();
			return new LeiloesCadastradosPage(chrome);
		}
		
		public void clickVoltarbutton() {
			chrome.findElement(By.id("button-back")).click();
		}

}
		
