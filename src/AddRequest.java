public class AddRequest extends Request {

    public static IRequest createRequest(int type, String studentID, String courseID) {
        throw new UnsupportedOperationException("Use Request.createRequest instead");
    }

    public static AddRequest createRequest(String studentID, String courseID) {
        return new AddRequest(studentID, courseID);
    }

    private AddRequest(String studentID, String courseID) {
        super(studentID, courseID);
        requestType = Request.REQUEST_ADD;
    }

}

