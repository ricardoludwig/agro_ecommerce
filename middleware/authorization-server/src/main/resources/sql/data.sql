	
DELETE FROM public.oauth_client_details;

INSERT INTO public.user_authority (username, authority)
SELECT * FROM (SELECT 'admin@teste.com.br', 'ROLE_USER, ROLE_ADMIN') AS tmp
WHERE NOT EXISTS (
    SELECT username, authority FROM public.user_authority WHERE username = 'admin@teste.com.br'
) LIMIT 1;

INSERT INTO public.user_authority (username, authority)
SELECT * FROM (SELECT 'jurgen.klinsmann@gmail.com', 'ROLE_USER') AS tmp
WHERE NOT EXISTS (
    SELECT username, authority FROM public.user_authority WHERE username = 'jurgen.klinsmann@gmail.com'
) LIMIT 1;



