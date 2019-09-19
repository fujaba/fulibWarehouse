package stocktaker.StudyRight;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class Student  
{

   public static final String PROPERTY_name = "name";

   private String name;

   public String getName()
   {
      return name;
   }

   public Student setName(String value)
   {
      if (value == null ? this.name != null : ! value.equals(this.name))
      {
         String oldValue = this.name;
         this.name = value;
         firePropertyChange("name", oldValue, value);
      }
      return this;
   }

   public static final String PROPERTY_studentId = "studentId";

   private String studentId;

   public String getStudentId()
   {
      return studentId;
   }

   public Student setStudentId(String value)
   {
      if (value == null ? this.studentId != null : ! value.equals(this.studentId))
      {
         String oldValue = this.studentId;
         this.studentId = value;
         firePropertyChange("studentId", oldValue, value);
      }
      return this;
   }

   public static final String PROPERTY_uni = "uni";

   private University uni = null;

   public University getUni()
   {
      return this.uni;
   }

   public Student setUni(University value)
   {
      if (this.uni != value)
      {
         University oldValue = this.uni;
         if (this.uni != null)
         {
            this.uni = null;
            oldValue.withoutStudents(this);
         }
         this.uni = value;
         if (value != null)
         {
            value.withStudents(this);
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
      result.append(" ").append(this.getStudentId());


      return result.substring(1);
   }

   public void removeYou()
   {
      this.setUni(null);

   }

}