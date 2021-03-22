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
           ,[spogliatoi]
           ,[centroSportivo_email]
           ,[superficie_idSuperficie])
     VALUES
           (0
           ,1
           ,'centro1@mail.it'
           ,1),
		   (0
           ,1
           ,'centro1@mail.it'
           ,1),
		   (1
           ,1
           ,'centro1@mail.it'
           ,2),
		   (1
           ,1
           ,'centro1@mail.it'
           ,2),
		   (1
           ,1
           ,'centro1@mail.it'
           ,3),
		   (1
           ,1
           ,'centro2@mail.it'
           ,3),
		   (1
           ,1
           ,'centro2@mail.it'
           ,4),
		   (1
           ,1
           ,'centro2@mail.it'
           ,5),
		   (1
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

