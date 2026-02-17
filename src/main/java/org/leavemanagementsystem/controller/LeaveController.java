package org.leavemanagementsystem.controller;

import org.leavemanagementsystem.entity.LeaveRequest;
import org.leavemanagementsystem.service.LeaveService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/leaves")
public class LeaveController {

    private final LeaveService service;

    public LeaveController(LeaveService service) {
        this.service = service;
    }

    @PostMapping("/apply")
    public LeaveRequest applyLeave(@RequestBody LeaveRequest request) {
        return service.applyLeave(request);
    }

    @GetMapping
    public List<LeaveRequest> getAll() {
        return service.getAllLeaves();
    }

    @PutMapping("/{id}/approve")
    public LeaveRequest approve(@PathVariable Long id) {
        return service.approveLeave(id);
    }

    @PutMapping("/{id}/reject")
    public LeaveRequest reject(@PathVariable Long id, @RequestParam String comment) {
        return service.rejectLeave(id, comment);
    }
}

