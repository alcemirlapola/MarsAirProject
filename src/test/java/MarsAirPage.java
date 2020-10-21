import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MarsAirPage{

	@FindBy
	(how = How.ID, using = "content")
	private WebElement mainPageFields;
	
	@FindBy
	(how = How.ID, using = "departing")
	private WebElement dropListDeparting;
	
	@FindBy
	(how = How.ID, using = "returning")
	private WebElement dropListReturning;
	
	@FindBy
	(how = How.XPATH, using = "//*[@id=\"content\"]/form/dl[4]/dd/input")
	private WebElement btnSearch;
	
	@FindBy
	(how = How.ID, using = "promotional_code")
	private WebElement inputPromoCode;

	@FindBy
	(how = How.CLASS_NAME, using = "promo_code")
	private WebElement txtDiscount;
	
	private WebDriver driver;
	
    public MarsAirPage(WebDriver driver) {
    	 this.driver = driver;
    	 PageFactory.initElements(driver, this);
    }
	 public void validaTitulo(String titulo){
		 assertTrue("Título não foi encontrado", mainPageFields.getText().contains(titulo));
	 }
	 
	 public void validaSubtitulo(String subtitulo) {
		 assertTrue("Subtítulo não foi encontrado", mainPageFields.getText().contains(subtitulo));
	 }
	 
	 public void validaCamposPreenchidos(String partida, String volta, String codigoPromocional) {
		 assertTrue("não foi encontrado o texto 'Departing'", mainPageFields.getText().contains(partida));
		 assertTrue("não foi encontrado o texto 'Returning'", mainPageFields.getText().contains(volta));
		 assertTrue("não foi encontrado o texto 'Promotional Code'", mainPageFields.getText().contains(codigoPromocional));
	 }
	 
	public void	selecionaPrimeiraDataIda(){
		Select escolhaMes = new Select(dropListDeparting);
		escolhaMes.selectByVisibleText("July");
	}
	
	public void selecionaPenultimaDataIda(){
		Select escolhaMes = new Select(dropListDeparting);
		escolhaMes.selectByVisibleText("July (two years from now)");
	}
	
	public void selecionaUltimaDataVolta(){
		Select escolhaMes = new Select(dropListReturning);
		escolhaMes.selectByVisibleText("December (two years from now)");
	}
	
	public void clicaBotaoPesquisar() {
		btnSearch.submit();
	}
	
	public void validaMensagemSucesso(String mensagem1, String mensagem2) {
		 assertTrue("Mensagem de sucesso não foi encontrada", mainPageFields.getText().contains(mensagem1));
		 assertTrue("Mensagem de sucesso não foi encontrada", mainPageFields.getText().contains(mensagem2));
	}
	
	public void validaMensagemSucessoCenarioErro(String mensagem) {
		 assertTrue("Mensagem de sucesso não foi encontrada", mainPageFields.getText().contains(mensagem));
	}
	
	public void preenchaCodigoPromocional(String codigoPromocional) {
		inputPromoCode.sendKeys(codigoPromocional);
	}
	
	public void validaMensagemDescontoSucesso(String mensagem1, String mensagem2) {
		assertTrue("Codigo Promocional não está correto. Favor validar", txtDiscount.getText().contains(mensagem1));
		assertTrue("Mensagem final não está correta. Favor validar", txtDiscount.getText().contains(mensagem2));
	}
	
}
