	
INSERT INTO public.tb_user (username, password, activated)
SELECT * FROM (SELECT 'admin', '$2a$10$r0RFDmpneBVryx.ihHK9gu6FFJQi4nTxQUqzdSTvrPpaKZMxigqpy', true) AS tmp
WHERE NOT EXISTS (
    SELECT username FROM public.tb_user WHERE username = 'admin'
) LIMIT 1;

