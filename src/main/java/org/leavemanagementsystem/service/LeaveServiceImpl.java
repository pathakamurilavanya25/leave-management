package org.leavemanagementsystem.service;

import org.leavemanagementsystem.entity.LeaveRequest;
import org.leavemanagementsystem.repository.LeaveRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {

    private final LeaveRequestRepository repository;

    public LeaveServiceImpl(LeaveRequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public LeaveRequest applyLeave(LeaveRequest request) {
        request.setStatus("PENDING");
        return repository.save(request);
    }

    @Override
    public List<LeaveRequest> getAllLeaves() {
        return repository.findAll();
    }

    @Override
    public LeaveRequest approveLeave(Long id) {
        LeaveRequest leave = repository.findById(id).orElseThrow();
        leave.setStatus("APPROVED");
        return repository.save(leave);
    }

    @Override
    public LeaveRequest rejectLeave(Long id, String comment) {
        LeaveRequest leave = repository.findById(id).orElseThrow();
        leave.setStatus("REJECTED");
        leave.setManagerComment(comment);
        return repository.save(leave);
    }
}

