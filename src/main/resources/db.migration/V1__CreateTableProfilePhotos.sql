CREATE TABLE IF NOT EXISTS profile_photos (
    customer_id VARCHAR(36) NOT NULL,
    id VARCHAR(36) NOT NULL,
    original_photo VARCHAR(200),
    generated_photo VARCHAR(200),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    uptaded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (customer_id, id)
);