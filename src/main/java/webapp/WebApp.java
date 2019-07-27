package webapp;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class WebApp  
{

   public final Warehouse warehouse;

   public WebApp() {
      warehouse = new Warehouse().init();
   }

   public static final String PROPERTY_id = "id";

   private String id;

   public String getId()
   {
      return id;
   }

   public WebApp setId(String value)
   {
      if (value == null ? this.id != null : ! value.equals(this.id))
      {
         String oldValue = this.id;
         this.id = value;
         firePropertyChange("id", oldValue, value);
      }
      return this;
   }

   protected PropertyChangeSupport listeners = null;

   public boolean firePropertyChange(String propertyName, Object oldValue, Object newValue)
   {
      if (listeners != null)
      {
         listeners.firePropertyChange(propertyName, oldValue, newValue);
         return true;
      }
      return false;
   }

   public boolean addPropertyChangeListener(PropertyChangeListener listener)
   {
      if (listeners == null)
      {
         listeners = new PropertyChangeSupport(this);
      }
      listeners.addPropertyChangeListener(listener);
      return true;
   }

   public boolean addPropertyChangeListener(String propertyName, PropertyChangeListener listener)
   {
      if (listeners == null)
      {
         listeners = new PropertyChangeSupport(this);
      }
      listeners.addPropertyChangeListener(propertyName, listener);
      return true;
   }

   public boolean removePropertyChangeListener(PropertyChangeListener listener)
   {
      if (listeners != null)
      {
         listeners.removePropertyChangeListener(listener);
      }
      return true;
   }

   public boolean removePropertyChangeListener(String propertyName,PropertyChangeListener listener)
   {
      if (listeners != null)
      {
         listeners.removePropertyChangeListener(propertyName, listener);
      }
      return true;
   }

   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();

      result.append(" ").append(this.getId());
      result.append(" ").append(this.getDescription());


      return result.substring(1);
   }

   public static final String PROPERTY_description = "description";

   private String description;

   public String getDescription()
   {
      return description;
   }

   public WebApp setDescription(String value)
   {
      if (value == null ? this.description != null : ! value.equals(this.description))
      {
         String oldValue = this.description;
         this.description = value;
         firePropertyChange("description", oldValue, value);
      }
      return this;
   }

   public static final String PROPERTY_content = "content";

   private Page content;

   public Page getContent()
   {
      return content;
   }

   public WebApp setContent(Page value)
   {
      if (value != this.content)
      {
         Page oldValue = this.content;
         this.content = value;
         firePropertyChange("content", oldValue, value);
      }
      return this;
   }

   public WebApp New_Supply() {
      Content palIn = new Content();
      Content productIn = new Content();
      Content itemsIn = new Content();
      palIn.setId("palIn");
      productIn.setId("productIn");
      itemsIn.setId("itemsIn");
      palIn.setDescription("input palette id?");
      productIn.setDescription("input product?");
      itemsIn.setDescription("input number of items?");
      Content addPaletteButton = new Content();
      addPaletteButton.setId("add-palette-button");
      addPaletteButton.setDescription("button submit");
      addPaletteButton.setAction("addPalette palIn productIn itemsIn Store_Palettes");
      Page addSupplyPage = new Page();
      addSupplyPage.setId("add-supply-page");
      addSupplyPage.setDescription("New_Supply | button Store_Palettes | button Tables");
      addSupplyPage.withContent(palIn, productIn, itemsIn, addPaletteButton);

      this.setContent(addSupplyPage);

      return this;
   }

   public WebApp ask4Place(Palette palIn) {
      Page placePage = new Page()
            .setId("place-page")
            .setDescription("button New_Supply | Store_Palettes | button Tables");

      Content palId = new Content().setId("palId").setDescription(palIn.getId());
      Content productName = new Content().setId("productName").setDescription(palIn.getProduct().getName());
      Content placeIn = new Content().setId("placeIn").setDescription("input place?");
      Content button = new Content().setId("button").setDescription("button OK");
      button.setAction("assignPlace palId placeIn Store_Palettes");

      placePage.withContent(palId, placeIn, button);

      this.setContent(placePage);

      return this;
   }

   public WebApp Place() {
      return this;
   }

   public WebApp assignPlace(Palette palIn, Place placeIn) {
      palIn.setRamp(null);
      palIn.setPlace(placeIn);
      return this;
   }

   public WebApp Store_Palettes() {

      Page storeSupplyPage = new Page()
            .setId("store-supply-page")
            .setDescription("button New_Supply | Store_Palettes | button Tables");

      for (Palette palette : warehouse.getAtRamp())
      {
         Element palId = new Element().setText(palette.getId());
         Element productName = new Element().setText(palette.getProduct().getName());
         Element button = new Element().setText("button Place");
         button.setAction("ask4Place " + palette.getId() + " Place");

         Content content = new Content().setId(palette.getId()).withElements(palId, productName, button);
         storeSupplyPage.withContent(content);
      }

      this.setContent(storeSupplyPage);

      return this;
   }


   public WebApp Tables() {
      Page tablesPage = new Page().setId("tables-page")
            .setDescription("button New_Supply | button Store_Palettes | Tables")
            .withTables(warehouse);

      this.setContent(tablesPage);
      return this;
   }

   public Palette addPalette(Palette palIn, Product productIn, int itemsIn) {
      warehouse.withProducts(productIn);
      palIn.setProduct(productIn);
      palIn.setQuantity(itemsIn);
      warehouse.withAtRamp(palIn);

      return palIn;
   }

   public WebApp init() { // no fulib

      this.setId("fork-lift-guide");
      this.setDescription("Fork Lift Guide");
      this.New_Supply();

      return this;
   }

}