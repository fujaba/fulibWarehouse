package webapp;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class WebApp  
{

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

   public WebApp init() { 
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
      this.setId("fork-lift-guide");
      this.setDescription("Fork Lift Guide");
      this.setContent(addSupplyPage);
      return this;
   }

}