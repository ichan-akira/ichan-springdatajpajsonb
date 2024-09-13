CREATE TABLE IF NOT EXISTS ichan_schema.sample (
    sample_id TEXT NOT NULL,
    sample_name TEXT NOT NULL,
    child_jsons JSONB DEFAULT '[]'::JSONB NULL,
    CONSTRAINT sample_sample_id_pkey PRIMARY KEY (sample_id)
);

CREATE INDEX IF NOT EXISTS sample_sample_name_idx
    ON ichan_schema.sample (sample_name);
