package com.fmellberg.economyapp.savingsgoal;

import com.fmellberg.economyapp.user.User;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "savings_goals")
@EntityListeners(AuditingEntityListener.class)
public class SavingsGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "goal_name", nullable = false)
    private String goalName;

    @Column(name = "current_amount_of_cash", nullable = false)
    private double currentAmountOfCash;

    @Column(name = "target_amount_of_cash", nullable = false)
    private double targetAmountOfCash;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    @CreatedDate
    @Column(name = "createdat")
    private Timestamp createdAt;

    @LastModifiedDate
    @Column(name = "last_modified")
    private Timestamp lastModified;

    public SavingsGoal() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public double getCurrentAmountOfCash() {
        return currentAmountOfCash;
    }

    public void setCurrentAmountOfCash(double currentAmountOfCash) {
        this.currentAmountOfCash = currentAmountOfCash;
    }

    public double getTargetAmountOfCash() {
        return targetAmountOfCash;
    }

    public void setTargetAmountOfCash(double targetAmountOfCash) {
        this.targetAmountOfCash = targetAmountOfCash;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getLastModified() {
        return lastModified;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public String toString() {
        return "SavingGoal{" +
                "id=" + id +
                ", goalName='" + goalName + '\'' +
                ", currentAmountOfCash=" + currentAmountOfCash +
                ", targetAmountOfCash=" + targetAmountOfCash +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", user=" + user +
                ", createdAt=" + createdAt +
                ", updatedAt=" + lastModified +
                '}';
    }
}
