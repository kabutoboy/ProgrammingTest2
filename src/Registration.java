import com.sun.org.apache.bcel.internal.generic.IREM;

import java.util.ArrayList;

public class Registration {
    // Request repository
    private ArrayList<IRequest> requestList;

    public Registration() {
        requestList = new ArrayList<>();
    }

    // Add new course, only request with non-exists studentID/courseID
    // is a valid request. Invalid request will cause an exception
    public void add(IRequest request) {
        int i = 1 + requestList.lastIndexOf(request);
        if (i == 0) {
            requestList.add(request);
            return;
        }
        for (; i < count(); i++) {
            IRequest dropReq = requestList.get(i);
            if (dropReq.isAlmostIdentical(request)) {
                requestList.add(request);
                return;
            }
        }
        throw new RuntimeException("Duplicate request");
    }

    // Drop existing course, only request with existing studentID/courseID
    // is a valid request. Invalid request will cause an exception
    public void drop(IRequest request) {
        int i = 1 + requestList.lastIndexOf(request);
        if (i == 0) {
            requestList.add(request);
            return;
        }
        for (; i < count(); i++) {
            IRequest addReq = requestList.get(i);
            if (addReq.isAlmostIdentical(request)) {
                requestList.add(request);
                return;
            }
        }
        throw new RuntimeException("Duplicate request");
    }

    // Check whether the request is in repository.
    public boolean exists(IRequest request) {
        return requestList.lastIndexOf(request) != -1;
    }

    // Count all requests
    public int count() {
        return requestList.size();
    }

    // Count requests by request type
    public int countByType(int type) {
        int n = 0;
        for (IRequest req : requestList) {
            if (req.getRequestType() == type) {
                n++;
            }
        }
        return n;

    }

    // Count request by course ID
    public int countByCourseID(String courseID) {
        int n = 0;
        for (IRequest req : requestList) {
            if (req.getCourseID().equals(courseID)) {
                n++;
            }
        }
        return n;
    }

    // Count request by student ID
    public int countByStudentID(String studentID) {
        int n = 0;
        for (IRequest req : requestList) {
            if (req.getStudentID().equals(studentID)) {
                n++;
            }
        }
        return n;
    }
}
