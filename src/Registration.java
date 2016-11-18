import java.util.ArrayList;

public class Registration {
    // Request repository
    private ArrayList<IRequest> requestList;

    // Add new course, only request with non-exists studentID/courseID
    // is a valid request. Invalid request will cause an exception
    public void add(IRequest request) {

    }

    // Drop existing course, only request with existing studentID/courseID
    // is a valid request. Invalid request will cause an exception
    public void drop(IRequest request) {

    }

    // Check whether the request is in repository.
    public boolean exists(IRequest request) {
        return false;
    }

    // Count all requests
    public int count() {
        return 0;
    }

    // Count requests by request type
    public int countByType(int type) {
        int cunt = 0;
        for (IRequest req: requestList) {
            if (req.getRequestType() == type) {
                cunt++;
            }
        }
        return cunt;
    }

    // Count request by course ID
    public int countByCourseID(String courseID) {
        return 0;
    }

    // Count request by student ID
    public int countByStudentID(String studentID) {
        return 0;
    }
}
