
## Paso 1
#Carga de Productos de mock
curl -X 'GET' \
  'http://localhost:9191/registro/product/mock' \
  -H 'accept: */*'




## Customer

CREATE TABLE PT_PRODUCT(
    id_product NUMBER GENERATED BY DEFAULT AS IDENTITY,
    cod_product VARCHAR2(50) NOT NULL,
    name VARCHAR2(50) NOT NULL,
    price NUMBER DEFAULT 0,
    stock NUMBER DEFAULT 0,
    REGISTRATION_DATE DATE DEFAULT SYSDATE,
UPDATE_DATE DATE,
STATUS      VARCHAR(1),

    PRIMARY KEY(id_product),
    CONSTRAINT cod_product_unique UNIQUE (cod_product)
);
--DROP TABLE PT_PRODUCT;
CREATE TABLE PT_store(
    id_store NUMBER GENERATED BY DEFAULT AS IDENTITY,
    cod_store VARCHAR2(50) NOT NULL,
     description VARCHAR2(50) NOT NULL,
    name VARCHAR2(50) NOT NULL,
        REGISTRATION_DATE DATE DEFAULT SYSDATE,
UPDATE_DATE DATE,
STATUS      VARCHAR(1),
    PRIMARY KEY(id_store),
    CONSTRAINT cod_store_unique UNIQUE (cod_store)
);
--DROP TABLE PT_store;
CREATE TABLE PT_warehouse(
    id_warehouse NUMBER GENERATED BY DEFAULT AS IDENTITY,
    id_store_fk NUMBER,
    id_product_fk NUMBER,
        REGISTRATION_DATE DATE DEFAULT SYSDATE,
UPDATE_DATE DATE,
STATUS      VARCHAR(1),
    PRIMARY KEY(id_warehouse),
      CONSTRAINT FK_id_store
    FOREIGN KEY (id_store_fk)
    REFERENCES PT_store(id_store),
          CONSTRAINT FK_id_product
    FOREIGN KEY (id_product_fk)
    REFERENCES PT_PRODUCT(id_product)
    
);
--DROP TABLE PT_warehouse 
CREATE TABLE PT_rules_types(
    id_rule_type NUMBER GENERATED BY DEFAULT AS IDENTITY,
    cod_rule_type VARCHAR2(50) NOT NULL,
    name VARCHAR2(50) NOT NULL,
    description VARCHAR2(50) NOT NULL,
        REGISTRATION_DATE DATE DEFAULT SYSDATE,
UPDATE_DATE DATE,
STATUS      VARCHAR(1),
    PRIMARY KEY(id_rule_type),
        CONSTRAINT cod_rule_type_unique UNIQUE (cod_rule_type)
);

CREATE TABLE PT_rules(
    id_rule NUMBER GENERATED BY DEFAULT AS IDENTITY,
    id_rule_type  NUMBER,
    minimum NUMBER default 0,
    maximum NUMBER default 0,
    action varchar(1),
    addstock number,
    processType varchar(1),
        REGISTRATION_DATE DATE DEFAULT SYSDATE,
UPDATE_DATE DATE,
STATUS      VARCHAR(1),
    PRIMARY KEY(id_rule),
          CONSTRAINT FK_cod_rule_type
    FOREIGN KEY (id_rule_type)
    REFERENCES PT_rules_types(id_rule_type)
    

);
--DROP TABLE PT_rules 

CREATE TABLE PT_clients(
    id_client NUMBER GENERATED BY DEFAULT AS IDENTITY,
    cod_client  VARCHAR2(50) NOT NULL,
    name VARCHAR2(100) NOT NULL,
    photo VARCHAR2(500) NOT NULL,
        REGISTRATION_DATE DATE DEFAULT SYSDATE,
UPDATE_DATE DATE,
STATUS      VARCHAR(1),
    PRIMARY KEY(id_client),
        CONSTRAINT cod_client_UNIQUE UNIQUE (cod_client)
);
--DROP TABLE PT_clients 
CREATE TABLE PT_ORDEN(
    ID_ORDEN NUMBER GENERATED BY DEFAULT AS IDENTITY,
    id_client_FK  NUMBER,
        REGISTRATION_DATE DATE DEFAULT SYSDATE,
UPDATE_DATE DATE,
STATUS      VARCHAR(1),
    PRIMARY KEY(ID_ORDEN),
              CONSTRAINT FK_id_client_FK
    FOREIGN KEY (id_client_FK)
    REFERENCES PT_clients(id_client)
        
);
--DROP TABLE PT_ORDEN 
CREATE TABLE PT_ORDEN_DETAIL(
    ID_ORDEN_DETAIL NUMBER GENERATED BY DEFAULT AS IDENTITY,
    ID_ORDEN_FK  NUMBER,
    id_product_FK NUMBER,
    id_store_FK NUMBER ,
    PRICE NUMBER DEFAULT 0,
    QUANTITY_PRODUCTS NUMBER DEFAULT 0,
        REGISTRATION_DATE DATE DEFAULT SYSDATE,
UPDATE_DATE DATE,
STATUS      VARCHAR(1),
    PRIMARY KEY(ID_ORDEN_DETAIL),
       
    CONSTRAINT FK_ID_ORDEN
    FOREIGN KEY (ID_ORDEN_FK)
    REFERENCES PT_ORDEN(ID_ORDEN),
    
    CONSTRAINT FK_id_product_OD
    FOREIGN KEY (id_product_FK)
    REFERENCES PT_PRODUCT(id_product),
    
    CONSTRAINT FK_store_OD
    FOREIGN KEY (id_store_FK)
    REFERENCES PT_store(id_store)
);

--DROP TABLE PT_ORDEN_DETAIL 



/*

DROP TABLE PT_ORDEN_DETAIL ;
DROP TABLE PT_ORDEN ;
DROP TABLE PT_clients ;
DROP TABLE PT_rules;
DROP TABLE PT_rules_types;
DROP TABLE PT_warehouse;
DROP TABLE PT_store;
DROP TABLE PT_PRODUCT;*/

insert into PT_rules_types (ID_RULE_TYPE, COD_RULE_TYPE, NAME, DESCRIPTION, REGISTRATION_DATE, UPDATE_DATE, STATUS)
values (1, 'pedido_mkt', 'Cantidad de Stock', 'Cantidad de Stock a solicitar.', to_date('22-06-2022', 'dd-mm-yyyy'), null, 'A');
COMMIT;

insert into PT_rules (ID_RULE, ID_RULE_TYPE, MINIMUM, MAXIMUM, ACTION, ADDSTOCK, PROCESSTYPE, REGISTRATION_DATE, UPDATE_DATE, STATUS)
values (1, 1, 0, 5, 'S', 5, 'A', to_date('22-06-2022', 'dd-mm-yyyy'), null, 'A');

insert into PT_rules (ID_RULE, ID_RULE_TYPE, MINIMUM, MAXIMUM, ACTION, ADDSTOCK, PROCESSTYPE, REGISTRATION_DATE, UPDATE_DATE, STATUS)
values (2, 1, 5, 10, 'S', 10, 'A', to_date('22-06-2022', 'dd-mm-yyyy'), null, 'A');

COMMIT;


