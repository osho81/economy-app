package com.fmellberg.economyapp.savingsgoal;

import com.fmellberg.economyapp.user.User;
import jakarta.persistence.*;

import java.util.Date;

public class SavingsGoalDTO {

    private int id;
    private String goalName;
    private double currentAmountOfCash;
    private double targetAmountOfCash;
    private Date startDate;
    private Date endDate;
    private int userId;

    public SavingsGoalDTO() {
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "SavingsGoalDTO{" +
                "id=" + id +
                ", goalName='" + goalName + '\'' +
                ", currentAmountOfCash=" + currentAmountOfCash +
                ", targetAmountOfCash=" + targetAmountOfCash +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", userId=" + userId +
                '}';
    }
}
