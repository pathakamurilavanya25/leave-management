package org.leavemanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "leave_requests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LeaveRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String leaveType;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String reason;

    private String status;
    private String managerComment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
