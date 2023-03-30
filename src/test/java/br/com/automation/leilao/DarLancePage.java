package br.com.automation.leilao;

import org.openqa.selenium.WebDriver;

public class DarLancePage {

	

	private WebDriver chrome;
		
		public DarLancePage(WebDriver chrome)
		{
			this.chrome = chrome;
		}

		// go to backgroundSteps
		public void fechar() {
			this.chrome.quit();
			
		}
		
}
