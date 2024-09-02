package infrastructure.repositories;

import domain.models.ProfilePhoto;
import domain.repositories.ProfilePhotoPersistenceRepository;
import infrastructure.repositories.entities.CustomerProfilePhotos;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class HibernateProfilePhotoPersistenceRepository implements ProfilePhotoPersistenceRepository {

    private final EntityManager entityManager;

    public HibernateProfilePhotoPersistenceRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(String custumerId, ProfilePhoto profilePhoto) {
        entityManager.merge(CustomerProfilePhotos.fromDomain(custumerId, profilePhoto));
    }
}
