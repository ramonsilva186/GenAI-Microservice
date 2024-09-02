package infrastructure.repositories;

import domain.models.ProfilePhoto;
import domain.repositories.ProfilePhotoRepository;
import jakarta.enterprise.context.RequestScoped;
import org.jboss.logging.Logger;

import java.util.Map;

@RequestScoped
public class UnitOfWorkProfilePhotoRepository implements ProfilePhotoRepository {

    private final HibernateProfilePhotoPersistenceRepository persistenceRepository;
    private final S3ProfilePhotoStorageRepository storageRepository;

    public UnitOfWorkProfilePhotoRepository(HibernateProfilePhotoPersistenceRepository persistenceRepository, S3ProfilePhotoStorageRepository storageRepository) {
        this.persistenceRepository = persistenceRepository;
        this.storageRepository = storageRepository;
        this.entities = Map.of();
    }

    private Map<String, ProfilePhoto> entities;

    @Override
    public void registerEntities(Map<String, ProfilePhoto> entities) {
        this.entities = entities;
    }

    @Override
    public void commit() {
        entities.forEach((customerId, profilePhoto) -> {
            persistenceRepository.save(customerId, profilePhoto);
            try {
                var url = storageRepository.store(customerId, profilePhoto).await().indefinitely();
                var updated = new ProfilePhoto(profilePhoto.id(), url, profilePhoto.generatedPhoto());
                persistenceRepository.save(customerId, updated);
            } catch (Exception e) {
                Logger.getLogger(getClass()).error(e);
            }

        });
    }

    @Override
    public void rollback() {

    }
}
