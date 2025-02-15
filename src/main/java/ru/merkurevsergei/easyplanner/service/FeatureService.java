package ru.merkurevsergei.easyplanner.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.merkurevsergei.easyplanner.model.FeatureEntity;
import ru.merkurevsergei.easyplanner.repository.FeatureRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FeatureService {


    private final FeatureRepository featureRepository;

    public List<FeatureEntity> findAll() {
        return featureRepository.findAll();
    }

    public Optional<FeatureEntity> findById(UUID id) {
        return featureRepository.findById(id);
    }

    public FeatureEntity save(FeatureEntity feature) {
        return featureRepository.save(feature);
    }

    public void deleteById(UUID id) {
        featureRepository.deleteById(id);
    }
}