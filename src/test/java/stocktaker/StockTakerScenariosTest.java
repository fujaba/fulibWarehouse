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
      Product book4004 = new Product();
      Product book5005 = new Product();
      Product beer1 = new Product();
      book4004.setId("book-4004");
      book5005.setId("book-5005");
      beer1.setId("beer-1");
      book4004.setName("Story Driven Modeling");
      book5005.setName("Java is also an Island");
      beer1.setName("Veltins");
      book4004.setItems(1);
      book5005.setItems(1);
      beer1.setItems(24);
      Board bR1C1 = new Board();
      Board bR1C2 = new Board();
      bR1C1.setId("b-r1-c1");
      bR1C2.setId("b-r1-c2");
      sEStore.withBoards(bR1C1, bR1C2);
      sEStore.withProducts(book4004, book5005, beer1);
      bR1C1.withProducts(book4004, book5005);
      bR1C2.withProducts(beer1);
      Person xavier = new Person().setJob("hiwi");
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
      MockupTools.htmlTool().dump("C:/Users/zuend/IdeaProjects/fulibWarehouse/src/main/scenarios/stocktaker/stock01.html", stockTaker);
      // --- Controller ---
      stockTaker.setStorage(sEStore);
      // --- Prototype ---
      // --- # builder ---
      Board newBoard = stockTaker.findBoard("b-r1-c1");
      // --- # gui ---
      stockTaker.login();
      stockTaker.runLogin("Albert", "geheim");
      stockTaker.scan();
      stockTaker.runScan("f1", "p1", 42);
      stockTaker.init();
   }

}