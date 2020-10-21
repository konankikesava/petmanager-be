CREATE TABLE agreement(
	id uuid NOT NULL,
    agreement_type varchar(500) NOT NULL, 
    required boolean default false,
	update_time timestamp,
	updator varchar(100),
	create_time timestamp, 
	creator varchar(100),
	delete_time timestamp, 
	deletor varchar(100),
	valid boolean NOT NULL DEFAULT TRUE,
	deleted boolean NOT NULL DEFAULT FALSE,
	version integer NOT NULL,
    CONSTRAINT agreement_pkey PRIMARY KEY (id)
);

CREATE TABLE agreement_lang(
	id uuid NOT NULL,
    language varchar(10) NOT NULL,
    agreement_id UUID NOT NULL,
    content text NOT NULL,
    title varchar(500) NOT NULL,
	update_time timestamp,
	updator varchar(100),
	create_time timestamp, 
	creator varchar(100),
	delete_time timestamp, 
	deletor varchar(100),
	valid boolean NOT NULL DEFAULT TRUE,
	deleted boolean NOT NULL DEFAULT FALSE,
	version integer NOT NULL,
    CONSTRAINT agreement_lang_pkey PRIMARY KEY (id),
    CONSTRAINT agreement_lang_to_agreement FOREIGN KEY (agreement_id)
        REFERENCES agreement (id) ON DELETE CASCADE
);

CREATE TABLE person_agreement(
	id uuid NOT NULL,
    person_id UUID NOT NULL,
    agreement_id UUID NOT NULL,
	update_time timestamp,
	updator varchar(100),
	create_time timestamp, 
	creator varchar(100),
	delete_time timestamp, 
	deletor varchar(100),
	valid boolean NOT NULL DEFAULT TRUE,
	deleted boolean NOT NULL DEFAULT FALSE,
	version integer NOT NULL,
    CONSTRAINT person_agreement_pkey PRIMARY KEY (id),
    CONSTRAINT person_agreement_to_agreement FOREIGN KEY (agreement_id)
        REFERENCES agreement (id) ON DELETE CASCADE,
    CONSTRAINT person_agreement_to_person FOREIGN KEY (person_id)
        REFERENCES person (id) ON DELETE CASCADE
);

CREATE UNIQUE INDEX agreement_unq_idx on agreement (agreement_type) where deleted =false;
CREATE UNIQUE INDEX agreement_lang_unq_idx on agreement_lang (language,agreement_id) where deleted =false; 
