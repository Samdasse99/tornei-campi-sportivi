USE [sportshub-jpa]
GO

INSERT INTO [dbo].[Sport]
           ([nomeSport])
     VALUES
           ('Calcio a 11'),
		   ('Calcio a 7'),
		   ('Calcio a 5'),
		   ('Pallacanestro'),
		   ('Pallavolo'),
		   ('Tennis')
GO

INSERT INTO [dbo].[Superficie]
           ([materiale])
     VALUES
           ('erba'),
		   ('erba sintetica'),
		   ('pvc'),
		   ('parquet'),
		   ('cemento')
GO

INSERT INTO [dbo].[CentroSportivo]
           ([email]
           ,[citta]
           ,[indirizzo]
           ,[nomeCentro]
           ,[numTelefono]
           ,[pIva]
           ,[sogliaCoupon])
     VALUES
           ('centro1@mail.it'
           ,'Milano'
           ,'Via Verdi 10'
           ,'Primo centro sportivo'
           ,'444444444'
           ,'101010111111121212'
		   , null),
		   ('centro2@mail.it'
           ,'Milano'
           ,'Via Garibaldi 20'
           ,'Secondo centro sportivo'
           ,'555555555'
           ,'202020212121222222'
		   , null)
GO

INSERT INTO [dbo].[Campo]
           ([coperto]
           ,[nomeCampo]
           ,[spogliatoi]
           ,[centroSportivo_email]
           ,[superficie_idSuperficie])
     VALUES
           (0
		   ,'Campo Platini'
           ,1
           ,'centro1@mail.it'
           ,1),
		   (0
		   ,'Campo Ronaldo'
           ,1
           ,'centro1@mail.it'
           ,1),
		   (1
		   ,'Campo Totti'
           ,1
           ,'centro1@mail.it'
           ,2),
		   (1
		   ,'Campo Ronaldinho'
           ,1
           ,'centro1@mail.it'
           ,2),
		   (1
		   ,'Campo polivalente'
           ,1
           ,'centro1@mail.it'
           ,3),
		   (1
		   ,'Campo ASD futsal'
           ,1
           ,'centro2@mail.it'
           ,3),
		   (1
		   ,'Campo Bryant'
           ,1
           ,'centro2@mail.it'
           ,4),
		   (1
		   ,'Campo Federer'
           ,1
           ,'centro2@mail.it'
           ,5),
		   (1
		   ,'Campo Nadal'
           ,1
           ,'centro2@mail.it'
           ,5)
GO

INSERT INTO [dbo].[Campo_Sport]
           ([campi_idCampo]
           ,[sports_idSport])
     VALUES
           (1, 1),
		   (2, 2),
		   (3, 3),
		   (4, 3),
		   (5, 4),
		   (5, 5),
		   (6, 3),
		   (7, 4),
		   (8, 6),
		   (9, 6)
GO

