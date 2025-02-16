package ru.merkurevsergei.easyplanner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.merkurevsergei.easyplanner.model.FeatureEntity;
import ru.merkurevsergei.easyplanner.service.FeatureService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/features")
public class FeatureController {

    private final FeatureService featureService;

    @GetMapping
    public List<FeatureEntity> getAll() {
        return featureService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeatureEntity> getById(@PathVariable UUID id) {
        return featureService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public FeatureEntity create(@RequestBody FeatureEntity feature) {
        return featureService.save(feature);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (featureService.findById(id).isPresent()) {
            featureService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}