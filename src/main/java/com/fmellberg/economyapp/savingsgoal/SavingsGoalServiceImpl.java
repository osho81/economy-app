package com.fmellberg.economyapp.savingsgoal;

import com.fmellberg.economyapp.exception.ResourceNotFoundException;
import com.fmellberg.economyapp.user.User;
import com.fmellberg.economyapp.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavingsGoalServiceImpl implements SavingsGoalService {

    private static final Logger logger = LoggerFactory.getLogger(SavingsGoalServiceImpl.class);
    private final SavingsGoalRepository savingsGoalRepository;
    private final UserRepository userRepository;

    @Autowired
    public SavingsGoalServiceImpl(SavingsGoalRepository savingsGoalRepository, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.savingsGoalRepository = savingsGoalRepository;
    }

    public SavingsGoalDTO createSavingsGoal(SavingsGoalDTO savingsGoalDTO) {
        Optional<User> user = userRepository.findById(savingsGoalDTO.getUserId());
        SavingsGoal savingsGoal = SavingsGoalMapper.toEntity(savingsGoalDTO, user.get());
        SavingsGoal createdSavingsGoal = savingsGoalRepository.save(savingsGoal);
        logger.info("Savings goal created: {}", createdSavingsGoal);
        return SavingsGoalMapper.toDTO(createdSavingsGoal);
    }

    public List<SavingsGoalDTO> getAllSavingsGoals() {
        List<SavingsGoal> savingsGoals = savingsGoalRepository.findAll();
        logger.info("Total savings goals found: {}", savingsGoals.size());
        List<SavingsGoalDTO> savingsGoalDTOs = SavingsGoalMapper.toDTOList(savingsGoals);
        return savingsGoalDTOs;
    }

    public SavingsGoalDTO getSavingsGoalById(int id) {
        Optional<SavingsGoal> savingsGoal = savingsGoalRepository.findById(id);
        if (savingsGoal.isPresent()) {
            SavingsGoalDTO savingsGoalDTO = SavingsGoalMapper.toDTO(savingsGoal.get());
            return savingsGoalDTO;
        } else {
            logger.error("Savings goal not found with ID: {}", id);
            throw new ResourceNotFoundException("SavingsGoal", "id", id);
        }
    }

    public SavingsGoalDTO updateSavingsGoal(SavingsGoalDTO savingsGoalDTO) {
        Optional<SavingsGoal> existingSavingsGoalOptional = savingsGoalRepository.findById(savingsGoalDTO.getId());
        if (existingSavingsGoalOptional.isPresent()) {
            SavingsGoal existingSavingsGoal = existingSavingsGoalOptional.get();

            existingSavingsGoal.setGoalName(savingsGoalDTO.getGoalName());
            existingSavingsGoal.setCurrentAmountOfCash(savingsGoalDTO.getCurrentAmountOfCash());
            existingSavingsGoal.setTargetAmountOfCash(savingsGoalDTO.getTargetAmountOfCash());
            existingSavingsGoal.setStartDate(savingsGoalDTO.getStartDate());
            existingSavingsGoal.setEndDate(savingsGoalDTO.getEndDate());

            SavingsGoal updatedSavingsGoal = savingsGoalRepository.save(existingSavingsGoal);
            logger.info("Savings goal updated: {}", updatedSavingsGoal);

            return SavingsGoalMapper.toDTO(updatedSavingsGoal);
        } else {
            logger.error("Savings goal not found with ID: {}", savingsGoalDTO.getId());
            throw new ResourceNotFoundException("SavingsGoal", "id", savingsGoalDTO.getId());
        }
    }

    public void deleteSavingsGoal(int id) {
        Optional<SavingsGoal> existingSavingsGoal = savingsGoalRepository.findById(id);
        if (existingSavingsGoal.isPresent()) {
            savingsGoalRepository.deleteById(id);
            logger.info("Savings goal with ID {} deleted", id);
        } else {
            logger.error("Savings goal not found with ID: {}", id);
            throw new ResourceNotFoundException("SavingsGoal", "id", id);
        }
    }
}
