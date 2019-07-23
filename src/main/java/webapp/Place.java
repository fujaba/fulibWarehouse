package webapp;

import java.beans.PropertyChangeSupport;

import java.beans.PropertyChangeListener;

public class Place  
{

   public static final String PROPERTY_name = "name";

   private String name;

   public String getName()
   {
      return name;
   }

   public Place setName(String value)
   {
      if (value == null ? this.name != null : ! value.equals(this.name))
      {
         String oldValue = this.name;
         this.name = value;
         firePropertyChange("name", oldValue, value);
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
      this.setPalette(null);
      this.setArea(null);

   }

   public static final String PROPERTY_palette = "palette";

   private Palette palette = null;

   public Palette getPalette()
   {
      return this.palette;
   }

   public Place setPalette(Palette value)
   {
      if (this.palette != value)
      {
         Palette oldValue = this.palette;
         if (this.palette != null)
         {
            this.palette = null;
            oldValue.setPlace(null);
         }
         this.palette = value;
         if (value != null)
         {
            value.setPlace(this);
         }
         firePropertyChange("palette", oldValue, value);
      }
      return this;
   }

   public static final String PROPERTY_area = "area";

   private Area area = null;

   public Area getArea()
   {
      return this.area;
   }

   public Place setArea(Area value)
   {
      if (this.area != value)
      {
         Area oldValue = this.area;
         if (this.area != null)
         {
            this.area = null;
            oldValue.withoutPlaces(this);
         }
         this.area = value;
         if (value != null)
         {
            value.withPlaces(this);
         }
         firePropertyChange("area", oldValue, value);
      }
      return this;
   }

}