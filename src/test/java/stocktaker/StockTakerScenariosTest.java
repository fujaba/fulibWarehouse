package stocktaker;
import org.fulib.FulibTools;
import org.fulib.scenarios.MockupTools;
import org.junit.Test;

public class StockTakerScenariosTest  
{

   @Test
   public void stockTakerForBooks() { 
      // --- Basic elements. ---
      Storage sEStore = new Storage();
      sEStore.setName("SE-Store");
      Product sDMBook = new Product();
      Product javaBook = new Product();
      Product veltinsBottle = new Product();
      sDMBook.setName("SDM book");
      javaBook.setName("Java book");
      veltinsBottle.setName("Veltins bottle");
      sDMBook.setItems(1);
      javaBook.setItems(1);
      veltinsBottle.setItems(24);
      Board b42 = new Board();
      Board b43 = new Board();
      b42.setId("b42");
      b43.setId("b43");
      sEStore.withBoards(b42, b43);
      sEStore.withProducts(sDMBook, javaBook, veltinsBottle);
      b42.withProducts(sDMBook, javaBook);
      b43.withProducts(veltinsBottle);
      FulibTools.objectDiagrams().dumpSVG("C:/Users/zuend/IdeaProjects/fulibWarehouse/src/main/scenarios/stocktaker/objects.svg", sEStore);
      // --- GUI ---
      Content nameIn = new Content();
      Content passIn = new Content();
      nameIn.setId("name-in");
      passIn.setId("pass-in");
      nameIn.setDescription("input name?");
      passIn.setDescription("input password?");
      Content loginButton = new Content();
      loginButton.setId("login-button");
      loginButton.setDescription("button login");
      loginButton.setAction("do-login pal-in product-in items-in Scan");
      Element productCode = new Element();
      Element productName = new Element();
      Element productItems = new Element();
      Element productBoard = new Element();
      Element delButton = new Element();
      productCode.setId("product-code");
      productName.setId("product-name");
      productItems.setId("product-items");
      productBoard.setId("product-board");
      delButton.setId("del-button");
      productCode.setText("book-4004");
      productName.setText("Story Driven Modeling");
      productItems.setText("1");
      productBoard.setText("b-r1-c1");
      delButton.setText("button Del");
      delButton.setAction("del-log-entry");
      Content logLine1 = new Content();
      logLine1.setId("log-line1");
      logLine1.withElements(productCode, productName, productItems, productBoard, delButton);
      Page loginPage = new Page();
      loginPage.setId("login-page");
      loginPage.setDescription("Login | button Scan | button Log");
      loginPage.withContent(nameIn, passIn, loginButton);
      StockApp stockTaker = new StockApp();
      stockTaker.setId("stock-taker");
      stockTaker.setDescription("Stock Taker");
      stockTaker.setContent(loginPage);
      stockTaker.setUser("unknown");
      FulibTools.objectDiagrams().dumpSVG("C:/Users/zuend/IdeaProjects/fulibWarehouse/src/main/scenarios/stocktaker/gui.svg", stockTaker);
      MockupTools.htmlTool().dump("C:/Users/zuend/IdeaProjects/fulibWarehouse/src/main/scenarios/stocktaker/stock01.html", stockTaker);
      nameIn.setValue("Albert");
      MockupTools.htmlTool().dump("C:/Users/zuend/IdeaProjects/fulibWarehouse/src/main/scenarios/stocktaker/stock02.html", stockTaker);
      passIn.setValue("geheim");
      MockupTools.htmlTool().dump("C:/Users/zuend/IdeaProjects/fulibWarehouse/src/main/scenarios/stocktaker/stock03.html", stockTaker);
      sEStore.login(nameIn.getValue(), passIn.getValue());
      FulibTools.objectDiagrams().dumpSVG("C:/Users/zuend/IdeaProjects/fulibWarehouse/src/main/scenarios/stocktaker/user.svg", sEStore);
      stockTaker.setDescription("Albert Stock Taker");
      Page scanPage = new Page();
      scanPage.setId("scan-page");
      scanPage.setDescription("button Login | Scan | button Log");
      Content barcodeIn = new Content();
      barcodeIn.setId("barcode-in");
      barcodeIn.setDescription("input barcode?");
      Content submitButton = new Content();
      submitButton.setId("submit-button");
      submitButton.setDescription("button submit");
      submitButton.setAction("do-scan barcode-in Log");
      scanPage.withContent(barcodeIn, submitButton);
      stockTaker.setContent(scanPage);
      MockupTools.htmlTool().dump("C:/Users/zuend/IdeaProjects/fulibWarehouse/src/main/scenarios/stocktaker/stock04.html", stockTaker);
      MockupTools.htmlTool().dump("C:/Users/zuend/IdeaProjects/fulibWarehouse/src/main/scenarios/stocktaker/stock01-04.mockup.html", stockTaker);
      // --- Controller ---
      stockTaker.setStorage(sEStore);
      // --- Prototype ---
      // --- # builder ---
      Board newBoard = stockTaker.findBoard("b42");
      Product product = stockTaker.findProduct("SDM book");
      Product newProduct = stockTaker.findProduct("DB book");
      FulibTools.objectDiagrams().dumpSVG("C:/Users/zuend/IdeaProjects/fulibWarehouse/src/main/scenarios/stocktaker/find-product.svg", sEStore);
      // --- # gui ---
      stockTaker.login();
      stockTaker.runLogin("Albert", "geheim");
      stockTaker.scan();
      stockTaker.runScan("b45", "RE book", 42);
      FulibTools.objectDiagrams().dumpSVG("C:/Users/zuend/IdeaProjects/fulibWarehouse/src/main/scenarios/stocktaker/run-scan.svg", sEStore);
      stockTaker.log();
      stockTaker.init();
   }

}