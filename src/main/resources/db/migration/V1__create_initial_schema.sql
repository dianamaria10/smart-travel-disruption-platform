CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       password_hash VARCHAR(255) NOT NULL,
                       full_name VARCHAR(255),
                       role VARCHAR(20) NOT NULL,
                       created_at TIMESTAMP NOT NULL DEFAULT now()
);
CREATE TABLE trips (
                       id BIGSERIAL PRIMARY KEY,
                       user_id BIGINT NOT NULL REFERENCES users(id),
                       title VARCHAR(255),
                       status VARCHAR(20) NOT NULL,
                       created_at TIMESTAMP NOT NULL DEFAULT now()
);
CREATE TABLE segments (
                          id BIGSERIAL PRIMARY KEY,
                          trip_id BIGINT NOT NULL REFERENCES trips(id),
                          sequence_order INT NOT NULL,
                          transport_type VARCHAR(20) NOT NULL,
                          reference_code VARCHAR(50),
                          carrier_name VARCHAR(255),
                          origin VARCHAR(255) NOT NULL,
                          destination VARCHAR(255) NOT NULL,
                          scheduled_departure TIMESTAMP NOT NULL,
                          scheduled_arrival TIMESTAMP NOT NULL,
                          actual_departure TIMESTAMP,
                          actual_arrival TIMESTAMP,
                          status VARCHAR(20) NOT NULL,
                          UNIQUE (trip_id, sequence_order)
);
CREATE TABLE disruption_events (
                                   id BIGSERIAL PRIMARY KEY,
                                   segment_id BIGINT NOT NULL REFERENCES segments(id),
                                   event_type VARCHAR(20) NOT NULL,
                                   delay_minutes INT,
                                   severity VARCHAR(20) NOT NULL,
                                   detected_at TIMESTAMP NOT NULL DEFAULT now(),
                                   description TEXT
);
CREATE TABLE alternative_options (
                                     id BIGSERIAL PRIMARY KEY,
                                     disruption_event_id BIGINT NOT NULL REFERENCES disruption_events(id),
                                     description TEXT NOT NULL,
                                     estimated_cost DECIMAL(10, 2),
                                     estimated_duration_minutes INT,
                                     priority_score INT NOT NULL,
                                     is_selected BOOLEAN NOT NULL DEFAULT false
);
CREATE TABLE notifications (
                               id BIGSERIAL PRIMARY KEY,
                               user_id BIGINT NOT NULL REFERENCES users(id),
                               disruption_event_id BIGINT REFERENCES disruption_events(id),
                               channel VARCHAR(20) NOT NULL,
                               message TEXT NOT NULL,
                               sent_at TIMESTAMP NOT NULL DEFAULT now(),
                               read_at TIMESTAMP
);