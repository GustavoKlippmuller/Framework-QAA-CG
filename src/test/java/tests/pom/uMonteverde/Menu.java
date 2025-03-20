    package tests.pom.uMonteverde;

    import framework.base.BasePage;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.interactions.Actions;
    import org.openqa.selenium.support.FindBy;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import tests.uMonteverde.ValidarTablasTest;

    public class Menu extends BasePage {

        @FindBy(linkText = "Llenar Formulario")
        private WebElement llenarFormulario;

        @FindBy(linkText = "Formulario")
        private WebElement formulario;

        @FindBy(linkText = "Elementos")
        private WebElement elementos;

        @FindBy(linkText = "Cerrar sesión")
        private WebElement cerrarSesion;

        @FindBy(linkText = "Buscar Elementos")
        private WebElement buscarElementos;

        @FindBy(linkText = "Validar Tablas")
        private WebElement validarTablas;

        @FindBy(linkText = "Interactuar con Elementos")
        private WebElement InteractuarConElementos;

        public Menu(WebDriver driver) {
            super(driver);
        }

        Actions actions = new Actions(driver);


        public boolean getElementos() {
            wait.until(ExpectedConditions.elementToBeClickable(elementos));
            return elementos.isDisplayed();
        }

        public boolean getBuscarElementos() {
            wait.until(ExpectedConditions.visibilityOf(elementos));
            actions.moveToElement(elementos).perform();
            wait.until(ExpectedConditions.visibilityOf(buscarElementos));
            return buscarElementos.isDisplayed();
        }

        public boolean getInteractuarElementos() {
            wait.until(ExpectedConditions.visibilityOf(elementos));
            actions.moveToElement(elementos).perform();
            wait.until(ExpectedConditions.visibilityOf(InteractuarConElementos));
            return InteractuarConElementos.isDisplayed();
        }


        public boolean getFormulario() {
            wait.until(ExpectedConditions.elementToBeClickable(formulario));
            return formulario.isDisplayed();
        }

        public boolean getllenarFormulario() {
            wait.until(ExpectedConditions.visibilityOf(formulario));
            actions.moveToElement(formulario).perform();
            wait.until(ExpectedConditions.visibilityOf(llenarFormulario));
            return llenarFormulario.isDisplayed();
        }


        public void clickearLlenarFormulario() {
            wait.until(ExpectedConditions.visibilityOf(formulario));
            actions.moveToElement(formulario).perform();
            wait.until(ExpectedConditions.visibilityOf(llenarFormulario));
            llenarFormulario.click();
        }

        public boolean getvalidarTablas() {
            wait.until(ExpectedConditions.visibilityOf(formulario));
            actions.moveToElement(formulario).perform();
            wait.until(ExpectedConditions.visibilityOf(validarTablas));
            return validarTablas.isDisplayed();
        }

        public boolean getCerrarSesion() {
            wait.until(ExpectedConditions.visibilityOf(elementos));
            return cerrarSesion.isDisplayed();
        }

        public void clickearBuscarElementos() {
            wait.until(ExpectedConditions.visibilityOf(elementos));
            actions.moveToElement(elementos).perform();
            wait.until(ExpectedConditions.visibilityOf(buscarElementos));
            buscarElementos.click();
        }


        public void clickearInteractuarConElementos() {
            wait.until(ExpectedConditions.visibilityOf(elementos));
            actions.moveToElement(elementos).perform();
            wait.until(ExpectedConditions.visibilityOf(InteractuarConElementos));
            InteractuarConElementos.click();
        }

        public void clickearValidarTablas(){
            wait.until(ExpectedConditions.visibilityOf(elementos));
            actions.moveToElement(formulario).perform();
            wait.until(ExpectedConditions.visibilityOf(validarTablas));
            validarTablas.click();
        }


    }
