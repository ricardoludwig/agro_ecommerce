	
INSERT INTO public.tb_user (username, email, password, activated)
SELECT * FROM (SELECT 'admin', 'admin@admin.com', '$2a$10$r0RFDmpneBVryx.ihHK9gu6FFJQi4nTxQUqzdSTvrPpaKZMxigqpy', true) AS tmp
WHERE NOT EXISTS (
    SELECT username FROM public.tb_user WHERE username = 'admin'
) LIMIT 1;

INSERT INTO public.tb_user (username, email, password, activated)
SELECT * FROM (SELECT 'jurgen.klinsmann@gmail.com', 'jurgen.klinsmann@gmail.com', '123456', true) AS tmp
WHERE NOT EXISTS (
    SELECT username FROM public.user WHERE username = 'jurgen.klinsmann@gmail.com'
) LIMIT 1;

INSERT INTO public.authority (name)
SELECT * FROM (SELECT 'ROLE_USER') AS tmp
WHERE NOT EXISTS (
    SELECT name FROM public.authority WHERE name = 'ROLE_USER'
) LIMIT 1;

INSERT INTO public.authority (name)
SELECT * FROM (SELECT 'ROLE_ADMIN') AS tmp
WHERE NOT EXISTS (
    SELECT name FROM public.authority WHERE name = 'ROLE_ADMIN'
) LIMIT 1;

INSERT INTO public.user_authority (username, authority)
SELECT * FROM (SELECT 'admin', 'ROLE_USER') AS tmp
WHERE NOT EXISTS (
    SELECT username, authority FROM public.user_authority WHERE username = 'admin' and authority = 'ROLE_USER'
) LIMIT 1;

INSERT INTO public.user_authority (username, authority)
SELECT * FROM (SELECT 'admin', 'ROLE_ADMIN') AS tmp
WHERE NOT EXISTS (
    SELECT username, authority FROM public.user_authority WHERE username = 'admin' and authority = 'ROLE_ADMIN'
) LIMIT 1;

INSERT INTO public.user_authority (username, authority)
SELECT * FROM (SELECT 'jurgen.klinsmann@gmail.com', 'ROLE_USER') AS tmp
WHERE NOT EXISTS (
    SELECT username, authority FROM public.user_authority WHERE username = 'jurgen.klinsmann@gmail.com' and authority = 'ROLE_USER'
) LIMIT 1;

UPDATE public.user
SET password = '$2a$10$T9nlfVp8g2LsrIaEguIjpeeI2Yi7t5s/ma9NmIlj7jUGGNcnPRA5W'
WHERE username = 'jurgen.klinsmann@gmail.com';

