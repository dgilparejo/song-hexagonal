FROM postgres:16-alpine

ENV POSTGRES_USER=postgres \
    POSTGRES_PASSWORD=postgres \
    POSTGRES_DB=appdb

HEALTHCHECK --interval=10s --timeout=5s --retries=5 CMD pg_isready -U "$POSTGRES_USER" -d "$POSTGRES_DB" || exit 1