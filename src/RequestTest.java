import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by aum on 11/18/16.
 */

public class RequestTest {
    protected AddRequest addReq;
    protected DropRequest dropReq;

    @Before
    public void setUp() throws Exception {
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testNewRequest() {
        exception.expect(UnsupportedOperationException.class);
        new Request();
    }

    @Test
    public void testAddRequestWithBlankParams() {
        exception.expect(RuntimeException.class);
        IRequest req = Request.createRequest(Request.REQUEST_ADD, "", "");
        assertEquals(Request.REQUEST_ADD, req.getRequestType());
        assertEquals("", req.getStudentID());
        assertEquals("", req.getCourseID());
    }

    @Test
    public void testAddRequestWithParams() {
        String studentID = "testStudentID";
        String courseID = "testCourseID";
        IRequest req = Request.createRequest(Request.REQUEST_ADD, studentID, courseID);
        assertEquals(Request.REQUEST_ADD, req.getRequestType());
        assertEquals(studentID, req.getStudentID());
        assertEquals(courseID, req.getCourseID());
    }

    @Test
    public void testAddRequestWithNullStudentID() {
        exception.expect(RuntimeException.class);
        IRequest req = Request.createRequest(Request.REQUEST_ADD, null, "");
    }

    @Test
    public void testAddRequestWithNullCourseID() {
        exception.expect(RuntimeException.class);
        IRequest req = Request.createRequest(Request.REQUEST_ADD, "", null);
    }

    @Test
    public void testDropRequestWithBlankParams() {
        exception.expect(RuntimeException.class);
        IRequest req = Request.createRequest(Request.REQUEST_DROP, "", "");
        assertEquals(Request.REQUEST_DROP, req.getRequestType());
        assertEquals("", req.getStudentID());
        assertEquals("", req.getCourseID());
    }

    @Test
    public void testDropRequestWithParams() {
        String studentID = "testStudentID";
        String courseID = "testCourseID";
        IRequest req = Request.createRequest(Request.REQUEST_DROP, studentID, courseID);
        assertEquals(Request.REQUEST_DROP, req.getRequestType());
        assertEquals(studentID, req.getStudentID());
        assertEquals(courseID, req.getCourseID());
    }

    @Test
    public void testDropRequestWithNullStudentID() {
        exception.expect(RuntimeException.class);
        IRequest req = Request.createRequest(Request.REQUEST_DROP, null, "");
    }

    @Test
    public void testDropRequestWithNullCourseID() {
        exception.expect(RuntimeException.class);
        IRequest req = Request.createRequest(Request.REQUEST_DROP, "", null);
    }

}
