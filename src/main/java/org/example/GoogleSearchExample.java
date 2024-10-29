package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleSearchExample {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver chrome = new ChromeDriver(options);

        try {
            // Navega até o Google
            chrome.get("https://www.google.com.br");

            // Encontra o campo de busca e insere o termo
            WebElement searchBox = chrome.findElement(By.name("q"));
            searchBox.sendKeys("Melhor aula de terça");

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
            System.out.println("Deu bom");
        }
    }
}
