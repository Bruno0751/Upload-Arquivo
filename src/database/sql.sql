CREATE DATABASE db_upload_images;

USE db_upload_images;

CREATE TABLE db_upload_images.arquivos(
id_arquivo INT AUTO_INCREMENT NOT NULL,
arquivo BLOB NULL,
nome TEXT NULL,
data_registro DATE NOT NULL,
hora_registro TIME NOT NULL,
CONSTRAINT pk_id_arquivo PRIMARY KEY(id_arquivo));

SELECT * FROM db_upload_images.arquivos;

describe db_upload_images.arquivos;

DROP TABLE db_upload_images.arquivos;
