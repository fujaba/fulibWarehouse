package stocktaker;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class Storage  
{

   public static final String PROPERTY_name = "name";

   private String name;

   public String getName()
   {
      return name;
   }

   public Storage setName(String value)
   {
      if (value == null ? this.name != null : ! value.equals(this.name))
      {
         String oldValue = this.name;
         this.name = value;
         firePropertyChange("name", oldValue, value);
      }
      return this;
   }

   public static final java.util.ArrayList<Product> EMPTY_products = new java.util.ArrayList<Product>()
   { @Override public boolean add(Product value){ throw new UnsupportedOperationException("No direct add! Use xy.withProducts(obj)"); }};

   public static final String PROPERTY_products = "products";

   private java.util.ArrayList<Product> products = null;

   public java.util.ArrayList<Product> getProducts()
   {
      if (this.products == null)
      {
         return EMPTY_products;
      }

      return this.products;
   }

   public Storage withProducts(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withProducts(i);
            }
         }
         else if (item instanceof Product)
         {
            if (this.products == null)
            {
               this.products = new java.util.ArrayList<Product>();
            }
            if ( ! this.products.contains(item))
            {
               this.products.add((Product)item);
               ((Product)item).setStore(this);
               firePropertyChange("products", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }

   public Storage withoutProducts(Object... value)
   {
      if (this.products == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutProducts(i);
            }
         }
         else if (item instanceof Product)
         {
            if (this.products.contains(item))
            {
               this.products.remove((Product)item);
               ((Product)item).setStore(null);
               firePropertyChange("products", item, null);
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

   public void removeYou()
   {
      this.withoutBoards(this.getBoards().clone());


      this.withoutProducts(this.getProducts().clone());


   }

   public static final java.util.ArrayList<Board> EMPTY_boards = new java.util.ArrayList<Board>()
   { @Override public boolean add(Board value){ throw new UnsupportedOperationException("No direct add! Use xy.withBoards(obj)"); }};

   public static final String PROPERTY_boards = "boards";

   private java.util.ArrayList<Board> boards = null;

   public java.util.ArrayList<Board> getBoards()
   {
      if (this.boards == null)
      {
         return EMPTY_boards;
      }

      return this.boards;
   }

   public Storage withBoards(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withBoards(i);
            }
         }
         else if (item instanceof Board)
         {
            if (this.boards == null)
            {
               this.boards = new java.util.ArrayList<Board>();
            }
            if ( ! this.boards.contains(item))
            {
               this.boards.add((Board)item);
               ((Board)item).setStore(this);
               firePropertyChange("boards", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }

   public Storage withoutBoards(Object... value)
   {
      if (this.boards == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutBoards(i);
            }
         }
         else if (item instanceof Board)
         {
            if (this.boards.contains(item))
            {
               this.boards.remove((Board)item);
               ((Board)item).setStore(null);
               firePropertyChange("boards", item, null);
            }
         }
      }
      return this;
   }

   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();

      result.append(" ").append(this.getName());


      return result.substring(1);
   }

}