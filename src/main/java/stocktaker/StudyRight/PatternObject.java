package stocktaker.StudyRight;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class PatternObject  
{

   public static final String PROPERTY_name = "name";

   private String name;

   public String getName()
   {
      return name;
   }

   public PatternObject setName(String value)
   {
      if (value == null ? this.name != null : ! value.equals(this.name))
      {
         String oldValue = this.name;
         this.name = value;
         firePropertyChange("name", oldValue, value);
      }
      return this;
   }

   public static final String PROPERTY_students = "students";

   private PatternObject students;

   public PatternObject getStudents()
   {
      return students;
   }

   public PatternObject setStudents(PatternObject value)
   {
      if (value != this.students)
      {
         PatternObject oldValue = this.students;
         this.students = value;
         firePropertyChange("students", oldValue, value);
      }
      return this;
   }

   public static final String PROPERTY_assignments = "assignments";

   private PatternObject assignments;

   public PatternObject getAssignments()
   {
      return assignments;
   }

   public PatternObject setAssignments(PatternObject value)
   {
      if (value != this.assignments)
      {
         PatternObject oldValue = this.assignments;
         this.assignments = value;
         firePropertyChange("assignments", oldValue, value);
      }
      return this;
   }

   public static final String PROPERTY_rooms = "rooms";

   private PatternObject rooms = null;

   public PatternObject getRooms()
   {
      return this.rooms;
   }

   public PatternObject setRooms(PatternObject value)
   {
      if (this.rooms != value)
      {
         PatternObject oldValue = this.rooms;
         if (this.rooms != null)
         {
            this.rooms = null;
            oldValue.setUni(null);
         }
         this.rooms = value;
         if (value != null)
         {
            value.setUni(this);
         }
         firePropertyChange("rooms", oldValue, value);
      }
      return this;
   }

   public static final String PROPERTY_uni = "uni";

   private PatternObject uni = null;

   public PatternObject getUni()
   {
      return this.uni;
   }

   public PatternObject setUni(PatternObject value)
   {
      if (this.uni != value)
      {
         PatternObject oldValue = this.uni;
         if (this.uni != null)
         {
            this.uni = null;
            oldValue.setRooms(null);
         }
         this.uni = value;
         if (value != null)
         {
            value.setRooms(this);
         }
         firePropertyChange("uni", oldValue, value);
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
      this.setRooms(null);
      this.setUni(null);

   }

}