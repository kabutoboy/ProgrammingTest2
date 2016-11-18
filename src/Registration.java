import com.sun.org.apache.bcel.internal.generic.IREM;

import java.util.ArrayList;

public class Registration {
    // Request repository
    private ArrayList<IRequest> requestList;

    // Add new course, only request with non-exists studentID/courseID
    // is a valid request. Invalid request will cause an exception
    public void add(IRequest request){
       if (exists(request) == false){
           requestList.add(request);
       }
    }

    // Drop existing course, only request with existing studentID/courseID
    // is a valid request. Invalid request will cause an exception
    public void drop(IRequest request) {
         if (exists(request) == false){
             requestList.add(request);
         }
         else
             throw new RuntimeException("Invalid Request");

    }

    // Check whether the request is in repository.
    public boolean exists(IRequest request) {
        for (IRequest req: requestList){
            if (req.getCourseID() == request.getCourseID() || req.getStudentID() == request.getStudentID())
                return true;
        }
        return false;
    }

    // Count all requests
    public int count() {
        return requestList.size();
    }

    // Count requests by request type
    public int countByType(int type) {
        int n=0;
        for (IRequest req: requestList)
            if (req.getRequestType() == type)
                n++;
        return n;

    }

    // Count request by course ID
    public int countByCourseID(String courseID) {
        int n=0;
        for (IRequest req: requestList)
            if (req.getCourseID() == courseID)
                n++;
        return n;
    }

    // Count request by student ID
    public int countByStudentID(String studentID) {
        int n=0;
        for (IRequest req: requestList)
            if (req.getStudentID() == studentID)
                n++;
        return n;
    }
}
