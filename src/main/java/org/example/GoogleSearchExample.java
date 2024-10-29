package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleSearchExample {
    public static void main(String[] args) {

        int err = 0;

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

            // Espera alguns segundos para a página carregar
            Thread.sleep(5000);

            // Obtém e exibe o título da página de resultados
            System.out.println("Título da página: " + chrome.getTitle());

            // Limpa o campo de busca e realiza a segunda pesquisa
            searchBox = chrome.findElement(By.name("q")); // Atualiza o campo de busca
            searchBox.clear();
            searchBox.sendKeys("Selenium");
            searchBox.submit();

            // Espera novamente para a página de resultados carregar
            Thread.sleep(5000);

            // Clica no link do site Selenium na página de resultados
            WebElement seleniumLink = chrome.findElement(By.partialLinkText("selenium.dev"));
            seleniumLink.click();

            // Aguarda o carregamento do site
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            err = 1;
            e.printStackTrace();
        } finally {
            // Fecha o navegador
            if (err == 0) {
                System.out.println("Sucesso!");
                chrome.quit();
            } else {
                System.out.println("Erro!");
            }

        }
    }
}
