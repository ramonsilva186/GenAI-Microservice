package infrastructure.repositories.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity(name = "profile_photos")
public class CustomerProfilePhotos {

    @EmbeddedId
    CompositeKey compositeKey;

    @Embeddable
    private class CompositeKey {
        @Column(name = "customer_id")
        String customerId;

        @Column(name = "id")
        String id;

    }
}
