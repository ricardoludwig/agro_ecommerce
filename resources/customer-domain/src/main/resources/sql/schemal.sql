
	
CREATE TABLE CUSTOMER (
	id SERIAL PRIMARY KEY,
	name VARCHAR(250),
	login VARCHAR(250),
	email VARCHAR(250),
	document VARCHAR(250),
	phones VARCHAR(250),
	credit_cards VARCHAR(250),
	disable BOOLEAN
)

 GRANT ALL PRIVILEGES ON TABLE customer TO lud;
 GRANT USAGE, SELECT ON SEQUENCE customer_id_seq TO lud;
	
	