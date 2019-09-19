package stocktaker.StudyRight;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PatternMatchingTest  
{

   @Test
   public void fulibTablesExample() { 
      University studyRight = new University();
      studyRight.setName("Study Right");
      Room math = new Room();
      Room arts = new Room();
      Room football = new Room();
      math.setTopic("math");
      arts.setTopic("arts");
      football.setTopic("football");
      math.setCredits(42.0);
      arts.setCredits(23.0);
      football.setCredits(23.0);
      studyRight.withRooms(math, arts, football);
      Assignment integrals = new Assignment();
      Assignment matrices = new Assignment();
      Assignment drawings = new Assignment();
      Assignment sculptures = new Assignment();
      integrals.setName("integrals");
      matrices.setName("matrices");
      drawings.setName("drawings");
      sculptures.setName("sculptures");
      integrals.setPoints(42);
      matrices.setPoints(23);
      drawings.setPoints(12);
      sculptures.setPoints(12);
      math.withAssignments(integrals, matrices);
      arts.withAssignments(drawings, sculptures);
      Student alice = new Student();
      Student bob = new Student();
      Student carli = new Student();
      alice.setName("Alice");
      bob.setName("Bob");
      carli.setName("Carli");
      alice.setStudentId("m4242");
      bob.setStudentId("m2323");
      carli.setStudentId("m2424");
      studyRight.withStudents(alice, bob, carli);
      ModelPattern modelPattern = new ModelPattern();
      PatternObject uni = new PatternObject();
      PatternObject room = new PatternObject();
      PatternObject student = new PatternObject();
      PatternObject assignment = new PatternObject();
      uni.setName("uni");
      room.setName("room");
      student.setName("student");
      assignment.setName("assignment");
      modelPattern.withObjects(uni, room, student, assignment);
      uni.setRooms(room);
      uni.setStudents(student);
      room.setStudents(student);
      room.setAssignments(assignment);
      // Model-pattern expects that points of assignments is greater than 20.
   }

}