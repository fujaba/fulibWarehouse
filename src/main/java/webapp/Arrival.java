package webapp;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class Arrival  
{

   public static final String PROPERTY_id = "id";

   private String id;

   public String getId()
   {
      return id;
   }

   public Arrival setId(String value)
   {
      if (value == null ? this.id != null : ! value.equals(this.id))
      {
         String oldValue = this.id;
         this.id = value;
         firePropertyChange("id", oldValue, value);
      }
      return this;
   }

   public static final String PROPERTY_producer = "producer";

   private Producer producer;

   public Producer getProducer()
   {
      return producer;
   }

   public Arrival setProducer(Producer value)
   {
      if (value != this.producer)
      {
         Producer oldValue = this.producer;
         this.producer = value;
         firePropertyChange("producer", oldValue, value);
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

   public Arrival withPalettes(Object... value)
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
               firePropertyChange("palettes", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }

   public Arrival withoutPalettes(Object... value)
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
               firePropertyChange("palettes", item, null);
            }
         }
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


      return result.substring(1);
   }

   public void removeYou()
   {
      this.withoutPalettes(this.getPalettes().clone());


   }

}