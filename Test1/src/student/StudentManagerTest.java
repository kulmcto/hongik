package student;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentManagerTest {
	
	StudentManager manager;

	@BeforeEach
	void setUp() throws Exception {
		manager = new StudentManager();	
		manager.addStudent("김철수");
		manager.addStudent("이영희");
	}

	@Test
	void testAddStudent() {
		manager.addStudent("홍길동");
		assertTrue(manager.hasStudent("홍길동"));
	}
	
	@Test
	void testRemoveStudent() {
		manager.removeStudent("김철수");
		assertFalse(manager.hasStudent("김철수"));
	}
	
	@Test
	void testExceptionAdd() {
		assertThrows(IllegalArgumentException.class, () -> {
			manager.addStudent("이영희");
		});
	}
	
	@Test
	void testExceptionRemove() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			manager.removeStudent("박창희");
		
		});
		System.out.println(e.getMessage());
	}

}
