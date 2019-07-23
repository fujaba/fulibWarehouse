package webapp;

import java.beans.PropertyChangeSupport;

import java.beans.PropertyChangeListener;

public class Area  
{

   public static final String PROPERTY_name = "name";

   private String name;

   public String getName()
   {
      return name;
   }

   public Area setName(String value)
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
      this.setWarehouse(null);

      this.withoutPlaces(this.getPlaces().clone());


   }

   public static final String PROPERTY_warehouse = "warehouse";

   private Warehouse warehouse = null;

   public Warehouse getWarehouse()
   {
      return this.warehouse;
   }

   public Area setWarehouse(Warehouse value)
   {
      if (this.warehouse != value)
      {
         Warehouse oldValue = this.warehouse;
         if (this.warehouse != null)
         {
            this.warehouse = null;
            oldValue.withoutAreas(this);
         }
         this.warehouse = value;
         if (value != null)
         {
            value.withAreas(this);
         }
         firePropertyChange("warehouse", oldValue, value);
      }
      return this;
   }

   public static final java.util.ArrayList<Place> EMPTY_places = new java.util.ArrayList<Place>()
   { @Override public boolean add(Place value){ throw new UnsupportedOperationException("No direct add! Use xy.withPlaces(obj)"); }};

   public static final String PROPERTY_places = "places";

   private java.util.ArrayList<Place> places = null;

   public java.util.ArrayList<Place> getPlaces()
   {
      if (this.places == null)
      {
         return EMPTY_places;
      }

      return this.places;
   }

   public Area withPlaces(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withPlaces(i);
            }
         }
         else if (item instanceof Place)
         {
            if (this.places == null)
            {
               this.places = new java.util.ArrayList<Place>();
            }
            if ( ! this.places.contains(item))
            {
               this.places.add((Place)item);
               ((Place)item).setArea(this);
               firePropertyChange("places", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }

   public Area withoutPlaces(Object... value)
   {
      if (this.places == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutPlaces(i);
            }
         }
         else if (item instanceof Place)
         {
            if (this.places.contains(item))
            {
               this.places.remove((Place)item);
               ((Place)item).setArea(null);
               firePropertyChange("places", item, null);
            }
         }
      }
      return this;
   }

}