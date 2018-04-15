package br.com.newsletter.oglobo.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FotosGaleriasPage {
	
	@FindBy(className = "carousel")
	private WebElement caroseulFotosUltimade;
	
	@FindBy(id = "normal-popover")
	private WebElement popUp;
	
	@FindBy(id = "onesignal-popover-cancel-button")
	private WebElement opcaoNao;
	
	@FindBy(className = "recommended")
	private WebElement fotosRecomendadas;
	
	@FindBy(className = "popular")
	private List<WebElement> fotosPopular;
	
	@FindBy(id = "selectEditorias")
	private WebElement editoras;
	
	@FindBy(id = "listaConteudosMobi")
	private List<WebElement> listaEdioras;
	
	@FindBy(id = "lastFrom")
	private List<WebElement> ultimasDe;
	
	@FindBy(id = "photoGallery")
	private List<WebElement> galeriaFotos; 
	
	public FotosGaleriasPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getPopUp() {
		return popUp;
	}

	public WebElement getOpcaoNao() {
		return opcaoNao;
	}

	public List<WebElement> getUltimasDe() {
		return ultimasDe;
	}

	public List<WebElement> getGaleriaFotos() {
		return galeriaFotos;
	}

	public List<WebElement> getFotosPopular() {
		return fotosPopular;
	}

	public WebElement getFotosRecomendadas() {
		return fotosRecomendadas;
	}

	public WebElement getEditoras() {
		return editoras;
	}

	public List<WebElement> getListaEdioras() {
		return listaEdioras;
	}

	public WebElement getCaroseulFotosUltimade() {
		return caroseulFotosUltimade;
	}

}
