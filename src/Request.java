/**
 * Created by pruet on 18/11/2559.
 */
public class Request implements IRequest {

    public static IRequest createRequest(int type, String studentID, String courseID) {
        switch (type) {
            case REQUEST_ADD:
                return AddRequest.createRequest(studentID, courseID);
            case REQUEST_DROP:
                return DropRequest.createRequest(studentID, courseID);
            default:
                throw new RuntimeException("Unrecognized request type");
        }
    }

    protected int requestType;
    protected String studentID;
    protected String courseID;

    protected Request()
    {
        throw new UnsupportedOperationException("Please override this method");
    }

    protected Request(String studentID, String courseID) {
        setStudentID(studentID);
        setCourseID(courseID);
    }

    @Override
    public String getStudentID() {
        return studentID;
    }

    @Override
    public String setStudentID(String studentID) {
        if (null == studentID) {
            throw new RuntimeException("studentID cannot be null");
        }
        if ("".equals(studentID)) {
            throw new RuntimeException("studentID cannot be blank");
        }
        this.studentID = studentID;
        return studentID;
    }

    @Override
    public String getCourseID() {
        return courseID;
    }

    @Override
    public void setCourseID(String courseID) {
        if (null == courseID) {
            throw new RuntimeException("courseID cannot be null");
        }
        if ("".equals(courseID)) {
            throw new RuntimeException("courseID cannot be blank");
        }
        this.courseID = courseID;
    }

    @Override
    public int getRequestType() {
        return requestType;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof IRequest) {
            IRequest req = (IRequest) o;
            return isIdentical(req);
        } else {
            return false;
        }
    }

    @Override
    public boolean isIdentical(IRequest req) {
        return  this.getRequestType() == req.getRequestType()
            &&  this.getCourseID().equals(req.getCourseID())
            &&  this.getStudentID().equals(req.getStudentID());
    }

    @Override
    public boolean isAlmostIdentical(IRequest req) {
        return  this.getCourseID().equals(req.getCourseID())
            &&  this.getStudentID().equals(req.getStudentID());
    }

}
