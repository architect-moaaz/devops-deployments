






Docker Build

docker run -d -p 5432:5432  --name  dev-postgres -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=admin123 -e  POSTGRES_DB=userdata -e PGDATA=/var/lib/postgresql/data/pgdata      -v /home/ifserveradmn/if-studio/postgres-data:/var/lib/postgresql/data  postgres