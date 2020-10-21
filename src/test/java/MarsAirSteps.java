import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MarsAirSteps {
	MarsAirPage marsAirPage;

	private WebDriver driver;

	@Given("^que acesso o link \"([^\"]*)\"$")
	public void que_acesso_o_link_https_marsair_thoughtworks_labs_net_alcemirlapola(String link) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://marsair.thoughtworks-labs.net/alcemirlapola");
		PageFactory.initElements(driver, this);
		marsAirPage = new MarsAirPage(driver);
	}

	@Then("^valido o titulo \"([^\"]*)\"$")
	public void valido_o_t_tulo_title_Welcome_do_MarsAir(String titulo) throws Throwable {
		marsAirPage.validaTitulo(titulo);
	}

	@Then("^valido o subtitulo \"([^\"]*)\"$")
	public void valido_o_subt_tulo_Book_a_ticket_to_the_red_planet_now(String subtitulo) throws Throwable {
		marsAirPage.validaSubtitulo(subtitulo);
	}

	@Then("^valido os campos \"([^\"]*)\" e \"([^\"]*)\" e \"([^\"]*)\"$")
	public void valido_os_campos_Departure_e_Return_e_Promotional_Code(String partida, String volta,
			String codigoPromocional) throws Throwable {
		marsAirPage.validaCamposPreenchidos(partida, volta, codigoPromocional);
		driver.quit();
	}
	
	
	@When("^seleciono a data de ida menor que um ano da data de volta$")
	public void seleciono_a_data_de_ida_menor_que_um_ano_da_data_de_volta() throws Throwable {
		marsAirPage.selecionaPrimeiraDataIda();
		marsAirPage.selecionaUltimaDataVolta();
	}
	
	@When("^seleciono a data de ida maior que um ano da data de volta$")
	public void seleciono_a_data_de_ida_maior_que_um_ano_da_data_de_volta() throws Throwable {
		marsAirPage.selecionaPenultimaDataIda();
		marsAirPage.selecionaUltimaDataVolta();

	}

	@When("^clico no botao \"([^\"]*)\"$")
	public void clico_no_bot_o(String pesquisar) throws Throwable {
		marsAirPage.clicaBotaoPesquisar();
	}

	@Then("^a seguinte mensagem deve ser exibida \"([^\"]*)\", \"([^\"]*)\"$")
	public void a_seguinte_mensagem_deve_ser_exibida(String mensagem1, String mensagem2) throws Throwable {
		marsAirPage.validaMensagemSucesso(mensagem1, mensagem2);
		driver.quit();
	}

	@Then("^a seguinte mensagem deve ser exibida \"([^\"]*)\"$")
	public void a_seguinte_mensagem_deve_ser_exibida(String mensagem) throws Throwable {
		marsAirPage.validaMensagemSucessoCenarioErro(mensagem);
		driver.quit();
	}
	
	@When("^preencho um codigo promocional com valor \"([^\"]*)\"$")
	public void preencho_um_c_digo_promocional_com_valor(String codigoPromocional) throws Throwable {
		marsAirPage.preenchaCodigoPromocional(codigoPromocional);
	}
	
	
	@Then("^valido a mensagem de desconto \"([^\"]*)\", \"([^\"]*)\"$")
	public void valido_a_mensagem_de_desconto(String mensagem1, String mensagem2) throws Throwable {
		marsAirPage.validaMensagemDescontoSucesso(mensagem1, mensagem2);
		driver.quit();
	}
}
