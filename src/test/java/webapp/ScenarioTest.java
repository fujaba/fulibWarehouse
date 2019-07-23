package webapp;
import org.fulib.FulibTools;
import org.fulib.scenarios.MockupTools;
import org.junit.Test;

public class ScenarioTest  
{

   @Test
   public void scenarioItalyDeliversShoes() { 
      Warehouse warehouse = new Warehouse();
      Area fastArea = new Area();
      Area middleArea = new Area();
      Area slowArea = new Area();
      fastArea.setName("fast area");
      middleArea.setName("middle area");
      slowArea.setName("slow area");
      warehouse.withAreas(fastArea, middleArea, slowArea);
      Place f1 = new Place();
      Place f2 = new Place();
      Place f3 = new Place();
      Place m1 = new Place();
      Place m2 = new Place();
      Place s1 = new Place();
      f1.setName("f1");
      f2.setName("f2");
      f3.setName("f3");
      m1.setName("m1");
      m2.setName("m2");
      s1.setName("s1");
      fastArea.withPlaces(f1, f2, f3);
      middleArea.withPlaces(m1, m2);
      slowArea.withPlaces(s1);
      FulibTools.objectDiagrams().dumpSVG("C:/Users/zuend/IdeaProjects/fulibWarehouse/src/main/scenarios/webapp/wareHouseAndPlaces.svg", warehouse);
      Producer italy = new Producer();
      italy.setName("Italy");
      Product highHeels = new Product();
      Product nikeAirs = new Product();
      highHeels.setName("High Heels");
      nikeAirs.setName("Nike Airs");
      Palette eu100 = new Palette();
      Palette eu200 = new Palette();
      Palette eu333 = new Palette();
      eu100.setId("eu100");
      eu200.setId("eu200");
      eu333.setId("eu333");
      eu100.setQuantity(100);
      eu200.setQuantity(150);
      eu333.setQuantity(150);
      highHeels.withPalettes(eu200, eu333);
      nikeAirs.withPalettes(eu100);
      warehouse.withProducts(highHeels, nikeAirs);
      f2.setPalette(eu100);
      Arrival mondayArrival = new Arrival();
      mondayArrival.setId("mondayArrival");
      mondayArrival.withPalettes(eu100, eu200, eu333);
      mondayArrival.setProducer(italy);
      warehouse.withAtRamp(eu200, eu333);
      FulibTools.objectDiagrams().dumpSVG("C:/Users/zuend/IdeaProjects/fulibWarehouse/src/main/scenarios/webapp/Arrival.svg", mondayArrival);
      // --- GUI ---
      Content palIn = new Content();
      Content productIn = new Content();
      Content itemsIn = new Content();
      palIn.setId("pal-in");
      productIn.setId("product-in");
      itemsIn.setId("items-in");
      palIn.setDescription("input palette id?");
      productIn.setDescription("input product?");
      itemsIn.setDescription("input number of items?");
      Content addPaletteButton = new Content();
      addPaletteButton.setId("add-palette-button");
      addPaletteButton.setDescription("button submit");
      Page addSupplyPage = new Page();
      addSupplyPage.setId("add-supply-page");
      addSupplyPage.setDescription("New Supply | button Store Palettes");
      addSupplyPage.withContent(palIn, productIn, itemsIn, addPaletteButton);
      WebApp forkLiftGuide = new WebApp();
      forkLiftGuide.setId("fork-lift-guide");
      forkLiftGuide.setDescription("Fork Lift Guide");
      forkLiftGuide.setContent(addSupplyPage);
      WebApp firstScreen = new WebApp();
      firstScreen.setId("first-screen");
      WebApp firstScreen1 = firstScreen.init();
      MockupTools.htmlTool().dump("C:/Users/zuend/IdeaProjects/fulibWarehouse/src/main/scenarios/webapp/step03.html", forkLiftGuide);
      palIn.setValue("eu500");
      MockupTools.htmlTool().dump("C:/Users/zuend/IdeaProjects/fulibWarehouse/src/main/scenarios/webapp/step04.html", forkLiftGuide);
      productIn.setValue("Sneakers");
      MockupTools.htmlTool().dump("C:/Users/zuend/IdeaProjects/fulibWarehouse/src/main/scenarios/webapp/step05.html", forkLiftGuide);
      itemsIn.setValue("50");
      MockupTools.htmlTool().dump("C:/Users/zuend/IdeaProjects/fulibWarehouse/src/main/scenarios/webapp/step06.html", forkLiftGuide);
      // --- Operations ---
      Product result = warehouse.findProduct(productIn.getValue());
      warehouse.newStock(palIn.getValue(), productIn.getValue(), itemsIn.getValue());
      MockupTools.htmlTool().dump("C:/Users/zuend/IdeaProjects/fulibWarehouse/src/main/scenarios/webapp/step03-07.mockup.html", forkLiftGuide);
      MockupTools.htmlTool().dump("C:/Users/zuend/IdeaProjects/fulibWarehouse/src/main/scenarios/webapp/Tables.tables.html", warehouse);
      FulibTools.objectDiagrams().dumpYaml("C:/Users/zuend/IdeaProjects/fulibWarehouse/src/main/scenarios/webapp/Overview.yaml", warehouse);
   }

}