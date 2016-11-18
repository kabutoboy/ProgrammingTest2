public class DropRequest extends Request {

    public static IRequest createRequest(int type, String studentID, String courseID) {
        throw new UnsupportedOperationException("Use Request.createRequest instead");
    }

    public static DropRequest createRequest(String studentID, String courseID) {
        return new DropRequest(studentID, courseID);
    }

    private DropRequest(String studentID, String courseID) {
        super(studentID, courseID);
        requestType = Request.REQUEST_DROP;
    }

}
