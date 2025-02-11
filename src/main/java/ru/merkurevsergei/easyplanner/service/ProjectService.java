package ru.merkurevsergei.easyplanner.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.merkurevsergei.easyplanner.model.ProjectEntity;
import ru.merkurevsergei.easyplanner.repository.ProjectRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectEntity createProject(ProjectEntity projectEntity) {
        return projectRepository.save(projectEntity);
    }

    public Optional<ProjectEntity> getProjectById(UUID projectId) {
        return projectRepository.findById(projectId);
    }

    public List<ProjectEntity> getAllProjects() {
        return projectRepository.findAll();
    }

    public ProjectEntity updateProject(UUID projectId, ProjectEntity updatedProjectEntity) {
        if (projectRepository.existsById(projectId)) {
            //updatedProject.setId(projectId);
            return projectRepository.save(updatedProjectEntity);
        }
        return null;
    }

    public boolean deleteProject(UUID projectId) {
        if (projectRepository.existsById(projectId)) {
            projectRepository.deleteById(projectId);
            return true;
        }
        return false;
    }
}

