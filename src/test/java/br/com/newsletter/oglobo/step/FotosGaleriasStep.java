package br.com.newsletter.oglobo.step;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.newsletter.oglobo.factory.DriverFactory;
import br.com.newsletter.oglobo.pages.FotosGaleriasPage;
import br.com.newsletter.oglobo.urls.Urls;
import br.com.newsletter.oglobo.utils.Browsers;
import br.com.newsletter.oglobo.utils.SeleniumRobot;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class FotosGaleriasStep {

	private WebDriver driver;
	private FotosGaleriasPage fotoGalerias;
	private int fotos;

	@Dado("^que eu estiver na fotogalerias$")
	public void queEuEstiverNaFotogalerias() throws Throwable {
		driver = DriverFactory.iniDriver(Browsers.Chrome);
		this.fotoGalerias = new FotosGaleriasPage(driver);
		driver.get(Urls.FOTOGALERIASMOBILE);
		SeleniumRobot.implicitlyWait(fotoGalerias.getPopUp());
		fotoGalerias.getOpcaoNao().click();
	}

	@Quando("^eu ir ate a secao recomendadas$")
	public void euIrAteASecaoRecomendadas() throws Throwable {
		SeleniumRobot.scroll(500);
		this.fotoGalerias.getGaleriaFotos().forEach(titule -> {
			WebElement texto = titule.findElement(By.cssSelector(".title"));
			assertTrue("RECOMENDADAS".equals(texto.getText()));
		});
	}

	@Entao("^devo visualizar (\\d+) fotos na secao \"([^\"]*)\"$")
	public void devoVisualizarFotosNaSecao(int quantidadeFotos, String secao) throws Throwable {
		switch (secao) {
		case "recomendadas":
			this.fotoGalerias.getGaleriaFotos().forEach(imagens -> {
				for (int i = 1; i <= quantidadeFotos; i++) {
					WebElement img = imagens
							.findElement(By.cssSelector(".recommended li:nth-child(" + i + ") > a > img"));
					assertNotNull(img.getAttribute("src"));
					fotos += 1;
				}

			});
			break;
		case "mais vistas":
			this.fotoGalerias.getGaleriaFotos().forEach(imagens -> {
				for (int i = 1; i <= quantidadeFotos; i++) {
					WebElement img = imagens
							.findElement(By.cssSelector(".recommended li:nth-child(" + i + ") > a > img"));
					assertNotNull(img.getAttribute("src"));
					fotos += 1;
				}

			});
			break;
		default:
			break;
		}

		assertTrue(fotos == quantidadeFotos);
	}

	@Quando("^eu ir ate a secao mais vistas$")
	public void euIrAteASecaoMaisVistas() throws Throwable {
		SeleniumRobot.scroll(900);
		this.fotoGalerias.getGaleriaFotos().forEach(titule -> {
			WebElement texto = titule.findElement(By.cssSelector(".popular .title"));
			assertTrue("MAIS VISTAS".equals(texto.getText()));
		});
	}

	@Quando("^eu ir ate a secao ultimas de$")
	public void euIrAteASecaoUltimasDe() throws Throwable {
		SeleniumRobot.scroll(1500);
	}

	@Quando("^selecionar uma \"([^\"]*)\"$")
	public void selecionarUma(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^devo visualizar (\\d+) fotos por titulo$")
	public void devoVisualizarFotosPorTitulo(int arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@After
	public void close() {
		driver.quit();
	}
}
