package com.fmellberg.economyapp.savingsgoal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/saving-goals")
public class SavingsGoalController {

    private static final Logger logger = LoggerFactory.getLogger(SavingsGoalController.class);
    private final SavingsGoalService savingsGoalService;

    @Autowired
    public SavingsGoalController(SavingsGoalService savingsGoalService) {
        this.savingsGoalService = savingsGoalService;
    }

    @PostMapping
    public ResponseEntity<SavingsGoalDTO> createSavingsGoal(@RequestBody SavingsGoalDTO savingsGoalDTO) {
        logger.info("Received request to create a new savings goal: {}", savingsGoalDTO);
        SavingsGoalDTO createdSavingsGoal = savingsGoalService.createSavingsGoal(savingsGoalDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSavingsGoal);
    }

    @GetMapping
    public ResponseEntity<List<SavingsGoalDTO>> getAllSavingsGoals() {
        logger.info("Received request to retrieve all savings goals");
        List<SavingsGoalDTO> savingsGoalDTOs = savingsGoalService.getAllSavingsGoals();
        return ResponseEntity.ok(savingsGoalDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SavingsGoalDTO> getSavingsGoalById(@PathVariable int id) {
        logger.info("Received request to retrieve savings goal with ID: {}", id);
        SavingsGoalDTO savingsGoalDTO = savingsGoalService.getSavingsGoalById(id);
        return ResponseEntity.ok(savingsGoalDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SavingsGoalDTO> updateSavingsGoal(@PathVariable int id, @RequestBody SavingsGoalDTO savingsGoalDTO) {
        logger.info("Received request to update savings goal with ID: {}", id);
        savingsGoalDTO.setId(id);
        SavingsGoalDTO updatedSavingsGoal = savingsGoalService.updateSavingsGoal(savingsGoalDTO);
        return ResponseEntity.ok(updatedSavingsGoal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSavingsGoal(@PathVariable int id) {
        logger.info("Received request to delete savings goal with ID: {}", id);
        savingsGoalService.deleteSavingsGoal(id);
        return ResponseEntity.noContent().build();
    }
}
