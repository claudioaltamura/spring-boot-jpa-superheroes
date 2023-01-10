SELECT 'CREATE DATABASE superheroes'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'superheroes')\gexec