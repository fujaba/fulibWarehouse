package stocktaker.StudyRight;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class ModelPattern  
{

   public static final java.util.ArrayList<PatternObject> EMPTY_objects = new java.util.ArrayList<PatternObject>()
   { @Override public boolean add(PatternObject value){ throw new UnsupportedOperationException("No direct add! Use xy.withObjects(obj)"); }};

   public static final String PROPERTY_objects = "objects";

   private java.util.ArrayList<PatternObject> objects = null;

   public java.util.ArrayList<PatternObject> getObjects()
   {
      if (this.objects == null)
      {
         return EMPTY_objects;
      }

      return this.objects;
   }

   public ModelPattern withObjects(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withObjects(i);
            }
         }
         else if (item instanceof PatternObject)
         {
            if (this.objects == null)
            {
               this.objects = new java.util.ArrayList<PatternObject>();
            }
            if ( ! this.objects.contains(item))
            {
               this.objects.add((PatternObject)item);
               firePropertyChange("objects", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }

   public ModelPattern withoutObjects(Object... value)
   {
      if (this.objects == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutObjects(i);
            }
         }
         else if (item instanceof PatternObject)
         {
            if (this.objects.contains(item))
            {
               this.objects.remove((PatternObject)item);
               firePropertyChange("objects", item, null);
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
      this.withoutObjects(this.getObjects().clone());


   }

}