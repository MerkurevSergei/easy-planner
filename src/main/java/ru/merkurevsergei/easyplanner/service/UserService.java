package ru.merkurevsergei.easyplanner.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.merkurevsergei.easyplanner.model.UserEntity;
import ru.merkurevsergei.easyplanner.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> findById(UUID id) {
        return userRepository.findById(id);
    }

    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }
}