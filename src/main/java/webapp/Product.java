package webapp;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class Product  
{

   public static final String PROPERTY_name = "name";

   private String name;

   public String getName()
   {
      return name;
   }

   public Product setName(String value)
   {
      if (value == null ? this.name != null : ! value.equals(this.name))
      {
         String oldValue = this.name;
         this.name = value;
         firePropertyChange("name", oldValue, value);
      }
      return this;
   }

   public static final java.util.ArrayList<Palette> EMPTY_palettes = new java.util.ArrayList<Palette>()
   { @Override public boolean add(Palette value){ throw new UnsupportedOperationException("No direct add! Use xy.withPalettes(obj)"); }};

   public static final String PROPERTY_palettes = "palettes";

   private java.util.ArrayList<Palette> palettes = null;

   public java.util.ArrayList<Palette> getPalettes()
   {
      if (this.palettes == null)
      {
         return EMPTY_palettes;
      }

      return this.palettes;
   }

   public Product withPalettes(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withPalettes(i);
            }
         }
         else if (item instanceof Palette)
         {
            if (this.palettes == null)
            {
               this.palettes = new java.util.ArrayList<Palette>();
            }
            if ( ! this.palettes.contains(item))
            {
               this.palettes.add((Palette)item);
               ((Palette)item).setProduct(this);
               firePropertyChange("palettes", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }

   public Product withoutPalettes(Object... value)
   {
      if (this.palettes == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutPalettes(i);
            }
         }
         else if (item instanceof Palette)
         {
            if (this.palettes.contains(item))
            {
               this.palettes.remove((Palette)item);
               ((Palette)item).setProduct(null);
               firePropertyChange("palettes", item, null);
            }
         }
      }
      return this;
   }

   public static final String PROPERTY_warehouse = "warehouse";

   private Warehouse warehouse = null;

   public Warehouse getWarehouse()
   {
      return this.warehouse;
   }

   public Product setWarehouse(Warehouse value)
   {
      if (this.warehouse != value)
      {
         Warehouse oldValue = this.warehouse;
         if (this.warehouse != null)
         {
            this.warehouse = null;
            oldValue.withoutProducts(this);
         }
         this.warehouse = value;
         if (value != null)
         {
            value.withProducts(this);
         }
         firePropertyChange("warehouse", oldValue, value);
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

      result.append(" ").append(this.getName());


      return result.substring(1);
   }

   public void removeYou()
   {
      this.setWarehouse(null);

      this.withoutPalettes(this.getPalettes().clone());


   }

}