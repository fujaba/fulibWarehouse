package SimpleTables;
import org.fulib.FulibTools;
import org.junit.Test;
import org.fulib.scenarios.MockupTools;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleTableTest  
{

   @Test
   public void stockTakerForSimpleTables() { 
      // --- Basic elements. ---
      Storage shop24 = new Storage();
      shop24.setName("Shop24");
      Product sDMBook = new Product();
      Product javaBook = new Product();
      Product veltinsBottle = new Product();
      sDMBook.setName("SDM book");
      javaBook.setName("Java book");
      veltinsBottle.setName("Veltins bottle");
      sDMBook.setItems("1");
      javaBook.setItems("2");
      veltinsBottle.setItems("24");
      Board b42 = new Board();
      Board b43 = new Board();
      b42.setId("b42");
      b43.setId("b43");
      shop24.withBoards(b42, b43);
      shop24.withProducts(sDMBook, javaBook, veltinsBottle);
      b42.withProducts(sDMBook, javaBook);
      b43.withProducts(veltinsBottle);
      FulibTools.objectDiagrams().dumpSVG("C:/Users/zuend/IdeaProjects/fulibWarehouse/src/main/scenarios/SimpleTables/objects.svg", shop24);
      ShopApp shopper = new ShopApp();
      shopper.setId("shopper");
      shopper.setDescription("Shop 24 App");
      Page productsPage = new Page();
      productsPage.setId("products-page");
      productsPage.setDescription("button Login | button Scan | Products");
      shopper.setContent(productsPage);
      Table prodTable = new Table();
      prodTable.setId("prod-table");
      productsPage.setContent(prodTable);
      Column nameCol = new Column();
      nameCol.setId("name-col");
      nameCol.withCells(shop24.getProducts().stream().map(Product::getName).collect(Collectors.toList()));
      Column itemsCol = new Column();
      itemsCol.setId("items-col");
      itemsCol.withCells(shop24.getProducts().stream().map(Product::getItems).collect(Collectors.toList()));
      prodTable.withColumns(nameCol, itemsCol);
      MockupTools.htmlTool().dump("C:/Users/zuend/IdeaProjects/fulibWarehouse/src/main/scenarios/SimpleTables/shopper.html", shopper);
   }

}