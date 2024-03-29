package webapp;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class Page  
{

   public static final String PROPERTY_id = "id";

   private String id;

   public String getId()
   {
      return id;
   }

   public Page setId(String value)
   {
      if (value == null ? this.id != null : ! value.equals(this.id))
      {
         String oldValue = this.id;
         this.id = value;
         firePropertyChange("id", oldValue, value);
      }
      return this;
   }

   public static final String PROPERTY_description = "description";

   private String description;

   public String getDescription()
   {
      return description;
   }

   public Page setDescription(String value)
   {
      if (value == null ? this.description != null : ! value.equals(this.description))
      {
         String oldValue = this.description;
         this.description = value;
         firePropertyChange("description", oldValue, value);
      }
      return this;
   }

   public static final java.util.ArrayList<Content> EMPTY_content = new java.util.ArrayList<Content>()
   { @Override public boolean add(Content value){ throw new UnsupportedOperationException("No direct add! Use xy.withContent(obj)"); }};

   public static final String PROPERTY_content = "content";

   private java.util.ArrayList<Content> content = null;

   public java.util.ArrayList<Content> getContent()
   {
      if (this.content == null)
      {
         return EMPTY_content;
      }

      return this.content;
   }

   public Page withContent(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withContent(i);
            }
         }
         else if (item instanceof Content)
         {
            if (this.content == null)
            {
               this.content = new java.util.ArrayList<Content>();
            }
            if ( ! this.content.contains(item))
            {
               this.content.add((Content)item);
               firePropertyChange("content", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }

   public Page withoutContent(Object... value)
   {
      if (this.content == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutContent(i);
            }
         }
         else if (item instanceof Content)
         {
            if (this.content.contains(item))
            {
               this.content.remove((Content)item);
               firePropertyChange("content", item, null);
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
      result.append(" ").append(this.getDescription());


      return result.substring(1);
   }

   public void removeYou()
   {
      this.withoutTables(this.getTables().clone());


      this.withoutContent(this.getContent().clone());


   }

   public static final java.util.ArrayList<Object> EMPTY_tables = new java.util.ArrayList<Object>()
   { @Override public boolean add(Object value){ throw new UnsupportedOperationException("No direct add! Use xy.withTables(obj)"); }};

   public static final String PROPERTY_tables = "tables";

   private java.util.ArrayList<Object> tables = null;

   public java.util.ArrayList<Object> getTables()
   {
      if (this.tables == null)
      {
         return EMPTY_tables;
      }

      return this.tables;
   }

   public Page withTables(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withTables(i);
            }
         }
         else if (item instanceof Object)
         {
            if (this.tables == null)
            {
               this.tables = new java.util.ArrayList<Object>();
            }
            if ( ! this.tables.contains(item))
            {
               this.tables.add((Object)item);
               firePropertyChange("tables", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }

   public Page withoutTables(Object... value)
   {
      if (this.tables == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutTables(i);
            }
         }
         else if (item instanceof Object)
         {
            if (this.tables.contains(item))
            {
               this.tables.remove((Object)item);
               firePropertyChange("tables", item, null);
            }
         }
      }
      return this;
   }

}