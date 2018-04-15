package br.com.newsletter.oglobo.step;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import br.com.newsletter.oglobo.factory.DriverFactory;
import br.com.newsletter.oglobo.pages.FotosGaleriasPage;
import br.com.newsletter.oglobo.urls.Urls;
import br.com.newsletter.oglobo.utils.Browsers;
import br.com.newsletter.oglobo.utils.SeleniumRobot;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class FotosGaleriasStep {

	private WebDriver driver;
	private FotosGaleriasPage fotoGalerias;
	private int fotos;
	
	@Before
	public void initTest() throws IOException {
		driver = DriverFactory.iniDriver(Browsers.Chrome);
		driver.get(Urls.FOTOGALERIASMOBILE);
		this.fotoGalerias = new FotosGaleriasPage(driver);
	}

	@Dado("^que eu estiver na fotogalerias$")
	public void queEuEstiverNaFotogalerias() {
		SeleniumRobot.implicitlyWait(fotoGalerias.getPopUp());
		fotoGalerias.getOpcaoNao().click();
		assertTrue(driver.getCurrentUrl().equals(Urls.FOTOGALERIASMOBILE));
	}

	@Quando("^eu ir ate a secao recomendadas$")
	public void euIrAteASecaoRecomendadas() throws Throwable {
		SeleniumRobot.scroll(500);
		SeleniumRobot.explicitWait(fotoGalerias.getGaleriaFotos().get(0));
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
		SeleniumRobot.explicitWait(fotoGalerias.getFotosPopular().get(0));
		this.fotoGalerias.getGaleriaFotos().forEach(titulo -> {
			WebElement texto = titulo.findElement(By.cssSelector(".popular .title"));
			assertTrue("MAIS VISTAS".equals(texto.getText()));
		});
	}

	@Quando("^eu ir ate a secao ultimas de$")
	public void euIrAteASecaoUltimasDe() throws Throwable {
		SeleniumRobot.scroll(1500);
		SeleniumRobot.explicitWait(fotoGalerias.getUltimasDe().get(0));
		this.fotoGalerias.getUltimasDe().forEach(titulo -> {
			WebElement texto = titulo.findElement(By.cssSelector("#lastFrom .title"));
			assertTrue("ULTIMAS DE".equals(texto.getText()));
		});
	}

	@Quando("^selecionar uma \"([^\"]*)\"$")
	public void selecionarUma(String opcao) throws Throwable {

		Select selecionar = new Select(driver.findElement(By.id(fotoGalerias.getEditoras().getAttribute("id"))));
		selecionar.selectByVisibleText(opcao);
	}

	@Entao("^devo visualizar (\\d+) fotos por titulo$")
	public void devoVisualizarFotosPorTitulo(int quantidadeFotos) throws Throwable {
		SeleniumRobot.explicitWait(fotoGalerias.getCaroseulFotosUltimade());
		this.fotoGalerias.getListaEdioras().forEach(editoras -> {
			for (int i = 1; i <= quantidadeFotos; i++) {
				WebElement editora = editoras
						.findElement(By.cssSelector("#listaConteudosMobi li:nth-child(" + i + ") > a > img"));
				assertNotNull(editora.getAttribute("src"));
				fotos += 1;
			}
		});
		
		assertTrue(fotos == quantidadeFotos);
	}

	@After
	public void close() {
		driver.quit();
	}
}
