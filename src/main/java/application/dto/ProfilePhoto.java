package application.dto;

import java.util.UUID;

public record ProfilePhoto() {
    public domain.models.ProfilePhoto toDomain() {
        return new domain.models.ProfilePhoto(UUID.randomUUID().toString(),
                                null,
                                null);
    }
}
