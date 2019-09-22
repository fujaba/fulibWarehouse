package SimpleTables;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class Table  
{

   public static final String PROPERTY_id = "id";

   private String id;

   public String getId()
   {
      return id;
   }

   public Table setId(String value)
   {
      if (value == null ? this.id != null : ! value.equals(this.id))
      {
         String oldValue = this.id;
         this.id = value;
         firePropertyChange("id", oldValue, value);
      }
      return this;
   }

   public static final java.util.ArrayList<Column> EMPTY_columns = new java.util.ArrayList<Column>()
   { @Override public boolean add(Column value){ throw new UnsupportedOperationException("No direct add! Use xy.withColumns(obj)"); }};

   public static final String PROPERTY_columns = "columns";

   private java.util.ArrayList<Column> columns = null;

   public java.util.ArrayList<Column> getColumns()
   {
      if (this.columns == null)
      {
         return EMPTY_columns;
      }

      return this.columns;
   }

   public Table withColumns(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withColumns(i);
            }
         }
         else if (item instanceof Column)
         {
            if (this.columns == null)
            {
               this.columns = new java.util.ArrayList<Column>();
            }
            if ( ! this.columns.contains(item))
            {
               this.columns.add((Column)item);
               firePropertyChange("columns", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }

   public Table withoutColumns(Object... value)
   {
      if (this.columns == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutColumns(i);
            }
         }
         else if (item instanceof Column)
         {
            if (this.columns.contains(item))
            {
               this.columns.remove((Column)item);
               firePropertyChange("columns", item, null);
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
      this.withoutColumns(this.getColumns().clone());


   }

}