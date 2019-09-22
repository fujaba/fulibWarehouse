package SimpleTables;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class Column  
{

   public static final String PROPERTY_id = "id";

   private String id;

   public String getId()
   {
      return id;
   }

   public Column setId(String value)
   {
      if (value == null ? this.id != null : ! value.equals(this.id))
      {
         String oldValue = this.id;
         this.id = value;
         firePropertyChange("id", oldValue, value);
      }
      return this;
   }

   public static final java.util.ArrayList<String> EMPTY_cells = new java.util.ArrayList<String>()
   { @Override public boolean add(String value){ throw new UnsupportedOperationException("No direct add! Use xy.withCells(obj)"); }};

   public static final String PROPERTY_cells = "cells";

   private java.util.ArrayList<String> cells = null;

   public java.util.ArrayList<String> getCells()
   {
      if (this.cells == null)
      {
         return EMPTY_cells;
      }

      return this.cells;
   }

   public Column withCells(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withCells(i);
            }
         }
         else if (item instanceof String)
         {
            if (this.cells == null)
            {
               this.cells = new java.util.ArrayList<String>();
            }
            if ( ! this.cells.contains(item))
            {
               this.cells.add((String)item);
               firePropertyChange("cells", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }

   public Column withoutCells(Object... value)
   {
      if (this.cells == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutCells(i);
            }
         }
         else if (item instanceof String)
         {
            if (this.cells.contains(item))
            {
               this.cells.remove((String)item);
               firePropertyChange("cells", item, null);
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
      this.withoutCells(this.getCells().clone());


   }

}