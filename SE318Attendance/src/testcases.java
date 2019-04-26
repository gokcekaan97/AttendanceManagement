import static org.junit.Assert.*;

import org.junit.Test;

public class testcases {
	@Test
	public void test() {
		TeacherScreen ts=new TeacherScreen();
		StudentScreen sc=new StudentScreen();
		assertFalse(ts.TeacherLoggingIn("2", "1111"));
		assertFalse(ts.TeacherLoggingIn("1", "2222"));
		assertFalse(ts.TeacherLoggingIn("2", "1234"));
		assertTrue(ts.TeacherLoggingIn("1","1111"));
		assertTrue(sc.StudentLoggingIn("1", "1111"));
		assertFalse(sc.StudentLoggingIn("2", "1111"));
		assertFalse(sc.StudentLoggingIn("1", "2222"));
		assertFalse(sc.StudentLoggingIn("2", "1234"));
	}

}
