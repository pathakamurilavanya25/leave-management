package org.leavemanagementsystem.service;

import org.leavemanagementsystem.entity.LeaveRequest;

import java.util.List;

public interface LeaveService {

    LeaveRequest applyLeave(LeaveRequest request);

    List<LeaveRequest> getAllLeaves();

    LeaveRequest approveLeave(Long id);

    LeaveRequest rejectLeave(Long id, String comment);
}
