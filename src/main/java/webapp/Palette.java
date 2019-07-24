package webapp;

import java.beans.PropertyChangeSupport;

import java.beans.PropertyChangeListener;

public class Palette  
{

   public static final String PROPERTY_id = "id";

   private String id;

   public String getId()
   {
      return id;
   }

   public Palette setId(String value)
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

   public void removeYou()
   {
      this.setProduct(null);
      this.setPlace(null);
      this.setRamp(null);

   }

   public static final String PROPERTY_quantity = "quantity";

   private int quantity;

   public int getQuantity()
   {
      return quantity;
   }

   public Palette setQuantity(int value)
   {
      if (value != this.quantity)
      {
         int oldValue = this.quantity;
         this.quantity = value;
         firePropertyChange("quantity", oldValue, value);
      }
      return this;
   }

   public static final String PROPERTY_product = "product";

   private Product product = null;

   public Product getProduct()
   {
      return this.product;
   }

   public Palette setProduct(Product value)
   {
      if (this.product != value)
      {
         Product oldValue = this.product;
         if (this.product != null)
         {
            this.product = null;
            oldValue.withoutPalettes(this);
         }
         this.product = value;
         if (value != null)
         {
            value.withPalettes(this);
         }
         firePropertyChange("product", oldValue, value);
      }
      return this;
   }

   public static final String PROPERTY_place = "place";

   private Place place = null;

   public Place getPlace()
   {
      return this.place;
   }

   public Palette setPlace(Place value)
   {
      if (this.place != value)
      {
         Place oldValue = this.place;
         if (this.place != null)
         {
            this.place = null;
            oldValue.setPalette(null);
         }
         this.place = value;
         if (value != null)
         {
            value.setPalette(this);
         }
         firePropertyChange("place", oldValue, value);
      }
      return this;
   }

   public static final String PROPERTY_ramp = "ramp";

   private Warehouse ramp = null;

   public Warehouse getRamp()
   {
      return this.ramp;
   }

   public Palette setRamp(Warehouse value)
   {
      if (this.ramp != value)
      {
         Warehouse oldValue = this.ramp;
         if (this.ramp != null)
         {
            this.ramp = null;
            oldValue.withoutAtRamp(this);
         }
         this.ramp = value;
         if (value != null)
         {
            value.withAtRamp(this);
         }
         firePropertyChange("ramp", oldValue, value);
      }
      return this;
   }

   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();

      result.append(" ").append(this.getId());
      result.append(" ").append(this.getItems());


      return result.substring(1);
   }

   public static final String PROPERTY_items = "items";

   private String items;

   public String getItems()
   {
      return items;
   }

   public Palette setItems(String value)
   {
      if (value == null ? this.items != null : ! value.equals(this.items))
      {
         String oldValue = this.items;
         this.items = value;
         firePropertyChange("items", oldValue, value);
      }
      return this;
   }

}