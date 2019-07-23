package webapp;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;
import java.util.stream.Collectors;

public class Warehouse  
{

   public static final java.util.ArrayList<Area> EMPTY_areas = new java.util.ArrayList<Area>()
   { @Override public boolean add(Area value){ throw new UnsupportedOperationException("No direct add! Use xy.withAreas(obj)"); }};

   public static final String PROPERTY_areas = "areas";

   private java.util.ArrayList<Area> areas = null;

   public java.util.ArrayList<Area> getAreas()
   {
      if (this.areas == null)
      {
         return EMPTY_areas;
      }

      return this.areas;
   }

   public Warehouse withAreas(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withAreas(i);
            }
         }
         else if (item instanceof Area)
         {
            if (this.areas == null)
            {
               this.areas = new java.util.ArrayList<Area>();
            }
            if ( ! this.areas.contains(item))
            {
               this.areas.add((Area)item);
               ((Area)item).setWarehouse(this);
               firePropertyChange("areas", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }

   public Warehouse withoutAreas(Object... value)
   {
      if (this.areas == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutAreas(i);
            }
         }
         else if (item instanceof Area)
         {
            if (this.areas.contains(item))
            {
               this.areas.remove((Area)item);
               ((Area)item).setWarehouse(null);
               firePropertyChange("areas", item, null);
            }
         }
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

   public Warehouse withProducts(Object... value)
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
               ((Product)item).setWarehouse(this);
               firePropertyChange("products", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }

   public Warehouse withoutProducts(Object... value)
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
               ((Product)item).setWarehouse(null);
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
      this.withoutAtRamp(this.getAtRamp().clone());


      this.withoutAreas(this.getAreas().clone());


      this.withoutProducts(this.getProducts().clone());


   }

   public void newStock(String newPalId, String newProductName, String newItems) { // no fulib
      Palette newPal = new Palette();
      newPal.setId(newPalId);
      newPal.setItems(newItems);
      Product product = this.findProduct(newProductName);
      newPal.setProduct(product);
      this.withAtRamp(newPal);
   }

   public static final java.util.ArrayList<Palette> EMPTY_atRamp = new java.util.ArrayList<Palette>()
   { @Override public boolean add(Palette value){ throw new UnsupportedOperationException("No direct add! Use xy.withAtRamp(obj)"); }};

   public static final String PROPERTY_atRamp = "atRamp";

   private java.util.ArrayList<Palette> atRamp = null;

   public java.util.ArrayList<Palette> getAtRamp()
   {
      if (this.atRamp == null)
      {
         return EMPTY_atRamp;
      }

      return this.atRamp;
   }

   public Warehouse withAtRamp(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withAtRamp(i);
            }
         }
         else if (item instanceof Palette)
         {
            if (this.atRamp == null)
            {
               this.atRamp = new java.util.ArrayList<Palette>();
            }
            if ( ! this.atRamp.contains(item))
            {
               this.atRamp.add((Palette)item);
               ((Palette)item).setRamp(this);
               firePropertyChange("atRamp", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }

   public Warehouse withoutAtRamp(Object... value)
   {
      if (this.atRamp == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutAtRamp(i);
            }
         }
         else if (item instanceof Palette)
         {
            if (this.atRamp.contains(item))
            {
               this.atRamp.remove((Palette)item);
               ((Palette)item).setRamp(null);
               firePropertyChange("atRamp", item, null);
            }
         }
      }
      return this;
   }

   public Product findProduct(String productName) { 
      for (final Product someProduct : this.getProducts()) {
         if (someProduct.getName().equals(productName)) {
            return someProduct;
         }
      }
      Product newProduct = new Product();
      newProduct.setName(productName);
      return newProduct;
      // --- Action Binding ---
   }

}