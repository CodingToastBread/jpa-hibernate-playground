/**
  YOU CAN'T USE THIS FILE AS jakarta.persistence.schema-generation.create-script-source!!!
  you must manually execute this query.
 */

/* drop all table in jpa schema */
DO $$
DECLARE
    r record;
BEGIN
    FOR r IN SELECT quote_ident(tablename) AS tablename, quote_ident(schemaname) AS schemaname FROM pg_tables WHERE schemaname = 'jpa'
        LOOP
            RAISE INFO 'Dropping table %.%', r.schemaname, r.tablename;
            EXECUTE format('DROP TABLE IF EXISTS %I.%I CASCADE', r.schemaname, r.tablename);
        END LOOP;
END$$;


/* drop all sequence in jpa schema */
DO $$
DECLARE
    r record;
BEGIN
    FOR r IN select quote_ident(schemaname) AS schemaname, quote_ident(sequencename) as sequencename from pg_sequences where schemaname = 'jpa'
        LOOP
            RAISE INFO 'Dropping table %.%', r.schemaname, r.sequencename;
            EXECUTE format('DROP SEQUENCE IF EXISTS %I.%I CASCADE', r.schemaname, r.sequencename);
        END LOOP;
END$$;



