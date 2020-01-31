CREATE TABLE public.dishes
(
    "Id" integer NOT NULL,
    "DishName" text COLLATE pg_catalog."default" NOT NULL,
    "Price" double precision NOT NULL,
    "Category" text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT dishes_pkey PRIMARY KEY ("Id")
)

TABLESPACE pg_default;

ALTER TABLE public.dishes
    OWNER to postgres;