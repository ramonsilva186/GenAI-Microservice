package domain.services;

import domain.models.ProfilePhoto;
import domain.repositories.ProfilePhotoPersistenceRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProfilePhotoCreateService {

    private final ProfilePhotoPersistenceRepository repository;

    public ProfilePhotoCreateService(ProfilePhotoPersistenceRepository repository) {
        this.repository = repository;
    }

    public void save(String customerId, ProfilePhoto profilePhoto) {
        repository.save(customerId, profilePhoto);
    }
}
