package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchExample {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver chrome = new ChromeDriver();

        try {
            // Navega até o Google
            chrome.get("https://link.devaprender.com");

            // Encontra o campo de busca e insere o termo
            WebElement searchBox = chrome.findElement(By.name("q"));
            searchBox.sendKeys("ChromeDriver");

            // Envia o formulário
            searchBox.submit();

            // Espera alguns segundos para a página carregar (não recomendado em produção)
            Thread.sleep(2000);

            // Obtém e exibe o título da página de resultados
            System.out.println("Título da página: " + chrome.getTitle());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Fecha o navegador
            chrome.quit();
        }
    }
}
